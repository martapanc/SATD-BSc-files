File path: src/core/org/apache/jmeter/JMeter.java
Comment: // TODO - could this be return?
Initial commit id: d9e4470c9
Final commit id: d894508ce
   Bugs between [      24]:
f464c9baf Bug 60053 - In Non GUI mode, a Stacktrace is shown at end of test while report is being generated Bugzilla Id: 60053
135483ac0 Bug 59391 - In Distributed mode, the client exits abnormally at the end of test Bugzilla Id: 59391
35cd20998 Bug 58986 - Report/Dashboard reuses the same output directory Factor in JOrphanUtils the check for output folder and make it more readable and complete Add the check in both HtmlTemplateExporter and JMeter as per sebb request Bugzilla Id: 58986
a75c821ad Bug 58986 - Report/Dashboard reuses the same output directory Bugzilla Id: 58986
9ee466a0e Bug 58987 - Report/Dashboard: Improve error reporting Avoid Log+Rethrow, only rethrow Add column index in message Bugzilla Id: 58987
04ba97a97 Bug 58781 - Command line option "-?" shows Unknown option Bugzilla Id: 58781
27745b727 Bug 58653 - New JMeter Dashboard/Report with Dynamic Graphs, Tables to help analyzing load test results Bugzilla Id: 58653
480c3656b Bug 57821 - Command-line option "-X --remoteexit" doesnt work since 2.13 (regression related to Bug 57500) Bugzilla Id: 57821
40b3221e7 Bug 57605 - When there is an error loading Test Plan, SaveService.loadTree returns null leading to NPE in callers Bugzilla Id: 57605
022af006b Bug 57500 - Introduce retry behavior for remote testing
321e520fe Bug 57365 - Selected LAF is not correctly setup due to call of UIManager.setLookAndFeel too late Fix test failure Bugzilla Id: 57365
b74853f78 Bug 57365 - Selected LAF is not correctly setup due to call of UIManager.setLookAndFeel too late Bugzilla Id: 57365
65bd9c284 Bug 57193: Add param and return tags to javadoc Bugzilla Id: 57193
be7f7415c Bug 55512 - Summariser should be enabled by default in Non GUI mode Bugzilla Id: 55512
849643223 Bug 54152 - In distributed testing : activeThreads and totalThreads always show 0 Add comment Bugzilla Id: 54152
8642a7617 Bug 54152 - In distributed testing : activeThreads and totalThreads always show 0 Bugzilla Id: 54152
90d52dfec Bug 55334 - Adding Include Controller to test plan (made of Include Controllers) without saving TestPlan leads to included code not being taken into account until save Bugzilla Id: 55334
4a2b1d231 Bug 54414 - Remote Test should not start if one of the engines fails to start correctly Bugzilla Id: 54414
1152bb1b5 Bug 52934 - GUI : Open Test plan with the tree expanded to the testplan level and no further and select the root of the tree
ba3cdcaf4 Bug 52346 - Shutdown detects if there are any non-daemon threads left which prevent JVM exit
5f7112827 Bug 51091 - New function returning the name of the current "Test Plan"
979329621 Bug 52029 - Command-line shutdown only gets sent to last engine that was started
04763b7d0 Bug 51831 - Cannot disable UDP server or change the maximum UDP port Also failed to check max port initially
dc1a76af6 Bug 50659 - JMeter server does not support concurrent tests - prevent client from starting another (part deux) Remove thread from ClientJMeterEngine - if it is required for GUI, then let the GUI create the thread This allows proper return of error conditions Also replace System.exit() with interrupt() of RMI thread
   Bugs after [       5]:
22288a776 Bug 60589 Migrate LogKit to SLF4J - Drop avalon, logkit and excalibur with backward compatibility for 3rd party modules. Contributed by Woonsan Ko Documenting log4j2 related changes since 3.2 This closes #278 Bugzilla Id: 60589
5f0651b4a Bug 60564 - Migrating LogKit to SLF4J - core, core/control, core/engine/ClientJMeterEngine Contributed by Woonsan Ko This closes #269 Bugzilla Id: 60564
9418f1a3d Bug 60589 - Migrate LogKit to SLF4J - Drop avalon, logkit and excalibur with backward compatibility for 3rd party modules Part 1 of PR #254 Contributed by Woonsan Ko
03a2728d2 Bug 59995 - Allow user to change font size with 2 new menu items and use "jmeter.hidpi.scale.factor" for scaling fonts Contributed by UbikLoadPack Bugzilla Id: 59995
5153cdb45 Bug 60595: Add a SplashScreen at the start of JMeter GUI Contributed by maxime.chassagneux at gmail.com This closes #251 Bugzilla Id: 60595

Start block index: 256
End block index: 372
    public void start(String[] args) {

        CLArgsParser parser = new CLArgsParser(args, options);
        String error = parser.getErrorString();
        if (error == null){// Check option combinations
            boolean gui = parser.getArgumentById(NONGUI_OPT)==null;
            boolean remoteStart = parser.getArgumentById(REMOTE_OPT)!=null
                               || parser.getArgumentById(REMOTE_OPT_PARAM)!=null;
            if (gui && remoteStart) {
                error = "-r and -R are only valid in non-GUI mode";
            }
        }
        if (null != error) {
            System.err.println("Error: " + error);
            System.out.println("Usage");
            System.out.println(CLUtil.describeOptions(options).toString());
            return;
        }
        try {
            initializeProperties(parser); // Also initialises JMeter logging

            /*
             * The following is needed for HTTPClient.
             * (originally tried doing this in HTTPSampler2,
             * but it appears that it was done too late when running in GUI mode)
             * Set the commons logging default to Avalon Logkit, if not already defined
             */
            if (System.getProperty("org.apache.commons.logging.Log") == null) { // $NON-NLS-1$
                System.setProperty("org.apache.commons.logging.Log" // $NON-NLS-1$
                        , "org.apache.commons.logging.impl.LogKitLogger"); // $NON-NLS-1$
            }

            log.info(JMeterUtils.getJMeterCopyright());
            log.info("Version " + JMeterUtils.getJMeterVersion());
            logProperty("java.version"); //$NON-NLS-1$
            logProperty("java.vm.name"); //$NON-NLS-1$
            logProperty("os.name"); //$NON-NLS-1$
            logProperty("os.arch"); //$NON-NLS-1$
            logProperty("os.version"); //$NON-NLS-1$
            logProperty("file.encoding"); // $NON-NLS-1$
            log.info("Default Locale=" + Locale.getDefault().getDisplayName());
            log.info("JMeter  Locale=" + JMeterUtils.getLocale().getDisplayName());
            log.info("JMeterHome="     + JMeterUtils.getJMeterHome());
            logProperty("user.dir","  ="); //$NON-NLS-1$
            log.info("PWD       ="+new File(".").getCanonicalPath());//$NON-NLS-1$
            log.info("IP: "+JMeterUtils.getLocalHostIP()
                    +" Name: "+JMeterUtils.getLocalHostName()
                    +" FullName: "+JMeterUtils.getLocalHostFullName());
            setProxy(parser);

            updateClassLoader();
            if (log.isDebugEnabled())
            {
                String jcp=System.getProperty("java.class.path");// $NON-NLS-1$
                String bits[] =jcp.split(File.pathSeparator);
                log.debug("ClassPath");
                for(int i = 0; i<bits.length ;i++){
                    log.debug(bits[i]);
                }
                log.debug(jcp);
            }

            // Set some (hopefully!) useful properties
            long now=System.currentTimeMillis();
            JMeterUtils.setProperty("START.MS",Long.toString(now));// $NON-NLS-1$
            Date today=new Date(now); // so it agrees with above
            // TODO perhaps should share code with __time() function for this...
            JMeterUtils.setProperty("START.YMD",new SimpleDateFormat("yyyyMMdd").format(today));// $NON-NLS-1$ $NON-NLS-2$
            JMeterUtils.setProperty("START.HMS",new SimpleDateFormat("HHmmss").format(today));// $NON-NLS-1$ $NON-NLS-2$

            if (parser.getArgumentById(VERSION_OPT) != null) {
                System.out.println(JMeterUtils.getJMeterCopyright());
                System.out.println("Version " + JMeterUtils.getJMeterVersion());
            } else if (parser.getArgumentById(HELP_OPT) != null) {
                System.out.println(JMeterUtils.getResourceFileAsText("org/apache/jmeter/help.txt"));// $NON-NLS-1$
            } else if (parser.getArgumentById(SERVER_OPT) != null) {
                // Start the server
                startServer(JMeterUtils.getPropDefault("server_port", 0));// $NON-NLS-1$
                startOptionalServers();
            } else {
                String testFile=null;
                CLOption testFileOpt = parser.getArgumentById(TESTFILE_OPT);
                if (testFileOpt != null){
                    testFile = testFileOpt.getArgument();
                    if (USE_LAST_JMX.equals(testFile)) {
                        testFile = LoadRecentProject.getRecentFile(0);// most recent
                    }
                }
                if (parser.getArgumentById(NONGUI_OPT) == null) {
                    startGui(testFile);
                    startOptionalServers();
                } else {
                    CLOption rem=parser.getArgumentById(REMOTE_OPT_PARAM);
                    if (rem==null) { rem=parser.getArgumentById(REMOTE_OPT); }
                    CLOption jtl = parser.getArgumentById(LOGFILE_OPT);
                    String jtlFile = null;
                    if (jtl != null){
                        jtlFile=processLAST(jtl.getArgument(), ".jtl"); // $NON-NLS-1$
                    }
                    startNonGui(testFile, jtlFile, rem);
                    startOptionalServers();
                }
            }
        } catch (IllegalUserActionException e) {
            System.out.println(e.getMessage());
            System.out.println("Incorrect Usage");
            System.out.println(CLUtil.describeOptions(options).toString());
        } catch (Throwable e) {
            if (log != null){
                log.fatalError("An error occurred: ",e);
            } else {
                e.printStackTrace();
            }
            System.out.println("An error occurred: " + e.getMessage());
            System.exit(1); // TODO - could this be return?
        }
    }
