diff --git a/src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSamplerBase.java b/src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSamplerBase.java
index a7aeb606e..d657a3c25 100644
--- a/src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSamplerBase.java
+++ b/src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSamplerBase.java
@@ -1,1901 +1,1901 @@
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
         HTTPConstants.UNLOCK
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
-        res.setSampleLabel("Error: " + res.getSampleLabel());
+        res.setSampleLabel(res.getSampleLabel());
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
                         String urlstr = url.toString();
                         String urlStrEnc=encodeSpaces(urlstr);
                         if (!urlstr.equals(urlStrEnc)){// There were some spaces in the URL
                             try {
                                 url = new URL(urlStrEnc);
                             } catch (MalformedURLException e) {
                                 res.addSubResult(errorResult(new Exception(urlStrEnc + " is not a correct URI"), new HTTPSampleResult(res)));
                                 setParentSampleSuccess(res, false);
                                 continue;
                             }
                         }
                         // I don't think localMatcher can be null here, but check just in case
                         if (pattern != null && localMatcher != null && !localMatcher.matches(urlStrEnc, pattern)) {
                             continue; // we have a pattern and the URL does not match, so skip it
                         }
                         
                         if (isConcurrentDwn()) {
                             // if concurrent download emb. resources, add to a list for async gets later
                             liste.add(new ASyncSample(url, HTTPConstants.GET, false, frameDepth + 1, getCookieManager(), this));
                         } else {
                             // default: serial download embedded resources
                             HTTPSampleResult binRes = sample(url, HTTPConstants.GET, false, frameDepth + 1);
                             res.addSubResult(binRes);
                             setParentSampleSuccess(res, res.isSuccessful() && (binRes != null ? binRes.isSuccessful() : true));
                         }
 
                     }
                 } catch (ClassCastException e) { // TODO can this happen?
                     res.addSubResult(errorResult(new Exception(binURL + " is not a correct URI"), new HTTPSampleResult(res)));
                     setParentSampleSuccess(res, false);
                     continue;
                 }
             }
             // IF for download concurrent embedded resources
             if (isConcurrentDwn()) {
                 int poolSize = CONCURRENT_POOL_SIZE; // init with default value
                 try {
                     poolSize = Integer.parseInt(getConcurrentPool());
                 } catch (NumberFormatException nfe) {
                     log.warn("Concurrent download resources selected, "// $NON-NLS-1$
                             + "but pool size value is bad. Use default value");// $NON-NLS-1$
                 }
                 // Thread pool Executor to get resources 
                 // use a LinkedBlockingQueue, note: max pool size doesn't effect
                 final ThreadPoolExecutor exec = new ThreadPoolExecutor(
                         poolSize, poolSize, KEEPALIVETIME, TimeUnit.SECONDS,
                         new LinkedBlockingQueue<Runnable>(),
                         new ThreadFactory() {
                             @Override
                             public Thread newThread(final Runnable r) {
                                 Thread t = new CleanerThread(new Runnable() {
                                     @Override
                                     public void run() {
                                         try {
                                             r.run();
                                         } finally {
                                             ((CleanerThread)Thread.currentThread()).notifyThreadEnd();
                                         }
                                     }
                                 });
                                 return t;
                             }
                         });
 
                 boolean tasksCompleted = false;
                 try {
                     // sample all resources with threadpool
                     final List<Future<AsynSamplerResultHolder>> retExec = exec.invokeAll(liste);
                     // call normal shutdown (wait ending all tasks)
                     exec.shutdown();
                     // put a timeout if tasks couldn't terminate
                     exec.awaitTermination(AWAIT_TERMINATION_TIMEOUT, TimeUnit.SECONDS);
                     CookieManager cookieManager = getCookieManager();
                     // add result to main sampleResult
                     for (Future<AsynSamplerResultHolder> future : retExec) {
                         AsynSamplerResultHolder binRes;
                         try {
                             binRes = future.get(1, TimeUnit.MILLISECONDS);
                             if(cookieManager != null) {
                                 CollectionProperty cookies = binRes.getCookies();
                                 PropertyIterator iter = cookies.iterator();
                                 while (iter.hasNext()) {
                                     Cookie cookie = (Cookie) iter.next().getObjectValue();
                                     cookieManager.add(cookie) ;
                                 }
                             }
                             res.addSubResult(binRes.getResult());
                             setParentSampleSuccess(res, res.isSuccessful() && (binRes.getResult() != null ? binRes.getResult().isSuccessful():true));
                         } catch (TimeoutException e) {
                             errorResult(e, res);
                         }
                     }
                     tasksCompleted = exec.awaitTermination(1, TimeUnit.MILLISECONDS); // did all the tasks finish?
                 } catch (InterruptedException ie) {
                     log.warn("Interruped fetching embedded resources", ie); // $NON-NLS-1$
                 } catch (ExecutionException ee) {
                     log.warn("Execution issue when fetching embedded resources", ee); // $NON-NLS-1$
                 } finally {
                     if (!tasksCompleted) {
                         exec.shutdownNow(); // kill any remaining tasks
                     }
                 }
             }
         }
         return res;
     }
     
     /**
      * Extract User-Agent header value
      * @param sampleResult HTTPSampleResult
      * @return User Agent part
      */
     private String getUserAgent(HTTPSampleResult sampleResult) {
         String res = sampleResult.getRequestHeaders();
         int index = res.indexOf(USER_AGENT);
         if(index >=0) {
             // see HTTPHC3Impl#getConnectionHeaders
             // see HTTPHC4Impl#getConnectionHeaders
             // see HTTPJavaImpl#getConnectionHeaders    
             //': ' is used by JMeter to fill-in requestHeaders, see getConnectionHeaders
             final String userAgentPrefix = USER_AGENT+": ";
             String userAgentHdr = res.substring(
                     index+userAgentPrefix.length(), 
                     res.indexOf('\n',// '\n' is used by JMeter to fill-in requestHeaders, see getConnectionHeaders
                             index+userAgentPrefix.length()+1));
             return userAgentHdr.trim();
         } else {
             if(log.isInfoEnabled()) {
                 log.info("No user agent extracted from requestHeaders:"+res);
             }
             return null;
         }
     }
 
     /**
      * Set parent successful attribute based on IGNORE_FAILED_EMBEDDED_RESOURCES parameter
      * @param res {@link HTTPSampleResult}
      * @param initialValue boolean
      */
     private void setParentSampleSuccess(HTTPSampleResult res, boolean initialValue) {
         if(!IGNORE_FAILED_EMBEDDED_RESOURCES) {
             res.setSuccessful(initialValue);
         }
     }
 
     /*
      * @param res HTTPSampleResult to check
      * @return parser class name (may be "") or null if entry does not exist
      */
     private String getParserClass(HTTPSampleResult res) {
         final String ct = res.getMediaType();
         return parsersForType.get(ct);
     }
 
     // TODO: make static?
     protected String encodeSpaces(String path) {
         return JOrphanUtils.replaceAllChars(path, ' ', "%20"); // $NON-NLS-1$
     }
 
     /**
      * {@inheritDoc}
      */
     @Override
     public void testEnded() {
     }
 
     /**
      * {@inheritDoc}
      */
     @Override
     public void testEnded(String host) {
         testEnded();
     }
 
     /**
      * {@inheritDoc}
      */
     @Override
     public void testStarted() {
     }
 
     /**
      * {@inheritDoc}
      */
     @Override
     public void testStarted(String host) {
         testStarted();
     }
 
     /**
      * {@inheritDoc}
      */
     @Override
     public Object clone() {
         HTTPSamplerBase base = (HTTPSamplerBase) super.clone();
         return base;
     }
 
     /**
      * Iteratively download the redirect targets of a redirect response.
      * <p>
      * The returned result will contain one subsample for each request issued,
      * including the original one that was passed in. It will be an
      * HTTPSampleResult that should mostly look as if the final destination of
      * the redirect chain had been obtained in a single shot.
      *
      * @param res
      *            result of the initial request - must be a redirect response
      * @param frameDepth
      *            Depth of this target in the frame structure. Used only to
      *            prevent infinite recursion.
      * @return "Container" result with one subsample per request issued
      */
     protected HTTPSampleResult followRedirects(HTTPSampleResult res, int frameDepth) {
         HTTPSampleResult totalRes = new HTTPSampleResult(res);
         totalRes.addRawSubResult(res);
         HTTPSampleResult lastRes = res;
 
         int redirect;
         for (redirect = 0; redirect < MAX_REDIRECTS; redirect++) {
             boolean invalidRedirectUrl = false;
             String location = lastRes.getRedirectLocation(); 
             if (log.isDebugEnabled()) {
                 log.debug("Initial location: " + location);
             }
             if (REMOVESLASHDOTDOT) {
                 location = ConversionUtils.removeSlashDotDot(location);
             }
             // Browsers seem to tolerate Location headers with spaces,
             // replacing them automatically with %20. We want to emulate
             // this behaviour.
             location = encodeSpaces(location);
             if (log.isDebugEnabled()) {
                 log.debug("Location after /. and space transforms: " + location);
             }
             // Change all but HEAD into GET (Bug 55450)
             String method = lastRes.getHTTPMethod();
             if (!HTTPConstants.HEAD.equalsIgnoreCase(method)) {
                 method = HTTPConstants.GET;
             }
             try {
                 URL url = ConversionUtils.makeRelativeURL(lastRes.getURL(), location);
                 url = ConversionUtils.sanitizeUrl(url).toURL();
                 if (log.isDebugEnabled()) {
                     log.debug("Location as URL: " + url.toString());
                 }
                 HTTPSampleResult tempRes = sample(url, method, true, frameDepth);
                 if(tempRes != null) {
                     lastRes = tempRes;
                 } else {
                     // Last url was in cache so tempRes is null
                     break;
                 }
             } catch (MalformedURLException e) {
                 errorResult(e, lastRes);
                 // The redirect URL we got was not a valid URL
                 invalidRedirectUrl = true;
             } catch (URISyntaxException e) {
                 errorResult(e, lastRes);
                 // The redirect URL we got was not a valid URL
                 invalidRedirectUrl = true;
             }
             if (lastRes.getSubResults() != null && lastRes.getSubResults().length > 0) {
                 SampleResult[] subs = lastRes.getSubResults();
                 for (int i = 0; i < subs.length; i++) {
                     totalRes.addSubResult(subs[i]);
                 }
             } else {
                 // Only add sample if it is a sample of valid url redirect, i.e. that
                 // we have actually sampled the URL
                 if(!invalidRedirectUrl) {
                     totalRes.addSubResult(lastRes);
                 }
             }
 
             if (!lastRes.isRedirect()) {
                 break;
             }
         }
         if (redirect >= MAX_REDIRECTS) {
             lastRes = errorResult(new IOException("Exceeeded maximum number of redirects: " + MAX_REDIRECTS), new HTTPSampleResult(lastRes));
             totalRes.addSubResult(lastRes);
         }
 
         // Now populate the any totalRes fields that need to
         // come from lastRes:
         totalRes.setSampleLabel(totalRes.getSampleLabel() + "->" + lastRes.getSampleLabel());
         // The following three can be discussed: should they be from the
         // first request or from the final one? I chose to do it this way
         // because that's what browsers do: they show the final URL of the
         // redirect chain in the location field.
         totalRes.setURL(lastRes.getURL());
         totalRes.setHTTPMethod(lastRes.getHTTPMethod());
         totalRes.setQueryString(lastRes.getQueryString());
         totalRes.setRequestHeaders(lastRes.getRequestHeaders());
 
         totalRes.setResponseData(lastRes.getResponseData());
         totalRes.setResponseCode(lastRes.getResponseCode());
         totalRes.setSuccessful(lastRes.isSuccessful());
         totalRes.setResponseMessage(lastRes.getResponseMessage());
         totalRes.setDataType(lastRes.getDataType());
         totalRes.setResponseHeaders(lastRes.getResponseHeaders());
         totalRes.setContentType(lastRes.getContentType());
         totalRes.setDataEncoding(lastRes.getDataEncodingNoDefault());
         return totalRes;
     }
 
     /**
      * Follow redirects and download page resources if appropriate. this works,
      * but the container stuff here is what's doing it. followRedirects() is
      * actually doing the work to make sure we have only one container to make
      * this work more naturally, I think this method - sample() - needs to take
      * an HTTPSamplerResult container parameter instead of a
      * boolean:areFollowingRedirect.
      *
      * @param areFollowingRedirect flag whether we are getting a redirect target
      * @param frameDepth Depth of this target in the frame structure. Used only to prevent infinite recursion.
      * @param res sample result to process
      * @return the sample result
      */
     protected HTTPSampleResult resultProcessing(boolean areFollowingRedirect, int frameDepth, HTTPSampleResult res) {
         boolean wasRedirected = false;
         if (!areFollowingRedirect) {
             if (res.isRedirect()) {
                 log.debug("Location set to - " + res.getRedirectLocation());
 
                 if (getFollowRedirects()) {
                     res = followRedirects(res, frameDepth);
                     areFollowingRedirect = true;
                     wasRedirected = true;
                 }
             }
         }
         if (isImageParser() && (SampleResult.TEXT).equals(res.getDataType()) && res.isSuccessful()) {
             if (frameDepth > MAX_FRAME_DEPTH) {
                 res.addSubResult(errorResult(new Exception("Maximum frame/iframe nesting depth exceeded."), new HTTPSampleResult(res)));
             } else {
                 // Only download page resources if we were not redirected.
                 // If we were redirected, the page resources have already been
                 // downloaded for the sample made for the redirected url
                 // otherwise, use null so the container is created if necessary unless
                 // the flag is false, in which case revert to broken 2.1 behaviour 
                 // Bug 51939 -  https://issues.apache.org/bugzilla/show_bug.cgi?id=51939
                 if(!wasRedirected) {
                     HTTPSampleResult container = (HTTPSampleResult) (
                             areFollowingRedirect ? res.getParent() : SEPARATE_CONTAINER ? null : res);
                     res = downloadPageResources(res, container, frameDepth);
                 }
             }
         }
         return res;
     }
 
     /**
      * Determine if the HTTP status code is successful or not
      * i.e. in range 200 to 399 inclusive
      *
      * @param code status code to check
      * @return whether in range 200-399 or not
      */
     protected boolean isSuccessCode(int code){
         return (code >= 200 && code <= 399);
     }
 
     protected static String encodeBackSlashes(String value) {
         StringBuilder newValue = new StringBuilder();
         for (int i = 0; i < value.length(); i++) {
             char charAt = value.charAt(i);
             if (charAt == '\\') { // $NON-NLS-1$
                 newValue.append("\\\\"); // $NON-NLS-1$
             } else {
                 newValue.append(charAt);
             }
         }
         return newValue.toString();
     }
 
     /*
      * Method to set files list to be uploaded.
      *
      * @param value
      *   HTTPFileArgs object that stores file list to be uploaded.
      */
     private void setHTTPFileArgs(HTTPFileArgs value) {
         if (value.getHTTPFileArgCount() > 0){
             setProperty(new TestElementProperty(FILE_ARGS, value));
         } else {
             removeProperty(FILE_ARGS); // no point saving an empty list
         }
     }
 
     /*
      * Method to get files list to be uploaded.
      */
     private HTTPFileArgs getHTTPFileArgs() {
         return (HTTPFileArgs) getProperty(FILE_ARGS).getObjectValue();
     }
 
     /**
      * Get the collection of files as a list.
      * The list is built up from the filename/filefield/mimetype properties,
      * plus any additional entries saved in the FILE_ARGS property.
      *
      * If there are no valid file entries, then an empty list is returned.
      *
      * @return an array of file arguments (never null)
      */
     public HTTPFileArg[] getHTTPFiles() {
         final HTTPFileArgs fileArgs = getHTTPFileArgs();
         return fileArgs == null ? new HTTPFileArg[] {} : fileArgs.asArray();
     }
 
     public int getHTTPFileCount(){
         return getHTTPFiles().length;
     }
     /**
      * Saves the list of files.
      * The first file is saved in the Filename/field/mimetype properties.
      * Any additional files are saved in the FILE_ARGS array.
      *
      * @param files list of files to save
      */
     public void setHTTPFiles(HTTPFileArg[] files) {
         HTTPFileArgs fileArgs = new HTTPFileArgs();
         // Weed out the empty files
         if (files.length > 0) {
             for(int i=0; i < files.length; i++){
                 HTTPFileArg file = files[i];
                 if (file.isNotEmpty()){
                     fileArgs.addHTTPFileArg(file);
                 }
             }
         }
         setHTTPFileArgs(fileArgs);
     }
 
     public static String[] getValidMethodsAsArray(){
         return METHODLIST.toArray(new String[METHODLIST.size()]);
     }
 
     public static boolean isSecure(String protocol){
         return HTTPConstants.PROTOCOL_HTTPS.equalsIgnoreCase(protocol);
     }
 
     public static boolean isSecure(URL url){
         return isSecure(url.getProtocol());
     }
 
     // Implement these here, to avoid re-implementing for sub-classes
     // (previously these were implemented in all TestElements)
     @Override
     public void threadStarted(){
     }
 
     @Override
     public void threadFinished(){
     }
 
     @Override
     public void testIterationStart(LoopIterationEvent event) {
         // NOOP to provide based empty impl and avoid breaking existing implementations
     }
 
     /**
      * Read response from the input stream, converting to MD5 digest if the useMD5 property is set.
      * <p>
      * For the MD5 case, the result byte count is set to the size of the original response.
      * <p>
      * Closes the inputStream 
      * 
      * @param sampleResult sample to store information about the response into
      * @param in input stream from which to read the response
      * @param length expected input length or zero
      * @return the response or the MD5 of the response
      * @throws IOException if reading the result fails
      */
     public byte[] readResponse(SampleResult sampleResult, InputStream in, int length) throws IOException {
         try {
             byte[] readBuffer = new byte[8192]; // 8kB is the (max) size to have the latency ('the first packet')
             int bufferSize=32;// Enough for MD5
     
             MessageDigest md=null;
             boolean asMD5 = useMD5();
             if (asMD5) {
                 try {
                     md = MessageDigest.getInstance("MD5"); //$NON-NLS-1$
                 } catch (NoSuchAlgorithmException e) {
                     log.error("Should not happen - could not find MD5 digest", e);
                     asMD5=false;
                 }
             } else {
                 if (length <= 0) {// may also happen if long value > int.max
                     bufferSize = 4 * 1024;
                 } else {
                     bufferSize = length;
                 }
             }
             ByteArrayOutputStream w = new ByteArrayOutputStream(bufferSize);
             int bytesRead = 0;
             int totalBytes = 0;
             boolean first = true;
             while ((bytesRead = in.read(readBuffer)) > -1) {
                 if (first) {
                     sampleResult.latencyEnd();
                     first = false;
                 }
                 if (asMD5 && md != null) {
                     md.update(readBuffer, 0 , bytesRead);
                     totalBytes += bytesRead;
                 } else {
                     w.write(readBuffer, 0, bytesRead);
                 }
             }
             if (first){ // Bug 46838 - if there was no data, still need to set latency
                 sampleResult.latencyEnd();
             }
             in.close();
             w.flush();
             if (asMD5 && md != null) {
                 byte[] md5Result = md.digest();
                 w.write(JOrphanUtils.baToHexBytes(md5Result)); 
                 sampleResult.setBytes(totalBytes);
             }
             w.close();
             return w.toByteArray();
         } finally {
             IOUtils.closeQuietly(in);
         }
     }
 
     /**
      * JMeter 2.3.1 and earlier only had fields for one file on the GUI:
      * <ul>
      *   <li>FILE_NAME</li>
      *   <li>FILE_FIELD</li>
      *   <li>MIMETYPE</li>
      * </ul>
      * These were stored in their own individual properties.
      * <p>
      * Version 2.3.3 introduced a list of files, each with their own path, name and mimetype.
      * <p>
      * In order to maintain backwards compatibility of test plans, the 3 original properties
      * were retained; additional file entries are stored in an HTTPFileArgs class.
      * The HTTPFileArgs class was only present if there is more than 1 file; this means that
      * such test plans are backward compatible.
      * <p>
      * Versions after 2.3.4 dispense with the original set of 3 properties.
      * Test plans that use them are converted to use a single HTTPFileArgs list.
      *
      * @see HTTPSamplerBaseConverter
      */
     void mergeFileProperties() {
         JMeterProperty fileName = getProperty(FILE_NAME);
         JMeterProperty paramName = getProperty(FILE_FIELD);
         JMeterProperty mimeType = getProperty(MIMETYPE);
         HTTPFileArg oldStyleFile = new HTTPFileArg(fileName, paramName, mimeType);
 
         HTTPFileArgs fileArgs = getHTTPFileArgs();
 
         HTTPFileArgs allFileArgs = new HTTPFileArgs();
         if(oldStyleFile.isNotEmpty()) { // OK, we have an old-style file definition
             allFileArgs.addHTTPFileArg(oldStyleFile); // save it
             // Now deal with any additional file arguments
             if(fileArgs != null) {
                 HTTPFileArg[] infiles = fileArgs.asArray();
                 for (int i = 0; i < infiles.length; i++){
                     allFileArgs.addHTTPFileArg(infiles[i]);
                 }
             }
         } else {
             if(fileArgs != null) { // for new test plans that don't have FILE/PARAM/MIME properties
                 allFileArgs = fileArgs;
             }
         }
         // Updated the property lists
         setHTTPFileArgs(allFileArgs);
         removeProperty(FILE_FIELD);
         removeProperty(FILE_NAME);
         removeProperty(MIMETYPE);
     }
 
     /**
      * set IP source to use - does not apply to Java HTTP implementation currently
      *
      * @param value IP source to use
      */
     public void setIpSource(String value) {
         setProperty(IP_SOURCE, value, "");
     }
 
     /**
      * get IP source to use - does not apply to Java HTTP implementation currently
      *
      * @return IP source to use
      */
     public String getIpSource() {
         return getPropertyAsString(IP_SOURCE,"");
     }
  
     /**
      * set IP/address source type to use
      *
      * @param value type of the IP/address source
      */
     public void setIpSourceType(int value) {
         setProperty(IP_SOURCE_TYPE, value, SOURCE_TYPE_DEFAULT);
     }
 
     /**
      * get IP/address source type to use
      * 
      * @return address source type
      */
     public int getIpSourceType() {
         return getPropertyAsInt(IP_SOURCE_TYPE, SOURCE_TYPE_DEFAULT);
     }
 
     /**
      * Return if used a concurrent thread pool to get embedded resources.
      *
      * @return true if used
      */
     public boolean isConcurrentDwn() {
         return getPropertyAsBoolean(CONCURRENT_DWN, false);
     }
 
     public void setConcurrentDwn(boolean concurrentDwn) {
         setProperty(CONCURRENT_DWN, concurrentDwn, false);
     }
 
     /**
      * Get the pool size for concurrent thread pool to get embedded resources.
      *
      * @return the pool size
      */
     public String getConcurrentPool() {
         return getPropertyAsString(CONCURRENT_POOL,CONCURRENT_POOL_DEFAULT);
     }
 
     public void setConcurrentPool(String poolSize) {
         setProperty(CONCURRENT_POOL, poolSize, CONCURRENT_POOL_DEFAULT);
     }
 
     
     /**
      * Callable class to sample asynchronously resources embedded
      *
      */
     private static class ASyncSample implements Callable<AsynSamplerResultHolder> {
         final private URL url;
         final private String method;
         final private boolean areFollowingRedirect;
         final private int depth;
         private final HTTPSamplerBase sampler;
         private final JMeterContext jmeterContextOfParentThread;
 
         ASyncSample(URL url, String method,
                 boolean areFollowingRedirect, int depth,  CookieManager cookieManager, HTTPSamplerBase base){
             this.url = url;
             this.method = method;
diff --git a/xdocs/changes.xml b/xdocs/changes.xml
index ebaa3c78c..fab4866e2 100644
--- a/xdocs/changes.xml
+++ b/xdocs/changes.xml
@@ -1,276 +1,277 @@
 <?xml version="1.0"?> 
 <!--
    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at
  
        http://www.apache.org/licenses/LICENSE-2.0
  
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 -->
 <document>   
 <properties>     
     <author email="dev AT jmeter.apache.org">JMeter developers</author>     
     <title>Changes</title>   
 </properties> 
 <body> 
 <section name="Changes"> 
 <style type="text/css"><!--
 h2 { color: #960000; }
 h3 { color: #960000; }
 --></style>
 <note>
 <b>This page details the changes made in the current version only.</b>
 <br></br>
 Earlier changes are detailed in the <a href="changes_history.html">History of Previous Changes</a>.
 </note>
 
 
 <!--  =================== 2.13 =================== -->
 
 <h1>Version 2.13</h1>
 
 Summary
 <ul>
 <li><a href="#New and Noteworthy">New and Noteworthy</a></li>
 <li><a href="#Known bugs">Known bugs</a></li>
 <li><a href="#Incompatible changes">Incompatible changes</a></li>
 <li><a href="#Bug fixes">Bug fixes</a></li>
 <li><a href="#Improvements">Improvements</a></li>
 <li><a href="#Non-functional changes">Non-functional changes</a></li>
 <li><a href="#Thanks">Thanks</a></li>
 
 </ul>
 
 <ch_section>New and Noteworthy</ch_section>
 
 <!-- <ch_category>Improvements</ch_category> -->
 <!-- <ch_title>Sample title</ch_title>
 <p>
 <ul>
 <li><bugzilla>48799</bugzilla> - Add time to establish connection to available sample metrics. Implemented by Andrey Pokhilko (andrey at blazemeter.com) and contributed by BlazeMeter Ltd.</li>
 <li><bugzilla>57500</bugzilla> - Introduce retry behavior for distributed testing. Implemented by Andrey Pokhilko and Dzimitry Kashlach and contributed by BlazeMeter Ltd.</li>
 <li>Sample text</li>
 </ul>
 </p>
 
 <ch_title>Sample title</ch_title>
 <p>Sample text</p>
 <figure width="691" height="215" image="changes/2.10/18_https_test_script_recorder.png"></figure>
  -->
 
 <!--  =================== Known bugs =================== -->
 
 
 <ch_section>Known bugs</ch_section>
 
 <ul>
 <li>The Once Only controller behaves correctly under a Thread Group or Loop Controller,
 but otherwise its behaviour is not consistent (or clearly specified).</li>
 
 <li>
 The numbers that appear to the left of the green box are the number of active threads / total number of threads, 
 the total number of threads only applies to a locally run test, otherwise it will show 0 (see <bugzilla>55510</bugzilla>).
 </li>
 
 <li>
 Note that there is a <a href="http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6396599 ">bug in Java</a>
 on some Linux systems that manifests itself as the following error when running the test cases or JMeter itself:
 <pre>
  [java] WARNING: Couldn't flush user prefs:
  java.util.prefs.BackingStoreException:
  java.lang.IllegalArgumentException: Not supported: indent-number
 </pre>
 This does not affect JMeter operation. This issue is fixed since Java 7b05.
 </li>
 
 <li>
 Note that under some windows systems you may have this WARNING:
 <pre>
 java.util.prefs.WindowsPreferences 
 WARNING: Could not open/create prefs root node Software\JavaSoft\Prefs at root 0
 x80000002. Windows RegCreateKeyEx(...) returned error code 5.
 </pre>
 The fix is to run JMeter as Administrator, it will create the registry key for you, then you can restart JMeter as a normal user and you won't have the warning anymore.
 </li>
 
 <li>
 With Java 1.6 and Gnome 3 on Linux systems, the JMeter menu may not work correctly (shift between mouse's click and the menu). 
 This is a known Java bug (see  <bugzilla>54477</bugzilla>). 
 A workaround is to use a Java 7 runtime (OpenJDK or Oracle JDK).
 </li>
 
 <li>
 With Oracle Java 7 and Mac Book Pro Retina Display, the JMeter GUI may look blurry. 
 This is a known Java bug, see Bug <a href="http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=8000629" >JDK-8000629</a>.
 A workaround is to use a Java 7 update 40 runtime which fixes this issue.
 </li>
 
 <li>
 You may encounter the following error: <i>java.security.cert.CertificateException: Certificates does not conform to algorithm constraints</i>
  if you run a HTTPS request on a web site with a SSL certificate (itself or one of SSL certificates in its chain of trust) with a signature
  algorithm using MD2 (like md2WithRSAEncryption) or with a SSL certificate with a size lower than 1024 bits.
 This error is related to increased security in Java 7 version u16 (MD2) and version u40 (Certificate size lower than 1024 bits), and Java 8 too.
 <br></br>
 To allow you to perform your HTTPS request, you can downgrade the security of your Java installation by editing 
 the Java <b>jdk.certpath.disabledAlgorithms</b> property. Remove the MD2 value or the constraint on size, depending on your case.
 <br></br>
 This property is in this file:
 <pre>JAVA_HOME/jre/lib/security/java.security</pre>
 See  <bugzilla>56357</bugzilla> for details.
 </li>
 
 </ul>
 
 <!-- =================== Incompatible changes =================== -->
 
 <ch_section>Incompatible changes</ch_section>
 
 <ul>
     <li>Since 2.13, Aggregate Graph, Summary Report and Aggregate Report now export percentages to %, before they exported the decimal value which differed from what was shown in GUI</li>
     <li>Third party plugins may be impacted by fix of <bugzilla>57586</bugzilla>, ensure that your subclass of HttpTestSampleGui implements ItemListener if you relied on parent class doing so.</li>
 </ul>
 
 <!-- =================== Bug fixes =================== -->
 
 <ch_section>Bug fixes</ch_section>
 
 <h3>HTTP Samplers and Test Script Recorder</h3>
 <ul>
 <li><bug>57385</bug>Getting empty thread name in xml result for HTTP requests with "Follow Redirects" set. Contributed by Ubik Load Pack (support at ubikloadpack.com)</li>
 <li><bug>57579</bug>NullPointerException error is raised on main sample if "RETURN_NO_SAMPLE" is used (default) and "Use Cache-Control / Expires header..." is checked in HTTP Cache Manager</li>
 </ul>
 
 <h3>Other Samplers</h3>
 <ul>
 </ul>
 
 <h3>Controllers</h3>
 <ul>
 <li><bug>57447</bug>Use only the user listed DNS Servers, when "use custom DNS resolver" option is enabled.</li>
 </ul>
 
 <h3>Listeners</h3>
 <ul>
 <li><bug>57262</bug>Aggregate Report, Aggregate Graph and Summary Report export : headers use keys instead of labels</li>
 <li><bug>57346</bug>Summariser : The + (difference) reports show wrong elapsed time and throughput</li>
 <li><bug>57449</bug>Distributed Testing: Stripped modes do not strip responses from SubResults (affects load tests that use Download of embedded resources). Contributed by Ubik Load Pack (support at ubikloadpack.com)</li>
 <li><bug>57562</bug>View Results Tree CSS/JQuery Tester : Nothing happens when there is an error in syntax and an exception occurs in jmeter.log</li>
 <li><bug>57514</bug>Aggregate Graph, Summary Report and Aggregate Report show wrong percentage reporting in saved file</li>
 </ul>
 
 <h3>Timers, Assertions, Config, Pre- &amp; Post-Processors</h3>
 <ul>
 </ul>
 
 <h3>Functions</h3>
 <ul>
 </ul>
 
 <h3>I18N</h3>
 <ul>
 </ul>
 
 <h3>General</h3>
 <ul>
 <li><bug>57365</bug>Selected LAF is not correctly setup due to call of UIManager.setLookAndFeel too late. Contributed by Ubik Load Pack (support at ubikloadpack.com)</li>
 <li><bug>57364</bug>Options &lt; Look And Feel does not update all windows LAF. Contributed by Ubik Load Pack (support at ubikloadpack.com)</li>
 <li><bug>57394</bug>When constructing an instance with ClassTools#construct(String, int) the integer was ignored and the default constructor was used instead.</li>
 <li><bug>57440</bug>OutOfMemoryError after introduction of JSyntaxTextArea in LoggerPanel due to disableUndo not being taken into account.</li>
 <li><bug>57569</bug>FileServer.reserveFile - inconsistent behaviour when hasHeader is true</li>
 <li><bug>57555</bug>Cannot use JMeter 2.12 as a maven dependency. Contributed by Pascal Schumacher (pascal.schumacher at t-systems.com)</li>
 </ul>
 
 <!-- =================== Improvements =================== -->
 
 <ch_section>Improvements</ch_section>
 
 <h3>HTTP Samplers and Test Script Recorder</h3>
 <ul>
 <li><bug>25430</bug>HTTP(S) Test Script Recorder : Make it populate HTTP Authorisation Manager. Partly based on a patch from Dzmitry Kashlach (dzmitrykashlach at gmail.com)</li>
 <li><bug>57381</bug>HTTP(S) Test Script Recorder should display an error if Target Controller references a Recording Controller and no Recording Controller exists. Contributed by Ubik Load Pack (support at ubikloadpack.com)</li>
 <li><bug>57488</bug>Performance : Improve SSLContext reset for Two-way SSL Authentication</li>
 <li><bug>57565</bug>SamplerCreator : Add method to allow implementations to add children to created sampler</li>
+<li><bug>57606</bug>HTTPSamplerBase#errorResult changes the sample label on exception </li>
 </ul>
 
 <h3>Other samplers</h3>
 <ul>
     <li><bug>57322</bug>JDBC Test elements: add ResultHandler to deal with ResultSets(cursors) returned by callable statements. Contributed by Yngvi &amp;THORN;&amp;oacute;r Sigurj&amp;oacute;nsson (blitzkopf at gmail.com)</li>
 </ul>
 
 <h3>Controllers</h3>
 <ul>
 <li><bug>57561</bug>Module controller UI : Replace combobox by tree. Contributed by Maciej Franek (maciej.franek at gmail.com)</li>
 </ul>
 
 <h3>Listeners</h3>
 <ul>
 <li><bug>55932</bug>Create a Async BackendListener to allow easy plug of new listener (Graphite, JDBC, Console,...)</li>
 <li><bug>57246</bug>BackendListener : Create a Graphite implementation</li>
 <li><bug>57217</bug>Aggregate graph and Aggregate report improvements (3 configurable percentiles, same data in both, factor out code). Contributed by Ubik Load Pack (support at ubikloadpack.com)</li>
 <li><bug>57537</bug>BackendListener : Allow implementations to drop samples</li>
 </ul>
 
 <h3>Timers, Assertions, Config, Pre- &amp; Post-Processors</h3>
 <ul>
 </ul>
 
 <h3>Functions</h3>
 <ul>
 <li><bug>54453</bug>Performance enhancements : Replace Random by ThreadLocalRandom in __Random function</li>
 </ul>
 
 <h3>I18N</h3>
 <ul>
 </ul>
 
 <h3>General</h3>
 <ul>
 <li><bug>57518</bug>Icons for toolbar with several sizes</li>
 </ul>
 <ch_section>Non-functional changes</ch_section>
 <ul>
 <li>Updated to jsoup-1.8.3.jar (from 1.7.3)</li>
 <li>Updated to tika-core and tika-parsers 1.7 (from 1.6)</li>
 <li><bug>57276</bug>RMIC no longer needed since Java 5</li>
 <li><bug>57310</bug>Replace System.getProperty("file.separator") with File.separator throughout (Also "path.separator" with File.pathSeparator)</li>
 <li><bug>57389</bug>Fix potential NPE in converters</li>
 <li><bug>57417</bug>Remove unused method isTemporary from NullProperty. This was a leftover from a refactoring done in 2003.</li>
 <li><bug>57418</bug>Remove unused constructor from Workbench</li>
 <li><bug>57419</bug>Remove unused interface ModelListener.</li>
 <li><bug>57466</bug>IncludeController : Remove an unneeded set creation. Contributed by Benoit Wiart (benoit.wiart at gmail.com)</li>
 <li>Added property loggerpanel.usejsyntaxtext to disable the use of JSyntaxTextArea for the Console Logger (in case of memory or other issues)</li>
 <li><bug>57586</bug>HttpTestSampleGui: Remove interface ItemListener implementation</li>
 </ul>
 
 <ch_section>Thanks</ch_section>
 <p>We thank all contributors mentioned in bug and improvement sections above:
 <ul>
 <li><a href="http://ubikloadpack.com">Ubik Load Pack</a></li>
 <li>Yngvi &amp;THORN;&amp;oacute;r Sigurj&amp;oacute;nsson (blitzkopf at gmail.com)</li>
 <li>Dzmitry Kashlach (dzmitrykashlach at gmail.com)</li>
 <li><a href="http://blazemeter.com">BlazeMeter Ltd.</a></li>
 <li>Benoit Wiart (benoit.wiart at gmail.com)</li>
 <li>Pascal Schumacher (pascal.schumacher at t-systems.com)</li>
 <li>Maciej Franek (maciej.franek at gmail.com)</li>
 </ul>
 
 <br/>
 We also thank bug reporters who helped us improve JMeter. <br/>
 For this release we want to give special thanks to the following reporters for the clear reports and tests made after our fixes:
 <ul>
 <li>Chaitanya Bhatt (bhatt.chaitanya@gmail.com) for his thorough testing of new BackendListener and Graphite Client implementation.</li>
 </ul>
 
 Apologies if we have omitted anyone else.
  </p>
 </section> 
 </body> 
 </document>