diff --git a/src/protocol/http/org/apache/jmeter/protocol/http/sampler/SoapSampler.java b/src/protocol/http/org/apache/jmeter/protocol/http/sampler/SoapSampler.java
deleted file mode 100644
index 4c2ab4e65..000000000
--- a/src/protocol/http/org/apache/jmeter/protocol/http/sampler/SoapSampler.java
+++ /dev/null
@@ -1,371 +0,0 @@
-/*
- * Licensed to the Apache Software Foundation (ASF) under one or more
- * contributor license agreements.  See the NOTICE file distributed with
- * this work for additional information regarding copyright ownership.
- * The ASF licenses this file to You under the Apache License, Version 2.0
- * (the "License"); you may not use this file except in compliance with
- * the License.  You may obtain a copy of the License at
- *
- *   http://www.apache.org/licenses/LICENSE-2.0
- *
- * Unless required by applicable law or agreed to in writing, software
- * distributed under the License is distributed on an "AS IS" BASIS,
- * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
- * See the License for the specific language governing permissions and
- * limitations under the License.
- *
- */
-
-package org.apache.jmeter.protocol.http.sampler;
-
-import java.io.BufferedInputStream;
-import java.io.ByteArrayOutputStream;
-import java.io.File;
-import java.io.FileInputStream;
-import java.io.IOException;
-import java.io.InputStream;
-import java.io.OutputStream;
-import java.io.UnsupportedEncodingException;
-import java.net.MalformedURLException;
-import java.net.URL;
-import java.util.zip.GZIPInputStream;
-
-import org.apache.commons.httpclient.HttpClient;
-import org.apache.commons.httpclient.methods.PostMethod;
-import org.apache.commons.httpclient.methods.RequestEntity;
-import org.apache.commons.io.IOUtils;
-import org.apache.jmeter.protocol.http.control.CacheManager;
-import org.apache.jmeter.protocol.http.control.Header;
-import org.apache.jmeter.protocol.http.control.HeaderManager;
-import org.apache.jmeter.protocol.http.util.HTTPConstants;
-import org.apache.jmeter.samplers.Interruptible;
-import org.apache.jmeter.util.JMeterUtils;
-import org.apache.jorphan.util.JOrphanUtils;
-import org.slf4j.Logger;
-import org.slf4j.LoggerFactory;
-
-/**
- * Commons HTTPClient based soap sampler
- * @deprecated since 3.0, will be removed in next version
- */
-@Deprecated
-public class SoapSampler extends HTTPSampler2 implements Interruptible { // Implemented by parent class
-    private static final Logger log = LoggerFactory.getLogger(SoapSampler.class);
-
-    private static final long serialVersionUID = 240L;
-
-    public static final String XML_DATA = "HTTPSamper.xml_data"; //$NON-NLS-1$
-
-    public static final String URL_DATA = "SoapSampler.URL_DATA"; //$NON-NLS-1$
-
-    public static final String SOAP_ACTION = "SoapSampler.SOAP_ACTION"; //$NON-NLS-1$
-
-    public static final String SEND_SOAP_ACTION = "SoapSampler.SEND_SOAP_ACTION"; //$NON-NLS-1$
-
-    public static final String XML_DATA_FILE = "SoapSampler.xml_data_file"; //$NON-NLS-1$
-
-    private static final String DOUBLE_QUOTE = "\""; //$NON-NLS-1$
-
-    private static final String SOAPACTION = "SOAPAction"; //$NON-NLS-1$
-
-    private static final String ENCODING = "utf-8"; //$NON-NLS-1$ TODO should this be variable?
-
-    private static final String DEFAULT_CONTENT_TYPE = "text/xml"; //$NON-NLS-1$
-
-    public void setXmlData(String data) {
-        setProperty(XML_DATA, data);
-    }
-
-    public String getXmlData() {
-        return getPropertyAsString(XML_DATA);
-    }
-
-    /**
-     * it's kinda obvious, but we state it anyways. Set the xml file with a
-     * string path.
-     *
-     * @param filename path to the xml file
-     */
-    public void setXmlFile(String filename) {
-        setProperty(XML_DATA_FILE, filename);
-    }
-
-    /**
-     * Get the file location of the xml file.
-     *
-     * @return String file path.
-     */
-    public String getXmlFile() {
-        return getPropertyAsString(XML_DATA_FILE);
-    }
-
-    public String getURLData() {
-        return getPropertyAsString(URL_DATA);
-    }
-
-    public void setURLData(String url) {
-        setProperty(URL_DATA, url);
-    }
-
-    public String getSOAPAction() {
-        return getPropertyAsString(SOAP_ACTION);
-    }
-
-    public String getSOAPActionQuoted() {
-        String action = getSOAPAction();
-        StringBuilder sb = new StringBuilder(action.length()+2);
-        sb.append(DOUBLE_QUOTE);
-        sb.append(action);
-        sb.append(DOUBLE_QUOTE);
-        return sb.toString();
-    }
-
-    public void setSOAPAction(String action) {
-        setProperty(SOAP_ACTION, action);
-    }
-
-    public boolean getSendSOAPAction() {
-        return getPropertyAsBoolean(SEND_SOAP_ACTION);
-    }
-
-    public void setSendSOAPAction(boolean action) {
-        setProperty(SEND_SOAP_ACTION, String.valueOf(action));
-    }
-
-    protected int setPostHeaders(PostMethod post) {
-        int length=0;// Take length from file
-        if (getHeaderManager() != null) {
-            // headerManager was set, so let's set the connection
-            // to use it.
-            HeaderManager mngr = getHeaderManager();
-            int headerSize = mngr.size();
-            for (int idx = 0; idx < headerSize; idx++) {
-                Header hd = mngr.getHeader(idx);
-                if (HTTPConstants.HEADER_CONTENT_LENGTH.equalsIgnoreCase(hd.getName())) {// Use this to override file length
-                    length = Integer.parseInt(hd.getValue());
-                    break;
-                }
-                // All the other headers are set up by HTTPSampler2.setupConnection()
-            }
-        } else {
-            // otherwise we use "text/xml" as the default
-            post.setRequestHeader(HTTPConstants.HEADER_CONTENT_TYPE, DEFAULT_CONTENT_TYPE); //$NON-NLS-1$
-        }
-        if (getSendSOAPAction()) {
-            post.setRequestHeader(SOAPACTION, getSOAPActionQuoted());
-        }
-        return length;
-    }
-
-    /**
-     * Send POST data from <code>Entry</code> to the open connection.
-     *
-     * @param post POST request to send
-     * @param length the length of the content
-     */
-    private String sendPostData(PostMethod post, final int length) {
-        // Buffer to hold the post body, except file content
-        StringBuilder postedBody = new StringBuilder(1000);
-        final String xmlFile = getXmlFile();
-        if (xmlFile != null && xmlFile.length() > 0) {
-            File xmlFileAsFile = new File(xmlFile);
-            if(!(xmlFileAsFile.exists() && xmlFileAsFile.canRead())) {
-                throw new IllegalArgumentException(JMeterUtils.getResString("soap_sampler_file_invalid") // $NON-NLS-1$
-                        + xmlFileAsFile.getAbsolutePath());
-            }
-            // We just add placeholder text for file content
-            postedBody.append("Filename: ").append(xmlFile).append("\n");
-            postedBody.append("<actual file content, not shown here>");
-            post.setRequestEntity(new RequestEntity() {
-                @Override
-                public boolean isRepeatable() {
-                    return true;
-                }
-
-                @Override
-                public void writeRequest(OutputStream out) throws IOException {
-                    try (InputStream fileStream = new FileInputStream(xmlFile);
-                            InputStream in = new BufferedInputStream(fileStream)) {
-                        IOUtils.copy(in, out);
-                        out.flush();
-                    }
-                }
-
-                @Override
-                public long getContentLength() {
-                    switch(length){
-                        case -1:
-                            return -1;
-                        case 0: // No header provided
-                            return new File(xmlFile).length();
-                        default:
-                            return length;
-                        }
-                }
-
-                @Override
-                public String getContentType() {
-                    // TODO do we need to add a charset for the file contents?
-                    return DEFAULT_CONTENT_TYPE; // $NON-NLS-1$
-                }
-            });
-        } else {
-            postedBody.append(getXmlData());
-            post.setRequestEntity(new RequestEntity() {
-                @Override
-                public boolean isRepeatable() {
-                    return true;
-                }
-
-                @Override
-                public void writeRequest(OutputStream out) throws IOException {
-                    // charset must agree with content-type below
-                    IOUtils.write(getXmlData(), out, ENCODING); // $NON-NLS-1$
-                    out.flush();
-                }
-
-                @Override
-                public long getContentLength() {
-                    try {
-                        return getXmlData().getBytes(ENCODING).length; // so we don't generate chunked encoding
-                    } catch (UnsupportedEncodingException e) {
-                        log.warn(e.getLocalizedMessage());
-                        return -1; // will use chunked encoding
-                    }
-                }
-
-                @Override
-                public String getContentType() {
-                    return DEFAULT_CONTENT_TYPE+"; charset="+ENCODING; // $NON-NLS-1$
-                }
-            });
-        }
-        return postedBody.toString();
-    }
-
-    @Override
-    protected HTTPSampleResult sample(URL url, String method, boolean areFollowingRedirect, int frameDepth) {
-
-        String urlStr = url.toString();
-
-        log.debug("Start : sample " + urlStr);
-
-        PostMethod httpMethod;
-        httpMethod = new PostMethod(urlStr);
-
-        HTTPSampleResult res = new HTTPSampleResult();
-
-        res.setSampleLabel(urlStr); // May be replaced later
-        res.setHTTPMethod(HTTPConstants.POST);
-        res.setURL(url);
-        res.sampleStart(); // Count the retries as well in the time
-        HttpClient client = null;
-        InputStream instream = null;
-        try {
-            int content_len = setPostHeaders(httpMethod);
-            client = setupConnection(url, httpMethod, res);
-            setSavedClient(client);
-
-            res.setQueryString(sendPostData(httpMethod,content_len));
-            int statusCode = client.executeMethod(httpMethod);
-            // Some headers are set by executeMethod()
-            res.setRequestHeaders(getConnectionHeaders(httpMethod));
-
-            // Request sent. Now get the response:
-            instream = httpMethod.getResponseBodyAsStream();
-
-            if (instream != null) {// will be null for HEAD
-
-                org.apache.commons.httpclient.Header responseHeader = httpMethod.getResponseHeader(HTTPConstants.HEADER_CONTENT_ENCODING);
-                if (responseHeader != null && HTTPConstants.ENCODING_GZIP.equals(responseHeader.getValue())) {
-                    instream = new GZIPInputStream(instream);
-                }
-
-                //int contentLength = httpMethod.getResponseContentLength();Not visible ...
-                //TODO size ouststream according to actual content length
-                ByteArrayOutputStream outstream = new ByteArrayOutputStream(4 * 1024);
-                //contentLength > 0 ? contentLength : DEFAULT_INITIAL_BUFFER_SIZE);
-                byte[] buffer = new byte[4096];
-                int len;
-                boolean first = true;// first response
-                while ((len = instream.read(buffer)) > 0) {
-                    if (first) { // save the latency
-                        res.latencyEnd();
-                        first = false;
-                    }
-                    outstream.write(buffer, 0, len);
-                }
-
-                res.setResponseData(outstream.toByteArray());
-                outstream.close();
-
-            }
-
-            res.sampleEnd();
-            // Done with the sampling proper.
-
-            // Now collect the results into the HTTPSampleResult:
-
-            res.setSampleLabel(httpMethod.getURI().toString());
-            // Pick up Actual path (after redirects)
-
-            res.setResponseCode(Integer.toString(statusCode));
-            res.setSuccessful(isSuccessCode(statusCode));
-
-            res.setResponseMessage(httpMethod.getStatusText());
-
-            // Set up the defaults (may be overridden below)
-            res.setDataEncoding(ENCODING);
-            res.setContentType(DEFAULT_CONTENT_TYPE);
-            String ct = null;
-            org.apache.commons.httpclient.Header h
-                    = httpMethod.getResponseHeader(HTTPConstants.HEADER_CONTENT_TYPE);
-            if (h != null)// Can be missing, e.g. on redirect
-            {
-                ct = h.getValue();
-                res.setContentType(ct);// e.g. text/html; charset=ISO-8859-1
-                res.setEncodingAndType(ct);
-            }
-
-            res.setResponseHeaders(getResponseHeaders(httpMethod));
-            if (res.isRedirect()) {
-                res.setRedirectLocation(httpMethod.getResponseHeader(HTTPConstants.HEADER_LOCATION).getValue());
-            }
-
-            // If we redirected automatically, the URL may have changed
-            if (getAutoRedirects()) {
-                res.setURL(new URL(httpMethod.getURI().toString()));
-            }
-
-            // Store any cookies received in the cookie manager:
-            saveConnectionCookies(httpMethod, res.getURL(), getCookieManager());
-
-            // Save cache information
-            final CacheManager cacheManager = getCacheManager();
-            if (cacheManager != null){
-                cacheManager.saveDetails(httpMethod, res);
-            }
-
-            // Follow redirects and download page resources if appropriate:
-            res = resultProcessing(areFollowingRedirect, frameDepth, res);
-
-            log.debug("End : sample");
-            httpMethod.releaseConnection();
-            return res;
-        } catch (IllegalArgumentException | IOException e)// e.g. some kinds of invalid URL
-        {
-            res.sampleEnd();
-            errorResult(e, res);
-            return res;
-        } finally {
-            JOrphanUtils.closeQuietly(instream);
-            setSavedClient(null);
-            httpMethod.releaseConnection();
-        }
-    }
-
-    @Override
-    public URL getUrl() throws MalformedURLException {
-        return new URL(getURLData());
-    }
-}
