diff --git a/bin/jmeter.properties b/bin/jmeter.properties
index a25d9c568..18f0f7910 100644
--- a/bin/jmeter.properties
+++ b/bin/jmeter.properties
@@ -1,580 +1,581 @@
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
 #language=de
 
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
 # 2.0 - original format
 # 2.1 - initial format using XStream
 # 2.2 - updated format using XStream, with shorter names
 
 # Note: JMeter 2.2 does not support file_format.testlog=2.1 - only 2.0 and 2.2
 
 #---------------------------------------------------------------------------
 # XML Parser
 #---------------------------------------------------------------------------
 
 # XML Reader(Parser) - Must implement SAX 2 specs
 xml.parser=org.apache.xerces.parsers.SAXParser
 
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
 
 #---------------------------------------------------------------------------
 # Look and Feel configuration
 #---------------------------------------------------------------------------
 
 #Classname of the Swing default UI
 #Installed Look and Feel classes on Windows are:
 # ?Metal ? = javax.swing.plaf.metal.MetalLookAndFeel
 # ?Motif ? = com.sun.java.swing.plaf.motif.MotifLookAndFeel
 # ?Windows = com.sun.java.swing.plaf.windows.WindowsLookAndFeel
 jmeter.laf=javax.swing.plaf.metal.MetalLookAndFeel
 
 # Icon definitions
 # default:
 #jmeter.icons=org/apache/jmeter/images/icon.properties
 # alternate:
 #jmeter.icons=org/apache/jmeter/images/icon_1.properties
 
 #Components to not display in JMeter GUI
 not_in_menu=org.apache.jmeter.protocol.http.control.Cookie,org.apache.jmeter.protocol.http.control.Authorization,org.apache.jmeter.config.LoginConfig,Header,org.apache.jmeter.protocol.http.config.MultipartUrlConfig
 
 #---------------------------------------------------------------------------
 # Remote hosts and RMI configuration
 #---------------------------------------------------------------------------
 
 # Remote Hosts - comma delimited
 remote_hosts=127.0.0.1
 #remote_hosts:localhost:1099,localhost:2010
 
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
 
 #---------------------------------------------------------------------------
 #         Logging Configuration
 #---------------------------------------------------------------------------
 
 # Note: JMeter uses Avalon LogKit
 
 # Logging Format
 # see http://avalon.apache.org/logkit/api/org/apache/log/format/PatternFormatter.html
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
 
 #---------------------------------------------------------------------------
 # HTTP Javat configuration
 #---------------------------------------------------------------------------
 
 # Number of connection retries performed by HTTP Java sampler before giving up
 #http.java.sampler.retries=10
 
 #---------------------------------------------------------------------------
 # HTTPClient configuration
 #---------------------------------------------------------------------------
 
 # define a properties file for overriding httpclient parameters
 # See: http://jakarta.apache.org/commons/httpclient/preference-api.html
 #httpclient.parameters.file=httpclient.parameters
 
 # set the socket timeout (or use the parameter http.socket.timeout)
 #httpclient.timeout=0
 
 # Set the http version (defaults to 1.1)
 #httpclient.version=1.0 (or use the parameter http.protocol.version)
 
 # Define characters per second > 0 to emulate slow connections
 #httpclient.socket.http.cps=0
 #httpclient.socket.https.cps=0
 
 # Define the local host address to be used for multi-homed hosts
 #httpclient.localaddress=1.2.3.4
 
 # Sample logging levels for HttpClient
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
 
 # Further logging configuration
 # Excalibur logging provides the facility to configure logging using
 # configuration files written in XML. This allows for such features as
 # log file rotation which are not supported directly by JMeter.
 #
 # If such a file specified, it will be applied to the current logging
 # hierarchy when that has been created.
 # 
 #log_config=logkit.xml
 
 # HttpClient Logging information can be found at:
 # http://jakarta.apache.org/commons/httpclient/logging.html
 
 #---------------------------------------------------------------------------
 # Results file configuration
 #---------------------------------------------------------------------------
 
 # This section helps determine how result data will be saved.
 # The commented out values are the defaults.
 
 # legitimate values: xml, csv, db.  Only xml and csv are currently supported.
 #jmeter.save.saveservice.output_format=xml
 
 
 # true when field should be saved; false otherwise
 
 # assertion_results_failure_message only affects CSV output
 #jmeter.save.saveservice.assertion_results_failure_message=false
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
 #jmeter.save.saveservice.thread_counts=false
+#jmeter.save.saveservice.sample_count=false
 
 # Timestamp format
 # legitimate values: none, ms, or a format suitable for SimpleDateFormat
 #jmeter.save.saveservice.timestamp_format=ms
 #jmeter.save.saveservice.timestamp_format=MM/dd/yy HH:mm:ss
 
 # Put the start time stamp in logs instead of the end
 sampleresult.timestamp.start=true
 
 
 # legitimate values: none, first, all
 #jmeter.save.saveservice.assertion_results=none
 
 # For use with Comma-separated value (CSV) files or other formats
 # where the fields' values are separated by specified delimiters.
 #jmeter.save.saveservice.default_delimiter=,
 #jmeter.save.saveservice.print_field_names=false
 
 # Optional xml processing instruction for line 2 of the file:
 #jmeter.save.saveservice.xml_pi=<?xml-stylesheet type="text/xsl" href="../extras/jmeter-results-detail-report_21.xsl"?>
 
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
 
 # Change the default HTTP Sampler
 # Java:
 #jmeter.httpsampler=HTTPSampler
 # Apache HTTPClient:
 #jmeter.httpsampler=HTTPSampler2
 
 # Default content-type include filter to use
 #proxy.content_type_include=text/html|text/plain|text/xml
 # Default content-type exclude filter to use
 #proxy.content_type_exclude=image/.*|text/css|application/.*
 
 #---------------------------------------------------------------------------
 # JMeter Proxy configuration
 #---------------------------------------------------------------------------
 # use command-line flags for user-name and password
 #http.proxyDomain=NTLM domain, if required by HTTPClient sampler
 
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
 
 # Remote batching support
 # default is Standard, which returns each sample
 # Hold retains samples until end of test (may need lots of memory)
 # Batch returns samples in batches
 # Statistical returns sample stats
 # hold_samples was originally defined as a separate property,
 # but can now also be defined using remote.mode
 #mode=Standard
 #mode=Batch
 #mode=Hold
 #mode=Statistical
 #hold_samples=true
 #num_sample_threshold=100
 #time_threshold=60000
 
 # To set the Monitor Health Visualiser buffer size, enter the desired value
 # monitor.buffer.size=800
 
 #---------------------------------------------------------------------------
 # TCP Sampler configuration
 #---------------------------------------------------------------------------
 
 # The default handler class
 #tcp.handler=TCPClientImpl
 #
 # eolByte = byte value for end of line
 #tcp.eolByte=0
 #
 # status.prefix and suffix = strings that enclose the status response code
 #tcp.status.prefix=Status=
 #tcp.status.suffix=.
 #
 # status.properties = property file to convert codes to messages
 #tcp.status.properties=mytestfiles/tcpstatus.properties
 
 #---------------------------------------------------------------------------
 # Summariser configuration (only applies to non-GUI mode)
 #---------------------------------------------------------------------------
 
 # Summariser settings
 #
 # Define the following property to automatically start a summariser with that name
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
 #beanshell.init.file=
 
 #
 # Define the intialisation files for BeanShell Sampler, Function and other BeanShell elements
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
 #time.YMDHMD=yyyyMMdd-HHmmss
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
 #mirror.server.port=8080
 
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
 
 # The encoding to be used if none is provided (default ISO-8859-1)
 #sampleresult.default.encoding=ISO-8859-1
 
 # CookieManager behaviour - should cookies with null/empty values be deleted?
 # Default is true. Use false to revert to original behaviour
 #CookieManager.delete_null_cookies=true
 
 # CookieManager behaviour - should variable cookies be allowed?
 # Default is true. Use false to revert to original behaviour
 #CookieManager.allow_variable_cookies=true
 
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
 
 
 # List of paths (separated by ;) to search for additional JMeter extension jars
 # These are in addition to lib/ext. Do not use this for utility jars.
 #search_paths=/app1/lib;/app2/lib
 
 # Users can define additional classpath items by setting the property below
 # Use the default separator for the host version of Java
 # Paths with spaces may cause problems for the JVM
 #user.classpath=../classes;../jars/jar1.jar
 
 #Should JMeter expand the tree when loading a test plan?
 #onload.expandtree=false
 
 # Should JMeter automatically load additional JMeter properties?
 # File name to look for (comment to disable)
 user.properties=user.properties
 
 # Should JMeter automatically load additional system properties?
 # File name to look for (comment to disable)
 system.properties=system.properties
\ No newline at end of file
diff --git a/src/core/org/apache/jmeter/resources/messages.properties b/src/core/org/apache/jmeter/resources/messages.properties
index 790bf6a24..935aecb37 100644
--- a/src/core/org/apache/jmeter/resources/messages.properties
+++ b/src/core/org/apache/jmeter/resources/messages.properties
@@ -1,849 +1,850 @@
 # Warning: JMeterUtils.getResString() replaces space with '_'
 # and converts keys to lowercase before lookup
 # => All keys in this file must also be lower case or they won't match
 #
 about=About Apache JMeter
 add=Add
 add_as_child=Add as Child
 add_parameter=Add Variable
 add_pattern=Add Pattern\:
 add_test=Add Test
 add_user=Add User
 add_value=Add Value
 addtest=Add test
 aggregate_graph=Statistical Graphs
 aggregate_graph_column=Column
 aggregate_graph_display=Display Graph
 aggregate_graph_height=Height
 aggregate_graph_max_length_xaxis_label=Max length of x-axis label
 aggregate_graph_ms=Milliseconds
 aggregate_graph_response_time=Response Time
 aggregate_graph_save=Save Graph
 aggregate_graph_save_table=Save Table Data
 aggregate_graph_title=Aggregate Graph
 aggregate_graph_user_title=Title for Graph
 aggregate_graph_width=Width
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
 als_message=Note\: The Access Log Parser is generic in design and allows you to plugin
 als_message2=your own parser. To do so, implement the LogParser, add the jar to the
 als_message3=/lib directory and enter the class in the sampler.
 analyze=Analyze Data File...
 anchor_modifier_title=HTML Link Parser
 appearance=Look and Feel
 argument_must_not_be_negative=The Argument must not be negative\!
 assertion_assume_success=Ignore Status
 assertion_code_resp=Response Code
 assertion_contains=Contains
 assertion_equals=Equals
 assertion_headers=Response Headers
 assertion_matches=Matches
 assertion_message_resp=Response Message
 assertion_not=Not
 assertion_pattern_match_rules=Pattern Matching Rules
 assertion_patterns_to_test=Patterns to Test
 assertion_resp_field=Response Field to Test
 assertion_text_resp=Text Response
 assertion_textarea_label=Assertions\:
 assertion_title=Response Assertion
 assertion_url_samp=URL Sampled
 assertion_visualizer_title=Assertion Results
 attribute=Attribute
 attrs=Attributes
 auth_base_url=Base URL
 auth_manager_title=HTTP Authorization Manager
 auths_stored=Authorizations Stored in the Authorization Manager
 average=Average
 average_bytes=Avg. Bytes
 bind=Thread Bind
 browse=Browse...
 bsf_sampler_title=BSF Sampler
 bsf_script=Script to run
 bsf_script_file=Script file to run
 bsf_script_language=Scripting language\:
 bsf_script_parameters=Parameters to pass to script/file\:
 bsh_assertion_script=Script (see below for variables that are defined)
 bsh_assertion_script_variables=The following variables are defined for the script:\nRead/Write: Failure, FailureMessage, SampleResult, vars, log.\nReadOnly: Response[Data|Code|Message|Headers], RequestHeaders, SampleLabel, SamplerData, ctx
 bsh_assertion_title=BeanShell Assertion
 bsh_function_expression=Expression to evaluate
 bsh_sampler_title=BeanShell Sampler
 bsh_script=Script (see below for variables that are defined)
 bsh_script_variables=The following variables are defined for the script:\nSampleResult, ResponseCode, ResponseMessage, IsSuccess, Label, FileName, ctx, vars, log
 bsh_script_file=Script file
 bsh_script_parameters=Parameters (-> String Parameters and String []bsh.args)
 busy_testing=I'm busy testing, please stop the test before changing settings
 cache_session_id=Cache Session Id?
 cancel=Cancel
 cancel_revert_project=There are test items that have not been saved.  Do you wish to revert to the previously saved test plan?
 cancel_exit_to_save=There are test items that have not been saved.  Do you wish to save before exiting?
 cancel_new_to_save=There are test items that have not been saved.  Do you wish to save before clearing the test plan?
 choose_function=Choose a function
 choose_language=Choose Language
 clear=Clear
 clear_all=Clear All
 clear_cookies_per_iter=Clear cookies each iteration?
 column_delete_disallowed=Deleting this column is not permitted
 column_number=Column number of CSV file | next | *alias
 compare=Compare
 comparefilt=Compare filter
 config_element=Config Element
 config_save_settings=Configure
 configure_wsdl=Configure
 constant_throughput_timer_memo=Add a delay between sampling to attain constant throughput
 constant_timer_delay=Thread Delay (in milliseconds)\:
 constant_timer_memo=Add a constant delay between sampling
 constant_timer_title=Constant Timer
 content_encoding=Content encoding\:
 controller=Controller
 cookie_manager_policy=Cookie Policy
 cookie_manager_title=HTTP Cookie Manager
 cookies_stored=Cookies Stored in the Cookie Manager
 copy=Copy
 corba_config_title=CORBA Sampler Config
 corba_input_data_file=Input Data File\:
 corba_methods=Choose method to invoke\:
 corba_name_server=Name Server\:
 corba_port=Port Number\:
 corba_request_data=Input Data
 corba_sample_title=CORBA Sampler
 counter_config_title=Counter
 counter_per_user=Track counter independently for each user
 countlim=Size limit
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
 delete=Delete
 delete_parameter=Delete Variable
 delete_test=Delete Test
 delete_user=Delete User
 deltest=Deletion test
 deref=Dereference aliases
 disable=Disable
 distribution_graph_title=Distribution Graph (alpha)
 distribution_note1=The graph will update every 10 samples
 dn=DN
 domain=Domain
 done=Done
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
 error_loading_help=Error loading help page
 error_occurred=Error Occurred
 error_title=Error
 es=Spanish
 example_data=Sample Data
 example_title=Example Sampler
 exit=Exit
 expiration=Expiration
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
 file_visualizer_output_file=Write All Data to a File
 file_visualizer_submit_data=Include Submitted Data
 file_visualizer_title=File Reporter
 file_visualizer_verbose=Verbose Output
 filename=File Name
 follow_redirects=Follow Redirects
 follow_redirects_auto=Redirect Automatically
 foreach_controller_title=ForEach Controller
 foreach_input=Input variable prefix
 foreach_output=Output variable name
 foreach_use_separator=Add "_" before number ?
 format=Number format
 fr=French
 ftp_binary_mode=Use Binary mode ?
 ftp_get=get(RETR)
 ftp_local_file=Local File:
 ftp_remote_file=Remote File:
 ftp_sample_title=FTP Request Defaults
 ftp_save_response_data=Save File in Response ?
 ftp_testing_title=FTP Request
 ftp_put=put(STOR)
 function_dialog_menu_item=Function Helper Dialog
 function_helper_title=Function Helper
 function_name_param=Name of variable in which to store the result
 function_name_paropt=Name of variable in which to store the result (optional)
 function_params=Function Parameters
 functional_mode=Functional Test Mode
 functional_mode_explanation=Select functional test mode only if you need \nto record to file the data received from the server for each request.  \n\nSelecting this option impacts performance considerably.
 gaussian_timer_delay=Constant Delay Offset (in milliseconds)\:
 gaussian_timer_memo=Adds a random delay with a gaussian distribution
 gaussian_timer_range=Deviation (in milliseconds)\:
 gaussian_timer_title=Gaussian Random Timer
 generate=Generate
 generator=Name of Generator class
 generator_cnf_msg=Could not find the generator class. Please make sure you place your jar file in the /lib directory.
 generator_illegal_msg=Could not access the generator class due to IllegalAcessException.
 generator_instantiate_msg=Could not create an instance of the generator parser. Please make sure the generator implements Generator interface.
 get_xml_from_file=File with SOAP XML Data (overrides above text)
 get_xml_from_random=Message Folder
 get_xml_message=Note\: Parsing XML is CPU intensive. Therefore, do not set the thread count
 get_xml_message2=too high. In general, 10 threads will consume 100% of the CPU on a 900mhz
 get_xml_message3=Pentium 3. On a pentium 4 2.4ghz cpu, 50 threads is the upper limit. Your
 get_xml_message4=options for increasing the number of clients is to increase the number of
 get_xml_message5=machines or use multi-cpu systems.
 graph_choose_graphs=Graphs to Display
 graph_full_results_title=Graph Full Results
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
 grouping_mode=Grouping\:
 grouping_no_groups=Do not group samplers
 grouping_store_first_only=Store 1st sampler of each group only
 header_manager_title=HTTP Header Manager
 headers_stored=Headers Stored in the Header Manager
 help=Help
 help_node=What's this node?
 html_assertion_label=HTML Assertion
 html_assertion_title=HTML Assertion
 html_parameter_mask=HTML Parameter Mask
 http_implementation=HTTP Implementation:
 http_response_code=HTTP response code
 http_url_rewriting_modifier_title=HTTP URL Re-writing Modifier
 http_user_parameter_modifier=HTTP User Parameter Modifier
 httpmirror_title=HTTP Mirror Server
 id_prefix=ID Prefix
 id_suffix=ID Suffix
 if_controller_evaluate_all=Evaluate for all children?
 if_controller_label=Condition (Javascript)
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
 jar_file=Jar Files
 java_request=Java Request
 java_request_defaults=Java Request Defaults
 javascript_expression=JavaScript expression to evaluate
 jexl_expression=JEXL expression to evaluate
 jms_auth_not_required=Not Required
 jms_auth_required=Required
 jms_authentication=Authentication
 jms_client_caption=Receive client uses TopicSubscriber.receive() to listen for message.
 jms_client_caption2=MessageListener uses onMessage(Message) interface to listen for new messages.
 jms_client_type=Client
 jms_communication_style=Communication style
 jms_concrete_connection_factory=Concrete Connection Factory
 jms_config=Configuration
 jms_config_title=JMS Configuration
 jms_connection_factory=Connection Factory
 jms_error_msg=Object message should read from an external file. Text input is currently selected, please remember to change it.
 jms_file=File
 jms_initial_context_factory=Initial Context Factory
 jms_itertions=Number of samples to aggregate
 jms_jndi_defaults_title=JNDI Default Configuration
 jms_jndi_props=JNDI Properties
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
 jms_random_file=Random File
 jms_read_response=Read Response
 jms_receive_queue=JNDI name Receive queue
 jms_request=Request Only
 jms_requestreply=Request Response
 jms_sample_title= JMS Default Request
 jms_send_queue=JNDI name Request queue
 jms_subscriber_on_message=Use MessageListener.onMessage()
 jms_subscriber_receive=Use TopicSubscriber.receive()
 jms_subscriber_title=JMS Subscriber
 jms_testing_title= Messaging Request
 jms_text_message=Text Message
 jms_timeout=Timeout (milliseconds)
 jms_topic=Topic
 jms_use_file=From file
 jms_use_non_persistent_delivery=Use non-persistent delivery mode?
 jms_use_properties_file=Use jndi.properties file
 jms_use_random_file=Random File
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
 jp=Japanese
 junit_append_error=Append assertion errors
 junit_append_exception=Append runtime exceptions
 junit_constructor_error=Unable to create an instance of the class
 junit_constructor_string=Constructor String Label
 junit_do_setup_teardown=Do not call setUp and tearDown
 junit_error_code=Error Code
 junit_error_default_code=9999
 junit_error_default_msg=An unexpected error occured
 junit_error_msg=Error Message
 junit_failure_code=Failure Code
 junit_failure_default_code=0001
 junit_failure_default_msg=Test failed
 junit_failure_msg=Failure Message
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
 ldapext_testing_title= LDAP Extended Request
 load=Load
 load_wsdl=Load WSDL
 log_errors_only=Log Errors Only
 log_file=Location of log File
 log_parser=Name of Log Parser class
 log_parser_cnf_msg=Could not find the class. Please make sure you place your jar file in the /lib directory.
 log_parser_illegal_msg=Could not access the class due to IllegalAcessException.
 log_parser_instantiate_msg=Could not create an instance of the log parser. Please make sure the parser implements LogParser interface.
 log_sampler=Tomcat Access Log Sampler
 logic_controller_title=Simple Controller
 login_config=Login Configuration
 login_config_element=Login Config Element
 loop_controller_title=Loop Controller
 looping_control=Looping Control
 lower_bound=Lower Bound
 mail_reader_account=Username:
 mail_reader_all_messages=All
 mail_reader_delete=Delete messages from the server
 mail_reader_folder=Folder:
 mail_reader_imap=IMAP
 mail_reader_num_messages=Number of messages to retrieve:
 mail_reader_password=Password:
 mail_reader_pop3=POP3
 mail_reader_server=Server:
 mail_reader_server_type=Server Type:
 mail_reader_title=Mail Reader Sampler
 mail_sent=Mail sent successfully
 mailer_attributes_panel=Mailing attributes
 mailer_error=Couldn't send mail. Please correct any misentries.
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
 menu_config_element=Config Element
 menu_edit=Edit
 menu_generative_controller=Sampler
 menu_listener=Listener
 menu_logic_controller=Logic Controller
 menu_merge=Merge
 menu_modifiers=Modifiers
 menu_non_test_elements=Non-Test Elements
 menu_open=Open
 menu_post_processors=Post Processors
 menu_pre_processors=Pre Processors
 menu_response_based_modifiers=Response Based Modifiers
 menu_timer=Timer
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
 module_controller_title=Module Controller
 module_controller_warning=Could not find module: 
 module_controller_module_to_run=Module To Run 
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
 port=Port\:
 property_as_field_label={0}\:
 property_default_param=Default value
 property_edit=Edit
 property_editor.value_is_invalid_message=The text you just entered is not a valid value for this property.\nThe property will be reverted to its previous value.
 property_editor.value_is_invalid_title=Invalid input
 property_name_param=Name of property
 property_returnvalue_param=Return Original Value of property (default false) ?
 property_tool_tip={0}\: {1}
 property_undefined=Undefined
 property_value_param=Value of property
 protocol=Protocol (default http)\:
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
 proxy_headers=Capture HTTP Headers
 proxy_httpsspoofing=Attempt https Spoofing
 proxy_regex=Regex matching
 proxy_sampler_settings=HTTP Sampler settings
 proxy_sampler_type=Type\:
 proxy_separators=Add Separators
 proxy_target=Target Controller\:
 proxy_test_plan_content=Test plan content
 proxy_title=HTTP Proxy Server
 ramp_up=Ramp-Up Period (in seconds)\:
 random_control_title=Random Controller
 random_order_control_title=Random Order Controller
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
 regex_source=Response Field to check
 regex_src_body=Body
 regex_src_hdrs=Headers
 regex_src_url=URL
 regexfunc_param_1=Regular expression used to search results from previous request
 regexfunc_param_2=Template for the replacement string, using groups from the regular expression.  Format is $[group]$.  Example $1$.
 regexfunc_param_3=Which match to use.  An integer 1 or greater, RAND to indicate JMeter should randomly choose, A float, or ALL indicating all matches should be used
 regexfunc_param_4=Between text.  If ALL is selected, the between text will be used to generate the results
 regexfunc_param_5=Default text.  Used instead of the template if the regular expression finds no matches
 remote_error_init=Error initialising remote server
 remote_error_starting=Error starting remote server
 remote_exit=Remote Exit
 remote_exit_all=Remote Exit All
 remote_start=Remote Start
 remote_start_all=Remote Start All
 remote_stop=Remote Stop
 remote_stop_all=Remote Stop All
 remove=Remove
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
 restart=Restart
 resultaction_title=Result Status Action Handler
 resultsaver_errors=Save Failed Responses only
 resultsaver_prefix=Filename prefix\:
 resultsaver_title=Save Responses to a file
 retobj=Return object
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
 sampler_label=Label
 sampler_on_error_action=Action to be taken after a Sampler error
 sampler_on_error_continue=Continue
 sampler_on_error_stop_test=Stop Test
 sampler_on_error_stop_thread=Stop Thread
 save=Save
 save?=Save?
 save_all_as=Save Test Plan as
 save_as=Save As...
 save_as_image=Save Node As Image
 save_as_image_all=Save Screen As Image
 save_assertionresultsfailuremessage=Save Assertion Results Failure Message
 save_assertions=Save Assertion Results
 save_asxml=Save As XML
 save_bytes=Save byte count
 save_code=Save Response Code
 save_datatype=Save Data Type
 save_encoding=Save Encoding
 save_fieldnames=Save Field Names
 save_filename=Save Response Filename
 save_graphics=Save Graph
 save_label=Save Label
 save_latency=Save Latency
 save_message=Save Response Message
 save_overwrite_existing_file=The selected file already exists, do you want to overwrite it?
 save_requestheaders=Save Request Headers
 save_responsedata=Save Response Data
 save_responseheaders=Save Response Headers
 save_samplerdata=Save Sampler Data
 save_subresults=Save Sub Results
 save_success=Save Success
+save_samplecount=Save Sample Count
 save_threadcounts=Save Active Thread Counts
 save_threadname=Save Thread Name
 save_time=Save Elapsed Time
 save_timestamp=Save Time Stamp
 save_url=Save URL
 sbind=Single bind/unbind
 scheduler=Scheduler
 scheduler_configuration=Scheduler Configuration
 scope=Scope
 search_base=Search base
 search_filter=Search Filter
 search_test=Search Test
 searchbase=Search base
 searchfilter=Search Filter
 searchtest=Search test
 second=second
 secure=Secure
 send_file=Send a File With the Request\:
 send_file_browse=Browse...
 send_file_filename_label=Filename\:
 send_file_mime_label=MIME Type\:
 send_file_param_name_label=Value for "name" attribute\:
 server=Server Name or IP\:
 servername=Servername \:
 session_argument_name=Session Argument Name
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
 soap_action=Soap Action
 soap_data_title=Soap/XML-RPC Data
 soap_sampler_title=SOAP/XML-RPC Request
 soap_send_action=Send SOAPAction: 
 spline_visualizer_average=Average
 spline_visualizer_incoming=Incoming
 spline_visualizer_maximum=Maximum
 spline_visualizer_minimum=Minimum
 spline_visualizer_title=Spline Visualizer
 spline_visualizer_waitingmessage=Waiting for samples
 ssl_alias_prompt=Please type your preferred alias
 ssl_alias_select=Select your alias for the test
 ssl_alias_title=Client Alias
 ssl_error_title=Key Store Problem
 ssl_pass_prompt=Please type your password
 ssl_pass_title=KeyStore Password
 ssl_port=SSL Port
 sslmanager=SSL Manager
 start=Start
 starttime=Start Time
 stop=Stop
 stopping_test=Shutting down all test threads.  Please be patient.
 stopping_test_title=Stopping Test
 string_from_file_file_name=Enter full path to file
 string_from_file_seq_final=Final file sequence number
 string_from_file_seq_start=Start file sequence number
 summariser_title=Generate Summary Results
 summary_report=Summary Report
 switch_controller_label=Switch Value
 switch_controller_title=Switch Controller
 table_visualizer_bytes=Bytes
 table_visualizer_sample_num=Sample #
 table_visualizer_sample_time=Sample Time(ms)
 table_visualizer_start_time=Start Time
 table_visualizer_status=Status
 table_visualizer_success=Success
 table_visualizer_thread_name=Thread Name
 table_visualizer_warning=Warning
 tcp_config_title=TCP Sampler Config
 tcp_nodelay=Set NoDelay
 tcp_port=Port Number\:
 tcp_request_data=Text to send
 tcp_sample_title=TCP Sampler
 tcp_timeout=Timeout (milliseconds)\:
 template_field=Template\:
 test=Test
 test_action_action=Action
 test_action_duration=Duration
 test_action_pause=Pause
 test_action_stop=Stop
 test_action_target=Target
 test_action_target_test=All Threads
 test_action_target_thread=Current Thread
 test_action_title=Test Action
 test_configuration=Test Configuration
 test_plan=Test Plan
 test_plan_classpath_browse=Add directory or jar to classpath
 testconfiguration=Test Configuration
 testplan.serialized=Run each Thread Group separately (i.e. run one group before starting the next)
 testplan_comments=Comments\:
 testt=Test
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
 transaction_controller_parent=Generate parent sample
 transaction_controller_title=Transaction Controller
 unbind=Thread Unbind
 uniform_timer_delay=Constant Delay Offset (in milliseconds)\:
 uniform_timer_memo=Adds a random delay with a uniform distribution
 uniform_timer_range=Random Delay Maximum (in milliseconds)\:
 uniform_timer_title=Uniform Random Timer
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
 use_keepalive=Use KeepAlive
 use_multipart_for_http_post=Use multipart/form-data for HTTP POST
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
 var_name=Reference Name
 variable_name_param=Name of variable (may include variable and function references)
 view_graph_tree_title=View Graph Tree
 view_results_in_table=View Results in Table
 view_results_tab_request=Request
 view_results_tab_response=Response data
 view_results_tab_sampler=Sampler result
 view_results_tab_assertion=Assertion result
 view_results_title=View Results
 view_results_tree_title=View Results Tree
 warning=Warning!
 web_request=HTTP Request
 web_server=Web Server
 web_server_domain=Server Name or IP\:
 web_server_port=Port Number\:
 web_testing_embedded_url_pattern=Embedded URLs must match\:
 web_testing_retrieve_images=Retrieve All Embedded Resources from HTML Files
 web_testing_title=HTTP Request
 web_testing2_title=HTTP Request HTTPClient
 webservice_proxy_host=Proxy Host
 webservice_proxy_note=If Use HTTP Proxy is checked, but no host or port are provided, the sampler
 webservice_proxy_note2=will look at command line options. If no proxy host or port are provided by
 webservice_proxy_note3=either, it will fail silently.
 webservice_proxy_port=Proxy Port
 webservice_sampler_title=WebService(SOAP) Request
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
 xml_namespace_button=Use Namespaces
 xml_tolerant_button=Tolerant XML/HTML Parser
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
 xpath_extractor_namespace=Use Namespaces?
 xpath_extractor_query=XPath query:
 xpath_extractor_title=XPath Extractor
 xpath_extractor_tolerant=Use Tidy ?
 xpath_file_file_name=XML file to get values from 
 you_must_enter_a_valid_number=You must enter a valid number
 zh_cn=Chinese (Simplified)
 zh_tw=Chinese (Traditional)
 # Please add new entries in alphabetical order
diff --git a/src/core/org/apache/jmeter/samplers/SampleSaveConfiguration.java b/src/core/org/apache/jmeter/samplers/SampleSaveConfiguration.java
index 19566b870..abd9cb177 100644
--- a/src/core/org/apache/jmeter/samplers/SampleSaveConfiguration.java
+++ b/src/core/org/apache/jmeter/samplers/SampleSaveConfiguration.java
@@ -1,730 +1,749 @@
 /*
  * Licensed to the Apache Software Foundation (ASF) under one or more
  * contributor license agreements.  See the NOTICE file distributed with
  * this work for additional information regarding copyright ownership.
  * The ASF licenses this file to You under the Apache License, Version 2.0
  * (the "License"); you may not use this file except in compliance with
  * the License.  You may obtain a copy of the License at
  * 
  * http://www.apache.org/licenses/LICENSE-2.0
  * 
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  * License for the specific language governing permissions and limitations
  * under the License.
  *  
  */
 
 /*
  * Created on Sep 7, 2004
  */
 package org.apache.jmeter.samplers;
 
 import java.io.ObjectStreamException;
 import java.io.Serializable;
 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
 import java.util.Properties;
 
 import org.apache.jmeter.testelement.TestPlan;
 import org.apache.jmeter.util.JMeterUtils;
 
 /*
  * N.B. to add a new field, remember the following
  * - static _xyz
  * - instance xyz=_xyz
  * - clone s.xyz = xyz
  * - setXyz(boolean)
  * - saveXyz()
- * - update SampleSaveConfigurationConverter to add new field
+ * - update SampleSaveConfigurationConverter to add new fields to marshall() and shouldSerialiseMember()
  * - update SampleResultConverter and/or HTTPSampleConverter
  * - update CSV routines in OldSaveService
  * - update messages.properties to add save_xyz entry
  * 
  */
 /**
  * Holds details of which sample attributes to save.
  * 
  * The pop-up dialogue for this is created by the class SavePropertyDialog, which assumes:
  * For each field XXX
  * - methods have the signature "boolean saveXXX()" 
  * - a corresponding "void setXXX(boolean)" method
  * - messages.properties contains the key save_XXX
  * 
  * @author mstover
  *
  */
 public class SampleSaveConfiguration implements Cloneable, Serializable {
-	private static final long serialVersionUID = 5;
+	private static final long serialVersionUID = 6L;
 
 	// ---------------------------------------------------------------------
 	// PROPERTY FILE CONSTANTS
 	// ---------------------------------------------------------------------
 
 	/** Indicates that the results file should be in XML format. * */
 	private static final String XML = "xml"; // $NON_NLS-1$
 
 	/** Indicates that the results file should be in CSV format. * */
 	//NOTUSED private static final String CSV = "csv"; // $NON_NLS-1$
 
 	/** Indicates that the results should be stored in a database. * */
 	//NOTUSED private static final String DATABASE = "db"; // $NON_NLS-1$
 
 	/** A properties file indicator for true. * */
 	private static final String TRUE = "true"; // $NON_NLS-1$
 
 	/** A properties file indicator for false. * */
 	private static final String FALSE = "false"; // $NON_NLS-1$
 
 	/** A properties file indicator for milliseconds. * */
 	private static final String MILLISECONDS = "ms"; // $NON_NLS-1$
 
 	/** A properties file indicator for none. * */
 	private static final String NONE = "none"; // $NON_NLS-1$
 
 	/** A properties file indicator for the first of a series. * */
 	private static final String FIRST = "first"; // $NON_NLS-1$
 
 	/** A properties file indicator for all of a series. * */
 	private static final String ALL = "all"; // $NON_NLS-1$
 
 	/***************************************************************************
 	 * The name of the property indicating which assertion results should be
 	 * saved.
 	 **************************************************************************/
 	private static final String ASSERTION_RESULTS_FAILURE_MESSAGE_PROP = 
         "jmeter.save.saveservice.assertion_results_failure_message";  // $NON_NLS-1$
 
 	/***************************************************************************
 	 * The name of the property indicating which assertion results should be
 	 * saved.
 	 **************************************************************************/
 	private static final String ASSERTION_RESULTS_PROP = "jmeter.save.saveservice.assertion_results"; // $NON_NLS-1$
 
 	/***************************************************************************
 	 * The name of the property indicating which delimiter should be used when
 	 * saving in a delimited values format.
 	 **************************************************************************/
 	private static final String DEFAULT_DELIMITER_PROP = "jmeter.save.saveservice.default_delimiter"; // $NON_NLS-1$
 
 	/***************************************************************************
 	 * The name of the property indicating which format should be used when
 	 * saving the results, e.g., xml or csv.
 	 **************************************************************************/
 	private static final String OUTPUT_FORMAT_PROP = "jmeter.save.saveservice.output_format"; // $NON_NLS-1$
 
 	/***************************************************************************
 	 * The name of the property indicating whether field names should be printed
 	 * to a delimited file.
 	 **************************************************************************/
 	private static final String PRINT_FIELD_NAMES_PROP = "jmeter.save.saveservice.print_field_names"; // $NON_NLS-1$
 
 	/***************************************************************************
 	 * The name of the property indicating whether the data type should be
 	 * saved.
 	 **************************************************************************/
 	private static final String SAVE_DATA_TYPE_PROP = "jmeter.save.saveservice.data_type"; // $NON_NLS-1$
 
 	/***************************************************************************
 	 * The name of the property indicating whether the label should be saved.
 	 **************************************************************************/
 	private static final String SAVE_LABEL_PROP = "jmeter.save.saveservice.label"; // $NON_NLS-1$
 
 	/***************************************************************************
 	 * The name of the property indicating whether the response code should be
 	 * saved.
 	 **************************************************************************/
 	private static final String SAVE_RESPONSE_CODE_PROP = "jmeter.save.saveservice.response_code"; // $NON_NLS-1$
 
 	/***************************************************************************
 	 * The name of the property indicating whether the response data should be
 	 * saved.
 	 **************************************************************************/
 	private static final String SAVE_RESPONSE_DATA_PROP = "jmeter.save.saveservice.response_data"; // $NON_NLS-1$
 
 	private static final String SAVE_RESPONSE_DATA_ON_ERROR_PROP = "jmeter.save.saveservice.response_data.on_error"; // $NON_NLS-1$
 
 	/***************************************************************************
 	 * The name of the property indicating whether the response message should
 	 * be saved.
 	 **************************************************************************/
 	private static final String SAVE_RESPONSE_MESSAGE_PROP = "jmeter.save.saveservice.response_message"; // $NON_NLS-1$
 
 	/***************************************************************************
 	 * The name of the property indicating whether the success indicator should
 	 * be saved.
 	 **************************************************************************/
 	private static final String SAVE_SUCCESSFUL_PROP = "jmeter.save.saveservice.successful"; // $NON_NLS-1$
 
 	/***************************************************************************
 	 * The name of the property indicating whether the thread name should be
 	 * saved.
 	 **************************************************************************/
 	private static final String SAVE_THREAD_NAME_PROP = "jmeter.save.saveservice.thread_name"; // $NON_NLS-1$
 
 	// Save bytes read
 	private static final String SAVE_BYTES_PROP = "jmeter.save.saveservice.bytes"; // $NON_NLS-1$
 
 	// Save URL
 	private static final String SAVE_URL_PROP = "jmeter.save.saveservice.url"; // $NON_NLS-1$
 
 	// Save fileName for ResultSaver
 	private static final String SAVE_FILENAME_PROP = "jmeter.save.saveservice.filename"; // $NON_NLS-1$
 
 	/***************************************************************************
 	 * The name of the property indicating whether the time should be saved.
 	 **************************************************************************/
 	private static final String SAVE_TIME_PROP = "jmeter.save.saveservice.time"; // $NON_NLS-1$
 
 	/***************************************************************************
 	 * The name of the property giving the format of the time stamp
 	 **************************************************************************/
 	private static final String TIME_STAMP_FORMAT_PROP = "jmeter.save.saveservice.timestamp_format"; // $NON_NLS-1$
 
     private static final String SUBRESULTS_PROP      = "jmeter.save.saveservice.subresults"; // $NON_NLS-1$
     private static final String ASSERTIONS_PROP      = "jmeter.save.saveservice.assertions"; // $NON_NLS-1$
     private static final String LATENCY_PROP         = "jmeter.save.saveservice.latency"; // $NON_NLS-1$
     private static final String SAMPLERDATA_PROP     = "jmeter.save.saveservice.samplerData"; // $NON_NLS-1$
     private static final String RESPONSEHEADERS_PROP = "jmeter.save.saveservice.responseHeaders"; // $NON_NLS-1$
     private static final String REQUESTHEADERS_PROP  = "jmeter.save.saveservice.requestHeaders"; // $NON_NLS-1$
     private static final String ENCODING_PROP        = "jmeter.save.saveservice.encoding"; // $NON_NLS-1$
     
 
     // optional processing instruction for line 2; e.g.
     // <?xml-stylesheet type="text/xsl" href="../extras/jmeter-results-detail-report_21.xsl"?>
     private static final String XML_PI               = "jmeter.save.saveservice.xml_pi"; // $NON_NLS-1$
 
     private static final String SAVE_THREAD_COUNTS = "jmeter.save.saveservice.thread_counts"; // $NON_NLS-1$
 
+    private static final String SAVE_SAMPLE_COUNT = "jmeter.save.saveservice.sample_count"; // $NON_NLS-1$
+
     // N.B. Remember to update the equals and hashCode methods when adding new variables.
     
 	// Initialise values from properties
 	private boolean time = _time, latency = _latency, timestamp = _timestamp, success = _success, label = _label,
 			code = _code, message = _message, threadName = _threadName, dataType = _dataType, encoding = _encoding,
 			assertions = _assertions, subresults = _subresults, responseData = _responseData,
 			samplerData = _samplerData, xml = _xml, fieldNames = _fieldNames, responseHeaders = _responseHeaders,
 			requestHeaders = _requestHeaders, responseDataOnError = _responseDataOnError;
 
 	private boolean saveAssertionResultsFailureMessage = _saveAssertionResultsFailureMessage;
 
 	private boolean url = _url, bytes = _bytes , fileName = _fileName;
 	
     private boolean threadCounts = _threadCounts;
+
+    private boolean sampleCount = _sampleCount;
     
     // Does not appear to be used (yet)
 	private int assertionsResultsToSave = _assertionsResultsToSave;
 
 
 	// Don't save this, as it is derived from the time format
 	private boolean printMilliseconds = _printMilliseconds;
 
 	/** A formatter for the time stamp. */
 	private transient DateFormat formatter = _formatter;
     /* Make transient as we don't want to save the SimpleDataFormat class
      * Also, there's currently no way to change the value via the GUI, so changing it
      * later means editting the JMX, or recreating the Listener.
      */
 
 	// Defaults from properties:
 	private static final boolean _time, _timestamp, _success, _label, _code, _message, _threadName, _xml,
 			_responseData, _dataType, _encoding, _assertions, _latency, _subresults, _samplerData, _fieldNames,
 			_responseHeaders, _requestHeaders;
 
 	private static final boolean _responseDataOnError;
 
 	private static final boolean _saveAssertionResultsFailureMessage;
 
 	private static final String _timeStampFormat;
 
 	private static int _assertionsResultsToSave;
 
 	// TODO turn into method?
 	public static final int SAVE_NO_ASSERTIONS = 0;
 
 	public static final int SAVE_FIRST_ASSERTION = SAVE_NO_ASSERTIONS + 1;
 
 	public static final int SAVE_ALL_ASSERTIONS = SAVE_FIRST_ASSERTION + 1;
 
 	private static final boolean _printMilliseconds;
 
 	private static final boolean _bytes;
 
 	private static final boolean _url;
 	
 	private static final boolean _fileName;
 
     private static final boolean _threadCounts;
     
+    private static final boolean _sampleCount;
+    
 	private static final DateFormat _formatter;
 
 	/**
 	 * The string used to separate fields when stored to disk, for example, the
 	 * comma for CSV files.
 	 */
 	private static final String _delimiter;
 
 	private static final String DEFAULT_DELIMITER = ","; // $NON_NLS-1$
 
 	/**
 	 * Read in the properties having to do with saving from a properties file.
 	 */
 	static {
 		Properties props = JMeterUtils.getJMeterProperties();
 
         _subresults      = TRUE.equalsIgnoreCase(props.getProperty(SUBRESULTS_PROP, TRUE));
         _assertions      = TRUE.equalsIgnoreCase(props.getProperty(ASSERTIONS_PROP, TRUE));
         _latency         = TRUE.equalsIgnoreCase(props.getProperty(LATENCY_PROP, TRUE));
         _samplerData     = TRUE.equalsIgnoreCase(props.getProperty(SAMPLERDATA_PROP, FALSE));
         _responseHeaders = TRUE.equalsIgnoreCase(props.getProperty(RESPONSEHEADERS_PROP, FALSE));
         _requestHeaders  = TRUE.equalsIgnoreCase(props.getProperty(REQUESTHEADERS_PROP, FALSE));
         _encoding        = TRUE.equalsIgnoreCase(props.getProperty(ENCODING_PROP, FALSE));
 
 		_delimiter = props.getProperty(DEFAULT_DELIMITER_PROP, DEFAULT_DELIMITER);
 
 		_fieldNames = TRUE.equalsIgnoreCase(props.getProperty(PRINT_FIELD_NAMES_PROP, FALSE));
 
 		_dataType = TRUE.equalsIgnoreCase(props.getProperty(SAVE_DATA_TYPE_PROP, TRUE));
 
 		_label = TRUE.equalsIgnoreCase(props.getProperty(SAVE_LABEL_PROP, TRUE));
 
 		_code = TRUE.equalsIgnoreCase(props.getProperty(SAVE_RESPONSE_CODE_PROP, TRUE));
 
 		_responseData = TRUE.equalsIgnoreCase(props.getProperty(SAVE_RESPONSE_DATA_PROP, FALSE));
 
 		_responseDataOnError = TRUE.equalsIgnoreCase(props.getProperty(SAVE_RESPONSE_DATA_ON_ERROR_PROP, FALSE));
 
 		_message = TRUE.equalsIgnoreCase(props.getProperty(SAVE_RESPONSE_MESSAGE_PROP, TRUE));
 
 		_success = TRUE.equalsIgnoreCase(props.getProperty(SAVE_SUCCESSFUL_PROP, TRUE));
 
 		_threadName = TRUE.equalsIgnoreCase(props.getProperty(SAVE_THREAD_NAME_PROP, TRUE));
 
 		_bytes = TRUE.equalsIgnoreCase(props.getProperty(SAVE_BYTES_PROP, TRUE));
 		
 		_url = TRUE.equalsIgnoreCase(props.getProperty(SAVE_URL_PROP, FALSE));
 
 		_fileName = TRUE.equalsIgnoreCase(props.getProperty(SAVE_FILENAME_PROP, FALSE));
 
 		_time = TRUE.equalsIgnoreCase(props.getProperty(SAVE_TIME_PROP, TRUE));
 
 		_timeStampFormat = props.getProperty(TIME_STAMP_FORMAT_PROP, MILLISECONDS);
 
 		_printMilliseconds = MILLISECONDS.equalsIgnoreCase(_timeStampFormat);
 
 		// Prepare for a pretty date
 		if (!_printMilliseconds && !NONE.equalsIgnoreCase(_timeStampFormat) && (_timeStampFormat != null)) {
 			_formatter = new SimpleDateFormat(_timeStampFormat);
 		} else {
 			_formatter = null;
 		}
 
 		_timestamp = !NONE.equalsIgnoreCase(_timeStampFormat);// reversed compare allows for null
 
 		_saveAssertionResultsFailureMessage = TRUE.equalsIgnoreCase(props.getProperty(
 				ASSERTION_RESULTS_FAILURE_MESSAGE_PROP, FALSE));
 
 		String whichAssertionResults = props.getProperty(ASSERTION_RESULTS_PROP, NONE);
 		if (NONE.equals(whichAssertionResults)) {
 			_assertionsResultsToSave = SAVE_NO_ASSERTIONS;
 		} else if (FIRST.equals(whichAssertionResults)) {
 			_assertionsResultsToSave = SAVE_FIRST_ASSERTION;
 		} else if (ALL.equals(whichAssertionResults)) {
 			_assertionsResultsToSave = SAVE_ALL_ASSERTIONS;
 		}
 
 		String howToSave = props.getProperty(OUTPUT_FORMAT_PROP, XML);
 
 		if (XML.equals(howToSave)) {
 			_xml = true;
 		} else {
 			_xml = false;
 		}
 
         _threadCounts=TRUE.equalsIgnoreCase(props.getProperty(SAVE_THREAD_COUNTS, FALSE));
+
+        _sampleCount=TRUE.equalsIgnoreCase(props.getProperty(SAVE_SAMPLE_COUNT, FALSE));
 	}
 
 	// Don't save this, as not settable via GUI
 	private String delimiter = _delimiter;
 	private static final SampleSaveConfiguration _static = new SampleSaveConfiguration();
 
 	// Give access to initial configuration
 	public static SampleSaveConfiguration staticConfig() {
 		return _static;
 	}
 
 	public SampleSaveConfiguration() {
 	}
 
 	/**
 	 * Alternate constructor for use by OldSaveService
 	 * 
 	 * @param value initial setting for boolean fields used in Config dialogue
 	 */
 	public SampleSaveConfiguration(boolean value) {
 		assertions = value;
 		bytes = value;
 		code = value;
 		dataType = value;
 		encoding = value;
 		fieldNames = value;
 		fileName = value;
 		label = value;
 		latency = value;
 		message = value;
 		printMilliseconds = _printMilliseconds;//is derived from properties only
 		requestHeaders = value;
 		responseData = value;
 		responseDataOnError = value;
 		responseHeaders = value;
 		samplerData = value;
 		saveAssertionResultsFailureMessage = value;
 		subresults = value;
 		success = value;
 		threadCounts = value;
+		sampleCount = value;
 		threadName = value;
 		time = value;
 		timestamp = value;
 		url = value;
 		xml = value;
 	}
 
     private Object readResolve() throws ObjectStreamException{
 	   formatter = _formatter;
        return this;
     }
 
     public Object clone() {
         try {
             SampleSaveConfiguration clone = (SampleSaveConfiguration)super.clone();
             if(this.formatter != null) {
                 clone.formatter = (SimpleDateFormat)this.formatter.clone();
             }
             return clone;
         }
         catch(CloneNotSupportedException e) {
             // this should not happen
             return null;
         }
 	}
     
     public boolean equals(Object obj) {
         if(this == obj) {
             return true;
         }
         if((obj == null) || (obj.getClass() != this.getClass())) {
             return false;
         }
         // We know we are comparing to another SampleSaveConfiguration
         SampleSaveConfiguration s = (SampleSaveConfiguration)obj;
         boolean primitiveValues = s.time == time &&
             s.latency == latency && 
             s.timestamp == timestamp &&
             s.success == success &&
             s.label == label &&
             s.code == code &&
             s.message == message &&
             s.threadName == threadName &&
             s.dataType == dataType &&
             s.encoding == encoding &&
             s.assertions == assertions &&
             s.subresults == subresults &&
             s.responseData == responseData &&
             s.samplerData == samplerData &&
             s.xml == xml &&
             s.fieldNames == fieldNames &&
             s.responseHeaders == responseHeaders &&
             s.requestHeaders == requestHeaders &&
             s.assertionsResultsToSave == assertionsResultsToSave &&
             s.saveAssertionResultsFailureMessage == saveAssertionResultsFailureMessage &&
             s.printMilliseconds == printMilliseconds &&
             s.responseDataOnError == responseDataOnError &&
             s.url == url &&
             s.bytes == bytes &&
             s.fileName == fileName &&
+            s.sampleCount == sampleCount &&
             s.threadCounts == threadCounts;
         
         boolean stringValues = false;
         if(primitiveValues) {
             stringValues = s.delimiter == delimiter || (delimiter != null && delimiter.equals(s.delimiter));
         }
         boolean complexValues = false;
         if(primitiveValues && stringValues) {
             complexValues = s.formatter == formatter || (formatter != null && formatter.equals(s.formatter));
         }
         
         return primitiveValues && stringValues && complexValues;
     }
     
     public int hashCode() {
         int hash = 7;
         hash = 31 * hash + (time ? 1 : 0);
         hash = 31 * hash + (latency ? 1 : 0);
         hash = 31 * hash + (timestamp ? 1 : 0);
         hash = 31 * hash + (success ? 1 : 0);
         hash = 31 * hash + (label ? 1 : 0);
         hash = 31 * hash + (code ? 1 : 0);
         hash = 31 * hash + (message ? 1 : 0);
         hash = 31 * hash + (threadName ? 1 : 0);
         hash = 31 * hash + (dataType ? 1 : 0);
         hash = 31 * hash + (encoding ? 1 : 0);
         hash = 31 * hash + (assertions ? 1 : 0);
         hash = 31 * hash + (subresults ? 1 : 0);
         hash = 31 * hash + (responseData ? 1 : 0);
         hash = 31 * hash + (samplerData ? 1 : 0);
         hash = 31 * hash + (xml ? 1 : 0);
         hash = 31 * hash + (fieldNames ? 1 : 0);
         hash = 31 * hash + (responseHeaders ? 1 : 0);
         hash = 31 * hash + (requestHeaders ? 1 : 0);
         hash = 31 * hash + assertionsResultsToSave;
         hash = 31 * hash + (saveAssertionResultsFailureMessage ? 1 : 0);
         hash = 31 * hash + (printMilliseconds ? 1 : 0);
         hash = 31 * hash + (responseDataOnError ? 1 : 0);
         hash = 31 * hash + (url ? 1 : 0);
         hash = 31 * hash + (bytes ? 1 : 0);
         hash = 31 * hash + (fileName ? 1 : 0);
         hash = 31 * hash + (threadCounts ? 1 : 0);
         hash = 31 * hash + (delimiter != null  ? delimiter.hashCode() : 0);
         hash = 31 * hash + (formatter != null  ? formatter.hashCode() : 0);
+        hash = 31 * hash + (sampleCount ? 1 : 0);
         
         return hash;
     }
 
     ///////////////////// Start of standard save/set access methods /////////////////////
     
 	public boolean saveResponseHeaders() {
 		return responseHeaders;
 	}
 
 	public void setResponseHeaders(boolean r) {
 		responseHeaders = r;
 	}
 
 	public boolean saveRequestHeaders() {
 		return requestHeaders;
 	}
 
 	public void setRequestHeaders(boolean r) {
 		requestHeaders = r;
 	}
 
 	public boolean saveAssertions() {
 		return assertions;
 	}
 
 	public void setAssertions(boolean assertions) {
 		this.assertions = assertions;
 	}
 
 	public boolean saveCode() {
 		return code;
 	}
 
 	public void setCode(boolean code) {
 		this.code = code;
 	}
 
 	public boolean saveDataType() {
 		return dataType;
 	}
 
 	public void setDataType(boolean dataType) {
 		this.dataType = dataType;
 	}
 
 	public boolean saveEncoding() {
 		return encoding;
 	}
 
 	public void setEncoding(boolean encoding) {
 		this.encoding = encoding;
 	}
 
 	public boolean saveLabel() {
 		return label;
 	}
 
 	public void setLabel(boolean label) {
 		this.label = label;
 	}
 
 	public boolean saveLatency() {
 		return latency;
 	}
 
 	public void setLatency(boolean latency) {
 		this.latency = latency;
 	}
 
 	public boolean saveMessage() {
 		return message;
 	}
 
 	public void setMessage(boolean message) {
 		this.message = message;
 	}
 
 	public boolean saveResponseData(SampleResult res) {
 		return responseData || TestPlan.getFunctionalMode() || (responseDataOnError && !res.isSuccessful());
 	}
     
     public boolean saveResponseData()
     {
         return responseData;
     }
 
 	public void setResponseData(boolean responseData) {
 		this.responseData = responseData;
 	}
 
 	public boolean saveSamplerData(SampleResult res) {
 		return samplerData || TestPlan.getFunctionalMode() // as per 2.0 branch
 				|| (responseDataOnError && !res.isSuccessful());
 	}
     
     public boolean saveSamplerData()
     {
         return samplerData;
     }
 
 	public void setSamplerData(boolean samplerData) {
 		this.samplerData = samplerData;
 	}
 
 	public boolean saveSubresults() {
 		return subresults;
 	}
 
 	public void setSubresults(boolean subresults) {
 		this.subresults = subresults;
 	}
 
 	public boolean saveSuccess() {
 		return success;
 	}
 
 	public void setSuccess(boolean success) {
 		this.success = success;
 	}
 
 	public boolean saveThreadName() {
 		return threadName;
 	}
 
 	public void setThreadName(boolean threadName) {
 		this.threadName = threadName;
 	}
 
 	public boolean saveTime() {
 		return time;
 	}
 
 	public void setTime(boolean time) {
 		this.time = time;
 	}
 
 	public boolean saveTimestamp() {
 		return timestamp;
 	}
 
 	public void setTimestamp(boolean timestamp) {
 		this.timestamp = timestamp;
 	}
 
 	public boolean saveAsXml() {
 		return xml;
 	}
 
 	public void setAsXml(boolean xml) {
 		this.xml = xml;
 	}
 
 	public boolean saveFieldNames() {
 		return fieldNames;
 	}
 
 	public void setFieldNames(boolean printFieldNames) {
 		this.fieldNames = printFieldNames;
 	}
 
 	public boolean saveUrl() {
 		return url;
 	}
 
 	public void setUrl(boolean save) {
 		this.url = save;
 	}
 
 	public boolean saveBytes() {
 		return bytes;
 	}
 
 	public void setBytes(boolean save) {
 		this.bytes = save;
 	}
 
 	public boolean saveFileName() {
 		return fileName;
 	}
 
 	public void setFileName(boolean save) {
 		this.fileName = save;
 	}
 
 	public boolean saveAssertionResultsFailureMessage() {
 		return saveAssertionResultsFailureMessage;
 	}
 
 	public void setAssertionResultsFailureMessage(boolean b) {
 		saveAssertionResultsFailureMessage = b;
 	}
 
     public boolean saveThreadCounts() {
         return threadCounts;
     }
 
     public void setThreadCounts(boolean save) {
         this.threadCounts = save;
     }
 
+    public boolean saveSampleCount() {
+        return sampleCount;
+    }
+
+    public void setSampleCount(boolean save) {
+        this.sampleCount = save;
+    }
+
 	///////////////// End of standard field accessors /////////////////////
 	
     /**
      * Only intended for use by OldSaveService (and test cases)
      */
     public void setFormatter(DateFormat fmt){
     	printMilliseconds = "ms".equals(fmt);// $NON-NLS-1$ maintain relationship
     	formatter = fmt;
     }
     
 	public boolean printMilliseconds() {
 		return printMilliseconds;
 	}
 
 	public DateFormat formatter() {
 		return formatter;
 	}
 
 	public int assertionsResultsToSave() {
 		return assertionsResultsToSave;
 	}
 
 	public String getDelimiter() {
 		return delimiter;
 	}
 
     public String getXmlPi() {
         return JMeterUtils.getJMeterProperties().getProperty(XML_PI, ""); // Defaults to empty;
     }
 
     // Used by SampleSaveConfigurationConverter.unmarshall()
 	public void setDefaultDelimiter() {
 		delimiter=_delimiter;
 	}
 
     // Used by SampleSaveConfigurationConverter.unmarshall()
 	public void setDefaultTimeStampFormat() {
 		printMilliseconds=_printMilliseconds;
 		formatter=_formatter;
 	}
 }
\ No newline at end of file
diff --git a/src/core/org/apache/jmeter/save/OldSaveService.java b/src/core/org/apache/jmeter/save/OldSaveService.java
index b95295c18..7d4dadfd0 100644
--- a/src/core/org/apache/jmeter/save/OldSaveService.java
+++ b/src/core/org/apache/jmeter/save/OldSaveService.java
@@ -1,966 +1,989 @@
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
 
 package org.apache.jmeter.save;
 
 import java.io.FileWriter;
 import java.io.IOException;
 import java.io.InputStream;
 import java.io.OutputStream;
 import java.io.UnsupportedEncodingException;
 import java.text.DateFormat;
 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.Collection;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.Iterator;
 import java.util.LinkedList;
 import java.util.List;
 import java.util.Map;
 import java.util.Vector;
 
 import org.apache.avalon.framework.configuration.Configuration;
 import org.apache.avalon.framework.configuration.ConfigurationException;
 import org.apache.avalon.framework.configuration.DefaultConfiguration;
 import org.apache.avalon.framework.configuration.DefaultConfigurationBuilder;
 import org.apache.avalon.framework.configuration.DefaultConfigurationSerializer;
 import org.apache.jmeter.assertions.AssertionResult;
 import org.apache.jmeter.samplers.SampleResult;
 import org.apache.jmeter.samplers.SampleSaveConfiguration;
 import org.apache.jmeter.testelement.TestElement;
 import org.apache.jmeter.testelement.property.CollectionProperty;
 import org.apache.jmeter.testelement.property.JMeterProperty;
 import org.apache.jmeter.testelement.property.MapProperty;
 import org.apache.jmeter.testelement.property.StringProperty;
 import org.apache.jmeter.testelement.property.TestElementProperty;
 import org.apache.jmeter.util.NameUpdater;
 import org.apache.jorphan.collections.HashTree;
 import org.apache.jorphan.collections.ListedHashTree;
 import org.apache.jorphan.logging.LoggingManager;
 import org.apache.jorphan.reflect.Functor;
 import org.apache.jorphan.util.JMeterError;
 import org.apache.log.Logger;
 import org.xml.sax.SAXException;
 
 /**
  * This class provides a means for saving test results. Test results are
  * typically saved in an XML file, but other storage mechanisms may also be
  * used, for instance, CSV files or databases.
  * 
  * @version $Revision$ $Date$
  */
 public final class OldSaveService {
 	private static final Logger log = LoggingManager.getLoggerForClass();
 
     // ---------------------------------------------------------------------
     // XML RESULT FILE CONSTANTS AND FIELD NAME CONSTANTS
     // ---------------------------------------------------------------------
 
     // Shared with TestElementSaver
     final static String PRESERVE = "preserve"; // $NON-NLS-1$
     final static String XML_SPACE = "xml:space"; // $NON-NLS-1$
 
     private static final String ASSERTION_RESULT_TAG_NAME = "assertionResult"; // $NON-NLS-1$
     private static final String BINARY = "binary"; // $NON-NLS-1$
     private static final String DATA_TYPE = "dataType"; // $NON-NLS-1$
     private static final String ERROR = "error"; // $NON-NLS-1$
     private static final String FAILURE = "failure"; // $NON-NLS-1$
     private static final String FAILURE_MESSAGE = "failureMessage"; // $NON-NLS-1$
     private static final String LABEL = "label"; // $NON-NLS-1$
     private static final String RESPONSE_CODE = "responseCode"; // $NON-NLS-1$
     private static final String RESPONSE_MESSAGE = "responseMessage"; // $NON-NLS-1$
     private static final String SAMPLE_RESULT_TAG_NAME = "sampleResult"; // $NON-NLS-1$
     private static final String SUCCESSFUL = "success"; // $NON-NLS-1$
     private static final String THREAD_NAME = "threadName"; // $NON-NLS-1$
     private static final String TIME = "time"; // $NON-NLS-1$
     private static final String TIME_STAMP = "timeStamp"; // $NON-NLS-1$
 
     // ---------------------------------------------------------------------
     // ADDITIONAL CSV RESULT FILE CONSTANTS AND FIELD NAME CONSTANTS
     // ---------------------------------------------------------------------
 
     private static final String CSV_ELAPSED = "elapsed"; // $NON-NLS-1$
     private static final String CSV_BYTES= "bytes"; // $NON-NLS-1$
     private static final String CSV_THREAD_COUNT1 = "grpThreads"; // $NON-NLS-1$
     private static final String CSV_THREAD_COUNT2 = "allThreads"; // $NON-NLS-1$
+    private static final String CSV_SAMPLE_COUNT = "SampleCount"; // $NON-NLS-1$
     private static final String CSV_URL = "URL"; // $NON-NLS-1$
     private static final String CSV_FILENAME = "Filename"; // $NON-NLS-1$
     private static final String CSV_LATENCY = "Latency"; // $NON-NLS-1$
     private static final String CSV_ENCODING = "Encoding"; // $NON-NLS-1$
     
     // Initial config from properties
 	static private final SampleSaveConfiguration _saveConfig = SampleSaveConfiguration.staticConfig();
 
 	// Date format to try if the time format does not parse as milliseconds
 	// (this is the suggested value in jmeter.properties)
 	private static final String DEFAULT_DATE_FORMAT_STRING = "MM/dd/yy HH:mm:ss"; // $NON-NLS-1$
 	private static final DateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat(DEFAULT_DATE_FORMAT_STRING);
 
 	private static DefaultConfigurationBuilder builder = new DefaultConfigurationBuilder();
 
 	/**
 	 * Private constructor to prevent instantiation.
 	 */
 	private OldSaveService() {
 	}
 
     //////////////////////////////////////////////////////////////////////////////
     //                  Start of CSV methods
     
     // TODO - move to separate file? If so, remember that some of the
       
     /**
      * Make a SampleResult given a delimited string.
      * 
      * @param inputLine - line from CSV file
      * @param saveConfig - configuration
      * @param lineNumber - line number for error reporting
      * @return SampleResult or null if header line detected
      * 
      * @throws JMeterError
      */
     public static SampleResult makeResultFromDelimitedString(
     		final String inputLine, 
     		final SampleSaveConfiguration saveConfig, // may be updated
     		final long lineNumber) {
  
     	SampleResult result = null;
 		long timeStamp = 0;
 		long elapsed = 0;
 		/*
 		 * Bug 40772: replaced StringTokenizer with String.split(), as the
 		 * former does not return empty tokens.
 		 */
 		// The \Q prefix is needed to ensure that meta-characters (e.g. ".") work.
 		String parts[]=inputLine.split("\\Q"+_saveConfig.getDelimiter());// $NON-NLS-1$
 		String text = null;
 		String field = null; // Save the name for error reporting
 		int i=0;
 
 		try {
 			if (saveConfig.saveTimestamp()){
 				field = TIME_STAMP;
 				text = parts[i++];
 				if (saveConfig.printMilliseconds()) {
 					try {
 						timeStamp = Long.parseLong(text);
 					} catch (NumberFormatException e) {// see if this works
 						log.warn(e.toString());
 						Date stamp = DEFAULT_DATE_FORMAT.parse(text);
 						timeStamp = stamp.getTime();
 						log.warn("Setting date format to: "+DEFAULT_DATE_FORMAT_STRING);
 						saveConfig.setFormatter(DEFAULT_DATE_FORMAT);
 					}
 				} else if (saveConfig.formatter() != null) {
 					Date stamp = saveConfig.formatter().parse(text);
 					timeStamp = stamp.getTime();
 				} else { // can this happen?
 					final String msg = "Unknown timestamp format";
 					log.warn(msg);
 					throw new JMeterError(msg);
 				}
 			}
 
 			if (saveConfig.saveTime()) {
 				field = CSV_ELAPSED;
 				text = parts[i++];
 				elapsed = Long.parseLong(text);
 			}
 
 			result = new SampleResult(timeStamp, elapsed);
 
 			if (saveConfig.saveLabel()) {
 				field = LABEL;
 				text = parts[i++];
 				result.setSampleLabel(text);
 			}
 			if (saveConfig.saveCode()) {
 				field = RESPONSE_CODE;
 				text = parts[i++];
 				result.setResponseCode(text);
 			}
 
 			if (saveConfig.saveMessage()) {
 				field = RESPONSE_MESSAGE;
 				text = parts[i++];
 				result.setResponseMessage(text);
 			}
 
 			if (saveConfig.saveThreadName()) {
 				field = THREAD_NAME;
 				text = parts[i++];
 				result.setThreadName(text);
 			}
 
 			if (saveConfig.saveDataType()) {
 				field = DATA_TYPE;
 				text = parts[i++];
 				result.setDataType(text);
 			}
 
 			if (saveConfig.saveSuccess()) {
 				field = SUCCESSFUL;
 				text = parts[i++];
 				result.setSuccessful(Boolean.valueOf(text).booleanValue());
 			}
 
 			if (saveConfig.saveAssertionResultsFailureMessage()) {
 				i++;
                 // TODO - should this be restored?
 			}
             
             if (saveConfig.saveBytes()) {
             	field = CSV_BYTES;
                 text = parts[i++];
                 result.setBytes(Integer.parseInt(text));
             }
         
             if (saveConfig.saveThreadCounts()) {
             	field = CSV_THREAD_COUNT1;
                 text = parts[i++];
                 result.setGroupThreads(Integer.parseInt(text));
                 
             	field = CSV_THREAD_COUNT2;
                 text = parts[i++];
                 result.setAllThreads(Integer.parseInt(text));
             }
 
             if (saveConfig.saveUrl()) {
                 i++;
                 // TODO: should this be restored?
             }
         
             if (saveConfig.saveFileName()) {
             	field = CSV_FILENAME;
                 text = parts[i++];
                 result.setResultFileName(text);
             }            
             if (saveConfig.saveLatency()) {
             	field = CSV_LATENCY;
                 text = parts[i++];
                 result.setLatency(Long.parseLong(text));
             }
 
             if (saveConfig.saveEncoding()) {
             	field = CSV_ENCODING;
                 text = parts[i++];
                 result.setEncodingAndType(text);
             }
 
+            if (saveConfig.saveEncoding()) {
+            	field = CSV_SAMPLE_COUNT;
+                text = parts[i++];
+                result.setSampleCount(Integer.parseInt(text));
+            }
+
             
 		} catch (NumberFormatException e) {
 			log.warn("Error parsing field '" + field + "' at line " + lineNumber + " " + e);
 			throw new JMeterError(e);
 		} catch (ParseException e) {
 			log.warn("Error parsing field '" + field + "' at line " + lineNumber + " " + e);
 			throw new JMeterError(e);
 		} catch (ArrayIndexOutOfBoundsException e){
 			log.warn("Insufficient columns to parse field '" + field + "' at line " + lineNumber);
 			throw new JMeterError(e);
 		}
 		return result;
 	}
 
     /**
      * Generates the field names for the output file
      * 
      * @return the field names as a string
      */
     public static String printableFieldNamesToString() {
         return printableFieldNamesToString(_saveConfig);
     }
     
 	/**
 	 * Generates the field names for the output file
 	 * 
 	 * @return the field names as a string
 	 */
 	public static String printableFieldNamesToString(SampleSaveConfiguration saveConfig) {
 		StringBuffer text = new StringBuffer();
 		String delim = saveConfig.getDelimiter();
 
 		if (saveConfig.saveTimestamp()) {
 			text.append(TIME_STAMP);
 			text.append(delim);
 		}
 
 		if (saveConfig.saveTime()) {
 			text.append(CSV_ELAPSED);
 			text.append(delim);
 		}
 
 		if (saveConfig.saveLabel()) {
 			text.append(LABEL);
 			text.append(delim);
 		}
 
 		if (saveConfig.saveCode()) {
 			text.append(RESPONSE_CODE);
 			text.append(delim);
 		}
 
 		if (saveConfig.saveMessage()) {
 			text.append(RESPONSE_MESSAGE);
 			text.append(delim);
 		}
 
 		if (saveConfig.saveThreadName()) {
 			text.append(THREAD_NAME);
 			text.append(delim);
 		}
 
 		if (saveConfig.saveDataType()) {
 			text.append(DATA_TYPE);
 			text.append(delim);
 		}
 
 		if (saveConfig.saveSuccess()) {
 			text.append(SUCCESSFUL);
 			text.append(delim);
 		}
 
 		if (saveConfig.saveAssertionResultsFailureMessage()) {
 			text.append(FAILURE_MESSAGE);
 			text.append(delim);
 		}
 
         if (saveConfig.saveBytes()) {
             text.append(CSV_BYTES);
             text.append(delim);
         }
 
         if (saveConfig.saveThreadCounts()) {
             text.append(CSV_THREAD_COUNT1);
             text.append(delim);
             text.append(CSV_THREAD_COUNT2);
             text.append(delim);
         }
 
         if (saveConfig.saveUrl()) {
             text.append(CSV_URL);
             text.append(delim);
         }
 
         if (saveConfig.saveFileName()) {
             text.append(CSV_FILENAME);
             text.append(delim);
         }
 
         if (saveConfig.saveLatency()) {
             text.append(CSV_LATENCY);
             text.append(delim);
         }
 
         if (saveConfig.saveEncoding()) {
             text.append(CSV_ENCODING);
             text.append(delim);
         }
 
+		if (saveConfig.saveSampleCount()) {
+			text.append(CSV_SAMPLE_COUNT);
+			text.append(delim);
+		}
+
 		String resultString = null;
 		int size = text.length();
 		int delSize = delim.length();
 
 		// Strip off the trailing delimiter
 		if (size >= delSize) {
 			resultString = text.substring(0, size - delSize);
 		} else {
 			resultString = text.toString();
 		}
 		return resultString;
 	}
 	
 	// Map header names to set() methods
 	private static final Map headerLabelMethods = new HashMap();
 	
 	static {
 		    headerLabelMethods.put(TIME_STAMP, new Functor("setTimestamp"));
 			headerLabelMethods.put(CSV_ELAPSED, new Functor("setTime"));
 			headerLabelMethods.put(LABEL, new Functor("setLabel"));
 			headerLabelMethods.put(RESPONSE_CODE, new Functor("setCode"));
 			headerLabelMethods.put(RESPONSE_MESSAGE, new Functor("setMessage"));
 			headerLabelMethods.put(THREAD_NAME, new Functor("setThreadName"));
 			headerLabelMethods.put(DATA_TYPE, new Functor("setDataType"));
 			headerLabelMethods.put(SUCCESSFUL, new Functor("setSuccess"));
 			headerLabelMethods.put(FAILURE_MESSAGE, new Functor("setAssertionResultsFailureMessage"));
             headerLabelMethods.put(CSV_BYTES, new Functor("setBytes"));
             headerLabelMethods.put(CSV_URL, new Functor("setUrl"));
             headerLabelMethods.put(CSV_FILENAME, new Functor("setFileName"));
             headerLabelMethods.put(CSV_LATENCY, new Functor("setLatency"));
             headerLabelMethods.put(CSV_ENCODING, new Functor("setEncoding"));
+            // Both these are needed in the list even though they set the same variable
             headerLabelMethods.put(CSV_THREAD_COUNT1,new Functor("setThreadCounts"));
-            headerLabelMethods.put(CSV_THREAD_COUNT2, new Functor("setThreadCounts"));
+            headerLabelMethods.put(CSV_THREAD_COUNT2,new Functor("setThreadCounts"));
+            headerLabelMethods.put(CSV_SAMPLE_COUNT, new Functor("setSampleCount"));
 	}
 
 	/**
 	 * Parse a CSV header line
 	 * @param headerLine from CSV file
 	 * @return config corresponding to the header items found or null if not a header line
 	 */
 	public static SampleSaveConfiguration getSampleSaveConfiguration(String headerLine){
 		String parts[]=headerLine.split("\\Q"+_saveConfig.getDelimiter());// $NON-NLS-1$
 
 		// Check if the line is a header
 		for(int i=0;i<parts.length;i++){
 			if (!headerLabelMethods.containsKey(parts[i])){
 				return null; // unknown column name
 			}
 		}
 
 		// We know the column names all exist, so create the config 
 		SampleSaveConfiguration saveConfig=new SampleSaveConfiguration(false);
 		
 		for(int i=0;i<parts.length;i++){
 			Functor set = (Functor) headerLabelMethods.get(parts[i]);
 			set.invoke(saveConfig,new Boolean[]{Boolean.TRUE});
 		}
 		return saveConfig;
 	}
 
 	/**
      * Method will save aggregate statistics as CSV. For now I put it here.
      * Not sure if it should go in the newer SaveService instead of here.
      * if we ever decide to get rid of this class, we'll need to move this
      * method to the new save service.
      * @param data
      * @param writer
      * @throws IOException
      */
     public static void saveCSVStats(Vector data, FileWriter writer) throws IOException {
         for (int idx=0; idx < data.size(); idx++) {
             Vector row = (Vector)data.elementAt(idx);
             for (int idy=0; idy < row.size(); idy++) {
                 if (idy > 0) {
                     writer.write(","); // $NON-NLS-1$
                 }
                 Object item = row.elementAt(idy);
                 writer.write( String.valueOf(item) );
             }
             writer.write(System.getProperty("line.separator")); // $NON-NLS-1$
         }
     }
 
     /**
      * Convert a result into a string, where the fields of the result are
      * separated by the default delimiter.
      * 
      * @param sample
      *            the test result to be converted
      * @return the separated value representation of the result
      */
     public static String resultToDelimitedString(SampleResult sample) {
     	return resultToDelimitedString(sample, sample.getSaveConfig().getDelimiter());
     }
 
     /**
      * Convert a result into a string, where the fields of the result are
      * separated by a specified String.
      * 
      * @param sample
      *            the test result to be converted
      * @param delimiter
      *            the separation string
      * @return the separated value representation of the result
      */
     public static String resultToDelimitedString(SampleResult sample, String delimiter) {
     	StringBuffer text = new StringBuffer();
     	SampleSaveConfiguration saveConfig = sample.getSaveConfig();
     
     	if (saveConfig.saveTimestamp()) {
     		if (saveConfig.printMilliseconds()){
     			text.append(sample.getTimeStamp());
     			text.append(delimiter);
     		} else if (saveConfig.formatter() != null) {
     			String stamp = saveConfig.formatter().format(new Date(sample.getTimeStamp()));
     			text.append(stamp);
     			text.append(delimiter);
     		}
     	}
     
     	if (saveConfig.saveTime()) {
     		text.append(sample.getTime());
     		text.append(delimiter);
     	}
     
     	if (saveConfig.saveLabel()) {
     		text.append(sample.getSampleLabel());
     		text.append(delimiter);
     	}
     
     	if (saveConfig.saveCode()) {
     		text.append(sample.getResponseCode());
     		text.append(delimiter);
     	}
     
     	if (saveConfig.saveMessage()) {
     		text.append(sample.getResponseMessage());
     		text.append(delimiter);
     	}
     
     	if (saveConfig.saveThreadName()) {
     		text.append(sample.getThreadName());
     		text.append(delimiter);
     	}
     
     	if (saveConfig.saveDataType()) {
     		text.append(sample.getDataType());
     		text.append(delimiter);
     	}
     
     	if (saveConfig.saveSuccess()) {
     		text.append(sample.isSuccessful());
     		text.append(delimiter);
     	}
     
     	if (saveConfig.saveAssertionResultsFailureMessage()) {
     		String message = null;
     		AssertionResult[] results = sample.getAssertionResults();
     
     		if (results != null) {
     			// Find the first non-null message
     			for (int i = 0; i < results.length; i++){
         			message = results[i].getFailureMessage();
     				if (message != null) break;
     			}
     		}
     
     		if (message != null) {
     			text.append(message);
     		}
     		text.append(delimiter);
     	}
     
         if (saveConfig.saveBytes()) {
             text.append(sample.getBytes());
             text.append(delimiter);
         }
     
         if (saveConfig.saveThreadCounts()) {
             text.append(sample.getGroupThreads());
             text.append(delimiter);
             text.append(sample.getAllThreads());
             text.append(delimiter);
         }
         if (saveConfig.saveUrl()) {
             text.append(sample.getURL());
             text.append(delimiter);
         }
     
         if (saveConfig.saveFileName()) {
             text.append(sample.getResultFileName());
             text.append(delimiter);
         }
     
         if (saveConfig.saveLatency()) {
             text.append(sample.getLatency());
             text.append(delimiter);
         }
 
         if (saveConfig.saveEncoding()) {
             text.append(sample.getDataEncoding());
             text.append(delimiter);
         }
 
+    	if (saveConfig.saveSampleCount()) {
+    		text.append(sample.getSampleCount());
+    		text.append(delimiter);
+    	}
+    
     	String resultString = null;
     	int size = text.length();
     	int delSize = delimiter.length();
     
     	// Strip off the trailing delimiter
     	if (size >= delSize) {
     		resultString = text.substring(0, size - delSize);
     	} else {
     		resultString = text.toString();
     	}
     	return resultString;
     }
 
     //              End of CSV methods
     //////////////////////////////////////////////////////////////////////////////////////////
     //              Start of Avalon methods
     
     public static void saveSubTree(HashTree subTree, OutputStream writer) throws IOException {
 		Configuration config = (Configuration) getConfigsFromTree(subTree).get(0);
 		DefaultConfigurationSerializer saver = new DefaultConfigurationSerializer();
 
 		saver.setIndent(true);
 		try {
 			saver.serialize(writer, config);
 		} catch (SAXException e) {
 			throw new IOException("SAX implementation problem");
 		} catch (ConfigurationException e) {
 			throw new IOException("Problem using Avalon Configuration tools");
 		}
 	}
     
     public static SampleResult getSampleResult(Configuration config) {
 		SampleResult result = new SampleResult(config.getAttributeAsLong(TIME_STAMP, 0L), config.getAttributeAsLong(
 				TIME, 0L));
 
 		result.setThreadName(config.getAttribute(THREAD_NAME, "")); // $NON-NLS-1$
 		result.setDataType(config.getAttribute(DATA_TYPE, ""));
 		result.setResponseCode(config.getAttribute(RESPONSE_CODE, "")); // $NON-NLS-1$
 		result.setResponseMessage(config.getAttribute(RESPONSE_MESSAGE, "")); // $NON-NLS-1$
 		result.setSuccessful(config.getAttributeAsBoolean(SUCCESSFUL, false));
 		result.setSampleLabel(config.getAttribute(LABEL, "")); // $NON-NLS-1$
 		result.setResponseData(getBinaryData(config.getChild(BINARY)));
 		Configuration[] subResults = config.getChildren(SAMPLE_RESULT_TAG_NAME);
 
 		for (int i = 0; i < subResults.length; i++) {
 			result.storeSubResult(getSampleResult(subResults[i]));
 		}
 		Configuration[] assResults = config.getChildren(ASSERTION_RESULT_TAG_NAME);
 
 		for (int i = 0; i < assResults.length; i++) {
 			result.addAssertionResult(getAssertionResult(assResults[i]));
 		}
 
 		Configuration[] samplerData = config.getChildren("property"); // $NON-NLS-1$
 		for (int i = 0; i < samplerData.length; i++) {
 			result.setSamplerData(samplerData[i].getValue("")); // $NON-NLS-1$
 		}
 		return result;
 	}
 
 	private static List getConfigsFromTree(HashTree subTree) {
 		Iterator iter = subTree.list().iterator();
 		List configs = new LinkedList();
 
 		while (iter.hasNext()) {
 			TestElement item = (TestElement) iter.next();
 			DefaultConfiguration config = new DefaultConfiguration("node", "node"); // $NON-NLS-1$ // $NON-NLS-2$
 
 			config.addChild(getConfigForTestElement(null, item));
 			List configList = getConfigsFromTree(subTree.getTree(item));
 			Iterator iter2 = configList.iterator();
 
 			while (iter2.hasNext()) {
 				config.addChild((Configuration) iter2.next());
 			}
 			configs.add(config);
 		}
 		return configs;
 	}
 
 	public static Configuration getConfiguration(byte[] bin) {
 		DefaultConfiguration config = new DefaultConfiguration(BINARY, "JMeter Save Service"); // $NON-NLS-1$
 
 		try {
 			config.setValue(new String(bin, "UTF-8")); // $NON-NLS-1$
 		} catch (UnsupportedEncodingException e) {
 			log.error("", e); // $NON-NLS-1$
 		}
 		return config;
 	}
 
 	public static byte[] getBinaryData(Configuration config) {
 		if (config == null) {
 			return new byte[0];
 		}
 		try {
 			return config.getValue("").getBytes("UTF-8"); // $NON-NLS-1$
 		} catch (UnsupportedEncodingException e) {
 			return new byte[0];
 		}
 	}
 
 	public static AssertionResult getAssertionResult(Configuration config) {
 		AssertionResult result = new AssertionResult(""); //TODO provide proper name?
 		result.setError(config.getAttributeAsBoolean(ERROR, false));
 		result.setFailure(config.getAttributeAsBoolean(FAILURE, false));
 		result.setFailureMessage(config.getAttribute(FAILURE_MESSAGE, ""));
 		return result;
 	}
 
 	public static Configuration getConfiguration(AssertionResult assResult) {
 		DefaultConfiguration config = new DefaultConfiguration(ASSERTION_RESULT_TAG_NAME, "JMeter Save Service");
 
 		config.setAttribute(FAILURE_MESSAGE, assResult.getFailureMessage());
 		config.setAttribute(ERROR, "" + assResult.isError());
 		config.setAttribute(FAILURE, "" + assResult.isFailure());
 		return config;
 	}
 
+	/*
+	 * TODO - I think this is used for the original test plan format
+	 * It seems to be rather out of date, as many attributes are missing?
+	*/
 	/**
 	 * This method determines the content of the result data that will be
 	 * stored.
 	 * 
 	 * @param result
 	 *            the object containing all of the data that has been collected.
 	 * @param saveConfig
 	 *            the configuration giving the data items to be saved.
 	 */
 	public static Configuration getConfiguration(SampleResult result, SampleSaveConfiguration saveConfig) {
 		DefaultConfiguration config = new DefaultConfiguration(SAMPLE_RESULT_TAG_NAME, "JMeter Save Service"); // $NON-NLS-1$
 
 		if (saveConfig.saveTime()) {
 			config.setAttribute(TIME, String.valueOf(result.getTime()));
 		}
 		if (saveConfig.saveLabel()) {
 			config.setAttribute(LABEL, result.getSampleLabel());
 		}
 		if (saveConfig.saveCode()) {
 			config.setAttribute(RESPONSE_CODE, result.getResponseCode());
 		}
 		if (saveConfig.saveMessage()) {
 			config.setAttribute(RESPONSE_MESSAGE, result.getResponseMessage());
 		}
 		if (saveConfig.saveThreadName()) {
 			config.setAttribute(THREAD_NAME, result.getThreadName());
 		}
 		if (saveConfig.saveDataType()) {
 			config.setAttribute(DATA_TYPE, result.getDataType());
 		}
 
 		if (saveConfig.printMilliseconds()) {
 			config.setAttribute(TIME_STAMP, String.valueOf(result.getTimeStamp()));
 		} else if (saveConfig.formatter() != null) {
 			String stamp = saveConfig.formatter().format(new Date(result.getTimeStamp()));
 
 			config.setAttribute(TIME_STAMP, stamp);
 		}
 
 		if (saveConfig.saveSuccess()) {
 			config.setAttribute(SUCCESSFUL, Boolean.toString(result.isSuccessful()));
 		}
 
 		SampleResult[] subResults = result.getSubResults();
 
 		if (subResults != null) {
 			for (int i = 0; i < subResults.length; i++) {
 				config.addChild(getConfiguration(subResults[i], saveConfig));
 			}
 		}
 
 		AssertionResult[] assResults = result.getAssertionResults();
 
 		if (saveConfig.saveSamplerData(result)) {
 			config.addChild(createConfigForString("samplerData", result.getSamplerData())); // $NON-NLS-1$
 		}
 		if (saveConfig.saveAssertions() && assResults != null) {
 			for (int i = 0; i < assResults.length; i++) {
 				config.addChild(getConfiguration(assResults[i]));
 			}
 		}
 		if (saveConfig.saveResponseData(result)) {
 			config.addChild(getConfiguration(result.getResponseData()));
 		}
 		return config;
 	}
 
 	public static Configuration getConfigForTestElement(String named, TestElement item) {
 		TestElementSaver saver = new TestElementSaver(named);
 		item.traverse(saver);
 		Configuration config = saver.getConfiguration();
 		/*
 		 * DefaultConfiguration config = new DefaultConfiguration("testelement",
 		 * "testelement");
 		 * 
 		 * if (named != null) { config.setAttribute("name", named); } if
 		 * (item.getProperty(TestElement.TEST_CLASS) != null) {
 		 * config.setAttribute("class", (String)
 		 * item.getProperty(TestElement.TEST_CLASS)); } else {
 		 * config.setAttribute("class", item.getClass().getName()); } Iterator
 		 * iter = item.getPropertyNames().iterator();
 		 * 
 		 * while (iter.hasNext()) { String name = (String) iter.next(); Object
 		 * value = item.getProperty(name);
 		 * 
 		 * if (value instanceof TestElement) {
 		 * config.addChild(getConfigForTestElement(name, (TestElement) value)); }
 		 * else if (value instanceof Collection) {
 		 * config.addChild(createConfigForCollection(name, (Collection) value)); }
 		 * else if (value != null) { config.addChild(createConfigForString(name,
 		 * value.toString())); } }
 		 */
 		return config;
 	}
 
 
 	private static Configuration createConfigForString(String name, String value) {
 		if (value == null) {
 			value = "";
 		}
 		DefaultConfiguration config = new DefaultConfiguration("property", "property");
 
 		config.setAttribute("name", name);
 		config.setValue(value);
 		config.setAttribute(XML_SPACE, PRESERVE);
 		return config;
 	}
 
 	public synchronized static HashTree loadSubTree(InputStream in) throws IOException {
 		try {
 			Configuration config = builder.build(in);
 			HashTree loadedTree = generateNode(config);
 
 			return loadedTree;
 		} catch (ConfigurationException e) {
 			String message = "Problem loading using Avalon Configuration tools";
 			log.error(message, e);
 			throw new IOException(message);
 		} catch (SAXException e) {
 			String message = "Problem with SAX implementation";
 			log.error(message, e);
 			throw new IOException(message);
 		}
 	}
 
 	public static TestElement createTestElement(Configuration config) throws ConfigurationException,
 			ClassNotFoundException, IllegalAccessException, InstantiationException {
 		TestElement element = null;
 
 		String testClass = config.getAttribute("class"); // $NON-NLS-1$
 		
         String gui_class=""; // $NON-NLS-1$
 		Configuration[] children = config.getChildren();
         for (int i = 0; i < children.length; i++) {
             if (children[i].getName().equals("property")) { // $NON-NLS-1$
                 if (children[i].getAttribute("name").equals(TestElement.GUI_CLASS)){ // $NON-NLS-1$
                     gui_class=children[i].getValue();
                 }
             }  
         }
         
         String newClass = NameUpdater.getCurrentTestName(testClass,gui_class);
 
         element = (TestElement) Class.forName(newClass).newInstance();
 
         for (int i = 0; i < children.length; i++) {
 			if (children[i].getName().equals("property")) { // $NON-NLS-1$
 				try {
                     JMeterProperty prop = createProperty(children[i], newClass);
 					if (prop!=null) element.setProperty(prop);
 				} catch (Exception ex) {
 					log.error("Problem loading property", ex);
 					element.setProperty(children[i].getAttribute("name"), ""); // $NON-NLS-1$ // $NON-NLS-2$
 				}
 			} else if (children[i].getName().equals("testelement")) { // $NON-NLS-1$
 				element.setProperty(new TestElementProperty(children[i].getAttribute("name", ""), // $NON-NLS-1$ // $NON-NLS-2$
 						createTestElement(children[i])));
 			} else if (children[i].getName().equals("collection")) { // $NON-NLS-1$
 				element.setProperty(new CollectionProperty(children[i].getAttribute("name", ""), // $NON-NLS-1$ // $NON-NLS-2$
                         createCollection(children[i], newClass)));
 			} else if (children[i].getName().equals("map")) { // $NON-NLS-1$
 				element.setProperty(new MapProperty(children[i].getAttribute("name", ""), // $NON-NLS-1$ // $NON-NLS-2$
                         createMap(children[i],newClass)));
 			}
 		}
 		return element;
 	}
 
 	private static Collection createCollection(Configuration config, String testClass) throws ConfigurationException,
 			ClassNotFoundException, IllegalAccessException, InstantiationException {
 		Collection coll = (Collection) Class.forName(config.getAttribute("class")).newInstance(); // $NON-NLS-1$ 
 		Configuration[] items = config.getChildren();
 
 		for (int i = 0; i < items.length; i++) {
 			if (items[i].getName().equals("property")) { // $NON-NLS-1$ 
                 JMeterProperty prop = createProperty(items[i], testClass);
 				if (prop!=null) coll.add(prop);
 			} else if (items[i].getName().equals("testelement")) { // $NON-NLS-1$ 
 				coll.add(new TestElementProperty(items[i].getAttribute("name", ""), createTestElement(items[i]))); // $NON-NLS-1$ // $NON-NLS-2$
 			} else if (items[i].getName().equals("collection")) { // $NON-NLS-1$ 
 				coll.add(new CollectionProperty(items[i].getAttribute("name", ""), // $NON-NLS-1$ // $NON-NLS-2$
 						createCollection(items[i], testClass)));
 			} else if (items[i].getName().equals("string")) { // $NON-NLS-1$ 
                 JMeterProperty prop = createProperty(items[i], testClass);
 				if (prop!=null) coll.add(prop);
 			} else if (items[i].getName().equals("map")) { // $NON-NLS-1$ 
 				coll.add(new MapProperty(items[i].getAttribute("name", ""), createMap(items[i], testClass))); // $NON-NLS-1$ // $NON-NLS-2$
 			}
 		}
 		return coll;
 	}
 
 	private static JMeterProperty createProperty(Configuration config, String testClass) throws IllegalAccessException,
 			ClassNotFoundException, InstantiationException {
 		String value = config.getValue(""); // $NON-NLS-1$ 
 		String name = config.getAttribute("name", value); // $NON-NLS-1$ 
         String oname = name;
 		String type = config.getAttribute("propType", StringProperty.class.getName()); // $NON-NLS-1$ 
 
 		// Do upgrade translation:
 		name = NameUpdater.getCurrentName(name, testClass);
 		if (TestElement.GUI_CLASS.equals(name)) {
 			value = NameUpdater.getCurrentName(value);
         } else if (TestElement.TEST_CLASS.equals(name)) {
             value=testClass; // must always agree
 		} else {
 			value = NameUpdater.getCurrentName(value, name, testClass);
 		}
 
         // Delete any properties whose name converts to the empty string
         if (oname.length() != 0 && name.length()==0) {
             return null;
         }
 
         // Create the property:
 		JMeterProperty prop = (JMeterProperty) Class.forName(type).newInstance();
 		prop.setName(name);
 		prop.setObjectValue(value);
 
 		return prop;
 	}
 
 	private static Map createMap(Configuration config, String testClass) throws ConfigurationException,
 			ClassNotFoundException, IllegalAccessException, InstantiationException {
 		Map map = (Map) Class.forName(config.getAttribute("class")).newInstance();
 		Configuration[] items = config.getChildren();
 
 		for (int i = 0; i < items.length; i++) {
 			if (items[i].getName().equals("property")) { // $NON-NLS-1$ 
 				JMeterProperty prop = createProperty(items[i], testClass);
 				if (prop!=null) map.put(prop.getName(), prop);
 			} else if (items[i].getName().equals("testelement")) { // $NON-NLS-1$ 
 				map.put(items[i].getAttribute("name", ""), new TestElementProperty(items[i].getAttribute("name", ""), // $NON-NLS-1$ // $NON-NLS-2$
 						createTestElement(items[i])));
 			} else if (items[i].getName().equals("collection")) { // $NON-NLS-1$ 
 				map.put(items[i].getAttribute("name"),  // $NON-NLS-1$ 
 						new CollectionProperty(items[i].getAttribute("name", ""), // $NON-NLS-1$ // $NON-NLS-2$
 						createCollection(items[i], testClass)));
 			} else if (items[i].getName().equals("map")) { // $NON-NLS-1$ 
 				map.put(items[i].getAttribute("name", ""),  // $NON-NLS-1$ // $NON-NLS-2$
 						new MapProperty(items[i].getAttribute("name", ""), // $NON-NLS-1$ // $NON-NLS-2$
 						createMap(items[i], testClass)));
 			}
 		}
 		return map;
 	}
 
 	private static HashTree generateNode(Configuration config) {
 		TestElement element = null;
 
 		try {
 			element = createTestElement(config.getChild("testelement")); // $NON-NLS-1$ 
 		} catch (Exception e) {
 			log.error("Problem loading part of file", e);
 			return null;
 		}
 		HashTree subTree = new ListedHashTree(element);
 		Configuration[] subNodes = config.getChildren("node"); // $NON-NLS-1$ 
 
 		for (int i = 0; i < subNodes.length; i++) {
 			HashTree t = generateNode(subNodes[i]);
 
 			if (t != null) {
 				subTree.add(element, t);
 			}
 		}
 		return subTree;
 	}
 }
diff --git a/src/core/org/apache/jmeter/save/converters/SampleSaveConfigurationConverter.java b/src/core/org/apache/jmeter/save/converters/SampleSaveConfigurationConverter.java
index 8f638f7d5..e15f0bc48 100644
--- a/src/core/org/apache/jmeter/save/converters/SampleSaveConfigurationConverter.java
+++ b/src/core/org/apache/jmeter/save/converters/SampleSaveConfigurationConverter.java
@@ -1,147 +1,152 @@
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
 
 package org.apache.jmeter.save.converters;
 
 import org.apache.jmeter.samplers.SampleSaveConfiguration;
 
 import com.thoughtworks.xstream.converters.MarshallingContext;
 import com.thoughtworks.xstream.converters.UnmarshallingContext;
 import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
 import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
 import com.thoughtworks.xstream.core.JVM;
 import com.thoughtworks.xstream.io.HierarchicalStreamReader;
 import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
 import com.thoughtworks.xstream.mapper.Mapper;
 import com.thoughtworks.xstream.mapper.MapperWrapper;
 
 /*
  * Allow new fields to be added to the SampleSaveConfiguration without
  * changing the output JMX file unless it is necessary. 
  * 
  * TODO work out how to make shouldSerializeMember() conditionally return true.
  */
 public class SampleSaveConfigurationConverter  extends ReflectionConverter {
 
 	private static final ReflectionProvider rp = new JVM().bestReflectionProvider();
 
     private static final String TRUE = "true"; // $NON-NLS-1$
 
     // N.B. These must agree with the new member names in SampleSaveConfiguration
 	private static final String NODE_FILENAME = "fileName"; // $NON-NLS-1$
 	private static final String NODE_URL = "url"; // $NON-NLS-1$
 	private static final String NODE_BYTES = "bytes"; // $NON-NLS-1$
     private static final String NODE_THREAD_COUNT = "threadCounts"; // $NON-NLS-1$
+    private static final String NODE_SAMPLE_COUNT = "sampleCount"; // $NON-NLS-1$
 
     // Additional member names which are currently not written out
     private static final String NODE_DELIMITER = "delimiter"; // $NON-NLS-1$
     private static final String NODE_PRINTMS = "printMilliseconds"; // $NON-NLS-1$
 
 
     static class MyWrapper extends MapperWrapper{
 
         public MyWrapper(Mapper wrapped) {
             super(wrapped);
         }
         
         public boolean shouldSerializeMember(Class definedIn, String fieldName) {
             if (SampleSaveConfiguration.class != definedIn) return true;
+            // These are new fields; not saved unless true
             if (fieldName.equals(NODE_BYTES)) return false; 
             if (fieldName.equals(NODE_URL)) return false; 
             if (fieldName.equals(NODE_FILENAME)) return false; 
             if (fieldName.equals(NODE_THREAD_COUNT)) return false; 
+            if (fieldName.equals(NODE_SAMPLE_COUNT)) return false; 
 
+            // These fields are not currently saved or restored
             if (fieldName.equals(NODE_DELIMITER)) return false; 
             if (fieldName.equals(NODE_PRINTMS)) return false; 
             return true;
         }
     }
 	public SampleSaveConfigurationConverter(Mapper arg0) {
         super(new MyWrapper(arg0),rp);
     }
 
     /**
 	 * Returns the converter version; used to check for possible
 	 * incompatibilities
 	 */
 	public static String getVersion() {
 		return "$Revision$"; // $NON-NLS-1$
 	}
 
 	/*
 	 * (non-Javadoc)
 	 * 
 	 * @see com.thoughtworks.xstream.converters.Converter#canConvert(java.lang.Class)
 	 */
 	public boolean canConvert(Class arg0) {
 		return arg0.equals(SampleSaveConfiguration.class);
 	}
 
 	/*
 	 * (non-Javadoc)
 	 * 
 	 * @see com.thoughtworks.xstream.converters.Converter#marshal(java.lang.Object,
 	 *      com.thoughtworks.xstream.io.HierarchicalStreamWriter,
 	 *      com.thoughtworks.xstream.converters.MarshallingContext)
 	 */
 	public void marshal(Object obj, HierarchicalStreamWriter writer, MarshallingContext context) {
         super.marshal(obj, writer, context); // Save most things
         
         SampleSaveConfiguration prop = (SampleSaveConfiguration) obj;
         
         // Save the new fields - but only if they are not the default
         createNode(writer,prop.saveBytes(),NODE_BYTES);
         createNode(writer,prop.saveUrl(),NODE_URL);
         createNode(writer,prop.saveFileName(),NODE_FILENAME);
         createNode(writer,prop.saveThreadCounts(),NODE_THREAD_COUNT);
+        createNode(writer,prop.saveSampleCount(),NODE_SAMPLE_COUNT);
 	}
 
     // Helper method to simplify marshall routine
     private void createNode(HierarchicalStreamWriter writer, boolean save, String node) {
         if (!save) return;
         writer.startNode(node);
         writer.setValue(TRUE);
         writer.endNode();
     }
 
     /*
      * 
      */
 	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
 		final Class thisClass = SampleSaveConfiguration.class;
 		final Class requiredType = context.getRequiredType();
 		if (requiredType != thisClass) {
 			throw new IllegalArgumentException("Unexpected class: "+requiredType.getName());
 		}
 		SampleSaveConfiguration result = new SampleSaveConfiguration();
 		result.setBytes(false); // Maintain backward compatibility (bytes was not in the JMX file)
 		while (reader.hasMoreChildren()) {
 			reader.moveDown();
 			String nn = reader.getNodeName();
 			if (!"formatter".equals(nn)){// Skip formatter (if present) bug 42674 $NON-NLS-1$
 				String fieldName = mapper.realMember(thisClass, nn);
                 java.lang.reflect.Field field = reflectionProvider.getField(thisClass,fieldName);
                 Class type = field.getType();
                 Object value = unmarshallField(context, result, type, field);
 				reflectionProvider.writeField(result, nn, value, thisClass);
 			}
 			reader.moveUp();
 		}
 		return result;
 	}
 }
diff --git a/xdocs/changes.xml b/xdocs/changes.xml
index 4edc9f769..1258f73e4 100644
--- a/xdocs/changes.xml
+++ b/xdocs/changes.xml
@@ -1,1060 +1,1061 @@
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
 	<author email="jmeter-dev AT jakarta.apache.org">JMeter developers</author>     
 	<title>History of Changes</title>   
 </properties> 
 <body> 
 <section name="History of Changes"> 
 <p><b>Changes sections are chronologically ordered from top (most recent) to bottom 
 (least recent)</b></p>  
 
 <!--  ===================  -->
 
 <h3>Version 2.3.1</h3>
 
 <h4>Bug fixes</h4>
 <ul>
 <li>SaveService no longer needs to instantiate classes</li>
 <li>Bug 43430 - Count of active threads is incorrect for remote samples</li>
 </ul>
 
 <h4>Improvements</h4>
 <ul>
 <li>Add run_gui Ant target, to package and then start the JMeter GUI from Ant</li>
 <li>Add File->Revert to easily drop the current changes and reload the project file currently loaded</li>
 <li>Bug 31366 - Remember recently opened file(s)</li>
 <li>Bug 43351 - Add support for Parameters and script file to all BeanShell test elements</li>
 </ul>
 
 <!--  ===================  -->
 
 <h3>Version 2.3</h3>
 
 <h3>Fixes since 2.3RC4</h3>
 
 <h4>Bug fixes</h4>
 <ul>
 <li>Fix NPE in SampleResultConverter - XStream PrettyPrintWriter cannot handle nulls</li>
 <li>If Java HTTP sampler sees null ResponseMessage, replace with HTTP header</li>
 <li>Bug 43332 - 2.3RC4 does not clear Guis based on TestBean</li>
 <li>Bug 42948 - Problems with Proxy gui table fields in Java 1.6</li>
 <li>Fixup broken jmeter-server script</li>
 <li>Bug 43364 - option to revert If Controller to pre 2.3RC3 behaviour</li>
 <li>Bug 43449 - Statistical Remote mode does not handle Latency</li>
+<li>Bug 43450 (partial fix) - Allow SampleCount to be saved/restored from CSV files</li>
 </ul>
 
 <h4>Improvements</h4>
 <ul>
 <li>Add nameSpace option to XPath extractor</li>
 <li>Add NULL parameter option to JDBC sampler</li>
 <li>Add documentation links for Rhino and BeanShell to functions; clarify variables and properties</li>
 <li>Ensure uncaught exceptions are logged</li>
 <li>Look for user.properties and system.properties in JMeter bin directory if not found locally</li>
 </ul>
 
 <h4>Fixes since 2.3RC3</h4>
 <ul>
 <li>Fixed NPE in Summariser (bug introduced in 2.3RC3)</li>
 <li>Fixed setup of proxy port (bug introduced in 2.3RC3)</li>
 <li>Fixed errors when running non-GUI on a headless host (bug introduced in 2.3RC3)</li>
 <li>Bug 43054 - SSLManager causes stress tests to saturate and crash (bug introduced in 2.3RC3)</li>
 <li>Clarified HTTP Request Defaults usage of the port field</li>
 <li>Bug 43006 - NPE if icon.properties file not found</li>
 <li>Bug 42918 - Size Assertion now treats an empty response as having zero length</li>
 <li>Bug 43007 - Test ends before all threadgroups started</li>
 <li>Fix possible NPE in HTTPSampler2 if 302 does not have Location header.</li>
 <li>Bug 42919 - Failure Message blank in CSV output [now records first non-blank message]</li>
 <li>Add link to Extending JMeter PDF</li>
 <li>Allow for quoted charset in Content-Type parsing</li>
 <li>Bug 39792 - ClientJMeter synchronisation needed</li>
 <li>Bug 43122 - GUI changes not always picked up when short-cut keys used (bug introduced in 2.3RC3)</li>
 <li>Bug 42947 - TestBeanGUI changes not picked up when short-cut keys used</li>
 <li>Added serializer.jar (needed for update to xalan 2.7.0)</li>
 <li>Bug 38687 - Module controller does not work in non-GUI mode</li>
 </ul>
 
 <h4>Improvements since 2.3RC3</h4>
 <ul>
 <li>Add stop thread option to CSV Dataset</li>
 <li>Updated commons-httpclient to 3.1</li>
 <li>Bug 28715 - allow variable cookie values (set CookieManager.allow_variable_cookies=false to disable)</li>
 <li>Bug 40873 - add JMS point-to-point non-persistent delivery option</li>
 <li>Bug 43283 - Save action adds .jmx if not present; checks for existing file on Save As</li>
 <li>Control+A key does not work for Save All As; changed to Control+Shift+S</li>
 <li>Bug 40991 - Allow Assertions to check Headers</li>
 </ul>
 
 <h3>Version 2.3RC3</h3>
 
 <h4>Known problems/restrictions:</h4>
 <p>
 The JMeter remote server does not support multiple concurrent tests - each remote test should be run in a separate server.
 Otherwise tests may fail with random Exceptions, e.g. ConcurrentModification Exception in StandardJMeterEngine.
 See bug 43168.
 </p>
 <p>
 The default HTTP Request (not HTTPClient) sampler may not work for HTTPS connections via a proxy.
 This appears to be due to a Java bug, see <a href="http://issues.apache.org/bugzilla/show_bug.cgi?id=39337">Bug 39337</a>.
 To avoid the problem, try a more recent version of Java, or switch to the HTTPClient version of the HTTP Request sampler.
 </p>
 <p>Transaction Controller parent mode does not support nested Transaction Controllers.
 Doing so may cause a Null Pointer Exception in TestCompiler.
 </p>
 <p>Thread active counts are always zero in CSV and XML files when running remote tests.
 </p>
 <p>The property file_format.testlog=2.1 is treated the same as 2.2.
 However JMeter does honour the 3 testplan versions.</p>
 <p>
 Bug 22510 - JMeter always uses the first entry in the keystore.
 </p>
 <p>
 Remote mode does not work if JMeter is installed in a directory where the path name contains spaces.
 </p>
 <p>
 BeanShell test elements leak memory.
 This can be reduced by using a file instead of including the script in the test element.
 </p>
 <p>
 Variables and functions do not work in Listeners in client-server (remote) mode so they cannot be used
 to name log files in client-server mode.
 </p>
 <p>
 CSV Dataset variables are defined after configuration processing is completed,
 so they cannot be used for other configuration items such as JDBC Config.
 (see <a href="http://issues.apache.org/bugzilla/show_bug.cgi?id=40934">Bug 40394 </a>)
 </p>
 
 <h4>Summary of changes (for more details, see below)</h4>
 <p>
 Some of the main enhancements are:
 </p>
 <ul>
 <li>Htmlparser 2.0 now used for parsing</li>
 <li>HTTP Authorisation now supports domain and realm</li>
 <li>HttpClient options can be specified via httpclient.parameters file</li>
 <li>HttpClient now behaves the same as Java Http for SSL certificates</li>
 <li>HTTP Mirror Server to allow local testing of HTTP samplers</li>
 <li>HTTP Proxy supports XML-RPC recording, and other proxy improvements</li>
 <li>__V() function allows support of nested variable references</li>
 <li>LDAP Ext sampler optionally parses result sets and supports secure mode</li>
 <li>FTP Sampler supports Ascii/Binary mode and upload</li>
 <li>Transaction Controller now optionally generates a Sample with subresults</li>
 <li>HTTPS session contexts are now per-thread, rather than shared. This gives better emulation of multiple users</li>
 <li>BeanShell elements now support ThreadListener and TestListener interfaces</li>
 <li>Coloured icons in Tree View Listener and elsewhere to better differentiate failed samples.</li>
 </ul>
 <p>
 The main bug fixes are:
 </p>
 <ul>
 <li>HTTPS (SSL) handling now much improved</li>
 <li>Various Remote mode bugs fixed</li>
 <li>Control+C and Control+V now work in the test tree</li>
 <li>Latency and Encoding now available in CSV log output</li>
 <li>Test elements no longer default to previous contents; test elements no longer cleared when changing language.</li>
 </ul>
 
 <h4>Incompatible changes (usage):</h4>
 <p>
 <b>N.B. The javax.net.ssl properties have been moved from jmeter.properties to system.properties,
 and will no longer work if defined in jmeter.properties.</b>
 <br></br>
 The new arrangement is more flexible, as it allows arbitrary system properties to be defined.
 </p>
 <p>
 SSL session contexts are now created per-thread, rather than being shared.
 This generates a more realistic load for HTTPS tests.
 The change is likely to slow down tests with many SSL threads.
 The original behaviour can be enabled by setting the JMeter property:
 <pre>
 https.sessioncontext.shared=true
 </pre>
 </p>
 <p>
 The LDAP Extended Sampler now uses the same panel for both Thread Bind and Single-Bind tests.
 This means that any tests using the Single-bind test will need to be updated to set the username and password.
 </p>
 <p>
 Bug 41140: JMeterThread behaviour was changed so that PostProcessors are run in forward order
 (as they appear in the test plan) rather than reverse order as previously.
 The original behaviour can be restored by setting the following JMeter property:
 <br/>
 jmeterthread.reversePostProcessors=true
 </p>
 <p>
 The HTTP Authorisation Manager now has extra columns for domain and realm, 
 so the temporary work-round of using '\' and '@' in the username to delimit the domain and realm
 has been removed.
 </p>
 <p>
 Control-Z no longer used for Remote Start All - this now uses Control+Shift+R
 </p>
 <p>
 HttpClient now uses pre-emptive authentication. 
 This can be changed by setting the following:
 <pre>
 jmeter.properties:
 httpclient.parameters.file=httpclient.parameters
 
 httpclient.parameters:
 http.authentication.preemptive$Boolean=false
 </pre>
 </p>
 
 <p>
 The port field in HTTP Request Defaults is no longer ignored for https samplers if it is set to 80.
 </p>
 
 <h4>Incompatible changes (development):</h4>
 <p>
 <b>N.B.</b>The clear() method was defined in the following interfaces: Clearable, JMeterGUIComponent and TestElement.
 The methods serve different purposes, so two of them were renamed: 
 the Clearable method is now clearData() and the JMeterGUIComponent method is now clearGui().
 3rd party add-ons may need to be rebuilt.
 </p>
 <p>
 Calulator and SamplingStatCalculator classes no longer provide any formatting of their data.
 Formatting should now be done using the jorphan.gui Renderer classes.
 </p>
 <p>
 Removed deprecated method JMeterUtils.split() - use JOrphanUtils version instead.
 </p>
 <p>
 Removed method saveUsingJPEGEncoder() from SaveGraphicsService.
 It was unused so far, and used the only Sun-specific class in JMeter.
 </p>
 
 
 <h4>New functionality/improvements:</h4>
 <ul>
 <li>Add Domain and Realm support to HTTP Authorisation Manager</li>
 <li>HttpClient now behaves the same as the JDK http sampler for invalid certificates etc</li>
 <li>Added httpclient.parameters.file to allow HttpClient parameters to be defined</li>
 <li>Bug 33964 - Http Requests can send a file as the entire post body if name/type are omitted</li>
 <li>Bug 41705 - add content-encoding option to HTTP samplers for POST requests</li>
 <li>Bug 40933, 40945 - optional RE matching when retrieving embedded resource URLs</li>
 <li>Bug 27780 - (patch 19936) create multipart/form-data HTTP request without uploading file</li>
 <li>Bug 42098 - Use specified encoding for parameter values in HTTP GET</li>
 <li>Bug 42506 - JMeter threads now use independent SSL sessions</li>
 <li>Bug 41707 - HTTP Proxy XML-RPC support</li>
 <li>Bug 41880 - Add content-type filtering to HTTP Proxy Server</li>
 <li>Bug 41876 - Add more options to control what the HTTP Proxy generates</li>
 <li>Bug 42158 - Improve support for multipart/form-data requests in HTTP Proxy server</li>
 <li>Bug 42173 - Let HTTP Proxy handle encoding of request, and undecode parameter values</li>
 <li>Bug 42674 - default to pre-emptive HTTP authorisation if not specified</li>
 <li>Support "file" protocol in HTTP Samplers</li>
 <li>Http Autoredirects are now enabled by default when creating new samplers</li>
 
 <li>Bug 40103 - various LDAP enhancements</li>
 <li>Bug 40369 - LDAP: Stable search results in sampler</li>
 <li>Bug 40381 - LDAP: more descriptive strings</li>
 
 <li>BeanShell Post-Processor no longer ignores samples with zero-length result data</li>
 <li>Added beanshell.init.file property to run a BeanShell script at startup</li>
 <li>Bug 39864 - BeanShell init files now found from currrent or bin directory</li>
 <li>BeanShell elements now support ThreadListener and TestListener interfaces</li>
 <li>BSF Sampler passes additional variables to the script</li>
 
 <li>Added timeout for WebService (SOAP) Sampler</li>
 
 <li>Bug 40825 - Add JDBC prepared statement support</li>
 <li>Extend JDBC Sampler: Commit, Rollback, AutoCommit</li>
 
 <li>Bug 41457 - Add TCP Sampler option to not re-use connections</li>
 
 <li>Bug 41522 - Use JUnit sampler name in sample results</li>
 
 <li>Bug 42223 - FTP Sampler can now upload files</li>
 
 <li>Bug 40804 - Change Counter default to max = Long.MAX_VALUE</li>
 
 <li>Use property jmeter.home (if present) to override user.dir when starting JMeter</li>
 <li>New -j option to easily change jmeter log file</li>
 
 <li>HTTP Mirror Server Workbench element</li>
 
 <li>Bug 41253 - extend XPathExtractor to work with non-NodeList XPath expressions</li>
 <li>Bug 42088 - Add XPath Assertion for booleans</li>
 
 <li>Added __V variable function to resolve nested variable names</li>
 
 <li>Bug 40369 - Equals Response Assertion</li>
 <li>Bug 41704 - Allow charset encoding to be specified for CSV DataSet</li>
 <li>Bug 41259 - Comment field added to all test elements</li>
 <li>Add standard deviation to Summary Report</li>
 <li>Bug 41873 - Add name to AssertionResult and display AssertionResult in ViewResultsFullVisualizer</li>
 <li>Bug 36755 - Save XML test files with UTF-8 encoding</li>
 <li>Use ISO date-time format for Tree View Listener (previously the year was not shown)</li>
 <li>Improve loading of CSV files: if possible, use header to determine format; guess timestamp format if not milliseconds</li>
 <li>Bug 41913 - TransactionController now creates samples as sub-samples of the transaction</li>
 <li>Bug 42582 - JSON pretty printing in Tree View Listener</li>
 <li>Bug 40099 - Enable use of object variable in ForEachController</li>
 
 <li>Bug 39693 - View Result Table uses icon instead of check box</li>
 <li>Bug 39717 - use icons in the results tree</li>
 <li>Bug 42247 - improve HCI</li>
 <li>Allow user to cancel out of Close dialogue</li>
 </ul>
 
 <h4>Non-functional improvements:</h4>
 <ul>
 <li>Functor calls can now be unit tested</li>
 <li>Replace com.sun.net classes with javax.net</li>
 <li>Extract external jar definitions into build.properties file</li>
 <li>Use specific jar names in build classpaths so errors are detected sooner</li>
 <li>Tidied up ORO calls; now only one cache, size given by oro.patterncache.size, default 1000</li>
 <li>Bug 42326 - Order of elements in .jmx files changes</li>
 </ul>
 
 <h4>External jar updates:</h4>
 <ul>
 <li>Htmlparser 2.0-20060923</li>
 <li>xstream 1.2.1/xpp3_min-1.1.3.4.O</li>
 <li>Batik 1.6</li>
 <li>BSF 2.4.0</li>
 <li>commons-collections 3.2</li>
 <li>commons-httpclient-3.1-rc1</li>
 <li>commons-jexl 1.1</li>
 <li>commons-lang-2.3 (added)</li>
 <li>JUnit 3.8.2</li>
 <li>velocity 1.5</li>
 <li>commons-io 1.3.1 (added)</li>
 </ul>
 
 <h4>Bug fixes:</h4>
 <ul>
 <li>Bug 39773 - NTLM now needs local host name - fix other call</li>
 <li>Bug 40438 - setting "httpclient.localaddress" has no effect</li>
 <li>Bug 40419 - Chinese messages translation fix</li>
 <li>Bug 39861 - fix typo</li>
 <li>Bug 40562 - redirects no longer invoke RE post processors</li>
 <li>Bug 40451 - set label if not set by sampler</li>
 <li>Fix NPE in CounterConfig.java in Remote mode</li>
 <li>Bug 40791 - Calculator used by Summary Report</li>
 <li>Bug 40772 - correctly parse missing fields in CSV log files</li>
 <li>Bug 40773 - XML log file timestamp not parsed correctly</li>
 <li>Bug 41029 - JMeter -t fails to close input JMX file</li>
 <li>Bug 40954 - Statistical mode in distributed testing shows wrong results</li>
 <li>Fix ClassCast Exception when using sampler that returns null, e..g TestAction</li>
 <li>Bug 41140 - Post-processors are run in reverse order</li>
 <li>Bug 41277 - add Latency and Encoding to CSV output</li>
 <li>Bug 41414 - Mac OS X may add extra item to -jar classpath</li>
 <li>Fix NPE when saving thread counts in remote testing</li>
 <li>Bug 34261 - NPE in HtmlParser (allow for missing attributes)</li>
 <li>Bug 40100 - check FileServer type before calling close</li>
 <li>Bug 39887 - jmeter.util.SSLManager: Couldn't load keystore error message</li>
 <li>Bug 41543 - exception when webserver returns "500 Internal Server Error" and content-length is 0</li>
 <li>Bug 41416 - don't use chunked input for text-box input in SOAP-RPC sampler</li>
 <li>Bug 39827 - SOAP Sampler content length for files</li>
 <li>Fix Class cast exception in Clear.java</li>
 <li>Bug 40383 - don't set content-type if already set</li>
 <li>Mailer Visualiser test button now works if test plan has not yet been saved</li>
 <li>Bug 36959 - Shortcuts "ctrl c" and "ctrl v" don't work on the tree elements</li>
 <li>Bug 40696 - retrieve embedded resources from STYLE URL() attributes</li>
 <li>Bug 41568 - Problem when running tests remotely when using a 'Counter'</li>
 <li>Fixed various classes that assumed timestamps were always end time stamps:
 <ul>
 <li>SamplingStatCalculator</li>
 <li>JTLData</li>
 <li>RunningSample</li>
 </ul>
 </li>
 <li>Bug 40325 - allow specification of proxyuser and proxypassword for WebServiceSampler</li>
 <li>Change HttpClient proxy definition to use NTCredentials; added http.proxyDomain property for this</li>
 <li>Bug 40371 - response assertion "pattern to test" scrollbar problem</li>
 <li>Bug 40589 - Unescape XML entities in embedded URLs</li>
 <li>Bug 41902 - NPE in HTTPSampler when responseCode = -1</li>
 <li>Bug 41903 - ViewResultsFullVisualizer : status column looks bad when you do copy and paste</li>
 <li>Bug 41837 - Parameter value corruption in proxy</li>
 <li>Bug 41905 - Can't cut/paste/select Header Manager fields in Java 1.6</li>
 <li>Bug 41928 - Make all request headers sent by HTTP Request sampler appear in sample result</li>
 <li>Bug 41944 - Subresults not handled recursively by ResultSaver</li>
 <li>Bug 42022 - HTTPSampler does not allow multiple headers of same name</li>
 <li>Bug 42019 - Content type not stored in redirected HTTP request with subresults</li>
 <li>Bug 42057 - connection can be null if method is null</li>
 <li>Bug 41518 - JMeter changes the HTTP header Content Type for POST request</li>
 <li>Bug 42156 - HTTPRequest HTTPClient incorrectly urlencodes parameter value in POST</li>
 <li>Bug 42184 - Number of bytes for subsamples not added to sample when sub samples are added</li>
 <li>Bug 42185 - If a HTTP Sampler follows a redirect, and is set up to download images, then images are downloaded multiple times</li>
 <li>Bug 39808 - Invalid redirect causes incorrect sample time</li>
 <li>Bug 42267 - Concurrent GUI update failure in Proxy Recording</li>
 <li>Bug 30120 - Name of simple controller is resetted if a new simple controller is added as child</li>
 <li>Bug 41078 - merge results in name change of test plan</li>
 <li>Bug 40077 - Creating new Elements copies values from Existing elements</li>
 <li>Bug 42325 - Implement the "clear" method for the LogicControllers</li>
 <li>Bug 25441 - TestPlan changes sometimes detected incorrectly (isDirty)</li>
 <li>Bug 39734 - Listeners shared after copy/paste operation</li>
 <li>Bug 40851 - Loop controller with 0 iterations, stops evaluating the iterations field</li>
 <li>Bug 24684 - remote startup problems if spaces in the path of the jmeter</li>
 <li>Use Listener configuration when loading CSV data files</li>
 <li>Function methods setParameters() need to be synchronized</li>
 <li>Fix CLI long optional argument to require "=" (as for short options)</li>
 <li>Fix SlowSocket to work properly with Httpclient (both http and https)</li>
 <li>Bug 41612 - Loop nested in If Controller behaves erratically</li>
 <li>Bug 42232 - changing language clears UDV contents</li>
 <li>Jexl function did not allow variables</li>
 </ul>
 
 <h3>Version 2.2</h3>
 
 <h4>Incompatible changes:</h4>
 <p>
 The time stamp is now set to the sampler start time (it was the end).
 To revert to the previous behaviour, change the property <b>sampleresult.timestamp.start</b> to false (or comment it)
 </p>
 <p>The JMX output format has been simplified and files are not backwards compatible</p>
 <p>
 The JMeter.BAT file no longer changes directory to JMeter home, but runs from the current working directory.
 The jmeter-n.bat and jmeter-t.bat files change to the directory containing the input file.
 </p>
 <p>
 Listeners are now started slightly later in order to allow variable names to be used.
 This may cause some problems; if so define the following in jmeter.properties:
 <br/>
 jmeterengine.startlistenerslater=false
 </p>
 
 <h4>Known problems:</h4>
 <ul>
 <li>Post-processors run in reverse order (see bug 41140)</li>
 <li>Module Controller does not work in non-GUI mode</li>
 <li>Aggregate Report and some other listeners use increasing amounts of memory as a test progresses</li>
 <li>Does not always handle non-default encoding properly</li>
 <li>Spaces in the installation path cause problems for client-server mode</li>
 <li>Change of Language does not propagate to all test elements</li>
 <li>SamplingStatCalculator keeps a List of all samples for calculation purposes; 
 this can cause memory exhaustion in long-running tests</li>
 <li>Does not properly handle server certificates if they are expired or not installed locally</li>
 </ul>
 
 <h4>New functionality:</h4>
 <ul>
 <li>Report function</li>
 <li>XPath Extractor Post-Processor. Handles single and multiple matches.</li>
 <li>Simpler JMX file format (2.2)</li>
 <li>BeanshellSampler code can update ResponseData directly</li>
 <li>Bug 37490 - Allow UDV as delay in Duration Assertion</li>
 <li>Slow connection emulation for HttpClient</li>
 <li>Enhanced JUnitSampler so that by default assert errors and exceptions are not appended to the error message. 
 Users must explicitly check append in the sampler</li>
 <li>Enhanced the documentation for webservice sampler to explain how it works with CSVDataSet</li>
 <li>Enhanced the documentation for javascript function to explain escaping comma</li>
 <li>Allow CSV Data Set file names to be absolute</li>
 <li>Report Tree compiler errors better</li>
 <li>Don't reset Regex Extractor variable if default is empty</li>
 <li>includecontroller.prefix property added</li>
 <li>Regular Expression Extractor sets group count</li>
 <li>Can now save entire screen as an image, not just the right-hand pane</li>
 <li>Bug 38901 - Add optional SOAPAction header to SOAP Sampler</li>
 <li>New BeanShell test elements: Timer, PreProcessor, PostProcessor, Listener</li>
 <li>__split() function now clears next variable, so it can be used with ForEach Controller</li>
 <li>Bug 38682 - add CallableStatement functionality to JDBC Sampler</li>
 <li>Make it easier to change the RMI/Server port</li>
 <li>Add property jmeter.save.saveservice.xml_pi to provide optional xml processing instruction in JTL files</li>
 <li>Add bytes and URL to items that can be saved in sample log files (XML and CSV)</li>
 <li>The Post-Processor "Save Responses to a File" now saves the generated file name with the
 sample, and the file name can be included in the sample log file.
 </li>
 <li>Change jmeter.bat DOS script so it works from any directory</li>
 <li>New -N option to define nonProxyHosts from command-line</li>
 <li>New -S option to define system properties from input file</li>
 <li>Bug 26136 - allow configuration of local address</li>
 <li>Expand tree by default when loading a test plan - can be disabled by setting property onload.expandtree=false</li>
 <li>Bug 11843 - URL Rewriter can now cache the session id</li>
 <li>Counter Pre-Processor now supports formatted numbers</li>
 <li>Add support for HEAD PUT OPTIONS TRACE and DELETE methods</li>
 <li>Allow default HTTP implementation to be changed</li>
 <li>Optionally save active thread counts (group and all) to result files</li>
 <li>Variables/functions can now be used in Listener file names</li>
 <li>New __time() function; define START.MS/START.YMD/START.HMS properties and variables</li>
 <li>Add Thread Name to Tree and Table Views</li>
 <li>Add debug functions: What class, debug on, debug off</li>
 <li>Non-caching Calculator - used by Table Visualiser to reduce memory footprint</li>
 <li>Summary Report - similar to Aggregate Report, but uses less memory</li>
 <li>Bug 39580 - recycle option for CSV Dataset</li>
 <li>Bug 37652 - support for Ajp Tomcat protocol</li>
 <li>Bug 39626 - Loading SOAP/XML-RPC requests from file</li>
 <li>Bug 39652 - Allow truncation of labels on AxisGraph</li>
 <li>Allow use of htmlparser 1.6</li>
 <li>Bug 39656 - always use SOAP action if it is provided</li>
 <li>Automatically include properties from user.properties file</li>
 <li>Add __jexl() function - evaluates Commons JEXL expressions</li>
 <li>Optionally load JMeter properties from user.properties and system properties from system.properties.</li>
 <li>Bug 39707 - allow Regex match against URL</li>
 <li>Add start time to Table Visualiser</li>
 <li>HTTP Samplers can now extract embedded resources for any required media types</li>
 </ul>
 
 <h4>Bug fixes:</h4>
 <ul>
 <li>Fix NPE when no module selected in Module Controller</li>
 <li>Fix NPE in XStream when no ResponseData present</li>
 <li>Remove ?xml prefix when running with Java 1.5 and no x-jars</li>
 <li>Bug 37117 - setProperty() function should return ""; added optional return of original setting</li>
 <li>Fix CSV output time format</li>
 <li>Bug 37140 - handle encoding better in RegexFunction</li>
 <li>Load all cookies, not just the first; fix class cast exception</li>
 <li>Fix default Cookie path name (remove page name)</li>
 <li>Fixed resultcode attribute name</li>
 <li>Bug 36898 - apply encoding to RegexExtractor</li>
 <li>Add properties for saving subresults, assertions, latency, samplerData, responseHeaders, requestHeaders &amp; encoding</li>
 <li>Bug 37705 - Synch Timer now works OK after run is stopped</li>
 <li>Bug 37716 - Proxy request now handles file Post correctly</li>
 <li>HttpClient Sampler now saves latency</li>
 <li>Fix NPE when using JavaScript function on Test Plan</li>
 <li>Fix Base Href parsing in htmlparser</li>
 <li>Bug 38256 - handle cookie with no path</li>
 <li>Bug 38391 - use long when accumulating timer delays</li>
 <li>Bug 38554 - Random function now uses long numbers</li>
 <li>Bug 35224 - allow duplicate attributes for LDAP sampler</li>
 <li>Bug 38693 - Webservice sampler can now use https protocol</li>
 <li>Bug 38646 - Regex Extractor now clears old variables on match failure</li>
 <li>Bug 38640 - fix WebService Sampler pooling</li>
 <li>Bug 38474 - HTML Link Parser doesn't follow frame links</li>
 <li>Bug 36430 - Counter now uses long rather than int to increase the range</li>
 <li>Bug 38302 - fix XPath function</li>
 <li>Bug 38748 - JDBC DataSourceElement fails with remote testing</li>
 <li>Bug 38902 - sometimes -1 seems to be returned unnecessarily for response code</li>
 <li>Bug 38840 - make XML Assertion thread-safe</li>
 <li>Bug 38681 - Include controller now works in non-GUI mode</li>
 <li>Add write(OS,IS) implementation to TCPClientImpl</li>
 <li>Sample Result converter saves response code as "rc". Previously it saved as "rs" but read with "rc"; it will now also read with "rc".
 The XSL stylesheets also now accept either "rc" or "rs"</li>
 <li>Fix counter function so each counter instance is independent (previously the per-user counters were shared between instances of the function)</li>
 <li>Fix TestBean Examples so that they work</li>
 <li>Fix JTidy parser so it does not skip body tags with background images</li>
 <li>Fix HtmlParser parser so it catches all background images</li>
 <li>Bug 39252 set SoapSampler sample result from XML data</li>
 <li>Bug 38694 - WebServiceSampler not setting data encoding correctly</li>
 <li>Result Collector now closes input files read by listeners</li>
 <li>Bug 25505 - First HTTP sampling fails with "HTTPS hostname wrong: should be 'localhost'"</li>
 <li>Bug 25236 - remove double scrollbar from Assertion Result Listener</li>
 <li>Bug 38234 - Graph Listener divide by zero problem</li>
 <li>Bug 38824 - clarify behaviour of Ignore Status</li>
 <li>Bug 38250 - jmeter.properties "language" now supports country suffix, for zh_CN and zh_TW etc</li>
 <li>jmeter.properties file is now closed after it has been read</li>
 <li>Bug 39533 - StatCalculator added wrong items</li>
 <li>Bug 39599 - ConcurrentModificationException</li>
 <li>HTTPSampler2 now handles Auto and Follow redirects correctly</li>
 <li>Bug 29481 - fix reloading sample results so subresults not counted twice</li>
 <li>Bug 30267 - handle AutoRedirects properly</li>
 <li>Bug 39677 - allow for space in JMETER_BIN variable</li>
 <li>Use Commons HttpClient cookie parsing and management. Fix various problems with cookie handling.</li>
 <li>Bug 39773 - NTCredentials needs host name</li>
 </ul>	
 	
 <h4>Other changes</h4>
 <ul>
 <li>Updated to HTTPClient 3.0 (from 2.0)</li>
 <li>Updated to Commons Collections 3.1</li>
 <li>Improved formatting of Request Data in Tree View</li>
 <li>Expanded user documentation</li>
 <li>Added MANIFEST, NOTICE and LICENSE to all jars</li>
 <li>Extract htmlparser interface into separate jarfile to make it possible to replace the parser</li>
 <li>Removed SQL Config GUI as no longer needed (or working!)</li>
 <li>HTTPSampler no longer logs a warning for Page not found (404)</li>
 <li>StringFromFile now callable as __StringFromFile (as well as _StringFromFile)</li>
 <li>Updated to Commons Logging 1.1</li>
 </ul>
 
 <!--  ===================  -->
 
 
 <hr/>
 <h3>Version 2.1.1</h3>
 <h4>New functionality:</h4>
 <ul>
 <li>New Include Controller allows a test plan to reference an external jmx file</li>
 <li>New JUnitSampler added for using JUnit Test classes</li>
 <li>New Aggregate Graph listener is capable of graphing aggregate statistics</li>
 <li>Can provide additional classpath entries using the property user.classpath and on the Test Plan element</li>
 </ul>
 <h4>Bug fixes:</h4>
 <ul>
 <li>AccessLog Sampler and JDBC test elements populated correctly from 2.0 test plans</li>
 <li>BSF Sampler now populates filename and parameters from saved test plan</li>
 <li>Bug 36500 - handle missing data more gracefully in WebServiceSampler</li>
 <li>Bug 35546 - add merge to right-click menu</li>
 <li>Bug 36642 - Summariser stopped working in 2.1</li>
 <li>Bug 36618 - CSV header line did not match saved data</li>
 <li>JMeter should now run under JVM 1.3 (but does not build with 1.3)</li>
 </ul>	
 	
 
 <!--  ===================  -->
 
 <h3>Version 2.1</h3>
 <h4>New functionality:</h4>
 <ul>
 <li>New Test Script file format - smaller, more compact, more readable</li>
 <li>New Sample Result file format - smaller, more compact</li>
 <li>XSchema Assertion</li>
 <li>XML Tree display</li>
 <li>CSV DataSet Config item</li>
 <li>New JDBC Connection Pool Config Element</li>
 <li>Synchronisation Timer</li>
 <li>setProperty function</li>
 <li>Save response data on error</li>
 <li>Ant JMeter XSLT now optionally shows failed responses and has internal links</li>
 <li>Allow JavaScript variable name to be omitted</li>
 <li>Changed following Samplers to set sample label from sampler name</li>
 <li>All Test elements can be saved as a graphics image to a file</li>
 <li>Bug 35026 - add RE pattern matching to Proxy</li>
 <li>Bug 34739 - Enhance constant Throughput timer</li>
 <li>Bug 25052 - use response encoding to create comparison string in Response Assertion</li>
 <li>New optional icons</li>
 <li>Allow icons to be defined via property files</li>
 <li>New stylesheets for 2.1 format XML test output</li>
 <li>Save samplers, config element and listeners as PNG</li>
 <li>Enhanced support for WSDL processing</li>
 <li>New JMS sampler for topic and queue messages</li>
 <li>How-to for JMS samplers</li>
 <li>Bug 35525 - Added Spanish localisation</li>
 <li>Bug 30379 - allow server.rmi.port to be overridden</li>
 <li>enhanced the monitor listener to save the calculated stats</li>
 <li>Functions and variables now work at top level of test plan</li>
 </ul>
 <h4>Bug fixes:</h4>
 <ul>
 <li>Bug 34586 - XPath always remained as /</li>
 <li>BeanShellInterpreter did not handle null objects properly</li>
 <li>Fix Chinese resource bundle names</li>
 <li>Save field names if required to CSV files</li>
 <li>Ensure XML file is closed</li>
 <li>Correct icons now displayed for TestBean components</li>
 <li>Allow for missing optional jar(s) in creating menus</li>
 <li>Changed Samplers to set sample label from sampler name as was the case for HTTP</li>
 <li>Fix various samplers to avoid NPEs when incomplete data is provided</li>
 <li>Fix Cookie Manager to use seconds; add debug</li>
 <li>Bug 35067 - set up filename when using -t option</li>
 <li>Don't substitute TestElement.* properties by UDVs in Proxy</li>
 <li>Bug 35065 - don't save old extensions in File Saver</li>
 <li>Bug 25413 - don't enable Restart button unnecessarily</li>
 <li>Bug 35059 - Runtime Controller stopped working</li>
 <li>Clear up any left-over connections created by LDAP Extended Sampler</li>
 <li>Bug 23248 - module controller didn't remember stuff between save and reload</li>
 <li>Fix Chinese locales</li>
 <li>Bug 29920 - change default locale if necessary to ensure default properties are picked up when English is selected.</li>
 <li>Bug fixes for Tomcat monitor captions</li> 
 <li>Fixed webservice sampler so it works with user defined variables</li>
 <li>Fixed screen borders for LDAP config GUI elements</li>
 <li>Bug 31184 - make sure encoding is specified in JDBC sampler</li>
 <li>TCP sampler - only share sockets with same host:port details; correct the manual</li>
 <li>Extract src attribute for embed tags in JTidy and Html Parsers</li>
 </ul>	
 
 <!--  ===================  -->
 
 <h3>Version 2.0.3</h3>
 <h4>New functionality:</h4>
 <ul>
 <li>XPath Assertion and XPath Function</li>
 <li>Switch Controller</li>
 <li>ForEach Controller can now loop through sets of groups</li>
 <li>Allow CSVRead delimiter to be changed (see jmeter.properties)</li>
 <li>Bug 33920 - allow additional property files</li>
 <li>Bug 33845 - allow direct override of Home dir</li>
 </ul>
 <h4>Bug fixes:</h4>
 <ul>
 <li>Regex Extractor nested constant not put in correct place (32395)</li>
 <li>Start time reset to now if necessary so that delay works OK.</li>
 <li>Missing start/end times in scheduler are assumed to be now, not 1970</li>
 <li>Bug 28661 - 304 responses not appearing in listeners</li>
 <li>DOS scripts now handle different disks better</li>
 <li>Bug 32345 - HTTP Rewriter does not work with HTTP Request default</li>
 <li>Catch Runtime Exceptions so an error in one Listener does not affect others</li>
 <li>Bug 33467 - __threadNum() extracted number wrongly </li>
 <li>Bug 29186,33299 - fix CLI parsing of "-" in second argument</li>
 <li>Fix CLI parse bug: -D arg1=arg2. Log more startup parameters.</li>
 <li>Fix JTidy and HTMLParser parsers to handle form src= and link rel=stylesheet</li>
 <li>JMeterThread now logs Errors to jmeter.log which were appearing on console</li>
 <li>Ensure WhileController condition is dynamically checked</li>
 <li>Bug 32790 ensure If Controller condition is re-evaluated each time</li>
 <li>Bug 30266 - document how to display proxy recording responses</li>
 <li>Bug 33921 - merge should not change file name</li>
 <li>Close file now gives chance to save changes</li>
 <li>Bug 33559 - fixes to Runtime Controller</li>
 </ul>
 <h4>Other changes:</h4>
 <ul>
 <li>To help with variable evaluation, JMeterThread sets "sampling started" a bit earlier (see jmeter.properties)</li>
 <li>Bug 33796 - delete cookies with null/empty values</li>
 <li>Better checking of parameter count in JavaScript function</li>
 <li>Thread Group now defaults to 1 loop instead of forever</li>
 <li>All Beanshell access is now via a single class; only need BSH jar at run-time</li>
 <li>Bug 32464 - document Direct Draw settings in jmeter.bat</li>
 <li>Bug 33919 - increase Counter field sizes</li>
 <li>Bug 32252 - ForEach was not initialising counters</li>
 </ul>
 
 <!--  ===================  -->
 
 <h3>Version 2.0.2</h3>
 <h4>New functionality:</h4>
 <ul>
 <li>While Controller</li>
 <li>BeanShell intilisation scripts</li>
 <li>Result Saver can optionally save failed results only</li>
 <li>Display as HTML has option not to download frames and images etc</li>
 <li>Multiple Tree elements can now be enabled/disabled/copied/pasted at once</li>
 <li>__split() function added</li>
 <li>(28699) allow Assertion to regard unsuccessful responses - e.g. 404 - as successful</li>
 <li>(29075) Regex Extractor can now extract data out of http response header as well as the body</li>
 <li>__log() functions can now write to stdout and stderr</li>
 <li>URL Modifier can now optionally ignore query parameters</li>
 </ul>
 <h4>Bug fixes:</h4>
 <ul>
 <li>If controller now works after the first false condition (31390)</li>
 <li>Regex GUI was losing track of Header/Body checkbox (29853)</li>
 <li>Display as HTML now handles frames and relative images</li>
 <li>Right-click open replaced by merge</li>
 <li>Fix some drag and drop problems</li>
 <li>Fixed foreach demo example so it works</li>
 <li>(30741) SSL password prompt now works again </li>
 <li>StringFromFile now closes files at end of test; start and end now optional as intended</li>
 <li>(31342) Fixed text of SOAP Sampler headers</li>
 <li>Proxy must now be stopped before it can be removed (25145)</li>
 <li>Link Parser now supports BASE href (25490)</li>
 <li>(30917) Classfinder ignores duplicate names</li>
 <li>(22820) Allow Counter value to be cleared</li>
 <li>(28230) Fix NPE in HTTP Sampler retrieving embedded resources</li>
 <li>Improve handling of StopTest; catch and log some more errors</li>
 <li>ForEach Controller no longer runs any samples if first variable is not defined</li>
 <li>(28663) NPE in remote JDBC execution</li>
 <li>(30110) Deadlock in stopTest processing</li>
 <li>(31696) Duration not working correctly when using Scheduler</li>
 <li>JMeterContext now uses ThreadLocal - should fix some potential NPE errors</li>
 </ul>
 <h3>Version 2.0.1</h3>
 <p>Bug fix release. TBA.</p>
 <h3>Version 2.0</h3>
 <ul>
 	<li>HTML parsing improved; now has choice of 3 parsers, and most embedded elements can now be detected and downloaded.</li>
 <li>Redirects can now be delegated to URLConnection by defining the JMeter property HTTPSamper.delegateRedirects=true (default is false) </li>
 <li>Stop Thread and Stop Test methods added for Samplers and Assertions etc. Samplers can call setStopThread(true) or setStopTest(true) if they detect an error that needs to stop the thread of the test after the sample has been processed </li>
 <li>Thread Group Gui now has an extra pane to specify what happens after a Sampler error: Continue (as now), Stop Thread or Stop Test. 
     This needs to be extended to a lower level at some stage. </li>
 <li>Added Shutdown to Run Menu. This is the same as Stop except that it lets the Threads finish normally (i.e. after the next sample has been completed) </li>
 <li>Remote samples can be cached until the end of a test by defining the property hold_samples=true when running the server.
 More work is needed to be able to control this from the GUI </li>
 <li>Proxy server has option to skip recording browser headers </li>
 <li>Proxy restart works better (stop waits for daemon to finish) </li>
 <li>Scheduler ignores start if it has already passed </li>
 <li>Scheduler now has delay function </li>
 <li>added Summariser test element (mainly for non-GUI) testing. This prints summary statistics to System.out and/or the log file every so oftem (3 minutes by default). Multiple summarisers can be used; samples are accumulated by summariser name. </li>
 <li>Extra Proxy Server options: 
 Create all samplers with keep-alive disabled 
 Add Separator markers between sets of samples 
 Add Response Assertion to first sampler in each set </li>
 <li>Test Plan has a comment field</li>
 	
 	<li>Help Page can now be pushed to background</li>
 	<li>Separate Function help page</li>
 	<li>New / amended functions</li>
 	<ul>
 	  <li>__property() and __P() functions</li>
 	  <li>__log() and __logn() - for writing to the log file</li>
       <li>_StringFromFile can now process a sequence of files, e.g. dir/file01.txt, dir/file02.txt etc </li>
       <li>_StringFromFile() funtion can now use a variable or function for the file name </li>
 	</ul>
 	<li>New / amended Assertions</li>
 	<ul>
         <li>Response Assertion now works for URLs, and it handles null data better </li>
         <li>Response Assertion can now match on Response Code and Response message as well </li>
 		<li>HTML Assertion using JTidy to check for well-formed HTML</li>
 	</ul>
 	<li>If Controller (not fully functional yet)</li>
 	<li>Transaction Controller (aggregates the times of its children)</li>
 	<li>New Samplers</li>
 		<ul>
 			<li>Basic BSF Sampler (optional)</li>
 			<li>BeanShell Sampler (optional, needs to be downloaded from www.beanshell.org</li>
 			<li>Basic TCP Sampler</li>
 		</ul>
      <li>Optionally start BeanShell server (allows remote access to JMeter variables and methods) </li>
 </ul>
 <h3>Version 1.9.1</h3>
 <p>TBA</p>
 <h3>Version 1.9</h3>
 <ul>
 <li>Sample result log files can now be in CSV or XML format</li>
 <li>New Event model for notification of iteration events during test plan run</li>
 <li>New Javascript function for executing arbitrary javascript statements</li>
 <li>Many GUI improvements</li>
 <li>New Pre-processors and Post-processors replace Modifiers and Response-Based Modifiers. </li>
 <li>Compatible with jdk1.3</li>
 <li>JMeter functions are now fully recursive and universal (can use functions as parameters to functions)</li>
 <li>Integrated help window now supports hypertext links</li>
 <li>New Random Function</li>
 <li>New XML Assertion</li>
 <li>New LDAP Sampler (alpha code)</li>
 <li>New Ant Task to run JMeter (in extras folder)</li>
 <li>New Java Sampler test implementation (to assist developers)</li>
 <li>More efficient use of memory, faster loading of .jmx files</li>
 <li>New SOAP Sampler (alpha code)</li>
 <li>New Median calculation in Graph Results visualizer</li>
 <li>Default config element added for developer benefit</li>
 <li>Various performance enhancements during test run</li>
 <li>New Simple File recorder for minimal GUI overhead during test run</li>
 <li>New Function: StringFromFile - grabs values from a file</li>
 <li>New Function: CSVRead - grabs multiple values from a file</li>
 <li>Functions now longer need to be encoded - special values should be escaped 
 with "\" if they are literal values</li>
 <li>New cut/copy/paste functionality</li>
 <li>SSL testing should work with less user-fudging, and in non-gui mode</li>
 <li>Mailer Model works in non-gui mode</li>
 <li>New Througput Controller</li>
 <li>New Module Controller</li>
 <li>Tests can now be scheduled to run from a certain time till a certain time</li>
 <li>Remote JMeter servers can be started from a non-gui client.  Also, in gui mode, all remote servers can be started with a single click</li>
 <li>ThreadGroups can now be run either serially or in parallel (default)</li>
 <li>New command line options to override properties</li>
 <li>New Size Assertion</li>
 
 </ul>
 
 <h3>Version 1.8.1</h3>
 <ul>
 <li>Bug Fix Release.  Many bugs were fixed.</li>
 <li>Removed redundant "Root" node from test tree.</li>
 <li>Re-introduced Icons in test tree.</li>
 <li>Some re-organization of code to improve build process.</li>
 <li>View Results Tree has added option to view results as web document (still buggy at this point).</li>
 <li>New Total line in Aggregate Listener (still buggy at this point).</li>
 <li>Improvements to ability to change JMeter's Locale settings.</li>
 <li>Improvements to SSL Manager.</li>
 </ul>
 
 <h3>Version 1.8</h3>
 <ul>
 <li>Improvement to Aggregate report's calculations.</li>
 <li>Simplified application logging.</li>
 <li>New Duration Assertion.</li>
 <li>Fixed and improved Mailer Visualizer.</li>
 <li>Improvements to HTTP Sampler's recovery of resources (sockets and file handles).</li>
 <li>Improving JMeter's internal handling of test start/stop.</li>
 <li>Fixing and adding options to behavior of Interleave and Random Controllers.</li>
 <li>New Counter config element.</li>
 <li>New User Parameters config element.</li>
 <li>Improved performance of file opener.</li>
 <li>Functions and other elements can access global variables.</li>
 <li>Help system available within JMeter's GUI.</li>
 <li>Test Elements can be disabled.</li>
 <li>Language/Locale can be changed while running JMeter (mostly).</li>
 <li>View Results Tree can be configured to record only errors.</li>
 <li>Various bug fixes.</li>
 </ul>
 
 <b>Changes: for more info, contact <a href="mailto:mstover1@apache.org">Michael Stover</a></b>
 <h3>Version 1.7.3</h3>
 <ul>
 <li>New Functions that provide more ability to change requests dynamically during test runs.</li>
 <li>New language translations in Japanese and German.</li>
 <li>Removed annoying Log4J error messages.</li>
 <li>Improved support for loading JMeter 1.7 version test plan files (.jmx files).</li>
 <li>JMeter now supports proxy servers that require username/password authentication.</li>
 <li>Dialog box indicating test stopping doesn't hang JMeter on problems with stopping test.</li>
 <li>GUI can run multiple remote JMeter servers (fixes GUI bug that prevented this).</li>
 <li>Dialog box to help created function calls in GUI.</li>
 <li>New Keep-alive switch in HTTP Requests to indicate JMeter should or should not use Keep-Alive for sockets.</li>
 <li>HTTP Post requests can have GET style arguments in Path field.  Proxy records them correctly now.</li>
 <li>New User-defined test-wide static variables.</li>
 <li>View Results Tree now displays more information, including name of request (matching the name
 in the test tree) and full request and POST data.</li>
 <li>Removed obsolete View Results Visualizer (use View Results Tree instead).</li>
 <li>Performance enhancements.</li>
 <li>Memory use enhancements.</li>
 <li>Graph visualizer GUI improvements.</li>
 <li>Updates and fixes to Mailer Visualizer.</li>
 </ul>
  
 <h3>Version 1.7.2</h3>
 <ul>
 <li>JMeter now notifies user when test has stopped running.</li>
 <li>HTTP Proxy server records HTTP Requests with re-direct turned off.</li>
 <li>HTTP Requests can be instructed to either follow redirects or ignore them.</li>
 <li>Various GUI improvements.</li>
 <li>New Random Controller.</li>
 <li>New SOAP/XML-RPC Sampler.</li>
 </ul>
 
 <h3>Version 1.7.1</h3>
 <ul>
 <li>JMeter's architecture revamped for a more complete separation between GUI code and
 test engine code.</li>
 <li>Use of Avalon code to save test plans to XML as Configuration Objects</li>
 <li>All listeners can save data to file and load same data at later date.</li>
 </ul>
 
 <h3>Version 1.7Beta</h3> 
 <ul> 
 	<li>Better XML support for special characters (Tushar Bhatia) </li> 
 	<li>Non-GUI functioning  &amp; Non-GUI test plan execution  (Tushar Bhatia)</li> 
 	<li>Removing Swing dependence from base JMeter classes</li> 
 	<li>Internationalization (Takashi Okamoto)</li> 
 	<li>AllTests bug fix (neth6@atozasia.com)</li> 
 	<li>ClassFinder bug fix (neth6@atozasia.com)</li> 
 	<li>New Loop Controller</li> 
 	<li>Proxy Server records HTTP samples from browser 
 		(and documented in the user manual)</li> <li>Multipart Form support</li> 
 	<li>HTTP Header class for Header customization</li> 
 	<li>Extracting HTTP Header information from responses (Jamie Davidson)</li> 
 	<li>Mailer Visualizer re-added to JMeter</li> 
 	<li>JMeter now url encodes parameter names and values</li> 
 	<li>listeners no longer give exceptions if their gui's haven't been initialized</li> 
 	<li>HTTPS and Authorization working together</li> 
 	<li>New Http sampling that automatically parses HTML response 
 		for images to download, and includes the downloading of these 
 		images in total time for request (Neth neth6@atozasia.com) </li> 
 	<li>HTTP responses from server can be parsed for links and forms, 
 		and dynamic data can be extracted and added to test samples 
 		at run-time (documented)</li>  
 	<li>New Ramp-up feature (Jonathan O'Keefe)</li> 
 	<li>New visualizers (Neth)</li> 
 	<li>New Assertions for functional testing</li> 
 </ul>  
 
 <h3>Version 1.6.1</h3> 
 <ul> 
 	<li>Fixed saving and loading of test scripts (no more extra lines)</li> 
 	<li>Can save and load special characters (such as &quot;&amp;&quot; and &quot;&lt;&quot;).</li> 
 	<li>Can save and load timers and listeners.</li> 
 	<li>Minor bug fix for cookies (if you cookie value 
 		contained an &quot;=&quot;, then it broke).</li> 
 	<li>URL's can sample ports other than 80, and can test HTTPS, 
 		provided you have the necessary jars (JSSE)</li> 
 </ul> 
 
 <h3>Version 1.6 Alpha</h3> 
 <ul> 
 	<li>New UI</li> 
 	<li>Separation of GUI and Logic code</li> 	
 	<li>New Plug-in framework for new modules</li> 
 	<li>Enhanced performance</li> 
 	<li>Layering of test logic for greater flexibility</li> 
 	<li>Added support for saving of test elements</li> 
 	<li>Added support for distributed testing using a single client</li> 
 
 </ul> 
 <h3>Version 1.5.1</h3> 
 <ul> 
 	<li>Fixed bug that caused cookies not to be read if header name case not as expected.</li> 
 	<li>Clone entries before sending to sampler - prevents relocations from messing up 
 		information across threads</li> 
 	<li>Minor bug fix to convenience dialog for adding paramters to test sample.  
 		Bug prevented entries in dialog from appearing in test sample.</li> 
 	<li>Added xerces.jar to distribution</li> 
 	<li>Added junit.jar to distribution and created a few tests.</li> 
 	<li>Started work on new framework.  New files in cvs, but do not effect program yet.</li> 
 	<li>Fixed bug that prevent HTTPJMeterThread from delaying according to chosen timer.</li> 
 </ul>  
 <p> 
 <h3>Version 1.5</h3> 
 <ul>   
 	<li>Abstracted out the concept of the Sampler, SamplerController, and TestSample.   
 		A Sampler represents code that understands a protocol (such as HTTP, 
 		or FTP, RMI,   SMTP, etc..).  It is the code that actually makes the 
 		connection to whatever is   being tested.   A SamplerController 
 		represents code that understands how to organize and run a group   
 		of test samples.  It is what binds together a Sampler and its test 
 		samples and runs them.   A TestSample represents code that understands 
 		how to gather information from the   user about a particular test.  
 		For a website, it would represent a URL and any   information to be sent 
 		with the URL.</li>   
 	<li>The UI has been updated to make entering test samples more convenient.</li>   
 	<li>Thread groups have been added, allowing a user to setup multiple test to run   
 		concurrently, and to allow sharing of test samples between those tests.</li>   
 	<li>It is now possible to save and load test samples.</li>   
 	<li>....and many more minor changes/improvements...</li> 
 </ul> 
 </p> 
 <p> 
 <b>Apache JMeter 1.4.1-dev</b> (<a href="mailto:stefano@apache.org">Stefano Mazzocchi</a>)  
 <ul>
    <li>Cleaned up URLSampler code after tons of patches for better readability. (SM)</li>
    <li>Made JMeter send a special &quot;user-agent&quot; identifier. (SM)</li>
    <li>Fixed problems with redirection not sending cookies and authentication info and removed
      a warning with jikes compilation. Thanks to <a href="mailto:wtanaka@yahoo.com">Wesley
      Tanaka</a> for the patches (SM)</li>
    <li>Fixed a bug in the URLSampler that caused to skip one URL when testing lists of URLs and
      a problem with Cookie handling. Thanks to <a
      href="mailto:gjohnson@investlearning.com">Graham Johnson</a> for the patches (SM)</li>
    <li>Fixed a problem with POST actions. Thanks to <a href="mailto:sschaub@bju.edu">Stephen
      Schaub</a> for the patch (SM)</li>
  </ul>
  </p>
  <p>
  <b>Apache JMeter 1.4</b> - Jul 11 1999 (<a href="mailto:cimjpno@be.ibm.com">Jean-Pierre Norguet</a>,
  <a href="mailto:stefano@apache.org">Stefano Mazzocchi</a>)
   <ul>
    <li>Fixed a problem with POST actions. Thanks to <a href="mailto:bburns@labs.gte.com">Brendan
      Burns</a> for the patch (SM)</li>
    <li>Added close button to the About box for those window managers who don't provide it.
      Thanks to Jan-Henrik Haukeland for pointing it out. (SM)</li>
    <li>Added the simple Spline sample visualizer (JPN)</li> 
 </ul> </p>
   <p><b>Apache JMeter 1.3</b> - Apr 16 1999
   (<a href="mailto:stefano@apache.org">Stefano Mazzocchi</a>,
  <a href="mailto:luta.raphael@networks.vivendi.net">Rapha??l Luta</a>)
 <ul>
    <li>Run the Garbage Collector and run finalization before starting to sampling to ensure
      same state every time (SM)</li>
    <li>Fixed some NullPointerExceptions here and there (SM)</li>
    <li>Added HTTP authentication capabilities (RL)</li>
    <li>Added windowed sample visualizer (SM)</li>
    <li>Fixed stupid bug for command line arguments. Thanks to <a
      href="mailto:jbracer@infoneers.com">Jorge Bracer</a> for pointing this out (SM)</li> 
 </ul> </p>
   <p><b>Apache JMeter 1.2</b> - Mar 17 1999 (<a href="mailto:sdowd@arcmail.com">Sean Dowd</a>, 
 <a href="mailto:stefano@apache.org">Stefano Mazzocchi</a>)  
 <ul>
    <li>Integrated cookie capabilities with JMeter (SM)</li>
    <li>Added the Cookie manager and Netscape file parser (SD)</li>
    <li>Fixed compilation error for JDK 1.1 (SD)</li> </ul> </p>  
 <p> <b>Apache JMeter 1.1</b> - Feb 24 1999 (<a href="mailto:sdowd@arcmail.com">Sean Dowd</a>, 
 <a href="mailto:stefano@apache.org">Stefano Mazzocchi</a>)  
 <ul>
    <li>Created the opportunity to create URL aliasing from the properties file as well as the
      ability to associate aliases to URL sequences instead of single URLs (SM) Thanks to <a
      href="mailto:chatfield@evergreen.com">Simon Chatfield</a> for the very nice suggestions
      and code examples.</li>
    <li>Removed the TextVisualizer and replaced it with the much more useful FileVisualizer (SM)</li>
    <li>Added the known bug list (SM)</li>
    <li>Removed the Java Apache logo (SM)</li>
    <li>Fixed a couple of typos (SM)</li>
    <li>Added UNIX makefile (SD)</li> </ul> </p> 
 <p> <b>Apache JMeter 1.0.1</b> - Jan 25 1999 (<a href="mailto:stefano@apache.org">Stefano Mazzocchi</a>)  
 <ul>
    <li>Removed pending issues doc issues (SM)</li>
    <li>Fixed the unix script (SM)</li>
    <li>Added the possibility of running the JAR directly using &quot;java -jar
      ApacheJMeter.jar&quot; with Java 2 (SM)</li>
    <li>Some small updates: fixed Swing location after Java 2(tm) release, license update and
      small cleanups (SM)</li> 
 </ul> </p> 
 <p> <b>Apache JMeter 1.0</b> - Dec 15 1998 (<a href="mailto:stefano@apache.org">Stefano Mazzocchi</a>) 
 <ul>
    <li>Initial version. (SM)</li> 
 </ul> </p> 
 </section> 
 </body> 
 </document>
