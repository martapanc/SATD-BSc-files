diff --git a/src/jorphan/org/apache/jorphan/gui/JLabeledTextArea.java b/src/jorphan/org/apache/jorphan/gui/JLabeledTextArea.java
new file mode 100644
index 000000000..0e2e9c760
--- /dev/null
+++ b/src/jorphan/org/apache/jorphan/gui/JLabeledTextArea.java
@@ -0,0 +1,243 @@
+/*
+ * ====================================================================
+ * The Apache Software License, Version 1.1
+ *
+ * Copyright (c) 2001 The Apache Software Foundation.  All rights
+ * reserved.
+ *
+ * Redistribution and use in source and binary forms, with or without
+ * modification, are permitted provided that the following conditions
+ * are met:
+ *
+ * 1. Redistributions of source code must retain the above copyright
+ * notice, this list of conditions and the following disclaimer.
+ *
+ * 2. Redistributions in binary form must reproduce the above copyright
+ * notice, this list of conditions and the following disclaimer in
+ * the documentation and/or other materials provided with the
+ * distribution.
+ *
+ * 3. The end-user documentation included with the redistribution,
+ * if any, must include the following acknowledgment:
+ * "This product includes software developed by the
+ * Apache Software Foundation (http://www.apache.org/)."
+ * Alternately, this acknowledgment may appear in the software itself,
+ * if and wherever such third-party acknowledgments normally appear.
+ *
+ * 4. The names "Apache" and "Apache Software Foundation" and
+ * "Apache JMeter" must not be used to endorse or promote products
+ * derived from this software without prior written permission. For
+ * written permission, please contact apache@apache.org.
+ *
+ * 5. Products derived from this software may not be called "Apache",
+ * "Apache JMeter", nor may "Apache" appear in their name, without
+ * prior written permission of the Apache Software Foundation.
+ *
+ * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
+ * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
+ * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
+ * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
+ * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
+ * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
+ * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
+ * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
+ * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
+ * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
+ * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
+ * SUCH DAMAGE.
+ * ====================================================================
+ *
+ * This software consists of voluntary contributions made by many
+ * individuals on behalf of the Apache Software Foundation.  For more
+ * information on the Apache Software Foundation, please see
+ * <http://www.apache.org/>.
+ */
+ 
+ package org.apache.jorphan.gui;
+
+import javax.swing.*;
+import java.util.*;
+import javax.swing.text.Document;
+import javax.swing.event.ChangeListener;
+import javax.swing.event.ChangeEvent;
+import java.awt.BorderLayout;
+import java.util.ArrayList;
+import java.awt.event.FocusListener;
+import java.awt.event.FocusEvent;
+
+/**
+ * A Helper component that wraps a JTextField with a label into
+ * a JPanel (this). This component also has an efficient event handling
+ * mechanism for handling the text changing in the Text Field. The registered
+ * change listeners are only called when the text has changed.
+ *
+ * @author S.Coleman
+ */
+public class JLabeledTextArea extends JPanel implements JLabeledField
+{
+	 private JLabel mLabel = new JLabel();
+	 private JTextArea mTextArea = new JTextArea(4,40);
+	 private ArrayList mChangeListeners = new ArrayList(3);  // Maybe move to vector if MT problems occur
+
+	 /**
+	  * Default constructor, The label and the Text field are left empty.
+	  */
+	 public JLabeledTextArea()
+	 {
+		  super();
+		  init();
+	 }
+
+	 public List getComponentList()
+	 {
+		List comps = new LinkedList();
+		comps.add(mLabel);
+		comps.add(mTextArea);
+		return comps;
+	 }
+
+	 /**
+	  * Constructs a new component with the label displaying the
+	  * passed text.
+	  *
+	  * @param pLabel The text to in the label.
+	  */
+	 public JLabeledTextArea(String pLabel,Document docModel)
+	 {
+		  super();
+		  mLabel.setText(pLabel);
+		  if(docModel != null)
+		  {
+			setDocumentModel(docModel);
+		  }
+		  init();
+	 }
+
+	 public void setDocumentModel(Document docModel)
+	 {
+		mTextArea.setDocument(docModel);
+	 }
+
+	 /**
+	  * Initialises all of the components on this panel.
+	  */
+	 private void init()
+	 {
+		this.setLayout(new BorderLayout());
+		mTextArea.setLineWrap(true);
+		mTextArea.setWrapStyleWord(true);
+		  // Register the handler for focus listening. This handler will
+		  // only notify the registered when the text changes from when
+		  // the focus is gained to when it is lost.
+		  mTextArea.addFocusListener(new FocusListener(){
+
+				String oldValue = ""; // A temporary cache.
+
+				/**
+				 * Callback method when the focus to the Text Field component
+				 * is lost.
+				 *
+				 * @param pFocusEvent The focus event that occured.
+				 */
+				public void focusLost(FocusEvent pFocusEvent)
+				{
+					 // Compare if the value has changed, since we received focus.
+					 if (oldValue.equals(mTextArea.getText()) == false)
+					 {
+						  notifyChangeListeners();
+					 }
+				}
+
+				/**
+				 * Catch what the value was when focus was gained.
+				 */
+				public void focusGained(FocusEvent pFocusEvent)
+				{
+					 oldValue = mTextArea.getText();
+				}
+		  });
+		  mTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
+
+		  // Add the sub components
+		  this.add(mLabel,BorderLayout.NORTH);
+		  this.add(mTextArea,BorderLayout.CENTER);
+	 }
+
+	 /**
+	  * Set the text displayed in the label.
+	  *
+	  * @param pLabel The new label text.
+	  */
+	 public void setLabel(String pLabel)
+	 {
+		  mLabel.setText(pLabel);
+	 }
+
+	 /**
+	  * Set the text displayed in the Text Field.
+	  *
+	  * @param pText The new text to display in the text field.
+	  */
+	 public void setText(String pText)
+	 {
+		  mTextArea.setText(pText);
+	 }
+
+	 /**
+	  * Returns the text in the Text Field.
+	  *
+	  * @return The text in the Text Field.
+	  */
+	 public String getText()
+	 {
+		  return mTextArea.getText();
+	 }
+
+	 /**
+	  * Returns the text of the label.
+	  *
+	  * @return The text of the label.
+	  */
+	 public String getLabel()
+	 {
+		  return mLabel.getText();
+	 }
+
+	 /**
+	  * Adds a change listener, that will be notified when the text in the
+	  * text field is changed. The ChangeEvent that will be passed
+	  * to registered listeners will contain this object as the source, allowing
+	  * the new text to be extracted using the {@link #getText() getText} method.
+	  *
+	  * @param pChangeListener The listener to add
+	  */
+	 public void addChangeListener(ChangeListener pChangeListener)
+	 {
+		  mChangeListeners.add(pChangeListener);
+	 }
+
+	 /**
+	  * Removes a change listener.
+	  *
+	  * @param pChangeListener The change listener to remove.
+	  */
+	 public void removeChangeListener(ChangeListener pChangeListener)
+	 {
+		  mChangeListeners.remove(pChangeListener);
+	 }
+
+	 /**
+	  * Notify all registered change listeners that the
+	  * text in the text field has changed.
+	  */
+	 private void notifyChangeListeners()
+	 {
+		  ChangeEvent ce = new ChangeEvent(this);
+		  for (int index = 0; index < mChangeListeners.size(); index ++)
+		  {
+				((ChangeListener)mChangeListeners.get(index)).stateChanged(ce);
+		  }
+	 }
+
+
+}
\ No newline at end of file
