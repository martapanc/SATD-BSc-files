diff --git a/src/core/org/apache/jmeter/resources/messages.properties b/src/core/org/apache/jmeter/resources/messages.properties
index 18a7ea918..272c7c508 100644
--- a/src/core/org/apache/jmeter/resources/messages.properties
+++ b/src/core/org/apache/jmeter/resources/messages.properties
@@ -1,807 +1,808 @@
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
 aggregate_graph_ms=Milliseconds
 aggregate_graph_response_time=Response Time
 aggregate_graph_save=Save Graph
 aggregate_graph_save_table=Save Table Data
 aggregate_graph_title=Aggregate Graph
 aggregate_graph_user_title=Title for Graph
 aggregate_graph_max_length_xaxis_label=Max length of x-axis label
 aggregate_graph_width=Width
 aggregate_report=Aggregate Report
 aggregate_report_90%_line=90% Line
 aggregate_report_90=90%
 aggregate_report_bandwidth=KB/sec
 aggregate_report_count=# Samples
 aggregate_report_error%=Error %
 aggregate_report_error=Error
 aggregate_report_max=Max
 aggregate_report_median=Median
 aggregate_report_min=Min
 aggregate_report_rate=Throughput
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
 assertion_matches=Matches
 assertion_equals=Equals
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
 bsh_assertion_script=Script
 bsh_assertion_script_variables=The following variables are defined for the script:\nRead/Write: Failure, FailureMessage, SampleResult, log.\nReadOnly: Response[Data|Code|Message|Headers], RequestHeaders, SampleLabel, SamplerData
 bsh_assertion_title=BeanShell Assertion
 bsh_function_expression=Expression to evaluate
 bsh_sampler_title=BeanShell Sampler
 bsh_script=Script (variables\: SampleResult, ResponseCode, ResponseMessage, IsSuccess, Label, FileName)
 bsh_script_file=Script file
 bsh_script_parameters=Parameters (-> String Parameters and String []bsh.args)
 busy_testing=I'm busy testing, please stop the test before changing settings
 cache_session_id=Cache Session Id?
 cancel=Cancel
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
+content_encoding=Content encoding\:
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
 debug_on=Enable debug
 debug_off=Disable debug
 default_parameters=Default Parameters
 default_value_field=Default Value\:
 delay=Startup delay (seconds)
 delete=Delete
 delete_parameter=Delete Variable
 delete_test=Delete Test
 delete_user=Delete User
 deltest=deletion test
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
 enable=Activate
 encode?=Encode?
 encoded_value=URL Encoded Value
 endtime=End Time  
 entry_dn=Entry DN
 entrydn=Entry DN
 error_loading_help=Error loading help page
 error_occurred=Error Occurred
 es=Spanish
 example_data=Sample Data
 example_title=Example Sampler
 exit=Exit
 expiration=Expiration
 field_name=Field name
 file=File
 file_already_in_use=That file is already in use
 file_to_retrieve=File to Retrieve From Server\:
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
 ftp_sample_title=FTP Request Defaults
 ftp_testing_title=FTP Request
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
 httpmirror_title=HTTP Mirror Server
 http_response_code=HTTP response code
 http_url_rewriting_modifier_title=HTTP URL Re-writing Modifier
 http_user_parameter_modifier=HTTP User Parameter Modifier
 id_prefix=ID Prefix
 id_suffix=ID Suffix
 if_controller_label=Condition
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
 iteration_counter_arg_1=TRUE, for each user to have own counter, FALSE for a global counter
 iterator_num=Loop Count\:
 jar_file=Jar Files
 java_request=Java Request
 java_request_defaults=Java Request Defaults
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
 jms_point_to_point=JMS Point-to-Point
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
 junit_constructor_string=Constructor String Label
 junit_constructor_error=Unable to create an instance of the class
 junit_do_setup_teardown=Do not call setUp and tearDown
 junit_error_code=Error Code
 junit_error_default_code=9999
 junit_error_msg=Error Message
 junit_error_default_msg=An unexpected error occured
 junit_failure_code=Failure Code
 junit_failure_default_code=0001
 junit_failure_msg=Failure Message
 junit_failure_default_msg=Test failed
 junit_pkg_filter=Package Filter
 junit_request=JUnit Request
 junit_request_defaults=JUnit Request Defaults
 junit_success_code=Success Code
 junit_success_default_code=1000
 junit_success_msg=Success Message
 junit_success_default_msg=Test successful
 junit_test_method=Test Method
 junit_test_config=JUnit Test Parameters
 ldap_argument_list=LDAPArgument List
 ldap_sample_title=LDAP Request Defaults
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
 patterns_to_exclude=Patterns to Exclude
 patterns_to_include=Patterns to Include
 pkcs12_desc=PKCS 12 Key (*.p12)
 port=Port\:
 property_as_field_label={0}\:
 property_default_param=Default value
 property_edit=Edit
 property_editor.value_is_invalid_message=The text you just entered is not a valid value for this property.\nThe property will be reverted to its previous value.
 property_editor.value_is_invalid_title=Invalid input
 property_name_param=Name of property
 property_value_param=Value of property
 property_returnvalue_param=Return Original Value of property (default false) ?
 property_tool_tip={0}\: {1}
 property_undefined=Undefined
 protocol=Protocol (default http)\:
 protocol_java_border=Java class
 protocol_java_classname=Classname\:
 protocol_java_config_tile=Configure Java Sample
 protocol_java_test_title=Java Testing
 provider_url=Provider URL
 proxy_assertions=Add Assertions
 proxy_cl_error=If specifying a proxy server, host and port must be given
 proxy_headers=Capture HTTP Headers
 proxy_httpsspoofing=Attempt https Spoofing
 proxy_regex=Regex matching
 proxy_separators=Add Separators
 proxy_target=Target Controller\:
 proxy_title=HTTP Proxy Server
 proxy_usekeepalive=Set Keep-Alive
 ramp_up=Ramp-Up Period (in seconds)\:
 random_control_title=Random Controller
 random_order_control_title=Random Order Controller
 realm=Realm
 read_response_message=Read response is not checked. To see the response, please check the box in the sampler.
 read_response_note=If read response is unchecked, the sampler will not read the response
 read_response_note2=or set the SampleResult. This improves performance, but it means
 read_response_note3=the response content won't be logged.
 read_soap_response=Read SOAP Response
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
 restart=Restart
 resultaction_title=Result Status Action Handler
 resultsaver_errors=Save Failed Responses only
 resultsaver_prefix=Filename prefix\:
 resultsaver_title=Save Responses to a file
 retobj=Return object
 reuseconnection=Re-use connection
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
 save_requestheaders=Save Request Headers
 save_responsedata=Save Response Data
 save_responseheaders=Save Response Headers
 save_samplerdata=Save Sampler Data
 save_subresults=Save Sub Results
 save_success=Save Success
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
 success?=Success?
 summariser_title=Generate Summary Results
 summary_report=Summary Report
 switch_controller_label=Switch Value
 switch_controller_title=Switch Controller
 table_visualizer_bytes=Bytes
 table_visualizer_sample_num=Sample #
 table_visualizer_sample_time=Sample Time(ms)
 table_visualizer_start_time=Start Time
 table_visualizer_thread_name=Thread Name
 tcp_config_title=TCP Sampler Config
 tcp_nodelay=Set NoDelay
 tcp_port=Port Number\:
 tcp_request_data=Text to send
 tcp_sample_title=TCP Sampler
 tcp_timeout=Timeout (milliseconds)\:
 template_field=Template\:
 test=Test
 testconfiguration=Test Configuration
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
 timelim=Time limit
 time_format=Format string for SimpleDateFormat (optional)
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
 view_results_title=View Results
 view_results_tree_title=View Results Tree
 warning=Warning!
 web_request=HTTP Request
 web_server=Web Server
 web_server_domain=Server Name or IP\:
 web_server_port=Port Number\:
 web_testing_retrieve_images=Retrieve All Embedded Resources from HTML Files
 web_testing_title=HTTP Request
 webservice_proxy_host=Proxy Host
 webservice_proxy_note=If Use HTTP Proxy is checked, but no host or port are provided, the sampler
 webservice_proxy_note2=will look at command line options. If no proxy host or port are provided by
 webservice_proxy_note3=either, it will fail silently.
 webservice_proxy_port=Proxy Port
 webservice_sampler_title=WebService(SOAP) Request
 webservice_soap_action=SOAPAction
 webservice_timeout=Timeout:
 webservice_use_proxy=Use HTTP Proxy
 while_controller_label=Condition
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
 xpath_extractor_title=XPath Extractor
 xpath_extractor_query=XPath query:
 xpath_extractor_tolerant=Use Tidy ?
 xpath_file_file_name=XML file to get values from 
 you_must_enter_a_valid_number=You must enter a valid number
 zh_cn=Chinese (Simplified)
 zh_tw=Chinese (Traditional)
 # Please add new entries in alphabetical order
\ No newline at end of file
diff --git a/src/protocol/http/org/apache/jmeter/protocol/http/config/gui/UrlConfigGui.java b/src/protocol/http/org/apache/jmeter/protocol/http/config/gui/UrlConfigGui.java
index 705eb7296..8377bc0b8 100644
--- a/src/protocol/http/org/apache/jmeter/protocol/http/config/gui/UrlConfigGui.java
+++ b/src/protocol/http/org/apache/jmeter/protocol/http/config/gui/UrlConfigGui.java
@@ -1,276 +1,291 @@
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
 
 package org.apache.jmeter.protocol.http.config.gui;
 
 import java.awt.BorderLayout;
 import java.awt.Component;
 import java.awt.FlowLayout;
 
 import javax.swing.BorderFactory;
 import javax.swing.Box;
 import javax.swing.BoxLayout;
 import javax.swing.JCheckBox;
 import javax.swing.JLabel;
 import javax.swing.JPanel;
 import javax.swing.JTextField;
 
 import org.apache.jmeter.config.Arguments;
 import org.apache.jmeter.config.ConfigTestElement;
 import org.apache.jmeter.protocol.http.gui.HTTPArgumentsPanel;
 import org.apache.jmeter.protocol.http.sampler.HTTPSamplerBase;
 import org.apache.jmeter.protocol.http.util.HTTPArgument;
 import org.apache.jmeter.testelement.AbstractTestElement;
 import org.apache.jmeter.testelement.TestElement;
 import org.apache.jmeter.testelement.property.BooleanProperty;
 import org.apache.jmeter.testelement.property.TestElementProperty;
 import org.apache.jmeter.util.JMeterUtils;
 import org.apache.jorphan.gui.JLabeledChoice;
 
 /**
  * @author Michael Stover
  */
 public class UrlConfigGui extends JPanel {
 	protected HTTPArgumentsPanel argsPanel;
 
 	private static String DOMAIN = "domain"; // $NON-NLS-1$
 
 	private static String PORT = "port"; // $NON-NLS-1$
 
 	private static String PROTOCOL = "protocol"; // $NON-NLS-1$
 
+	private static String CONTENT_ENCODING = "content_encoding"; // $NON-NLS-1$
+
 	private static String PATH = "path"; // $NON-NLS-1$
 
 	private static String FOLLOW_REDIRECTS = "follow_redirects"; // $NON-NLS-1$
 
 	private static String AUTO_REDIRECTS = "auto_redirects"; // $NON-NLS-1$
 
 	private static String USE_KEEPALIVE = "use_keepalive"; // $NON-NLS-1$
 
 	private JTextField domain;
 
 	private JTextField port;
 
 	private JTextField protocol;
 
+	private JTextField contentEncoding;
+
 	private JTextField path;
 
 	private JCheckBox followRedirects;
 
 	private JCheckBox autoRedirects;
 
 	private JCheckBox useKeepAlive;
 
     private JLabeledChoice method;
     
 	public UrlConfigGui() {
 		init();
 	}
 
 	protected void configureTestElement(TestElement mc) {
 		mc.setProperty(TestElement.NAME, getName());
 		mc.setProperty(TestElement.GUI_CLASS, this.getClass().getName());
 		mc.setProperty(TestElement.TEST_CLASS, mc.getClass().getName());
 	}
 
 	public void clear() {
 		domain.setText(""); // $NON-NLS-1$
 		followRedirects.setSelected(true);
 		autoRedirects.setSelected(false);
         method.setText(HTTPSamplerBase.DEFAULT_METHOD);
 		path.setText(""); // $NON-NLS-1$
 		port.setText(""); // $NON-NLS-1$
 		protocol.setText(""); // $NON-NLS-1$
+		contentEncoding.setText(""); // $NON-NLS-1$
 		useKeepAlive.setSelected(true);
 		argsPanel.clear();
-
 	}
 
 	public TestElement createTestElement() {
 		ConfigTestElement element = new ConfigTestElement();
 
 		this.configureTestElement(element);
 		Arguments args = (Arguments) argsPanel.createTestElement();
 
 		HTTPArgument.convertArgumentsToHTTP(args);
 		element.setProperty(new TestElementProperty(HTTPSamplerBase.ARGUMENTS, args));
 		element.setProperty(HTTPSamplerBase.DOMAIN, domain.getText());
 		element.setProperty(HTTPSamplerBase.PORT, port.getText());
 		element.setProperty(HTTPSamplerBase.PROTOCOL, protocol.getText());
 		element.setProperty(HTTPSamplerBase.METHOD, method.getText());
+		element.setProperty(HTTPSamplerBase.CONTENT_ENCODING, contentEncoding.getText());
 		element.setProperty(HTTPSamplerBase.PATH, path.getText());
 		element.setProperty(new BooleanProperty(HTTPSamplerBase.FOLLOW_REDIRECTS, followRedirects.isSelected()));
 		element.setProperty(new BooleanProperty(HTTPSamplerBase.AUTO_REDIRECTS, autoRedirects.isSelected()));
 		element.setProperty(new BooleanProperty(HTTPSamplerBase.USE_KEEPALIVE, useKeepAlive.isSelected()));
 		return element;
 	}
 
 	/**
 	 * Set the text, etc. in the UI.
 	 * 
 	 * @param el
 	 *            contains the data to be displayed
 	 */
 	public void configure(TestElement el) {
 		setName(el.getPropertyAsString(TestElement.NAME));
 		argsPanel.configure((TestElement) el.getProperty(HTTPSamplerBase.ARGUMENTS).getObjectValue());
 		domain.setText(el.getPropertyAsString(HTTPSamplerBase.DOMAIN));
 
 		String portString = el.getPropertyAsString(HTTPSamplerBase.PORT);
 
 		// Only display the port number if it is meaningfully specified
 		if (portString.equals(HTTPSamplerBase.UNSPECIFIED_PORT_AS_STRING)) {
 			port.setText(""); // $NON-NLS-1$
 		} else {
 			port.setText(portString);
 		}
 		protocol.setText(el.getPropertyAsString(HTTPSamplerBase.PROTOCOL));
         method.setText(el.getPropertyAsString(HTTPSamplerBase.METHOD));
+        contentEncoding.setText(el.getPropertyAsString(HTTPSamplerBase.CONTENT_ENCODING));
 		path.setText(el.getPropertyAsString(HTTPSamplerBase.PATH));
 		followRedirects.setSelected(((AbstractTestElement) el).getPropertyAsBoolean(HTTPSamplerBase.FOLLOW_REDIRECTS));
 
 		autoRedirects.setSelected(((AbstractTestElement) el).getPropertyAsBoolean(HTTPSamplerBase.AUTO_REDIRECTS));
 		useKeepAlive.setSelected(((AbstractTestElement) el).getPropertyAsBoolean(HTTPSamplerBase.USE_KEEPALIVE));
 	}
 
 	protected void init() {
 		this.setLayout(new BorderLayout());
 
 		JPanel webServerPanel = new JPanel();
 
 		webServerPanel.setLayout(new BorderLayout());
 		webServerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), JMeterUtils
 				.getResString("web_server"))); // $NON-NLS-1$
 		webServerPanel.add(getDomainPanel(), BorderLayout.NORTH);
 		webServerPanel.add(getPortPanel(), BorderLayout.WEST);
 
 		JPanel webRequestPanel = new JPanel();
 
 		webRequestPanel.setLayout(new BorderLayout());
 		webRequestPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), JMeterUtils
 				.getResString("web_request"))); // $NON-NLS-1$
 		JPanel northPanel = new JPanel(new BorderLayout());
 
 		northPanel.add(getProtocolAndMethodPanel(), BorderLayout.NORTH);
 		northPanel.add(getPathPanel(), BorderLayout.SOUTH);
 		webServerPanel.add(northPanel, BorderLayout.SOUTH);
 		webRequestPanel.add(getParameterPanel(), BorderLayout.CENTER);
 
 		this.add(webServerPanel, BorderLayout.NORTH);
 		this.add(webRequestPanel, BorderLayout.CENTER);
 	}
 
 	protected JPanel getPortPanel() {
 		port = new JTextField(6);
 		port.setName(PORT);
 
 		JLabel label = new JLabel(JMeterUtils.getResString("web_server_port")); // $NON-NLS-1$
 		label.setLabelFor(port);
 
 		JPanel panel = new JPanel(new BorderLayout(5, 0));
 		panel.add(label, BorderLayout.WEST);
 		panel.add(port, BorderLayout.CENTER);
 
 		return panel;
 	}
 
 	protected JPanel getDomainPanel() {
 		domain = new JTextField(20);
 		domain.setName(DOMAIN);
 
 		JLabel label = new JLabel(JMeterUtils.getResString("web_server_domain")); // $NON-NLS-1$
 		label.setLabelFor(domain);
 
 		JPanel panel = new JPanel(new BorderLayout(5, 0));
 		panel.add(label, BorderLayout.WEST);
 		panel.add(domain, BorderLayout.CENTER);
 		return panel;
 	}
 
 	/**
 	 * This method defines the Panel for the HTTP path, 'Follow Redirects' and
 	 * 'Use KeepAlive' elements.
 	 * 
 	 * @return JPanel The Panel for the path, 'Follow Redirects' and 'Use
 	 *         KeepAlive' elements.
 	 */
 	protected Component getPathPanel() {
 		path = new JTextField(15);
 		path.setName(PATH);
 
 		JLabel label = new JLabel(JMeterUtils.getResString("path"));
 		label.setLabelFor(path);
 
 		autoRedirects = new JCheckBox(JMeterUtils.getResString("follow_redirects_auto"));
 		autoRedirects.setName(AUTO_REDIRECTS);
 		autoRedirects.setSelected(false);// will be reset by
 											// configure(TestElement)
 
 		followRedirects = new JCheckBox(JMeterUtils.getResString("follow_redirects")); // $NON-NLS-1$
 		followRedirects.setName(FOLLOW_REDIRECTS);
 		followRedirects.setSelected(true);
 
 		useKeepAlive = new JCheckBox(JMeterUtils.getResString("use_keepalive")); // $NON-NLS-1$
 		useKeepAlive.setName(USE_KEEPALIVE);
 		useKeepAlive.setSelected(true);
 
 		JPanel pathPanel = new JPanel(new BorderLayout(5, 0));
 		pathPanel.add(label, BorderLayout.WEST);
 		pathPanel.add(path, BorderLayout.CENTER);
 		pathPanel.setMinimumSize(pathPanel.getPreferredSize());
 
 		JPanel optionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
 		optionPanel.add(autoRedirects);
 		optionPanel.add(followRedirects);
 		optionPanel.add(useKeepAlive);
 		optionPanel.setMinimumSize(optionPanel.getPreferredSize());
 
 		JPanel panel = new JPanel();
 		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
 		panel.add(pathPanel);
 		panel.add(optionPanel);
 		return panel;
 	}
 
 	protected JPanel getProtocolAndMethodPanel() {
 		// PROTOCOL
 		protocol = new JTextField(20);
 		protocol.setName(PROTOCOL);
+		// CONTENT_ENCODING
+		contentEncoding = new JTextField(10);
+		contentEncoding.setName(CONTENT_ENCODING);
 
 		JLabel protocolLabel = new JLabel(JMeterUtils.getResString("protocol")); // $NON-NLS-1$
 		protocolLabel.setLabelFor(protocol);
+		JLabel contentEncodingLabel = new JLabel(JMeterUtils.getResString("content_encoding")); // $NON-NLS-1$
+		protocolLabel.setLabelFor(contentEncoding);
         method = new JLabeledChoice(JMeterUtils.getResString("method"), // $NON-NLS-1$
                 HTTPSamplerBase.getValidMethodsAsArray());
 
         JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
 
 		panel.add(protocolLabel);
 		panel.add(protocol);
 		panel.add(Box.createHorizontalStrut(5));
 
         panel.add(method);
 		panel.setMinimumSize(panel.getPreferredSize());
+        panel.add(Box.createHorizontalStrut(5));
+		
+		panel.add(contentEncodingLabel);
+		panel.add(contentEncoding);
 		return panel;
 	}
 
 	protected JPanel getParameterPanel() {
 		argsPanel = new HTTPArgumentsPanel();
 
 		return argsPanel;
 	}
 }
diff --git a/src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSampler2.java b/src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSampler2.java
index bb13393de..74a68ed75 100644
--- a/src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSampler2.java
+++ b/src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSampler2.java
@@ -1,760 +1,766 @@
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
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.IOException;
 import java.io.InputStream;
 import java.io.OutputStream;
 import java.net.InetAddress;
 import java.net.URL;
 import java.net.UnknownHostException;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.HashSet;
 import java.util.Iterator;
 import java.util.List;
 import java.util.Map;
 import java.util.Set;
 import java.util.StringTokenizer;
 import java.util.zip.GZIPInputStream;
 
 import org.apache.commons.httpclient.Header;
 import org.apache.commons.httpclient.HostConfiguration;
 import org.apache.commons.httpclient.HttpClient;
 import org.apache.commons.httpclient.HttpMethod;
 import org.apache.commons.httpclient.HttpMethodBase;
 import org.apache.commons.httpclient.HttpVersion;
 import org.apache.commons.httpclient.NTCredentials;
 import org.apache.commons.httpclient.ProtocolException;
 import org.apache.commons.httpclient.SimpleHttpConnectionManager;
 import org.apache.commons.httpclient.UsernamePasswordCredentials;
 import org.apache.commons.httpclient.auth.AuthScope;
 import org.apache.commons.httpclient.cookie.CookiePolicy;
 import org.apache.commons.httpclient.methods.DeleteMethod;
 import org.apache.commons.httpclient.methods.GetMethod;
 import org.apache.commons.httpclient.methods.HeadMethod;
 import org.apache.commons.httpclient.methods.OptionsMethod;
 import org.apache.commons.httpclient.methods.PostMethod;
 import org.apache.commons.httpclient.methods.PutMethod;
 import org.apache.commons.httpclient.methods.RequestEntity;
 import org.apache.commons.httpclient.methods.TraceMethod;
 import org.apache.commons.httpclient.methods.multipart.FilePart;
 import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
 import org.apache.commons.httpclient.methods.multipart.Part;
 import org.apache.commons.httpclient.methods.multipart.StringPart;
 import org.apache.commons.httpclient.params.DefaultHttpParams;
 import org.apache.commons.httpclient.params.HttpMethodParams;
 import org.apache.commons.httpclient.params.HttpParams;
 import org.apache.commons.httpclient.protocol.Protocol;
 import org.apache.jmeter.JMeter;
 import org.apache.jmeter.config.Argument;
 import org.apache.jmeter.protocol.http.control.AuthManager;
 import org.apache.jmeter.protocol.http.control.Authorization;
 import org.apache.jmeter.protocol.http.control.CookieManager;
 import org.apache.jmeter.protocol.http.control.HeaderManager;
 import org.apache.jmeter.protocol.http.util.SlowHttpClientSocketFactory;
 import org.apache.jmeter.testelement.property.CollectionProperty;
 import org.apache.jmeter.testelement.property.PropertyIterator;
 import org.apache.jmeter.util.JMeterUtils;
 import org.apache.jmeter.util.SSLManager;
 import org.apache.jorphan.logging.LoggingManager;
 import org.apache.jorphan.util.JOrphanUtils;
 import org.apache.log.Logger;
 
 /**
  * A sampler which understands all the parts necessary to read statistics about
  * HTTP requests, including cookies and authentication.
  * 
  */
 public class HTTPSampler2 extends HTTPSamplerBase {
 
     private static final Logger log = LoggingManager.getLoggerForClass();
 
     static final String PROXY_HOST = 
         System.getProperty("http.proxyHost",""); // $NON-NLS-1$ 
 
     private static final String NONPROXY_HOSTS = 
         System.getProperty("http.nonProxyHosts",""); // $NON-NLS-1$ 
 
     static final int PROXY_PORT = 
         Integer.parseInt(System.getProperty("http.proxyPort","0")); // $NON-NLS-1$ 
 
     // Have proxy details been provided?
     private static final boolean PROXY_DEFINED = PROXY_HOST.length() > 0 && PROXY_PORT > 0;
     
     static final String PROXY_USER = 
         JMeterUtils.getPropDefault(JMeter.HTTP_PROXY_USER,""); // $NON-NLS-1$
     
     static final String PROXY_PASS = 
         JMeterUtils.getPropDefault(JMeter.HTTP_PROXY_PASS,""); // $NON-NLS-1$
     
     static InetAddress localAddress = null;
     
     private static final String localHost;
     
     /*
      * Connection is re-used within the thread if possible
      */
 	static final ThreadLocal httpClients = new ThreadLocal();
 
     private static Set nonProxyHostFull   = new HashSet();// www.apache.org
     private static List nonProxyHostSuffix = new ArrayList();// .apache.org
 
     private static final int nonProxyHostSuffixSize;
 
     static boolean isNonProxy(String host){
         return nonProxyHostFull.contains(host) || isPartialMatch(host);
     }
 
     private static boolean isPartialMatch(String host) {    
         for (int i=0;i<nonProxyHostSuffixSize;i++){
             if (host.endsWith((String)nonProxyHostSuffix.get(i)))
                 return true;
         }
         return false;
     }
 
 	static {
         if (NONPROXY_HOSTS.length() > 0){
             StringTokenizer s = new StringTokenizer(NONPROXY_HOSTS,"|");// $NON-NLS-1$
             while (s.hasMoreTokens()){
                 String t = s.nextToken();
                 if (t.indexOf("*") ==0){// e.g. *.apache.org // $NON-NLS-1$
                     nonProxyHostSuffix.add(t.substring(1));
                 } else {
                     nonProxyHostFull.add(t);// e.g. www.apache.org
                 }
             }
         }
         nonProxyHostSuffixSize=nonProxyHostSuffix.size();
 
         int cps =
             JMeterUtils.getPropDefault("httpclient.socket.http.cps", 0); // $NON-NLS-1$        
 
         if (cps > 0) {
             log.info("Setting up HTTP SlowProtocol, cps="+cps);
             Protocol.registerProtocol(PROTOCOL_HTTP, 
                     new Protocol(PROTOCOL_HTTP,new SlowHttpClientSocketFactory(cps),DEFAULT_HTTP_PORT));
         }
         cps =
             JMeterUtils.getPropDefault("httpclient.socket.https.cps", 0); // $NON-NLS-1$        
 
         if (cps > 0) {
             log.info("Setting up HTTPS SlowProtocol, cps="+cps);
             Protocol.registerProtocol(PROTOCOL_HTTPS, 
                     new Protocol(PROTOCOL_HTTPS,new SlowHttpClientSocketFactory(cps),DEFAULT_HTTPS_PORT));
         }
 
         String localHostOrIP = 
             JMeterUtils.getPropDefault("httpclient.localaddress",""); // $NON-NLS-1$
         if (localHostOrIP.length() > 0){
             try {
                 localAddress = InetAddress.getByName(localHostOrIP);
                 log.info("Using localAddress "+localAddress.getHostAddress());
             } catch (UnknownHostException e) {
                 log.warn(e.getLocalizedMessage());
             }
         } else {
             try {
                 InetAddress addr = InetAddress.getLocalHost();
                 // Get hostname
                 localHostOrIP = addr.getHostName();
             } catch (UnknownHostException e) {
                 log.warn("Cannot determine localhost name, and httpclient.localaddress was not specified");
             }
         }
         localHost = localHostOrIP;
         log.info("Local host = "+localHost);
         
         setDefaultParams();
 	}
 
     // Set default parameters as needed
     private static void setDefaultParams(){
         HttpParams params = DefaultHttpParams.getDefaultParams();
         
         // Process httpclient parameters file
         String file=JMeterUtils.getProperty("httpclient.parameters.file"); // $NON-NLS-1$
         if (file != null) {
             HttpClientDefaultParameters.load(file,params);
         }
         
         // Handle old-style JMeter properties
         // Default to HTTP version 1.1
         String ver=JMeterUtils.getPropDefault("httpclient.version","1.1"); // $NON-NLS-1$ $NON-NLS-2$
         try {
             params.setParameter(HttpMethodParams.PROTOCOL_VERSION, HttpVersion.parse("HTTP/"+ver));
         } catch (ProtocolException e) {
             log.warn("Problem setting protocol version "+e.getLocalizedMessage());
         }
         String to= JMeterUtils.getProperty("httpclient.timeout");
         if (to != null){
             params.setIntParameter(HttpMethodParams.SO_TIMEOUT, Integer.parseInt(to));
         }
 
         // This must be done last, as must not be overridden
         params.setParameter(HttpMethodParams.COOKIE_POLICY,CookiePolicy.IGNORE_COOKIES);
         // We do our own cookie handling
     }
     
     /**
 	 * Constructor for the HTTPSampler2 object.
      * 
      * Consider using HTTPSamplerFactory.newInstance() instead
 	 */
 	public HTTPSampler2() {
 	}
 
-	/**
+	/*
 	 * Send POST data from <code>Entry</code> to the open connection.
 	 * 
 	 * @param connection
 	 *            <code>URLConnection</code> where POST data should be sent
 	 * @exception IOException
 	 *                if an I/O exception occurs
 	 */
 	private void sendPostData(PostMethod post) throws IOException {
 		// If filename was specified then send the post using multipart syntax
 		String filename = getFilename();
+		final String contentEncoding = getContentEncoding();
 		if ((filename != null) && (filename.trim().length() > 0)) {
 			if (getSendFileAsPostBody()) {
 				post.setRequestEntity(new FileRequestEntity(new File(filename),null));
 			} else {
 	            int argc = getArguments().getArgumentCount();
 	            Part[] parts = new Part[argc+1]; 
 	            PropertyIterator args = getArguments().iterator();
 	            int i = 0;
 	            while (args.hasNext()) {
 	                Argument arg = (Argument) args.next().getObjectValue();
 	                parts[i++] = new StringPart(arg.getName(), arg.getValue());
 	            }
 	            File input = new File(filename);
 	                    //TODO should allow charset to be defined ...
 	            parts[i]= new FilePart(getFileField(), input, getMimetype(), "UTF-8" );//$NON-NLS-1$
 	            post.setRequestEntity(new MultipartRequestEntity(parts, post.getParams()));
 			}
 		} else {
+            // If a content encoding is specified, we set it as http parameter, so that
+            // the post body will be encoded in the specified content encoding
+            if(contentEncoding != null && contentEncoding.trim().length() > 0) {
+    			post.getParams().setContentCharset(contentEncoding);
+            }
             PropertyIterator args = getArguments().iterator();
             while (args.hasNext()) {
                 Argument arg = (Argument) args.next().getObjectValue();
                 post.addParameter(arg.getName(), arg.getValue());
             }
         }
 	}
      
     /**
 	 * Returns an <code>HttpConnection</code> fully ready to attempt
 	 * connection. This means it sets the request method (GET or POST), headers,
 	 * cookies, and authorization for the URL request.
 	 * <p>
 	 * The request infos are saved into the sample result if one is provided.
 	 * 
 	 * @param u
 	 *            <code>URL</code> of the URL request
 	 * @param method 
 	 *            GET/PUT/HEAD etc
 	 * @param res
 	 *            sample result to save request infos to
 	 * @return <code>HttpConnection</code> ready for .connect
 	 * @exception IOException
 	 *                if an I/O Exception occurs
 	 */
 	HttpClient setupConnection(URL u, HttpMethodBase httpMethod, HTTPSampleResult res) throws IOException {
 
 		String urlStr = u.toString();
 
 		org.apache.commons.httpclient.URI uri = new org.apache.commons.httpclient.URI(urlStr,false);
 
 		String schema = uri.getScheme();
 		if ((schema == null) || (schema.length()==0)) {
 			schema = PROTOCOL_HTTP;
 		}
 		
 		if (PROTOCOL_HTTPS.equalsIgnoreCase(schema)){
 			SSLManager.getInstance(); // ensure the manager is initialised
 			// we don't currently need to do anything further, as this sets the default https protocol
 		}
 		
 		Protocol protocol = Protocol.getProtocol(schema);
 
 		String host = uri.getHost();
 		int port = uri.getPort();
 
         /*
          *  We use the HostConfiguration as the key to retrieve the HttpClient,
          *  so need to ensure that any items used in its equals/hashcode methods are
          *  not changed after use, i.e.:
          *  host, port, protocol, localAddress, proxy
          *  
         */
 		HostConfiguration hc = new HostConfiguration();
 		hc.setHost(host, port, protocol); // All needed to ensure re-usablility
 
         // Set up the local address if one exists
         if (localAddress != null){
             hc.setLocalAddress(localAddress);
         }
         
         boolean useProxy = PROXY_DEFINED && !isNonProxy(host);
         if (useProxy) {
             if (log.isDebugEnabled()){
                 log.debug("Setting proxy: "+PROXY_HOST+":"+PROXY_PORT);
             }
             hc.setProxy(PROXY_HOST, PROXY_PORT);
         }
         
         Map map = (Map) httpClients.get();
 		HttpClient httpClient = (HttpClient) map.get(hc);
 		
 		if ( httpClient == null )
 		{
 			httpClient = new HttpClient(new SimpleHttpConnectionManager());
 			httpClient.setHostConfiguration(hc);
 			map.put(hc, httpClient);
             // These items don't change, so only need to be done once
             if (useProxy) {
                 if (PROXY_USER.length() > 0){
                     httpClient.getState().setProxyCredentials(
                         new AuthScope(PROXY_HOST,PROXY_PORT,null,AuthScope.ANY_SCHEME),
                         new UsernamePasswordCredentials(PROXY_USER,PROXY_PASS)
                     );
                 }
             }
 
 		}
 
 		// Allow HttpClient to handle the redirects:
 		httpMethod.setFollowRedirects(getAutoRedirects());
 
 		// a well-behaved browser is supposed to send 'Connection: close'
 		// with the last request to an HTTP server. Instead, most browsers
 		// leave it to the server to close the connection after their
 		// timeout period. Leave it to the JMeter user to decide.
 		if (getUseKeepAlive()) {
 			httpMethod.setRequestHeader(HEADER_CONNECTION, KEEP_ALIVE);
 		} else {
 			httpMethod.setRequestHeader(HEADER_CONNECTION, CONNECTION_CLOSE);
 		}
 
 		String hdrs = setConnectionHeaders(httpMethod, u, getHeaderManager());
 		String cookies = setConnectionCookie(httpMethod, u, getCookieManager());
 
 		if (res != null) {
             res.setURL(u);
             res.setRequestHeaders(hdrs);
             res.setCookies(cookies);
 		}
 
 		setConnectionAuthorization(httpClient, u, getAuthManager());
 
 		return httpClient;
 	}
 
 	/**
 	 * Gets the ResponseHeaders
 	 * 
 	 * @param method
 	 *            connection from which the headers are read
 	 * @return string containing the headers, one per line
 	 */
 	protected String getResponseHeaders(HttpMethod method) {
 		StringBuffer headerBuf = new StringBuffer();
 		org.apache.commons.httpclient.Header rh[] = method.getResponseHeaders();
 		headerBuf.append(method.getStatusLine());// header[0] is not the status line...
 		headerBuf.append("\n"); // $NON-NLS-1$
 
 		for (int i = 0; i < rh.length; i++) {
 			String key = rh[i].getName();
 			if (!key.equalsIgnoreCase(TRANSFER_ENCODING))
                 // TODO - why is this not saved?
 			{
 				headerBuf.append(key);
 				headerBuf.append(": "); // $NON-NLS-1$
 				headerBuf.append(rh[i].getValue());
 				headerBuf.append("\n"); // $NON-NLS-1$
 			}
 		}
 		return headerBuf.toString();
 	}
 
 	/**
 	 * Extracts all the required cookies for that particular URL request and
 	 * sets them in the <code>HttpMethod</code> passed in.
 	 * 
 	 * @param method <code>HttpMethod</code> for the request
 	 * @param u <code>URL</code> of the request
 	 * @param cookieManager the <code>CookieManager</code> containing all the cookies
      * @return a String containing the cookie details (for the response)
      * May be null
 	 */
 	String setConnectionCookie(HttpMethod method, URL u, CookieManager cookieManager) {        
         String cookieHeader = null;
         if (cookieManager != null) {
             cookieHeader = cookieManager.getCookieHeaderForURL(u);
             if (cookieHeader != null) {
                 method.setRequestHeader(HEADER_COOKIE, cookieHeader);
             }
         }
 		return cookieHeader;
 	}
 
 	/**
 	 * Extracts all the required non-cookie headers for that particular URL request and
 	 * sets them in the <code>HttpMethod</code> passed in
 	 * 
 	 * @param method
 	 *            <code>HttpMethod</code> which represents the request
 	 * @param u
 	 *            <code>URL</code> of the URL request
 	 * @param headerManager
 	 *            the <code>HeaderManager</code> containing all the cookies
 	 *            for this <code>UrlConfig</code>
 	 * @return the headers as a string
 	 */
 	String setConnectionHeaders(HttpMethod method, URL u, HeaderManager headerManager) {
 		StringBuffer hdrs = new StringBuffer(100);
 		if (headerManager != null) {
 			CollectionProperty headers = headerManager.getHeaders();
 			if (headers != null) {
 				PropertyIterator i = headers.iterator();
 				while (i.hasNext()) {
 					org.apache.jmeter.protocol.http.control.Header header 
                     = (org.apache.jmeter.protocol.http.control.Header) 
                        i.next().getObjectValue();
 					String n = header.getName();
 					// Don't allow override of Content-Length
 					// This helps with SoapSampler hack too
 					// TODO - what other headers are not allowed?
 					if (! HEADER_CONTENT_LENGTH.equalsIgnoreCase(n)){
 						String v = header.getValue();
 						method.addRequestHeader(n, v);
 						hdrs.append(n);
 						hdrs.append(": "); // $NON-NLS-1$
 						hdrs.append(v);
 						hdrs.append("\n"); // $NON-NLS-1$
 					}
 				}
 			}
 		}
 		return hdrs.toString();
 	}
 
 	/**
 	 * Extracts all the required authorization for that particular URL request
 	 * and sets it in the <code>HttpMethod</code> passed in.
 	 * 
 	 * @param method
 	 *            <code>HttpMethod</code> which represents the request
 	 * @param u
 	 *            <code>URL</code> of the URL request
 	 * @param authManager
 	 *            the <code>AuthManager</code> containing all the authorisations for
 	 *            this <code>UrlConfig</code>
 	 */
 	void setConnectionAuthorization(HttpClient client, URL u, AuthManager authManager) {
 		if (authManager != null) {
             Authorization auth = authManager.getAuthForURL(u);
             if (auth != null) {
                     String username = auth.getUser();
                     String realm = auth.getRealm();
                     String domain = auth.getDomain();
                     if (log.isDebugEnabled()){
                         log.debug(username + " >  D="+ username + " D="+domain+" R="+realm);
                     }
 					client.getState().setCredentials(
                             new AuthScope(u.getHost(),u.getPort(),
                             		realm.length()==0 ? null : realm //"" is not the same as no realm
                             		,AuthScope.ANY_SCHEME),
                             // NT Includes other types of Credentials
                             new NTCredentials(
 									username, 
                                     auth.getPass(), 
                                     localHost,
 									domain
 							));
 			}
             else
             {
                 client.getState().clearCredentials();
             }
 		}
         else
         {
             client.getState().clearCredentials();
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
 	 * @param url
 	 *            URL to sample
 	 * @param method
 	 *            HTTP method: GET, POST,...
 	 * @param areFollowingRedirect
 	 *            whether we're getting a redirect target
 	 * @param frameDepth
 	 *            Depth of this target in the frame structure. Used only to
 	 *            prevent infinite recursion.
 	 * @return results of the sampling
 	 */
 	protected HTTPSampleResult sample(URL url, String method, boolean areFollowingRedirect, int frameDepth) {
 
 		String urlStr = url.toString();
 
 		log.debug("Start : sample" + urlStr);
 		log.debug("method" + method);
 
         HttpMethodBase httpMethod = null;
 
         if (method.equals(POST)) {
             httpMethod = new PostMethod(urlStr);
         } else if (method.equals(PUT)){
             httpMethod = new PutMethod(urlStr);
         } else if (method.equals(HEAD)){
             httpMethod = new HeadMethod(urlStr);
         } else if (method.equals(TRACE)){
             httpMethod = new TraceMethod(urlStr);
         } else if (method.equals(OPTIONS)){
             httpMethod = new OptionsMethod(urlStr);
         } else if (method.equals(DELETE)){
             httpMethod = new DeleteMethod(urlStr);
         } else if (method.equals(GET)){
             httpMethod = new GetMethod(urlStr);
         } else {
         	log.error("Unexpected method (converted to GET): "+method);
             httpMethod = new GetMethod(urlStr);
         }
 
 		HTTPSampleResult res = new HTTPSampleResult();
 		res.setMonitor(isMonitor());
         
 		res.setSampleLabel(urlStr); // May be replaced later
         res.setHTTPMethod(method);
 		res.sampleStart(); // Count the retries as well in the time
         HttpClient client = null;
         InputStream instream = null;
 		try {
 			client = setupConnection(url, httpMethod, res);
 
 			if (method.equals(POST)) {
                 res.setQueryString(getQueryString());
 				sendPostData((PostMethod)httpMethod);
 			} else if (method.equals(PUT)) {
                 setPutHeaders((PutMethod) httpMethod);
             }
 
 			int statusCode = client.executeMethod(httpMethod);
 
 			// Request sent. Now get the response:
             instream = httpMethod.getResponseBodyAsStream();
             
             if (instream != null) {// will be null for HEAD
             
                 Header responseHeader = httpMethod.getResponseHeader(TRANSFER_ENCODING);
                 if (responseHeader!= null && ENCODING_GZIP.equals(responseHeader.getValue())) {
                     instream = new GZIPInputStream(instream);
                 }
     
                 //int contentLength = httpMethod.getResponseContentLength();Not visible ...
                 //TODO size ouststream according to actual content length
                 ByteArrayOutputStream outstream = new ByteArrayOutputStream(4*1024);
                         //contentLength > 0 ? contentLength : DEFAULT_INITIAL_BUFFER_SIZE);
                 byte[] buffer = new byte[4096];
                 int len;
                 boolean first = true;// first response
                 while ((len = instream.read(buffer)) > 0) {
                     if (first) { // save the latency
                         res.latencyEnd();
                         first = false;
                     }
                     outstream.write(buffer, 0, len);
                 }
     
                 res.setResponseData(outstream.toByteArray());
                 outstream.close();            
 
             }
             
 			res.sampleEnd();
 			// Done with the sampling proper.
 
 			// Now collect the results into the HTTPSampleResult:
 
 			res.setSampleLabel(httpMethod.getURI().toString());
             // Pick up Actual path (after redirects)
             
 			res.setResponseCode(Integer.toString(statusCode));
 			res.setSuccessful(isSuccessCode(statusCode));
 
 			res.setResponseMessage(httpMethod.getStatusText());
 
 			String ct = null;
 			org.apache.commons.httpclient.Header h 
                 = httpMethod.getResponseHeader(HEADER_CONTENT_TYPE);
 			if (h != null)// Can be missing, e.g. on redirect
 			{
 				ct = h.getValue();
 				res.setContentType(ct);// e.g. text/html; charset=ISO-8859-1
                 res.setEncodingAndType(ct);
 			}
 
 			res.setResponseHeaders(getResponseHeaders(httpMethod));
 			if (res.isRedirect()) {
 				res.setRedirectLocation(httpMethod.getResponseHeader(HEADER_LOCATION).getValue());
 			}
 
             // If we redirected automatically, the URL may have changed
             if (getAutoRedirects()){
                 res.setURL(new URL(httpMethod.getURI().toString()));
             }
             
 			// Store any cookies received in the cookie manager:
 			saveConnectionCookies(httpMethod, res.getURL(), getCookieManager());
 
 			// Follow redirects and download page resources if appropriate:
 			res = resultProcessing(areFollowingRedirect, frameDepth, res);
 
 			log.debug("End : sample");
 			if (httpMethod != null)
 				httpMethod.releaseConnection();
 			return res;
 		} catch (IllegalArgumentException e)// e.g. some kinds of invalid URL
 		{
 			res.sampleEnd();
 			HTTPSampleResult err = errorResult(e, res);
 			err.setSampleLabel("Error: " + url.toString());
 			return err;
 		} catch (IOException e) {
 			res.sampleEnd();
 			HTTPSampleResult err = errorResult(e, res);
 			err.setSampleLabel("Error: " + url.toString());
 			return err;
 		} finally {
             JOrphanUtils.closeQuietly(instream);
 			if (httpMethod != null)
 				httpMethod.releaseConnection();
 		}
 	}
 
     /**
      * Set up the PUT data (if present)
      */
 	private void setPutHeaders(PutMethod put) 
      {
          String filename = getFilename();
          if ((filename != null) && (filename.trim().length() > 0))
          {
              RequestEntity requestEntity = 
             	 new FileRequestEntity(new File(filename),getMimetype());
              put.setRequestEntity(requestEntity);
          }
      }
 
 	// Implement locally, as current httpclient InputStreamRI implementation does not close file...
 	private class FileRequestEntity implements RequestEntity {
 
 	    final File file;
 	    final String contentType;
 	    
 	    public FileRequestEntity(final File file, final String contentType) {
 	        super();
 	        if (file == null) {
 	            throw new IllegalArgumentException("File may not be null");
 	        }
 	        this.file = file;
 	        this.contentType = contentType;
 	    }
 	    public long getContentLength() {
 	        return this.file.length();
 	    }
 
 	    public String getContentType() {
 	        return this.contentType;
 	    }
 
 	    public boolean isRepeatable() {
 	        return true;
 	    }
 
 	    public void writeRequest(OutputStream out) throws IOException {
 	        InputStream in = new FileInputStream(this.file);
 	        try {
 	            int l;
 	            byte[] buffer = new byte[1024];
 	            while ((l = in.read(buffer)) != -1) {
 	                out.write(buffer, 0, l);
 	            }
 	        } finally {
 	            in.close();
 	        }
 	    }
 	}
 
     /**
 	 * From the <code>HttpMethod</code>, store all the "set-cookie" key-pair
 	 * values in the cookieManager of the <code>UrlConfig</code>.
 	 * 
 	 * @param method
 	 *            <code>HttpMethod</code> which represents the request
 	 * @param u
 	 *            <code>URL</code> of the URL request
 	 * @param cookieManager
 	 *            the <code>CookieManager</code> containing all the cookies
 	 */
 	void saveConnectionCookies(HttpMethod method, URL u, CookieManager cookieManager) {
 		if (cookieManager != null) {
             Header hdr[] = method.getResponseHeaders(HEADER_SET_COOKIE);            
 			for (int i = 0; i < hdr.length; i++) {
                 cookieManager.addCookieFromHeader(hdr[i].getValue(),u);
 			}
 		}
 	}
 	
 
 	public void threadStarted() {
 		log.debug("Thread Started");
         
 		// Does not need to be synchronised, as all access is from same thread
         httpClients.set ( new HashMap() );	
     }
 
 	public void threadFinished() {
 		log.debug("Thread Finished");
 
         // Does not need to be synchronised, as all access is from same thread
 		Map map = (Map)httpClients.get();
 
 		if ( map != null ) {
 			for ( Iterator it = map.entrySet().iterator(); it.hasNext(); )
 			{
 				Map.Entry entry = (Map.Entry) it.next();
 				HttpClient cl = (HttpClient) entry.getValue();
                 cl.getHttpConnectionManager().closeIdleConnections(-1000);// Closes the connection
 			}
 			map.clear();
 		}
 	}
 }
diff --git a/src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSamplerBase.java b/src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSamplerBase.java
index 2b6306d08..cac349b39 100644
--- a/src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSamplerBase.java
+++ b/src/protocol/http/org/apache/jmeter/protocol/http/sampler/HTTPSamplerBase.java
@@ -1,1019 +1,1029 @@
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
 import java.io.PrintStream;
 import java.net.MalformedURLException;
 import java.net.URL;
 import java.util.Arrays;
 import java.util.Collections;
 import java.util.HashMap;
 import java.util.Iterator;
 import java.util.List;
 import java.util.Map;
 
 import org.apache.jmeter.config.Argument;
 import org.apache.jmeter.config.Arguments;
 import org.apache.jmeter.engine.event.LoopIterationEvent;
 import org.apache.jmeter.protocol.http.control.AuthManager;
 import org.apache.jmeter.protocol.http.control.CookieManager;
 import org.apache.jmeter.protocol.http.control.HeaderManager;
 import org.apache.jmeter.protocol.http.parser.HTMLParseException;
 import org.apache.jmeter.protocol.http.parser.HTMLParser;
 import org.apache.jmeter.protocol.http.util.HTTPArgument;
 import org.apache.jmeter.samplers.AbstractSampler;
 import org.apache.jmeter.samplers.Entry;
 import org.apache.jmeter.samplers.SampleResult;
 import org.apache.jmeter.testelement.TestElement;
 import org.apache.jmeter.testelement.TestListener;
 import org.apache.jmeter.testelement.property.BooleanProperty;
 import org.apache.jmeter.testelement.property.IntegerProperty;
 import org.apache.jmeter.testelement.property.JMeterProperty;
 import org.apache.jmeter.testelement.property.PropertyIterator;
 import org.apache.jmeter.testelement.property.StringProperty;
 import org.apache.jmeter.testelement.property.TestElementProperty;
 import org.apache.jmeter.util.JMeterUtils;
 import org.apache.jorphan.logging.LoggingManager;
 import org.apache.jorphan.util.JOrphanUtils;
 import org.apache.log.Logger;
 
 /**
  * Common constants and methods for HTTP samplers
  * 
  */
 public abstract class HTTPSamplerBase extends AbstractSampler implements TestListener {
 
     private static final Logger log = LoggingManager.getLoggerForClass();
 
 	public static final int DEFAULT_HTTPS_PORT = 443;
 
 	public static final int    DEFAULT_HTTP_PORT = 80;
     public static final String DEFAULT_HTTP_PORT_STRING = "80"; // $NON-NLS-1$
 
 	public final static String ARGUMENTS = "HTTPsampler.Arguments"; // $NON-NLS-1$
 
 	public final static String AUTH_MANAGER = "HTTPSampler.auth_manager"; // $NON-NLS-1$
 
 	public final static String COOKIE_MANAGER = "HTTPSampler.cookie_manager"; // $NON-NLS-1$
 
 	public final static String HEADER_MANAGER = "HTTPSampler.header_manager"; // $NON-NLS-1$
 
 	public final static String MIMETYPE = "HTTPSampler.mimetype"; // $NON-NLS-1$
 
 	public final static String DOMAIN = "HTTPSampler.domain"; // $NON-NLS-1$
 
 	public final static String PORT = "HTTPSampler.port"; // $NON-NLS-1$
 
 	public final static String METHOD = "HTTPSampler.method"; // $NON-NLS-1$
 
+	public final static String CONTENT_ENCODING = "HTTPSampler.contentEncoding"; // $NON-NLS-1$
+
     public final static String IMPLEMENTATION = "HTTPSampler.implementation"; // $NON-NLS-1$
 
     public final static String PATH = "HTTPSampler.path"; // $NON-NLS-1$
 
 	public final static String FOLLOW_REDIRECTS = "HTTPSampler.follow_redirects"; // $NON-NLS-1$
 
 	public final static String AUTO_REDIRECTS = "HTTPSampler.auto_redirects"; // $NON-NLS-1$
 
 	public final static String PROTOCOL = "HTTPSampler.protocol"; // $NON-NLS-1$
 
     public static final String PROTOCOL_HTTP = "http"; // $NON-NLS-1$
 
     public static final String PROTOCOL_HTTPS = "https"; // $NON-NLS-1$
 
     public final static String DEFAULT_PROTOCOL = PROTOCOL_HTTP;
 
 	public final static String URL = "HTTPSampler.URL"; // $NON-NLS-1$
 
     public final static String HEAD = "HEAD"; // $NON-NLS-1$
     
 	public final static String POST = "POST"; // $NON-NLS-1$
 
     public final static String PUT = "PUT"; // $NON-NLS-1$
 
 	public final static String GET = "GET"; // $NON-NLS-1$
 
     public final static String OPTIONS = "OPTIONS"; // $NON-NLS-1$
     public final static String TRACE = "TRACE"; // $NON-NLS-1$
     public final static String DELETE = "DELETE"; // $NON-NLS-1$
 
     public final static String DEFAULT_METHOD = "GET"; // $NON-NLS-1$
     // Supported methods:
     private final static String [] METHODS = {
         DEFAULT_METHOD, // i.e. GET
         POST,
         HEAD,
         PUT,
         OPTIONS,
         TRACE,
         DELETE,
         };
     
     public final static List METHODLIST = Collections.unmodifiableList(Arrays.asList(METHODS));
 
     
 	public final static String USE_KEEPALIVE = "HTTPSampler.use_keepalive"; // $NON-NLS-1$
 
 	public final static String FILE_NAME = "HTTPSampler.FILE_NAME"; // $NON-NLS-1$
 
     /* Shown as Parameter Name on the GUI */
 	public final static String FILE_FIELD = "HTTPSampler.FILE_FIELD"; // $NON-NLS-1$
 
 	public final static String FILE_DATA = "HTTPSampler.FILE_DATA"; // $NON-NLS-1$
 
 	public final static String FILE_MIMETYPE = "HTTPSampler.FILE_MIMETYPE"; // $NON-NLS-1$
 
 	public final static String CONTENT_TYPE = "HTTPSampler.CONTENT_TYPE"; // $NON-NLS-1$
 
 	public final static String NORMAL_FORM = "normal_form"; // $NON-NLS-1$
 
 	public final static String MULTIPART_FORM = "multipart_form"; // $NON-NLS-1$
 
 	// public final static String ENCODED_PATH= "HTTPSampler.encoded_path";
 	public final static String IMAGE_PARSER = "HTTPSampler.image_parser"; // $NON-NLS-1$
 
 	public final static String MONITOR = "HTTPSampler.monitor"; // $NON-NLS-1$
 
 	/** A number to indicate that the port has not been set. * */
 	public static final int UNSPECIFIED_PORT = 0;
     public static final String UNSPECIFIED_PORT_AS_STRING = "0";
 
 	protected final static String NON_HTTP_RESPONSE_CODE = "Non HTTP response code";
 
 	protected final static String NON_HTTP_RESPONSE_MESSAGE = "Non HTTP response message";
 
     private static final String ARG_VAL_SEP = "="; // $NON-NLS-1$
 
     private static final String QRY_SEP = "&"; // $NON-NLS-1$
 
     private static final String QRY_PFX = "?"; // $NON-NLS-1$
 
     protected static final int MAX_REDIRECTS = JMeterUtils.getPropDefault("httpsampler.max_redirects", 5); // $NON-NLS-1$
 
     protected static final int MAX_FRAME_DEPTH = JMeterUtils.getPropDefault("httpsampler.max_frame_depth", 5); // $NON-NLS-1$
 
     protected static final String HEADER_AUTHORIZATION = "Authorization"; // $NON-NLS-1$
 
     protected static final String HEADER_COOKIE = "Cookie"; // $NON-NLS-1$
 
     protected static final String HEADER_CONNECTION = "Connection"; // $NON-NLS-1$
 
     protected static final String CONNECTION_CLOSE = "close"; // $NON-NLS-1$
 
     protected static final String KEEP_ALIVE = "keep-alive"; // $NON-NLS-1$
 
     protected static final String TRANSFER_ENCODING = "transfer-encoding";
 
     protected static final String HTTP_1_1 = "HTTP/1.1"; // $NON-NLS-1$
 
     protected static final String HEADER_SET_COOKIE = "set-cookie"; // $NON-NLS-1$
 
     protected static final String ENCODING_GZIP = "gzip"; // $NON-NLS-1$
 
     protected static final String HEADER_CONTENT_DISPOSITION = "Content-Disposition"; // $NON-NLS-1$
 
     protected static final String HEADER_CONTENT_TYPE = "Content-Type"; // $NON-NLS-1$
 
     protected static final String HEADER_CONTENT_LENGTH = "Content-Length"; // $NON-NLS-1$
 
     protected static final String HEADER_LOCATION = "Location"; // $NON-NLS-1$
 
 	protected static final String APPLICATION_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";
 
     // Derive the mapping of content types to parsers
     private static Map parsersForType = new HashMap();
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
     
     ////////////////////// Variables //////////////////////
     
     private boolean dynamicPath = false;// Set false if spaces are already encoded
 
     ////////////////////// Code ///////////////////////////
     
     public HTTPSamplerBase() {
 		setArguments(new Arguments());
 	}
 
     /**
      * The name parameter to be applied to the file
      */
 	public void setFileField(String value) {
 		setProperty(FILE_FIELD, value);
 	}
 
     /**
      * The name parameter to be applied to the file
      */
 	public String getFileField() {
 		return getPropertyAsString(FILE_FIELD);
 	}
 
     /**
      * The actual name of the file to POST
      */
 	public void setFilename(String value) {
 		setProperty(FILE_NAME, value);
 	}
 
     /**
      * The actual name of the file to POST
      */
 	public String getFilename() {
 		return getPropertyAsString(FILE_NAME);
 	}
 
 	/**
 	 * Determine if the file should be sent as the entire Post body,
 	 * i.e. without any additional wrapping
 	 * 
 	 * @return true if specified file is to be sent as the body,
 	 * i.e. both FileField and MimeType are blank
 	 */
 	public boolean getSendFileAsPostBody(){
 		return getFileField().length()== 0 && getMimetype().length() == 0;
 	}
 
 	public void setProtocol(String value) {
 		setProperty(PROTOCOL, value.toLowerCase());
 	}
 
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
 		if (GET.equals(getMethod())) {
 			int index = path.indexOf(QRY_PFX);
 			if (index > -1) {
 				setProperty(PATH, path.substring(0, index));
 				parseArguments(path.substring(index + 1));
 			} else {
 				setProperty(PATH, path);
 			}
 		} else {
 			setProperty(PATH, path);
 		}
 	}
 
 	public String getPath() {
 		String p = getPropertyAsString(PATH);
 		if (dynamicPath) {
 			return encodeSpaces(p);
 		}
 		return p;
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
 
+	public void setContentEncoding(String value) {
+		setProperty(CONTENT_ENCODING, value);
+	}
+
+	public String getContentEncoding() {
+		return getPropertyAsString(CONTENT_ENCODING);
+	}
+
 	public void setUseKeepAlive(boolean value) {
 		setProperty(new BooleanProperty(USE_KEEPALIVE, value));
 	}
 
 	public boolean getUseKeepAlive() {
 		return getPropertyAsBoolean(USE_KEEPALIVE);
 	}
 
 	public void setMonitor(String value) {
 		this.setProperty(MONITOR, value);
 	}
 
     public void setMonitor(boolean truth) {
         this.setProperty(MONITOR, JOrphanUtils.booleanToString(truth));
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
 
     /**
      * Add an argument which has already been encoded
      */
     public void addEncodedArgument(String name, String value) {
         this.addEncodedArgument(name, value, ARG_VAL_SEP);
     }
 
 	public void addEncodedArgument(String name, String value, String metaData) {
         if (log.isDebugEnabled()){
 		    log.debug("adding argument: name: " + name + " value: " + value + " metaData: " + metaData);
         }
 
         
 		HTTPArgument arg = new HTTPArgument(name, value, metaData, true);
 
 		if (arg.getName().equals(arg.getEncodedName()) && arg.getValue().equals(arg.getEncodedValue())) {
 			arg.setAlwaysEncoded(false);
 		}
 		this.getArguments().addArgument(arg);
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
 
 	public void addTestElement(TestElement el) {
 		if (el instanceof CookieManager) {
 			setCookieManager((CookieManager) el);
 		} else if (el instanceof HeaderManager) {
 			setHeaderManager((HeaderManager) el);
 		} else if (el instanceof AuthManager) {
 			setAuthManager((AuthManager) el);
 		} else {
 			super.addTestElement(el);
 		}
 	}
 
 	public void setPort(int value) {
 		setProperty(new IntegerProperty(PORT, value));
 	}
 
     public static int getDefaultPort(String protocol,int port){
         if (port==-1){
             return 
                 protocol.equalsIgnoreCase(PROTOCOL_HTTP)  ? DEFAULT_HTTP_PORT :
                 protocol.equalsIgnoreCase(PROTOCOL_HTTPS) ? DEFAULT_HTTPS_PORT :
                     port;
         }
         return port;
     }
     
 	public int getPort() {
 		int port = getPropertyAsInt(PORT);
 		if (port == UNSPECIFIED_PORT) {
 			String prot = getProtocol();
             if (PROTOCOL_HTTPS.equalsIgnoreCase(prot)) {
 				return DEFAULT_HTTPS_PORT;
 			}
             if (!PROTOCOL_HTTP.equalsIgnoreCase(prot)) {
                 log.warn("Unexpected protocol: "+prot);
                 // TODO - should this return something else?
             }
 			return DEFAULT_HTTP_PORT;
 		}
 		return port;
 	}
 
 	public void setDomain(String value) {
 		setProperty(DOMAIN, value);
 	}
 
 	public String getDomain() {
 		return getPropertyAsString(DOMAIN);
 	}
 
 	public void setArguments(Arguments value) {
 		setProperty(new TestElementProperty(ARGUMENTS, value));
 	}
 
 	public Arguments getArguments() {
 		return (Arguments) getProperty(ARGUMENTS).getObjectValue();
 	}
 
 	public void setAuthManager(AuthManager value) {
 		AuthManager mgr = getAuthManager();
 		if (mgr != null) {
 			log.warn("Existing Manager " + mgr.getName() + " superseded by " + value.getName());
 		}
 		setProperty(new TestElementProperty(AUTH_MANAGER, value));
 	}
 
 	public AuthManager getAuthManager() {
 		return (AuthManager) getProperty(AUTH_MANAGER).getObjectValue();
 	}
 
 	public void setHeaderManager(HeaderManager value) {
 		HeaderManager mgr = getHeaderManager();
 		if (mgr != null) {
 			log.warn("Existing Manager " + mgr.getName() + " superseded by " + value.getName());
 		}
 		setProperty(new TestElementProperty(HEADER_MANAGER, value));
 	}
 
 	public HeaderManager getHeaderManager() {
 		return (HeaderManager) getProperty(HEADER_MANAGER).getObjectValue();
 	}
 
 	public void setCookieManager(CookieManager value) {
 		CookieManager mgr = getCookieManager();
 		if (mgr != null) {
 			log.warn("Existing Manager " + mgr.getName() + " superseded by " + value.getName());
 		}
 		setProperty(new TestElementProperty(COOKIE_MANAGER, value));
 	}
 
 	public CookieManager getCookieManager() {
 		return (CookieManager) getProperty(COOKIE_MANAGER).getObjectValue();
 	}
 
 	public void setMimetype(String value) {
 		setProperty(MIMETYPE, value);
 	}
 
 	public String getMimetype() {
 		return getPropertyAsString(MIMETYPE);
 	}
 
 	public boolean isImageParser() {
 		return getPropertyAsBoolean(IMAGE_PARSER);
 	}
 
 	public void setImageParser(boolean parseImages) {
 		setProperty(new BooleanProperty(IMAGE_PARSER, parseImages));
 	}
 
 	/**
 	 * Obtain a result that will help inform the user that an error has occured
 	 * during sampling, and how long it took to detect the error.
 	 * 
 	 * @param e
 	 *            Exception representing the error.
 	 * @param current
 	 *            SampleResult
 	 * @return a sampling result useful to inform the user about the exception.
 	 */
 	protected HTTPSampleResult errorResult(Throwable e, HTTPSampleResult res) {
 		res.setSampleLabel("Error");
 		res.setDataType(HTTPSampleResult.TEXT);
 		ByteArrayOutputStream text = new ByteArrayOutputStream(200);
 		e.printStackTrace(new PrintStream(text));
 		res.setResponseData(text.toByteArray());
 		res.setResponseCode(NON_HTTP_RESPONSE_CODE+": "+e.getClass().getName());
 		res.setResponseMessage(NON_HTTP_RESPONSE_MESSAGE+": "+e.getMessage());
 		res.setSuccessful(false);
 		res.setMonitor(this.isMonitor());
 		return res;
 	}
 
 	/**
 	 * Get the URL, built from its component parts.
 	 * 
 	 * @return The URL to be requested by this sampler.
 	 * @throws MalformedURLException
 	 */
 	public URL getUrl() throws MalformedURLException {
 		StringBuffer pathAndQuery = new StringBuffer(100);
 		String path = this.getPath();
         if (!path.startsWith("/")){ // $NON-NLS-1$
             pathAndQuery.append("/"); // $NON-NLS-1$
         }
         pathAndQuery.append(path);
         if (this.getMethod().equals(GET) && getQueryString().length() > 0) {
 			if (path.indexOf(QRY_PFX) > -1) {
 				pathAndQuery.append(QRY_SEP);
 			} else {
 				pathAndQuery.append(QRY_PFX);
 			}
             pathAndQuery.append(getQueryString());
 		}
 		if (getPort() == UNSPECIFIED_PORT || getPort() == DEFAULT_HTTP_PORT) {
 			return new URL(getProtocol(), getDomain(), pathAndQuery.toString());
 		}
 		return new URL(getProtocol(), getPropertyAsString(DOMAIN), getPort(), pathAndQuery.toString());
 	}
 
 	/**
 	 * Gets the QueryString attribute of the UrlConfig object.
 	 * 
 	 * @return the QueryString value
 	 */
 	public String getQueryString() {
 		StringBuffer buf = new StringBuffer();
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
 			if (!first) {
 				buf.append(QRY_SEP);
 			} else {
 				first = false;
 			}
 			buf.append(item.getEncodedName());
 			if (item.getMetaData() == null) {
 				buf.append(ARG_VAL_SEP);
 			} else {
 				buf.append(item.getMetaData());
 			}
 			buf.append(item.getEncodedValue());
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
 	 *            the query string
 	 * 
 	 */
 	public void parseArguments(String queryString) {
 		String[] args = JOrphanUtils.split(queryString, QRY_SEP);
 		for (int i = 0; i < args.length; i++) {
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
                 // The browser has already done the encoding, so save the values as is 
                 HTTPArgument arg = new HTTPArgument(name, value, metaData, false);
                 // and make sure they stay that way:
                 arg.setAlwaysEncoded(false);
                 // Note that URL.encode()/decode() do not follow RFC3986 entirely
 				this.getArguments().addArgument(arg);
 				// TODO: this leaves the arguments in encoded form, which may be difficult to read
                 // if we can find proper coding methods, this could be tidied up 
             }
 		}
 	}
 
 	public String toString() {
 		try {
 			return this.getUrl().toString() + ((POST.equals(getMethod())) ? "\nQuery Data: " + getQueryString() : "");
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
 			res.setSampleLabel(getName());
 			return res;
 		} catch (MalformedURLException e) {
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
      * @param url
      *            URL to sample
      * @param method
      *            HTTP method: GET, POST,...
      * @param areFollowingRedirect
      *            whether we're getting a redirect target
      * @param frameDepth
      *            Depth of this target in the frame structure. Used only to
      *            prevent infinite recursion.
      * @return results of the sampling
      */
 	protected abstract HTTPSampleResult sample(URL u, 
             String method, boolean areFollowingRedirect, int depth);
 
 	/**
 	 * Download the resources of an HTML page.
 	 * <p>
 	 * If createContainerResult is true, the returned result will contain one
 	 * subsample for each request issued, including the original one that was
 	 * passed in. It will otherwise look exactly like that original one.
 	 * <p>
 	 * If createContainerResult is false, one subsample will be added to the
 	 * provided result for each requests issued.
 	 * 
 	 * @param res
 	 *            result of the initial request - must contain an HTML response
 	 * @param container
 	 *            for storing the results
 	 * @param frameDepth
 	 *            Depth of this target in the frame structure. Used only to
 	 *            prevent infinite recursion.
 	 * @return "Container" result with one subsample per request issued
 	 */
 	protected HTTPSampleResult downloadPageResources(HTTPSampleResult res, HTTPSampleResult container, int frameDepth) {
 		Iterator urls = null;
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
                     urls = parser.getEmbeddedResourceURLs(responseData, res.getURL());
     			} 
             }
 		} catch (HTMLParseException e) {
 			// Don't break the world just because this failed:
 			res.addSubResult(errorResult(e, res));
 			res.setSuccessful(false);
 		}
 
 		// Iterate through the URLs and download each image:
 		if (urls != null && urls.hasNext()) {
 			if (container == null) {
 				res = new HTTPSampleResult(res);
 			} else {
 				res = container;
 			}
 
 			while (urls.hasNext()) {
 				Object binURL = urls.next();
 				try {
 					URL url = (URL) binURL;
                     String urlstr = url.toString();
                     String urlStrEnc=encodeSpaces(urlstr);
                     if (!urlstr.equals(urlStrEnc)){// There were some spaces in the URL
                         try {
                             url = new URL(urlStrEnc);
                         } catch (MalformedURLException e) {
                             res.addSubResult(errorResult(new Exception(urlStrEnc + " is not a correct URI"), res));
                             res.setSuccessful(false);
                             continue;
                         }
                     }
                     HTTPSampleResult binRes = sample(url, GET, false, frameDepth + 1);
 					res.addSubResult(binRes);
 					res.setSuccessful(res.isSuccessful() && binRes.isSuccessful());
 				} catch (ClassCastException e) {
 					res.addSubResult(errorResult(new Exception(binURL + " is not a correct URI"), res));
 					res.setSuccessful(false);
 					continue;
                 }
 			}
 		}
 		return res;
 	}
 
     /*
      * @param res HTTPSampleResult to check
      * @return parser class name (may be "") or null if entry does not exist
      */
     private String getParserClass(HTTPSampleResult res) {
         final String ct = res.getMediaType();
         return (String)parsersForType.get(ct);
     }
 
     // TODO: make static?
 	protected String encodeSpaces(String path) {
         return JOrphanUtils.replaceAllChars(path, ' ', "%20"); // $NON-NLS-1$
 	}
 
 	/*
 	 * (non-Javadoc)
 	 * 
 	 * @see org.apache.jmeter.testelement.TestListener#testEnded()
 	 */
 	public void testEnded() {
 		dynamicPath = false;
 	}
 
 	/*
 	 * (non-Javadoc)
 	 * 
 	 * @see org.apache.jmeter.testelement.TestListener#testEnded(java.lang.String)
 	 */
 	public void testEnded(String host) {
 		testEnded();
 	}
 
 	/*
 	 * (non-Javadoc)
 	 * 
 	 * @see org.apache.jmeter.testelement.TestListener#testIterationStart(org.apache.jmeter.engine.event.LoopIterationEvent)
 	 */
 	public void testIterationStart(LoopIterationEvent event) {
 	}
 
 	/*
 	 * (non-Javadoc)
 	 * 
 	 * @see org.apache.jmeter.testelement.TestListener#testStarted()
 	 */
 	public void testStarted() {
 		JMeterProperty pathP = getProperty(PATH);
 		log.debug("path property is a " + pathP.getClass().getName());
 		log.debug("path beginning value = " + pathP.getStringValue());
 		if (pathP instanceof StringProperty && !"".equals(pathP.getStringValue())) {
 			log.debug("Encoding spaces in path");
 			pathP.setObjectValue(encodeSpaces(pathP.getStringValue()));
             dynamicPath = false;
 		} else {
 			log.debug("setting dynamic path to true");
 			dynamicPath = true;
 		}
 		log.debug("path ending value = " + pathP.getStringValue());
 	}
 
 	/*
 	 * (non-Javadoc)
 	 * 
 	 * @see org.apache.jmeter.testelement.TestListener#testStarted(java.lang.String)
 	 */
 	public void testStarted(String host) {
 		testStarted();
 	}
 
 	/*
 	 * (non-Javadoc)
 	 * 
 	 * @see java.lang.Object#clone()
 	 */
 	public Object clone() {
 		HTTPSamplerBase base = (HTTPSamplerBase) super.clone();
 		base.dynamicPath = dynamicPath;
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
 		HTTPSampleResult lastRes = res;
 
 		int redirect;
 		for (redirect = 0; redirect < MAX_REDIRECTS; redirect++) {
 			String location = encodeSpaces(lastRes.getRedirectLocation());
 			// Browsers seem to tolerate Location headers with spaces,
 			// replacing them automatically with %20. We want to emulate
 			// this behaviour.
 			try {
 				lastRes = sample(new URL(lastRes.getURL(), location), GET, true, frameDepth);
 			} catch (MalformedURLException e) {
 				lastRes = errorResult(e, lastRes);
 			}
 			if (lastRes.getSubResults() != null && lastRes.getSubResults().length > 0) {
 				SampleResult[] subs = lastRes.getSubResults();
 				for (int i = 0; i < subs.length; i++) {
 					totalRes.addSubResult(subs[i]);
 				}
 			} else
 				totalRes.addSubResult(lastRes);
 
 			if (!lastRes.isRedirect()) {
 				break;
 			}
 		}
 		if (redirect >= MAX_REDIRECTS) {
 			lastRes = errorResult(new IOException("Exceeeded maximum number of redirects: " + MAX_REDIRECTS), lastRes);
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
         totalRes.setDataEncoding(lastRes.getDataEncoding());
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
 	 * @param areFollowingRedirect
 	 * @param frameDepth
 	 * @param res
 	 * @return
 	 */
 	protected HTTPSampleResult resultProcessing(boolean areFollowingRedirect, int frameDepth, HTTPSampleResult res) {
 		if (!areFollowingRedirect) {
 			if (res.isRedirect()) {
 				log.debug("Location set to - " + res.getRedirectLocation());
 
 				if (getFollowRedirects()) {
 					res = followRedirects(res, frameDepth);
 					areFollowingRedirect = true;
 				}
 			}
 		}
 		if (isImageParser() && (HTTPSampleResult.TEXT).equals(res.getDataType()) && res.isSuccessful()) {
 			if (frameDepth > MAX_FRAME_DEPTH) {
 				res.addSubResult(errorResult(new Exception("Maximum frame/iframe nesting depth exceeded."), res));
 			} else {
 				// If we followed redirects, we already have a container:
 				HTTPSampleResult container = (HTTPSampleResult) (areFollowingRedirect ? res.getParent() : res);
 
 				res = downloadPageResources(res, container, frameDepth);
 			}
 		}
 		return res;
 	}
     
     /**
      * Determine if the HTTP status code is successful or not
      * i.e. in range 200 to 399 inclusive
      * 
      * @return whether in range 200-399 or not
      */
     protected boolean isSuccessCode(int code){
         return (code >= 200 && code <= 399);
     }
 
     protected static String encodeBackSlashes(String value) {
     	StringBuffer newValue = new StringBuffer();
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
 
     public static String[] getValidMethodsAsArray(){
         return (String[]) METHODLIST.toArray(new String[0]);
     }
 
     public static boolean isSecure(String protocol){
         return PROTOCOL_HTTPS.equalsIgnoreCase(protocol);
     }
     
     public static boolean isSecure(URL url){
         return isSecure(url.getProtocol());
     }
 }
 
diff --git a/src/protocol/http/org/apache/jmeter/protocol/http/sampler/PostWriter.java b/src/protocol/http/org/apache/jmeter/protocol/http/sampler/PostWriter.java
index 2066c362d..162c79816 100644
--- a/src/protocol/http/org/apache/jmeter/protocol/http/sampler/PostWriter.java
+++ b/src/protocol/http/org/apache/jmeter/protocol/http/sampler/PostWriter.java
@@ -1,192 +1,198 @@
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
 
 package org.apache.jmeter.protocol.http.sampler;
 
 import java.io.BufferedInputStream;
 import java.io.FileInputStream;
 import java.io.IOException;
 import java.io.InputStream;
 import java.io.OutputStream;
-import java.io.PrintWriter;
+import java.io.OutputStreamWriter;
 import java.io.UnsupportedEncodingException;
 import java.net.HttpURLConnection;
 import java.net.URLConnection;
 
 import org.apache.jmeter.config.Argument;
 import org.apache.jmeter.testelement.property.PropertyIterator;
 
 /**
  */
 
 public class PostWriter {
     
 	private static final String DASH_DASH = "--";  // $NON-NLS-1$
 
     protected final static String BOUNDARY = "---------------------------7d159c1302d0y0"; // $NON-NLS-1$
 
 	private final static byte[] CRLF = { 0x0d, 0x0A };
 
 	protected static final String encoding = "iso-8859-1"; // $NON-NLS-1$
 
 	// Not instantiable
 	private PostWriter(){
 		
 	}
 	/**
 	 * Send POST data from Entry to the open connection.
 	 */
 	public static void sendPostData(URLConnection connection, HTTPSampler sampler) throws IOException {
 		// If filename was specified then send the post using multipart syntax
 		String filename = sampler.getFilename();
 		if ((filename != null) && (filename.trim().length() > 0)) {
 			OutputStream out = connection.getOutputStream();
 			// Check if not using multi-part:
             if (sampler.getSendFileAsPostBody())
             {
                 InputStream in = getFileStream(filename);
                 byte[] buf = new byte[1024];
                 int read;
                 while ((read = in.read(buf)) > 0)
                 {
                     out.write(buf, 0, read);
                 }
                 out.flush();
                 in.close();
                 return;
             }
 			writeln(out, DASH_DASH + BOUNDARY);
 			PropertyIterator args = sampler.getArguments().iterator();
 			while (args.hasNext()) {
 				Argument arg = (Argument) args.next().getObjectValue();
 				writeFormMultipartStyle(out, arg.getName(), arg.getValue());
 				writeln(out, DASH_DASH + BOUNDARY);
 			}
 			writeFileToURL(out, filename, sampler.getFileField(), getFileStream(filename), sampler.getMimetype());
 
 			writeln(out, DASH_DASH + BOUNDARY + DASH_DASH);
 			out.flush();
 			out.close();
 		}
 
 		// No filename specified, so send the post using normal syntax
 		else {
 			String postData = sampler.getQueryString();
-			PrintWriter out = new PrintWriter(connection.getOutputStream());
-			out.print(postData);
+			final String contentEncoding = sampler.getContentEncoding();
+			OutputStreamWriter out;
+			if (contentEncoding.length() > 0) {
+			out = new OutputStreamWriter(connection.getOutputStream(), contentEncoding);
+			} else {
+				out = new OutputStreamWriter(connection.getOutputStream());				
+			}
+			out.write(postData);
 			out.flush();
             out.close();
 		}
 	}
 
 	public static void setHeaders(URLConnection connection, HTTPSampler sampler) throws IOException {
 		((HttpURLConnection) connection).setRequestMethod(HTTPSamplerBase.POST);
 
 		// If filename was specified then send the post using multipart syntax
 		String filename = sampler.getFilename();
 		if ((filename != null) && (filename.trim().length() > 0)) {
 			if (!sampler.getSendFileAsPostBody()) { // unless the file is the body...
 				String hct= connection.getRequestProperty(HTTPSamplerBase.HEADER_CONTENT_TYPE);
 				if (hct == null || hct.length() == 0) {
 			        connection.setRequestProperty(HTTPSamplerBase.HEADER_CONTENT_TYPE, 
                         "multipart/form-data; boundary=" + BOUNDARY); // $NON-NLS-1$
 				}
 			}
 			connection.setDoOutput(true);
 			connection.setDoInput(true);
 		}
 
 		// No filename specified, so send the post using normal syntax
 		else {
 			String postData = sampler.getQueryString();
 			connection.setRequestProperty(HTTPSamplerBase.HEADER_CONTENT_LENGTH, Integer.toString(postData.length()));
 			String hct= connection.getRequestProperty(HTTPSamplerBase.HEADER_CONTENT_TYPE);
 			if (hct == null || hct.length() == 0) {
 			    connection.setRequestProperty(HTTPSamplerBase.HEADER_CONTENT_TYPE, HTTPSamplerBase.APPLICATION_X_WWW_FORM_URLENCODED);
 			}
 			connection.setDoOutput(true);
 		}
 	}
 
 	private static InputStream getFileStream(String filename) throws IOException {
 		return new BufferedInputStream(new FileInputStream(filename));
 	}
 
 	/*
 	 * NOTUSED private String getContentLength(MultipartUrlConfig config) { long
 	 * size = 0; size += BOUNDARY.length() + 2; PropertyIterator iter =
 	 * config.getArguments().iterator(); while (iter.hasNext()) { Argument item =
 	 * (Argument) iter.next().getObjectValue(); size += item.getName().length() +
 	 * item.getValue().toString().length(); size += CRLF.length * 4; size +=
 	 * BOUNDARY.length() + 2; size += 39; } size += new
 	 * File(config.getFilename()).length(); size += CRLF.length * 5; size +=
 	 * BOUNDARY.length() + 2; size +=
 	 * encode(config.getFileFieldName()).length(); size +=
 	 * encode(config.getFilename()).length(); size +=
 	 * config.getMimeType().length(); size += 66; size += 2 + (CRLF.length * 1);
 	 * return Long.toString(size); }
 	 */
 
 	/**
 	 * Writes out the contents of a file in correct multipart format.
 	 */
 	private static void writeFileToURL(OutputStream out, String filename,
             String fieldname, InputStream in, String mimetype)
             throws IOException {
         write(out, "Content-Disposition: form-data; name=\""); // $NON-NLS-1$
         write(out, HTTPSamplerBase.encodeBackSlashes(fieldname));
         write(out, "\"; filename=\"");// $NON-NLS-1$
         write(out, HTTPSamplerBase.encodeBackSlashes(filename));
         writeln(out, "\""); // $NON-NLS-1$
         writeln(out, "Content-Type: " + mimetype); // $NON-NLS-1$
         out.write(CRLF);
 
         byte[] buf = new byte[1024];
         // 1k - the previous 100k made no sense (there's tons of buffers
         // elsewhere in the chain) and it caused OOM when many concurrent
         // uploads were being done. Could be fixed by increasing the evacuation
         // ratio in bin/jmeter[.bat], but this is better.
         int read;
         while ((read = in.read(buf)) > 0) {
             out.write(buf, 0, read);
         }
         out.write(CRLF);
         in.close();
     }
 
 	/**
 	 * Writes form data in multipart format.
 	 */
 	private static void writeFormMultipartStyle(OutputStream out, String name, String value) throws IOException {
 		writeln(out, "Content-Disposition: form-data; name=\"" + name + "\""); // $NON-NLS-1$ // $NON-NLS-2$
 		out.write(CRLF);
 		writeln(out, value);
 	}
 
     private static void write(OutputStream out, String value) 
     throws UnsupportedEncodingException, IOException 
     {
     	out.write(value.getBytes(encoding)); 
     }
 	
 
 	private static void writeln(OutputStream out, String value) throws UnsupportedEncodingException, IOException {
 		out.write(value.getBytes(encoding));
 		out.write(CRLF);
 	}
 }
diff --git a/xdocs/changes.xml b/xdocs/changes.xml
index 7a58f8a81..aa1e3b4e6 100644
--- a/xdocs/changes.xml
+++ b/xdocs/changes.xml
@@ -1,788 +1,789 @@
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
 <p><b>Changes are chronologically ordered from top (most recent) to bottom 
 (least recent)</b></p>  
 
 <!--  ===================  -->
 
 <h3>Version 2.2.1</h3>
 <h4>Known problems:</h4>
 <p>Thread active counts are always zero in CSV and XML files when running remote tests.
 </p>
 <p>The property file_format.testlog=2.1 is treated the same as 2.2.
 However JMeter does honour the 3 testplan versions.</p>
 <p>
 Bug 22510 - JMeter always uses the first entry in the keystore.
 </p>
 <h4>Incompatible changes (usage):</h4>
 <p>
 Bug 41104: JMeterThread behaviour was changed so that PostProcessors are run in forward order
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
 <h4>Incompatible changes (development):</h4>
 <p>
 Calulator and SamplingStatCalculator classes no longer provide any formatting of their data.
 Formatting should now be done using the jorphan.gui Renderer classes.
 </p>
 <p>
 Removed deprecated method JMeterUtils.split() - use JOrphanUtils version instead.
 </p>
 
 <h4>New functionality:</h4>
 <ul>
 <li>Added httpclient.parameters.file to allow HttpClient parameters to be defined</li>
 <li>Added beanshell.init.file property to run a BeanShell script at startup</li>
 <li>Added timeout for WebService (SOAP) Sampler</li>
 <li>Bug 40804 - Change Counter default to max = Long.MAX_VALUE</li>
 <li>BeanShell Post-Processor no longer ignores samples with zero-length result data</li>
 <li>Use property jmeter.home (if present) to override user.dir when starting JMeter</li>
 <li>Bug 41457 - Add TCP Sampler option to not re-use connections</li>
 <li>Bug 41522 - Use JUnit sampler name in sample results</li>
 <li>HttpClient now behaves the same as the JDK http sampler for invalid certificates etc</li>
 <li>Add Domain and Realm support to HTTP Authorisation Manager</li>
 <li>Bug 33964 - send file as entire post body if name/type are omitted</li>
 <li>HTTP Mirror Server Workbench element</li>
 <li>Bug 41253 - extend XPathExtractor to work with non-NodeList XPath expressions</li>
 <li>Bug 39717 - use icons in the results tree instead of colors</li>
 <li>Added __V variable function to resolve nested variable names</li>
 <li>Bug 41707 - HTTP Proxy XML-RPC support</li>
 <li>Bug 40381 - LDAP: more descriptive strings</li>
 <li>Bug 40369 (partial) Equals Response Assertion</li>
+<li>Bug 41705 - add content-encoding option to HTTP samplers</li>
 </ul>
 
 <h4>Non-functional improvements:</h4>
 <ul>
 <li>Functor calls can now be unit tested</li>
 <li>Replace com.sun.net classes with javax.net</li>
 <li>Extract external jar definitions into build.properties file</li>
 <li>Use specific jar names in build classpaths so errors are detected sooner</li>
 <li>Updated to: batik 1</li>
 </ul>
 
 <h4>External jar updates:</h4>
 <ul>
 <li>Htmlparser 2.0-20060923</li>
 <li>xstream 1.2.1/xpp3_min-1.1.3.4.O</li>
 <li>Batik 1.6</li>
 <li>BSF 2.4.0</li>
 <li>commons-collections 3.2</li>
 <li>commons-jexl 1.1</li>
 <li>velocity 1.4</li>
 <li></li>
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
 <li>Bug 40772 - correctly parse missing fields</li>
 <li>Bug 40773 - XML JTL not parsed correctly</li>
 <li>Bug 41029 - JMeter -t fails to close input JMX file</li>
 <li>Bug 40954 - Statistical mode in distributed testing shows wrong results</li>
 <li>Fix ClassCast Exception when using sampler that returns null, e..g TestAction</li>
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
 		of test samples.  It is what binds together a Sampler and it's test 
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
