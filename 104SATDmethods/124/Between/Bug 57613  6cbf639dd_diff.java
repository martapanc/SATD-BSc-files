diff --git a/src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSamplerBase.java b/src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSamplerBase.java
index d657a3c25..6e0fb77c0 100644
--- a/src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSamplerBase.java
+++ b/src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSamplerBase.java
@@ -1,1241 +1,1243 @@
 /*
  * Licensed to the Apache Software Foundation (ASF) under one or more
  * contributor license agreements.  See the NOTICE file distributed with
  * this work for additional information regarding copyright ownership.
  * The ASF licenses this file to You under the Apache License, Version 2.0
  * (the "License"); you may not use this file except in compliance with
  * the License.  You may obtain a copy of the License at
  *
  *   http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */
 package org.apache.jmeter.protocol.http.sampler;
 
 import java.io.ByteArrayOutputStream;
 import java.io.IOException;
 import java.io.InputStream;
 import java.io.PrintStream;
 import java.io.UnsupportedEncodingException;
 import java.net.MalformedURLException;
 import java.net.URISyntaxException;
 import java.net.URL;
 import java.security.MessageDigest;
 import java.security.NoSuchAlgorithmException;
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.Collections;
 import java.util.HashMap;
 import java.util.HashSet;
 import java.util.Iterator;
 import java.util.List;
 import java.util.Map;
 import java.util.Set;
 import java.util.concurrent.Callable;
 import java.util.concurrent.ExecutionException;
 import java.util.concurrent.Future;
 import java.util.concurrent.LinkedBlockingQueue;
 import java.util.concurrent.ThreadFactory;
 import java.util.concurrent.ThreadPoolExecutor;
 import java.util.concurrent.TimeUnit;
 import java.util.concurrent.TimeoutException;
 
 import org.apache.commons.io.IOUtils;
 import org.apache.commons.lang3.StringUtils;
 import org.apache.jmeter.config.Argument;
 import org.apache.jmeter.config.Arguments;
 import org.apache.jmeter.config.ConfigTestElement;
 import org.apache.jmeter.engine.event.LoopIterationEvent;
 import org.apache.jmeter.protocol.http.control.AuthManager;
 import org.apache.jmeter.protocol.http.control.CacheManager;
 import org.apache.jmeter.protocol.http.control.Cookie;
 import org.apache.jmeter.protocol.http.control.CookieManager;
 import org.apache.jmeter.protocol.http.control.DNSCacheManager;
 import org.apache.jmeter.protocol.http.control.HeaderManager;
 import org.apache.jmeter.protocol.http.parser.HTMLParseException;
 import org.apache.jmeter.protocol.http.parser.HTMLParser;
 import org.apache.jmeter.protocol.http.util.ConversionUtils;
 import org.apache.jmeter.protocol.http.util.EncoderCache;
 import org.apache.jmeter.protocol.http.util.HTTPArgument;
 import org.apache.jmeter.protocol.http.util.HTTPConstants;
 import org.apache.jmeter.protocol.http.util.HTTPConstantsInterface;
 import org.apache.jmeter.protocol.http.util.HTTPFileArg;
 import org.apache.jmeter.protocol.http.util.HTTPFileArgs;
 import org.apache.jmeter.samplers.AbstractSampler;
 import org.apache.jmeter.samplers.Entry;
 import org.apache.jmeter.samplers.SampleResult;
 import org.apache.jmeter.testelement.TestElement;
 import org.apache.jmeter.testelement.TestIterationListener;
 import org.apache.jmeter.testelement.TestStateListener;
 import org.apache.jmeter.testelement.ThreadListener;
 import org.apache.jmeter.testelement.property.BooleanProperty;
 import org.apache.jmeter.testelement.property.CollectionProperty;
 import org.apache.jmeter.testelement.property.IntegerProperty;
 import org.apache.jmeter.testelement.property.JMeterProperty;
 import org.apache.jmeter.testelement.property.PropertyIterator;
 import org.apache.jmeter.testelement.property.StringProperty;
 import org.apache.jmeter.testelement.property.TestElementProperty;
 import org.apache.jmeter.threads.JMeterContext;
 import org.apache.jmeter.threads.JMeterContextService;
 import org.apache.jmeter.util.JMeterUtils;
 import org.apache.jorphan.logging.LoggingManager;
 import org.apache.jorphan.util.JOrphanUtils;
 import org.apache.log.Logger;
 import org.apache.oro.text.MalformedCachePatternException;
 import org.apache.oro.text.regex.Pattern;
 import org.apache.oro.text.regex.Perl5Matcher;
 
 /**
  * Common constants and methods for HTTP samplers
  *
  */
 public abstract class HTTPSamplerBase extends AbstractSampler
     implements TestStateListener, TestIterationListener, ThreadListener, HTTPConstantsInterface {
 
     private static final long serialVersionUID = 240L;
 
     private static final Logger log = LoggingManager.getLoggerForClass();
 
     private static final Set<String> APPLIABLE_CONFIG_CLASSES = new HashSet<String>(
             Arrays.asList(new String[]{
                     "org.apache.jmeter.config.gui.LoginConfigGui",
                     "org.apache.jmeter.protocol.http.config.gui.HttpDefaultsGui",
                     "org.apache.jmeter.config.gui.SimpleConfigGui",
                     "org.apache.jmeter.protocol.http.gui.HeaderPanel",
                     "org.apache.jmeter.protocol.http.control.DNSCacheManager",
                     "org.apache.jmeter.protocol.http.gui.DNSCachePanel",
                     "org.apache.jmeter.protocol.http.gui.AuthPanel",
                     "org.apache.jmeter.protocol.http.gui.CacheManagerGui",
                     "org.apache.jmeter.protocol.http.gui.CookiePanel"}));
     
     //+ JMX names - do not change
     public static final String ARGUMENTS = "HTTPsampler.Arguments"; // $NON-NLS-1$
 
     public static final String AUTH_MANAGER = "HTTPSampler.auth_manager"; // $NON-NLS-1$
 
     public static final String COOKIE_MANAGER = "HTTPSampler.cookie_manager"; // $NON-NLS-1$
 
     public static final String CACHE_MANAGER = "HTTPSampler.cache_manager"; // $NON-NLS-1$
 
     public static final String HEADER_MANAGER = "HTTPSampler.header_manager"; // $NON-NLS-1$
 
     public static final String DNS_CACHE_MANAGER = "HTTPSampler.dns_cache_manager"; // $NON-NLS-1$
 
     public static final String DOMAIN = "HTTPSampler.domain"; // $NON-NLS-1$
 
     public static final String PORT = "HTTPSampler.port"; // $NON-NLS-1$
 
     public static final String PROXYHOST = "HTTPSampler.proxyHost"; // $NON-NLS-1$
 
     public static final String PROXYPORT = "HTTPSampler.proxyPort"; // $NON-NLS-1$
 
     public static final String PROXYUSER = "HTTPSampler.proxyUser"; // $NON-NLS-1$
 
     public static final String PROXYPASS = "HTTPSampler.proxyPass"; // $NON-NLS-1$
 
     public static final String CONNECT_TIMEOUT = "HTTPSampler.connect_timeout"; // $NON-NLS-1$
 
     public static final String RESPONSE_TIMEOUT = "HTTPSampler.response_timeout"; // $NON-NLS-1$
 
     public static final String METHOD = "HTTPSampler.method"; // $NON-NLS-1$
 
     /** This is the encoding used for the content, i.e. the charset name, not the header "Content-Encoding" */
     public static final String CONTENT_ENCODING = "HTTPSampler.contentEncoding"; // $NON-NLS-1$
 
     public static final String IMPLEMENTATION = "HTTPSampler.implementation"; // $NON-NLS-1$
 
     public static final String PATH = "HTTPSampler.path"; // $NON-NLS-1$
 
     public static final String FOLLOW_REDIRECTS = "HTTPSampler.follow_redirects"; // $NON-NLS-1$
 
     public static final String AUTO_REDIRECTS = "HTTPSampler.auto_redirects"; // $NON-NLS-1$
 
     public static final String PROTOCOL = "HTTPSampler.protocol"; // $NON-NLS-1$
 
     static final String PROTOCOL_FILE = "file"; // $NON-NLS-1$
 
     private static final String DEFAULT_PROTOCOL = HTTPConstants.PROTOCOL_HTTP;
 
     public static final String URL = "HTTPSampler.URL"; // $NON-NLS-1$
 
     /**
      * IP source to use - does not apply to Java HTTP implementation currently
      */
     public static final String IP_SOURCE = "HTTPSampler.ipSource"; // $NON-NLS-1$
 
     public static final String IP_SOURCE_TYPE = "HTTPSampler.ipSourceType"; // $NON-NLS-1$
 
     public static final String USE_KEEPALIVE = "HTTPSampler.use_keepalive"; // $NON-NLS-1$
 
     public static final String DO_MULTIPART_POST = "HTTPSampler.DO_MULTIPART_POST"; // $NON-NLS-1$
 
     public static final String BROWSER_COMPATIBLE_MULTIPART  = "HTTPSampler.BROWSER_COMPATIBLE_MULTIPART"; // $NON-NLS-1$
     
     public static final String CONCURRENT_DWN = "HTTPSampler.concurrentDwn"; // $NON-NLS-1$
     
     public static final String CONCURRENT_POOL = "HTTPSampler.concurrentPool"; // $NON-NLS-1$
 
     private static final String CONCURRENT_POOL_DEFAULT = "4"; // default for concurrent pool (do not change)
     
     private static final String USER_AGENT = "User-Agent"; // $NON-NLS-1$
 
     //- JMX names
 
     public static final boolean BROWSER_COMPATIBLE_MULTIPART_MODE_DEFAULT = false; // The default setting to be used (i.e. historic)
     
     private static final long KEEPALIVETIME = 0; // for Thread Pool for resources but no need to use a special value?
     
     private static final long AWAIT_TERMINATION_TIMEOUT = 
         JMeterUtils.getPropDefault("httpsampler.await_termination_timeout", 60); // $NON-NLS-1$ // default value: 60 secs 
     
     private static final boolean IGNORE_FAILED_EMBEDDED_RESOURCES = 
             JMeterUtils.getPropDefault("httpsampler.ignore_failed_embedded_resources", false); // $NON-NLS-1$ // default value: false
 
     public static final int CONCURRENT_POOL_SIZE = 4; // Default concurrent pool size for download embedded resources
 
     public static enum SourceType {
         HOSTNAME("web_testing_source_ip_hostname"), //$NON-NLS-1$
         DEVICE("web_testing_source_ip_device"), //$NON-NLS-1$
         DEVICE_IPV4("web_testing_source_ip_device_ipv4"), //$NON-NLS-1$
         DEVICE_IPV6("web_testing_source_ip_device_ipv6"); //$NON-NLS-1$
         
         public final String propertyName;
         SourceType(String propertyName) {
             this.propertyName = propertyName;
         }
     }
 
     private static final int SOURCE_TYPE_DEFAULT = HTTPSamplerBase.SourceType.HOSTNAME.ordinal();
 
     // Use for ComboBox Source Address Type. Preserve order (specially with localization)
     public static final String[] getSourceTypeList() {
         final SourceType[] types = SourceType.values();
         final String[] displayStrings = new String[types.length];
         for(int i = 0; i < types.length; i++) {
             displayStrings[i] = JMeterUtils.getResString(types[i].propertyName);
         }
         return displayStrings;
     }
 
     public static final String DEFAULT_METHOD = HTTPConstants.GET; // $NON-NLS-1$
     // Supported methods:
     private static final String [] METHODS = {
         DEFAULT_METHOD, // i.e. GET
         HTTPConstants.POST,
         HTTPConstants.HEAD,
         HTTPConstants.PUT,
         HTTPConstants.OPTIONS,
         HTTPConstants.TRACE,
         HTTPConstants.DELETE,
         HTTPConstants.PATCH,
         HTTPConstants.PROPFIND,
         HTTPConstants.PROPPATCH,
         HTTPConstants.MKCOL,
         HTTPConstants.COPY,
         HTTPConstants.MOVE,
         HTTPConstants.LOCK,
-        HTTPConstants.UNLOCK
+        HTTPConstants.UNLOCK,
+        HTTPConstants.REPORT,
+        HTTPConstants.MKCALENDAR
         };
 
     private static final List<String> METHODLIST = Collections.unmodifiableList(Arrays.asList(METHODS));
 
     // @see mergeFileProperties
     // Must be private, as the file list needs special handling
     private static final String FILE_ARGS = "HTTPsampler.Files"; // $NON-NLS-1$
     // MIMETYPE is kept for backward compatibility with old test plans
     private static final String MIMETYPE = "HTTPSampler.mimetype"; // $NON-NLS-1$
     // FILE_NAME is kept for backward compatibility with old test plans
     private static final String FILE_NAME = "HTTPSampler.FILE_NAME"; // $NON-NLS-1$
     /* Shown as Parameter Name on the GUI */
     // FILE_FIELD is kept for backward compatibility with old test plans
     private static final String FILE_FIELD = "HTTPSampler.FILE_FIELD"; // $NON-NLS-1$
 
     public static final String CONTENT_TYPE = "HTTPSampler.CONTENT_TYPE"; // $NON-NLS-1$
 
     // IMAGE_PARSER now really means EMBEDDED_PARSER
     public static final String IMAGE_PARSER = "HTTPSampler.image_parser"; // $NON-NLS-1$
 
     // Embedded URLs must match this RE (if provided)
     public static final String EMBEDDED_URL_RE = "HTTPSampler.embedded_url_re"; // $NON-NLS-1$
 
     public static final String MONITOR = "HTTPSampler.monitor"; // $NON-NLS-1$
 
     // Store MD5 hash instead of storing response
     private static final String MD5 = "HTTPSampler.md5"; // $NON-NLS-1$
 
     /** A number to indicate that the port has not been set. */
     public static final int UNSPECIFIED_PORT = 0;
     public static final String UNSPECIFIED_PORT_AS_STRING = "0"; // $NON-NLS-1$
     // TODO - change to use URL version? Will this affect test plans?
 
     /** If the port is not present in a URL, getPort() returns -1 */
     public static final int URL_UNSPECIFIED_PORT = -1;
     public static final String URL_UNSPECIFIED_PORT_AS_STRING = "-1"; // $NON-NLS-1$
 
     protected static final String NON_HTTP_RESPONSE_CODE = "Non HTTP response code";
 
     protected static final String NON_HTTP_RESPONSE_MESSAGE = "Non HTTP response message";
 
     public static final String POST_BODY_RAW = "HTTPSampler.postBodyRaw"; // TODO - belongs elsewhere 
 
     public static final boolean POST_BODY_RAW_DEFAULT = false;
 
     private static final String ARG_VAL_SEP = "="; // $NON-NLS-1$
 
     private static final String QRY_SEP = "&"; // $NON-NLS-1$
 
     private static final String QRY_PFX = "?"; // $NON-NLS-1$
 
     protected static final int MAX_REDIRECTS = JMeterUtils.getPropDefault("httpsampler.max_redirects", 5); // $NON-NLS-1$
 
     protected static final int MAX_FRAME_DEPTH = JMeterUtils.getPropDefault("httpsampler.max_frame_depth", 5); // $NON-NLS-1$
 
 
     // Derive the mapping of content types to parsers
     private static final Map<String, String> parsersForType = new HashMap<String, String>();
     // Not synch, but it is not modified after creation
 
     private static final String RESPONSE_PARSERS= // list of parsers
         JMeterUtils.getProperty("HTTPResponse.parsers");//$NON-NLS-1$
 
     static{
         String []parsers = JOrphanUtils.split(RESPONSE_PARSERS, " " , true);// returns empty array for null
         for (int i=0;i<parsers.length;i++){
             final String parser = parsers[i];
             String classname=JMeterUtils.getProperty(parser+".className");//$NON-NLS-1$
             if (classname == null){
                 log.info("Cannot find .className property for "+parser+", using default");
                 classname="";
             }
             String typelist=JMeterUtils.getProperty(parser+".types");//$NON-NLS-1$
             if (typelist != null){
                 String []types=JOrphanUtils.split(typelist, " " , true);
                 for (int j=0;j<types.length;j++){
                     final String type = types[j];
                     log.info("Parser for "+type+" is "+classname);
                     parsersForType.put(type,classname);
                 }
             } else {
                 log.warn("Cannot find .types property for "+parser);
             }
         }
         if (parsers.length==0){ // revert to previous behaviour
             parsersForType.put("text/html", ""); //$NON-NLS-1$ //$NON-NLS-2$
             log.info("No response parsers defined: text/html only will be scanned for embedded resources");
         }
         
     }
 
     // Bug 49083
     /** Whether to remove '/pathsegment/..' from redirects; default true */
     private static final boolean REMOVESLASHDOTDOT = JMeterUtils.getPropDefault("httpsampler.redirect.removeslashdotdot", true);
 
     ////////////////////// Code ///////////////////////////
 
     public HTTPSamplerBase() {
         setArguments(new Arguments());
     }
 
     /**
      * Determine if the file should be sent as the entire Content body,
      * i.e. without any additional wrapping.
      *
      * @return true if specified file is to be sent as the body,
      * i.e. there is a single file entry which has a non-empty path and
      * an empty Parameter name.
      */
     public boolean getSendFileAsPostBody() {
         // If there is one file with no parameter name, the file will
         // be sent as post body.
         HTTPFileArg[] files = getHTTPFiles();
         return (files.length == 1)
             && (files[0].getPath().length() > 0)
             && (files[0].getParamName().length() == 0);
     }
 
     /**
      * Determine if none of the parameters have a name, and if that
      * is the case, it means that the parameter values should be sent
      * as the entity body
      *
      * @return true if none of the parameters have a name specified
      */
     public boolean getSendParameterValuesAsPostBody() {
         if(getPostBodyRaw()) {
             return true;
         } else {
             boolean noArgumentsHasName = true;
             PropertyIterator args = getArguments().iterator();
             while (args.hasNext()) {
                 HTTPArgument arg = (HTTPArgument) args.next().getObjectValue();
                 if(arg.getName() != null && arg.getName().length() > 0) {
                     noArgumentsHasName = false;
                     break;
                 }
             }
             return noArgumentsHasName;
         }
     }
 
     /**
      * Determine if we should use multipart/form-data or
      * application/x-www-form-urlencoded for the post
      *
      * @return true if multipart/form-data should be used and method is POST
      */
     public boolean getUseMultipartForPost(){
         // We use multipart if we have been told so, or files are present
         // and the files should not be send as the post body
         HTTPFileArg[] files = getHTTPFiles();
         if(HTTPConstants.POST.equals(getMethod()) && (getDoMultipartPost() || (files.length > 0 && !getSendFileAsPostBody()))) {
             return true;
         }
         return false;
     }
 
     public void setProtocol(String value) {
         setProperty(PROTOCOL, value.toLowerCase(java.util.Locale.ENGLISH));
     }
 
     /**
      * Gets the protocol, with default.
      *
      * @return the protocol
      */
     public String getProtocol() {
         String protocol = getPropertyAsString(PROTOCOL);
         if (protocol == null || protocol.length() == 0 ) {
             return DEFAULT_PROTOCOL;
         }
         return protocol;
     }
 
     /**
      * Sets the Path attribute of the UrlConfig object Also calls parseArguments
      * to extract and store any query arguments
      *
      * @param path
      *            The new Path value
      */
     public void setPath(String path) {
         // We know that URL arguments should always be encoded in UTF-8 according to spec
         setPath(path, EncoderCache.URL_ARGUMENT_ENCODING);
     }
 
     /**
      * Sets the PATH property; if the request is a GET or DELETE (and the path
      * does not start with http[s]://) it also calls {@link #parseArguments(String, String)}
      * to extract and store any query arguments.
      *
      * @param path
      *            The new Path value
      * @param contentEncoding
      *            The encoding used for the querystring parameter values
      */
     public void setPath(String path, String contentEncoding) {
         boolean fullUrl = path.startsWith(HTTP_PREFIX) || path.startsWith(HTTPS_PREFIX); 
         if (!fullUrl && (HTTPConstants.GET.equals(getMethod()) || HTTPConstants.DELETE.equals(getMethod()))) {
             int index = path.indexOf(QRY_PFX);
             if (index > -1) {
                 setProperty(PATH, path.substring(0, index));
                 // Parse the arguments in querystring, assuming specified encoding for values
                 parseArguments(path.substring(index + 1), contentEncoding);
             } else {
                 setProperty(PATH, path);
             }
         } else {
             setProperty(PATH, path);
         }
     }
 
     public String getPath() {
         String p = getPropertyAsString(PATH);
         return encodeSpaces(p);
     }
 
     public void setFollowRedirects(boolean value) {
         setProperty(new BooleanProperty(FOLLOW_REDIRECTS, value));
     }
 
     public boolean getFollowRedirects() {
         return getPropertyAsBoolean(FOLLOW_REDIRECTS);
     }
 
     public void setAutoRedirects(boolean value) {
         setProperty(new BooleanProperty(AUTO_REDIRECTS, value));
     }
 
     public boolean getAutoRedirects() {
         return getPropertyAsBoolean(AUTO_REDIRECTS);
     }
 
     public void setMethod(String value) {
         setProperty(METHOD, value);
     }
 
     public String getMethod() {
         return getPropertyAsString(METHOD);
     }
 
     /**
      * Sets the value of the encoding to be used for the content.
      * 
      * @param charsetName the name of the encoding to be used
      */
     public void setContentEncoding(String charsetName) {
         setProperty(CONTENT_ENCODING, charsetName);
     }
 
     /**
      * 
      * @return the encoding of the content, i.e. its charset name
      */
     public String getContentEncoding() {
         return getPropertyAsString(CONTENT_ENCODING);
     }
 
     public void setUseKeepAlive(boolean value) {
         setProperty(new BooleanProperty(USE_KEEPALIVE, value));
     }
 
     public boolean getUseKeepAlive() {
         return getPropertyAsBoolean(USE_KEEPALIVE);
     }
 
     public void setDoMultipartPost(boolean value) {
         setProperty(new BooleanProperty(DO_MULTIPART_POST, value));
     }
 
     public boolean getDoMultipartPost() {
         return getPropertyAsBoolean(DO_MULTIPART_POST, false);
     }
 
     public void setDoBrowserCompatibleMultipart(boolean value) {
         setProperty(BROWSER_COMPATIBLE_MULTIPART, value, BROWSER_COMPATIBLE_MULTIPART_MODE_DEFAULT);
     }
 
     public boolean getDoBrowserCompatibleMultipart() {
         return getPropertyAsBoolean(BROWSER_COMPATIBLE_MULTIPART, BROWSER_COMPATIBLE_MULTIPART_MODE_DEFAULT);
     }
 
     public void setMonitor(String value) {
         this.setProperty(MONITOR, value);
     }
 
     public void setMonitor(boolean truth) {
         this.setProperty(MONITOR, truth);
     }
 
     public String getMonitor() {
         return this.getPropertyAsString(MONITOR);
     }
 
     public boolean isMonitor() {
         return this.getPropertyAsBoolean(MONITOR);
     }
 
     public void setImplementation(String value) {
         this.setProperty(IMPLEMENTATION, value);
     }
 
     public String getImplementation() {
         return this.getPropertyAsString(IMPLEMENTATION);
     }
 
     public boolean useMD5() {
         return this.getPropertyAsBoolean(MD5, false);
     }
 
    public void setMD5(boolean truth) {
         this.setProperty(MD5, truth, false);
     }
 
     /**
      * Add an argument which has already been encoded
      *
      * @param name name of the argument
      * @param value value of the argument
      */
     public void addEncodedArgument(String name, String value) {
         this.addEncodedArgument(name, value, ARG_VAL_SEP);
     }
 
     /**
      * Creates an HTTPArgument and adds it to the current set {@link #getArguments()} of arguments.
      * 
      * @param name - the parameter name
      * @param value - the parameter value
      * @param metaData - normally just '='
      * @param contentEncoding - the encoding, may be null
      */
     public void addEncodedArgument(String name, String value, String metaData, String contentEncoding) {
         if (log.isDebugEnabled()){
             log.debug("adding argument: name: " + name + " value: " + value + " metaData: " + metaData + " contentEncoding: " + contentEncoding);
         }
 
         HTTPArgument arg = null;
         final boolean nonEmptyEncoding = !StringUtils.isEmpty(contentEncoding);
         if(nonEmptyEncoding) {
             arg = new HTTPArgument(name, value, metaData, true, contentEncoding);
         }
         else {
             arg = new HTTPArgument(name, value, metaData, true);
         }
 
         // Check if there are any difference between name and value and their encoded name and value
         String valueEncoded = null;
         if(nonEmptyEncoding) {
             try {
                 valueEncoded = arg.getEncodedValue(contentEncoding);
             }
             catch (UnsupportedEncodingException e) {
                 log.warn("Unable to get encoded value using encoding " + contentEncoding);
                 valueEncoded = arg.getEncodedValue();
             }
         }
         else {
             valueEncoded = arg.getEncodedValue();
         }
         // If there is no difference, we mark it as not needing encoding
         if (arg.getName().equals(arg.getEncodedName()) && arg.getValue().equals(valueEncoded)) {
             arg.setAlwaysEncoded(false);
         }
         this.getArguments().addArgument(arg);
     }
 
     public void addEncodedArgument(String name, String value, String metaData) {
         this.addEncodedArgument(name, value, metaData, null);
     }
 
     public void addNonEncodedArgument(String name, String value, String metadata) {
         HTTPArgument arg = new HTTPArgument(name, value, metadata, false);
         arg.setAlwaysEncoded(false);
         this.getArguments().addArgument(arg);
     }
 
     public void addArgument(String name, String value) {
         this.getArguments().addArgument(new HTTPArgument(name, value));
     }
 
     public void addArgument(String name, String value, String metadata) {
         this.getArguments().addArgument(new HTTPArgument(name, value, metadata));
     }
 
     public boolean hasArguments() {
         return getArguments().getArgumentCount() > 0;
     }
 
     @Override
     public void addTestElement(TestElement el) {
         if (el instanceof CookieManager) {
             setCookieManager((CookieManager) el);
         } else if (el instanceof CacheManager) {
             setCacheManager((CacheManager) el);
         } else if (el instanceof HeaderManager) {
             setHeaderManager((HeaderManager) el);
         } else if (el instanceof AuthManager) {
             setAuthManager((AuthManager) el);
         } else if (el instanceof DNSCacheManager) {
             setDNSResolver((DNSCacheManager) el);
         } else {
             super.addTestElement(el);
         }
     }
 
     /**
      * {@inheritDoc}
      * <p>
      * Clears the Header Manager property so subsequent loops don't keep merging more elements
      */
     @Override
     public void clearTestElementChildren(){
         removeProperty(HEADER_MANAGER);
     }
 
     public void setPort(int value) {
         setProperty(new IntegerProperty(PORT, value));
     }
 
     /**
      * Get the port number for a URL, applying defaults if necessary.
      * (Called by CookieManager.)
      * @param protocol from {@link URL#getProtocol()}
      * @param port number from {@link URL#getPort()}
      * @return the default port for the protocol
      */
     public static int getDefaultPort(String protocol,int port){
         if (port==URL_UNSPECIFIED_PORT){
             return
                 protocol.equalsIgnoreCase(HTTPConstants.PROTOCOL_HTTP)  ? HTTPConstants.DEFAULT_HTTP_PORT :
                 protocol.equalsIgnoreCase(HTTPConstants.PROTOCOL_HTTPS) ? HTTPConstants.DEFAULT_HTTPS_PORT :
                     port;
         }
         return port;
     }
 
     /**
      * Get the port number from the port string, allowing for trailing blanks.
      *
      * @return port number or UNSPECIFIED_PORT (== 0)
      */
     public int getPortIfSpecified() {
         String port_s = getPropertyAsString(PORT, UNSPECIFIED_PORT_AS_STRING);
         try {
             return Integer.parseInt(port_s.trim());
         } catch (NumberFormatException e) {
             return UNSPECIFIED_PORT;
         }
     }
 
     /**
      * Tell whether the default port for the specified protocol is used
      *
      * @return true if the default port number for the protocol is used, false otherwise
      */
     public boolean isProtocolDefaultPort() {
         final int port = getPortIfSpecified();
         final String protocol = getProtocol();
         if (port == UNSPECIFIED_PORT ||
                 (HTTPConstants.PROTOCOL_HTTP.equalsIgnoreCase(protocol) && port == HTTPConstants.DEFAULT_HTTP_PORT) ||
                 (HTTPConstants.PROTOCOL_HTTPS.equalsIgnoreCase(protocol) && port == HTTPConstants.DEFAULT_HTTPS_PORT)) {
             return true;
         }
         return false;
     }
 
     /**
      * Get the port; apply the default for the protocol if necessary.
      *
      * @return the port number, with default applied if required.
      */
     public int getPort() {
         final int port = getPortIfSpecified();
         if (port == UNSPECIFIED_PORT) {
             String prot = getProtocol();
             if (HTTPConstants.PROTOCOL_HTTPS.equalsIgnoreCase(prot)) {
                 return HTTPConstants.DEFAULT_HTTPS_PORT;
             }
             if (!HTTPConstants.PROTOCOL_HTTP.equalsIgnoreCase(prot)) {
                 log.warn("Unexpected protocol: "+prot);
                 // TODO - should this return something else?
             }
             return HTTPConstants.DEFAULT_HTTP_PORT;
         }
         return port;
     }
 
     public void setDomain(String value) {
         setProperty(DOMAIN, value);
     }
 
     public String getDomain() {
         return getPropertyAsString(DOMAIN);
     }
 
     public void setConnectTimeout(String value) {
         setProperty(CONNECT_TIMEOUT, value, "");
     }
 
     public int getConnectTimeout() {
         return getPropertyAsInt(CONNECT_TIMEOUT, 0);
     }
 
     public void setResponseTimeout(String value) {
         setProperty(RESPONSE_TIMEOUT, value, "");
     }
 
     public int getResponseTimeout() {
         return getPropertyAsInt(RESPONSE_TIMEOUT, 0);
     }
 
     public String getProxyHost() {
         return getPropertyAsString(PROXYHOST);
     }
 
     public int getProxyPortInt() {
         return getPropertyAsInt(PROXYPORT, 0);
     }
 
     public String getProxyUser() {
         return getPropertyAsString(PROXYUSER);
     }
 
     public String getProxyPass() {
         return getPropertyAsString(PROXYPASS);
     }
 
     public void setArguments(Arguments value) {
         setProperty(new TestElementProperty(ARGUMENTS, value));
     }
 
     public Arguments getArguments() {
         return (Arguments) getProperty(ARGUMENTS).getObjectValue();
     }
 
     /**
      * @param value Boolean that indicates body will be sent as is
      */
     public void setPostBodyRaw(boolean value) {
         setProperty(POST_BODY_RAW, value, POST_BODY_RAW_DEFAULT);
     }
 
     /**
      * @return boolean that indicates body will be sent as is
      */
     public boolean getPostBodyRaw() {
         return getPropertyAsBoolean(POST_BODY_RAW, POST_BODY_RAW_DEFAULT);
     }
 
     public void setAuthManager(AuthManager value) {
         AuthManager mgr = getAuthManager();
         if (mgr != null) {
             log.warn("Existing AuthManager " + mgr.getName() + " superseded by " + value.getName());
         }
         setProperty(new TestElementProperty(AUTH_MANAGER, value));
     }
 
     public AuthManager getAuthManager() {
         return (AuthManager) getProperty(AUTH_MANAGER).getObjectValue();
     }
 
     public void setHeaderManager(HeaderManager value) {
         HeaderManager mgr = getHeaderManager();
         if (mgr != null) {
             value = mgr.merge(value, true);
             if (log.isDebugEnabled()) {
                 log.debug("Existing HeaderManager '" + mgr.getName() + "' merged with '" + value.getName() + "'");
                 for (int i=0; i < value.getHeaders().size(); i++) {
                     log.debug("    " + value.getHeader(i).getName() + "=" + value.getHeader(i).getValue());
                 }
             }
         }
         setProperty(new TestElementProperty(HEADER_MANAGER, value));
     }
 
     public HeaderManager getHeaderManager() {
         return (HeaderManager) getProperty(HEADER_MANAGER).getObjectValue();
     }
 
     // private method to allow AsyncSample to reset the value without performing checks
     private void setCookieManagerProperty(CookieManager value) {
         setProperty(new TestElementProperty(COOKIE_MANAGER, value));        
     }
 
     public void setCookieManager(CookieManager value) {
         CookieManager mgr = getCookieManager();
         if (mgr != null) {
             log.warn("Existing CookieManager " + mgr.getName() + " superseded by " + value.getName());
         }
         setCookieManagerProperty(value);
     }
 
     public CookieManager getCookieManager() {
         return (CookieManager) getProperty(COOKIE_MANAGER).getObjectValue();
     }
 
     // private method to allow AsyncSample to reset the value without performing checks
     private void setCacheManagerProperty(CacheManager value) {
         setProperty(new TestElementProperty(CACHE_MANAGER, value));
     }
 
     public void setCacheManager(CacheManager value) {
         CacheManager mgr = getCacheManager();
         if (mgr != null) {
             log.warn("Existing CacheManager " + mgr.getName() + " superseded by " + value.getName());
         }
         setCacheManagerProperty(value);
     }
 
     public CacheManager getCacheManager() {
         return (CacheManager) getProperty(CACHE_MANAGER).getObjectValue();
     }
 
     public DNSCacheManager getDNSResolver() {
         return (DNSCacheManager) getProperty(DNS_CACHE_MANAGER).getObjectValue();
     }
 
     public void setDNSResolver(DNSCacheManager cacheManager) {
         DNSCacheManager mgr = getDNSResolver();
         if (mgr != null) {
             log.warn("Existing DNSCacheManager " + mgr.getName() + " superseded by " + cacheManager.getName());
         }
         setProperty(new TestElementProperty(DNS_CACHE_MANAGER, cacheManager));
     }
 
     public boolean isImageParser() {
         return getPropertyAsBoolean(IMAGE_PARSER, false);
     }
 
     public void setImageParser(boolean parseImages) {
         setProperty(IMAGE_PARSER, parseImages, false);
     }
 
     /**
      * Get the regular expression URLs must match.
      *
      * @return regular expression (or empty) string
      */
     public String getEmbeddedUrlRE() {
         return getPropertyAsString(EMBEDDED_URL_RE,"");
     }
 
     public void setEmbeddedUrlRE(String regex) {
         setProperty(new StringProperty(EMBEDDED_URL_RE, regex));
     }
 
     /**
      * Populates the provided HTTPSampleResult with details from the Exception.
      * Does not create a new instance, so should not be used directly to add a subsample.
      * 
      * @param e
      *            Exception representing the error.
      * @param res
      *            SampleResult to be modified
      * @return the modified sampling result containing details of the Exception.
      */
     protected HTTPSampleResult errorResult(Throwable e, HTTPSampleResult res) {
         res.setSampleLabel(res.getSampleLabel());
         res.setDataType(SampleResult.TEXT);
         ByteArrayOutputStream text = new ByteArrayOutputStream(200);
         e.printStackTrace(new PrintStream(text));
         res.setResponseData(text.toByteArray());
         res.setResponseCode(NON_HTTP_RESPONSE_CODE+": "+e.getClass().getName());
         res.setResponseMessage(NON_HTTP_RESPONSE_MESSAGE+": "+e.getMessage());
         res.setSuccessful(false);
         res.setMonitor(this.isMonitor());
         return res;
     }
 
     private static final String HTTP_PREFIX = HTTPConstants.PROTOCOL_HTTP+"://"; // $NON-NLS-1$
     private static final String HTTPS_PREFIX = HTTPConstants.PROTOCOL_HTTPS+"://"; // $NON-NLS-1$
 
     // Bug 51939
     private static final boolean SEPARATE_CONTAINER = 
             JMeterUtils.getPropDefault("httpsampler.separate.container", true); // $NON-NLS-1$
 
     /**
      * Get the URL, built from its component parts.
      *
      * <p>
      * As a special case, if the path starts with "http[s]://",
      * then the path is assumed to be the entire URL.
      * </p>
      *
      * @return The URL to be requested by this sampler.
      * @throws MalformedURLException if url is malformed
      */
     public URL getUrl() throws MalformedURLException {
         StringBuilder pathAndQuery = new StringBuilder(100);
         String path = this.getPath();
         // Hack to allow entire URL to be provided in host field
         if (path.startsWith(HTTP_PREFIX)
          || path.startsWith(HTTPS_PREFIX)){
             return new URL(path);
         }
         String domain = getDomain();
         String protocol = getProtocol();
         if (PROTOCOL_FILE.equalsIgnoreCase(protocol)) {
             domain=null; // allow use of relative file URLs
         } else {
             // HTTP URLs must be absolute, allow file to be relative
             if (!path.startsWith("/")){ // $NON-NLS-1$
                 pathAndQuery.append("/"); // $NON-NLS-1$
             }
         }
         pathAndQuery.append(path);
 
         // Add the query string if it is a HTTP GET or DELETE request
         if(HTTPConstants.GET.equals(getMethod()) || HTTPConstants.DELETE.equals(getMethod())) {
             // Get the query string encoded in specified encoding
             // If no encoding is specified by user, we will get it
             // encoded in UTF-8, which is what the HTTP spec says
             String queryString = getQueryString(getContentEncoding());
             if(queryString.length() > 0) {
                 if (path.indexOf(QRY_PFX) > -1) {// Already contains a prefix
                     pathAndQuery.append(QRY_SEP);
                 } else {
                     pathAndQuery.append(QRY_PFX);
                 }
                 pathAndQuery.append(queryString);
             }
         }
         // If default port for protocol is used, we do not include port in URL
         if(isProtocolDefaultPort()) {
             return new URL(protocol, domain, pathAndQuery.toString());
         }
         return new URL(protocol, domain, getPort(), pathAndQuery.toString());
     }
 
     /**
      * Gets the QueryString attribute of the UrlConfig object, using
      * UTF-8 to encode the URL
      *
      * @return the QueryString value
      */
     public String getQueryString() {
         // We use the encoding which should be used according to the HTTP spec, which is UTF-8
         return getQueryString(EncoderCache.URL_ARGUMENT_ENCODING);
     }
 
     /**
      * Gets the QueryString attribute of the UrlConfig object, using the
      * specified encoding to encode the parameter values put into the URL
      *
      * @param contentEncoding the encoding to use for encoding parameter values
      * @return the QueryString value
      */
     public String getQueryString(String contentEncoding) {
          // Check if the sampler has a specified content encoding
          if(JOrphanUtils.isBlank(contentEncoding)) {
              // We use the encoding which should be used according to the HTTP spec, which is UTF-8
              contentEncoding = EncoderCache.URL_ARGUMENT_ENCODING;
          }
         StringBuilder buf = new StringBuilder();
         PropertyIterator iter = getArguments().iterator();
         boolean first = true;
         while (iter.hasNext()) {
             HTTPArgument item = null;
             /*
              * N.B. Revision 323346 introduced the ClassCast check, but then used iter.next()
              * to fetch the item to be cast, thus skipping the element that did not cast.
              * Reverted to work more like the original code, but with the check in place.
              * Added a warning message so can track whether it is necessary
              */
             Object objectValue = iter.next().getObjectValue();
             try {
                 item = (HTTPArgument) objectValue;
             } catch (ClassCastException e) {
                 log.warn("Unexpected argument type: "+objectValue.getClass().getName());
                 item = new HTTPArgument((Argument) objectValue);
             }
             final String encodedName = item.getEncodedName();
             if (encodedName.length() == 0) {
                 continue; // Skip parameters with a blank name (allows use of optional variables in parameter lists)
             }
             if (!first) {
                 buf.append(QRY_SEP);
             } else {
                 first = false;
             }
             buf.append(encodedName);
             if (item.getMetaData() == null) {
                 buf.append(ARG_VAL_SEP);
             } else {
                 buf.append(item.getMetaData());
             }
 
             // Encode the parameter value in the specified content encoding
             try {
                 buf.append(item.getEncodedValue(contentEncoding));
             }
             catch(UnsupportedEncodingException e) {
                 log.warn("Unable to encode parameter in encoding " + contentEncoding + ", parameter value not included in query string");
             }
         }
         return buf.toString();
     }
 
     // Mark Walsh 2002-08-03, modified to also parse a parameter name value
     // string, where string contains only the parameter name and no equal sign.
     /**
      * This method allows a proxy server to send over the raw text from a
      * browser's output stream to be parsed and stored correctly into the
      * UrlConfig object.
      *
      * For each name found, addArgument() is called
      *
      * @param queryString -
      *            the query string, might be the post body of a http post request.
      * @param contentEncoding -
      *            the content encoding of the query string; 
      *            if non-null then it is used to decode the 
      */
     public void parseArguments(String queryString, String contentEncoding) {
         String[] args = JOrphanUtils.split(queryString, QRY_SEP);
         final boolean isDebug = log.isDebugEnabled();
         for (int i = 0; i < args.length; i++) {
             if (isDebug) {
                 log.debug("Arg: " + args[i]);
             }
             // need to handle four cases:
             // - string contains name=value
             // - string contains name=
             // - string contains name
             // - empty string
 
             String metaData; // records the existance of an equal sign
             String name;
             String value;
             int length = args[i].length();
             int endOfNameIndex = args[i].indexOf(ARG_VAL_SEP);
             if (endOfNameIndex != -1) {// is there a separator?
                 // case of name=value, name=
                 metaData = ARG_VAL_SEP;
                 name = args[i].substring(0, endOfNameIndex);
                 value = args[i].substring(endOfNameIndex + 1, length);
             } else {
                 metaData = "";
                 name=args[i];
                 value="";
             }
             if (name.length() > 0) {
                 if (isDebug) {
                     log.debug("Name: " + name+ " Value: " + value+ " Metadata: " + metaData);
                 }
                 // If we know the encoding, we can decode the argument value,
                 // to make it easier to read for the user
                 if(!StringUtils.isEmpty(contentEncoding)) {
                     addEncodedArgument(name, value, metaData, contentEncoding);
                 }
                 else {
                     // If we do not know the encoding, we just use the encoded value
                     // The browser has already done the encoding, so save the values as is
                     addNonEncodedArgument(name, value, metaData);
                 }
             }
         }
     }
 
     public void parseArguments(String queryString) {
         // We do not know the content encoding of the query string
         parseArguments(queryString, null);
     }
 
     @Override
     public String toString() {
         try {
             StringBuilder stringBuffer = new StringBuilder();
             stringBuffer.append(this.getUrl().toString());
             // Append body if it is a post or put
             if(HTTPConstants.POST.equals(getMethod()) || HTTPConstants.PUT.equals(getMethod())) {
                 stringBuffer.append("\nQuery Data: ");
                 stringBuffer.append(getQueryString());
             }
             return stringBuffer.toString();
         } catch (MalformedURLException e) {
             return "";
         }
     }
 
     /**
      * Do a sampling and return its results.
      *
      * @param e
      *            <code>Entry</code> to be sampled
      * @return results of the sampling
      */
     @Override
     public SampleResult sample(Entry e) {
         return sample();
     }
 
     /**
      * Perform a sample, and return the results
      *
      * @return results of the sampling
      */
     public SampleResult sample() {
         SampleResult res = null;
         try {
             res = sample(getUrl(), getMethod(), false, 0);
             if(res != null) {
                 res.setSampleLabel(getName());
             }
             return res;
         } catch (Exception e) {
             return errorResult(e, new HTTPSampleResult());
         }
     }
 
     /**
      * Samples the URL passed in and stores the result in
      * <code>HTTPSampleResult</code>, following redirects and downloading
      * page resources as appropriate.
      * <p>
      * When getting a redirect target, redirects are not followed and resources
      * are not downloaded. The caller will take care of this.
      *
      * @param u
      *            URL to sample
      * @param method
      *            HTTP method: GET, POST,...
      * @param areFollowingRedirect
      *            whether we're getting a redirect target
      * @param depth
      *            Depth of this target in the frame structure. Used only to
      *            prevent infinite recursion.
      * @return results of the sampling, can be null if u is in CacheManager
      */
     protected abstract HTTPSampleResult sample(URL u,
             String method, boolean areFollowingRedirect, int depth);
 
     /**
      * Download the resources of an HTML page.
      * 
      * @param res
      *            result of the initial request - must contain an HTML response
      * @param container
      *            for storing the results, if any
      * @param frameDepth
      *            Depth of this target in the frame structure. Used only to
      *            prevent infinite recursion.
      * @return res if no resources exist, otherwise the "Container" result with one subsample per request issued
      */
     protected HTTPSampleResult downloadPageResources(HTTPSampleResult res, HTTPSampleResult container, int frameDepth) {
         Iterator<URL> urls = null;
         try {
             final byte[] responseData = res.getResponseData();
             if (responseData.length > 0){  // Bug 39205
                 String parserName = getParserClass(res);
                 if(parserName != null)
                 {
                     final HTMLParser parser =
                         parserName.length() > 0 ? // we have a name
                         HTMLParser.getParser(parserName)
                         :
                         HTMLParser.getParser(); // we don't; use the default parser
                     String userAgent = getUserAgent(res);
                     urls = parser.getEmbeddedResourceURLs(userAgent, responseData, res.getURL(), res.getDataEncodingWithDefault());
                 }
             }
         } catch (HTMLParseException e) {
             // Don't break the world just because this failed:
             res.addSubResult(errorResult(e, new HTTPSampleResult(res)));
             setParentSampleSuccess(res, false);
         }
 
         // Iterate through the URLs and download each image:
         if (urls != null && urls.hasNext()) {
             if (container == null) {
                 container = new HTTPSampleResult(res);
                 container.addRawSubResult(res);
             }
             res = container;
 
             // Get the URL matcher
             String re=getEmbeddedUrlRE();
             Perl5Matcher localMatcher = null;
             Pattern pattern = null;
             if (re.length()>0){
                 try {
                     pattern = JMeterUtils.getPattern(re);
                     localMatcher = JMeterUtils.getMatcher();// don't fetch unless pattern compiles
                 } catch (MalformedCachePatternException e) {
                     log.warn("Ignoring embedded URL match string: "+e.getMessage());
                 }
             }
             
             // For concurrent get resources
             final List<Callable<AsynSamplerResultHolder>> liste = new ArrayList<Callable<AsynSamplerResultHolder>>();
 
             while (urls.hasNext()) {
                 Object binURL = urls.next(); // See catch clause below
                 try {
                     URL url = (URL) binURL;
                     if (url == null) {
                         log.warn("Null URL detected (should not happen)");
                     } else {
