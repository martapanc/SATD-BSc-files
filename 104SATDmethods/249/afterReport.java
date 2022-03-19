/249/report.java
Satd-method: //    public void configureSampler(HTTPSampler sampler)
********************************************
********************************************
/249/After/Bug 27780  76ac18a7_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 
+    private static String USE_MULTIPART_FOR_POST = "use_multipart_for_post"; // $NON-NLS-1$
+        useMultipartForPost = new JCheckBox(JMeterUtils.getResString("use_multipart_for_http_post")); // $NON-NLS-1$
+            // Get the boundary string for the multiparts from the
+            // content type
-			// If no file is uploaded, then it was really a multipart/form-data
-			// post request. But currently, that is not supported, so we must
-			// change the "Content-Type" header from multipart/form-data to
-			// application/x-www-form-urlencoded, which is the one the HTTP Request
-			// sampler will send
+        // Check if it was a multipart http post request
+            // Tell the sampler to do a multipart post
+            // Remove the header for content-type and content-length, since
+            // those values will most likely be incorrect when the sampler
+            // performs the multipart request, because the boundary string
+            // will change
+            // Set the form data
+            // Set the file uploads

Lines added containing method: 12. Lines removed containing method: 5. Tot = 17
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	public TestElement createTestElement() {
+        element.setProperty(new BooleanProperty(HTTPSamplerBase.DO_MULTIPART_POST, useMultipartForPost.isSelected()));

Lines added: 1. Lines removed: 0. Tot = 1
********************************************
********************************************
/249/After/Bug 41705  90684a56_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 
+	private static String CONTENT_ENCODING = "content_encoding"; // $NON-NLS-1$
+		contentEncoding.setText(""); // $NON-NLS-1$
+		// CONTENT_ENCODING
+		JLabel contentEncodingLabel = new JLabel(JMeterUtils.getResString("content_encoding")); // $NON-NLS-1$
+            // If a content encoding is specified, we set it as http parameter, so that
+            // the post body will be encoded in the specified content encoding
+	public final static String CONTENT_ENCODING = "HTTPSampler.contentEncoding"; // $NON-NLS-1$

Lines added containing method: 7. Lines removed containing method: 0. Tot = 7
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	public void setUseKeepAlive(boolean value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setDomain(String value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setProtocol(String value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setPath(String path) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setFollowRedirects(boolean value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setPort(int value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setMethod(String value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public TestElement createTestElement() {
+		element.setProperty(HTTPSamplerBase.CONTENT_ENCODING, contentEncoding.getText());

Lines added: 1. Lines removed: 0. Tot = 1
—————————
Method found in diff:	public void setArguments(Arguments value) {

Lines added: 0. Lines removed: 0. Tot = 0
********************************************
********************************************
/249/After/Bug 50684  592bf6b7_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 
+            useBrowserCompatibleMultipartMode = new JCheckBox(JMeterUtils.getResString("use_multipart_mode_browser")); // $NON-NLS-1$
+    public static final String USE_KEEPALIVE = "HTTPSampler.use_keepalive"; // $NON-NLS-1$
+    public static final String DO_MULTIPART_POST = "HTTPSampler.DO_MULTIPART_POST"; // $NON-NLS-1$
+    public static final String BROWSER_COMPATIBLE_MULTIPART  = "HTTPSampler.BROWSER_COMPATIBLE_MULTIPART"; // $NON-NLS-1$
+    public static final boolean BROWSER_COMPATIBLE_MULTIPART_MODE_DEFAULT = false; // The default setting to be used (i.e. historic)
-    public static final String USE_KEEPALIVE = "HTTPSampler.use_keepalive"; // $NON-NLS-1$
-    public static final String DO_MULTIPART_POST = "HTTPSampler.DO_MULTIPART_POST"; // $NON-NLS-1$
-        writeln(out, "Content-Type: text/plain; charset=" + charSet); // $NON-NLS-1$
-        writeln(out, "Content-Transfer-Encoding: 8bit"); // $NON-NLS-1$
+            writeln(out, "Content-Type: text/plain; charset=" + charSet); // $NON-NLS-1$
+            writeln(out, "Content-Transfer-Encoding: 8bit"); // $NON-NLS-1$

Lines added containing method: 7. Lines removed containing method: 4. Tot = 11
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	protected void setUseKeepAlive(boolean b) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setDomain(String value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setProtocol(String value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setPath(String path) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setFollowRedirects(boolean value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setPort(int value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setMethod(String value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public TestElement createTestElement() {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setArguments(Arguments value) {

Lines added: 0. Lines removed: 0. Tot = 0
********************************************
********************************************
/249/After/Bug 51861  4b9cb415_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 
+    // Raw POST Body 
+    // Tabbed pane that contains parameters and raw body
+            postBodyContent.setText("");// $NON-NLS-1$
+    // FIXME FACTOR WITH HTTPHC4Impl, HTTPHC3Impl
+    // Just append all the parameter values, and use that as the post body
+        postContentTabbedPane.add(JMeterUtils.getResString("post_as_parameters"), argsPanel);// $NON-NLS-1$
+            postBodyContent = new JLabeledTextArea(JMeterUtils.getResString("post_body_raw"));// $NON-NLS-1$
+            postContentTabbedPane.add(JMeterUtils.getResString("post_body"), postBodyContent);// $NON-NLS-1$
+                    // If there is no data, then switching between Parameters and Raw should be
+                    // allowed with no further user interaction.
+                        // If RAW data and Parameters match we allow switching
+                            // If there is data in the Raw panel, then the user should be 
+                            // prevented from switching (that would be easy to track).
+                                    JMeterUtils.getResString("web_cannot_switch_tab"), // $NON-NLS-1$
+                                    JMeterUtils.getResString("warning"), // $NON-NLS-1$
+                        // If the Parameter data can be converted (i.e. no names), we 
+                        // warn the user that the Parameter data will be lost.
+                            // If the Parameter data cannot be converted to Raw, then the user should be
+                            // prevented from doing so raise an error dialog
+                                    JMeterUtils.getResString("web_cannot_convert_parameters_to_raw"), // $NON-NLS-1$
+                                    JMeterUtils.getResString("warning"), // $NON-NLS-1$
+    public static final String POST_BODY_RAW = "HTTPSampler.postBodyRaw"; // TODO - belongs elsewhere 

Lines added containing method: 22. Lines removed containing method: 0. Tot = 22
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	public void setUseKeepAlive(boolean value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setDomain(String value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setProtocol(String value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setPath(String path) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setFollowRedirects(boolean value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setPort(int value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setMethod(String value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public TestElement createTestElement() {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setArguments(Arguments value) {

Lines added: 0. Lines removed: 0. Tot = 0
********************************************
********************************************
/249/After/Bug 51861  dcf739f0_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 
+                value=value.replaceAll("\r\n", "\n"); // See modifyTestElement
+            String postBody = computePostBody(arguments, true); // Convert CRLF to CR, see modifyTestElement

Lines added containing method: 2. Lines removed containing method: 0. Tot = 2
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	public TestElement createTestElement() {

Lines added: 0. Lines removed: 0. Tot = 0
********************************************
********************************************
/249/After/Bug 52613  ddc3bf4d_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 

Lines added containing method: 0. Lines removed containing method: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	public TestElement createTestElement() {

Lines added: 0. Lines removed: 0. Tot = 0
********************************************
********************************************
/249/After/Bug 53765  472da151_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 

Lines added containing method: 0. Lines removed containing method: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	public void setUseKeepAlive(boolean value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setDomain(String value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setProtocol(String value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setPath(String path) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setFollowRedirects(boolean value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setPort(int value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setMethod(String value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public TestElement createTestElement() {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setArguments(Arguments value) {

Lines added: 0. Lines removed: 0. Tot = 0
********************************************
********************************************
/249/After/Bug 55606  22bc84d7_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 
-        // WEB REQUEST PANEL
-                JMeterUtils.getResString("web_request"))); // $NON-NLS-1$
+	        // WEB REQUEST PANEL
+	                JMeterUtils.getResString("web_request"))); // $NON-NLS-1$
+        	// When running in Headless mode, avoid unit tests failures

Lines added containing method: 3. Lines removed containing method: 2. Tot = 5
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	public TestElement createTestElement() {

Lines added: 0. Lines removed: 0. Tot = 0
********************************************
********************************************
/249/After/Bug 55606  2ed95f96_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 
-	        // WEB REQUEST PANEL
-	                JMeterUtils.getResString("web_request"))); // $NON-NLS-1$
-        	// When running in Headless mode, avoid unit tests failures
+        // WEB REQUEST PANEL
+                JMeterUtils.getResString("web_request"))); // $NON-NLS-1$
-	        // WEB REQUEST PANEL
-	                JMeterUtils.getResString("web_request"))); // $NON-NLS-1$
-        	// When running in Headless mode, avoid unit tests failures
+        // WEB REQUEST PANEL
+                JMeterUtils.getResString("web_request"))); // $NON-NLS-1$

Lines added containing method: 4. Lines removed containing method: 6. Tot = 10
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	public TestElement createTestElement() {

Lines added: 0. Lines removed: 0. Tot = 0
********************************************
********************************************
/249/After/Bug 55606  832fa54b_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 
-            postBodyContent.setText("");// $NON-NLS-1$
+            postBodyContent.setInitialText("");// $NON-NLS-1$
-            postBodyContent = new JLabeledTextArea(JMeterUtils.getResString("post_body_raw"));// $NON-NLS-1$
-            postContentTabbedPane.add(JMeterUtils.getResString("post_body"), postBodyContent);// $NON-NLS-1$
+            postBodyContent = new JSyntaxTextArea(30, 50);// $NON-NLS-1$
+            postContentTabbedPane.add(JMeterUtils.getResString("post_body"), new JTextScrollPane(postBodyContent));// $NON-NLS-1$
-    private final JLabeledTextArea textMessage = new JLabeledTextArea(JMeterUtils.getResString("jms_text_area")); // $NON-NLS-1$
+    private final JSyntaxTextArea textMessage = new JSyntaxTextArea(15, 50); // $NON-NLS-1$
-        textMessage.setText(""); // $NON-NLS-1$
+        textMessage.setInitialText(""); // $NON-NLS-1$
-        messageContent.setText(""); // $NON-NLS-1$
+        messageContent.setInitialText(""); // $NON-NLS-1$

Lines added containing method: 6. Lines removed containing method: 6. Tot = 12
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	public TestElement createTestElement() {

Lines added: 0. Lines removed: 0. Tot = 0
********************************************
********************************************
/249/After/Bug 57193: 0d45f17f_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 
- * <PRE> // ... float[] nodes = {3F, 2F, 4F, 1F, 2.5F, 5F, 3F}; Spline3 curve =
+ * <PRE>// ... float[] nodes = {3F, 2F, 4F, 1F, 2.5F, 5F, 3F}; Spline3 curve =

Lines added containing method: 1. Lines removed containing method: 1. Tot = 2
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	public String getText() {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public TestElement createTestElement() {

Lines added: 0. Lines removed: 0. Tot = 0
********************************************
********************************************
/249/After/Bug 57193: 5be9daa8_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 

Lines added containing method: 0. Lines removed containing method: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	public void setUseKeepAlive(boolean b) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setDomain(String domain) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	protected String getText(Object value, int row, int column) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setPort(int port) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public TestElement createTestElement() {

Lines added: 0. Lines removed: 0. Tot = 0
********************************************
********************************************
/249/After/Bug 57193: ee0c987f_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 

Lines added containing method: 0. Lines removed containing method: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	public void setUseKeepAlive(boolean value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setDomain(String domain) { // N.B. Must be in this class for the TestBean code to work

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setProtocol(String value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setPath(String path) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setFollowRedirects(boolean value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setPort(int value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setMethod(String value) {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public TestElement createTestElement() {

Lines added: 0. Lines removed: 0. Tot = 0
—————————
Method found in diff:	public void setArguments(Arguments value) {

Lines added: 0. Lines removed: 0. Tot = 0
********************************************
********************************************
/249/After/Bug 59044  3282578e_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 
+        // disable the multi-part if not a post request

Lines added containing method: 1. Lines removed containing method: 0. Tot = 1
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	public TestElement createTestElement() {

Lines added: 0. Lines removed: 0. Tot = 0
********************************************
********************************************
/249/After/Bug 59060  564705a4_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 
-                    // If there is no data, then switching between Parameters and Raw should be
-                    // allowed with no further user interaction.
+                // If there is no data, then switching between Parameters/file upload and Raw should be
+                // allowed with no further user interaction.
-                        // If the Parameter data can be converted (i.e. no names), we 
-                        // warn the user that the Parameter data will be lost.
+                        // can switch from parameter to fileupload
+                        // If the Parameter data can be converted (i.e. no names) and there is no data in file upload
+                        // we warn the user that the Parameter data will be lost.
-                                    JMeterUtils.getResString("web_cannot_convert_parameters_to_raw"), // $NON-NLS-1$
+                                    JMeterUtils.getResString(messageKey), // $NON-NLS-1$
-        this(""); // required for unit tests
+        // retro compatibility, will be removed in the next version

Lines added containing method: 7. Lines removed containing method: 6. Tot = 13
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	public TestElement createTestElement() {

Lines added: 0. Lines removed: 0. Tot = 0
********************************************
********************************************
/249/After/Bug 60543  2c182abb_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 
+        proxyHost.setText(""); // $NON-NLS-1$
+        proxyPort.setText(""); // $NON-NLS-1$
+        proxyUser.setText(""); // $NON-NLS-1$
+        proxyPass.setText(""); // $NON-NLS-1$
+        httpImplementation.setText(""); // $NON-NLS-1$
+        connectTimeOut.setText(""); // $NON-NLS-1$
+        responseTimeOut.setText(""); // $NON-NLS-1$
+                JMeterUtils.getResString("web_server_timeout_title"))); // $NON-NLS-1$
+        JLabel label = new JLabel(JMeterUtils.getResString("web_server_timeout_connect")); // $NON-NLS-1$
+        JLabel label = new JLabel(JMeterUtils.getResString("web_server_timeout_response")); // $NON-NLS-1$
+        httpImplementation = new JLabeledChoice(JMeterUtils.getResString("http_implementation"), // $NON-NLS-1$
+                JMeterUtils.getResString("web_proxy_server_title"))); // $NON-NLS-1$
+        JLabel label = new JLabel(JMeterUtils.getResString("web_server_domain")); // $NON-NLS-1$
+        JLabel label = new JLabel(JMeterUtils.getResString("web_server_port")); // $NON-NLS-1$
+        JLabel label = new JLabel(JMeterUtils.getResString("username")); // $NON-NLS-1$
+        JLabel label = new JLabel(JMeterUtils.getResString("password")); // $NON-NLS-1$
-    private final boolean showImplementation; // Set false for AJP
-            httpImplementation.setText(""); // $NON-NLS-1$
-        proxyHost.setText(""); // $NON-NLS-1$
-        proxyPort.setText(""); // $NON-NLS-1$
-        proxyUser.setText(""); // $NON-NLS-1$
-        proxyPass.setText(""); // $NON-NLS-1$
-        connectTimeOut.setText(""); // $NON-NLS-1$
-        responseTimeOut.setText(""); // $NON-NLS-1$
-        // WEB SERVER PANEL
+        // PROTOCOL
+        protocol = new JLabeledTextField(JMeterUtils.getResString("protocol"), 4); // $NON-NLS-1$
+        port = new JLabeledTextField(JMeterUtils.getResString("web_server_port"), 7); // $NON-NLS-1$
+        domain = new JLabeledTextField(JMeterUtils.getResString("web_server_domain"), 40); // $NON-NLS-1$
-                JMeterUtils.getResString("web_server_timeout_title"))); // $NON-NLS-1$
-                JMeterUtils.getResString("web_proxy_server_title"))); // $NON-NLS-1$
-        JLabel label = new JLabel(JMeterUtils.getResString("web_server_port")); // $NON-NLS-1$
-        JLabel label = new JLabel(JMeterUtils.getResString("web_server_port")); // $NON-NLS-1$
-        JLabel label = new JLabel(JMeterUtils.getResString("web_server_timeout_connect")); // $NON-NLS-1$
-        JLabel label = new JLabel(JMeterUtils.getResString("web_server_timeout_response")); // $NON-NLS-1$
-        JLabel label = new JLabel(JMeterUtils.getResString("web_server_domain")); // $NON-NLS-1$
-        JLabel label = new JLabel(JMeterUtils.getResString("web_server_domain")); // $NON-NLS-1$
-        JLabel label = new JLabel(JMeterUtils.getResString("username")); // $NON-NLS-1$
-        JLabel label = new JLabel(JMeterUtils.getResString("password")); // $NON-NLS-1$
+        // CONTENT_ENCODING
+        contentEncoding = new JLabeledTextField(JMeterUtils.getResString("content_encoding"), 7); // $NON-NLS-1$
+            method = new JLabeledChoice(JMeterUtils.getResString("method"), // $NON-NLS-1$
-        // Implementation
-            httpImplementation = new JLabeledChoice(JMeterUtils.getResString("http_implementation"), // $NON-NLS-1$
-        // PROTOCOL
-        JLabel protocolLabel = new JLabel(JMeterUtils.getResString("protocol")); // $NON-NLS-1$
-        // CONTENT_ENCODING
-        JLabel contentEncodingLabel = new JLabel(JMeterUtils.getResString("content_encoding")); // $NON-NLS-1$
-            method = new JLabeledChoice(JMeterUtils.getResString("method"), // $NON-NLS-1$
+                JMeterUtils.getResString("web_server_timeout_title"))); // $NON-NLS-1$
+        JLabel label = new JLabel(JMeterUtils.getResString("web_server_timeout_connect")); // $NON-NLS-1$
+        JLabel label = new JLabel(JMeterUtils.getResString("web_server_timeout_response")); // $NON-NLS-1$
+        httpImplementation = new JLabeledChoice(JMeterUtils.getResString("http_implementation"), // $NON-NLS-1$
-            // Add a new field source ip address (for HC implementations only)
+        // Add a new field source ip address (for HC implementations only)
+            proxyHost.setText(""); // $NON-NLS-1$
+            proxyPort.setText(""); // $NON-NLS-1$
+            proxyUser.setText(""); // $NON-NLS-1$
+            proxyPass.setText(""); // $NON-NLS-1$
+            httpImplementation.setText(""); // $NON-NLS-1$
+            connectTimeOut.setText(""); // $NON-NLS-1$
+            responseTimeOut.setText(""); // $NON-NLS-1$
+                JMeterUtils.getResString("web_proxy_server_title"))); // $NON-NLS-1$
+        JLabel label = new JLabel(JMeterUtils.getResString("web_server_domain")); // $NON-NLS-1$
+        JLabel label = new JLabel(JMeterUtils.getResString("web_server_port")); // $NON-NLS-1$
+        JLabel label = new JLabel(JMeterUtils.getResString("username")); // $NON-NLS-1$
+        JLabel label = new JLabel(JMeterUtils.getResString("password")); // $NON-NLS-1$

Lines added containing method: 40. Lines removed containing method: 27. Tot = 67
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	public TestElement createTestElement() {

Lines added: 0. Lines removed: 0. Tot = 0
********************************************
********************************************
/249/After/Reduce the f459b334_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
// 
+            optionPanel.setFont(FONT_SMALL); // all sub-components with setFont(null) inherit this font

Lines added containing method: 1. Lines removed containing method: 0. Tot = 1
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
* setUseKeepAlive
* setDomain
* getText
* setProtocol
* length
* setPath
* setDelegateRedirects
* setFollowRedirects
* setPort
* parseInt
* setMethod
* createTestElement
* isSelected
* setArguments
—————————
Method found in diff:	public TestElement createTestElement() {

Lines added: 0. Lines removed: 0. Tot = 0
********************************************
********************************************
