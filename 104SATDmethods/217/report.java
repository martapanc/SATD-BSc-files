File path: src/components/org/apache/jmeter/visualizers/ViewResultsFullVisualizer.java
Comment:  clear what can cause this
Initial commit id: c66bf070
Final commit id: ff6a94c7
   Bugs between [       3]:
944144d7b Bug 26337 - show date of sample
60cacbb4f Bug 34796 - add Tooltips to XML Tree display
6aceb9d1a Bug 34649 - don't show root of tree
   Bugs after [      23]:
61304dee3 Bug 60564 - Migrating LogKit to SLF4J - Replace logkit loggers with slf4j ones with keeping the current logkit binding solution Contributed by Woonsan Ko #comment #266 Bugzilla Id: 60564
eb234b7aa Bug 60583 - VRT listener with JavaFX html view don't work with openjdk 8 Bugzilla Id: 60583
ac1f2c212 Bug 60542 - View Results Tree : Allow Upper Panel to be collapsed Contributed by UbikLoadPack Bugzilla Id: 60542
8cc1b70be Bug 59102 - View Results Tree: Better default value for "view.results.tree.max_size" Bugzilla Id: 59102
08efaaadc Bug 55597 View Results Tree: Add a search feature to search in recorded samplers
4321ec752 Bug 56228 - View Results Tree : Improve ergonomy by changing placement of Renderers and allowing custom ordering Bugzilla Id: 56228
b85f6c38c Bug 54226 - View Results Tree : Show response even when server does not return ContentType header Bugzilla Id: 54226
c0f98a933 Bug 52266 - Code:Inconsistent synchronization Bugzilla Id: 52266
ea4d5caba Bug 52694 - Deadlock in GUI related to non AWT Threads updating GUI
9845e49b4 Bug 52217 - ViewResultsFullVisualizer : Synchronization issues on root and treeModel
11668430e Bug 52022 - In View Results Tree rather than showing just a message if the results are to big, show as much of the result as are configured
3a87c8dc3 Bug 52003 - View Results Tree "Scroll automatically" does not scroll properly in case nodes are expanded
90d8067c4 Bug 42246 - don't override colour for autoscroll checkbox
c592cc4c2 Bug 42246 - Need for a 'auto-scroll' option in "View Results Tree" and "Assertion Results"
e5c108478 Bug 47474 - View Results Tree support for plugin renderers
dd20f3a41 Bug 36726 - add search function to Tree View Listener
447cb7f46 Bug 47137 - Labels in View Results Tree aren't I18N
6f9771e84 Bug 43450 - add save/restore of error count; fix Calculator to use error count
e09e4965b Bug 42582 - JSON pretty printing in Tree View Listener
d1bab6aed Bug 42184 - Number of bytes for subsamples not added to sample when sub samples are added
a585fdb25 Bug 41913 (19861) - fix ViewTree Assertion display; accumulate sub-sample byte-count
0a717bbad Bug 41873 - Add name to AssertionResult and display AssertionResult in ViewResultsFullVisualizer
607a2d815 Bug 39717 - use icons in the results tree instead of colors

Start block index: 1090
End block index: 1099
		 * Not clear what can cause this
         * ? conflicting versions perhaps
		 */
        public void warning(SAXParseException exception)
                throws SAXParseException 
        {
             msg="warning: "+errorDetails(exception);
			 log.debug(msg);
			 messageType = JOptionPane.WARNING_MESSAGE;
        }
