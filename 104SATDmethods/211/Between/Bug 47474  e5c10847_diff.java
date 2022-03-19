diff --git a/src/components/org/apache/jmeter/visualizers/ViewResultsFullVisualizer.java b/src/components/org/apache/jmeter/visualizers/ViewResultsFullVisualizer.java
index 5caa3113d..40faf8735 100644
--- a/src/components/org/apache/jmeter/visualizers/ViewResultsFullVisualizer.java
+++ b/src/components/org/apache/jmeter/visualizers/ViewResultsFullVisualizer.java
@@ -1,1070 +1,377 @@
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
- * distributed under the License is distributed on an "AS IS" BASIS,
- * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
+ * distributed  under the  License is distributed on an "AS IS" BASIS,
+ * WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
+ * implied.
+ *
  * See the License for the specific language governing permissions and
  * limitations under the License.
- *
  */
 
+/**
+ *
+ */
 package org.apache.jmeter.visualizers;
 
 import java.awt.BorderLayout;
 import java.awt.Color;
 import java.awt.Component;
 import java.awt.Dimension;
-import java.awt.Font;
-import java.awt.GridLayout;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
-import java.io.ByteArrayInputStream;
-import java.io.StringWriter;
-import java.text.DateFormat;
-import java.text.SimpleDateFormat;
-import java.util.Date;
-import java.util.regex.Matcher;
-import java.util.regex.Pattern;
+import java.io.IOException;
+import java.util.Collections;
+import java.util.List;
 
-import javax.swing.BorderFactory;
-import javax.swing.Box;
-import javax.swing.BoxLayout;
-import javax.swing.ButtonGroup;
-import javax.swing.Icon;
+import javax.swing.ComboBoxModel;
+import javax.swing.DefaultComboBoxModel;
 import javax.swing.ImageIcon;
-import javax.swing.JCheckBox;
-import javax.swing.JEditorPane;
-import javax.swing.JLabel;
-import javax.swing.JOptionPane;
-import javax.swing.JPanel;
-import javax.swing.JRadioButton;
+import javax.swing.JComboBox;
 import javax.swing.JScrollPane;
 import javax.swing.JSplitPane;
 import javax.swing.JTabbedPane;
-import javax.swing.JTextArea;
-import javax.swing.JTextPane;
 import javax.swing.JTree;
-import javax.swing.ToolTipManager;
 import javax.swing.event.TreeSelectionEvent;
 import javax.swing.event.TreeSelectionListener;
-import javax.swing.text.BadLocationException;
-import javax.swing.text.ComponentView;
-import javax.swing.text.Document;
-import javax.swing.text.EditorKit;
-import javax.swing.text.Element;
-import javax.swing.text.Style;
-import javax.swing.text.StyleConstants;
-import javax.swing.text.StyledDocument;
-import javax.swing.text.View;
-import javax.swing.text.ViewFactory;
-import javax.swing.text.html.HTML;
-import javax.swing.text.html.HTMLEditorKit;
 import javax.swing.tree.DefaultMutableTreeNode;
 import javax.swing.tree.DefaultTreeCellRenderer;
 import javax.swing.tree.DefaultTreeModel;
 import javax.swing.tree.TreePath;
 import javax.swing.tree.TreeSelectionModel;
 
 import org.apache.jmeter.assertions.AssertionResult;
+import org.apache.jmeter.gui.util.VerticalPanel;
 import org.apache.jmeter.samplers.Clearable;
 import org.apache.jmeter.samplers.SampleResult;
 import org.apache.jmeter.util.JMeterUtils;
-import org.apache.jmeter.util.XPathUtil;
 import org.apache.jmeter.visualizers.gui.AbstractVisualizer;
 import org.apache.jorphan.logging.LoggingManager;
-import org.apache.jorphan.util.JOrphanUtils;
+import org.apache.jorphan.reflect.ClassFinder;
 import org.apache.log.Logger;
-import org.w3c.dom.Node;
-import org.w3c.dom.NodeList;
-import org.w3c.tidy.Tidy;
-import org.xml.sax.SAXException;
 
 /**
- * Allows the tester to view the textual response from sampling an Entry. This
- * also allows to "single step through" the sampling process via a nice
- * "Continue" button.
+ * Base for ViewResults
  *
- * Created 2001/07/25
  */
 public class ViewResultsFullVisualizer extends AbstractVisualizer
-        implements ActionListener, TreeSelectionListener, Clearable
-    {
+implements ActionListener, TreeSelectionListener, Clearable {
 
-    private static final long serialVersionUID = 1L;
+    private static final long serialVersionUID = 7338676747296593842L;
 
     private static final Logger log = LoggingManager.getLoggerForClass();
 
-    // Maximum size that we will display
-    private static final int MAX_DISPLAY_SIZE =
-        JMeterUtils.getPropDefault("view.results.tree.max_size", 200 * 1024); // $NON-NLS-1$
-
-    // N.B. these are not multi-threaded, so don't make it static
-    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z"); // ISO format $NON-NLS-1$
-
-    private static final String NL = "\n"; // $NON-NLS-1$
-
-    private static final byte[] XML_PFX = "<?xml ".getBytes(); // $NON-NLS-1$
-
     public static final Color SERVER_ERROR_COLOR = Color.red;
 
     public static final Color CLIENT_ERROR_COLOR = Color.blue;
 
     public static final Color REDIRECT_COLOR = Color.green;
 
-    private static final String TEXT_HTML = "text/html"; // $NON-NLS-1$
-
-    private static final String HTML_COMMAND = "html"; // $NON-NLS-1$
-
-    private static final String JSON_COMMAND = "json"; // $NON-NLS-1$
-
-    private static final String XML_COMMAND = "xml"; // $NON-NLS-1$
-
-    private static final String TEXT_COMMAND = "text"; // $NON-NLS-1$
-
-    private static final String STYLE_SERVER_ERROR = "ServerError"; // $NON-NLS-1$
-
-    private static final String STYLE_CLIENT_ERROR = "ClientError"; // $NON-NLS-1$
-
-    private static final String STYLE_REDIRECT = "Redirect"; // $NON-NLS-1$
-
-    private boolean textMode = true;
-
-    private static final String ESC_CHAR_REGEX = "\\\\[\"\\\\/bfnrt]|\\\\u[0-9A-Fa-f]{4}"; // $NON-NLS-1$
-
-    private static final String NORMAL_CHARACTER_REGEX = "[^\"\\\\]";  // $NON-NLS-1$
-
-    private static final String STRING_REGEX = "\"(" + ESC_CHAR_REGEX + "|" + NORMAL_CHARACTER_REGEX + ")*\""; // $NON-NLS-1$
-
-    // This 'other value' regex is deliberately weak, even accepting an empty string, to be useful when reporting malformed data.
-    private static final String OTHER_VALUE_REGEX = "[^\\{\\[\\]\\}\\,]*"; // $NON-NLS-1$
-
-    private static final String VALUE_OR_PAIR_REGEX = "((" + STRING_REGEX + "\\s*:)?\\s*(" + STRING_REGEX + "|" + OTHER_VALUE_REGEX + ")\\s*,?\\s*)"; // $NON-NLS-1$
-
-    private static final Pattern VALUE_OR_PAIR_PATTERN = Pattern.compile(VALUE_OR_PAIR_REGEX);
-
-    // set default command to Text
-    private String command = TEXT_COMMAND;
-
-    // Keep copies of the two editors needed
-    private static final EditorKit customisedEditor = new LocalHTMLEditorKit();
-
-    private static final EditorKit defaultHtmlEditor = JEditorPane.createEditorKitForContentType(TEXT_HTML);
+    private  JSplitPane mainSplit;
 
     private DefaultMutableTreeNode root;
 
     private DefaultTreeModel treeModel;
 
-    private JTextPane stats;
-
-    private JEditorPane results;
-
-    private JScrollPane resultsScrollPane;
-
-    private JPanel resultsPane;
-
-    private JLabel imageLabel;
-
-    private JTextArea sampleDataField;
-
-    private JPanel requestPane;
+    private JTree jTree;
 
-    private JRadioButton textButton;
+    private Component leftSide;
 
-    private JRadioButton htmlButton;
+    private JTabbedPane rightSide;
 
-    private JRadioButton jsonButton;
+    private JComboBox selectRenderPanel;
 
-    private JRadioButton xmlButton;
+    private int selectedTab;
 
-    private JCheckBox downloadAll;
-    
-    private JLabel renderLabel;
-
-    private JTree jTree;
-
-    private JTabbedPane rightSide;
-
-    private SearchTextExtension searchTextExtension;
-    
-    private JPanel searchPanel = null;
+    protected static final String COMBO_CHANGE_COMMAND = "change_combo"; // $NON-NLS-1$
 
     private static final ImageIcon imageSuccess = JMeterUtils.getImage(
             JMeterUtils.getPropDefault("viewResultsTree.success",  //$NON-NLS-1$
                     "icon_success_sml.gif")); //$NON-NLS-1$
 
     private static final ImageIcon imageFailure = JMeterUtils.getImage(
             JMeterUtils.getPropDefault("viewResultsTree.failure",  //$NON-NLS-1$
                     "icon_warning_sml.gif")); //$NON-NLS-1$
 
+    // Maximum size that we will display
+    private static final int MAX_DISPLAY_SIZE =
+        JMeterUtils.getPropDefault("view.results.tree.max_size", 200 * 1024); // $NON-NLS-1$
+
+    private ResultRenderer resultsRender = null;
+
+    private TreeSelectionEvent lastSelectionEvent;
+
+    /*
+     * Constructor
+     */
     public ViewResultsFullVisualizer() {
         super();
-        log.debug("Start : ViewResultsFullVisualizer1");
         init();
-        log.debug("End : ViewResultsFullVisualizer1");
     }
 
-    public void add(SampleResult res) {
-        updateGui(res);
-    }
-
-    public String getLabelResource() {
-        return "view_results_tree_title"; // $NON-NLS-1$
+    /** {@inheritDoc} */
+    public void add(SampleResult sample) {
+        updateGui(sample);
     }
 
     /**
      * Update the visualizer with new data.
      */
     private synchronized void updateGui(SampleResult res) {
-        log.debug("Start : updateGui1");
-        if (log.isDebugEnabled()) {
-            log.debug("updateGui1 : sample result - " + res);
-        }
         // Add sample
         DefaultMutableTreeNode currNode = new DefaultMutableTreeNode(res);
         treeModel.insertNodeInto(currNode, root, root.getChildCount());
         addSubResults(currNode, res);
         // Add any assertion that failed as children of the sample node
         AssertionResult assertionResults[] = res.getAssertionResults();
         int assertionIndex = currNode.getChildCount();
         for (int j = 0; j < assertionResults.length; j++) {
             AssertionResult item = assertionResults[j];
 
             if (item.isFailure() || item.isError()) {
                 DefaultMutableTreeNode assertionNode = new DefaultMutableTreeNode(item);
                 treeModel.insertNodeInto(assertionNode, currNode, assertionIndex++);
             }
         }
 
         if (root.getChildCount() == 1) {
             jTree.expandPath(new TreePath(root));
         }
-        log.debug("End : updateGui1");
     }
 
     private void addSubResults(DefaultMutableTreeNode currNode, SampleResult res) {
         SampleResult[] subResults = res.getSubResults();
 
         int leafIndex = 0;
 
         for (int i = 0; i < subResults.length; i++) {
             SampleResult child = subResults[i];
 
             if (log.isDebugEnabled()) {
                 log.debug("updateGui1 : child sample result - " + child);
             }
             DefaultMutableTreeNode leafNode = new DefaultMutableTreeNode(child);
 
             treeModel.insertNodeInto(leafNode, currNode, leafIndex++);
             addSubResults(leafNode, child);
             // Add any assertion that failed as children of the sample node
             AssertionResult assertionResults[] = child.getAssertionResults();
             int assertionIndex = leafNode.getChildCount();
             for (int j = 0; j < assertionResults.length; j++) {
                 AssertionResult item = assertionResults[j];
 
                 if (item.isFailure() || item.isError()) {
                     DefaultMutableTreeNode assertionNode = new DefaultMutableTreeNode(item);
                     treeModel.insertNodeInto(assertionNode, leafNode, assertionIndex++);
                 }
             }
         }
     }
 
-    /**
-     * Clears the visualizer.
-     */
-    public synchronized void clearData() {
-        log.debug("Start : clear1");
-
-        if (log.isDebugEnabled()) {
-            log.debug("clear1 : total child - " + root.getChildCount());
-        }
+    /** {@inheritDoc} */
+    public void clearData() {
         while (root.getChildCount() > 0) {
             // the child to be removed will always be 0 'cos as the nodes are
             // removed the nth node will become (n-1)th
             treeModel.removeNodeFromParent((DefaultMutableTreeNode) root.getChildAt(0));
         }
+        resultsRender.clearData();
+    }
 
-        results.setText("");// Response Data // $NON-NLS-1$
-        sampleDataField.setText("");// Request Data // $NON-NLS-1$
-        log.debug("End : clear1");
+    /** {@inheritDoc} */
+    public String getLabelResource() {
+        return "view_results_tree_title"; // $NON-NLS-1$
     }
 
     /**
-     * Returns the description of this visualizer.
-     *
-     * @return description of this visualizer
+     * Initialize this visualizer
      */
-    @Override
-    public String toString() {
-        String desc = JMeterUtils.getResString("view_results_desc"); //$NON-NLS-1$
+    protected void init() {
+        log.debug("init() - pass");
+        setLayout(new BorderLayout(0, 5));
+        setBorder(makeBorder());
+        add(makeTitlePanel(), BorderLayout.NORTH);
 
-        if (log.isDebugEnabled()) {
-            log.debug("toString1 : Returning description - " + desc);
-        }
-        return desc;
+        leftSide = createLeftPanel();
+        // Prepare the common tab
+        rightSide = new JTabbedPane();
+
+        // Create the split pane
+        mainSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftSide, rightSide);
+        add(mainSplit, BorderLayout.CENTER);
+        // init right side with first render
+        resultsRender.setRightSide(rightSide);
+        resultsRender.init();
     }
 
-    /**
-     * Sets the right pane to correspond to the selected node of the left tree.
-     */
+    /** {@inheritDoc} */
     public void valueChanged(TreeSelectionEvent e) {
-        log.debug("Start : valueChanged1");
+        lastSelectionEvent = e;
         DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
 
-        if (log.isDebugEnabled()) {
-            log.debug("valueChanged : selected node - " + node);
-        }
-
-        StyledDocument statsDoc = stats.getStyledDocument();
-        try {
-            statsDoc.remove(0, statsDoc.getLength());
-            sampleDataField.setText(""); // $NON-NLS-1$
-            results.setText(""); // $NON-NLS-1$
-            if (node != null) {
-                Object userObject = node.getUserObject();
-                if(userObject instanceof SampleResult) {
-                    SampleResult res = (SampleResult) userObject;
-
-                    // We are displaying a SampleResult
-                    setupTabPaneForSampleResult();
-
-                    if (log.isDebugEnabled()) {
-                        log.debug("valueChanged1 : sample result - " + res);
-                        log.debug("valueChanged1 : load time - " + res.getTime());
-                    }
-
-                    String sd = res.getSamplerData();
-                    if (sd != null) {
-                        String rh = res.getRequestHeaders();
-                        if (rh != null) {
-                            StringBuilder sb = new StringBuilder(sd.length() + rh.length()+20);
-                            sb.append(sd);
-                            sb.append("\n"); //$NON-NLS-1$
-                            sb.append(JMeterUtils.getResString("view_results_request_headers")); //$NON-NLS-1$
-                            sb.append("\n"); //$NON-NLS-1$
-                            sb.append(rh);
-                            sd = sb.toString();
-                        }
-                        sampleDataField.setText(sd);
-                    }
-
-                    StringBuilder statsBuff = new StringBuilder(200);
-                    statsBuff.append(JMeterUtils.getResString("view_results_thread_name")).append(res.getThreadName()).append(NL); //$NON-NLS-1$
-                    String startTime = dateFormat.format(new Date(res.getStartTime()));
-                    statsBuff.append(JMeterUtils.getResString("view_results_sample_start")).append(startTime).append(NL); //$NON-NLS-1$
-                    statsBuff.append(JMeterUtils.getResString("view_results_load_time")).append(res.getTime()).append(NL); //$NON-NLS-1$
-                    statsBuff.append(JMeterUtils.getResString("view_results_latency")).append(res.getLatency()).append(NL); //$NON-NLS-1$
-                    statsBuff.append(JMeterUtils.getResString("view_results_size_in_bytes")).append(res.getBytes()).append(NL); //$NON-NLS-1$
-                    statsBuff.append(JMeterUtils.getResString("view_results_sample_count")).append(res.getSampleCount()).append(NL); //$NON-NLS-1$
-                    statsBuff.append(JMeterUtils.getResString("view_results_error_count")).append(res.getErrorCount()).append(NL); //$NON-NLS-1$
-                    statsDoc.insertString(statsDoc.getLength(), statsBuff.toString(), null);
-                    statsBuff = new StringBuilder(); //reset for reuse
-
-                    String responseCode = res.getResponseCode();
-                    if (log.isDebugEnabled()) {
-                        log.debug("valueChanged1 : response code - " + responseCode);
-                    }
-                    int responseLevel = 0;
-                    if (responseCode != null) {
-                        try {
-                            responseLevel = Integer.parseInt(responseCode) / 100;
-                        } catch (NumberFormatException numberFormatException) {
-                            // no need to change the foreground color
-                        }
-                    }
-
-                    Style style = null;
-                    switch (responseLevel) {
-                    case 3:
-                        style = statsDoc.getStyle(STYLE_REDIRECT);
-                        break;
-                    case 4:
-                        style = statsDoc.getStyle(STYLE_CLIENT_ERROR);
-                        break;
-                    case 5:
-                        style = statsDoc.getStyle(STYLE_SERVER_ERROR);
-                        break;
-                    }
-
-                    statsBuff.append(JMeterUtils.getResString("view_results_response_code")).append(responseCode).append(NL); //$NON-NLS-1$
-                    statsDoc.insertString(statsDoc.getLength(), statsBuff.toString(), style);
-                    statsBuff = new StringBuilder(100); //reset for reuse
-
-                    // response message label
-                    String responseMsgStr = res.getResponseMessage();
-
-                    if (log.isDebugEnabled()) {
-                        log.debug("valueChanged1 : response message - " + responseMsgStr);
-                    }
-                    statsBuff.append(JMeterUtils.getResString("view_results_response_message")).append(responseMsgStr).append(NL); //$NON-NLS-1$
-
-                    statsBuff.append(NL);
-                    statsBuff.append(JMeterUtils.getResString("view_results_response_headers")).append(NL); //$NON-NLS-1$
-                    statsBuff.append(res.getResponseHeaders()).append(NL);
-                    statsBuff.append(NL);
-                    final String samplerClass = res.getClass().getName();
-                    statsBuff.append(samplerClass.substring(1+samplerClass.lastIndexOf('.'))).append(" " + JMeterUtils.getResString("view_results_fields")).append(NL); //$NON-NLS-1$
-                    statsBuff.append("ContentType: ").append(res.getContentType()).append(NL);
-                    statsBuff.append("DataEncoding: ").append(res.getDataEncodingNoDefault()).append(NL);
-                    statsDoc.insertString(statsDoc.getLength(), statsBuff.toString(), null);
-                    statsBuff = null; // Done
-
-                    // Reset search
-                    searchTextExtension.resetTextToFind();
-                    
-                    // get the text response and image icon
-                    // to determine which is NOT null
-                    if ((SampleResult.TEXT).equals(res.getDataType())) // equals(null) is OK
-                    {
-                        String response = getResponseAsString(res);
-                        if (command.equals(TEXT_COMMAND)) {
-                            showTextResponse(response);
-                        } else if (command.equals(HTML_COMMAND)) {
-                            showRenderedResponse(response, res);
-                        } else if (command.equals(JSON_COMMAND)) {
-                            showRenderJSONResponse(response);
-                        } else if (command.equals(XML_COMMAND)) {
-                            showRenderXMLResponse(res);
-                        }
-                        if (!searchTextExtension.isEnabled()) {
-                            searchTextExtension.setEnabled(true);
-                        }
-                    } else {
-                        byte[] responseBytes = res.getResponseData();
-                        if (responseBytes != null) {
-                            showImage(new ImageIcon(responseBytes)); //TODO implement other non-text types
-                            if (searchTextExtension.isEnabled()) {
-                                searchTextExtension.setEnabled(false);
-                            }
-                        }
+        if (node != null) {
+            // to restore last tab used
+            if (rightSide.getTabCount() > selectedTab) {
+                resultsRender.setLastSelectedTab(rightSide.getSelectedIndex());
+            }
+            Object userObject = node.getUserObject();
+            resultsRender.setSamplerResult(userObject);
+            resultsRender.setupTabPane();
+            // display a SampleResult
+            if (userObject instanceof SampleResult) {
+                SampleResult sampleResult = (SampleResult) userObject;
+                if ((SampleResult.TEXT).equals(sampleResult.getDataType())){
+                    resultsRender.renderResult(sampleResult);
+                } else {
+                    byte[] responseBytes = sampleResult.getResponseData();
+                    if (responseBytes != null) {
+                        resultsRender.renderImage(sampleResult);
                     }
                 }
-                else if(userObject instanceof AssertionResult) {
-                    AssertionResult res = (AssertionResult) userObject;
-
-                    // We are displaying an AssertionResult
-                    setupTabPaneForAssertionResult();
-
-                    if (log.isDebugEnabled()) {
-                        log.debug("valueChanged1 : sample result - " + res);
-                    }
-
-                    StringBuilder statsBuff = new StringBuilder(100);
-                    statsBuff.append(JMeterUtils.getResString("view_results_assertion_error")).append(res.isError()).append(NL); //$NON-NLS-1$
-                    statsBuff.append(JMeterUtils.getResString("view_results_assertion_failure")).append(res.isFailure()).append(NL); //$NON-NLS-1$
-                    statsBuff.append(JMeterUtils.getResString("view_results_assertion_failure_message")).append(res.getFailureMessage()).append(NL); //$NON-NLS-1$
-                    statsDoc.insertString(statsDoc.getLength(), statsBuff.toString(), null);
-                    statsBuff = null;
-                }
             }
-        } catch (BadLocationException exc) {
-            log.error("Error setting statistics text", exc);
-            stats.setText("");
         }
-        log.debug("End : valueChanged1");
-    }
-
-    private void showImage(Icon image) {
-        imageLabel.setIcon(image);
-        resultsScrollPane.setViewportView(imageLabel);
-        setEnabledButtons(false);
     }
 
-    private void showTextResponse(String response) {
-        results.setContentType("text/plain"); // $NON-NLS-1$
-        results.setText(response == null ? "" : response); // $NON-NLS-1$
-        results.setCaretPosition(0);
-        resultsScrollPane.setViewportView(results);
-
-        setEnabledButtons(true);
-    }
+    private Component createLeftPanel() {
+        SampleResult rootSampleResult = new SampleResult();
+        rootSampleResult.setSampleLabel("Root");
+        rootSampleResult.setSuccessful(true);
+        root = new DefaultMutableTreeNode(rootSampleResult);
 
-    // It might be useful also to make this available in the 'Request' tab, for
-    // when posting JSON.
-    private static String prettyJSON(String json) {
-        StringBuilder pretty = new StringBuilder(json.length() * 2); // Educated guess
+        treeModel = new DefaultTreeModel(root);
+        jTree = new JTree(treeModel);
+        jTree.setCellRenderer(new ResultsNodeRenderer());
+        jTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
+        jTree.addTreeSelectionListener(this);
+        jTree.setRootVisible(false);
+        jTree.setShowsRootHandles(true);
 
-        final String tab = ":   "; // $NON-NLS-1$
-        StringBuilder index = new StringBuilder();
-        String nl = ""; // $NON-NLS-1$
+        JScrollPane treePane = new JScrollPane(jTree);
+        treePane.setPreferredSize(new Dimension(200, 300));
 
-        Matcher valueOrPair = VALUE_OR_PAIR_PATTERN.matcher(json);
+        VerticalPanel leftPane = new VerticalPanel();
+        leftPane.add(treePane, BorderLayout.CENTER);
+        leftPane.add(createComboRender(), BorderLayout.SOUTH);
 
-        boolean misparse = false;
+        return leftPane;
+    }
 
-        for (int i = 0; i < json.length(); ) {
-            final char currentChar = json.charAt(i);
-            if ((currentChar == '{') || (currentChar == '[')) {
-                pretty.append(nl).append(index).append(currentChar);
-                i++;
-                index.append(tab);
-                misparse = false;
-            }
-            else if ((currentChar == '}') || (currentChar == ']')) {
-                if (index.length() > 0) {
-                    index.delete(0, tab.length());
-                }
-                pretty.append(nl).append(index).append(currentChar);
-                i++;
-                int j = i;
-                while ((j < json.length()) && Character.isWhitespace(json.charAt(j))) {
-                    j++;
-                }
-                if ((j < json.length()) && (json.charAt(j) == ',')) {
-                    pretty.append(","); // $NON-NLS-1$
-                    i=j+1;
-                }
-                misparse = false;
-            }
-            else if (valueOrPair.find(i) && valueOrPair.group().length() > 0) {
-                pretty.append(nl).append(index).append(valueOrPair.group());
-                i=valueOrPair.end();
-                misparse = false;
-            }
-            else {
-                if (!misparse) {
-                    pretty.append(nl).append("- Parse failed from:");
-                }
-                pretty.append(currentChar);
-                i++;
-                misparse = true;
+    /**
+     * Create the drop-down list to changer render
+     * @return List of all render (implement ResultsRender)
+     */
+    private Component createComboRender() {// TODO move to bottom of renderer
+        ComboBoxModel nodesModel = new DefaultComboBoxModel();
+        // drop-down list for renderer
+        selectRenderPanel = new JComboBox(nodesModel);
+        selectRenderPanel.setActionCommand(COMBO_CHANGE_COMMAND);
+        selectRenderPanel.addActionListener(this);
+
+        // if no results render in jmeter.properties, load Standard (default)
+        List<String> classesToAdd = Collections.<String>emptyList();
+        try {
+            classesToAdd = ClassFinder.findClassesThatExtend(ResultRenderer.class);
+        } catch (IOException e1) {
+            // ignored
+        }
+        for (String clazz : classesToAdd) {
+            try {
+                // Instantiate render classes
+                final ResultRenderer renderer = (ResultRenderer) Class.forName(clazz).newInstance();
+                renderer.setBackgroundColor(getBackground());
+                selectRenderPanel.addItem(renderer);
+            } catch (Exception e) {
+                log.warn("Error in load result render:" + clazz, e);
             }
-            nl = "\n"; // $NON-NLS-1$
         }
-        return pretty.toString();
+        return selectRenderPanel;
     }
 
-    private void showRenderJSONResponse(String response) {
-        results.setContentType("text/plain"); // $NON-NLS-1$
-        results.setText(response == null ? "" : prettyJSON(response));
-        results.setCaretPosition(0);
-        resultsScrollPane.setViewportView(results);
-
-        setEnabledButtons(true);
-    }
-
-    private void showRenderXMLResponse(SampleResult res) {
-        results.setContentType("text/xml"); // $NON-NLS-1$
-        results.setCaretPosition(0);
-        byte[] source = res.getResponseData();
-        final ByteArrayInputStream baIS = new ByteArrayInputStream(source);
-        for(int i=0; i<source.length-XML_PFX.length; i++){
-            if (JOrphanUtils.startsWith(source, XML_PFX, i)){
-                baIS.skip(i);// Skip the leading bytes (if any)
-                break;
+    /** {@inheritDoc} */
+    public void actionPerformed(ActionEvent event) {
+        String command = event.getActionCommand();
+        if (COMBO_CHANGE_COMMAND.equals(command)) {
+            JComboBox jcb = (JComboBox) event.getSource();
+
+            if (jcb != null) {
+                resultsRender = (ResultRenderer) jcb.getSelectedItem();
+                if (rightSide != null) {
+                    // to restore last selected tab (better user-friendly)
+                    selectedTab = rightSide.getSelectedIndex();
+                    // Remove old right side
+                    mainSplit.remove(rightSide);
+
+                    // create and add a new right side
+                    rightSide = new JTabbedPane();
+                    mainSplit.add(rightSide);
+                    resultsRender.setRightSide(rightSide);
+                    resultsRender.setLastSelectedTab(selectedTab);
+                    log.debug("selectedTab=" + selectedTab);
+                    resultsRender.init();
+                    // To display current sampler result before change
+                    this.valueChanged(lastSelectionEvent);
+                }
             }
         }
-        Component view = results;
-
-        // there is also a javax.swing.text.Document class.
-        org.w3c.dom.Document document = null;
-
-        StringWriter sw = new StringWriter();
-        Tidy tidy = XPathUtil.makeTidyParser(true, true, true, sw);
-        document = tidy.parseDOM(baIS, null);
-        document.normalize();
-        if (tidy.getParseErrors() > 0) {
-            showErrorMessageDialog(sw.toString(),
-                    "Tidy: " + tidy.getParseErrors() + " errors, " + tidy.getParseWarnings() + " warnings",
-                    JOptionPane.WARNING_MESSAGE);
-        }
-
-        JPanel domTreePanel = new DOMTreePanel(document);
-        view = domTreePanel;
-        resultsScrollPane.setViewportView(view);
-        setEnabledButtons(true);
     }
 
-    private static String getResponseAsString(SampleResult res) {
-
+    public static String getResponseAsString(SampleResult res) {
         String response = null;
         if ((SampleResult.TEXT).equals(res.getDataType())) {
             // Showing large strings can be VERY costly, so we will avoid
             // doing so if the response
             // data is larger than 200K. TODO: instead, we could delay doing
             // the result.setText
             // call until the user chooses the "Response data" tab. Plus we
             // could warn the user
             // if this happens and revert the choice if he doesn't confirm
             // he's ready to wait.
             int len = res.getResponseData().length;
             if (MAX_DISPLAY_SIZE > 0 && len > MAX_DISPLAY_SIZE) {
                 response = JMeterUtils.getResString("view_results_response_too_large_message") //$NON-NLS-1$
                     + len + " > Max: "+MAX_DISPLAY_SIZE;
                 log.warn(response);
             } else {
                 response = res.getResponseDataAsString();
             }
         }
         return response;
     }
 
-    /**
-     * Display the response as text or as rendered HTML. Change the text on the
-     * button appropriate to the current display.
-     *
-     * @param e
-     *            the ActionEvent being processed
-     */
-    public void actionPerformed(ActionEvent e) {
-        command = e.getActionCommand();
-
-        if (command != null
-                && (command.equals(TEXT_COMMAND) || command.equals(HTML_COMMAND)
-                 || command.equals(JSON_COMMAND) || command.equals(XML_COMMAND))) {
-
-            textMode = command.equals(TEXT_COMMAND);
-
-            DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
-
-            if (node == null) {
-                results.setText("");
-                return;
-            }
-            searchTextExtension.resetTextToFind();
-            
-            SampleResult res = (SampleResult) node.getUserObject();
-            String response = getResponseAsString(res);
-
-            if (command.equals(TEXT_COMMAND)) {
-                showTextResponse(response);
-            } else if (command.equals(HTML_COMMAND)) {
-                showRenderedResponse(response, res);
-            } else if (command.equals(JSON_COMMAND)) {
-                showRenderJSONResponse(response);
-            } else if (command.equals(XML_COMMAND)) {
-                showRenderXMLResponse(res);
-            }
-        }
-    }
-
-    private void showRenderedResponse(String response, SampleResult res) {
-        if (response == null) {
-            results.setText("");
-            return;
-        }
-
-        int htmlIndex = response.indexOf("<HTML"); // could be <HTML lang=""> // $NON-NLS-1$
-
-        // Look for a case variation
-        if (htmlIndex < 0) {
-            htmlIndex = response.indexOf("<html"); // ditto // $NON-NLS-1$
-        }
-
-        // If we still can't find it, just try using all of the text
-        if (htmlIndex < 0) {
-            htmlIndex = 0;
-        }
-
-        String html = response.substring(htmlIndex);
-
-        /*
-         * To disable downloading and rendering of images and frames, enable the
-         * editor-kit. The Stream property can then be
-         */
-
-        // Must be done before setContentType
-        results.setEditorKitForContentType(TEXT_HTML, downloadAll.isSelected() ? defaultHtmlEditor : customisedEditor);
-
-        results.setContentType(TEXT_HTML);
-
-        if (downloadAll.isSelected()) {
-            // Allow JMeter to render frames (and relative images)
-            // Must be done after setContentType [Why?]
-            results.getDocument().putProperty(Document.StreamDescriptionProperty, res.getURL());
-        }
-
-        /*
-         * Get round problems parsing <META http-equiv='content-type'
-         * content='text/html; charset=utf-8'> See
-         * http://issues.apache.org/bugzilla/show_bug.cgi?id=23315
-         *
-         * Is this due to a bug in Java?
-         */
-        results.getDocument().putProperty("IgnoreCharsetDirective", Boolean.TRUE); // $NON-NLS-1$
-
-        results.setText(html);
-        results.setCaretPosition(0);
-        resultsScrollPane.setViewportView(results);
-
-        setEnabledButtons(true);
-    }
-
-    private Component createHtmlOrTextPane() {
-        ButtonGroup group = new ButtonGroup();
-        Font font = new Font("SansSerif", Font.PLAIN, 10);
-        Font fontBold = new Font("SansSerif", Font.BOLD, 10);
-
-        renderLabel = new JLabel(JMeterUtils
-                .getResString("view_results_render")); // $NON-NLS-1$
-        renderLabel.setFont(fontBold);
-
-        textButton = new JRadioButton(JMeterUtils.getResString("view_results_render_text")); // $NON-NLS-1$
-        textButton.setFont(font);
-        textButton.setActionCommand(TEXT_COMMAND);
-        textButton.addActionListener(this);
-        textButton.setSelected(textMode);
-        group.add(textButton);
-
-        htmlButton = new JRadioButton(JMeterUtils.getResString("view_results_render_html")); // $NON-NLS-1$
-        htmlButton.setFont(font);
-        htmlButton.setActionCommand(HTML_COMMAND);
-        htmlButton.addActionListener(this);
-        htmlButton.setSelected(!textMode);
-        group.add(htmlButton);
-
-        jsonButton = new JRadioButton(JMeterUtils.getResString("view_results_render_json")); // $NON-NLS-1$
-        jsonButton.setFont(font);
-        jsonButton.setActionCommand(JSON_COMMAND);
-        jsonButton.addActionListener(this);
-        jsonButton.setSelected(!textMode);
-        group.add(jsonButton);
-
-        xmlButton = new JRadioButton(JMeterUtils.getResString("view_results_render_xml")); // $NON-NLS-1$
-        xmlButton.setFont(font);
-        xmlButton.setActionCommand(XML_COMMAND);
-        xmlButton.addActionListener(this);
-        xmlButton.setSelected(!textMode);
-        group.add(xmlButton);
-
-        downloadAll = new JCheckBox(JMeterUtils.getResString("view_results_render_embedded")); // $NON-NLS-1$
-        downloadAll.setFont(font);
-        
-        JPanel pane = new JPanel();
-        pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
-        pane.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
-        pane.add(searchTextExtension.createShowSearchPanel());
-        pane.add(Box.createRigidArea(new Dimension(30, 0)));
-        pane.add(renderLabel);
-        pane.add(textButton);
-        pane.add(htmlButton);
-        pane.add(xmlButton);
-        pane.add(jsonButton);
-        pane.add(downloadAll);
-        
-        return pane;
-    }
-
-    /**
-     * Initialize this visualizer
-     */
-    private void init() {
-        setLayout(new BorderLayout(0, 5));
-        setBorder(makeBorder());
-
-        add(makeTitlePanel(), BorderLayout.NORTH);
-
-        Component leftSide = createLeftPanel();
-        rightSide = new JTabbedPane();
-        // Add the common tab
-        rightSide.addTab(JMeterUtils.getResString("view_results_tab_sampler"), createResponseMetadataPanel()); // $NON-NLS-1$
-        // Create the panels for the other tabs
-        requestPane = createRequestPanel();
-        resultsPane = createResponseDataPanel();
-
-        JSplitPane mainSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftSide, rightSide);
-        add(mainSplit, BorderLayout.CENTER);
-        
-        searchTextExtension.init(resultsPane);
-    }
-
-    private void setupTabPaneForSampleResult() {
-        // Set the title for the first tab
-        rightSide.setTitleAt(0, JMeterUtils.getResString("view_results_tab_sampler")); //$NON-NLS-1$
-        // Add the other tabs if not present
-        if(rightSide.indexOfTab(JMeterUtils.getResString("view_results_tab_request")) < 0) { // $NON-NLS-1$
-            rightSide.addTab(JMeterUtils.getResString("view_results_tab_request"), requestPane); // $NON-NLS-1$
-        }
-        if(rightSide.indexOfTab(JMeterUtils.getResString("view_results_tab_response")) < 0) { // $NON-NLS-1$
-            rightSide.addTab(JMeterUtils.getResString("view_results_tab_response"), resultsPane); // $NON-NLS-1$
-        }
-    }
-
-    private void setupTabPaneForAssertionResult() {
-        // Set the title for the first tab
-        rightSide.setTitleAt(0, JMeterUtils.getResString("view_results_tab_assertion")); //$NON-NLS-1$
-        // Remove the other tabs if present
-        int requestTabIndex = rightSide.indexOfTab(JMeterUtils.getResString("view_results_tab_request")); // $NON-NLS-1$
-        if(requestTabIndex >= 0) {
-            rightSide.removeTabAt(requestTabIndex);
-        }
-        int responseTabIndex = rightSide.indexOfTab(JMeterUtils.getResString("view_results_tab_response")); // $NON-NLS-1$
-        if(responseTabIndex >= 0) {
-            rightSide.removeTabAt(responseTabIndex);
-        }
-    }
-
-    private Component createLeftPanel() {
-        SampleResult rootSampleResult = new SampleResult();
-        rootSampleResult.setSampleLabel("Root");
-        rootSampleResult.setSuccessful(true);
-        root = new DefaultMutableTreeNode(rootSampleResult);
-
-        treeModel = new DefaultTreeModel(root);
-        jTree = new JTree(treeModel);
-        jTree.setCellRenderer(new ResultsNodeRenderer());
-        jTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
-        jTree.addTreeSelectionListener(this);
-        jTree.setRootVisible(false);
-        jTree.setShowsRootHandles(true);
-
-        JScrollPane treePane = new JScrollPane(jTree);
-        treePane.setPreferredSize(new Dimension(200, 300));
-        return treePane;
-    }
-
-    private Component createResponseMetadataPanel() {
-        stats = new JTextPane();
-        stats.setEditable(false);
-        stats.setBackground(getBackground());
-
-        // Add styles to use for different types of status messages
-        StyledDocument doc = (StyledDocument) stats.getDocument();
-
-        Style style = doc.addStyle(STYLE_REDIRECT, null);
-        StyleConstants.setForeground(style, REDIRECT_COLOR);
-
-        style = doc.addStyle(STYLE_CLIENT_ERROR, null);
-        StyleConstants.setForeground(style, CLIENT_ERROR_COLOR);
-
-        style = doc.addStyle(STYLE_SERVER_ERROR, null);
-        StyleConstants.setForeground(style, SERVER_ERROR_COLOR);
-
-        JScrollPane pane = makeScrollPane(stats);
-        pane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
-        return pane;
-    }
-
-    private JPanel createRequestPanel() {
-        sampleDataField = new JTextArea();
-        sampleDataField.setEditable(false);
-        sampleDataField.setLineWrap(true);
-        sampleDataField.setWrapStyleWord(true);
-
-        JPanel pane = new JPanel(new BorderLayout(0, 5));
-        pane.add(makeScrollPane(sampleDataField));
-        return pane;
-    }
-
-    private JPanel createResponseDataPanel() {
-        results = new JEditorPane();
-        results.setEditable(false);
-
-        resultsScrollPane = makeScrollPane(results);
-        imageLabel = new JLabel();
-
-        // Add search text extension
-        searchTextExtension = new SearchTextExtension();
-        searchPanel = searchTextExtension.createSearchTextPanel();
-        searchTextExtension.setResults(results);
-        searchPanel.setVisible(false);
-        JPanel panelSouth = new JPanel(new BorderLayout());
-        panelSouth.add(createHtmlOrTextPane(), BorderLayout.CENTER);
-        panelSouth.add(searchPanel, BorderLayout.SOUTH);
-        
-        JPanel panel = new JPanel(new BorderLayout());
-        panel.add(resultsScrollPane, BorderLayout.CENTER);
-        panel.add(panelSouth, BorderLayout.SOUTH);
-
-        return panel;
-    }
+    private static class ResultsNodeRenderer extends DefaultTreeCellRenderer {
 
-    private void setEnabledButtons(boolean b) {
-        renderLabel.setEnabled(b); 
-        textButton.setEnabled(b);
-        htmlButton.setEnabled(b);
-        jsonButton.setEnabled(b);
-        xmlButton.setEnabled(b);
-        if (b && command.equals(HTML_COMMAND)) {
-            downloadAll.setEnabled(b);
-        } else {
-            downloadAll.setEnabled(false);
-        }
-    }
+        private static final long serialVersionUID = 4159626601097711565L;
 
-    private static class ResultsNodeRenderer extends DefaultTreeCellRenderer {
         @Override
-        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
-                boolean leaf, int row, boolean focus) {
+        public Component getTreeCellRendererComponent(JTree tree, Object value,
+                boolean sel, boolean expanded, boolean leaf, int row, boolean focus) {
             super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, focus);
             boolean failure = true;
             Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
-            if(userObject instanceof SampleResult) {
+            if (userObject instanceof SampleResult) {
                 failure = !(((SampleResult) userObject).isSuccessful());
-            }
-            else if(userObject instanceof AssertionResult) {
+            } else if (userObject instanceof AssertionResult) {
                 AssertionResult assertion = (AssertionResult) userObject;
-                failure =  assertion.isError() || assertion.isFailure();
+                failure = assertion.isError() || assertion.isFailure();
             }
 
             // Set the status for the node
             if (failure) {
                 this.setForeground(Color.red);
                 this.setIcon(imageFailure);
             } else {
                 this.setIcon(imageSuccess);
             }
             return this;
         }
     }
 
-    private static class LocalHTMLEditorKit extends HTMLEditorKit {
-
-        private static final ViewFactory defaultFactory = new LocalHTMLFactory();
-
-        @Override
-        public ViewFactory getViewFactory() {
-            return defaultFactory;
-        }
-
-        private static class LocalHTMLFactory extends javax.swing.text.html.HTMLEditorKit.HTMLFactory {
-            /*
-             * Provide dummy implementations to suppress download and display of
-             * related resources: - FRAMEs - IMAGEs TODO create better dummy
-             * displays TODO suppress LINK somehow
-             */
-            @Override
-            public View create(Element elem) {
-                Object o = elem.getAttributes().getAttribute(StyleConstants.NameAttribute);
-                if (o instanceof HTML.Tag) {
-                    HTML.Tag kind = (HTML.Tag) o;
-                    if (kind == HTML.Tag.FRAME) {
-                        return new ComponentView(elem);
-                    } else if (kind == HTML.Tag.IMG) {
-                        return new ComponentView(elem);
-                    }
-                }
-                return super.create(elem);
-            }
-        }
-    }
-
-    /**
-     *
-     * A Dom tree panel for to display response as tree view author <a
-     * href="mailto:d.maung@mdl.com">Dave Maung</a> TODO implement to find any
-     * nodes in the tree using TreePath.
-     *
-     */
-    private static class DOMTreePanel extends JPanel {
-
-        private JTree domJTree;
-
-        public DOMTreePanel(org.w3c.dom.Document document) {
-            super(new GridLayout(1, 0));
-            try {
-                Node firstElement = getFirstElement(document);
-                DefaultMutableTreeNode top = new XMLDefaultMutableTreeNode(firstElement);
-                domJTree = new JTree(top);
-
-                domJTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
-                domJTree.setShowsRootHandles(true);
-                JScrollPane domJScrollPane = new JScrollPane(domJTree);
-                domJTree.setAutoscrolls(true);
-                this.add(domJScrollPane);
-                ToolTipManager.sharedInstance().registerComponent(domJTree);
-                domJTree.setCellRenderer(new DomTreeRenderer());
-            } catch (SAXException e) {
-                log.warn("", e);
-            }
-
-        }
-
-        /**
-         * Skip all DTD nodes, all prolog nodes. They dont support in tree view
-         * We let user to insert them however in DOMTreeView, we dont display it
-         *
-         * @param root
-         * @return
-         */
-        private Node getFirstElement(Node parent) {
-            NodeList childNodes = parent.getChildNodes();
-            Node toReturn = parent; // Must return a valid node, or may generate an NPE
-            for (int i = 0; i < childNodes.getLength(); i++) {
-                Node childNode = childNodes.item(i);
-                toReturn = childNode;
-                if (childNode.getNodeType() == Node.ELEMENT_NODE){
-                    break;
-                }
-
-            }
-            return toReturn;
-        }
-
-        /**
-         * This class is to view as tooltext. This is very useful, when the
-         * contents has long string and does not fit in the view. it will also
-         * automatically wrap line for each 100 characters since tool tip
-         * support html. author <a href="mailto:d.maung@mdl.com">Dave Maung</a>
-         */
-        private static class DomTreeRenderer extends DefaultTreeCellRenderer {
-            @Override
-            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
-                    boolean leaf, int row, boolean phasFocus) {
-                super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, phasFocus);
-
-                DefaultMutableTreeNode valueTreeNode = (DefaultMutableTreeNode) value;
-                setToolTipText(getHTML(valueTreeNode.toString(), "<br>", 100)); // $NON-NLS-1$
-                return this;
-            }
-
-            /**
-             * get the html
-             *
-             * @param str
-             * @param separator
-             * @param maxChar
-             * @return
-             */
-            private String getHTML(String str, String separator, int maxChar) {
-                StringBuilder strBuf = new StringBuilder("<html><body bgcolor=\"yellow\"><b>"); // $NON-NLS-1$
-                char[] chars = str.toCharArray();
-                for (int i = 0; i < chars.length; i++) {
-
-                    if (i % maxChar == 0 && i != 0) {
-                        strBuf.append(separator);
-                    }
-                    strBuf.append(encode(chars[i]));
-
-                }
-                strBuf.append("</b></body></html>"); // $NON-NLS-1$
-                return strBuf.toString();
-
-            }
-
-            private String encode(char c) {
-                String toReturn = String.valueOf(c);
-                switch (c) {
-                case '<': // $NON-NLS-1$
-                    toReturn = "&lt;"; // $NON-NLS-1$
-                    break;
-                case '>': // $NON-NLS-1$
-                    toReturn = "&gt;"; // $NON-NLS-1$
-                    break;
-                case '\'': // $NON-NLS-1$
-                    toReturn = "&apos;"; // $NON-NLS-1$
-                    break;
-                case '\"': // $NON-NLS-1$
-                    toReturn = "&quot;"; // $NON-NLS-1$
-                    break;
-
-                }
-                return toReturn;
-            }
-        }
-    }
-
-    private static void showErrorMessageDialog(String message, String title, int messageType) {
-        JOptionPane.showMessageDialog(null, message, title, messageType);
-    }
-
 }
