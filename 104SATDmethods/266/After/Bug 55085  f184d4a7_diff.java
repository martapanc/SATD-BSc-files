diff --git a/bin/jmeter.properties b/bin/jmeter.properties
index 14fed36de..acaf1912d 100644
--- a/bin/jmeter.properties
+++ b/bin/jmeter.properties
@@ -1,938 +1,942 @@
 ################################################################################
 # Apache JMeter Property file
 ################################################################################
 
 ##   Licensed to the Apache Software Foundation (ASF) under one or more
 ##   contributor license agreements.  See the NOTICE file distributed with
 ##   this work for additional information regarding copyright ownership.
 ##   The ASF licenses this file to You under the Apache License, Version 2.0
 ##   (the "License"); you may not use this file except in compliance with
 ##   the License.  You may obtain a copy of the License at
 ## 
 ##       http://www.apache.org/licenses/LICENSE-2.0
 ## 
 ##   Unless required by applicable law or agreed to in writing, software
 ##   distributed under the License is distributed on an "AS IS" BASIS,
 ##   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ##   See the License for the specific language governing permissions and
 ##   limitations under the License.
 
 
 #Preferred GUI language. Comment out to use the JVM default locale's language.
 #language=en
 
 # Additional locale(s) to add to the displayed list.
 # The current default list is: en, fr, de, no, es, tr, ja, zh_CN, zh_TW, pl, pt_BR
 # [see JMeterMenuBar#makeLanguageMenu()]
 # The entries are a comma-separated list of language names
 #locales.add=zu
 
 # Netscape HTTP Cookie file
 cookies=cookies
 
 #---------------------------------------------------------------------------
 # File format configuration for JMX and JTL files
 #---------------------------------------------------------------------------
 
 # Properties:
 # file_format          - affects both JMX and JTL files
 # file_format.testplan - affects JMX files only
 # file_format.testlog  - affects JTL files only
 #
 # Possible values are:
 # 2.1 - initial format using XStream
 # 2.2 - updated format using XStream, with shorter names
 
 # N.B. format 2.0 (Avalon) is no longer supported
 
 #---------------------------------------------------------------------------
 # XML Parser
 #---------------------------------------------------------------------------
 
 # XML Reader(Parser) - Must implement SAX 2 specs
 xml.parser=org.apache.xerces.parsers.SAXParser
 
 # Path to a Properties file containing Namespace mapping in the form
 # prefix=Namespace
 # Example:
 # ns=http://biz.aol.com/schema/2006-12-18
 #xpath.namespace.config=
 
 #---------------------------------------------------------------------------
 # SSL configuration
 #---------------------------------------------------------------------------
 
 ## SSL System properties are now in system.properties
 
 # JMeter no longer converts javax.xxx property entries in this file into System properties.
 # These must now be defined in the system.properties file or on the command-line.
 # The system.properties file gives more flexibility.
 
 # By default, SSL session contexts are now created per-thread, rather than being shared.
 # The original behaviour can be enabled by setting the JMeter property:
 #https.sessioncontext.shared=true
 
 # Default HTTPS protocol level:
 #https.default.protocol=TLS
 # This may need to be changed here (or in user.properties) to:
 #https.default.protocol=SSLv3
 
 # List of protocols to enable. You may have to select only a subset if you find issues with target server.
 # This is needed when server does not support Socket version negotiation, this can lead to:
 # javax.net.ssl.SSLPeerUnverifiedException: peer not authenticated
 # java.net.SocketException: Connection reset
 # see https://issues.apache.org/bugzilla/show_bug.cgi?id=54759
 #https.socket.protocols=SSLv2Hello SSLv3 TLSv1
 
 # Control if we allow reuse of cached SSL context between iterations
 # set the value to 'false' to reset the SSL context each iteration
 #https.use.cached.ssl.context=true
 
 # Start and end index to be used with keystores with many entries
 # The default is to use entry 0, i.e. the first
 #https.keyStoreStartIndex=0
 #https.keyStoreEndIndex=0
 
 #---------------------------------------------------------------------------
 # Look and Feel configuration
 #---------------------------------------------------------------------------
 
 #Classname of the Swing default UI
 #
 # The LAF classnames that are available are now displayed as ToolTip text
 # when hovering over the Options/Look and Feel selection list.
 #
 # You can either use a full class name, as shown above,
 # or one of the strings "System" or "CrossPlatform" which means
 #  JMeter will use the corresponding string returned by UIManager.get<name>LookAndFeelClassName()
 
 # LAF can be overridden by os.name (lowercased, spaces replaced by '_')
 # Sample os.name LAF:
 #jmeter.laf.windows_xp=javax.swing.plaf.metal.MetalLookAndFeel
 
 # Failing that, the OS family = os.name, but only up to first space:
 # Sample OS family LAF:
 #jmeter.laf.windows=com.sun.java.swing.plaf.windows.WindowsLookAndFeel
 
 # Mac apparently looks better with the System LAF
 jmeter.laf.mac=System
 
 # Failing that, the JMeter default laf can be defined:
 #jmeter.laf=System
 
 # If none of the above jmeter.laf properties are defined, JMeter uses the CrossPlatform LAF.
 # This is because the CrossPlatform LAF generally looks better than the System LAF.
 # See https://issues.apache.org/bugzilla/show_bug.cgi?id=52026 for details
 # N.B. the laf can be defined in user.properties.
 
 # LoggerPanel display
 # default to false
 #jmeter.loggerpanel.display=false
 
 # Error/Fatal Log count display
 # defaults to true
 #jmeter.errorscounter.display=true
 
 # Max characters kept in LoggerPanel, default to 80000 chars
 # O means no limit
 #jmeter.loggerpanel.maxlength=80000
 
 # Toolbar display
 # default:
 #jmeter.toolbar.display=true
 # Toolbar icon definitions
 #jmeter.toolbar.icons=org/apache/jmeter/images/toolbar/icons-toolbar.properties
 # Toolbar list
 #jmeter.toolbar=new,open,close,save,save_as_testplan,|,cut,copy,paste,|,expand,collapse,toggle,|,test_start,test_stop,test_shutdown,|,test_start_remote_all,test_stop_remote_all,test_shutdown_remote_all,|,test_clear,test_clear_all,|,search,search_reset,|,function_helper,help
 
 # Icon definitions
 # default:
 #jmeter.icons=org/apache/jmeter/images/icon.properties
 # alternate:
 #jmeter.icons=org/apache/jmeter/images/icon_1.properties
 
 #Components to not display in JMeter GUI (GUI class name or static label)
 # These elements are deprecated: HTML Parameter Mask,HTTP User Parameter Modifier, Webservice (SOAP) Request
 not_in_menu=org.apache.jmeter.protocol.http.modifier.gui.ParamModifierGui, HTTP User Parameter Modifier, org.apache.jmeter.protocol.http.control.gui.WebServiceSamplerGui
 
 #---------------------------------------------------------------------------
 # Remote hosts and RMI configuration
 #---------------------------------------------------------------------------
 
 # Remote Hosts - comma delimited
 remote_hosts=127.0.0.1
 #remote_hosts=localhost:1099,localhost:2010
 
 # RMI port to be used by the server (must start rmiregistry with same port)
 #server_port=1099
 
 # To change the port to (say) 1234:
 # On the server(s)
 # - set server_port=1234
 # - start rmiregistry with port 1234
 # On Windows this can be done by:
 # SET SERVER_PORT=1234
 # JMETER-SERVER
 #
 # On Unix:
 # SERVER_PORT=1234 jmeter-server
 #
 # On the client:
 # - set remote_hosts=server:1234
 
 # Parameter that controls the RMI port used by the RemoteSampleListenerImpl
 # Default value is 0 which means port is randomly assigned
 #client.rmi.localport=0
 
 # To change the default port (1099) used to access the server:
 #server.rmi.port=1234
 
 # To use a specific port for the JMeter server engine, define
 # the following property before starting the server:
 #server.rmi.localport=4000
 
 # From JMeter 2.3.1, the jmeter server creates the RMI registry as part of the server process.
 # To stop the server creating the RMI registry:
 #server.rmi.create=false
 
 # From JMeter 2.3.1, define the following property to cause JMeter to exit after the first test
 #server.exitaftertest=true
 
 # Prefix used by IncludeController when building file name
 #includecontroller.prefix=
 
 #---------------------------------------------------------------------------
 #         Logging Configuration
 #---------------------------------------------------------------------------
 
 # Note: JMeter uses Avalon (Excalibur) LogKit
 
 # Logging Format
 # see http://excalibur.apache.org/apidocs/org/apache/log/format/PatternFormatter.html
 
 #
 # Default format:
 #log_format=%{time:yyyy/MM/dd HH:mm:ss} %5.5{priority} - %{category}: %{message} %{throwable}
 # \n is automatically added to the end of the string
 #
 # Predefined formats in the JMeter LoggingManager:
 #log_format_type=default
 #log_format_type=thread_prefix
 #log_format_type=thread_suffix
 # default is as above
 # thread_prefix adds the thread name as a prefix to the category
 # thread_suffix adds the thread name as a suffix to the category
 # Note that thread name is not included by default, as it requires extra processing.
 #
 # To change the logging format, define either log_format_type or log_format
 # If both are defined, the type takes precedence
 # Note that these properties cannot be defined using the -J or -D JMeter
 # command-line flags, as the format will have already been determined by then
 # However, they can be defined as JVM properties
 
 #Logging levels for the logging categories in JMeter.  Correct values are FATAL_ERROR, ERROR, WARN, INFO, and DEBUG
 # To set the log level for a package or individual class, use:
 # log_level.[package_name].[classname]=[PRIORITY_LEVEL]
 # But omit "org.apache" from the package name.  The classname is optional.  Further examples below.
 
 log_level.jmeter=INFO
 log_level.jmeter.junit=DEBUG
 #log_level.jmeter.control=DEBUG
 #log_level.jmeter.testbeans=DEBUG
 #log_level.jmeter.engine=DEBUG
 #log_level.jmeter.threads=DEBUG
 #log_level.jmeter.gui=WARN
 #log_level.jmeter.testelement=DEBUG
 #log_level.jmeter.util=WARN
 #log_level.jmeter.util.classfinder=WARN
 #log_level.jmeter.test=DEBUG
 #log_level.jmeter.protocol.http=DEBUG
 # For CookieManager, AuthManager etc:
 #log_level.jmeter.protocol.http.control=DEBUG
 #log_level.jmeter.protocol.ftp=WARN
 #log_level.jmeter.protocol.jdbc=DEBUG
 #log_level.jmeter.protocol.java=WARN
 #log_level.jmeter.testelements.property=DEBUG
 log_level.jorphan=INFO
 	
 
 #Log file for log messages.
 # You can specify a different log file for different categories via:
 # log_file.[category]=[filename]
 # category is equivalent to the package/class names described above
 
 # Combined log file (for jmeter and jorphan)
 #log_file=jmeter.log
 # To redirect logging to standard output, try the following:
 # (it will probably report an error, but output will be to stdout)
 #log_file=
 
 # Or define separate logs if required:
 #log_file.jorphan=jorphan.log
 #log_file.jmeter=jmeter.log
 
 # If the filename contains  paired single-quotes, then the name is processed
 # as a SimpleDateFormat format applied to the current date, for example:
 #log_file='jmeter_'yyyyMMddHHmmss'.tmp'
 
 # N.B. When JMeter starts, it sets the system property:
 #    org.apache.commons.logging.Log
 # to
 #    org.apache.commons.logging.impl.LogKitLogger
 # if not already set. This causes Apache and Commons HttpClient to use the same logging as JMeter
 
 # Further logging configuration
 # Excalibur logging provides the facility to configure logging using
 # configuration files written in XML. This allows for such features as
 # log file rotation which are not supported directly by JMeter.
 #
 # If such a file specified, it will be applied to the current logging
 # hierarchy when that has been created.
 # 
 #log_config=logkit.xml
 
 #---------------------------------------------------------------------------
 # HTTP Java configuration
 #---------------------------------------------------------------------------
 
 # Number of connection retries performed by HTTP Java sampler before giving up
 #http.java.sampler.retries=10
 # 0 now means don't retry connection (in 2.3 and before it meant no tries at all!)
 
 #---------------------------------------------------------------------------
 # Commons HTTPClient configuration
 #---------------------------------------------------------------------------
 
 # define a properties file for overriding Commons HttpClient parameters
 # See: http://hc.apache.org/httpclient-3.x/preference-api.html
 #httpclient.parameters.file=httpclient.parameters
 
 
 # define a properties file for overriding Apache HttpClient parameters
 # See: TBA
 #hc.parameters.file=hc.parameters
 
 # Following properties apply to both Commons and Apache HttpClient
 
 # set the socket timeout (or use the parameter http.socket.timeout)
 # Value is in milliseconds
 #httpclient.timeout=0
 # 0 == no timeout
 
 # Set the http version (defaults to 1.1)
 #httpclient.version=1.0 (or use the parameter http.protocol.version)
 
 # Define characters per second > 0 to emulate slow connections
 #httpclient.socket.http.cps=0
 #httpclient.socket.https.cps=0
 
 #Enable loopback protocol
 #httpclient.loopback=true
 
 # Define the local host address to be used for multi-homed hosts
 #httpclient.localaddress=1.2.3.4
 
 #         Sample logging levels for Commons HttpClient
 #
 # Commons HttpClient Logging information can be found at:
 # http://hc.apache.org/httpclient-3.x/logging.html
 
 # Note that full category names are used, i.e. must include the org.apache.
 # Info level produces no output:
 #log_level.org.apache.commons.httpclient=debug
 # Might be useful:
 #log_level.org.apache.commons.httpclient.Authenticator=trace 
 
 # Show headers only
 #log_level.httpclient.wire.header=debug
 
 # Full wire debug produces a lot of output; consider using separate file:
 #log_level.httpclient.wire=debug
 #log_file.httpclient=httpclient.log
 
 
 #         Apache Commons HttpClient logging examples
 #
 # Enable header wire + context logging - Best for Debugging
 #log_level.org.apache.http=DEBUG
 #log_level.org.apache.http.wire=ERROR
 
 # Enable full wire + context logging
 #log_level.org.apache.http=DEBUG
 
 # Enable context logging for connection management
 #log_level.org.apache.http.impl.conn=DEBUG
 
 # Enable context logging for connection management / request execution
 #log_level.org.apache.http.impl.conn=DEBUG
 #log_level.org.apache.http.impl.client=DEBUG
 #log_level.org.apache.http.client=DEBUG
 
 #---------------------------------------------------------------------------
 # Apache HttpComponents HTTPClient configuration (HTTPClient4)
 #---------------------------------------------------------------------------
 
 # Number of retries to attempt (default 1)
 #httpclient4.retrycount=1
 
 # Number of retries to attempt (default 1)
 #httpclient3.retrycount=1
 
 #---------------------------------------------------------------------------
 # Results file configuration
 #---------------------------------------------------------------------------
 
 # This section helps determine how result data will be saved.
 # The commented out values are the defaults.
 
 # legitimate values: xml, csv, db.  Only xml and csv are currently supported.
 #jmeter.save.saveservice.output_format=csv
 
 
 # true when field should be saved; false otherwise
 
 # assertion_results_failure_message only affects CSV output
 #jmeter.save.saveservice.assertion_results_failure_message=false
 #
 # legitimate values: none, first, all
 #jmeter.save.saveservice.assertion_results=none
 #
 #jmeter.save.saveservice.data_type=true
 #jmeter.save.saveservice.label=true
 #jmeter.save.saveservice.response_code=true
 # response_data is not currently supported for CSV output
 #jmeter.save.saveservice.response_data=false
 # Save ResponseData for failed samples
 #jmeter.save.saveservice.response_data.on_error=false
 #jmeter.save.saveservice.response_message=true
 #jmeter.save.saveservice.successful=true
 #jmeter.save.saveservice.thread_name=true
 #jmeter.save.saveservice.time=true
 #jmeter.save.saveservice.subresults=true
 #jmeter.save.saveservice.assertions=true
 #jmeter.save.saveservice.latency=true
 #jmeter.save.saveservice.samplerData=false
 #jmeter.save.saveservice.responseHeaders=false
 #jmeter.save.saveservice.requestHeaders=false
 #jmeter.save.saveservice.encoding=false
 #jmeter.save.saveservice.bytes=true
 #jmeter.save.saveservice.url=false
 #jmeter.save.saveservice.filename=false
 #jmeter.save.saveservice.hostname=false
 #jmeter.save.saveservice.thread_counts=false
 #jmeter.save.saveservice.sample_count=false
 #jmeter.save.saveservice.idle_time=false
 
 # Timestamp format - this only affects CSV output files
 # legitimate values: none, ms, or a format suitable for SimpleDateFormat
 #jmeter.save.saveservice.timestamp_format=ms
 #jmeter.save.saveservice.timestamp_format=yyyy/MM/dd HH:mm:ss.SSS
 
 # For use with Comma-separated value (CSV) files or other formats
 # where the fields' values are separated by specified delimiters.
 # Default:
 #jmeter.save.saveservice.default_delimiter=,
 # For TAB, since JMeter 2.3 one can use:
 #jmeter.save.saveservice.default_delimiter=\t
 
 # Only applies to CSV format files:
 #jmeter.save.saveservice.print_field_names=false
 
 # Optional list of JMeter variable names whose values are to be saved in the result data files.
 # Use commas to separate the names. For example:
 #sample_variables=SESSION_ID,REFERENCE
 # N.B. The current implementation saves the values in XML as attributes,
 # so the names must be valid XML names.
 # Versions of JMeter after 2.3.2 send the variable to all servers
 # to ensure that the correct data is available at the client.
 
 # Optional xml processing instruction for line 2 of the file:
 #jmeter.save.saveservice.xml_pi=<?xml-stylesheet type="text/xsl" href="../extras/jmeter-results-detail-report_21.xsl"?>
 
 # Prefix used to identify filenames that are relative to the current base
 #jmeter.save.saveservice.base_prefix=~/
 
 # AutoFlush on each line written in XML or CSV output
 # Setting this to true will result in less test results data loss in case of Crash
 # but with impact on performances, particularly for intensive tests (low or no pauses)
 # Since JMeter 2.10, this is false by default
 #jmeter.save.saveservice.autoflush=false
 
 #---------------------------------------------------------------------------
 # Settings that affect SampleResults
 #---------------------------------------------------------------------------
 
 # Save the start time stamp instead of the end
 # This also affects the timestamp stored in result files
 sampleresult.timestamp.start=true
 
 # Whether to use System.nanoTime() - otherwise only use System.currentTimeMillis()
 #sampleresult.useNanoTime=true
 
 # Use a background thread to calculate the nanoTime offset
 # Set this to <= 0 to disable the background thread
 #sampleresult.nanoThreadSleep=5000
 
 #---------------------------------------------------------------------------
 # Upgrade property
 #---------------------------------------------------------------------------
 
 # File that holds a record of name changes for backward compatibility issues
 upgrade_properties=/bin/upgrade.properties
 
 #---------------------------------------------------------------------------
 # JMeter Proxy recorder configuration
 #---------------------------------------------------------------------------
 
 # If the proxy detects a gap of at least 1s (default) between HTTP requests,
 # it assumes that the user has clicked a new URL
 #proxy.pause=1000
 
 # Add numeric prefix to Sampler names (default false)
 #proxy.number.requests=true
 
 # List of URL patterns that will be added to URL Patterns to exclude in Proxy
 #proxy.excludes.suggested=.*\\.js;.*\\.css;.*\\.swf;.*\\.gif;.*\\.png;.*\\.jpg;.*\\.bmp
 
 # Change the default HTTP Sampler (currently HttpClient4)
 # Java:
 #jmeter.httpsampler=HTTPSampler
 #or
 #jmeter.httpsampler=Java
 #
 # Apache HTTPClient:
 #jmeter.httpsampler=HTTPSampler2
 #or
 #jmeter.httpsampler=HttpClient3.1
 #
 # HttpClient4.x
 #jmeter.httpsampler=HttpClient4
 
 # Default content-type include filter to use
 #proxy.content_type_include=text/html|text/plain|text/xml
 # Default content-type exclude filter to use
 #proxy.content_type_exclude=image/.*|text/css|application/.*
 
 # Default headers to remove from Header Manager elements
 # (Cookie and Authorization are always removed)
 #proxy.headers.remove=If-Modified-Since,If-None-Match,Host
 
 # Binary content-type handling
 # These content-types will be handled by saving the request in a file:
 #proxy.binary.types=application/x-amf,application/x-java-serialized-object
 # The files will be saved in this directory:
 #proxy.binary.directory=user.dir
 # The files will be created with this file filesuffix:
 #proxy.binary.filesuffix=.binary
 
 #---------------------------------------------------------------------------
 # JMeter Proxy configuration
 #---------------------------------------------------------------------------
 # use command-line flags for user-name and password
 #http.proxyDomain=NTLM domain, if required by HTTPClient sampler
 
 # SSL configuration
 #proxy.cert.directory=.
 #proxy.cert.file=proxyserver.jks
 #proxy.cert.type=JKS
 #proxy.cert.keystorepass=password
 #proxy.cert.keypassword=password
 #proxy.cert.factory=SunX509
 #proxy.ssl.protocol=SSLv3
 
 #---------------------------------------------------------------------------
 # HTTPSampleResponse Parser configuration
 #---------------------------------------------------------------------------
 
 # Space-separated list of parser groups
 HTTPResponse.parsers=htmlParser wmlParser
 # for each parser, there should be a parser.types and a parser.className property
 
 #---------------------------------------------------------------------------
 # HTML Parser configuration
 #---------------------------------------------------------------------------
 
 # Define the HTML parser to be used.
 # Default parser:
 #htmlParser.className=org.apache.jmeter.protocol.http.parser.HtmlParserHTMLParser
 # Other parsers:
 #htmlParser.className=org.apache.jmeter.protocol.http.parser.JTidyHTMLParser
 #htmlParser.className=org.apache.jmeter.protocol.http.parser.RegexpHTMLParser
 #
 
 htmlParser.types=text/html application/xhtml+xml application/xml text/xml
 
 #---------------------------------------------------------------------------
 # WML Parser configuration
 #---------------------------------------------------------------------------
 
 wmlParser.className=org.apache.jmeter.protocol.http.parser.RegexpHTMLParser
 
 wmlParser.types=text/vnd.wap.wml 
 
 #---------------------------------------------------------------------------
 # Remote batching configuration
 #---------------------------------------------------------------------------
 # How is Sample sender implementations configured:
 # - true (default) means client configuration will be used
 # - false means server configuration will be used
 #sample_sender_client_configured=true
 
 # Remote batching support
 # Since JMeter 2.9, default is MODE_STRIPPED_BATCH, which returns samples in
 # batch mode (every 100 samples or every minute by default)
 # Note also that MODE_STRIPPED_BATCH strips response data from SampleResult, so if you need it change to
 # another mode
 # Hold retains samples until end of test (may need lots of memory)
 # Batch returns samples in batches
 # Statistical returns sample summary statistics
 # hold_samples was originally defined as a separate property,
 # but can now also be defined using mode=Hold
 # mode can also be the class name of an implementation of org.apache.jmeter.samplers.SampleSender
 #mode=Standard
 #mode=Batch
 #mode=Hold
 #mode=Statistical
 #Set to true to key statistical samples on threadName rather than threadGroup
 #key_on_threadname=false
 #mode=Stripped
 #mode=StrippedBatch
 #mode=org.example.load.MySampleSender
 #hold_samples=true
 #
 #num_sample_threshold=100
 # Value is in milliseconds
 #time_threshold=60000
 #
 # Asynchronous sender; uses a queue and background worker process to return the samples
 #mode=Asynch
 # default queue size
 #asynch.batch.queue.size=100
 #
 # DiskStore: as for Hold mode, but serialises the samples to disk, rather than saving in memory
 #mode=DiskStore
 
 # Note: the mode is currently resolved on the client; 
 # other properties (e.g. time_threshold) are resolved on the server.
 
 # To set the Monitor Health Visualiser buffer size, enter the desired value
 # monitor.buffer.size=800
 
 #---------------------------------------------------------------------------
 # TCP Sampler configuration
 #---------------------------------------------------------------------------
 
 # The default handler class
 #tcp.handler=TCPClientImpl
 #
 # eolByte = byte value for end of line
 # set this to a value outside the range -128 to +127 to skip eol checking
 #tcp.eolByte=1000
 #
 # TCP Charset, used by org.apache.jmeter.protocol.tcp.sampler.TCPClientImpl
 # default to Platform defaults charset as returned by Charset.defaultCharset().name()
 #tcp.charset=
 #
 # status.prefix and suffix = strings that enclose the status response code
 #tcp.status.prefix=Status=
 #tcp.status.suffix=.
 #
 # status.properties = property file to convert codes to messages
 #tcp.status.properties=mytestfiles/tcpstatus.properties
 
 # The length prefix used by LengthPrefixedBinaryTCPClientImpl implementation
 # defaults to 2 bytes.
 #tcp.binarylength.prefix.length=2
 
 #---------------------------------------------------------------------------
 # Summariser - Generate Summary Results - configuration (mainly applies to non-GUI mode)
 #---------------------------------------------------------------------------
 #
 # Define the following property to automatically start a summariser with that name
 # (applies to non-GUI mode only)
 #summariser.name=summary
 #
 # interval between summaries (in seconds) default 3 minutes
 #summariser.interval=180
 #
 # Write messages to log file
 #summariser.log=true
 #
 # Write messages to System.out
 #summariser.out=true
 
 #---------------------------------------------------------------------------
 # BeanShell configuration
 #---------------------------------------------------------------------------
 
 # BeanShell Server properties
 #
 # Define the port number as non-zero to start the http server on that port
 #beanshell.server.port=9000
 # The telnet server will be started on the next port
 
 #
 # Define the server initialisation file
 beanshell.server.file=../extras/startup.bsh
 
 #
 # Define a file to be processed at startup
 # This is processed using its own interpreter.
 #beanshell.init.file=
 
 #
 # Define the intialisation files for BeanShell Sampler, Function and other BeanShell elements
 # N.B. Beanshell test elements do not share interpreters.
 #      Each element in each thread has its own interpreter.
 #      This is retained between samples.
 #beanshell.sampler.init=BeanShellSampler.bshrc
 #beanshell.function.init=BeanShellFunction.bshrc
 #beanshell.assertion.init=BeanShellAssertion.bshrc
 #beanshell.listener.init=etc
 #beanshell.postprocessor.init=etc
 #beanshell.preprocessor.init=etc
 #beanshell.timer.init=etc
 
 # The file BeanShellListeners.bshrc contains sample definitions
 # of Test and Thread Listeners.
 
 #---------------------------------------------------------------------------
 # MailerModel configuration
 #---------------------------------------------------------------------------
 
 # Number of successful samples before a message is sent
 #mailer.successlimit=2
 #
 # Number of failed samples before a message is sent
 #mailer.failurelimit=2
 
 #---------------------------------------------------------------------------
 # CSVRead configuration
 #---------------------------------------------------------------------------
 
 # CSVRead delimiter setting (default ",")
 # Make sure that there are no trailing spaces or tabs after the delimiter
 # characters, or these will be included in the list of valid delimiters
 #csvread.delimiter=,
 #csvread.delimiter=;
 #csvread.delimiter=!
 #csvread.delimiter=~
 # The following line has a tab after the =
 #csvread.delimiter=	
 
 #---------------------------------------------------------------------------
 # __time() function configuration
 #
 # The properties below can be used to redefine the default formats
 #---------------------------------------------------------------------------
 #time.YMD=yyyyMMdd
 #time.HMS=HHmmss
 #time.YMDHMS=yyyyMMdd-HHmmss
 #time.USER1=
 #time.USER2=
 
 #---------------------------------------------------------------------------
 # CSV DataSet configuration
 #---------------------------------------------------------------------------
 
 # String to return at EOF (if recycle not used)
 #csvdataset.eofstring=<EOF>
 
 #---------------------------------------------------------------------------
 # LDAP Sampler configuration
 #---------------------------------------------------------------------------
 # Maximum number of search results returned by a search that will be sorted
 # to guarantee a stable ordering (if more results then this limit are retruned
 # then no sorting is done). Set to 0 to turn off all sorting, in which case
 # "Equals" response assertions will be very likely to fail against search results.
 #
 #ldapsampler.max_sorted_results=1000
  
 # Number of characters to log for each of three sections (starting matching section, diff section,
 #   ending matching section where not all sections will appear for all diffs) diff display when an Equals
 #   assertion fails. So a value of 100 means a maximum of 300 characters of diff text will be displayed
 #   (+ a number of extra characters like "..." and "[[["/"]]]" which are used to decorate it).
 #assertion.equals_section_diff_len=100
 # test written out to log to signify start/end of diff delta
 #assertion.equals_diff_delta_start=[[[
 #assertion.equals_diff_delta_end=]]]
 
 #---------------------------------------------------------------------------
 # Miscellaneous configuration
 #---------------------------------------------------------------------------
 
 # If defined, then start the mirror server on the port
 #mirror.server.port=8081
 
 # ORO PatternCacheLRU size
 #oro.patterncache.size=1000
 
 #TestBeanGui
 #
 #propertyEditorSearchPath=null
 
 # Turn expert mode on/off: expert mode will show expert-mode beans and properties
 #jmeter.expertMode=true
 
 # Maximum redirects to follow in a single sequence (default 5)
 #httpsampler.max_redirects=5
 # Maximum frame/iframe nesting depth (default 5)
 #httpsampler.max_frame_depth=5
 # Maximum await termination timeout (secs) when concurrent download embedded resources (default 60)
 #httpsampler.await_termination_timeout=60
 # Revert to BUG 51939 behaviour (no separate container for embedded resources) by setting the following false:
 #httpsampler.separate.container=true
 
 # If embedded resources download fails due to missing resources or other reasons, if this property is true
 # Parent sample will not be marked as failed 
 #httpsampler.ignore_failed_embedded_resources=false
 
 # The encoding to be used if none is provided (default ISO-8859-1)
 #sampleresult.default.encoding=ISO-8859-1
 
 # Network response size calculation method
 # Use real size: number of bytes for response body return by webserver
 # (i.e. the network bytes received for response)
 # if set to false, the (uncompressed) response data size will used (default before 2.5)
 # Include headers: add the headers size in real size
 #sampleresult.getbytes.body_real_size=true
 #sampleresult.getbytes.headers_size=true
 
 # CookieManager behaviour - should cookies with null/empty values be deleted?
 # Default is true. Use false to revert to original behaviour
 #CookieManager.delete_null_cookies=true
 
 # CookieManager behaviour - should variable cookies be allowed?
 # Default is true. Use false to revert to original behaviour
 #CookieManager.allow_variable_cookies=true
 
 # CookieManager behaviour - should Cookies be stored as variables?
 # Default is false
 #CookieManager.save.cookies=false
 
 # CookieManager behaviour - prefix to add to cookie name before storing it as a variable
 # Default is COOKIE_; to remove the prefix, define it as one or more spaces
 #CookieManager.name.prefix=
  
 # CookieManager behaviour - check received cookies are valid before storing them?
 # Default is true. Use false to revert to previous behaviour
 #CookieManager.check.cookies=true
 
 # (2.0.3) JMeterThread behaviour has been changed to set the started flag before
 # the controllers are initialised. This is so controllers can access variables earlier. 
 # In case this causes problems, the previous behaviour can be restored by uncommenting
 # the following line.
 #jmeterthread.startearlier=false
 
 # (2.2.1) JMeterThread behaviour has changed so that PostProcessors are run in forward order
 # (as they appear in the test plan) rather than reverse order as previously.
 # Uncomment the following line to revert to the original behaviour
 #jmeterthread.reversePostProcessors=true
 
 # (2.2) StandardJMeterEngine behaviour has been changed to notify the listeners after
 # the running version is enabled. This is so they can access variables. 
 # In case this causes problems, the previous behaviour can be restored by uncommenting
 # the following line.
 #jmeterengine.startlistenerslater=false
 
 # Number of milliseconds to wait for a thread to stop
 #jmeterengine.threadstop.wait=5000
 
 #Whether to invoke System.exit(0) in server exit code after stopping RMI
 #jmeterengine.remote.system.exit=false
 
 # Whether to call System.exit(1) on failure to stop threads in non-GUI mode.
 # This only takes effect if the test was explictly requested to stop.
 # If this is disabled, it may be necessary to kill the JVM externally
 #jmeterengine.stopfail.system.exit=true
 
 # Whether to force call System.exit(0) at end of test in non-GUI mode, even if
 # there were no failures and the test was not explicitly asked to stop.
 # Without this, the JVM may never exit if there are other threads spawned by
 # the test which never exit.
 #jmeterengine.force.system.exit=false
 
 # How long to pause (in ms) in the daemon thread before reporting that the JVM has failed to exit.
 # If the value is <= 0, the JMeter does not start the daemon thread 
 #jmeter.exit.check.pause=2000
 
 # If running non-GUI, then JMeter listens on the following port for a shutdown message.
 # To disable, set the port to 1000 or less.
 #jmeterengine.nongui.port=4445
 #
 # If the initial port is busy, keep trying until this port is reached
 # (to disable searching, set the value less than or equal to the .port property)
 #jmeterengine.nongui.maxport=4455
 
 # How often to check for shutdown during ramp-up (milliseconds)
 #jmeterthread.rampup.granularity=1000
 
 #Should JMeter expand the tree when loading a test plan?
 # default value is false since JMeter 2.7
 #onload.expandtree=false
 
 # Maximum size of HTML page that can be displayed; default=200 * 1024
 # Set to 0 to disable the size check
 #view.results.tree.max_size=0
 
 # Maximum size of Document that can be parsed by Tika engine; defaut=10 * 1024 * 1024 (10MB)
 # Set to 0 to disable the size check
 #document.max_size=0
 
 #JMS options
 # Enable the following property to stop JMS Point-to-Point Sampler from using
 # the properties java.naming.security.[principal|credentials] when creating the queue connection
 #JMSSampler.useSecurity.properties=false
 
 # Set the following value to true in order to skip the delete confirmation dialogue
 #confirm.delete.skip=false
 
 # Used by Webservice Sampler (SOAP)
 # Size of Document Cache
 #soap.document_cache=50
 
 # Used by JSR223 elements
 # Size of compiled scripts cache
 #jsr223.compiled_scripts_cache_size=100
 
 #---------------------------------------------------------------------------
 # Classpath configuration
 #---------------------------------------------------------------------------
 
 # List of paths (separated by ;) to search for additional JMeter extension classes
 # - for example new GUI elements and samplers
 # These are in addition to lib/ext. Do not use this for utility jars.
 #search_paths=/app1/lib;/app2/lib
 
 # Users can define additional classpath items by setting the property below
 # - for example, utility jars or JUnit test cases
 #
 # Use the default separator for the host version of Java
 # Paths with spaces may cause problems for the JVM
 #user.classpath=../classes;../jars/jar1.jar
 
 # Classpath finder
 # ================
 # The classpath finder currently needs to load every single JMeter class to find
 # the classes it needs.
 # For non-GUI mode, it's only necessary to scan for Function classes, but all classes
 # are still loaded.
 # All current Function classes include ".function." in their name,
 # and none include ".gui." in the name, so the number of unwanted classes loaded can be
 # reduced by checking for these. However, if a valid function class name does not match
 # these restrictions, it will not be loaded. If problems are encountered, then comment
 # or change the following properties:
 classfinder.functions.contain=.functions.
 classfinder.functions.notContain=.gui.
 
 #---------------------------------------------------------------------------
 # Additional property files to load
 #---------------------------------------------------------------------------
 
 # Should JMeter automatically load additional JMeter properties?
 # File name to look for (comment to disable)
 user.properties=user.properties
 
 # Should JMeter automatically load additional system properties?
 # File name to look for (comment to disable)
-system.properties=system.properties
\ No newline at end of file
+system.properties=system.properties
+
+# Comma separated list of files that contain reference to templates and their description
+# Path must be relative to jmeter root folder
+#template.files=/bin/templates/templates.xml
\ No newline at end of file
diff --git a/bin/templates/jdbc.jmx b/bin/templates/jdbc.jmx
new file mode 100644
index 000000000..0ca8a700b
--- /dev/null
+++ b/bin/templates/jdbc.jmx
@@ -0,0 +1,93 @@
+<?xml version="1.0" encoding="UTF-8"?>
+<jmeterTestPlan version="1.2" properties="2.5" jmeter="2.10-SNAPSHOT.20130609">
+  <hashTree>
+    <TestPlan guiclass="TestPlanGui" testclass="TestPlan" testname="Test Plan" enabled="true">
+      <stringProp name="TestPlan.comments"></stringProp>
+      <boolProp name="TestPlan.functional_mode">false</boolProp>
+      <boolProp name="TestPlan.serialize_threadgroups">false</boolProp>
+      <elementProp name="TestPlan.user_defined_variables" elementType="Arguments" guiclass="ArgumentsPanel" testclass="Arguments" testname="User Defined Variables" enabled="true">
+        <collectionProp name="Arguments.arguments"/>
+      </elementProp>
+      <stringProp name="TestPlan.user_define_classpath"></stringProp>
+    </TestPlan>
+    <hashTree>
+      <JDBCDataSource guiclass="TestBeanGUI" testclass="JDBCDataSource" testname="JDBC Connection Configuration" enabled="true">
+        <boolProp name="autocommit">true</boolProp>
+        <stringProp name="checkQuery">Select 1</stringProp>
+        <stringProp name="connectionAge">5000</stringProp>
+        <stringProp name="dataSource">jdbcConfig</stringProp>
+        <stringProp name="dbUrl">jdbc:postgresql://hostname:port/dbname</stringProp>
+        <stringProp name="driver">org.postgresql.Driver</stringProp>
+        <boolProp name="keepAlive">true</boolProp>
+        <stringProp name="password">password</stringProp>
+        <stringProp name="poolMax">10</stringProp>
+        <stringProp name="timeout">10000</stringProp>
+        <stringProp name="transactionIsolation">DEFAULT</stringProp>
+        <stringProp name="trimInterval">60000</stringProp>
+        <stringProp name="username">username</stringProp>
+      </JDBCDataSource>
+      <hashTree/>
+      <ThreadGroup guiclass="ThreadGroupGui" testclass="ThreadGroup" testname="Thread Group" enabled="true">
+        <stringProp name="ThreadGroup.on_sample_error">continue</stringProp>
+        <elementProp name="ThreadGroup.main_controller" elementType="LoopController" guiclass="LoopControlPanel" testclass="LoopController" testname="Loop Controller" enabled="true">
+          <boolProp name="LoopController.continue_forever">false</boolProp>
+          <stringProp name="LoopController.loops">1</stringProp>
+        </elementProp>
+        <stringProp name="ThreadGroup.num_threads">1</stringProp>
+        <stringProp name="ThreadGroup.ramp_time">1</stringProp>
+        <longProp name="ThreadGroup.start_time">1370729701000</longProp>
+        <longProp name="ThreadGroup.end_time">1370729701000</longProp>
+        <boolProp name="ThreadGroup.scheduler">false</boolProp>
+        <stringProp name="ThreadGroup.duration"></stringProp>
+        <stringProp name="ThreadGroup.delay"></stringProp>
+      </ThreadGroup>
+      <hashTree>
+        <JDBCSampler guiclass="TestBeanGUI" testclass="JDBCSampler" testname="JDBC Request" enabled="true">
+          <stringProp name="dataSource">jdbcConfig</stringProp>
+          <stringProp name="query">select column1 from table</stringProp>
+          <stringProp name="queryArguments"></stringProp>
+          <stringProp name="queryArgumentsTypes"></stringProp>
+          <stringProp name="queryType">Select Statement</stringProp>
+          <stringProp name="resultVariable"></stringProp>
+          <stringProp name="variableNames">col1</stringProp>
+        </JDBCSampler>
+        <hashTree/>
+      </hashTree>
+      <ResultCollector guiclass="ViewResultsFullVisualizer" testclass="ResultCollector" testname="View Results Tree" enabled="true">
+        <boolProp name="ResultCollector.error_logging">false</boolProp>
+        <objProp>
+          <name>saveConfig</name>
+          <value class="SampleSaveConfiguration">
+            <time>true</time>
+            <latency>true</latency>
+            <timestamp>true</timestamp>
+            <success>true</success>
+            <label>true</label>
+            <code>true</code>
+            <message>true</message>
+            <threadName>true</threadName>
+            <dataType>false</dataType>
+            <encoding>false</encoding>
+            <assertions>true</assertions>
+            <subresults>false</subresults>
+            <responseData>false</responseData>
+            <samplerData>false</samplerData>
+            <xml>false</xml>
+            <fieldNames>true</fieldNames>
+            <responseHeaders>false</responseHeaders>
+            <requestHeaders>false</requestHeaders>
+            <responseDataOnError>true</responseDataOnError>
+            <saveAssertionResultsFailureMessage>true</saveAssertionResultsFailureMessage>
+            <assertionsResultsToSave>0</assertionsResultsToSave>
+            <bytes>true</bytes>
+            <hostname>true</hostname>
+            <threadCounts>true</threadCounts>
+            <sampleCount>true</sampleCount>
+          </value>
+        </objProp>
+        <stringProp name="filename"></stringProp>
+      </ResultCollector>
+      <hashTree/>
+    </hashTree>
+  </hashTree>
+</jmeterTestPlan>
diff --git a/bin/templates/recording.jmx b/bin/templates/recording.jmx
new file mode 100644
index 000000000..7c713abb9
--- /dev/null
+++ b/bin/templates/recording.jmx
@@ -0,0 +1,158 @@
+<?xml version="1.0" encoding="UTF-8"?>
+<jmeterTestPlan version="1.2" properties="2.5" jmeter="2.10-SNAPSHOT.20130608">
+  <hashTree>
+    <TestPlan guiclass="TestPlanGui" testclass="TestPlan" testname="Test Plan" enabled="true">
+      <stringProp name="TestPlan.comments"></stringProp>
+      <boolProp name="TestPlan.functional_mode">false</boolProp>
+      <boolProp name="TestPlan.serialize_threadgroups">false</boolProp>
+      <elementProp name="TestPlan.user_defined_variables" elementType="Arguments" guiclass="ArgumentsPanel" testclass="Arguments" testname="User Defined Variables" enabled="true">
+        <collectionProp name="Arguments.arguments"/>
+      </elementProp>
+      <stringProp name="TestPlan.user_define_classpath"></stringProp>
+    </TestPlan>
+    <hashTree>
+      <Arguments guiclass="ArgumentsPanel" testclass="Arguments" testname="User Defined Variables" enabled="true">
+        <collectionProp name="Arguments.arguments"/>
+      </Arguments>
+      <hashTree/>
+      <ConfigTestElement guiclass="HttpDefaultsGui" testclass="ConfigTestElement" testname="HTTP Request Defaults" enabled="true">
+        <elementProp name="HTTPsampler.Arguments" elementType="Arguments" guiclass="HTTPArgumentsPanel" testclass="Arguments" testname="User Defined Variables" enabled="true">
+          <collectionProp name="Arguments.arguments"/>
+        </elementProp>
+        <stringProp name="HTTPSampler.domain"></stringProp>
+        <stringProp name="HTTPSampler.port"></stringProp>
+        <stringProp name="HTTPSampler.connect_timeout"></stringProp>
+        <stringProp name="HTTPSampler.response_timeout"></stringProp>
+        <stringProp name="HTTPSampler.protocol"></stringProp>
+        <stringProp name="HTTPSampler.contentEncoding"></stringProp>
+        <stringProp name="HTTPSampler.path"></stringProp>
+        <stringProp name="HTTPSampler.concurrentPool">4</stringProp>
+      </ConfigTestElement>
+      <hashTree/>
+      <CookieManager guiclass="CookiePanel" testclass="CookieManager" testname="HTTP Cookie Manager" enabled="true">
+        <collectionProp name="CookieManager.cookies"/>
+        <boolProp name="CookieManager.clearEachIteration">true</boolProp>
+      </CookieManager>
+      <hashTree/>
+      <ThreadGroup guiclass="ThreadGroupGui" testclass="ThreadGroup" testname="Thread Group" enabled="true">
+        <stringProp name="ThreadGroup.on_sample_error">continue</stringProp>
+        <elementProp name="ThreadGroup.main_controller" elementType="LoopController" guiclass="LoopControlPanel" testclass="LoopController" testname="Loop Controller" enabled="true">
+          <boolProp name="LoopController.continue_forever">false</boolProp>
+          <stringProp name="LoopController.loops">1</stringProp>
+        </elementProp>
+        <stringProp name="ThreadGroup.num_threads">1</stringProp>
+        <stringProp name="ThreadGroup.ramp_time">1</stringProp>
+        <longProp name="ThreadGroup.start_time">1370726934000</longProp>
+        <longProp name="ThreadGroup.end_time">1370726934000</longProp>
+        <boolProp name="ThreadGroup.scheduler">false</boolProp>
+        <stringProp name="ThreadGroup.duration"></stringProp>
+        <stringProp name="ThreadGroup.delay"></stringProp>
+      </ThreadGroup>
+      <hashTree>
+        <RecordingController guiclass="RecordController" testclass="RecordingController" testname="Recording Controller" enabled="true"/>
+        <hashTree/>
+      </hashTree>
+      <ResultCollector guiclass="ViewResultsFullVisualizer" testclass="ResultCollector" testname="View Results Tree" enabled="true">
+        <boolProp name="ResultCollector.error_logging">false</boolProp>
+        <objProp>
+          <name>saveConfig</name>
+          <value class="SampleSaveConfiguration">
+            <time>true</time>
+            <latency>true</latency>
+            <timestamp>true</timestamp>
+            <success>true</success>
+            <label>true</label>
+            <code>true</code>
+            <message>true</message>
+            <threadName>true</threadName>
+            <dataType>false</dataType>
+            <encoding>false</encoding>
+            <assertions>true</assertions>
+            <subresults>false</subresults>
+            <responseData>false</responseData>
+            <samplerData>false</samplerData>
+            <xml>false</xml>
+            <fieldNames>true</fieldNames>
+            <responseHeaders>false</responseHeaders>
+            <requestHeaders>false</requestHeaders>
+            <responseDataOnError>true</responseDataOnError>
+            <saveAssertionResultsFailureMessage>true</saveAssertionResultsFailureMessage>
+            <assertionsResultsToSave>0</assertionsResultsToSave>
+            <bytes>true</bytes>
+            <hostname>true</hostname>
+            <threadCounts>true</threadCounts>
+            <sampleCount>true</sampleCount>
+          </value>
+        </objProp>
+        <stringProp name="filename"></stringProp>
+      </ResultCollector>
+      <hashTree/>
+    </hashTree>
+    <WorkBench guiclass="WorkBenchGui" testclass="WorkBench" testname="WorkBench" enabled="true">
+      <boolProp name="WorkBench.save">true</boolProp>
+    </WorkBench>
+    <hashTree>
+      <ProxyControl guiclass="ProxyControlGui" testclass="ProxyControl" testname="HTTP Proxy Server" enabled="true">
+        <stringProp name="ProxyControlGui.port">8888</stringProp>
+        <collectionProp name="ProxyControlGui.exclude_list">
+          <stringProp name="-835639533">.*\.jpg</stringProp>
+          <stringProp name="1358517207">.*\.js</stringProp>
+          <stringProp name="-835633829">.*\.png</stringProp>
+          <stringProp name="-835642634">.*\.gif</stringProp>
+          <stringProp name="-835647305">.*\.bmp</stringProp>
+          <stringProp name="-835630668">.*\.swf</stringProp>
+          <stringProp name="-835646155">.*\.css</stringProp>
+        </collectionProp>
+        <collectionProp name="ProxyControlGui.include_list"/>
+        <boolProp name="ProxyControlGui.capture_http_headers">true</boolProp>
+        <intProp name="ProxyControlGui.grouping_mode">4</intProp>
+        <boolProp name="ProxyControlGui.add_assertion">false</boolProp>
+        <stringProp name="ProxyControlGui.sampler_type_name"></stringProp>
+        <boolProp name="ProxyControlGui.sampler_redirect_automatically">false</boolProp>
+        <boolProp name="ProxyControlGui.sampler_follow_redirects">true</boolProp>
+        <boolProp name="ProxyControlGui.use_keepalive">true</boolProp>
+        <boolProp name="ProxyControlGui.sampler_download_images">false</boolProp>
+        <boolProp name="ProxyControlGui.regex_match">true</boolProp>
+        <stringProp name="ProxyControlGui.content_type_include"></stringProp>
+        <stringProp name="ProxyControlGui.content_type_exclude"></stringProp>
+      </ProxyControl>
+      <hashTree>
+        <ResultCollector guiclass="ViewResultsFullVisualizer" testclass="ResultCollector" testname="View Results Tree" enabled="true">
+          <boolProp name="ResultCollector.error_logging">false</boolProp>
+          <objProp>
+            <name>saveConfig</name>
+            <value class="SampleSaveConfiguration">
+              <time>true</time>
+              <latency>true</latency>
+              <timestamp>true</timestamp>
+              <success>true</success>
+              <label>true</label>
+              <code>true</code>
+              <message>true</message>
+              <threadName>true</threadName>
+              <dataType>false</dataType>
+              <encoding>false</encoding>
+              <assertions>true</assertions>
+              <subresults>false</subresults>
+              <responseData>false</responseData>
+              <samplerData>false</samplerData>
+              <xml>false</xml>
+              <fieldNames>true</fieldNames>
+              <responseHeaders>false</responseHeaders>
+              <requestHeaders>false</requestHeaders>
+              <responseDataOnError>true</responseDataOnError>
+              <saveAssertionResultsFailureMessage>true</saveAssertionResultsFailureMessage>
+              <assertionsResultsToSave>0</assertionsResultsToSave>
+              <bytes>true</bytes>
+              <hostname>true</hostname>
+              <threadCounts>true</threadCounts>
+              <sampleCount>true</sampleCount>
+            </value>
+          </objProp>
+          <stringProp name="filename"></stringProp>
+        </ResultCollector>
+        <hashTree/>
+      </hashTree>
+    </hashTree>
+  </hashTree>
+</jmeterTestPlan>
diff --git a/bin/templates/templates.xml b/bin/templates/templates.xml
new file mode 100644
index 000000000..2c2b5f1ea
--- /dev/null
+++ b/bin/templates/templates.xml
@@ -0,0 +1,53 @@
+<templates>
+    <template>
+        <name>Recording</name>
+        <fileName>/bin/templates/recording.jmx</fileName>
+        <description><![CDATA[
+        <h1>Template showing how to record</h1>
+        <h2>JMeter Configuration</h2>
+        <p>
+            <ul>
+                <li>JMeter Server Proxy port is set to 8888, you may want to change
+                
+            </ul>
+        </p>
+        <h2>Browser Configuration</h2>
+        <p>Configure your browser so that is uses the JMeter proxy, set:
+            <ul>
+                <li>the host of the machine that runs JMeter</li>
+                <li>the port you setup in JMeter Server Proxy</li>
+            </ul>
+        </p>
+        <h2>Useful links</h2>
+        <p>
+            <ul>
+                <li><a href="http://jmeter.apache.org/usermanual/jmeter_proxy_step_by_step.pdf" >http://jmeter.apache.org/usermanual/jmeter_proxy_step_by_step.pdf</a></li>
+                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#HTTP_Proxy_Server" >http://jmeter.apache.org/usermanual/component_reference.html#HTTP_Proxy_Server</a></li>
+            </ul>
+        </p>
+        
+        ]]></description>
+    </template>
+    <template>
+        <name>JDBC Load Test</name>
+        <fileName>/bin/templates/jdbc.jmx</fileName>
+        <description>
+        <![CDATA[<h1>Template showing how to Load Test an SQL query on Database</h1>
+        <h2>JMeter Configuration</h2>
+        <p>
+            <ul>
+                <li>Add the database driver to jmeter/lib folder</li>
+                <li>Configure the host, port, username and password in JDBC Configuration</li>
+                <li>Modify the SQL query to match your query</li>
+            </ul>
+        </p>
+        <h2>Useful links</h2>
+        <p>
+            <ul>
+                <li><a href="http://jmeter.apache.org/usermanual/build-db-test-plan.html" >http://jmeter.apache.org/usermanual/build-db-test-plan.html</a></li>
+            </ul>
+        </p>
+        
+        ]]></description>
+    </template>
+</templates>
\ No newline at end of file
diff --git a/src/core/org/apache/jmeter/gui/action/ActionNames.java b/src/core/org/apache/jmeter/gui/action/ActionNames.java
index fd02ae45a..1f0132c2f 100644
--- a/src/core/org/apache/jmeter/gui/action/ActionNames.java
+++ b/src/core/org/apache/jmeter/gui/action/ActionNames.java
@@ -1,101 +1,102 @@
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
  *
  */
 
 package org.apache.jmeter.gui.action;
 
 /*
  * Collect all the action names together in one place.
  * This helps to ensure that there are no duplicates
  *
  *
  */
 public final class ActionNames {
 
     public static final String ABOUT            = "about"; // $NON-NLS-1$
     public static final String ACTION_SHUTDOWN  = "shutdown"; // $NON-NLS-1$
     public static final String ACTION_START     = "start"; // $NON-NLS-1$
     public static final String ACTION_START_NO_TIMERS = "start_no_timers"; // $NON-NLS-1$
     public static final String ACTION_STOP      = "stop"; // $NON-NLS-1$
     public static final String ADD              = "Add"; // $NON-NLS-1$
     public static final String ADD_ALL          = "add_all"; // $NON-NLS-1$
     public static final String ADD_PARENT       = "Add Parent"; // $NON-NLS-1$
     public static final String ANALYZE_FILE     = "Analyze File"; // $NON-NLS-1$
     public static final String CHANGE_LANGUAGE  = "change_language"; // $NON-NLS-1$
     public static final String CHANGE_PARENT    = "Change Parent"; // $NON-NLS-1$
     public static final String CHECK_DIRTY      = "check_dirty"; // $NON-NLS-1$
     public static final String CHECK_REMOVE     = "check_remove"; // $NON-NLS-1$
     public static final String CLEAR            = "action.clear"; // $NON-NLS-1$
     public static final String CLEAR_ALL        = "action.clear_all"; // $NON-NLS-1$
     public static final String CLOSE            = "close"; // $NON-NLS-1$
     public static final String COLLAPSE_ALL     = "collapse all"; // $NON-NLS-1$
     public static final String COPY             = "Copy"; // $NON-NLS-1$
     public static final String CUT              = "Cut"; // $NON-NLS-1$
     public static final String DEBUG_ON         = "debug_on"; // $NON-NLS-1$
     public static final String DEBUG_OFF        = "debug_off"; // $NON-NLS-1$
     public static final String DISABLE          = "disable"; // $NON-NLS-1$
     /** Copy, then paste afterwards */
     public static final String DUPLICATE        = "duplicate"; // $NON-NLS-1$
     public static final String EDIT             = "edit"; // $NON-NLS-1$
     public static final String ENABLE           = "enable"; // $NON-NLS-1$
     public static final String EXIT             = "exit"; // $NON-NLS-1$
     public static final String EXPAND_ALL       = "expand all"; // $NON-NLS-1$
     public static final String FUNCTIONS        = "functions"; // $NON-NLS-1$
     public static final String HELP             = "help"; // $NON-NLS-1$
     public static final String HEAP_DUMP        = "heap_dump"; // $NON-NLS-1$
     public static final String LAF_PREFIX       = "laf:"; // Look and Feel prefix
     public static final String LOGGER_PANEL_ENABLE_DISABLE     = "logger_panel_enable_disable"; // $NON-NLS-1$
     public static final String MERGE            = "merge"; // $NON-NLS-1$
     public static final String OPEN             = "open"; // $NON-NLS-1$
     public static final String OPEN_RECENT      = "open_recent"; // $NON-NLS-1$
+    public static final String CREATE_FROM_TEMPLATE      = "create_from_template"; // $NON-NLS-1$
     public static final String PASTE            = "Paste"; // $NON-NLS-1$
     public static final String REMOTE_EXIT      = "remote_exit"; // $NON-NLS-1$
     public static final String REMOTE_EXIT_ALL  = "remote_exit_all"; // $NON-NLS-1$
     public static final String REMOTE_SHUT      = "remote_shut"; // $NON-NLS-1$
     public static final String REMOTE_SHUT_ALL  = "remote_shut_all"; // $NON-NLS-1$
     public static final String REMOTE_START     = "remote_start"; // $NON-NLS-1$
     public static final String REMOTE_START_ALL = "remote_start_all"; // $NON-NLS-1$
     public static final String REMOTE_STOP      = "remote_stop"; // $NON-NLS-1$
     public static final String REMOTE_STOP_ALL  = "remote_stop_all"; // $NON-NLS-1$
     public static final String REMOVE           = "remove"; // $NON-NLS-1$
     public static final String RESET_GUI        = "reset_gui"; // $NON-NLS-1$
     public static final String REVERT_PROJECT   = "revert_project"; // $NON-NLS-1$
     public static final String SAVE             = "save"; // $NON-NLS-1$
     public static final String SAVE_ALL_AS      = "save_all_as";  // $NON-NLS-1$
     public static final String SAVE_AS          = "save_as"; // $NON-NLS-1$
     public static final String SAVE_GRAPHICS    = "save_graphics"; // $NON-NLS-1$
     public static final String SAVE_GRAPHICS_ALL= "save_graphics_all"; // $NON-NLS-1$
     public static final String SSL_MANAGER      = "sslManager"; // $NON-NLS-1$
     public static final String STOP_THREAD      = "stop_thread"; // $NON-NLS-1$
     public static final String SUB_TREE_LOADED  = "sub_tree_loaded"; // $NON-NLS-1$
     public static final String SUB_TREE_MERGED  = "sub_tree_merged"; // $NON-NLS-1$
     public static final String SUB_TREE_SAVED   = "sub_tree_saved"; // $NON-NLS-1$
     public static final String TOGGLE           = "toggle"; // $NON-NLS-1$ enable/disable
     public static final String TOOLBAR           = "toolbar"; // $NON-NLS-1$
     public static final String WHAT_CLASS       = "what_class"; // $NON-NLS-1$
     public static final String SEARCH_TREE      = "search_tree"; // $NON-NLS-1$
     public static final String SEARCH_RESET      = "search_reset"; // $NON-NLS-1$
     public static final String MOVE_UP          = "move_up"; // $NON-NLS-1$
     public static final String MOVE_DOWN        = "move_down"; // $NON-NLS-1$
     public static final String MOVE_LEFT        = "move_left"; // $NON-NLS-1$
     public static final String MOVE_RIGHT       = "move_right"; // $NON-NLS-1$
 
     // Prevent instantiation
     private ActionNames(){
 
     }
 }
diff --git a/src/core/org/apache/jmeter/gui/action/SelectTemplateDialog.java b/src/core/org/apache/jmeter/gui/action/SelectTemplateDialog.java
new file mode 100644
index 000000000..d92865c40
--- /dev/null
+++ b/src/core/org/apache/jmeter/gui/action/SelectTemplateDialog.java
@@ -0,0 +1,222 @@
+/*
+ * Licensed to the Apache Software Foundation (ASF) under one or more
+ * contributor license agreements.  See the NOTICE file distributed with
+ * this work for additional information regarding copyright ownership.
+ * The ASF licenses this file to You under the Apache License, Version 2.0
+ * (the "License"); you may not use this file except in compliance with
+ * the License.  You may obtain a copy of the License at
+ *
+ *   http://www.apache.org/licenses/LICENSE-2.0
+ *
+ * Unless required by applicable law or agreed to in writing, software
+ * distributed under the License is distributed on an "AS IS" BASIS,
+ * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
+ * See the License for the specific language governing permissions and
+ * limitations under the License.
+ *
+ */
+
+package org.apache.jmeter.gui.action;
+
+import java.awt.BorderLayout;
+import java.awt.Dimension;
+import java.awt.FlowLayout;
+import java.awt.GridLayout;
+import java.awt.event.ActionEvent;
+import java.awt.event.ActionListener;
+import java.io.BufferedInputStream;
+import java.io.BufferedOutputStream;
+import java.io.File;
+import java.io.FileInputStream;
+import java.io.FileOutputStream;
+import java.io.InputStream;
+import java.io.OutputStream;
+import java.util.Arrays;
+import java.util.Comparator;
+import java.util.Set;
+
+import javax.swing.AbstractAction;
+import javax.swing.Action;
+import javax.swing.ActionMap;
+import javax.swing.InputMap;
+import javax.swing.JButton;
+import javax.swing.JComponent;
+import javax.swing.JDialog;
+import javax.swing.JFrame;
+import javax.swing.JPanel;
+import javax.swing.JRootPane;
+import javax.swing.JScrollPane;
+import javax.swing.event.ChangeEvent;
+import javax.swing.event.ChangeListener;
+
+import org.apache.commons.io.IOUtils;
+import org.apache.jmeter.gui.action.template.Template;
+import org.apache.jmeter.gui.action.template.TemplateManager;
+import org.apache.jmeter.swing.HtmlPane;
+import org.apache.jmeter.util.JMeterUtils;
+import org.apache.jorphan.gui.ComponentUtil;
+import org.apache.jorphan.gui.JLabeledChoice;
+import org.apache.jorphan.logging.LoggingManager;
+import org.apache.jorphan.util.JOrphanUtils;
+import org.apache.log.Logger;
+
+/**
+ * Dialog used for Templates selection
+ * @since 2.10
+ */
+public class SelectTemplateDialog extends JDialog implements ChangeListener, ActionListener {
+    /**
+     *
+     */
+    private static final long serialVersionUID = -4436834972710248247L;
+
+    private static final Logger log = LoggingManager.getLoggerForClass();
+
+    private JLabeledChoice templateList;
+
+    private HtmlPane helpDoc = new HtmlPane();
+
+    private JButton createFromTemplateButton;
+
+    private JButton cancelButton;
+    
+    private JScrollPane scroller = new JScrollPane(helpDoc);
+
+    public SelectTemplateDialog() {
+        super((JFrame) null, JMeterUtils.getResString("template_title"), true); //$NON-NLS-1$
+        init();
+    }
+
+    @Override
+    protected JRootPane createRootPane() {
+        JRootPane rootPane = new JRootPane();
+        // Hide Window on ESC
+        Action escapeAction = new AbstractAction("ESCAPE") { //$NON-NLS-1$
+            /**
+             *
+             */
+            private static final long serialVersionUID = -6543764044868772971L;
+
+            @Override
+            public void actionPerformed(ActionEvent actionEvent) {
+                setVisible(false);
+            }
+        };
+        // Do search on Enter
+        Action enterAction = new AbstractAction("ENTER") { //$NON-NLS-1$
+            /**
+             *
+             */
+            private static final long serialVersionUID = -3661361497864527363L;
+
+            @Override
+            public void actionPerformed(ActionEvent actionEvent) {
+                doOpen(actionEvent);
+            }
+        };
+        ActionMap actionMap = rootPane.getActionMap();
+        actionMap.put(escapeAction.getValue(Action.NAME), escapeAction);
+        actionMap.put(enterAction.getValue(Action.NAME), enterAction);
+        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
+        inputMap.put(KeyStrokes.ESC, escapeAction.getValue(Action.NAME));
+        inputMap.put(KeyStrokes.ENTER, enterAction.getValue(Action.NAME));
+
+        return rootPane;
+    }
+
+    private void init() {
+        initializeTemplateList();
+        this.getContentPane().setLayout(new BorderLayout(10, 10));
+        JPanel comboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
+        comboPanel.add(templateList);
+        this.getContentPane().add(comboPanel, BorderLayout.NORTH);
+        helpDoc.setContentType("text/html"); //$NON-NLS-1$
+        helpDoc.setEditable(false);
+        fillDescription();
+        JPanel jPanel = new JPanel(new GridLayout(1,1));
+        scroller.setPreferredSize(new Dimension(300, 400));
+        jPanel.setPreferredSize(new Dimension(310, 410));
+        jPanel.add(scroller);
+        this.getContentPane().add(jPanel, BorderLayout.CENTER);
+
+        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
+
+        createFromTemplateButton = new JButton(JMeterUtils.getResString("template_create_from")); //$NON-NLS-1$
+        createFromTemplateButton.addActionListener(this);
+
+        cancelButton = new JButton(JMeterUtils.getResString("cancel")); //$NON-NLS-1$
+        cancelButton.addActionListener(this);
+        buttonsPanel.add(createFromTemplateButton);
+        buttonsPanel.add(cancelButton);
+        this.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
+
+        this.pack();
+        ComponentUtil.centerComponentInWindow(this);
+    }
+    
+    private void initializeTemplateList() {
+        Set<String> templatesAsSet = TemplateManager.getInstance().getTemplateNames();
+        String[] templateNames =  templatesAsSet.toArray(new String[templatesAsSet.size()]);
+        Arrays.sort(templateNames, new Comparator<String>() {
+            @Override
+            public int compare(String o1, String o2) {
+                return o1.compareToIgnoreCase(o2);
+            }
+        });
+        templateList = new JLabeledChoice(JMeterUtils.getResString("template_choose"), templateNames); //$NON-NLS-1$
+        templateList.addChangeListener(this);
+    }
+
+    /**
+     * Do search
+     * @param e {@link ActionEvent}
+     */
+    @Override
+    public void actionPerformed(ActionEvent e) {
+        if(e.getSource()==cancelButton) {
+            this.setVisible(false);
+            return;
+        }
+        doOpen(e);
+    }
+    
+    @Override
+    public void stateChanged(ChangeEvent event) {
+        fillDescription();
+    }
+
+    /**
+     * 
+     */
+    protected void fillDescription() {
+        String selectedTemplate = templateList.getText();
+        Template template = TemplateManager.getInstance().getTemplateByName(selectedTemplate);
+        helpDoc.setText(template.getDescription());
+    }
+
+    /**
+     * @param e {@link ActionEvent}
+     */
+    private void doOpen(ActionEvent e) {
+        InputStream inputStream = null;
+        OutputStream outputStream = null;
+        try {
+            String selectedTemplate = templateList.getText();
+            Template template = TemplateManager.getInstance().getTemplateByName(selectedTemplate);   
+            File fileToCopy = new File(JMeterUtils.getJMeterHome(), template.getFileName());
+            File targetFile = new File( System.getProperty("user.dir"), 
+                    template.getFileName().substring(template.getFileName().lastIndexOf("/")));
+            inputStream = new BufferedInputStream(new FileInputStream(fileToCopy));
+            outputStream = new BufferedOutputStream(new FileOutputStream(targetFile));
+            IOUtils.copy(inputStream, outputStream);
+            outputStream.close();
+            Load.loadProjectFile(e, targetFile, false); 
+            this.setVisible(false);
+        } catch (Exception e1) {
+            throw new Error(e1);
+        } finally {
+            JOrphanUtils.closeQuietly(inputStream);
+            JOrphanUtils.closeQuietly(outputStream);
+        }
+    }
+}
\ No newline at end of file
diff --git a/src/core/org/apache/jmeter/gui/action/TemplateCommand.java b/src/core/org/apache/jmeter/gui/action/TemplateCommand.java
new file mode 100644
index 000000000..dee7cdfe1
--- /dev/null
+++ b/src/core/org/apache/jmeter/gui/action/TemplateCommand.java
@@ -0,0 +1,54 @@
+/*
+ * Licensed to the Apache Software Foundation (ASF) under one or more
+ * contributor license agreements.  See the NOTICE file distributed with
+ * this work for additional information regarding copyright ownership.
+ * The ASF licenses this file to You under the Apache License, Version 2.0
+ * (the "License"); you may not use this file except in compliance with
+ * the License.  You may obtain a copy of the License at
+ *
+ *   http://www.apache.org/licenses/LICENSE-2.0
+ *
+ * Unless required by applicable law or agreed to in writing, software
+ * distributed under the License is distributed on an "AS IS" BASIS,
+ * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
+ * See the License for the specific language governing permissions and
+ * limitations under the License.
+ *
+ */
+
+package org.apache.jmeter.gui.action;
+
+import java.awt.event.ActionEvent;
+import java.util.HashSet;
+import java.util.Set;
+
+/**
+ * Open Templates 
+ * @since 2.10
+ */
+public class TemplateCommand extends AbstractAction {
+
+    private static final Set<String> commands = new HashSet<String>();
+
+    static {
+        commands.add(ActionNames.CREATE_FROM_TEMPLATE);
+    }
+
+    private SelectTemplateDialog dialog = new SelectTemplateDialog();
+    /**
+     * @see Command#doAction(ActionEvent)
+     */
+    @Override
+    public void doAction(ActionEvent e) {
+        dialog.setVisible(true);
+    }
+
+
+    /**
+     * @see Command#getActionNames()
+     */
+    @Override
+    public Set<String> getActionNames() {
+        return commands;
+    }
+}
diff --git a/src/core/org/apache/jmeter/gui/action/template/Template.java b/src/core/org/apache/jmeter/gui/action/template/Template.java
new file mode 100644
index 000000000..f1f11b21b
--- /dev/null
+++ b/src/core/org/apache/jmeter/gui/action/template/Template.java
@@ -0,0 +1,65 @@
+/*
+ * Licensed to the Apache Software Foundation (ASF) under one or more
+ * contributor license agreements.  See the NOTICE file distributed with
+ * this work for additional information regarding copyright ownership.
+ * The ASF licenses this file to You under the Apache License, Version 2.0
+ * (the "License"); you may not use this file except in compliance with
+ * the License.  You may obtain a copy of the License at
+ *
+ *   http://www.apache.org/licenses/LICENSE-2.0
+ *
+ * Unless required by applicable law or agreed to in writing, software
+ * distributed under the License is distributed on an "AS IS" BASIS,
+ * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
+ * See the License for the specific language governing permissions and
+ * limitations under the License.
+ *
+ */
+
+package org.apache.jmeter.gui.action.template;
+
+/**
+ * Template Bean
+ * @since 2.10
+ */
+public class Template {
+    private String name;
+    private String fileName;
+    private String description;
+    /**
+     * @return the name
+     */
+    public String getName() {
+        return name;
+    }
+    /**
+     * @param name the name to set
+     */
+    public void setName(String name) {
+        this.name = name;
+    }
+    /**
+     * @return the relativeFileName
+     */
+    public String getFileName() {
+        return fileName;
+    }
+    /**
+     * @param relativeFileName the relativeFileName to set
+     */
+    public void setFileName(String relativeFileName) {
+        fileName = relativeFileName;
+    }
+    /**
+     * @return the description
+     */
+    public String getDescription() {
+        return description;
+    }
+    /**
+     * @param description the description to set
+     */
+    public void setDescription(String description) {
+        this.description = description;
+    }
+}
\ No newline at end of file
diff --git a/src/core/org/apache/jmeter/gui/action/template/TemplateManager.java b/src/core/org/apache/jmeter/gui/action/template/TemplateManager.java
new file mode 100644
index 000000000..aa1590409
--- /dev/null
+++ b/src/core/org/apache/jmeter/gui/action/template/TemplateManager.java
@@ -0,0 +1,140 @@
+/*
+ * Licensed to the Apache Software Foundation (ASF) under one or more
+ * contributor license agreements.  See the NOTICE file distributed with
+ * this work for additional information regarding copyright ownership.
+ * The ASF licenses this file to You under the Apache License, Version 2.0
+ * (the "License"); you may not use this file except in compliance with
+ * the License.  You may obtain a copy of the License at
+ *
+ *   http://www.apache.org/licenses/LICENSE-2.0
+ *
+ * Unless required by applicable law or agreed to in writing, software
+ * distributed under the License is distributed on an "AS IS" BASIS,
+ * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
+ * See the License for the specific language governing permissions and
+ * limitations under the License.
+ *
+ */
+
+package org.apache.jmeter.gui.action.template;
+
+import java.io.BufferedInputStream;
+import java.io.File;
+import java.io.FileInputStream;
+import java.io.FileNotFoundException;
+import java.io.IOException;
+import java.io.InputStream;
+import java.util.HashMap;
+import java.util.Map;
+import java.util.Set;
+
+import org.apache.commons.lang3.StringUtils;
+import org.apache.jmeter.util.JMeterUtils;
+import org.apache.jorphan.logging.LoggingManager;
+import org.apache.jorphan.util.JOrphanUtils;
+import org.apache.log.Logger;
+
+import com.thoughtworks.xstream.XStream;
+import com.thoughtworks.xstream.io.xml.DomDriver;
+
+/**
+ * Manages Test Plan templates
+ * @since 2.10
+ */
+public class TemplateManager {
+    private class Templates {
+        private Map<String, Template> templates = new HashMap<String, Template>();
+    }
+    private static final String TEMPLATE_FILES = JMeterUtils.getPropDefault("template.files", // $NON-NLS-1$
+            "/bin/templates/templates.xml");
+
+    private static final Logger log = LoggingManager.getLoggerForClass();
+    
+    private static final TemplateManager SINGLETON = new TemplateManager();
+    
+    private Map<String, Template> templates = new HashMap<String, Template>();
+
+    private XStream xstream = initXStream();
+
+    /**
+     * 
+     * @return
+     */
+    public static final TemplateManager getInstance() {
+        return SINGLETON;
+    }
+    
+    private TemplateManager()  {
+        try {
+            templates = readTemplates();            
+        } catch(IOException e) {
+            log.error("Error loading templates from files referenced in templates.files property:"+
+                    TEMPLATE_FILES, e);
+        }
+    }
+    
+    private XStream initXStream() {
+        XStream xstream = new XStream(new DomDriver());
+        xstream.alias("template", Template.class);
+        xstream.alias("templates", Templates.class);
+        
+        // templates i
+        xstream.addImplicitMap(Templates.class, 
+                // field TemplateManager#templates 
+                "templates", // $NON-NLS-1$
+                Template.class,     
+                // field Template#name 
+                "name" // $NON-NLS-1$
+                );
+                
+        return xstream;
+    }
+
+    public void addTemplate(Template template) {
+        templates.put(template.getName(), template);
+    }
+
+    /**
+     * @return Set<String> the templates names
+     */
+    public Set<String> getTemplateNames() {
+        return templates.keySet();
+    }
+
+
+    private Map<String, Template> readTemplates() throws FileNotFoundException {
+        Map<String, Template> templates = new HashMap<String, Template>();
+       
+        String[] templateFiles = TEMPLATE_FILES.split(",");
+        for (int i = 0; i < templateFiles.length; i++) {
+            if(!StringUtils.isEmpty(templateFiles[i])) {
+                InputStream inputStream = null;
+                File f = new File(JMeterUtils.getJMeterHome(),
+                        templateFiles[i]); 
+                try {
+                    if(f.exists() && f.canRead()) {
+                        log.info("Reading templates from:"+f.getAbsolutePath());
+                        inputStream = new BufferedInputStream(new FileInputStream(f)); 
+                                
+                        templates.putAll(((Templates) xstream.fromXML(inputStream)).templates);
+                    } else {
+                        log.warn("Ignoring template file:'"+f.getAbsolutePath()+"' as it does not exist or is not readable");
+                    }
+                } catch(Exception ex) {                    
+                    log.warn("Ignoring template file:'"+f.getAbsolutePath()+"', an error occured parsing the file", ex);
+                } finally {
+                    JOrphanUtils.closeQuietly(inputStream);
+                } 
+            }
+        }
+        return templates;
+    }
+
+    /**
+     * @param selectedTemplate Template name
+     * @return {@link Template}
+     */
+    public Template getTemplateByName(String selectedTemplate) {
+        return templates.get(selectedTemplate);
+    }
+}
diff --git a/src/core/org/apache/jmeter/gui/util/JMeterMenuBar.java b/src/core/org/apache/jmeter/gui/util/JMeterMenuBar.java
index 9d460ed37..855fdd7d4 100644
--- a/src/core/org/apache/jmeter/gui/util/JMeterMenuBar.java
+++ b/src/core/org/apache/jmeter/gui/util/JMeterMenuBar.java
@@ -1,752 +1,758 @@
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
  *
  */
 
 package org.apache.jmeter.gui.util;
 
 import java.awt.Component;
 import java.awt.event.KeyEvent;
 import java.util.ArrayList;
 import java.util.Collection;
 import java.util.Iterator;
 import java.util.LinkedList;
 import java.util.List;
 import java.util.Locale;
 
 import javax.swing.JCheckBoxMenuItem;
 import javax.swing.JComponent;
 import javax.swing.JMenu;
 import javax.swing.JMenuBar;
 import javax.swing.JMenuItem;
 import javax.swing.JPopupMenu;
 import javax.swing.KeyStroke;
 import javax.swing.MenuElement;
 import javax.swing.UIManager;
 import javax.swing.UIManager.LookAndFeelInfo;
 
 import org.apache.jmeter.gui.GuiPackage;
 import org.apache.jmeter.gui.action.ActionNames;
 import org.apache.jmeter.gui.action.ActionRouter;
 import org.apache.jmeter.gui.action.KeyStrokes;
 import org.apache.jmeter.gui.action.LoadRecentProject;
 import org.apache.jmeter.util.JMeterUtils;
 import org.apache.jmeter.util.LocaleChangeEvent;
 import org.apache.jmeter.util.LocaleChangeListener;
 import org.apache.jmeter.util.SSLManager;
 import org.apache.jorphan.logging.LoggingManager;
 import org.apache.jorphan.util.JOrphanUtils;
 import org.apache.log.Logger;
 
 public class JMeterMenuBar extends JMenuBar implements LocaleChangeListener {
     private static final long serialVersionUID = 240L;
 
     private static final Logger log = LoggingManager.getLoggerForClass();
 
     private JMenu fileMenu;
 
     private JMenuItem file_save_as;
 
     private JMenuItem file_selection_as;
 
     private JMenuItem file_revert;
 
     private JMenuItem file_load;
 
+    private JMenuItem create_from_template;
+
     private List<JComponent> file_load_recent_files;
 
     private JMenuItem file_merge;
 
     private JMenuItem file_exit;
 
     private JMenuItem file_close;
 
     private JMenu editMenu;
 
     private JMenu edit_add;
 
     private JMenu runMenu;
 
     private JMenuItem run_start;
 
     private JMenuItem run_start_no_timers;
 
     private JMenu remote_start;
 
     private JMenuItem remote_start_all;
 
     private Collection<JMenuItem> remote_engine_start;
 
     private JMenuItem run_stop;
 
     private JMenuItem run_shut;
 
     private JMenu remote_stop;
 
     private JMenu remote_shut;
 
     private JMenuItem remote_stop_all;
 
     private JMenuItem remote_shut_all;
 
     private Collection<JMenuItem> remote_engine_stop;
 
     private Collection<JMenuItem> remote_engine_shut;
 
     private JMenuItem run_clear;
 
     private JMenuItem run_clearAll;
 
     // JMenu reportMenu;
     // JMenuItem analyze;
     private JMenu optionsMenu;
 
     private JMenu lafMenu;
 
     private JMenuItem sslManager;
 
     private JMenu helpMenu;
 
     private JMenuItem help_about;
 
     private String[] remoteHosts;
 
     private JMenu remote_exit;
 
     private JMenuItem remote_exit_all;
 
     private Collection<JMenuItem> remote_engine_exit;
 
     private JMenu searchMenu;
 
     public static final String SYSTEM_LAF = "System"; // $NON-NLS-1$
 
     public static final String CROSS_PLATFORM_LAF = "CrossPlatform"; // $NON-NLS-1$
 
     public JMeterMenuBar() {
         // List for recent files menu items
         file_load_recent_files = new LinkedList<JComponent>();
         // Lists for remote engines menu items
         remote_engine_start = new LinkedList<JMenuItem>();
         remote_engine_stop = new LinkedList<JMenuItem>();
         remote_engine_shut = new LinkedList<JMenuItem>();
         remote_engine_exit = new LinkedList<JMenuItem>();
         remoteHosts = JOrphanUtils.split(JMeterUtils.getPropDefault("remote_hosts", ""), ","); //$NON-NLS-1$
         if (remoteHosts.length == 1 && remoteHosts[0].equals("")) {
             remoteHosts = new String[0];
         }
         this.getRemoteItems();
         createMenuBar();
         JMeterUtils.addLocaleChangeListener(this);
     }
 
     public void setFileSaveEnabled(boolean enabled) {
         if(file_save_as != null) {
             file_save_as.setEnabled(enabled);
         }
     }
 
     public void setFileLoadEnabled(boolean enabled) {
         if (file_load != null) {
             file_load.setEnabled(enabled);
         }
         if (file_merge != null) {
             file_merge.setEnabled(enabled);
         }
     }
 
     public void setFileRevertEnabled(boolean enabled) {
         if(file_revert != null) {
             file_revert.setEnabled(enabled);
         }
     }
 
     public void setProjectFileLoaded(String file) {
         if(file_load_recent_files != null && file != null) {
             LoadRecentProject.updateRecentFileMenuItems(file_load_recent_files, file);
         }
     }
 
     public void setEditEnabled(boolean enabled) {
         if (editMenu != null) {
             editMenu.setEnabled(enabled);
         }
     }
 
     // Does not appear to be used; called by MainFrame#setEditAddMenu() but that is not called
     public void setEditAddMenu(JMenu menu) {
         // If the Add menu already exists, remove it.
         if (edit_add != null) {
             editMenu.remove(edit_add);
         }
         // Insert the Add menu as the first menu item in the Edit menu.
         edit_add = menu;
         editMenu.insert(edit_add, 0);
     }
 
     // Called by MainFrame#setEditMenu() which is called by EditCommand#doAction and GuiPackage#localeChanged
     public void setEditMenu(JPopupMenu menu) {
         if (menu != null) {
             editMenu.removeAll();
             Component[] comps = menu.getComponents();
             for (int i = 0; i < comps.length; i++) {
                 editMenu.add(comps[i]);
             }
             editMenu.setEnabled(true);
         } else {
             editMenu.setEnabled(false);
         }
     }
 
     public void setEditAddEnabled(boolean enabled) {
         // There was a NPE being thrown without the null check here.. JKB
         if (edit_add != null) {
             edit_add.setEnabled(enabled);
         }
         // If we are enabling the Edit-->Add menu item, then we also need to
         // enable the Edit menu. The Edit menu may already be enabled, but
         // there's no harm it trying to enable it again.
         setEditEnabled(enabled);
     }
 
     /**
      * Creates the MenuBar for this application. I believe in my heart that this
      * should be defined in a file somewhere, but that is for later.
      */
     public void createMenuBar() {
         makeFileMenu();
         makeEditMenu();
         makeRunMenu();
         makeOptionsMenu();
         makeHelpMenu();
         makeSearchMenu();
         this.add(fileMenu);
         this.add(editMenu);
         this.add(searchMenu);
         this.add(runMenu);
         this.add(optionsMenu);
         this.add(helpMenu);
     }
 
     private void makeHelpMenu() {
         // HELP MENU
         helpMenu = makeMenuRes("help",'H'); //$NON-NLS-1$
 
         JMenuItem contextHelp = makeMenuItemRes("help", 'H', ActionNames.HELP, KeyStrokes.HELP); //$NON-NLS-1$
 
         JMenuItem whatClass = makeMenuItemRes("help_node", 'W', ActionNames.WHAT_CLASS, KeyStrokes.WHAT_CLASS);//$NON-NLS-1$
 
         JMenuItem setDebug = makeMenuItemRes("debug_on", ActionNames.DEBUG_ON, KeyStrokes.DEBUG_ON);//$NON-NLS-1$
 
         JMenuItem resetDebug = makeMenuItemRes("debug_off", ActionNames.DEBUG_OFF, KeyStrokes.DEBUG_OFF);//$NON-NLS-1$
 
         JMenuItem heapDump = makeMenuItemRes("heap_dump", ActionNames.HEAP_DUMP);//$NON-NLS-1$
 
         help_about = makeMenuItemRes("about", 'A', ActionNames.ABOUT); //$NON-NLS-1$
 
         helpMenu.add(contextHelp);
         helpMenu.addSeparator();
         helpMenu.add(whatClass);
         helpMenu.add(setDebug);
         helpMenu.add(resetDebug);
         helpMenu.add(heapDump);
         helpMenu.addSeparator();
         helpMenu.add(help_about);
     }
 
     private void makeOptionsMenu() {
         // OPTIONS MENU
         optionsMenu = makeMenuRes("option",'O'); //$NON-NLS-1$
         JMenuItem functionHelper = makeMenuItemRes("function_dialog_menu_item", 'F', ActionNames.FUNCTIONS, KeyStrokes.FUNCTIONS); //$NON-NLS-1$
 
         lafMenu = makeMenuRes("appearance",'L'); //$NON-NLS-1$
         UIManager.LookAndFeelInfo lafs[] = getAllLAFs();
         for (int i = 0; i < lafs.length; ++i) {
             JMenuItem laf = new JMenuItem(lafs[i].getName());
             laf.addActionListener(ActionRouter.getInstance());
             laf.setActionCommand(ActionNames.LAF_PREFIX + lafs[i].getClassName());
             laf.setToolTipText(lafs[i].getClassName()); // show the classname to the user
             lafMenu.add(laf);
         }
         optionsMenu.add(functionHelper);
         optionsMenu.add(lafMenu);
 
         JCheckBoxMenuItem menuToolBar = makeCheckBoxMenuItemRes("menu_toolbar", ActionNames.TOOLBAR); //$NON-NLS-1$
         JCheckBoxMenuItem menuLoggerPanel = makeCheckBoxMenuItemRes("menu_logger_panel", ActionNames.LOGGER_PANEL_ENABLE_DISABLE); //$NON-NLS-1$
         GuiPackage guiInstance = GuiPackage.getInstance();
         if (guiInstance != null) { //avoid error in ant task tests (good way?)
             guiInstance.setMenuItemToolbar(menuToolBar);
             guiInstance.setMenuItemLoggerPanel(menuLoggerPanel);
         }
         optionsMenu.add(menuToolBar);
         optionsMenu.add(menuLoggerPanel);
         
         if (SSLManager.isSSLSupported()) {
             sslManager = makeMenuItemRes("sslmanager", 'S', ActionNames.SSL_MANAGER, KeyStrokes.SSL_MANAGER); //$NON-NLS-1$
             optionsMenu.add(sslManager);
         }
         optionsMenu.add(makeLanguageMenu());
 
         JMenuItem collapse = makeMenuItemRes("menu_collapse_all", ActionNames.COLLAPSE_ALL, KeyStrokes.COLLAPSE_ALL); //$NON-NLS-1$
         optionsMenu.add(collapse);
 
         JMenuItem expand = makeMenuItemRes("menu_expand_all", ActionNames.EXPAND_ALL, KeyStrokes.EXPAND_ALL); //$NON-NLS-1$
         optionsMenu.add(expand);
     }
 
     private static class LangMenuHelper{
         final ActionRouter actionRouter = ActionRouter.getInstance();
         final JMenu languageMenu;
 
         LangMenuHelper(JMenu _languageMenu){
             languageMenu = _languageMenu;
         }
 
         /**
          * Create a language entry from the locale name.
          *
          * @param locale - must also be a valid resource name
          */
         void addLang(String locale){
             String localeString = JMeterUtils.getLocaleString(locale);
             JMenuItem language = new JMenuItem(localeString);
             language.addActionListener(actionRouter);
             language.setActionCommand(ActionNames.CHANGE_LANGUAGE);
             language.setName(locale); // This is used by the ChangeLanguage class to define the Locale
             languageMenu.add(language);
         }
 
    }
 
     /**
      * Generate the list of supported languages.
      *
      * @return list of languages
      */
     // Also used by org.apache.jmeter.resources.PackageTest
     public static String[] getLanguages(){
         List<String> lang = new ArrayList<String>(20);
         lang.add(Locale.ENGLISH.toString()); // en
         lang.add(Locale.FRENCH.toString()); // fr
         lang.add(Locale.GERMAN.toString()); // de
         lang.add("no"); // $NON-NLS-1$
         lang.add("pl"); // $NON-NLS-1$
         lang.add("pt_BR"); // $NON-NLS-1$
         lang.add("es"); // $NON-NLS-1$
         lang.add("tr"); // $NON-NLS-1$
         lang.add(Locale.JAPANESE.toString()); // ja
         lang.add(Locale.SIMPLIFIED_CHINESE.toString()); // zh_CN
         lang.add(Locale.TRADITIONAL_CHINESE.toString()); // zh_TW
         final String addedLocales = JMeterUtils.getProperty("locales.add");
         if (addedLocales != null){
             String [] addLanguages =addedLocales.split(","); // $NON-NLS-1$
             for(String newLang : addLanguages){
                 log.info("Adding locale "+newLang);
                 lang.add(newLang);
             }
         }
         return lang.toArray(new String[lang.size()]);
     }
 
     static JMenu makeLanguageMenu() {
         final JMenu languageMenu = makeMenuRes("choose_language",'C'); //$NON-NLS-1$
 
         LangMenuHelper langMenu = new LangMenuHelper(languageMenu);
 
         /*
          * Note: the item name is used by ChangeLanguage to create a Locale for
          * that language, so need to ensure that the language strings are valid
          * If they exist, use the Locale language constants.
          * Also, need to ensure that the names are valid resource entries too.
          */
 
         for(String lang : getLanguages()){
             langMenu.addLang(lang);
         }
         return languageMenu;
     }
 
     private void makeRunMenu() {
         // RUN MENU
         runMenu = makeMenuRes("run",'R'); //$NON-NLS-1$
 
         run_start = makeMenuItemRes("start", 'S', ActionNames.ACTION_START, KeyStrokes.ACTION_START); //$NON-NLS-1$
 
         run_start_no_timers = makeMenuItemRes("start_no_timers", ActionNames.ACTION_START_NO_TIMERS); //$NON-NLS-1$
         
         run_stop = makeMenuItemRes("stop", 'T', ActionNames.ACTION_STOP, KeyStrokes.ACTION_STOP); //$NON-NLS-1$
         run_stop.setEnabled(false);
 
         run_shut = makeMenuItemRes("shutdown", 'Y', ActionNames.ACTION_SHUTDOWN, KeyStrokes.ACTION_SHUTDOWN); //$NON-NLS-1$
         run_shut.setEnabled(false);
 
         run_clear = makeMenuItemRes("clear", 'C', ActionNames.CLEAR, KeyStrokes.CLEAR); //$NON-NLS-1$
 
         run_clearAll = makeMenuItemRes("clear_all", 'a', ActionNames.CLEAR_ALL, KeyStrokes.CLEAR_ALL); //$NON-NLS-1$
 
         runMenu.add(run_start);
         runMenu.add(run_start_no_timers);
         if (remote_start != null) {
             runMenu.add(remote_start);
         }
         remote_start_all = makeMenuItemRes("remote_start_all", ActionNames.REMOTE_START_ALL, KeyStrokes.REMOTE_START_ALL); //$NON-NLS-1$
 
         runMenu.add(remote_start_all);
         runMenu.add(run_stop);
         runMenu.add(run_shut);
         if (remote_stop != null) {
             runMenu.add(remote_stop);
         }
         remote_stop_all = makeMenuItemRes("remote_stop_all", 'X', ActionNames.REMOTE_STOP_ALL, KeyStrokes.REMOTE_STOP_ALL); //$NON-NLS-1$
         runMenu.add(remote_stop_all);
 
         if (remote_shut != null) {
             runMenu.add(remote_shut);
         }
         remote_shut_all = makeMenuItemRes("remote_shut_all", 'X', ActionNames.REMOTE_SHUT_ALL, KeyStrokes.REMOTE_SHUT_ALL); //$NON-NLS-1$
         runMenu.add(remote_shut_all);
 
         if (remote_exit != null) {
             runMenu.add(remote_exit);
         }
         remote_exit_all = makeMenuItemRes("remote_exit_all", ActionNames.REMOTE_EXIT_ALL); //$NON-NLS-1$
         runMenu.add(remote_exit_all);
 
         runMenu.addSeparator();
         runMenu.add(run_clear);
         runMenu.add(run_clearAll);
     }
 
     private void makeEditMenu() {
         // EDIT MENU
         editMenu = makeMenuRes("edit",'E'); //$NON-NLS-1$
 
         // From the Java Look and Feel Guidelines: If all items in a menu
         // are disabled, then disable the menu. Makes sense.
         editMenu.setEnabled(false);
     }
 
     private void makeFileMenu() {
         // FILE MENU
         fileMenu = makeMenuRes("file",'F'); //$NON-NLS-1$
 
         JMenuItem file_save = makeMenuItemRes("save", 'S', ActionNames.SAVE, KeyStrokes.SAVE); //$NON-NLS-1$
         file_save.setEnabled(true);
 
         file_save_as = makeMenuItemRes("save_all_as", 'A', ActionNames.SAVE_ALL_AS, KeyStrokes.SAVE_ALL_AS); //$NON-NLS-1$
         file_save_as.setEnabled(true);
 
         file_selection_as = makeMenuItemRes("save_as", ActionNames.SAVE_AS); //$NON-NLS-1$
         file_selection_as.setEnabled(true);
 
         file_revert = makeMenuItemRes("revert_project", 'R', ActionNames.REVERT_PROJECT); //$NON-NLS-1$
         file_revert.setEnabled(false);
 
         file_load = makeMenuItemRes("menu_open", 'O', ActionNames.OPEN, KeyStrokes.OPEN); //$NON-NLS-1$
         // Set default SAVE menu item to disabled since the default node that
         // is selected is ROOT, which does not allow items to be inserted.
         file_load.setEnabled(false);
 
+        create_from_template = makeMenuItemRes("create_from_template", 'T', ActionNames.CREATE_FROM_TEMPLATE); //$NON-NLS-1$
+        create_from_template.setEnabled(true);
+
         file_close = makeMenuItemRes("menu_close", 'C', ActionNames.CLOSE, KeyStrokes.CLOSE); //$NON-NLS-1$
 
         file_exit = makeMenuItemRes("exit", 'X', ActionNames.EXIT, KeyStrokes.EXIT); //$NON-NLS-1$
 
         file_merge = makeMenuItemRes("menu_merge", 'M', ActionNames.MERGE); //$NON-NLS-1$
         // file_merge.setAccelerator(
         // KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
         // Set default SAVE menu item to disabled since the default node that
         // is selected is ROOT, which does not allow items to be inserted.
         file_merge.setEnabled(false);
 
         fileMenu.add(file_close);
         fileMenu.add(file_load);
+        fileMenu.add(create_from_template);
         fileMenu.add(file_merge);
         fileMenu.addSeparator();
         fileMenu.add(file_save);
         fileMenu.add(file_save_as);
         fileMenu.add(file_selection_as);
         fileMenu.add(file_revert);
         fileMenu.addSeparator();
         // Add the recent files, which will also add a separator that is
         // visible when needed
         file_load_recent_files = LoadRecentProject.getRecentFileMenuItems();
         for(JComponent jc : file_load_recent_files){
             fileMenu.add(jc);
         }
         fileMenu.add(file_exit);
     }
 
     private void makeSearchMenu() {
         // Search MENU
         searchMenu = makeMenuRes("menu_search"); //$NON-NLS-1$
 
         JMenuItem search = makeMenuItemRes("menu_search", 'F', ActionNames.SEARCH_TREE, KeyStrokes.SEARCH_TREE); //$NON-NLS-1$
         searchMenu.add(search);
         searchMenu.setEnabled(true);
 
         JMenuItem searchReset = makeMenuItemRes("menu_search_reset", ActionNames.SEARCH_RESET); //$NON-NLS-1$
         searchMenu.add(searchReset);
         searchMenu.setEnabled(true);
     }
     
     public void setRunning(boolean running, String host) {
         log.info("setRunning(" + running + "," + host + ")");
 
         Iterator<JMenuItem> iter = remote_engine_start.iterator();
         Iterator<JMenuItem> iter2 = remote_engine_stop.iterator();
         Iterator<JMenuItem> iter3 = remote_engine_exit.iterator();
         Iterator<JMenuItem> iter4 = remote_engine_shut.iterator();
         while (iter.hasNext() && iter2.hasNext() && iter3.hasNext() &&iter4.hasNext()) {
             JMenuItem start = iter.next();
             JMenuItem stop = iter2.next();
             JMenuItem exit = iter3.next();
             JMenuItem shut = iter4.next();
             if (start.getText().equals(host)) {
                 log.debug("Found start host: " + start.getText());
                 start.setEnabled(!running);
             }
             if (stop.getText().equals(host)) {
                 log.debug("Found stop  host: " + stop.getText());
                 stop.setEnabled(running);
             }
             if (exit.getText().equals(host)) {
                 log.debug("Found exit  host: " + exit.getText());
                 exit.setEnabled(true);
             }
             if (shut.getText().equals(host)) {
                 log.debug("Found exit  host: " + exit.getText());
                 shut.setEnabled(running);
             }
         }
     }
 
     /** {@inheritDoc} */
     @Override
     public void setEnabled(boolean enable) {
         run_start.setEnabled(!enable);
         run_start_no_timers.setEnabled(!enable);
         run_stop.setEnabled(enable);
         run_shut.setEnabled(enable);
     }
 
     private void getRemoteItems() {
         if (remoteHosts.length > 0) {
             remote_start = makeMenuRes("remote_start"); //$NON-NLS-1$
             remote_stop = makeMenuRes("remote_stop"); //$NON-NLS-1$
             remote_shut = makeMenuRes("remote_shut"); //$NON-NLS-1$
             remote_exit = makeMenuRes("remote_exit"); //$NON-NLS-1$
 
             for (int i = 0; i < remoteHosts.length; i++) {
                 remoteHosts[i] = remoteHosts[i].trim();
 
                 JMenuItem item = makeMenuItemNoRes(remoteHosts[i], ActionNames.REMOTE_START);
                 remote_engine_start.add(item);
                 remote_start.add(item);
 
                 item = makeMenuItemNoRes(remoteHosts[i], ActionNames.REMOTE_STOP);
                 item.setEnabled(false);
                 remote_engine_stop.add(item);
                 remote_stop.add(item);
 
                 item = makeMenuItemNoRes(remoteHosts[i], ActionNames.REMOTE_SHUT);
                 item.setEnabled(false);
                 remote_engine_shut.add(item);
                 remote_shut.add(item);
 
                 item = makeMenuItemNoRes(remoteHosts[i],ActionNames.REMOTE_EXIT);
                 item.setEnabled(false);
                 remote_engine_exit.add(item);
                 remote_exit.add(item);
             }
         }
     }
 
     /** {@inheritDoc} */
     @Override
     public void localeChanged(LocaleChangeEvent event) {
         updateMenuElement(fileMenu);
         updateMenuElement(editMenu);
         updateMenuElement(searchMenu);
         updateMenuElement(runMenu);
         updateMenuElement(optionsMenu);
         updateMenuElement(helpMenu);
     }
 
     /**
      * Get a list of all installed LAFs plus CrossPlatform and System.
      */
     // This is also used by LookAndFeelCommand
     public static LookAndFeelInfo[] getAllLAFs() {
         UIManager.LookAndFeelInfo lafs[] = UIManager.getInstalledLookAndFeels();
         int i = lafs.length;
         UIManager.LookAndFeelInfo lafsAll[] = new UIManager.LookAndFeelInfo[i+2];
         System.arraycopy(lafs, 0, lafsAll, 0, i);
         lafsAll[i++]=new UIManager.LookAndFeelInfo(CROSS_PLATFORM_LAF,UIManager.getCrossPlatformLookAndFeelClassName());
         lafsAll[i++]=new UIManager.LookAndFeelInfo(SYSTEM_LAF,UIManager.getSystemLookAndFeelClassName());
         return lafsAll;
     }
     /**
      * <p>Refreshes all texts in the menu and all submenus to a new locale.</p>
      *
      * <p>Assumes that the item name is set to the resource key, so the resource can be retrieved.
      * Certain action types do not follow this rule, @see JMeterMenuBar#isNotResource(String)</p>
      *
      * The Language Change event assumes that the name is the same as the locale name,
      * so this additionally means that all supported locales must be defined as resources.
      *
      */
     private void updateMenuElement(MenuElement menu) {
         Component component = menu.getComponent();
         final String compName = component.getName();
         if (compName != null) {
             if (component instanceof JMenu) {
                 final JMenu jMenu = (JMenu) component;
                 if (isResource(jMenu.getActionCommand())){
                     jMenu.setText(JMeterUtils.getResString(compName));
                 }
             } else {
                 final JMenuItem jMenuItem = (JMenuItem) component;
                 if (isResource(jMenuItem.getActionCommand())){
                     jMenuItem.setText(JMeterUtils.getResString(compName));
                 } else if  (ActionNames.CHANGE_LANGUAGE.equals(jMenuItem.getActionCommand())){
                     jMenuItem.setText(JMeterUtils.getLocaleString(compName));
                 }
             }
         }
 
         MenuElement[] subelements = menu.getSubElements();
 
         for (int i = 0; i < subelements.length; i++) {
             updateMenuElement(subelements[i]);
         }
     }
 
     /**
      * Return true if component name is a resource.<br/>
      * i.e it is not a hostname:<br/>
      *
      * <tt>ActionNames.REMOTE_START</tt><br/>
      * <tt>ActionNames.REMOTE_STOP</tt><br/>
      * <tt>ActionNames.REMOTE_EXIT</tt><br/>
      *
      * nor a filename:<br/>
      * <tt>ActionNames.OPEN_RECENT</tt>
      *
      * nor a look and feel prefix:<br/>
      * <tt>ActionNames.LAF_PREFIX</tt>
      */
     private static boolean isResource(String actionCommand) {
         if (ActionNames.CHANGE_LANGUAGE.equals(actionCommand)){//
             return false;
         }
         if (ActionNames.ADD.equals(actionCommand)){//
             return false;
         }
         if (ActionNames.REMOTE_START.equals(actionCommand)){//
             return false;
         }
         if (ActionNames.REMOTE_STOP.equals(actionCommand)){//
             return false;
         }
         if (ActionNames.REMOTE_SHUT.equals(actionCommand)){//
             return false;
         }
         if (ActionNames.REMOTE_EXIT.equals(actionCommand)){//
             return false;
         }
         if (ActionNames.OPEN_RECENT.equals(actionCommand)){//
             return false;
         }
         if (actionCommand != null && actionCommand.startsWith(ActionNames.LAF_PREFIX)){
             return false;
         }
         return true;
     }
 
     /**
      * Make a menu from a resource string.
      * @param resource used to name menu and set text.
      * @return the menu
      */
     private static JMenu makeMenuRes(String resource) {
         JMenu menu = new JMenu(JMeterUtils.getResString(resource));
         menu.setName(resource);
         return menu;
     }
 
     /**
      * Make a menu from a resource string and set its mnemonic.
      *
      * @param resource
      * @param mnemonic
      * @return the menu
      */
     private static JMenu makeMenuRes(String resource, int mnemonic){
         JMenu menu = makeMenuRes(resource);
         menu.setMnemonic(mnemonic);
         return menu;
     }
 
     /**
      * Make a menuItem using a fixed label which is also used as the item name.
      * This is used for items such as recent files and hostnames which are not resources
      * @param label (this is not used as a resource key)
      * @param actionCommand
      * @return the menu item
      */
     private static JMenuItem makeMenuItemNoRes(String label, String actionCommand) {
         JMenuItem menuItem = new JMenuItem(label);
         menuItem.setName(label);
         menuItem.setActionCommand(actionCommand);
         menuItem.addActionListener(ActionRouter.getInstance());
         return menuItem;
     }
 
     private static JMenuItem makeMenuItemRes(String resource, String actionCommand) {
         return makeMenuItemRes(resource, KeyEvent.VK_UNDEFINED, actionCommand, null);
     }
 
     private static JMenuItem makeMenuItemRes(String resource, String actionCommand, KeyStroke keyStroke) {
         return makeMenuItemRes(resource, KeyEvent.VK_UNDEFINED, actionCommand, keyStroke);
     }
 
     private static JMenuItem makeMenuItemRes(String resource, int mnemonic, String actionCommand) {
         return makeMenuItemRes(resource, mnemonic, actionCommand, null);
     }
 
     private static JMenuItem makeMenuItemRes(String resource, int mnemonic, String actionCommand, KeyStroke keyStroke){
         JMenuItem menuItem = new JMenuItem(JMeterUtils.getResString(resource), mnemonic);
         menuItem.setName(resource);
         menuItem.setActionCommand(actionCommand);
         menuItem.setAccelerator(keyStroke);
         menuItem.addActionListener(ActionRouter.getInstance());
         return menuItem;
     }
     
     private static JCheckBoxMenuItem makeCheckBoxMenuItemRes(String resource, String actionCommand) {
         return makeCheckBoxMenuItemRes(resource, actionCommand, null);
     }
 
     private static JCheckBoxMenuItem makeCheckBoxMenuItemRes(String resource, 
             String actionCommand, KeyStroke keyStroke){
         JCheckBoxMenuItem cbkMenuItem = new JCheckBoxMenuItem(JMeterUtils.getResString(resource));
         cbkMenuItem.setName(resource);
         cbkMenuItem.setActionCommand(actionCommand);
         cbkMenuItem.setAccelerator(keyStroke);
         cbkMenuItem.addActionListener(ActionRouter.getInstance());
         return cbkMenuItem;
     }
 }
diff --git a/src/core/org/apache/jmeter/resources/messages.properties b/src/core/org/apache/jmeter/resources/messages.properties
index 12aca6ca8..e0b7e8593 100644
--- a/src/core/org/apache/jmeter/resources/messages.properties
+++ b/src/core/org/apache/jmeter/resources/messages.properties
@@ -1,1259 +1,1263 @@
 #   Licensed to the Apache Software Foundation (ASF) under one or more
 #   contributor license agreements.  See the NOTICE file distributed with
 #   this work for additional information regarding copyright ownership.
 #   The ASF licenses this file to You under the Apache License, Version 2.0
 #   (the "License"); you may not use this file except in compliance with
 #   the License.  You may obtain a copy of the License at
 # 
 #       http://www.apache.org/licenses/LICENSE-2.0
 # 
 #   Unless required by applicable law or agreed to in writing, software
 #   distributed under the License is distributed on an "AS IS" BASIS,
 #   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 #   See the License for the specific language governing permissions and
 #   limitations under the License.
 
 # Warning: JMeterUtils.getResString() replaces space with '_'
 # and converts keys to lowercase before lookup
 # => All keys in this file must also be lower case or they won't match
 #
 
 # Please add new entries in alphabetical order
 
 about=About Apache JMeter
 active_threads_tooltip=Running threads
 add=Add
 add_from_clipboard=Add from Clipboard
 add_from_suggested_excludes=Add suggested Excludes
 add_as_child=Add as Child
 add_parameter=Add Variable
 add_pattern=Add Pattern\:
 add_test=Add Test
 add_user=Add User
 add_value=Add Value
 addtest=Add test
 aggregate_graph=Statistical Graphs
 aggregate_graph_choose_color=Choose color
 aggregate_graph_choose_foreground_color=Foreground color
 aggregate_graph_color_bar=Color\:
 aggregate_graph_column=Column\:
 aggregate_graph_column_selection=Column label selection\:
 aggregate_graph_column_settings=Column settings
 aggregate_graph_columns_to_display=Columns to display\:
 aggregate_graph_dimension=Graph size
 aggregate_graph_display=Display Graph
 aggregate_graph_draw_outlines=Draw outlines bar?
 aggregate_graph_dynamic_size=Dynamic graph size
 aggregate_graph_font=Font\:
 aggregate_graph_height=Height\:
 aggregate_graph_increment_scale=Increment scale\:
 aggregate_graph_legend=Legend
 aggregate_graph_legend.placement.bottom=Bottom
 aggregate_graph_legend.placement.left=Left
 aggregate_graph_legend.placement.right=Right
 aggregate_graph_legend.placement.top=Top
 aggregate_graph_legend_placement=Placement\:
 aggregate_graph_max_length_xaxis_label=Max length of x-axis label\:
 aggregate_graph_ms=Milliseconds
 aggregate_graph_no_values_to_graph=No values to graph
 aggregate_graph_number_grouping=Show number grouping?
 aggregate_graph_response_time=Response Time
 aggregate_graph_save=Save Graph
 aggregate_graph_save_table=Save Table Data
 aggregate_graph_save_table_header=Save Table Header
 aggregate_graph_size=Size\:
 aggregate_graph_style=Style\:
 aggregate_graph_sync_with_name=Synchronize with name
 aggregate_graph_tab_graph=Graph
 aggregate_graph_tab_settings=Settings
 aggregate_graph_title=Aggregate Graph
 aggregate_graph_title_group=Title
 aggregate_graph_use_group_name=Include group name in label?
 aggregate_graph_user_title=Graph title\:
 aggregate_graph_value_font=Value font\:
 aggregate_graph_value_labels_vertical=Value labels vertical?
 aggregate_graph_width=Width\:
 aggregate_graph_xaxis_group=X Axis
 aggregate_graph_yaxis_group=Y Axis (milli-seconds)
 aggregate_graph_yaxis_max_value=Scale maximum value\:
 aggregate_report=Aggregate Report
 aggregate_report_90=90%
 aggregate_report_90%_line=90% Line
 aggregate_report_bandwidth=KB/sec
 aggregate_report_count=# Samples
 aggregate_report_error=Error
 aggregate_report_error%=Error %
 aggregate_report_max=Max
 aggregate_report_median=Median
 aggregate_report_min=Min
 aggregate_report_rate=Throughput
 aggregate_report_stddev=Std. Dev.
 aggregate_report_total_label=TOTAL
 ajp_sampler_title=AJP/1.3 Sampler
 als_message=Note\: The Access Log Parser is generic in design and allows you to plugin
 als_message2=your own parser. To do so, implement the LogParser, add the jar to the
 als_message3=/lib directory and enter the class in the sampler.
 analyze=Analyze Data File...
 anchor_modifier_title=HTML Link Parser
 appearance=Look and Feel
 argument_must_not_be_negative=The Argument must not be negative\!
 arguments_panel_title=Command parameters
 assertion_assume_success=Ignore Status
 assertion_body_resp=Response Body
 assertion_code_resp=Response Code
 assertion_contains=Contains
 assertion_equals=Equals
 assertion_headers=Response Headers
 assertion_matches=Matches
 assertion_message_resp=Response Message
 assertion_network_size=Full Response
 assertion_not=Not
 assertion_pattern_match_rules=Pattern Matching Rules
 assertion_patterns_to_test=Patterns to Test
 assertion_resp_field=Response Field to Test
 assertion_resp_size_field=Response Size Field to Test
 assertion_substring=Substring
 assertion_text_document=Document (text)
 assertion_text_resp=Text Response
 assertion_textarea_label=Assertions\:
 assertion_title=Response Assertion
 assertion_url_samp=URL Sampled
 assertion_visualizer_title=Assertion Results
 attribute=Attribute
 attribute_field=Attribute\:
 attrs=Attributes
 auth_base_url=Base URL
 auth_manager_title=HTTP Authorization Manager
 auths_stored=Authorizations Stored in the Authorization Manager
 average=Average
 average_bytes=Avg. Bytes
 bind=Thread Bind
 bouncy_castle_unavailable_message=The jars for bouncy castle are unavailable, please add them to your classpath.
 browse=Browse...
 bsf_sampler_title=BSF Sampler
 bsf_script=Script to run (variables: ctx vars props SampleResult sampler log Label FileName Parameters args[] OUT)
 bsf_script_file=Script file to run
 bsf_script_language=Scripting language\:
 bsf_script_parameters=Parameters to pass to script/file\:
 bsh_assertion_script=Script (see below for variables that are defined)
 bsh_assertion_script_variables=The following variables are defined for the script:\nRead/Write: Failure, FailureMessage, SampleResult, vars, props, log.\nReadOnly: Response[Data|Code|Message|Headers], RequestHeaders, SampleLabel, SamplerData, ctx
 bsh_assertion_title=BeanShell Assertion
 bsh_function_expression=Expression to evaluate
 bsh_sampler_title=BeanShell Sampler
 bsh_script=Script (see below for variables that are defined)
 bsh_script_file=Script file
 bsh_script_parameters=Parameters (-> String Parameters and String []bsh.args)
 bsh_script_reset_interpreter=Reset bsh.Interpreter before each call
 bsh_script_variables=The following variables are defined for the script\:\nSampleResult, ResponseCode, ResponseMessage, IsSuccess, Label, FileName, ctx, vars, props, log
 busy_testing=I'm busy testing, please stop the test before changing settings
 cache_manager_size=Max Number of elements in cache
 cache_manager_title=HTTP Cache Manager
 cache_session_id=Cache Session Id?
 cancel=Cancel
 cancel_exit_to_save=There are test items that have not been saved.  Do you wish to save before exiting?
 cancel_new_to_save=There are test items that have not been saved.  Do you wish to save before clearing the test plan?
 cancel_revert_project=There are test items that have not been saved.  Do you wish to revert to the previously saved test plan?
 cssjquery_attribute=Attribute\:
 cssjquery_impl=CSS/JQuery implementation\:
 cssjquery_render_no_text=Data response result isn't text.
 cssjquery_tester_button_test=Test
 cssjquery_tester_field=Selector\:
 cssjquery_tester_title=CSS/JQuery Tester
 change_parent=Change Controller
 char_value=Unicode character number (decimal or 0xhex)
 check_return_code_title=Check Return Code
 choose_function=Choose a function
 choose_language=Choose Language
 clear=Clear
 clear_all=Clear All
 clear_cache_per_iter=Clear cache each iteration?
 clear_cookies_per_iter=Clear cookies each iteration?
 clipboard_node_read_error=An error occurred while copying node
 close=Close
 closeconnection=Close connection
 column_delete_disallowed=Deleting this column is not permitted
 column_number=Column number of CSV file | next | *alias
 command_config_box_title=Command to Execute
 command_config_std_streams_title=Standard streams (files)
 command_field_title=Command:
 compare=Compare
 comparefilt=Compare filter
 comparison_differ_content=Responses differ in content
 comparison_differ_time=Responses differ in response time by more than 
 comparison_invalid_node=Invalid Node 
 comparison_regex_string=Regex String
 comparison_regex_substitution=Substitution
 comparison_response_time=Response Time: 
 comparison_unit=\ ms
 comparison_visualizer_title=Comparison Assertion Visualizer
 config_element=Config Element
 config_save_settings=Configure
 configure_wsdl=Configure
 confirm=Confirm
 constant_throughput_timer_memo=Add a delay between sampling to attain constant throughput
 constant_timer_delay=Thread Delay (in milliseconds)\:
 constant_timer_memo=Add a constant delay between sampling
 constant_timer_title=Constant Timer
 content_encoding=Content encoding\:
 controller=Controller
 cookie_implementation_choose=Implementation:
 cookie_manager_policy=Cookie Policy:
 cookie_manager_title=HTTP Cookie Manager
 cookie_options=Options
 cookies_stored=User-Defined Cookies
 copy=Copy
 counter_config_title=Counter
 counter_per_user=Track counter independently for each user
 counter_reset_per_tg_iteration=Reset counter on each Thread Group Iteration
 countlim=Size limit
+create_from_template=New from templates
 csvread_file_file_name=CSV file to get values from | *alias
 cut=Cut
 cut_paste_function=Copy and paste function string
 database_conn_pool_max_usage=Max Usage For Each Connection\:
 database_conn_pool_props=Database Connection Pool
 database_conn_pool_size=Number of Connections in Pool\:
 database_conn_pool_title=JDBC Database Connection Pool Defaults
 database_driver_class=Driver Class\:
 database_login_title=JDBC Database Login Defaults
 database_sql_query_string=SQL Query String\:
 database_sql_query_title=JDBC SQL Query Defaults
 database_testing_title=JDBC Request
 database_url=JDBC URL\:
 database_url_jdbc_props=Database URL and JDBC Driver
 ddn=DN
 de=German
 debug_off=Disable debug
 debug_on=Enable debug
 default_parameters=Default Parameters
 default_value_field=Default Value\:
 delay=Startup delay (seconds)
 delayed_start=Delay Thread creation until needed
 delete=Delete
 delete_parameter=Delete Variable
 delete_test=Delete Test
 delete_user=Delete User
 deltest=Deletion test
 deref=Dereference aliases
 description=Description
 detail=Detail
 directory_field_title=Working directory:
 disable=Disable
 distribution_graph_title=Distribution Graph (alpha)
 distribution_note1=The graph will update every 10 samples
 dn=DN
 domain=Domain
 done=Done
 down=Down
 duplicate=Duplicate
 duration=Duration (seconds)
 duration_assertion_duration_test=Duration to Assert
 duration_assertion_failure=The operation lasted too long\: It took {0} milliseconds, but should not have lasted longer than {1} milliseconds.
 duration_assertion_input_error=Please enter a valid positive integer.
 duration_assertion_label=Duration in milliseconds\:
 duration_assertion_title=Duration Assertion
 edit=Edit
 email_results_title=Email Results
 en=English
 enable=Enable
 encode?=Encode?
 encoded_value=URL Encoded Value
 endtime=End Time  
 entry_dn=Entry DN
 entrydn=Entry DN
 environment_panel_title=Environment Variables
 eolbyte=End of line(EOL) byte value: 
 error_indicator_tooltip=Show the number of errors in log, click to open Log Viewer panel
 error_loading_help=Error loading help page
 error_occurred=Error Occurred
 error_title=Error
 es=Spanish
 escape_html_string=String to escape
 eval_name_param=Text containing variable and function references
 evalvar_name_param=Name of variable
 example_data=Sample Data
 example_title=Example Sampler
 exit=Exit
 expand=Expand
 expected_return_code_title=Expected Return Code: 
 expiration=Expiration
 expression_field=CSS/JQuery expression\:
 field_name=Field name
 file=File
 file_already_in_use=That file is already in use
 file_visualizer_append=Append to Existing Data File
 file_visualizer_auto_flush=Automatically Flush After Each Data Sample
 file_visualizer_browse=Browse...
 file_visualizer_close=Close
 file_visualizer_file_options=File Options
 file_visualizer_filename=Filename
 file_visualizer_flush=Flush
 file_visualizer_missing_filename=No output filename specified.
 file_visualizer_open=Open
 file_visualizer_output_file=Write results to file / Read from file
 file_visualizer_submit_data=Include Submitted Data
 file_visualizer_title=File Reporter
 file_visualizer_verbose=Verbose Output
 filename=File Name
 follow_redirects=Follow Redirects
 follow_redirects_auto=Redirect Automatically
 font.sansserif=Sans Serif
 font.serif=Serif
 fontstyle.bold=Bold
 fontstyle.italic=Italic
 fontstyle.normal=Normal
 foreach_controller_title=ForEach Controller
 foreach_end_index=End index for loop
 foreach_input=Input variable prefix
 foreach_output=Output variable name
 foreach_start_index=Start index for loop
 foreach_use_separator=Add "_" before number ?
 format=Number format
 fr=French
 ftp_binary_mode=Use Binary mode ?
 ftp_get=get(RETR)
 ftp_local_file=Local File:
 ftp_local_file_contents=Local File Contents:
 ftp_put=put(STOR)
 ftp_remote_file=Remote File:
 ftp_sample_title=FTP Request Defaults
 ftp_save_response_data=Save File in Response ?
 ftp_testing_title=FTP Request
 function_dialog_menu_item=Function Helper Dialog
 function_helper_title=Function Helper
 function_name_param=Name of variable in which to store the result (required)
 function_name_paropt=Name of variable in which to store the result (optional)
 function_params=Function Parameters
 functional_mode=Functional Test Mode (i.e. save Response Data and Sampler Data)
 functional_mode_explanation=Selecting Functional Test Mode may adversely affect performance.
 gaussian_timer_delay=Constant Delay Offset (in milliseconds)\:
 gaussian_timer_memo=Adds a random delay with a gaussian distribution
 gaussian_timer_range=Deviation (in milliseconds)\:
 gaussian_timer_title=Gaussian Random Timer
 generate=Generate
 generator=Name of Generator class
 generator_cnf_msg=Could not find the generator class. Please make sure you place your jar file in the /lib directory.
 generator_illegal_msg=Could not access the generator class due to IllegalAccessException.
 generator_instantiate_msg=Could not create an instance of the generator parser. Please make sure the generator implements Generator interface.
 get_xml_from_file=File with SOAP XML Data (overrides above text)
 get_xml_from_random=Message(s) Folder
 graph_apply_filter=Apply filter
 graph_choose_graphs=Graphs to Display
 graph_full_results_title=Graph Full Results
 graph_pointshape_circle=Circle
 graph_pointshape_diamond=Diamond
 graph_pointshape_square=Square
 graph_pointshape_triangle=Triangle
 graph_pointshape_none=None
 graph_resp_time_interval_label=Interval (ms):
 graph_resp_time_interval_reload=Apply interval
 graph_resp_time_not_enough_data=Unable to graph, not enough data
 graph_resp_time_series_selection=Sampler label selection:
 graph_resp_time_settings_line=Line settings
 graph_resp_time_settings_pane=Graph settings
 graph_resp_time_shape_label=Shape point:
 graph_resp_time_stroke_width=Stroke width:
 graph_resp_time_title=Response Time Graph
 graph_resp_time_title_label=Graph title:
 graph_resp_time_xaxis_time_format=Time format (SimpleDateFormat):
 graph_results_average=Average
 graph_results_data=Data
 graph_results_deviation=Deviation
 graph_results_latest_sample=Latest Sample
 graph_results_median=Median
 graph_results_ms=ms
 graph_results_no_samples=No of Samples
 graph_results_throughput=Throughput
 graph_results_title=Graph Results
 grouping_add_separators=Add separators between groups
 grouping_in_controllers=Put each group in a new controller
 grouping_in_transaction_controllers=Put each group in a new transaction controller
 grouping_mode=Grouping\:
 grouping_no_groups=Do not group samplers
 grouping_store_first_only=Store 1st sampler of each group only
 header_manager_title=HTTP Header Manager
 headers_stored=Headers Stored in the Header Manager
 heap_dump=Create a heap dump
 help=Help
 help_node=What's this node?
 html_assertion_file=Write JTidy report to file
 html_assertion_label=HTML Assertion
 html_assertion_title=HTML Assertion
 html_extractor_type=CSS/JQuery Extractor Implementation
 html_extractor_title=CSS/JQuery Extractor
 html_parameter_mask=HTML Parameter Mask (DEPRECATED)
 http_implementation=Implementation:
 http_response_code=HTTP response code
 http_url_rewriting_modifier_title=HTTP URL Re-writing Modifier
 http_user_parameter_modifier=HTTP User Parameter Modifier
 httpmirror_title=HTTP Mirror Server
 httpmirror_settings=Settings
 httpmirror_max_pool_size=Max number of Threads:
 httpmirror_max_queue_size=Max queue size:
 id_prefix=ID Prefix
 id_suffix=ID Suffix
 if_controller_evaluate_all=Evaluate for all children?
 if_controller_expression=Interpret Condition as Variable Expression?
 if_controller_label=Condition (default Javascript)
 if_controller_title=If Controller
 ignore_subcontrollers=Ignore sub-controller blocks
 include_controller=Include Controller
 include_equals=Include Equals?
 include_path=Include Test Plan
 increment=Increment
 infinite=Forever
 initial_context_factory=Initial Context Factory
 insert_after=Insert After
 insert_before=Insert Before
 insert_parent=Insert Parent
 interleave_control_title=Interleave Controller
 intsum_param_1=First int to add.
 intsum_param_2=Second int to add - further ints can be summed by adding further arguments.
 invalid_data=Invalid data
 invalid_mail=Error occurred sending the e-mail
 invalid_mail_address=One or more invalid e-mail addresses detected
 invalid_mail_server=Problem contacting the e-mail server (see JMeter log file)
 invalid_variables=Invalid variables
 iteration_counter_arg_1=TRUE, for each user to have own counter, FALSE for a global counter
 iterator_num=Loop Count\:
 ja=Japanese
 jar_file=Jar Files
 java_request=Java Request
 java_request_defaults=Java Request Defaults
 javascript_expression=JavaScript expression to evaluate
 jexl_expression=JEXL expression to evaluate
 jms_auth_required=Required
 jms_bytes_message=Bytes Message
 jms_client_caption=Receiver client uses MessageConsumer.receive() to listen for message.
 jms_client_caption2=MessageListener uses onMessage(Message) interface to listen for new messages.
 jms_client_id=Client ID
 jms_client_type=Client
 jms_communication_style=Communication style
 jms_concrete_connection_factory=Concrete Connection Factory
 jms_config=Message source
 jms_config_title=JMS Configuration
 jms_connection_factory=Connection Factory
 jms_correlation_title=Use alternate fields for message correlation
 jms_dest_setup=Setup
 jms_dest_setup_dynamic=Each sample
 jms_dest_setup_static=At startup
 jms_durable_subscription_id=Durable Subscription ID
 jms_file=File
 jms_initial_context_factory=Initial Context Factory
 jms_itertions=Number of samples to aggregate
 jms_jndi_defaults_title=JNDI Default Configuration
 jms_jndi_props=JNDI Properties
 jms_map_message=Map Message
 jms_message_title=Message properties
 jms_message_type=Message Type
 jms_msg_content=Content
 jms_object_message=Object Message
 jms_point_to_point=JMS Point-to-Point
 jms_props=JMS Properties
 jms_provider_url=Provider URL
 jms_publisher=JMS Publisher
 jms_pwd=Password
 jms_queue=Queue
 jms_queue_connection_factory=QueueConnection Factory
 jms_queueing=JMS Resources
 jms_random_file=Random folder containing files ending with .dat for bytes messages, .txt or .obj for text and Object messages
 jms_read_response=Read Response
 jms_receive_queue=JNDI name Receive queue
 jms_request=Request Only
 jms_requestreply=Request Response
 jms_sample_title=JMS Default Request
 jms_selector=JMS Selector
 jms_send_queue=JNDI name Request queue
 jms_separator=Separator
 jms_stop_between_samples=Stop between samples?
 jms_subscriber_on_message=Use MessageListener.onMessage()
 jms_subscriber_receive=Use MessageConsumer.receive()
 jms_subscriber_title=JMS Subscriber
 jms_testing_title=Messaging Request
 jms_text_area=Text Message or Object Message serialized to XML by XStream
 jms_text_message=Text Message
 jms_timeout=Timeout (milliseconds)
 jms_topic=Destination
 jms_use_auth=Use Authorization?
 jms_use_file=From file
 jms_use_non_persistent_delivery=Use non-persistent delivery mode?
 jms_use_properties_file=Use jndi.properties file
 jms_use_random_file=Random File from folder specified below
 jms_use_req_msgid_as_correlid=Use Request Message Id
 jms_use_res_msgid_as_correlid=Use Response Message Id
 jms_use_text=Textarea
 jms_user=User
 jndi_config_title=JNDI Configuration
 jndi_lookup_name=Remote Interface
 jndi_lookup_title=JNDI Lookup Configuration
 jndi_method_button_invoke=Invoke
 jndi_method_button_reflect=Reflect
 jndi_method_home_name=Home Method Name
 jndi_method_home_parms=Home Method Parameters
 jndi_method_name=Method Configuration
 jndi_method_remote_interface_list=Remote Interfaces
 jndi_method_remote_name=Remote Method Name
 jndi_method_remote_parms=Remote Method Parameters
 jndi_method_title=Remote Method Configuration
 jndi_testing_title=JNDI Request
 jndi_url_jndi_props=JNDI Properties
 junit_append_error=Append assertion errors
 junit_append_exception=Append runtime exceptions
 junit_constructor_error=Unable to create an instance of the class
 junit_constructor_string=Constructor String Label
 junit_create_instance_per_sample=Create a new instance per sample
 junit_do_setup_teardown=Do not call setUp and tearDown
 junit_error_code=Error Code
 junit_error_default_code=9999
 junit_error_default_msg=An unexpected error occured
 junit_error_msg=Error Message
 junit_failure_code=Failure Code
 junit_failure_default_code=0001
 junit_failure_default_msg=Test failed
 junit_failure_msg=Failure Message
 junit_junit4=Search for JUnit 4 annotations (instead of JUnit 3)
 junit_pkg_filter=Package Filter
 junit_request=JUnit Request
 junit_request_defaults=JUnit Request Defaults
 junit_success_code=Success Code
 junit_success_default_code=1000
 junit_success_default_msg=Test successful
 junit_success_msg=Success Message
 junit_test_config=JUnit Test Parameters
 junit_test_method=Test Method
 ldap_argument_list=LDAPArgument List
 ldap_connto=Connection timeout (in milliseconds)
 ldap_parse_results=Parse the search results ?
 ldap_sample_title=LDAP Request Defaults
 ldap_search_baseobject=Perform baseobject search
 ldap_search_onelevel=Perform onelevel search
 ldap_search_subtree=Perform subtree search
 ldap_secure=Use Secure LDAP Protocol ?
 ldap_testing_title=LDAP Request
 ldapext_sample_title=LDAP Extended Request Defaults
 ldapext_testing_title=LDAP Extended Request
 library=Library
 load=Load
 load_wsdl=Load WSDL
 log_errors_only=Errors
 log_file=Location of log File
 log_function_comment=Additional comment (optional)
 log_function_level=Log level (default INFO) or OUT or ERR
 log_function_string=String to be logged
 log_function_string_ret=String to be logged (and returned)
 log_function_throwable=Throwable text (optional)
 log_only=Log/Display Only:
 log_parser=Name of Log Parser class
 log_parser_cnf_msg=Could not find the class. Please make sure you place your jar file in the /lib directory.
 log_parser_illegal_msg=Could not access the class due to IllegalAccessException.
 log_parser_instantiate_msg=Could not create an instance of the log parser. Please make sure the parser implements LogParser interface.
 log_sampler=Tomcat Access Log Sampler
 log_success_only=Successes
 logic_controller_title=Simple Controller
 login_config=Login Configuration
 login_config_element=Login Config Element
 longsum_param_1=First long to add
 longsum_param_2=Second long to add - further longs can be summed by adding further arguments.
 loop_controller_title=Loop Controller
 looping_control=Looping Control
 lower_bound=Lower Bound
 mail_reader_account=Username:
 mail_reader_all_messages=All
 mail_reader_delete=Delete messages from the server
 mail_reader_folder=Folder:
 mail_reader_num_messages=Number of messages to retrieve:
 mail_reader_password=Password:
 mail_reader_port=Server Port (optional):
 mail_reader_server=Server Host:
 mail_reader_server_type=Protocol (e.g. pop3, imaps):
 mail_reader_storemime=Store the message using MIME (raw)
 mail_reader_title=Mail Reader Sampler
 mail_sent=Mail sent successfully
 mailer_addressees=Addressee(s): 
 mailer_attributes_panel=Mailing attributes
 mailer_connection_security=Connection security: 
 mailer_error=Couldn't send mail. Please correct any misentries.
 mailer_failure_limit=Failure Limit: 
 mailer_failure_subject=Failure Subject: 
 mailer_failures=Failures: 
 mailer_from=From: 
 mailer_host=Host: 
 mailer_login=Login: 
 mailer_msg_title_error=Error
 mailer_msg_title_information=Information
 mailer_password=Password: 
 mailer_port=Port: 
 mailer_string=E-Mail Notification
 mailer_success_limit=Success Limit: 
 mailer_success_subject=Success Subject: 
 mailer_test_mail=Test Mail
 mailer_title_message=Message
 mailer_title_settings=Mailer settings
 mailer_title_smtpserver=SMTP server
 mailer_visualizer_title=Mailer Visualizer
 match_num_field=Match No. (0 for Random)\: 
 max=Maximum
 maximum_param=The maximum value allowed for a range of values
 md5hex_assertion_failure=Error asserting MD5 sum : got {0} but should have been {1}
 md5hex_assertion_label=MD5Hex
 md5hex_assertion_md5hex_test=MD5Hex to Assert
 md5hex_assertion_title=MD5Hex Assertion
 memory_cache=Memory Cache
 menu_assertions=Assertions
 menu_close=Close
 menu_collapse_all=Collapse All
 menu_config_element=Config Element
 menu_edit=Edit
 menu_expand_all=Expand All
 menu_fragments=Test Fragment
 menu_generative_controller=Sampler
 menu_listener=Listener
 menu_logic_controller=Logic Controller
 menu_logger_panel=Log Viewer 
 menu_merge=Merge
 menu_modifiers=Modifiers
 menu_non_test_elements=Non-Test Elements
 menu_open=Open
 menu_post_processors=Post Processors
 menu_pre_processors=Pre Processors
 menu_response_based_modifiers=Response Based Modifiers
 menu_search=Search
 menu_search_reset=Reset Search
 menu_tables=Table
 menu_threads=Threads (Users)
 menu_timer=Timer
 menu_toolbar=Toolbar
 metadata=MetaData
 method=Method\:
 mimetype=Mimetype
 minimum_param=The minimum value allowed for a range of values
 minute=minute
 modddn=Old entry name
 modification_controller_title=Modification Controller
 modification_manager_title=Modification Manager
 modify_test=Modify Test
 modtest=Modification test
 module_controller_module_to_run=Module To Run 
 module_controller_title=Module Controller
 module_controller_warning=Could not find module: 
 monitor_equation_active=Active:  (busy/max) > 25%
 monitor_equation_dead=Dead:  no response
 monitor_equation_healthy=Healthy:  (busy/max) < 25%
 monitor_equation_load=Load:  ( (busy / max) * 50) + ( (used memory / max memory) * 50)
 monitor_equation_warning=Warning:  (busy/max) > 67%
 monitor_health_tab_title=Health
 monitor_health_title=Monitor Results
 monitor_is_title=Use as Monitor
 monitor_label_left_bottom=0 %
 monitor_label_left_middle=50 %
 monitor_label_left_top=100 %
 monitor_label_prefix=Connection Prefix
 monitor_label_right_active=Active
 monitor_label_right_dead=Dead
 monitor_label_right_healthy=Healthy
 monitor_label_right_warning=Warning
 monitor_legend_health=Health
 monitor_legend_load=Load
 monitor_legend_memory_per=Memory % (used/total)
 monitor_legend_thread_per=Thread % (busy/max)
 monitor_load_factor_mem=50
 monitor_load_factor_thread=50
 monitor_performance_servers=Servers
 monitor_performance_tab_title=Performance
 monitor_performance_title=Performance Graph
 name=Name\:
 new=New
 newdn=New distinguished name
 next=Next
 no=Norwegian
 number_of_threads=Number of Threads (users)\:
 obsolete_test_element=This test element is obsolete
 once_only_controller_title=Once Only Controller
 opcode=opCode
 open=Open...
 option=Options
 optional_tasks=Optional Tasks
 paramtable=Send Parameters With the Request\:
 password=Password
 paste=Paste
 paste_insert=Paste As Insert
 path=Path\:
 path_extension_choice=Path Extension (use ";" as separator)
 path_extension_dont_use_equals=Do not use equals in path extension (Intershop Enfinity compatibility)
 path_extension_dont_use_questionmark=Do not use questionmark in path extension (Intershop Enfinity compatibility)
 patterns_to_exclude=URL Patterns to Exclude
 patterns_to_include=URL Patterns to Include
 pkcs12_desc=PKCS 12 Key (*.p12)
 pl=Polish
 poisson_timer_delay=Constant Delay Offset (in milliseconds)\:
 poisson_timer_memo=Adds a random delay with a poisson distribution
 poisson_timer_range=Lambda (in milliseconds)\:
 poisson_timer_title=Poisson Random Timer
 port=Port\:
 post_as_parameters=Parameters
 post_body=Post Body
 post_body_raw=Raw Post Body
 post_thread_group_title=tearDown Thread Group
 previous=Previous
 property_as_field_label={0}\:
 property_default_param=Default value
 property_edit=Edit
 property_editor.value_is_invalid_message=The text you just entered is not a valid value for this property.\nThe property will be reverted to its previous value.
 property_editor.value_is_invalid_title=Invalid input
 property_name_param=Name of property
 property_returnvalue_param=Return Original Value of property (default false) ?
 #property_tool_tip={0}\: {1}
 property_tool_tip=<html><b>{0}</b><br><br>{1}</html>
 property_undefined=Undefined
 property_value_param=Value of property
 property_visualiser_title=Property Display
 protocol=Protocol [http]\:
 protocol_java_border=Java class
 protocol_java_classname=Classname\:
 protocol_java_config_tile=Configure Java Sample
 protocol_java_test_title=Java Testing
 provider_url=Provider URL
 proxy_assertions=Add Assertions
 proxy_cl_error=If specifying a proxy server, host and port must be given
 proxy_content_type_exclude=Exclude\:
 proxy_content_type_filter=Content-type filter
 proxy_content_type_include=Include\:
 proxy_daemon_bind_error=Could not create proxy - port in use. Choose another port.
 proxy_daemon_error=Could not create proxy - see log for details
 proxy_general_settings=Global Settings
 proxy_headers=Capture HTTP Headers
 proxy_regex=Regex matching
 proxy_sampler_settings=HTTP Sampler settings
 proxy_sampler_type=Type\:
 proxy_separators=Add Separators
 proxy_target=Target Controller\:
 proxy_test_plan_content=Test plan content
 proxy_title=HTTP Proxy Server
 pt_br=Portugese (Brazilian)
 ramp_up=Ramp-Up Period (in seconds)\:
 random_control_title=Random Controller
 random_order_control_title=Random Order Controller
 random_string_chars_to_use=Chars to use for random string generation
 random_string_length=Random string length
 read_response_message=Read response is not checked. To see the response, please check the box in the sampler.
 read_response_note=If read response is unchecked, the sampler will not read the response
 read_response_note2=or set the SampleResult. This improves performance, but it means
 read_response_note3=the response content won't be logged.
 read_soap_response=Read SOAP Response
 realm=Realm
 record_controller_title=Recording Controller
 ref_name_field=Reference Name\:
 regex_extractor_title=Regular Expression Extractor
 regex_field=Regular Expression\:
 regex_params_names_field=Parameter names regexp group number
 regex_params_values_field=Parameter values regex group number
 regex_params_ref_name_field=Regular Expression Reference Name
 regex_params_title=RegEx User Parameters
 regex_source=Response Field to check
 regex_src_body=Body
 regex_src_body_as_document=Body as a Document
 regex_src_body_unescaped=Body (unescaped)
 regex_src_hdrs=Headers
 regex_src_url=URL
 regexfunc_param_1=Regular expression used to search previous sample - or variable.
 regexfunc_param_2=Template for the replacement string, using groups from the regular expression.  Format is $[group]$.  Example $1$.
 regexfunc_param_3=Which match to use.  An integer 1 or greater, RAND to indicate JMeter should randomly choose, A float, or ALL indicating all matches should be used ([1])
 regexfunc_param_4=Between text.  If ALL is selected, the between text will be used to generate the results ([""])
 regexfunc_param_5=Default text.  Used instead of the template if the regular expression finds no matches ([""])
 regexfunc_param_7=Input variable name containing the text to be parsed ([previous sample])
 regexp_render_no_text=Data response result isn't text.
 regexp_tester_button_test=Test
 regexp_tester_field=Regular expression\:
 regexp_tester_title=RegExp Tester
 remote_error_init=Error initialising remote server
 remote_error_starting=Error starting remote server
 remote_exit=Remote Exit
 remote_exit_all=Remote Exit All
 remote_shut=Remote Shutdown
 remote_shut_all=Remote Shutdown All
 remote_start=Remote Start
 remote_start_all=Remote Start All
 remote_stop=Remote Stop
 remote_stop_all=Remote Stop All
 remove=Remove
 remove_confirm_title=Confirm remove?
 remove_confirm_msg=Are you sure you want remove the selected element(s)?
 rename=Rename entry
 report=Report
 report_bar_chart=Bar Chart
 report_bar_graph_url=URL
 report_base_directory=Base Directory
 report_chart_caption=Chart Caption
 report_chart_x_axis=X Axis
 report_chart_x_axis_label=Label for X Axis
 report_chart_y_axis=Y Axis
 report_chart_y_axis_label=Label for Y Axis
 report_line_graph=Line Graph
 report_line_graph_urls=Include URLs
 report_output_directory=Output Directory for Report
 report_page=Report Page
 report_page_element=Page Element
 report_page_footer=Page Footer
 report_page_header=Page Header
 report_page_index=Create Page Index
 report_page_intro=Page Introduction
 report_page_style_url=Stylesheet url
 report_page_title=Page Title
 report_pie_chart=Pie Chart
 report_plan=Report Plan
 report_select=Select
 report_summary=Report Summary
 report_table=Report Table
 report_writer=Report Writer
 report_writer_html=HTML Report Writer
 request_data=Request Data
 reset_gui=Reset Gui
 response_save_as_md5=Save response as MD5 hash?
 restart=Restart
 resultaction_title=Result Status Action Handler
 resultsaver_addtimestamp=Add timestamp
 resultsaver_errors=Save Failed Responses only
 resultsaver_numberpadlen=Minumum Length of sequence number
 resultsaver_prefix=Filename prefix\:
 resultsaver_skipautonumber=Don't add number to prefix
 resultsaver_skipsuffix=Don't add suffix
 resultsaver_success=Save Successful Responses only
 resultsaver_title=Save Responses to a file
 resultsaver_variable=Variable Name:
 retobj=Return object
 return_code_config_box_title=Return Code Configuration
 reuseconnection=Re-use connection
 revert_project=Revert
 revert_project?=Revert project?
 root=Root
 root_title=Root
 run=Run
 running_test=Running test
 runtime_controller_title=Runtime Controller
 runtime_seconds=Runtime (seconds)
 sample_result_save_configuration=Sample Result Save Configuration
 sample_scope=Apply to:
 sample_scope_all=Main sample and sub-samples
 sample_scope_children=Sub-samples only
 sample_scope_parent=Main sample only
 sample_scope_variable=JMeter Variable
 sampler_label=Label
 sampler_on_error_action=Action to be taken after a Sampler error
 sampler_on_error_continue=Continue
 sampler_on_error_start_next_loop=Start Next Thread Loop
 sampler_on_error_stop_test=Stop Test
 sampler_on_error_stop_test_now=Stop Test Now
 sampler_on_error_stop_thread=Stop Thread
 save=Save
 save?=Save?
 save_all_as=Save Test Plan as
 save_as=Save Selection As...
 save_as_error=More than one item selected!
 save_as_image=Save Node As Image
 save_as_image_all=Save Screen As Image
 save_assertionresultsfailuremessage=Save Assertion Failure Message
 save_assertions=Save Assertion Results (XML)
 save_asxml=Save As XML
 save_bytes=Save byte count
 save_code=Save Response Code
 save_datatype=Save Data Type
 save_encoding=Save Encoding
 save_fieldnames=Save Field Names (CSV)
 save_filename=Save Response Filename
 save_graphics=Save Graph
 save_hostname=Save Hostname
 save_idletime=Save Idle Time
 save_label=Save Label
 save_latency=Save Latency
 save_message=Save Response Message
 save_overwrite_existing_file=The selected file already exists, do you want to overwrite it?
 save_requestheaders=Save Request Headers (XML)
 save_responsedata=Save Response Data (XML)
 save_responseheaders=Save Response Headers (XML)
 save_samplecount=Save Sample and Error Counts
 save_samplerdata=Save Sampler Data (XML)
 save_subresults=Save Sub Results (XML)
 save_success=Save Success
 save_threadcounts=Save Active Thread Counts
 save_threadname=Save Thread Name
 save_time=Save Elapsed Time
 save_timestamp=Save Time Stamp
 save_url=Save URL
 save_workbench=Save WorkBench
 sbind=Single bind/unbind
 scheduler=Scheduler
 scheduler_configuration=Scheduler Configuration
 scope=Scope
 search_base=Search base
 search_filter=Search Filter
 search_test=Search Test
 search_text_button_close=Close
 search_text_button_find=Find
 search_text_button_next=Find next
 search_text_chkbox_case=Case sensitive
 search_text_chkbox_regexp=Regular exp.
 search_text_field=Search: 
 search_text_msg_not_found=Text not found
 search_text_title_not_found=Not found
 search_tree_title=Search Tree
 search=Search
 search_expand=Search & Expand
 searchbase=Search base
 searchfilter=Search Filter
 searchtest=Search test
 second=second
 secure=Secure
 send_file=Send Files With the Request\:
 send_file_browse=Browse...
 send_file_filename_label=File Path\:
 send_file_mime_label=MIME Type\:
 send_file_param_name_label=Parameter Name\:
 server=Server Name or IP\:
 servername=Servername \:
 session_argument_name=Session Argument Name
 setup_thread_group_title=setUp Thread Group
 should_save=You should save your test plan before running it.  \nIf you are using supporting data files (ie, for CSV Data Set or _StringFromFile), \nthen it is particularly important to first save your test script. \nDo you want to save your test plan first?
 shutdown=Shutdown
 simple_config_element=Simple Config Element
 simple_data_writer_title=Simple Data Writer
 size_assertion_comparator_error_equal=been equal to
 size_assertion_comparator_error_greater=been greater than
 size_assertion_comparator_error_greaterequal=been greater or equal to
 size_assertion_comparator_error_less=been less than
 size_assertion_comparator_error_lessequal=been less than or equal to
 size_assertion_comparator_error_notequal=not been equal to
 size_assertion_comparator_label=Type of Comparison
 size_assertion_failure=The result was the wrong size\: It was {0} bytes, but should have {1} {2} bytes.
 size_assertion_input_error=Please enter a valid positive integer.
 size_assertion_label=Size in bytes\:
 size_assertion_size_test=Size to Assert
 size_assertion_title=Size Assertion
 smime_assertion_issuer_dn=Issuer distinguished name
 smime_assertion_message_position=Execute assertion on message at position
 smime_assertion_not_signed=Message not signed
 smime_assertion_signature=Signature
 smime_assertion_signer=Signer certificate
 smime_assertion_signer_by_file=Certificate file
 smime_assertion_signer_constraints=Check values
 smime_assertion_signer_dn=Signer distinguished name
 smime_assertion_signer_email=Signer email address
 smime_assertion_signer_no_check=No check
 smime_assertion_signer_serial=Serial Number
 smime_assertion_title=SMIME Assertion
 smime_assertion_verify_signature=Verify signature
 smtp_additional_settings=Additional Settings
 smtp_attach_file=Attach file(s):
 smtp_attach_file_tooltip=Separate multiple files with ";"
 smtp_auth_settings=Auth settings
 smtp_bcc=Address To BCC:
 smtp_cc=Address To CC:
 smtp_default_port=(Defaults: SMTP:25, SSL:465, StartTLS:587)
 smtp_eml=Send .eml:
 smtp_enabledebug=Enable debug logging?
 smtp_enforcestarttls=Enforce StartTLS
 smtp_enforcestarttls_tooltip=<html><b>Enforces</b> the server to use StartTLS.<br />If not selected and the SMTP-Server doesn't support StartTLS, <br />a normal SMTP-Connection will be used as fallback instead. <br /><i>Please note</i> that this checkbox creates a file in "/tmp/", <br />so this will cause problems under windows.</html>
 smtp_from=Address From:
 smtp_header_add=Add Header
 smtp_header_name=Header Name
 smtp_header_remove=Remove
 smtp_header_value=Header Value
 smtp_mail_settings=Mail settings
 smtp_message=Message:
 smtp_message_settings=Message settings
 smtp_messagesize=Calculate message size
 smtp_password=Password:
 smtp_plainbody=Send plain body (i.e. not multipart/mixed)
 smtp_replyto=Address Reply-To:
 smtp_sampler_title=SMTP Sampler
 smtp_security_settings=Security settings
 smtp_server=Server:
 smtp_server_port=Port:
 smtp_server_settings=Server settings
 smtp_subject=Subject:
 smtp_suppresssubj=Suppress Subject Header
 smtp_timestamp=Include timestamp in subject
 smtp_to=Address To:
 smtp_trustall=Trust all certificates
 smtp_trustall_tooltip=<html><b>Enforces</b> JMeter to trust all certificates, whatever CA it comes from.</html>
 smtp_truststore=Local truststore:
 smtp_truststore_tooltip=<html>The pathname of the truststore.<br />Relative paths are resolved against the current directory.<br />Failing that, against the directory containing the test script (JMX file)</html>
 smtp_useauth=Use Auth
 smtp_usenone=Use no security features
 smtp_username=Username:
 smtp_usessl=Use SSL
 smtp_usestarttls=Use StartTLS
 smtp_usetruststore=Use local truststore
 smtp_usetruststore_tooltip=<html>Allows JMeter to use a local truststore.</html>
 soap_action=Soap Action
 soap_data_title=Soap/XML-RPC Data
 soap_sampler_title=SOAP/XML-RPC Request
 soap_send_action=Send SOAPAction: 
 soap_sampler_file_invalid=Filename references a missing or unreadable file\:
 solinger=SO_LINGER:
 spline_visualizer_average=Average
 spline_visualizer_incoming=Incoming
 spline_visualizer_maximum=Maximum
 spline_visualizer_minimum=Minimum
 spline_visualizer_title=Spline Visualizer
 spline_visualizer_waitingmessage=Waiting for samples
 split_function_separator=String to split on. Default is , (comma).
 split_function_string=String to split
 ssl_alias_prompt=Please type your preferred alias
 ssl_alias_select=Select your alias for the test
 ssl_alias_title=Client Alias
 ssl_error_title=Key Store Problem
 ssl_pass_prompt=Please type your password
 ssl_pass_title=KeyStore Password
 ssl_port=SSL Port
 sslmanager=SSL Manager
 start=Start
 start_no_timers=Start no pauses
 starttime=Start Time
 stop=Stop
 stopping_test=Shutting down all test threads.  Please be patient.
 stopping_test_failed=One or more test threads won't exit; see log file.
 stopping_test_title=Stopping Test
 string_from_file_encoding=File encoding if not the platform default (opt)
 string_from_file_file_name=Enter path (absolute or relative) to file
 string_from_file_seq_final=Final file sequence number (opt)
 string_from_file_seq_start=Start file sequence number (opt)
 summariser_title=Generate Summary Results
 summary_report=Summary Report
 switch_controller_label=Switch Value
 switch_controller_title=Switch Controller
 system_sampler_stderr=Standard error (stderr):
 system_sampler_stdin=Standard input (stdin):
 system_sampler_stdout=Standard output (stdout):
 system_sampler_title=OS Process Sampler
 table_visualizer_bytes=Bytes
 table_visualizer_latency=Latency
 table_visualizer_sample_num=Sample #
 table_visualizer_sample_time=Sample Time(ms)
 table_visualizer_start_time=Start Time
 table_visualizer_status=Status
 table_visualizer_success=Success
 table_visualizer_thread_name=Thread Name
 table_visualizer_warning=Warning
 target_server=Target Server
 tcp_classname=TCPClient classname\:
 tcp_config_title=TCP Sampler Config
 tcp_nodelay=Set NoDelay
 tcp_port=Port Number\:
 tcp_request_data=Text to send
 tcp_sample_title=TCP Sampler
 tcp_timeout=Timeout (milliseconds)\:
 teardown_on_shutdown=Run tearDown Thread Groups after shutdown of main threads
+template_choose=Select Template
+template_create_from=Create
 template_field=Template\:
+template_title=Create from Template
 test=Test
 test_action_action=Action
 test_action_duration=Duration (milliseconds)
 test_action_pause=Pause
 test_action_restart_next_loop=Go to next loop iteration
 test_action_stop=Stop
 test_action_stop_now=Stop Now
 test_action_target=Target
 test_action_target_test=All Threads
 test_action_target_thread=Current Thread
 test_action_title=Test Action
 test_configuration=Test Configuration
 test_fragment_title=Test Fragment
 test_plan=Test Plan
 test_plan_classpath_browse=Add directory or jar to classpath
 testconfiguration=Test Configuration
 testplan.serialized=Run Thread Groups consecutively (i.e. run groups one at a time)
 testplan_comments=Comments\:
 testt=Test
 textbox_cancel=Cancel
 textbox_close=Close
 textbox_save_close=Save & Close
 textbox_title_edit=Edit text
 textbox_title_view=View text
 textbox_tooltip_cell=Double click to view/edit
 thread_delay_properties=Thread Delay Properties
 thread_group_title=Thread Group
 thread_properties=Thread Properties
 threadgroup=Thread Group
 throughput_control_bynumber_label=Total Executions
 throughput_control_bypercent_label=Percent Executions
 throughput_control_perthread_label=Per User
 throughput_control_title=Throughput Controller
 throughput_control_tplabel=Throughput
 time_format=Format string for SimpleDateFormat (optional)
 timelim=Time limit
 toggle=Toggle
 toolbar_icon_set_not_found=The file description of toolbar icon set is not found. See logs.
 total_threads_tooltip=Total number of threads to run
 tr=Turkish
 transaction_controller_include_timers=Include duration of timer and pre-post processors in generated sample
 transaction_controller_parent=Generate parent sample
 transaction_controller_title=Transaction Controller
 unbind=Thread Unbind
 unescape_html_string=String to unescape
 unescape_string=String containing Java escapes
 uniform_timer_delay=Constant Delay Offset (in milliseconds)\:
 uniform_timer_memo=Adds a random delay with a uniform distribution
 uniform_timer_range=Random Delay Maximum (in milliseconds)\:
 uniform_timer_title=Uniform Random Timer
 up=Up
 update=Update
 update_per_iter=Update Once Per Iteration
 upload=File Upload
 upper_bound=Upper Bound
 url=URL
 url_config_get=GET
 url_config_http=HTTP
 url_config_https=HTTPS
 url_config_post=POST
 url_config_protocol=Protocol\:
 url_config_title=HTTP Request Defaults
 url_full_config_title=UrlFull Sample
 url_multipart_config_title=HTTP Multipart Request Defaults
 urldecode_string=String with URL encoded chars to decode
 urlencode_string=String to encode in URL encoded chars
 use_expires=Use Cache-Control/Expires header when processing GET requests
 use_keepalive=Use KeepAlive
 use_multipart_for_http_post=Use multipart/form-data for POST
 use_multipart_mode_browser=Browser-compatible headers
 use_recording_controller=Use Recording Controller
 user=User
 user_defined_test=User Defined Test
 user_defined_variables=User Defined Variables
 user_param_mod_help_note=(Do not change this.  Instead, modify the file of that name in JMeter's /bin directory)
 user_parameters_table=Parameters
 user_parameters_title=User Parameters
 userdn=Username
 username=Username
 userpw=Password
 value=Value
 value_to_quote_meta=Value to escape from ORO Regexp meta chars
 var_name=Reference Name
 variable_name_param=Name of variable (may include variable and function references)
 view_graph_tree_title=View Graph Tree
 view_results_assertion_error=Assertion error: 
 view_results_assertion_failure=Assertion failure: 
 view_results_assertion_failure_message=Assertion failure message: 
 view_results_autoscroll=Scroll automatically?
 view_results_childsamples=Child samples?
 view_results_desc=Shows the text results of sampling in tree form
 view_results_error_count=Error Count: 
 view_results_fields=fields:
 view_results_in_table=View Results in Table
 view_results_latency=Latency: 
 view_results_load_time=Load time: 
 view_results_render=Render: 
 view_results_render_document=Document
 view_results_render_html=HTML
 view_results_render_html_embedded=HTML (download resources)
 view_results_render_json=JSON
 view_results_render_text=Text
 view_results_render_xml=XML
 view_results_request_headers=Request Headers:
 view_results_response_code=Response code: 
 view_results_response_headers=Response headers:
 view_results_response_message=Response message: 
 view_results_response_missing_tika=Missing tika-app.jar in classpath. Unable to convert to plain text this kind of document.\nDownload the tika-app-x.x.jar file from http://tika.apache.org/download.html\nAnd put the file in <JMeter>/lib directory.
 view_results_response_partial_message=Start of message:
 view_results_response_too_large_message=Response too large to be displayed. Size: 
 view_results_sample_count=Sample Count: 
 view_results_sample_start=Sample Start: 
 view_results_search_pane=Search pane
 view_results_size_body_in_bytes=Body size in bytes: 
 view_results_size_headers_in_bytes=Headers size in bytes: 
 view_results_size_in_bytes=Size in bytes: 
 view_results_tab_assertion=Assertion result
 view_results_tab_request=Request
 view_results_tab_response=Response data
 view_results_tab_sampler=Sampler result
 view_results_table_fields_key=Additional field
 view_results_table_fields_value=Value
 view_results_table_headers_key=Response header
 view_results_table_headers_value=Value
 view_results_table_request_headers_key=Request header
 view_results_table_request_headers_value=Value
 view_results_table_request_http_cookie=Cookie
 view_results_table_request_http_host=Host
 view_results_table_request_http_method=Method
 view_results_table_request_http_nohttp=No HTTP Sample
 view_results_table_request_http_path=Path
 view_results_table_request_http_port=Port
 view_results_table_request_http_protocol=Protocol
 view_results_table_request_params_key=Parameter name
 view_results_table_request_params_value=Value
 view_results_table_request_raw_nodata=No data to display
 view_results_table_request_tab_http=HTTP
 view_results_table_request_tab_raw=Raw
 view_results_table_result_tab_parsed=Parsed
 view_results_table_result_tab_raw=Raw
 view_results_thread_name=Thread Name: 
 view_results_title=View Results
 view_results_tree_title=View Results Tree
 warning=Warning!
 web_cannot_convert_parameters_to_raw=Cannot convert parameters to RAW Post body \nbecause one of the parameters has a name
 web_cannot_switch_tab=You cannot switch because data cannot be converted\n to target Tab data, empty data to switch
 web_parameters_lost_message=Switching to RAW Post body will convert the parameters.\nParameter table will be cleared when you select\nanother node or save the test plan.\nOK to proceeed?
 web_proxy_server_title=Proxy Server
 web_request=HTTP Request
 web_server=Web Server
 web_server_client=Client implementation:
 web_server_domain=Server Name or IP\:
 web_server_port=Port Number\:
 web_server_timeout_connect=Connect:
 web_server_timeout_response=Response:
 web_server_timeout_title=Timeouts (milliseconds)
 web_testing2_source_ip=Source IP address:
 web_testing2_title=HTTP Request HTTPClient
 web_testing_concurrent_download=Use concurrent pool. Size:
 web_testing_embedded_url_pattern=Embedded URLs must match\:
 web_testing_retrieve_images=Retrieve All Embedded Resources from HTML Files
 web_testing_title=HTTP Request
 webservice_configuration_wizard=WSDL helper
 webservice_get_xml_from_random_title=Use random messages SOAP
 webservice_maintain_session=Maintain HTTP Session
 webservice_message_soap=WebService message
 webservice_methods=Web Methods
 webservice_proxy_host=Proxy Host
 webservice_proxy_note=If Use HTTP Proxy is checked, but no host or port are provided, the sampler
 webservice_proxy_note2=will look at command line options. If no proxy host or port are provided by
 webservice_proxy_note3=either, it will fail silently.
 webservice_proxy_port=Proxy Port
 webservice_sampler_title=WebService(SOAP) Request (DEPRECATED)
 webservice_soap_action=SOAPAction
 webservice_timeout=Timeout:
 webservice_use_proxy=Use HTTP Proxy
 while_controller_label=Condition (function or variable)
 while_controller_title=While Controller
 workbench_title=WorkBench
 wsdl_helper_error=The WSDL was not valid, please double check the url.
 wsdl_url=WSDL URL
 wsdl_url_error=The WSDL was emtpy.
 xml_assertion_title=XML Assertion
 xml_download_dtds=Fetch external DTDs
 xml_namespace_button=Use Namespaces
 xml_tolerant_button=Use Tidy (tolerant parser)
 xml_validate_button=Validate XML
 xml_whitespace_button=Ignore Whitespace
 xmlschema_assertion_label=File Name:
 xmlschema_assertion_title=XML Schema Assertion
 xpath_assertion_button=Validate
 xpath_assertion_check=Check XPath Expression
 xpath_assertion_error=Error with XPath
 xpath_assertion_failed=Invalid XPath Expression
 xpath_assertion_label=XPath
 xpath_assertion_negate=True if nothing matches
 xpath_assertion_option=XML Parsing Options
 xpath_assertion_test=XPath Assertion 
 xpath_assertion_tidy=Try and tidy up the input
 xpath_assertion_title=XPath Assertion
 xpath_assertion_valid=Valid XPath Expression
 xpath_assertion_validation=Validate the XML against the DTD
 xpath_assertion_whitespace=Ignore whitespace
 xpath_expression=XPath expression to match against
 xpath_extractor_fragment=Return entire XPath fragment instead of text content?
 xpath_extractor_query=XPath query:
 xpath_extractor_title=XPath Extractor
 xpath_file_file_name=XML file to get values from 
 xpath_tidy_quiet=Quiet
 xpath_tidy_report_errors=Report errors
 xpath_tidy_show_warnings=Show warnings
 you_must_enter_a_valid_number=You must enter a valid number
 zh_cn=Chinese (Simplified)
 zh_tw=Chinese (Traditional)
diff --git a/src/core/org/apache/jmeter/resources/messages_fr.properties b/src/core/org/apache/jmeter/resources/messages_fr.properties
index f1a2bf642..d58956875 100644
--- a/src/core/org/apache/jmeter/resources/messages_fr.properties
+++ b/src/core/org/apache/jmeter/resources/messages_fr.properties
@@ -1,1252 +1,1256 @@
 #   Licensed to the Apache Software Foundation (ASF) under one or more
 #   contributor license agreements.  See the NOTICE file distributed with
 #   this work for additional information regarding copyright ownership.
 #   The ASF licenses this file to You under the Apache License, Version 2.0
 #   (the "License"); you may not use this file except in compliance with
 #   the License.  You may obtain a copy of the License at
 # 
 #       http://www.apache.org/licenses/LICENSE-2.0
 # 
 #   Unless required by applicable law or agreed to in writing, software
 #   distributed under the License is distributed on an "AS IS" BASIS,
 #   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 #   See the License for the specific language governing permissions and
 #   limitations under the License.
 
 #Stored by I18NEdit, may be edited!
 about=A propos de JMeter
 active_threads_tooltip=Unit\u00E9s actives
 add=Ajouter
 add_as_child=Ajouter en tant qu'enfant
 add_from_clipboard=Ajouter depuis Presse-papier
 add_from_suggested_excludes=Ajouter exclusions propos\u00E9es
 add_parameter=Ajouter un param\u00E8tre
 add_pattern=Ajouter un motif \:
 add_test=Ajout
 add_user=Ajouter un utilisateur
 add_value=Ajouter valeur
 addtest=Ajout
 aggregate_graph=Graphique des statistiques
 aggregate_graph_choose_color=Choisir couleur
 aggregate_graph_choose_foreground_color=Couleur valeur
 aggregate_graph_color_bar=Couleur \:
 aggregate_graph_column=Colonne
 aggregate_graph_column_selection=S\u00E9lection de colonnes par libell\u00E9 \:
 aggregate_graph_column_settings=Param\u00E8tres colonne
 aggregate_graph_columns_to_display=Colonnes \u00E0 afficher \:
 aggregate_graph_dimension=Taille graphique
 aggregate_graph_display=G\u00E9n\u00E9rer le graphique
 aggregate_graph_draw_outlines=Bordure de barre ?
 aggregate_graph_dynamic_size=Taille de graphique dynamique
 aggregate_graph_font=Police \:
 aggregate_graph_height=Hauteur \:
 aggregate_graph_increment_scale=Intervalle \u00E9chelle \:
 aggregate_graph_legend=L\u00E9gende
 aggregate_graph_legend.placement.bottom=Bas
 aggregate_graph_legend.placement.left=Gauche
 aggregate_graph_legend.placement.right=Droite
 aggregate_graph_legend.placement.top=Haut
 aggregate_graph_legend_placement=Position \:
 aggregate_graph_max_length_xaxis_label=Longueur maximum du libell\u00E9 de l'axe des abscisses \:
 aggregate_graph_ms=Millisecondes
 aggregate_graph_no_values_to_graph=Pas de valeurs pour le graphique
 aggregate_graph_number_grouping=S\u00E9parateur de milliers ?
 aggregate_graph_response_time=Temps de r\u00E9ponse
 aggregate_graph_save=Enregistrer le graphique
 aggregate_graph_save_table=Enregistrer le tableau de donn\u00E9es
 aggregate_graph_save_table_header=Inclure l'ent\u00EAte du tableau
 aggregate_graph_size=Taille \:
 aggregate_graph_style=Style \:
 aggregate_graph_sync_with_name=Synchroniser avec nom
 aggregate_graph_tab_graph=Graphique
 aggregate_graph_tab_settings=Param\u00E8tres
 aggregate_graph_title=Graphique agr\u00E9g\u00E9
 aggregate_graph_title_group=Titre
 aggregate_graph_use_group_name=Ajouter le nom du groupe aux libell\u00E9s
 aggregate_graph_user_title=Titre du graphique \:
 aggregate_graph_value_font=Police de la valeur \:
 aggregate_graph_value_labels_vertical=Libell\u00E9 de valeurs vertical ?
 aggregate_graph_width=Largeur \:
 aggregate_graph_xaxis_group=Abscisses
 aggregate_graph_yaxis_group=Ordonn\u00E9es (milli-secondes)
 aggregate_graph_yaxis_max_value=Echelle maximum \:
 aggregate_report=Rapport agr\u00E9g\u00E9
 aggregate_report_90=90%
 aggregate_report_90%_line=90e centile
 aggregate_report_bandwidth=Ko/sec
 aggregate_report_count=\# Echantillons
 aggregate_report_error=Erreur
 aggregate_report_error%=% Erreur
 aggregate_report_max=Max
 aggregate_report_median=M\u00E9diane
 aggregate_report_min=Min
 aggregate_report_rate=D\u00E9bit
 aggregate_report_stddev=Ecart type
 aggregate_report_total_label=TOTAL
 ajp_sampler_title=Requ\u00EAte AJP/1.3
 als_message=Note \: Le parseur de log d'acc\u00E8s est g\u00E9n\u00E9rique et vous permet de se brancher \u00E0 
 als_message2=votre propre parseur. Pour se faire, impl\u00E9menter le LogParser, ajouter le jar au 
 als_message3=r\u00E9pertoire /lib et entrer la classe (fichier .class) dans l'\u00E9chantillon (sampler).
 analyze=En train d'analyser le fichier de donn\u00E9es
 anchor_modifier_title=Analyseur de lien HTML
 appearance=Apparence
 argument_must_not_be_negative=L'argument ne peut pas \u00EAtre n\u00E9gatif \!
 arguments_panel_title=Param\u00E8tres de commande
 assertion_assume_success=Ignorer le statut
 assertion_body_resp=Corps de r\u00E9ponse
 assertion_code_resp=Code de r\u00E9ponse
 assertion_contains=Contient (exp. r\u00E9guli\u00E8re)
 assertion_equals=Est \u00E9gale \u00E0 (texte brut)
 assertion_headers=Ent\u00EAtes de r\u00E9ponse
 assertion_matches=Correspond \u00E0 (exp. r\u00E9guli\u00E8re)
 assertion_message_resp=Message de r\u00E9ponse
 assertion_network_size=R\u00E9ponse compl\u00E8te
 assertion_not=Inverser
 assertion_pattern_match_rules=Type de correspondance du motif
 assertion_patterns_to_test=Motifs \u00E0 tester
 assertion_resp_field=Section de r\u00E9ponse \u00E0 tester
 assertion_resp_size_field=Taille \u00E0 v\u00E9rifier sur
 assertion_substring=Contient (texte brut)
 assertion_text_document=Document (texte)
 assertion_text_resp=Texte de r\u00E9ponse
 assertion_textarea_label=Assertions \:
 assertion_title=Assertion R\u00E9ponse
 assertion_url_samp=URL Echantillon
 assertion_visualizer_title=R\u00E9cepteur d'assertions
 attribute=Attribut \:
 attribute_field=Attribut \:
 attrs=Attributs
 auth_base_url=URL de base
 auth_manager_title=Gestionnaire d'autorisation HTTP
 auths_stored=Autorisations stock\u00E9es
 average=Moyenne
 average_bytes=Moy. octets
 bind=Connexion de l'unit\u00E9
 bouncy_castle_unavailable_message=Les jars de bouncycastle sont indisponibles, ajoutez les au classpath.
 browse=Parcourir...
 bsf_sampler_title=Echantillon BSF
 bsf_script=Script \u00E0 lancer (variables\: ctx vars props SampleResult sampler log Label FileName Parameters args[] OUT)
 bsf_script_file=Fichier script \u00E0 lancer \:
 bsf_script_language=Langage de script \:
 bsf_script_parameters=Param\u00E8tres \u00E0 passer au script/fichier \:
 bsh_assertion_script=Script (IO\: Failure[Message], Response. IN\: Response[Data|Code|Message|Headers], RequestHeaders, Sample[Label|rData])
 bsh_assertion_script_variables=Les variables suivantes sont d\u00E9finies pour le script \:\nEn lecture/\u00E9criture \: Failure, FailureMessage, SampleResult, vars, props, log.\nEn lecture seule \: Response[Data|Code|Message|Headers], RequestHeaders, SampleLabel, SamplerData, ctx
 bsh_assertion_title=Assertion BeanShell
 bsh_function_expression=Expression \u00E0 \u00E9valuer
 bsh_sampler_title=Echantillon BeanShell
 bsh_script=Script (voir la suite pour les variables qui sont d\u00E9finies)
 bsh_script_file=Fichier script \:
 bsh_script_parameters=Param\u00E8tres  (-> String Parameters et String []bsh.args)
 bsh_script_reset_interpreter=R\u00E9initialiser l'interpr\u00E9teur bsh avant chaque appel
 bsh_script_variables=Les variables suivantes sont d\u00E9finies pour le script \:\nSampleResult, ResponseCode, ResponseMessage, IsSuccess, Label, FileName, ctx, vars, props, log
 busy_testing=Je suis occup\u00E9 \u00E0 tester, veuillez arr\u00EAter le test avant de changer le param\u00E8trage
 cache_manager_size=Nombre maximum d'\u00E9l\u00E9ments dans le cache
 cache_manager_title=Gestionnaire de cache HTTP
 cache_session_id=Identifiant de session de cache ?
 cancel=Annuler
 cancel_exit_to_save=Il y a des \u00E9l\u00E9ments qui n'ont pas \u00E9t\u00E9 sauv\u00E9s. Voulez-vous enregistrer avant de sortir ?
 cancel_new_to_save=Il y a des \u00E9l\u00E9ments qui n'ont pas \u00E9t\u00E9 sauv\u00E9s. Voulez-vous enregistrer avant de nettoyer le plan de test ?
 cancel_revert_project=Il y a des \u00E9l\u00E9ments qui n'ont pas \u00E9t\u00E9 sauv\u00E9s. Annuler les changements et revenir \u00E0 la derni\u00E8re sauvegarde du plan de test ?
 change_parent=Changer le contr\u00F4leur
 char_value=Caract\u221A\u00AEre num\u221A\u00A9rique Unicode (d\u221A\u00A9cimal or 0xhex)
 check_return_code_title=V\u00E9rifier le code retour
 choose_function=Choisir une fonction
 choose_language=Choisir une langue
 clear=Nettoyer
 clear_all=Nettoyer tout
 clear_cache_per_iter=Nettoyer le cache \u00E0 chaque it\u00E9ration ?
 clear_cookies_per_iter=Nettoyer les cookies \u00E0 chaque it\u00E9ration ?
 clipboard_node_read_error=Une erreur est survenue lors de la copie du noeud
 close=Fermer
 closeconnection=Fermer la connexion
 column_delete_disallowed=Supprimer cette colonne n'est pas possible
 column_number=Num\u00E9ro de colonne du fichier CSV | next | *alias
 command_config_box_title=Commande \u00E0 ex\u00E9cuter
 command_config_std_streams_title=Flux standard (fichiers)
 command_field_title=Commande \:
 compare=Comparaison
 comparefilt=Filtre de comparaison
 comparison_differ_content=Le contenu des r\u00E9ponses est diff\u00E9rent.
 comparison_differ_time=La diff\u00E9rence du temps de r\u00E9ponse diff\u00E8re de plus de 
 comparison_invalid_node=Noeud invalide 
 comparison_regex_string=Expression r\u00E9guli\u00E8re
 comparison_regex_substitution=Substitution
 comparison_response_time=Temps de r\u00E9ponse \: 
 comparison_unit=ms
 comparison_visualizer_title=R\u00E9cepteur d'assertions de comparaison
 config_element=El\u00E9ment de configuration
 config_save_settings=Configurer
 configure_wsdl=Configurer
 confirm=Confirmer
 constant_throughput_timer_memo=Ajouter un d\u00E9lai entre les \u00E9chantillions pour obtenir un d\u00E9bit constant
 constant_timer_delay=D\u00E9lai d'attente (en millisecondes) \:
 constant_timer_memo=Ajouter un d\u00E9lai fixe entre les \u00E9chantillions de test
 constant_timer_title=Compteur de temps fixe
 content_encoding=Encodage contenu \:
 controller=Contr\u00F4leur
 cookie_implementation_choose=Impl\u00E9mentation \:
 cookie_manager_policy=Politique des cookies \:
 cookie_manager_title=Gestionnaire de cookies HTTP
 cookie_options=Options
 cookies_stored=Cookies stock\u00E9s
 copy=Copier
 counter_config_title=Compteur
 counter_per_user=Suivre le compteur ind\u00E9pendamment pour chaque unit\u00E9 de test
 counter_reset_per_tg_iteration=R\u00E9initialiser le compteur \u00E0 chaque it\u00E9ration du groupe d'unit\u00E9s
 countlim=Limiter le nombre d'\u00E9l\u00E9ments retourn\u00E9s \u00E0
+create_from_template=Mod\u00E8les
 cssjquery_attribute=Attribut
 cssjquery_impl=Impl\u00E9mentation CSS/JQuery\:
 cssjquery_render_no_text=Les donn\u00E9es de r\u00E9ponse ne sont pas du texte.
 cssjquery_tester_button_test=Tester
 cssjquery_tester_field=S\u00E9lecteur\:
 cssjquery_tester_title=Testeur CSS/JQuery
 csvread_file_file_name=Fichier CSV pour obtenir les valeurs de | *alias
 cut=Couper
 cut_paste_function=Fonction de copier/coller de cha\u00EEne de caract\u00E8re
 database_conn_pool_max_usage=Utilisation max pour chaque connexion\:
 database_conn_pool_props=Pool de connexions \u221A\u2020 la base de donn\u221A\u00A9es
 database_conn_pool_size=Nombre de Connexions dans le Pool\:
 database_conn_pool_title=Valeurs par d\u221A\u00A9faut du Pool de connexions JDBC
 database_driver_class=Classe du Driver\:
 database_login_title=Valeurs par d\u221A\u00A9faut de la base de donn\u221A\u00A9es JDBC
 database_sql_query_string=Requ\u00EAte SQL \:
 database_sql_query_title=Requ\u00EAte SQL JDBC par d\u00E9faut
 database_testing_title=Requ\u221A\u2122te JDBC
 database_url=URL JDBC\:
 database_url_jdbc_props=URL et driver JDBC de la base de donn\u221A\u00A9es
 ddn=DN \:
 de=Allemand
 debug_off=D\u00E9sactiver le d\u00E9bogage
 debug_on=Activer le d\u00E9bogage
 default_parameters=Param\u00E8tres par d\u00E9faut
 default_value_field=Valeur par d\u00E9faut \:
 delay=D\u00E9lai avant d\u00E9marrage (secondes) \:
 delayed_start=Cr\u00E9er les unit\u00E9s seulement quand n\u00E9cessaire
 delete=Supprimer
 delete_parameter=Supprimer le param\u00E8tre
 delete_test=Suppression
 delete_user=Supprimer l'utilisateur
 deltest=Suppression
 deref=D\u00E9r\u00E9f\u00E9rencement des alias
 description=Description
 detail=D\u00E9tail
 directory_field_title=R\u00E9pertoire d'ex\u00E9cution \:
 disable=D\u00E9sactiver
 distribution_graph_title=Graphique de distribution (alpha)
 distribution_note1=Ce graphique se mettra \u00E0 jour tous les 10 \u00E9chantillons
 dn=Racine DN \:
 domain=Domaine \:
 done=Fait
 down=Descendre
 duplicate=Dupliquer
 duration=Dur\u00E9e (secondes) \:
 duration_assertion_duration_test=Dur\u00E9e maximale \u00E0 v\u00E9rifier
 duration_assertion_failure=L''op\u00E9ration a dur\u00E9e trop longtemps\: cela a pris {0} millisecondes, mais n''aurait pas d\u00FB durer plus de {1} millisecondes.
 duration_assertion_input_error=Veuillez entrer un entier positif valide.
 duration_assertion_label=Dur\u00E9e en millisecondes \:
 duration_assertion_title=Assertion Dur\u00E9e
 edit=Editer
 email_results_title=R\u00E9sultat d'email
 en=Anglais
 enable=Activer
 encode?=Encodage
 encoded_value=Valeur de l'URL encod\u00E9e
 endtime=Date et heure de fin \:
 entry_dn=Entr\u00E9e DN \:
 entrydn=Entr\u00E9e DN
 environment_panel_title=Variables d'environnement
 eolbyte=Valeur byte de l'indicateur de fin de ligne (EOL)\: 
 error_indicator_tooltip=Affiche le nombre d'erreurs dans le journal(log), cliquer pour afficher la console.
 error_loading_help=Erreur au chargement de la page d'aide
 error_occurred=Une erreur est survenue
 error_title=Erreur
 es=Espagnol
 escape_html_string=Cha\u00EEne d'\u00E9chappement
 eval_name_param=Variable contenant du texte et r\u00E9f\u00E9rences de fonctions
 evalvar_name_param=Nom de variable
 example_data=Exemple de donn\u00E9e
 example_title=Echantillon exemple
 exit=Quitter
 expand=D\u00E9plier
 expected_return_code_title=Code retour attendu \: 
 expiration=Expiration
 expression_field=Expression CSS/JQuery \:
 field_name=Nom du champ
 file=Fichier
 file_already_in_use=Ce fichier est d\u00E9j\u00E0 utilis\u00E9
 file_visualizer_append=Concat\u00E9ner au fichier de donn\u00E9es existant
 file_visualizer_auto_flush=Vider automatiquement apr\u00E8s chaque echantillon de donn\u00E9es
 file_visualizer_browse=Parcourir...
 file_visualizer_close=Fermer
 file_visualizer_file_options=Options de fichier
 file_visualizer_filename=Nom du fichier \: 
 file_visualizer_flush=Vider
 file_visualizer_missing_filename=Aucun fichier de sortie sp\u00E9cifi\u00E9.
 file_visualizer_open=Ouvrir...
 file_visualizer_output_file=\u00C9crire les r\u00E9sultats dans un fichier ou lire les r\u00E9sultats depuis un fichier CSV / JTL
 file_visualizer_submit_data=Inclure les donn\u00E9es envoy\u00E9es
 file_visualizer_title=Rapporteur de fichier
 file_visualizer_verbose=Sortie verbeuse
 filename=Nom de fichier \: 
 follow_redirects=Suivre les redirect.
 follow_redirects_auto=Rediriger automat.
 font.sansserif=Sans Serif
 font.serif=Serif
 fontstyle.bold=Gras
 fontstyle.italic=Italique
 fontstyle.normal=Normal
 foreach_controller_title=Contr\u00F4leur Pour chaque (ForEach)
 foreach_end_index=Indice de fin de la boucle
 foreach_input=Pr\u00E9fixe de la variable d'entr\u00E9e \:
 foreach_output=Nom de la variable de sortie \:
 foreach_start_index=Indice de d\u00E9but de la boucle
 foreach_use_separator=Ajouter un soulign\u00E9 "_" avant le nombre ?
 format=Format du nombre \:
 fr=Fran\u00E7ais
 ftp_binary_mode=Utiliser le mode binaire ?
 ftp_get=R\u00E9cup\u00E9rer (get)
 ftp_local_file=Fichier local \:
 ftp_local_file_contents=Contenus fichier local \:
 ftp_put=D\u00E9poser (put)
 ftp_remote_file=Fichier distant \:
 ftp_sample_title=Param\u00E8tres FTP par d\u00E9faut
 ftp_save_response_data=Enregistrer le fichier dans la r\u00E9ponse ?
 ftp_testing_title=Requ\u00EAte FTP
 function_dialog_menu_item=Assistant de fonctions
 function_helper_title=Assistant de fonctions
 function_name_param=Nom de la fonction. Utilis\u00E9 pour stocker les valeurs \u00E0 utiliser ailleurs dans la plan de test
 function_name_paropt=Nom de variable dans laquelle le r\u00E9sultat sera stock\u00E9 (optionnel)
 function_params=Param\u00E8tres de la fonction
 functional_mode=Mode de test fonctionnel
 functional_mode_explanation=S\u00E9lectionner le mode de test fonctionnel uniquement si vous avez besoin\nd'enregistrer les donn\u00E9es re\u00E7ues du serveur dans un fichier \u00E0 chaque requ\u00EAte. \n\nS\u00E9lectionner cette option affecte consid\u00E9rablement les performances.
 gaussian_timer_delay=D\u00E9lai de d\u00E9calage bas\u00E9 gaussian (en millisecondes) \:
 gaussian_timer_memo=Ajoute un d\u00E9lai al\u00E9atoire avec une distribution gaussienne
 gaussian_timer_range=D\u00E9viation (en millisecondes) \:
 gaussian_timer_title=Compteur de temps al\u00E9atoire gaussien
 generate=G\u00E9n\u00E9rer
 generator=Nom de la classe g\u00E9n\u00E9ratrice
 generator_cnf_msg=N'a pas p\u00FB trouver la classe g\u00E9n\u00E9ratrice. Assurez-vous que vous avez plac\u00E9 votre fichier jar dans le r\u00E9pertoire /lib
 generator_illegal_msg=N'a pas p\u00FB acc\u00E9der \u00E0 la classes g\u00E9n\u00E9ratrice \u00E0 cause d'une IllegalAccessException.
 generator_instantiate_msg=N'a pas p\u00FB cr\u00E9er une instance du parseur g\u00E9n\u00E9rateur. Assurez-vous que le g\u00E9n\u00E9rateur impl\u00E9mente l'interface Generator.
 get_xml_from_file=Fichier avec les donn\u00E9es XML SOAP (remplace le texte ci-dessus)
 get_xml_from_random=R\u00E9pertoire contenant les fichier(s) \:
 graph_apply_filter=Appliquer le filtre
 graph_choose_graphs=Graphique \u00E0 afficher
 graph_full_results_title=Graphique de r\u00E9sultats complets
 graph_pointshape_circle=Cercle
 graph_pointshape_diamond=Diamant
 graph_pointshape_none=Aucun
 graph_pointshape_square=Carr\u00E9
 graph_pointshape_triangle=Triangle
 graph_resp_time_interval_label=Interval (ms) \:
 graph_resp_time_interval_reload=Appliquer l'interval
 graph_resp_time_not_enough_data=Impossible de dessiner le graphique, pas assez de donn\u00E9es
 graph_resp_time_series_selection=S\u00E9lection des \u00E9chantillons par libell\u00E9 \:
 graph_resp_time_settings_line=Param\u00E9tres de la courbe
 graph_resp_time_settings_pane=Param\u00E9tres du graphique
 graph_resp_time_shape_label=Forme de la jonction \:
 graph_resp_time_stroke_width=Largeur de ligne \:
 graph_resp_time_title=Graphique \u00E9volution temps de r\u00E9ponses
 graph_resp_time_title_label=Titre du graphique \:  
 graph_resp_time_xaxis_time_format=Formatage heure (SimpleDateFormat) \:
 graph_results_average=Moyenne
 graph_results_data=Donn\u00E9es
 graph_results_deviation=Ecart type
 graph_results_latest_sample=Dernier \u00E9chantillon
 graph_results_median=M\u00E9diane
 graph_results_ms=ms
 graph_results_no_samples=Nombre d'\u00E9chantillons
 graph_results_throughput=D\u00E9bit
 graph_results_title=Graphique de r\u00E9sultats
 grouping_add_separators=Ajouter des s\u00E9parateurs entre les groupes
 grouping_in_controllers=Mettre chaque groupe dans un nouveau contr\u00F4leur
 grouping_in_transaction_controllers=Mettre chaque groupe dans un nouveau contr\u00F4leur de transaction
 grouping_mode=Grouper \:
 grouping_no_groups=Ne pas grouper les \u00E9chantillons
 grouping_store_first_only=Stocker le 1er \u00E9chantillon pour chaque groupe uniquement
 header_manager_title=Gestionnaire d'ent\u00EAtes HTTP
 headers_stored=Ent\u00EAtes stock\u00E9es
 heap_dump=Cr\u00E9er une image disque de la m\u00E9moire (heap dump)
 help=Aide
 help_node=Quel est ce noeud ?
 html_assertion_file=Ecrire un rapport JTidy dans un fichier
 html_assertion_label=Assertion HTML
 html_assertion_title=Assertion HTML
 html_extractor_title=Extracteur CSS/JQuery
 html_extractor_type=Impl\u00E9mentation de l'extracteur CSS/JQuery
 html_parameter_mask=Masque de param\u00E8tre HTML (DEPRECATED)
 http_implementation=Impl\u00E9mentation \:
 http_response_code=Code de r\u00E9ponse HTTP
 http_url_rewriting_modifier_title=Transcripteur d'URL HTTP
 http_user_parameter_modifier=Modificateur de param\u00E8tre utilisateur HTTP
 httpmirror_max_pool_size=Taille maximum du pool d'unit\u00E9s \:
 httpmirror_max_queue_size=Taille maximum de la file d'attente \:
 httpmirror_settings=Param\u00E8tres
 httpmirror_title=Serveur HTTP miroir
 id_prefix=Pr\u00E9fixe d'ID
 id_suffix=Suffixe d'ID
 if_controller_evaluate_all=Evaluer pour tous les fils ?
 if_controller_expression=Interpr\u00E9ter la condition comme une expression
 if_controller_label=Condition (d\u00E9faut Javascript) \:
 if_controller_title=Contr\u00F4leur Si (If)
 ignore_subcontrollers=Ignorer les sous-blocs de contr\u00F4leurs
 include_controller=Contr\u00F4leur Inclusion
 include_equals=Inclure \u00E9gale ?
 include_path=Plan de test \u00E0 inclure
 increment=Incr\u00E9ment \:
 infinite=Infini
 initial_context_factory=Fabrique de contexte initiale
 insert_after=Ins\u00E9rer apr\u00E8s
 insert_before=Ins\u00E9rer avant
 insert_parent=Ins\u00E9rer en tant que parent
 interleave_control_title=Contr\u00F4leur Interleave
 intsum_param_1=Premier entier \u00E0 ajouter
 intsum_param_2=Deuxi\u00E8me entier \u00E0 ajouter - les entier(s) suivants peuvent \u00EAtre ajout\u00E9(s) avec les arguments suivants.
 invalid_data=Donn\u00E9e invalide
 invalid_mail=Une erreur est survenue lors de l'envoi de l'email
 invalid_mail_address=Une ou plusieurs adresse(s) invalide(s) ont \u00E9t\u00E9 d\u00E9tect\u00E9e(s)
 invalid_mail_server=Le serveur de mail est inconnu (voir le fichier de journalisation JMeter)
 invalid_variables=Variables invalides
 iteration_counter_arg_1=TRUE, pour que chaque utilisateur ait son propre compteur, FALSE pour un compteur global
 iterator_num=Nombre d'it\u00E9rations \:
 ja=Japonais
 jar_file=Fichiers .jar
 java_request=Requ\u00EAte Java
 java_request_defaults=Requ\u00EAte Java par d\u00E9faut
 javascript_expression=Expression JavaScript \u00E0 \u00E9valuer
 jexl_expression=Expression JEXL \u00E0 \u00E9valuer
 jms_auth_required=Obligatoire
 jms_bytes_message=Message binaire
 jms_client_caption=Le client r\u00E9cepteur utilise MessageConsumer.receive () pour \u00E9couter les messages.
 jms_client_caption2=MessageListener utilise l'interface onMessage(Message) pour \u00E9couter les nouveaux messages.
 jms_client_id=ID du Client
 jms_client_type=Client
 jms_communication_style=Type de communication \: 
 jms_concrete_connection_factory=Fabrique de connexion 
 jms_config=Source du message \:
 jms_config_title=Configuration JMS
 jms_connection_factory=Fabrique de connexion
 jms_correlation_title=Champs alternatifs pour la correspondance de message
 jms_dest_setup=Evaluer
 jms_dest_setup_dynamic=A chaque \u00E9chantillon
 jms_dest_setup_static=Au d\u00E9marrage
 jms_durable_subscription_id=ID d'abonnement durable
 jms_file=Fichier
 jms_initial_context_factory=Fabrique de connexion initiale
 jms_itertions=Nombre d'\u00E9chantillons \u00E0 agr\u00E9ger
 jms_jndi_defaults_title=Configuration JNDI par d\u00E9faut
 jms_jndi_props=Propri\u00E9t\u00E9s JNDI
 jms_map_message=Message Map
 jms_message_title=Propri\u00E9t\u00E9s du message
 jms_message_type=Type de message \: 
 jms_msg_content=Contenu
 jms_object_message=Message Object
 jms_point_to_point=Requ\u00EAte JMS Point-\u00E0-point
 jms_props=Propri\u00E9t\u00E9s JMS
 jms_provider_url=URL du fournisseur
 jms_publisher=Requ\u00EAte JMS Publication
 jms_pwd=Mot de passe
 jms_queue=File
 jms_queue_connection_factory=Fabrique QueueConnection
 jms_queueing=Ressources JMS
 jms_random_file=Dossier contenant les fichiers al\u00E9atoires
 jms_read_response=Lire la r\u00E9ponse
 jms_receive_queue=Nom JNDI de la file d'attente Receive 
 jms_request=Requ\u00EAte seule
 jms_requestreply=Requ\u00EAte R\u00E9ponse
 jms_sample_title=Requ\u00EAte JMS par d\u00E9faut
 jms_selector=S\u00E9lecteur JMS
 jms_send_queue=Nom JNDI de la file d'attente Request
 jms_separator=S\u00E9parateur
 jms_stop_between_samples=Arr\u00EAter entre les \u00E9chantillons ?
 jms_subscriber_on_message=Utiliser MessageListener.onMessage()
 jms_subscriber_receive=Utiliser MessageConsumer.receive()
 jms_subscriber_title=Requ\u00EAte JMS Abonnement
 jms_testing_title=Messagerie Request
 jms_text_area=Message texte ou Message Objet s\u00E9rialis\u00E9 en XML par XStream
 jms_text_message=Message texte
 jms_timeout=D\u00E9lai (millisecondes)
 jms_topic=Destination
 jms_use_auth=Utiliser l'authentification ?
 jms_use_file=Depuis un fichier
 jms_use_non_persistent_delivery=Utiliser un mode de livraison non persistant ?
 jms_use_properties_file=Utiliser le fichier jndi.properties
 jms_use_random_file=Fichier al\u00E9atoire
 jms_use_req_msgid_as_correlid=Utiliser l'ID du message Request
 jms_use_res_msgid_as_correlid=Utiliser l'ID du message Response
 jms_use_text=Zone de texte (ci-dessous)
 jms_user=Utilisateur
 jndi_config_title=Configuration JNDI
 jndi_lookup_name=Interface remote
 jndi_lookup_title=Configuration Lookup JNDI 
 jndi_method_button_invoke=Invoquer
 jndi_method_button_reflect=R\u00E9flection
 jndi_method_home_name=Nom de la m\u00E9thode home
 jndi_method_home_parms=Param\u00E8tres de la m\u00E9thode home
 jndi_method_name=Configuration m\u00E9thode
 jndi_method_remote_interface_list=Interfaces remote
 jndi_method_remote_name=Nom m\u00E9thodes remote
 jndi_method_remote_parms=Param\u00E8tres m\u00E9thode remote
 jndi_method_title=Configuration m\u00E9thode remote
 jndi_testing_title=Requ\u00EAte JNDI
 jndi_url_jndi_props=Propri\u00E9t\u00E9s JNDI
 junit_append_error=Concat\u00E9ner les erreurs d'assertion
 junit_append_exception=Concat\u00E9ner les exceptions d'ex\u00E9cution
 junit_constructor_error=Impossible de cr\u00E9er une instance de la classe
 junit_constructor_string=Libell\u00E9 de cha\u00EEne Constructeur
 junit_create_instance_per_sample=Cr\u00E9er une nouvelle instance pour chaque \u00E9chantillon
 junit_do_setup_teardown=Ne pas appeler setUp et tearDown
 junit_error_code=Code d'erreur
 junit_error_default_code=9999
 junit_error_default_msg=Une erreur inattendue est survenue
 junit_error_msg=Message d'erreur
 junit_failure_code=Code d'\u00E9chec
 junit_failure_default_code=0001
 junit_failure_default_msg=Test \u00E9chou\u00E9
 junit_failure_msg=Message d'\u00E9chec
 junit_junit4=Rechercher les annotations JUnit 4 (au lieu de JUnit 3)
 junit_pkg_filter=Filtre de paquets
 junit_request=Requ\u00EAte JUnit
 junit_request_defaults=Requ\u00EAte par d\u00E9faut JUnit
 junit_success_code=Code de succ\u00E8s
 junit_success_default_code=1000
 junit_success_default_msg=Test r\u00E9ussi
 junit_success_msg=Message de succ\u00E8s
 junit_test_config=Param\u00E8tres Test JUnit
 junit_test_method=M\u00E9thode de test
 ldap_argument_list=Liste d'arguments LDAP
 ldap_connto=D\u00E9lai d'attente de connexion (millisecondes)
 ldap_parse_results=Examiner les r\u00E9sultats de recherche ?
 ldap_sample_title=Requ\u00EAte LDAP par d\u00E9faut
 ldap_search_baseobject=Effectuer une recherche 'baseobject'
 ldap_search_onelevel=Effectuer une recherche 'onelevel'
 ldap_search_subtree=Effectuer une recherche 'subtree'
 ldap_secure=Utiliser le protocole LDAP s\u00E9curis\u00E9 (ldaps) ?
 ldap_testing_title=Requ\u00EAte LDAP
 ldapext_sample_title=Requ\u00EAte LDAP \u00E9tendue par d\u00E9faut
 ldapext_testing_title=Requ\u00EAte LDAP \u00E9tendue
 library=Librairie
 load=Charger
 load_wsdl=Charger WSDL
 log_errors_only=Erreurs
 log_file=Emplacement du fichier de journal (log)
 log_function_comment=Commentaire (facultatif)
 log_function_level=Niveau de journalisation (INFO par d\u00E9faut), OUT ou ERR
 log_function_string=Cha\u00EEne \u00E0 tracer
 log_function_string_ret=Cha\u00EEne \u00E0 tracer (et \u00E0 retourner)
 log_function_throwable=Texte de l'exception Throwable (optionnel)
 log_only=Uniquement \:
 log_parser=Nom de la classe de parseur des journaux (log)
 log_parser_cnf_msg=N'a pas p\u00FB trouver cette classe. Assurez-vous que vous avez plac\u00E9 votre fichier jar dans le r\u00E9pertoire /lib
 log_parser_illegal_msg=N'a pas p\u00FB acc\u00E9der \u00E0 la classe \u00E0 cause d'une exception IllegalAccessException.
 log_parser_instantiate_msg=N'a pas p\u00FB cr\u00E9er une instance du parseur de log. Assurez-vous que le parseur impl\u00E9mente l'interface LogParser.
 log_sampler=Echantillon Journaux d'acc\u00E8s Tomcat
 log_success_only=Succ\u00E8s
 logic_controller_title=Contr\u00F4leur Simple
 login_config=Configuration Identification
 login_config_element=Configuration Identification 
 longsum_param_1=Premier long \u221A\u2020 ajouter
 longsum_param_2=Second long \u221A\u2020 ajouter - les autres longs pourront \u221A\u2122tre cumul\u221A\u00A9s en ajoutant d'autres arguments.
 loop_controller_title=Contr\u00F4leur Boucle
 looping_control=Contr\u00F4le de boucle
 lower_bound=Borne Inf\u00E9rieure
 mail_reader_account=Nom utilisateur \:
 mail_reader_all_messages=Tous
 mail_reader_delete=Supprimer les messages du serveur
 mail_reader_folder=Dossier \:
 mail_reader_num_messages=Nombre de message \u00E0 r\u00E9cup\u00E9rer \:
 mail_reader_password=Mot de passe \:
 mail_reader_port=Port (optionnel) \:
 mail_reader_server=Serveur \:
 mail_reader_server_type=Protocole (ex. pop3, imaps) \:
 mail_reader_storemime=Stocker le message en utilisant MIME (brut)
 mail_reader_title=Echantillon Lecteur d'email
 mail_sent=Email envoy\u00E9 avec succ\u00E8s
 mailer_addressees=Destinataire(s) \: 
 mailer_attributes_panel=Attributs de courrier
 mailer_connection_security=S\u00E9curit\u00E9 connexion \: 
 mailer_error=N'a pas p\u00FB envoyer l'email. Veuillez corriger les erreurs de saisie.
 mailer_failure_limit=Limite d'\u00E9chec \: 
 mailer_failure_subject=Sujet Echec \: 
 mailer_failures=Nombre d'\u00E9checs \: 
 mailer_from=Exp\u00E9diteur \: 
 mailer_host=Serveur \: 
 mailer_login=Identifiant \: 
 mailer_msg_title_error=Erreur
 mailer_msg_title_information=Information
 mailer_password=Mot de passe \: 
 mailer_port=Port \: 
 mailer_string=Notification d'email
 mailer_success_limit=Limite de succ\u00E8s \: 
 mailer_success_subject=Sujet Succ\u00E8s \: 
 mailer_test_mail=Tester email
 mailer_title_message=Message
 mailer_title_settings=Param\u00E8tres
 mailer_title_smtpserver=Serveur SMTP
 mailer_visualizer_title=R\u00E9cepteur Notification Email
 match_num_field=R\u00E9cup\u00E9rer la Ni\u00E8me corresp. (0 \: Al\u00E9atoire) \: 
 max=Maximum \:
 maximum_param=La valeur maximum autoris\u00E9e pour un \u00E9cart de valeurs
 md5hex_assertion_failure=Erreur de v\u00E9rification de la somme MD5 \: obtenu {0} mais aurait d\u00FB \u00EAtre {1}
 md5hex_assertion_label=MD5Hex
 md5hex_assertion_md5hex_test=MD5Hex \u00E0 v\u00E9rifier
 md5hex_assertion_title=Assertion MD5Hex
 memory_cache=Cache de m\u00E9moire
 menu_assertions=Assertions
 menu_close=Fermer
 menu_collapse_all=R\u00E9duire tout
 menu_config_element=Configurations
 menu_edit=Editer
 menu_expand_all=Etendre tout
 menu_fragments=Fragment d'\u00E9l\u00E9ments
 menu_generative_controller=Echantillons
 menu_listener=R\u00E9cepteurs
 menu_logger_panel=Afficher la console 
 menu_logic_controller=Contr\u00F4leurs Logiques
 menu_merge=Fusionner...
 menu_modifiers=Modificateurs
 menu_non_test_elements=El\u00E9ments hors test
 menu_open=Ouvrir...
 menu_post_processors=Post-Processeurs
 menu_pre_processors=Pr\u00E9-Processeurs
 menu_response_based_modifiers=Modificateurs bas\u00E9s sur la r\u00E9ponse
 menu_search=Rechercher
 menu_search_reset=Effacer la recherche
 menu_tables=Table
 menu_threads=Moteurs d'utilisateurs
 menu_timer=Compteurs de temps
 menu_toolbar=Barre d'outils
 metadata=M\u00E9ta-donn\u00E9es
 method=M\u00E9thode \:
 mimetype=Type MIME
 minimum_param=La valeur minimale autoris\u00E9e pour l'\u00E9cart de valeurs
 minute=minute
 modddn=Ancienne valeur
 modification_controller_title=Contr\u00F4leur Modification
 modification_manager_title=Gestionnaire Modification
 modify_test=Modification
 modtest=Modification
 module_controller_module_to_run=Module \u00E0 ex\u00E9cuter \:
 module_controller_title=Contr\u00F4leur Module
 module_controller_warning=Ne peut pas trouver le module \:
 monitor_equation_active=Activit\u00E9 \:  (occup\u00E9e/max) > 25%
 monitor_equation_dead=Mort \: pas de r\u00E9ponse
 monitor_equation_healthy=Sant\u00E9 \:  (occup\u00E9e/max) < 25%
 monitor_equation_load=Charge \:  ((occup\u00E9e / max) * 50) + ((m\u00E9moire utilis\u00E9e / m\u00E9moire maximum) * 50)
 monitor_equation_warning=Attention \:  (occup\u00E9/max) > 67%
 monitor_health_tab_title=Sant\u00E9
 monitor_health_title=Moniteur de connecteurs
 monitor_is_title=Utiliser comme moniteur
 monitor_label_left_bottom=0 %
 monitor_label_left_middle=50 %
 monitor_label_left_top=100 %
 monitor_label_prefix=Pr\u00E9fixe de connecteur \:
 monitor_label_right_active=Actif
 monitor_label_right_dead=Mort
 monitor_label_right_healthy=Sant\u00E9
 monitor_label_right_warning=Attention
 monitor_legend_health=Sant\u00E9
 monitor_legend_load=Charge
 monitor_legend_memory_per=M\u00E9moire % (utilis\u00E9e/total)
 monitor_legend_thread_per=Unit\u00E9 % (occup\u00E9/max)
 monitor_load_factor_mem=50
 monitor_load_factor_thread=50
 monitor_performance_servers=Serveurs
 monitor_performance_tab_title=Performance
 monitor_performance_title=Graphique de performance
 name=Nom \:
 new=Nouveau
 newdn=Nouveau DN
 next=Suivant
 no=Norv\u00E9gien
 number_of_threads=Nombre d'unit\u00E9s (utilisateurs) \:
 obsolete_test_element=Cet \u00E9l\u00E9ment de test est obsol\u00E8te
 once_only_controller_title=Contr\u00F4leur Ex\u00E9cution unique
 opcode=Code d'op\u00E9ration
 open=Ouvrir...
 option=Options
 optional_tasks=T\u00E2ches optionnelles
 paramtable=Envoyer les param\u00E8tres avec la requ\u00EAte \:
 password=Mot de passe \:
 paste=Coller
 paste_insert=Coller ins\u00E9rer
 path=Chemin \:
 path_extension_choice=Extension de chemin (utiliser ";" comme separateur)
 path_extension_dont_use_equals=Ne pas utiliser \u00E9gale dans l'extension de chemin (Compatibilit\u00E9 Intershop Enfinity)
 path_extension_dont_use_questionmark=Ne pas utiliser le point d'interrogation dans l'extension du chemin (Compatiblit\u00E9 Intershop Enfinity)
 patterns_to_exclude=URL \: motifs \u00E0 exclure
 patterns_to_include=URL \: motifs \u00E0 inclure
 pkcs12_desc=Clef PKCS 12 (*.p12)
 pl=Polonais
 poisson_timer_delay=D\u00E9lai de d\u00E9calage bas\u00E9 sur la loi de poisson (en millisecondes) \:
 poisson_timer_memo=Ajoute un d\u00E9lai al\u00E9atoire avec une distribution de type Poisson
 poisson_timer_range=D\u00E9viation (en millisecondes) \:
 poisson_timer_title=Compteur de temps al\u00E9atoire selon la loi de Poisson 
 port=Port \:
 post_as_parameters=Param\u00E8tres
 post_body=Donn\u00E9es POST
 post_body_raw=Donn\u00E9es POST brutes
 post_thread_group_title=Groupe d'unit\u00E9s de fin
 previous=Pr\u00E9c\u00E9dent
 property_as_field_label={0}\:
 property_default_param=Valeur par d\u00E9faut
 property_edit=Editer
 property_editor.value_is_invalid_message=Le texte que vous venez d'entrer n'a pas une valeur valide pour cette propri\u00E9t\u00E9.\nLa propri\u00E9t\u00E9 va revenir \u00E0 sa valeur pr\u00E9c\u00E9dente.
 property_editor.value_is_invalid_title=Texte saisi invalide
 property_name_param=Nom de la propri\u00E9t\u00E9
 property_returnvalue_param=Revenir \u00E0 la valeur originale de la propri\u00E9t\u00E9 (d\u00E9faut non) ?
 property_tool_tip={0}\: {1}
 property_undefined=Non d\u00E9fini
 property_value_param=Valeur de propri\u00E9t\u00E9
 property_visualiser_title=Afficheur de propri\u00E9t\u00E9s
 protocol=Protocole [http] \:
 protocol_java_border=Classe Java
 protocol_java_classname=Nom de classe \:
 protocol_java_config_tile=Configurer \u00E9chantillon Java
 protocol_java_test_title=Test Java
 provider_url=Provider URL
 proxy_assertions=Ajouter une Assertion R\u00E9ponse
 proxy_cl_error=Si un serveur proxy est sp\u00E9cifi\u00E9, h\u00F4te et port doivent \u00EAtre donn\u00E9
 proxy_content_type_exclude=Exclure \:
 proxy_content_type_filter=Filtre de type de contenu
 proxy_content_type_include=Inclure \:
 proxy_daemon_bind_error=Impossible de lancer le serveur proxy, le port est d\u00E9j\u00E0 utilis\u00E9. Choisissez un autre port.
 proxy_daemon_error=Impossible de lancer le serveur proxy, voir le journal pour plus de d\u00E9tails
 proxy_general_settings=Param\u00E8tres g\u00E9n\u00E9raux
 proxy_headers=Capturer les ent\u00EAtes HTTP
 proxy_regex=Correspondance des variables par regex ?
 proxy_sampler_settings=Param\u00E8tres Echantillon HTTP
 proxy_sampler_type=Type \:
 proxy_separators=Ajouter des s\u00E9parateurs
 proxy_target=Contr\u00F4leur Cible \:
 proxy_test_plan_content=Param\u00E8tres du plan de test
 proxy_title=Serveur Proxy HTTP
 pt_br=Portugais (Br\u00E9sil)
 ramp_up=Dur\u00E9e de mont\u00E9e en charge (en secondes) \:
 random_control_title=Contr\u00F4leur Al\u00E9atoire
 random_order_control_title=Contr\u00F4leur d'Ordre al\u00E9atoire
 random_string_chars_to_use=Caract\u00E8res \u00E0 utiliser pour la g\u00E9n\u00E9ration de la cha\u00EEne al\u00E9atoire
 random_string_length=Longueur de cha\u00EEne al\u00E9atoire
 read_response_message='Lire la r\u00E9ponse SOAP' n'est pas coch\u00E9. Pour voir la r\u00E9ponse, cocher la case dans la requ\u00EAte WebService svp.
 read_response_note=Si 'Lire la r\u00E9ponse SOAP' n'est pas coch\u00E9, la requ\u00EAte WebService ne lira pas la r\u00E9ponse.
 read_response_note2=et ne remplira pas l'objet SampleResult. Cela am\u00E9liore les performances, mais signifie que 
 read_response_note3=le contenu de la r\u00E9ponse ne sera pas tra\u00E7\u00E9.
 read_soap_response=Lire la r\u00E9ponse SOAP
 realm=Univers (realm)
 record_controller_title=Contr\u00F4leur Enregistreur
 ref_name_field=Nom de r\u00E9f\u00E9rence \:
 regex_extractor_title=Extracteur Expression r\u00E9guli\u00E8re
 regex_field=Expression r\u00E9guli\u00E8re \:
 regex_params_names_field=Num\u00E9ro du groupe de la Regex pour les noms des param\u00E8tres
 regex_params_ref_name_field=Nom de la r\u00E9f\u00E9rence de la Regex
 regex_params_title=Param\u00E8tres utilisateurs bas\u00E9s sur RegEx
 regex_params_values_field=Num\u00E9ro du groupe de la Regex pour les valeurs des param\u00E8tres
 regex_source=Port\u00E9e
 regex_src_body=Corps
 regex_src_body_as_document=Corps en tant que Document
 regex_src_body_unescaped=Corps (non \u00E9chapp\u00E9)
 regex_src_hdrs=Ent\u00EAtes
 regex_src_url=URL
 regexfunc_param_1=Expression r\u00E9guli\u00E8re utilis\u00E9e pour chercher les r\u00E9sultats de la requ\u00EAte pr\u00E9c\u00E9dente.
 regexfunc_param_2=Canevas pour la ch\u00EEne de caract\u00E8re de remplacement, utilisant des groupes d'expressions r\u00E9guli\u00E8res. Le format est  $[group]$.  Exemple $1$.
 regexfunc_param_3=Quelle correspondance utiliser. Un entier 1 ou plus grand, RAND pour indiquer que JMeter doit choisir al\u00E9atoirement , A d\u00E9cimal, ou ALL indique que toutes les correspondances doivent \u00EAtre utilis\u00E9es
 regexfunc_param_4=Entre le texte. Si ALL est s\u00E9lectionn\u00E9, l'entre-texte sera utilis\u00E9 pour g\u00E9n\u00E9rer les r\u00E9sultats ([""])
 regexfunc_param_5=Text par d\u00E9faut. Utilis\u00E9 \u00E0 la place du canevas si l'expression r\u00E9guli\u00E8re ne trouve pas de correspondance
 regexfunc_param_7=Variable en entr\u221A\u00A9e contenant le texte \u221A\u2020 parser ([\u221A\u00A9chantillon pr\u221A\u00A9c\u221A\u00A9dent])
 regexp_render_no_text=Les donn\u00E9es de r\u00E9ponse ne sont pas du texte.
 regexp_tester_button_test=Tester
 regexp_tester_field=Expression r\u00E9guli\u00E8re \:
 regexp_tester_title=Testeur de RegExp
 remote_error_init=Erreur lors de l'initialisation du serveur distant
 remote_error_starting=Erreur lors du d\u221A\u00A9marrage du serveur distant
 remote_exit=Sortie distante
 remote_exit_all=Sortie distante de tous
 remote_shut=Extinction \u00E0 distance
 remote_shut_all=Extinction \u00E0 distance de tous
 remote_start=D\u00E9marrage distant
 remote_start_all=D\u00E9marrage distant de tous
 remote_stop=Arr\u00EAt distant
 remote_stop_all=Arr\u00EAt distant de tous
 remove=Supprimer
 remove_confirm_msg=Etes-vous s\u00FBr de vouloir supprimer ce(s) \u00E9l\u00E9ment(s) ?
 remove_confirm_title=Confirmer la suppression ?
 rename=Renommer une entr\u00E9e
 report=Rapport
 report_bar_chart=Graphique \u221A\u2020 barres
 report_bar_graph_url=URL
 report_base_directory=R\u221A\u00A9pertoire de Base
 report_chart_caption=L\u221A\u00A9gende du graph
 report_chart_x_axis=Axe X
 report_chart_x_axis_label=Libell\u221A\u00A9 de l'Axe X
 report_chart_y_axis=Axe Y
 report_chart_y_axis_label=Libell\u221A\u00A9 de l'Axe Y
 report_line_graph=Graphique Lin\u221A\u00A9aire
 report_line_graph_urls=Inclure les URLs
 report_output_directory=R\u221A\u00A9pertoire de sortie du rapport
 report_page=Page de Rapport
 report_page_element=Page Element
 report_page_footer=Pied de page
 report_page_header=Ent\u221A\u2122te de Page
 report_page_index=Cr\u221A\u00A9er la Page d'Index
 report_page_intro=Page d'Introduction
 report_page_style_url=Url de la feuille de style
 report_page_title=Titre de la Page
 report_pie_chart=Camembert
 report_plan=Plan du rapport
 report_select=Selectionner
 report_summary=Rapport r\u221A\u00A9sum\u221A\u00A9
 report_table=Table du Rapport
 report_writer=R\u221A\u00A9dacteur du Rapport
 report_writer_html=R\u221A\u00A9dacteur de rapport HTML
 request_data=Donn\u00E9e requ\u00EAte
 reset_gui=R\u00E9initialiser l'\u00E9l\u00E9ment
 response_save_as_md5=R\u00E9ponse en empreinte MD5
 restart=Red\u00E9marrer
 resultaction_title=Op\u00E9rateur R\u00E9sultats Action
 resultsaver_addtimestamp=Ajouter un timestamp
 resultsaver_errors=Enregistrer seulement les r\u00E9ponses en \u00E9checs
 resultsaver_numberpadlen=Taille minimale du num\u00E9ro de s\u00E9quence
 resultsaver_prefix=Pr\u00E9fixe du nom de fichier \: 
 resultsaver_skipautonumber=Ne pas ajouter de nombre au pr\u00E9fixe
 resultsaver_skipsuffix=Ne pas ajouter de suffixe
 resultsaver_success=Enregistrer seulement les r\u00E9ponses en succ\u00E8s
 resultsaver_title=Sauvegarder les r\u00E9ponses vers un fichier
 resultsaver_variable=Nom de variable \:
 retobj=Retourner les objets
 return_code_config_box_title=Configuration du code retour
 reuseconnection=R\u00E9-utiliser la connexion
 revert_project=Annuler les changements
 revert_project?=Annuler les changements sur le projet ?
 root=Racine
 root_title=Racine
 run=Lancer
 running_test=Lancer test
 runtime_controller_title=Contr\u00F4leur Dur\u00E9e d'ex\u00E9cution
 runtime_seconds=Temps d'ex\u00E9cution (secondes) \:
 sample_result_save_configuration=Sauvegarder la configuration de la sauvegarde des \u00E9chantillons
 sample_scope=Appliquer sur
 sample_scope_all=L'\u00E9chantillon et ses ressources li\u00E9es
 sample_scope_children=Les ressources li\u00E9es
 sample_scope_parent=L'\u00E9chantillon
 sample_scope_variable=Une variable \:
 sampler_label=Libell\u00E9
 sampler_on_error_action=Action \u00E0 suivre apr\u00E8s une erreur d'\u00E9chantillon
 sampler_on_error_continue=Continuer
 sampler_on_error_start_next_loop=D\u00E9marrer it\u00E9ration suivante
 sampler_on_error_stop_test=Arr\u00EAter le test
 sampler_on_error_stop_test_now=Arr\u00EAter le test imm\u00E9diatement
 sampler_on_error_stop_thread=Arr\u00EAter l'unit\u00E9
 save=Enregistrer le plan de test
 save?=Enregistrer ?
 save_all_as=Enregistrer le plan de test sous...
 save_as=Enregistrer sous...
 save_as_error=Au moins un \u00E9l\u00E9ment doit \u00EAtre s\u00E9lectionn\u00E9 \!
 save_as_image=Enregistrer en tant qu'image sous...
 save_as_image_all=Enregistrer l'\u00E9cran en tant qu'image...
 save_assertionresultsfailuremessage=Messages d'erreur des assertions
 save_assertions=R\u00E9sultats des assertions (XML)
 save_asxml=Enregistrer au format XML
 save_bytes=Nombre d'octets
 save_code=Code de r\u00E9ponse HTTP
 save_datatype=Type de donn\u00E9es
 save_encoding=Encodage
 save_fieldnames=Libell\u00E9 des colonnes (CSV)
 save_filename=Nom de fichier de r\u00E9ponse
 save_graphics=Enregistrer le graphique
 save_hostname=Nom d'h\u00F4te
 save_idletime=Temps d'inactivit\u00E9
 save_label=Libell\u00E9
 save_latency=Latence
 save_message=Message de r\u00E9ponse
 save_overwrite_existing_file=Le fichier s\u00E9lectionn\u00E9 existe d\u00E9j\u00E0, voulez-vous l'\u00E9craser ?
 save_requestheaders=Ent\u00EAtes de requ\u00EAte (XML)
 save_responsedata=Donn\u00E9es de r\u00E9ponse (XML)
 save_responseheaders=Ent\u00EAtes de r\u00E9ponse (XML)
 save_samplecount=Nombre d'\u00E9chantillon et d'erreur
 save_samplerdata=Donn\u00E9es d'\u00E9chantillon (XML)
 save_subresults=Sous r\u00E9sultats (XML)
 save_success=Succ\u00E8s
 save_threadcounts=Nombre d'unit\u00E9s actives
 save_threadname=Nom d'unit\u00E9
 save_time=Temps \u00E9coul\u00E9
 save_timestamp=Horodatage
 save_url=URL
 save_workbench=Sauvegarder le plan de travail
 sbind=Simple connexion/d\u00E9connexion
 scheduler=Programmateur de d\u00E9marrage
 scheduler_configuration=Configuration du programmateur
 scope=Port\u00E9e
 search=Rechercher
 search_base=Base de recherche
 search_expand=Rechercher & D\u00E9plier
 search_filter=Filtre de recherche
 search_test=Recherche
 search_text_button_close=Fermer
 search_text_button_find=Rechercher
 search_text_button_next=Suivant
 search_text_chkbox_case=Consid\u00E9rer la casse
 search_text_chkbox_regexp=Exp. reguli\u00E8re
 search_text_field=Rechercher \:
 search_text_msg_not_found=Texte non trouv\u00E9
 search_text_title_not_found=Pas trouv\u00E9
 search_tree_title=Rechercher dans l'arbre
 searchbase=Base de recherche
 searchfilter=Filtre de recherche
 searchtest=Recherche
 second=seconde
 secure=S\u00E9curis\u00E9 \:
 send_file=Envoyer un fichier avec la requ\u00EAte \:
 send_file_browse=Parcourir...
 send_file_filename_label=Chemin du fichier \: 
 send_file_mime_label=Type MIME \:
 send_file_param_name_label=Nom du param\u00E8tre \:
 server=Nom ou IP du serveur \:
 servername=Nom du serveur \:
 session_argument_name=Nom des arguments de la session
 setup_thread_group_title=Groupe d'unit\u00E9s de d\u00E9but
 should_save=Vous devez enregistrer le plan de test avant de le lancer.  \nSi vous utilisez des fichiers de donn\u00E9es (i.e. Source de donn\u00E9es CSV ou la fonction _StringFromFile), \nalors c'est particuli\u00E8rement important d'enregistrer d'abord votre script de test. \nVoulez-vous enregistrer maintenant votre plan de test ?
 shutdown=Eteindre
 simple_config_element=Configuration Simple
 simple_data_writer_title=Enregistreur de donn\u00E9es
 size_assertion_comparator_error_equal=est \u00E9gale \u00E0
 size_assertion_comparator_error_greater=est plus grand que
 size_assertion_comparator_error_greaterequal=est plus grand ou \u00E9gale \u00E0
 size_assertion_comparator_error_less=est inf\u00E9rieur \u00E0
 size_assertion_comparator_error_lessequal=est inf\u00E9rieur ou \u00E9gale \u00E0
 size_assertion_comparator_error_notequal=n'est pas \u00E9gale \u00E0
 size_assertion_comparator_label=Type de comparaison
 size_assertion_failure=Le r\u00E9sultat n''a pas la bonne taille \: il \u00E9tait de {0} octet(s), mais aurait d\u00FB \u00EAtre de {1} {2} octet(s).
 size_assertion_input_error=Entrer un entier positif valide svp.
 size_assertion_label=Taille en octets \:
 size_assertion_size_test=Taille \u00E0 v\u00E9rifier
 size_assertion_title=Assertion Taille
 smime_assertion_issuer_dn=Nom unique de l'\u00E9metteur \: 
 smime_assertion_message_position=V\u00E9rifier l'assertion sur le message \u00E0 partir de la position
 smime_assertion_not_signed=Message non sign\u00E9
 smime_assertion_signature=Signature
 smime_assertion_signer=Certificat signataire
 smime_assertion_signer_by_file=Fichier du certificat \: 
 smime_assertion_signer_constraints=V\u00E9rifier les valeurs \:
 smime_assertion_signer_dn=Nom unique du signataire \: 
 smime_assertion_signer_email=Adresse courriel du signataire \: 
 smime_assertion_signer_no_check=Pas de v\u00E9rification
 smime_assertion_signer_serial=Num\u00E9ro de s\u00E9rie \: 
 smime_assertion_title=Assertion SMIME
 smime_assertion_verify_signature=V\u00E9rifier la signature
 smtp_additional_settings=Param\u00E8tres suppl\u00E9mentaires
 smtp_attach_file=Fichier(s) attach\u00E9(s) \:
 smtp_attach_file_tooltip=S\u00E9parer les fichiers par le point-virgule ";"
 smtp_auth_settings=Param\u00E8tres d'authentification
 smtp_bcc=Adresse en copie cach\u00E9e (Bcc) \:
 smtp_cc=Adresse en copie (CC) \:
 smtp_default_port=(D\u00E9fauts \: SMTP \: 25, SSL \: 465, StartTLS \: 587)
 smtp_eml=Envoyer un message .eml \:
 smtp_enabledebug=Activer les traces de d\u00E9bogage ?
 smtp_enforcestarttls=Forcer le StartTLS
 smtp_enforcestarttls_tooltip=<html><b>Force</b> le serveur a utiliser StartTLS.<br />Si il n'est pas s\u00E9lectionn\u00E9 et que le serveur SMTP ne supporte pas StartTLS, <br />une connexion SMTP normale sera utilis\u00E9e \u00E0 la place. <br /><i>Merci de noter</i> que la case \u00E0 cocher cr\u00E9\u00E9e un fichier dans /tmp/, <br />donc cela peut poser des probl\u00E8mes sous Windows.</html>
 smtp_from=Adresse exp\u00E9diteur (From) \:
 smtp_header_add=Ajouter une ent\u00EAte
 smtp_header_name=Nom d'ent\u00EAte
 smtp_header_remove=Supprimer
 smtp_header_value=Valeur d'ent\u00EAte
 smtp_mail_settings=Param\u00E8tres du courriel
 smtp_message=Message \:
 smtp_message_settings=Param\u00E8tres du message
 smtp_messagesize=Calculer la taille du message
 smtp_password=Mot de passe \:
 smtp_plainbody=Envoyer le message en texte (i.e. sans multipart/mixed)
 smtp_replyto=Adresse de r\u00E9ponse (Reply-To) \:
 smtp_sampler_title=Requ\u00EAte SMTP
 smtp_security_settings=Param\u00E8tres de s\u00E9curit\u00E9
 smtp_server=Serveur \:
 smtp_server_port=Port \:
 smtp_server_settings=Param\u00E8tres du serveur
 smtp_subject=Sujet \:
 smtp_suppresssubj=Supprimer l'ent\u00EAte Sujet (Subject)
 smtp_timestamp=Ajouter un horodatage dans le sujet
 smtp_to=Adresse destinataire (To) \:
 smtp_trustall=Faire confiance \u00E0 tous les certificats
 smtp_trustall_tooltip=<html><b>Forcer</b> JMeter \u00E0 faire confiance \u00E0 tous les certificats, quelque soit l'autorit\u00E9 de certification du certificat.</html>
 smtp_truststore=Coffre de cl\u00E9s local \:
 smtp_truststore_tooltip=<html>Le chemin du coffre de confiance.<br />Les chemins relatifs sont d\u00E9termin\u00E9s \u00E0 partir du r\u00E9pertoire courant.<br />En cas d'\u00E9chec, c'est le r\u00E9pertoire contenant le script JMX qui est utilis\u00E9.</html>
 smtp_useauth=Utiliser l'authentification
 smtp_usenone=Pas de fonctionnalit\u00E9 de s\u00E9curit\u00E9
 smtp_username=Identifiant \:
 smtp_usessl=Utiliser SSL
 smtp_usestarttls=Utiliser StartTLS
 smtp_usetruststore=Utiliser le coffre de confiance local
 smtp_usetruststore_tooltip=<html>Autoriser JMeter \u00E0 utiliser le coffre de confiance local.</html>
 soap_action=Action Soap
 soap_data_title=Donn\u00E9es Soap/XML-RPC
 soap_sampler_file_invalid=Le nom de fichier r\u00E9f\u00E9rence un fichier absent ou sans droits de lecture\:
 soap_sampler_title=Requ\u00EAte SOAP/XML-RPC
 soap_send_action=Envoyer l'action SOAP \:
 solinger=SO_LINGER\:
 spline_visualizer_average=Moyenne \:
 spline_visualizer_incoming=Entr\u00E9e \:
 spline_visualizer_maximum=Maximum \:
 spline_visualizer_minimum=Minimum \:
 spline_visualizer_title=Moniteur de courbe (spline)
 spline_visualizer_waitingmessage=En attente de r\u00E9sultats d'\u00E9chantillons
 split_function_separator=S\u00E9parateur utilis\u00E9 pour scinder le texte. Par d\u00E9faut , (virgule) est utilis\u00E9.
 split_function_string=Texte \u00E0 scinder
 ssl_alias_prompt=Veuillez entrer votre alias pr\u00E9f\u00E9r\u00E9
 ssl_alias_select=S\u00E9lectionner votre alias pour le test
 ssl_alias_title=Alias du client
 ssl_error_title=Probl\u00E8me de KeyStore
 ssl_pass_prompt=Entrer votre mot de passe
 ssl_pass_title=Mot de passe KeyStore
 ssl_port=Port SSL
 sslmanager=Gestionnaire SSL
 start=Lancer
 start_no_timers=Lancer sans pauses
 starttime=Date et heure de d\u00E9marrage \:
 stop=Arr\u00EAter
 stopping_test=En train d'\u00E9teindre toutes les unit\u00E9s de tests. Soyez patient, merci.
 stopping_test_failed=Au moins une unit\u00E9 non arr\u00EAt\u00E9e; voir le journal.
 stopping_test_title=En train d'arr\u00EAter le test
 string_from_file_encoding=Encodage du fichier (optionnel)
 string_from_file_file_name=Entrer le chemin (absolu ou relatif) du fichier
 string_from_file_seq_final=Nombre final de s\u00E9quence de fichier
 string_from_file_seq_start=D\u00E9marer le nombre de s\u00E9quence de fichier
 summariser_title=G\u00E9n\u00E9rer les resultats consolid\u00E9s
 summary_report=Rapport consolid\u00E9
 switch_controller_label=Aller vers le num\u00E9ro d'\u00E9l\u00E9ment (ou nom) subordonn\u00E9 \:
 switch_controller_title=Contr\u00F4leur Aller \u00E0
 system_sampler_stderr=Erreur standard (stderr) \:
 system_sampler_stdin=Entr\u00E9e standard (stdin) \:
 system_sampler_stdout=Sortie standard (stdout) \:
 system_sampler_title=Appel de processus syst\u00E8me
 table_visualizer_bytes=Octets
 table_visualizer_latency=Latence
 table_visualizer_sample_num=Echantillon \#
 table_visualizer_sample_time=Temps (ms)
 table_visualizer_start_time=Heure d\u00E9but
 table_visualizer_status=Statut
 table_visualizer_success=Succ\u00E8s
 table_visualizer_thread_name=Nom d'unit\u00E9
 table_visualizer_warning=Alerte
 target_server=Serveur cible
 tcp_classname=Nom de classe TCPClient \:
 tcp_config_title=Param\u00E8tres TCP par d\u00E9faut
 tcp_nodelay=D\u00E9finir aucun d\u00E9lai (NoDelay)
 tcp_port=Num\u00E9ro de port \:
 tcp_request_data=Texte \u00E0 envoyer \:
 tcp_sample_title=Requ\u00EAte TCP
 tcp_timeout=Expiration (millisecondes) \:
 teardown_on_shutdown=Ex\u00E9cuter le Groupe d'unit\u00E9s de fin m\u00EAme apr\u00E8s un arr\u00EAt manuel des Groupes d'unit\u00E9s principaux
+template_choose=Choisir le mod\u00E8le
+template_create_from=Cr\u00E9er
 template_field=Canevas \:
+template_title=Cr\u00E9er \u00E0 partir du mod\u00E8le
 test=Test
 test_action_action=Action \:
 test_action_duration=Dur\u00E9e (millisecondes) \:
 test_action_pause=Mettre en pause
 test_action_restart_next_loop=Passer \u00E0 l'it\u00E9ration suivante de la boucle
 test_action_stop=Arr\u00EAter
 test_action_stop_now=Arr\u00EAter imm\u00E9diatement
 test_action_target=Cible \:
 test_action_target_test=Toutes les unit\u00E9s
 test_action_target_thread=Unit\u00E9 courante
 test_action_title=Action test
 test_configuration=Type de test
 test_fragment_title=Fragment d'\u00E9l\u00E9ments
 test_plan=Plan de test
 test_plan_classpath_browse=Ajouter un r\u00E9pertoire ou un fichier 'jar' au 'classpath'
 testconfiguration=Tester la configuration
 testplan.serialized=Lancer les groupes d'unit\u00E9s en s\u00E9rie (c'est-\u00E0-dire \: lance un groupe \u00E0 la fois)
 testplan_comments=Commentaires \:
 testt=Test
 textbox_cancel=Annuler
 textbox_close=Fermer
 textbox_save_close=Enregistrer & Fermer
 textbox_title_edit=Editer texte
 textbox_title_view=Voir texte
 textbox_tooltip_cell=Double clic pour voir/editer
 thread_delay_properties=Propri\u00E9t\u00E9s de temporisation de l'unit\u00E9
 thread_group_title=Groupe d'unit\u00E9s
 thread_properties=Propri\u00E9t\u00E9s du groupe d'unit\u00E9s
 threadgroup=Groupe d'unit\u00E9s
 throughput_control_bynumber_label=Ex\u00E9cutions totales
 throughput_control_bypercent_label=Pourcentage d'ex\u00E9cution
 throughput_control_perthread_label=Par utilisateur
 throughput_control_title=Contr\u00F4leur D\u00E9bit
 throughput_control_tplabel=D\u00E9bit \:
 time_format=Chaine de formatage sur le mod\u00E8le SimpleDateFormat (optionnel)
 timelim=Limiter le temps de r\u00E9ponses \u00E0 (ms)
 toggle=Permuter
 toolbar_icon_set_not_found=Le fichier de description des ic\u00F4nes de la barre d'outils n'est pas trouv\u00E9. Voir les journaux.
 total_threads_tooltip=Nombre total d'Unit\u00E9s \u00E0 lancer
 tr=Turc
 transaction_controller_include_timers=Inclure la dur\u00E9e des compteurs de temps et pre/post processeurs dans le calcul du temps
 transaction_controller_parent=G\u00E9n\u00E9rer en \u00E9chantillon parent
 transaction_controller_title=Contr\u00F4leur Transaction
 unbind=D\u00E9connexion de l'unit\u00E9
 unescape_html_string=Cha\u00EEne \u00E0 \u00E9chapper
 unescape_string=Cha\u00EEne de caract\u00E8res contenant des\u00E9chappements Java
 uniform_timer_delay=D\u00E9lai de d\u00E9calage constant (en millisecondes) \:
 uniform_timer_memo=Ajoute un d\u00E9lai al\u00E9atoire avec une distribution uniforme
 uniform_timer_range=D\u00E9viation al\u00E9atoire maximum (en millisecondes) \:
 uniform_timer_title=Compteur de temps al\u00E9atoire uniforme
 up=Monter
 update=Mettre \u00E0 jour
 update_per_iter=Mettre \u00E0 jour une fois par it\u00E9ration
 upload=Fichier \u00E0 uploader
 upper_bound=Borne sup\u00E9rieure
 url=URL
 url_config_get=GET
 url_config_http=HTTP
 url_config_https=HTTPS
 url_config_post=POST
 url_config_protocol=Protocole \:
 url_config_title=Param\u00E8tres HTTP par d\u00E9faut
 url_full_config_title=Echantillon d'URL complet
 url_multipart_config_title=Requ\u00EAte HTTP Multipart par d\u00E9faut
 urldecode_string=Cha\u00EEne de style URL \u00E0 d\u00E9coder
 urlencode_string=Cha\u00EEne de caract\u00E8res \u00E0 encoder en style URL
 use_expires=Utiliser les ent\u00EAtes Cache-Control/Expires lors du traitement des requ\u00EAtes GET
 use_keepalive=Connexion persist.
 use_multipart_for_http_post=Multipart/form-data
 use_multipart_mode_browser=Ent\u00EAtes compat. navigateur
 use_recording_controller=Utiliser un contr\u00F4leur enregistreur
 user=Utilisateur
 user_defined_test=Test d\u00E9fini par l'utilisateur
 user_defined_variables=Variables pr\u00E9-d\u00E9finies
 user_param_mod_help_note=(Ne pas changer. A la place, modifier le fichier de ce nom dans le r\u00E9pertoire /bin de JMeter)
 user_parameters_table=Param\u00E8tres
 user_parameters_title=Param\u00E8tres Utilisateur
 userdn=Identifiant
 username=Nom d'utilisateur \:
 userpw=Mot de passe
 value=Valeur \:
 value_to_quote_meta=Valeur \u00E0 \u00E9chapper des caract\u00E8res sp\u00E9ciaux utilis\u00E8s par ORO Regexp
 var_name=Nom de r\u00E9f\u00E9rence \:
 variable_name_param=Nom de variable (peut inclure une r\u00E9f\u00E9rence de variable ou fonction)
 view_graph_tree_title=Voir le graphique en arbre
 view_results_assertion_error=Erreur d'assertion \: 
 view_results_assertion_failure=Echec d'assertion \: 
 view_results_assertion_failure_message=Message d'\u00E9chec d'assertion \: 
 view_results_autoscroll=D\u00E9filement automatique ?
 view_results_childsamples=Echantillons enfants?
 view_results_desc=Affiche les r\u00E9sultats d'un \u00E9chantillon dans un arbre de r\u00E9sultats
 view_results_error_count=Compteur erreur\: 
 view_results_fields=champs \:
 view_results_in_table=Tableau de r\u00E9sultats
 view_results_latency=Latence \: 
 view_results_load_time=Temps de r\u00E9ponse \: 
 view_results_render=Rendu \: 
 view_results_render_document=Document
 view_results_render_html=HTML
 view_results_render_html_embedded=HTML et ressources
 view_results_render_json=JSON
 view_results_render_text=Texte brut
 view_results_render_xml=XML
 view_results_request_headers=Ent\u00EAtes de requ\u00EAte \:
 view_results_response_code=Code de retour \: 
 view_results_response_headers=Ent\u00EAtes de r\u00E9ponse \:
 view_results_response_message=Message de retour \: 
 view_results_response_missing_tika=Manque l'archive tika-app.jar dans le classpath. Impossible de convertir en texte ce type de document.\nT\u00E9l\u00E9charger le fichier tika-app-x.x.jar depuis http\://tika.apache.org/download.html\nPuis ajouter ce fichier dans le r\u00E9pertoire <JMeter>/lib
 view_results_response_partial_message=D\u00E9but du message\:
 view_results_response_too_large_message=R\u00E9ponse d\u00E9passant la taille maximale d'affichage. Taille \: 
 view_results_sample_count=Compteur \u00E9chantillon \: 
 view_results_sample_start=Date d\u00E9but \u00E9chantillon \: 
 view_results_search_pane=Volet recherche 
 view_results_size_body_in_bytes=Taille du corps en octets \: 
 view_results_size_headers_in_bytes=Taille de l'ent\u00EAte en octets \: 
 view_results_size_in_bytes=Taille en octets \: 
 view_results_tab_assertion=R\u00E9sultats d'assertion
 view_results_tab_request=Requ\u00EAte
 view_results_tab_response=Donn\u00E9es de r\u00E9ponse
 view_results_tab_sampler=R\u00E9sultat de l'\u00E9chantillon
 view_results_table_fields_key=Champ suppl\u00E9mentaire
 view_results_table_fields_value=Valeur
 view_results_table_headers_key=Ent\u00EAtes de r\u00E9ponse
 view_results_table_headers_value=Valeur
 view_results_table_request_headers_key=Ent\u00EAtes de requ\u00EAte
 view_results_table_request_headers_value=Valeur
 view_results_table_request_http_cookie=Cookie
 view_results_table_request_http_host=H\u00F4te
 view_results_table_request_http_method=M\u00E9thode
 view_results_table_request_http_nohttp=N'est pas un \u00E9chantillon HTTP
 view_results_table_request_http_path=Chemin
 view_results_table_request_http_port=Port
 view_results_table_request_http_protocol=Protocole
 view_results_table_request_params_key=Nom de param\u00E8tre
 view_results_table_request_params_value=Valeur
 view_results_table_request_raw_nodata=Pas de donn\u00E9es \u00E0 afficher
 view_results_table_request_tab_http=HTTP
 view_results_table_request_tab_raw=Brut
 view_results_table_result_tab_parsed=D\u00E9cod\u00E9
 view_results_table_result_tab_raw=Brut
 view_results_thread_name=Nom d'unit\u00E9 \: 
 view_results_title=Voir les r\u00E9sultats
 view_results_tree_title=Arbre de r\u00E9sultats
 warning=Attention \!
 web_cannot_convert_parameters_to_raw=Ne peut pas convertir les param\u00E8tres en Donn\u00E9es POST brutes\ncar l'un des param\u00E8tres a un nom.
 web_cannot_switch_tab=Vous ne pouvez pas basculer car ces donn\u00E9es ne peuvent \u00EAtre converties.\nVider les donn\u00E9es pour basculer.
 web_parameters_lost_message=Basculer vers les Donn\u00E9es POST brutes va convertir en format brut\net perdre le format tabulaire quand vous s\u00E9lectionnerez un autre noeud\nou \u00E0 la sauvegarde du plan de test, \u00EAtes-vous s\u00FBr ?
 web_proxy_server_title=Requ\u00EAte via un serveur proxy
 web_request=Requ\u00EAte HTTP
 web_server=Serveur web
 web_server_client=Impl\u00E9mentation client \:
 web_server_domain=Nom ou adresse IP \:
 web_server_port=Port \:
 web_server_timeout_connect=Connexion \:
 web_server_timeout_response=R\u00E9ponse \:
 web_server_timeout_title=D\u00E9lai expiration (ms)
 web_testing2_source_ip=Adresse IP source \:
 web_testing2_title=Requ\u00EAte HTTP HTTPClient
 web_testing_concurrent_download=Utiliser pool unit\u00E9. Nbre \:
 web_testing_embedded_url_pattern=Les URL \u00E0 inclure doivent correspondre \u00E0 \:
 web_testing_retrieve_images=R\u00E9cup\u00E9rer les ressources incluses
 web_testing_title=Requ\u00EAte HTTP
 webservice_configuration_wizard=Assistant de configuration WSDL
 webservice_get_xml_from_random_title=Utiliser al\u00E9atoirement des messages SOAP
 webservice_maintain_session=Maintenir la Session HTTP
 webservice_message_soap=Message WebService
 webservice_methods=M\u00E9thode(s) WebService \:
 webservice_proxy_host=H\u00F4te proxy
 webservice_proxy_note=Si 'utiliser un proxy HTTP' est coch\u00E9e, mais qu'aucun h\u00F4te ou port est fournit, l'\u00E9chantillon
 webservice_proxy_note2=regardera les options de ligne de commandes. Si aucun h\u00F4te ou port du proxy sont fournit 
 webservice_proxy_note3=non plus, il \u00E9chouera silencieusement.
 webservice_proxy_port=Port proxy
 webservice_sampler_title=Requ\u00EAte WebService (SOAP) (DEPRECATED)
 webservice_soap_action=Action SOAP \:
 webservice_timeout=D\u00E9lai expiration \:
 webservice_use_proxy=Utiliser un proxy HTTP
 while_controller_label=Condition (fonction ou variable) \:
 while_controller_title=Contr\u00F4leur Tant Que
 workbench_title=Plan de travail
 wsdl_helper_error=Le WSDL n'est pas valide, veuillez rev\u00E9rifier l'URL.
 wsdl_url=URL du WSDL
 wsdl_url_error=Le WSDL est vide.
 xml_assertion_title=Assertion XML
 xml_download_dtds=R\u00E9cup\u00E9rer les DTD externes
 xml_namespace_button=Utiliser les espaces de noms
 xml_tolerant_button=Utiliser Tidy (analyseur tol\u00E9rant)
 xml_validate_button=Validation XML
 xml_whitespace_button=Ignorer les espaces
 xmlschema_assertion_label=Nom de fichier \: 
 xmlschema_assertion_title=Assertion Sch\u00E9ma XML
 xpath_assertion_button=Valider
 xpath_assertion_check=V\u00E9rifier l'expression XPath
 xpath_assertion_error=Erreur avec XPath
 xpath_assertion_failed=Expression XPath invalide
 xpath_assertion_label=XPath
 xpath_assertion_negate=Vrai si aucune correspondance trouv\u00E9e
 xpath_assertion_option=Options d'analyse XML
 xpath_assertion_test=V\u00E9rificateur XPath
 xpath_assertion_tidy=Essayer et nettoyer l'entr\u00E9e
 xpath_assertion_title=Assertion XPath
 xpath_assertion_valid=Expression XPath valide
 xpath_assertion_validation=Valider le code XML \u00E0 travers le fichier DTD
 xpath_assertion_whitespace=Ignorer les espaces
 xpath_expression=Expression XPath de correspondance
 xpath_extractor_fragment=Retourner le fragment XPath entier au lieu du contenu
 xpath_extractor_query=Requ\u00EAte XPath \:
 xpath_extractor_title=Extracteur XPath
 xpath_file_file_name=Fichier XML contenant les valeurs
 xpath_tidy_quiet=Silencieux
 xpath_tidy_report_errors=Rapporter les erreurs
 xpath_tidy_show_warnings=Afficher les alertes
 you_must_enter_a_valid_number=Vous devez entrer un nombre valide
 zh_cn=Chinois (simplifi\u00E9)
 zh_tw=Chinois (traditionnel)
diff --git a/xdocs/changes.xml b/xdocs/changes.xml
index e99e4658b..155c4f760 100644
--- a/xdocs/changes.xml
+++ b/xdocs/changes.xml
@@ -1,246 +1,247 @@
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
 
 
 <!--  =================== 2.10 =================== -->
 
 <h1>Version 2.10</h1>
 
 <h2>New and Noteworthy</h2>
 
 <!--  =================== Known bugs =================== -->
 
 <h2>Known bugs</h2>
 
 <p>The Once Only controller behaves correctly under a Thread Group or Loop Controller,
 but otherwise its behaviour is not consistent (or clearly specified).</p>
 
 <p>Listeners don't show iteration counts when a If Controller has a condition which is always false from the first iteration (see <bugzilla>52496</bugzilla>).  
 A workaround is to add a sampler at the same level as (or superior to) the If Controller.
 For example a Test Action sampler with 0 wait time (which doesn't generate a sample),
 or a Debug Sampler with all fields set to False (to reduce the sample size).
 </p>
 
 <p>Webservice sampler does not consider the HTTP response status to compute the status of a response, thus a response 500 containing a non empty body will be considered as successful, see <bugzilla>54006</bugzilla>.
 To workaround this issue, ensure you always read the response and add a Response Assertion checking text inside the response.
 </p>
 
 <p>
 Changing language can break part of the configuration of the following elements (see <bugzilla>53679</bugzilla>):
 <ul>
     <li>CSV Data Set Config (sharing mode will be lost)</li>
     <li>Constant Throughput Timer (Calculate throughput based on will be lost)</li>
 </ul>
 </p>
 
 <p>
 The numbers that appear to the left of the green box are the number of active threads / total number of threads, 
 these only apply to a locally run test; they do not include any threads started on remote systems when using client-server mode, (see <bugzilla>54152</bugzilla>).
 </p>
 
 <p>
 Note that there is a bug in Java on some Linux systems that manifests
 itself as the following error when running the test cases or JMeter itself:
 <pre>
  [java] WARNING: Couldn't flush user prefs:
  java.util.prefs.BackingStoreException:
  java.lang.IllegalArgumentException: Not supported: indent-number
 </pre>
 This does not affect JMeter operation.
 </p>
 
 <!-- =================== Incompatible changes =================== -->
 
 <h2>Incompatible changes</h2>
 
 <p>SMTP Sampler now uses eml file subject if subject field is empty</p>
 
 <p>With this version autoFlush has been turned off on PrintWriter in charge of writing test results. 
 This results in improved throughput for intensive tests but can result in more test data loss in case
 of JMeter crash (very rare). To revert to previous behaviour set jmeter.save.saveservice.autoflush property to true. </p>
 
 <p>
 Shortcut for Function Helper Dialog is now CTRL+SHIFT+F1 (CMD + SHIFT + F1 for Mac OS).
 The original key sequence (Ctrl+F1) did not work in some locations (it is consumed by the Java Swing ToolTipManager).
 It was therefore necessary to change the shortcut.
 </p>
 
 <p>
 Webservice (SOAP) Request has been removed by default from GUI as Element is deprecated (use HTTP Sampler with Raw Post body), if you need to show it, see property not_in_menu in jmeter.properties
 </p>
 
 <p>
 Transaction Controller now sets Response Code of Generated Parent Sampler (if Generate Parent Sampler is checked) to response code of first failing child in case of failure of one of the children, in previous versions Response Code was empty.
 </p>
 
 <!-- =================== Bug fixes =================== -->
 
 <h2>Bug fixes</h2>
 
 <h3>HTTP Samplers and Proxy</h3>
 <ul>
 <li><bugzilla>54627</bugzilla> - JMeter Proxy GUI: Type of sampler settings takes the whole screen with when there are samplers with long name</li>
 <li><bugzilla>54629</bugzilla> - HTMLParser does not extract &lt;object&gt; tag urls</li>
 <li><bugzilla>55023</bugzilla> - SSL Context reuse feature (51380) adversely affects non-ssl request performance/throughput</li>
 <li><bugzilla>55092</bugzilla> - Log message "WARN - jmeter.protocol.http.sampler.HTTPSamplerBase: Null URL detected (should not happen)" displayed when embedded resource URL is malformed</li>
 </ul>
 
 <h3>Other Samplers</h3>
 <ul>
 <li><bugzilla>54913</bugzilla> - JMSPublisherGui incorrectly restore its state</li>
 <li><bugzilla>55027</bugzilla> - Test Action regression, duration value are not record (nightly build)</li>
 </ul>
 
 <h3>Controllers</h3>
 <ul>
 <li><bugzilla>54467</bugzilla> - Loop controller Controller check conditions each request</li>
 <li><bugzilla>54985</bugzilla> - Make Transaction Controller set Response Code of Generated Parent Sampler to response code of first failing child in case of failure of one of its children</li>
 </ul>
 
 <h3>Listeners</h3>
 <ul>
 <li><bugzilla>54589</bugzilla> - View Results Tree have a lot of Garbage characters if html page uses double-byte charset</li>
 <li><bugzilla>54753</bugzilla> - StringIndexOutOfBoundsException at SampleResult.getSampleLabel() if key_on_threadname=false when using Statistical mode</li>
 <li><bugzilla>54865</bugzilla> - ArrayIndexOutOfBoundsException if "sample_variable" is set in client but not server</li>
 </ul>
 
 <h3>Timers, Assertions, Config, Pre- &amp; Post-Processors</h3>
 <ul>
 <li><bugzilla>54540</bugzilla> - "HTML Parameter Mask" are not marked deprecated in the IHM</li>
 <li><bugzilla>54575</bugzilla> - CSS/JQuery Extractor : Choosing JODD Implementation always uses JSOUP</li>
 <li><bugzilla>54901</bugzilla> - Response Assertion GUI behaves weirdly</li>
 <li><bugzilla>54924</bugzilla> - XMLAssertion uses JMeter JVM file.encoding instead of response encoding and does not clean threadlocal variable</li>
 </ul>
 
 <h3>Functions</h3>
 <ul>
 </ul>
 
 <h3>I18N</h3>
 <ul>
 </ul>
 
 <h3>General</h3>
 <ul>
 <li><bugzilla>54504</bugzilla> - Resource string not found: [clipboard_node_read_error]</li>
 <li><bugzilla>54538</bugzilla> - GUI: context menu is too big</li>
 <li><bugzilla>54847</bugzilla> - Cut &amp; Paste is broken with tree multi-selection</li>
 <li><bugzilla>54870</bugzilla> - Tree D&amp;D may lost leaf nodes (affected nightly build)</li>
 <li><bugzilla>55056</bugzilla> - wasted work in Data.append()</li>
 <li><bugzilla>55129</bugzilla> -  Change Javadoc generation per CVE-2013-1571, VU#225657</li>
 </ul>
 
 <!-- =================== Improvements =================== -->
 
 <h2>Improvements</h2>
 
 <h3>HTTP Samplers</h3>
 <ul>
 <li>HTTP Request: Small user interaction improvements in Row parameter Detail Box</li>
 </ul>
 
 <h3>Other samplers</h3>
 <ul>
 <li><bugzilla>54788</bugzilla> - JMS Point-to-Point Sampler - GUI enhancements to increase readability and ease of use</li>
 <li><bugzilla>54798</bugzilla> - Using subject from EML-file for SMTP Sampler</li>
 <li><bugzilla>54759</bugzilla> - SSLPeerUnverifiedException using HTTPS , property documented</li>
 <li><bugzilla>54896</bugzilla> - JUnit sampler gives only “failed to create an instance of the class” message with constructor problems</li>
 <li><bugzilla>55084</bugzilla> - Add timeout support for JDBC Request</li>
 </ul>
 
 <h3>Controllers</h3>
 <ul>
 </ul>
 
 <h3>Listeners</h3>
 <ul>
 <li><bugzilla>54532</bugzilla> - Improve Response Time Graph Y axis scale with huge values or small values (&lt; 1000ms). Add a new field to define increment scale</li>
 <li><bugzilla>54576</bugzilla> - View Results Tree : Add a CSS/JQuery Tester</li>
 <li><bugzilla>54777</bugzilla> - Improve Performance of default ResultCollector</li>
 </ul>
 
 <h3>Timers, Assertions, Config, Pre- &amp; Post-Processors</h3>
 <ul>
 </ul>
 
 <h3>Functions</h3>
 <ul>
 <li><bugzilla>54991</bugzilla> - Add functions to encode/decode URL encoded chars (__urlencode and __urldecode)</li>
 </ul>
 
 <h3>I18N</h3>
 <ul>
 </ul>
 
 <h3>General</h3>
 <ul>
 <li><bugzilla>54584</bugzilla> - MongoDB plugin</li>
 <li><bugzilla>54669</bugzilla> - Add flag forcing non-GUI JVM to exit after test</li>
 <li><bugzilla>42428</bugzilla> - Workbench not saved with Test Plan</li>
 <li><bugzilla>54825</bugzilla> - Add shortcuts to move elements in the tree</li>
 <li><bugzilla>54834</bugzilla> - Improve Drag &amp; Drop in the jmeter tree</li>
 <li><bugzilla>54839</bugzilla> - Set the application name on Mac</li>
 <li><bugzilla>54841</bugzilla> - Correctly handle the quit shortcut on Mac Os (CMD-Q)</li>
 <li><bugzilla>54844</bugzilla> - Set the application icon on Mac Os</li>
 <li><bugzilla>54834</bugzilla> - Improve Drag &amp; Drop in the jmeter tree</li>
 <li><bugzilla>54864</bugzilla> - Enable multi selection drag &amp; drop in the tree without having to start dragging before releasing Shift or Control </li>
 <li><bugzilla>54945</bugzilla> - Add Shutdown Hook to enable trapping kill or CTRL+C signals</li>
 <li><bugzilla>54990</bugzilla> - Download large files avoiding outOfMemory</li>
+<li><bugzilla>55085</bugzilla> - UX Improvement : Ability to create New Test Plan from Templates</li>
 </ul>
 
 <h2>Non-functional changes</h2>
 <ul>
 <li>Updated to jsoup-1.7.2</li>
 <li><bugzilla>54776</bugzilla> - Update the dependency on Bouncy Castle to 1.48</li>
 <li>Updated to commons-logging 1.1.2 (from 1.1.1)</li>
 <li>Updated to HttpComponents Client 4.2.5 (from 4.2.3)</li>
 <li>Updated to HttpComponents Core 4.2.4 (from 4.2.3)</li>
 <li>Updated to commons-codec 1.8 (from 1.6)</li>
 <li>Updated to commons-io 2.4 (from 2.2)</li>
 <li>Updated to commons-net 3.2 (from 3.1)</li>
 <li>Updated to jdom-1.1.3 (from 1.1.2)</li>
 <li>Updated to jodd-lagarto and jodd-core 3.4.3 (from 3.4.1)</li>
 <li>Updated to junit 4.11 (from 4.10)</li>
 <li>Updated to slf4j-api 1.7.5 (from 1.7.2)</li>
 <li>Updated to xmlgraphics-commons 1.5 (from 1.3.1)</li>
 <li>Updated to xstream 1.4.4 (from 1.4.2)</li>
 <li><bugzilla>54912</bugzilla> - JMeterTreeListener should use constants</li>
 <li><bugzilla>55065</bugzilla> - Useless processing in Spline3.converge()</li>
 <li><bugzilla>55064</bugzilla> - Useless processing in ReportTreeListener.isValidDragAction()</li>
 <li><bugzilla>54903</bugzilla> - Remove the dependency on the Activation Framework</li>
 </ul>
 
 </section> 
 </body> 
 </document>
