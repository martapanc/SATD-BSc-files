File path: src/core/org/apache/jmeter/save/SaveService.java
Comment: TODO should this be JTLSAVER? Only seems to be called by MonitorHealthVisualzer
Initial commit id: 663185ad
Final commit id: cb1112e3
   Bugs between [      30]:
2651c6ffc Bug 60727 - Drop commons-httpclient-3.1 and related elements Contributed by UbikLoadPack support Bugzilla Id: 60727
ea090c4eb Bug 60564 - Migrating LogKit to SLF4J - core/samplers,save,services,swing,testbeans (2/2) Contributed by Woonsan Ko This closes #271 Bugzilla Id: 60564
744b55d60 Bug 60423 - Drop Monitor Results listener Part 5 Fix sha Bugzilla Id: 60423
0bf26f41b Bug 60423 - Drop Monitor Results listener Part 1 Bugzilla Id: 60423
ca8b70dfe Bug 60222 - Remove deprecated elements Distribution Graph, Spline Visualizer Also update version in saveservice.properties to match version of JMeter Bugzilla Id: 60222
53ff0e8e5 Bug 59607 - JMeter crashes when reading large test plan (greater than 2g) Bugzilla Id: 59607
1ad626d26 Bug 59094 - Drop support of old JMX file format Bugzilla Id: 59094
e85059bca Bug 59064 - Remove OldSaveService which supported very old Avalon format JTL (result) files Bugzilla Id: 59064
ebf9d44bc Bug 58679 - Replace the xpp pull parser in xstream with a java6+ standard solution Bugzilla Id: 58679
f5a710739 Bug 57981 - Require a minimum of Java 7 Use Java7 resource management Bugzilla Id: 57981
fe5972e03 Bug 58515 - New JSON related components : JSON-PATH Extractor and JSON-PATH Renderer in View Results Tree Update SaveService svn revision id Bugzilla Id: 58515
5abea329b Bug 58515 - New JSON related components : JSON-PATH Extractor and JSON-PATH Renderer in View Results Tree Bugzilla Id: 58515
4cfdbcd88 [Bug 57605] When there is an error loading Test Plan, SaveService.loadTree returns null leading to NPE in callers Retain backward compatibility as per sebb note Bugzilla Id: 57605
40b3221e7 Bug 57605 - When there is an error loading Test Plan, SaveService.loadTree returns null leading to NPE in callers Bugzilla Id: 57605
5a5df9b8e Bug 57269 - Drop org.apache.jmeter.reports package Update FILEVERSION Bugzilla Id: 57269
903cdee27 Bug 57269 - Drop org.apache.jmeter.reports package Update FILEVERSION Bugzilla Id: 57269
7b0cf8db2 Bug 57193: Add param and return tags to javadoc Bugzilla Id: 57193
b17400f34 Bug 55932 - Create a Async BackendListener to allow easy plug of new listener (Graphite, JDBC, Console,...) Fix test failure Bugzilla Id: 55932
72e40dbc3 Bug 55932 - Create a Async BackendListener to allow easy plug of new listener (Graphite, JDBC, Console,...) Bugzilla Id: 55932
07705508c Bug 56975 - Error when opening JTL(XML) file (that saves sub samplers results) due to TreeMarshaller$CircularReferenceException: Recursive reference to parent object Adding more infos when error occurs (UbikLoadPack patch) Bugzilla Id: 56975
7505cfbe5 Bug 56728 - New Critical Section Controller to serialize blocks of a Test Bugzilla Id: 56728
182d536dd Bug 55589 - JMS Publisher/Point to Point : Add ability to set typed values in JMS header properties. Bugzilla Id: 55589
1d8085b74 Bug 55589 - JMS Publisher/Point to Point : Add ability to set typed values in JMS header properties. Bugzilla Id: 55589
392657edb Bug 54152 - In distributed testing : activeThreads and totalThreads always show 0 Fix test failure Bugzilla Id: 54152
93d0570db Bug 45772 - RegEx User Parameters Post Processor update revision saveservice Bugzilla Id: 45772
5015b6818 Bug 54259 - Introduce a CSS or jquery-like based Extractor update version and revision Bugzilla Id: 54259
baf3da4ab Bug 53841 - CSVSaveService reads file using JVM default file encoding instead of using the one configured in saveservice.properties
69459cfc9 Bug 53418 - New OnDemandThreadGroup that creates threads when needed instead of creating them on Test startup Fix SaveService fileVersion and version
c5e8b96e3 Bug 52466 - Upgrade Test Plan feature : NameUpdater does not upgrade properties (r1227589) Also need to upgrade top-level element names
d642aa92e Bug 52466 - Upgrade Test Plan feature : NameUpdater does not upgrade properties
   Bugs after [       0]:


Start block index: 335
End block index: 338
    public synchronized static void saveTestElement(TestElement elem, Writer writer) throws IOException {
        JMXSAVER.toXML(elem, writer); // TODO should this be JTLSAVER? Only seems to be called by MonitorHealthVisualzer
        writer.write('\n');
    }
