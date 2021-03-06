File path: src/components/org/apache/jmeter/visualizers/StatGraphVisualizer.java
Comment: OT USED protected double[][] data = null
Initial commit id: 19424092
Final commit id: 24e22e43
   Bugs between [      13]:
1df17a5c3 Bug 60252 - Add sent kbytes/s to Aggregate Report and Summary report Bugzilla Id: 60252
ba6eb6362 Bug 58329 - Response Time Graph and Aggregate Graph : Save graph to file does not take into account the settings changed since last click on Graph Bugzilla Id: 58329
2038c1c9a Bug 57514 - Aggregate Graph, Summary Report and Aggregate Report show wrong percentage reporting in saved file Bugzilla Id: 57514
b4a4e92b6 Bug 57262 - Aggregate Report, Aggregate Graph and Summary Report export : headers use keys instead of labels Bugzilla Id: 57262
e1d2ee767 Bug 57217 - Aggregate graph and Aggregate report improvements (3 configurable percentiles, same data in both, factor out code) Bugzilla Id: 57217
6d991f29f Applied some improvements from Bug 53718 (new Response Time Graph) to Aggregate Graph
544a345a5 Bug 53070 - Change Aggregate graph to Clustered Bar chart, add more columns (median, 90% line, min, max) and options, fixed some bugs
ea4d5caba Bug 52694 - Deadlock in GUI related to non AWT Threads updating GUI
c05ba4594 Bug 52452 - Improvements on Aggregate Graph Listener (GUI and settings)
1755b2395 Bug 52215 - Confusing synchronization in StatVisualizer, SummaryReport ,Summariser and issue in StatGraphVisualizer
fd4f2374e Bug 44184 - Allow header to be saved with Aggregate Graph data
e861ae37d Bug 36755 (patch 20073) - consistent closing of file streams
cac1dd30b Bug 39652 - Allow truncation of labels on AxisGraph
   Bugs after [       2]:
2c2756776 Bug 60564 - Migrating LogKit to SLF4J - Replace logkit loggers with slf4j ones with keeping the current logkit binding solution Contributed by Woonsan Ko This closes #266 Bugzilla Id: 60564
343a9428b Bug 52962 - Allow sorting by columns for View Results in Table, Summary Report, Aggregate Report and Aggregate Graph Based on a contribution by Logan Mauzaize (logan.mauzaize at gmail.com) and Maxime Chassagneux This closes github pr #245 Bugzilla Id: 52962

Start block index: 108
End block index: 108
    
    //NOT USED protected double[][] data = null;
    