diff --git a/src/core/org/apache/jmeter/testbeans/gui/TestBeanGUI.java b/src/core/org/apache/jmeter/testbeans/gui/TestBeanGUI.java
index 2e3b6901d..5652e25b3 100644
--- a/src/core/org/apache/jmeter/testbeans/gui/TestBeanGUI.java
+++ b/src/core/org/apache/jmeter/testbeans/gui/TestBeanGUI.java
@@ -1,500 +1,516 @@
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
  */
 package org.apache.jmeter.testbeans.gui;
 
 import java.awt.BorderLayout;
 import java.awt.Component;
 import java.beans.BeanDescriptor;
 import java.beans.BeanInfo;
 import java.beans.Customizer;
 import java.beans.IntrospectionException;
 import java.beans.Introspector;
 import java.beans.PropertyDescriptor;
 import java.beans.PropertyEditorManager;
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.Collection;
 import java.util.HashMap;
 import java.util.LinkedList;
 import java.util.List;
 import java.util.Locale;
 import java.util.Map;
 import java.util.ResourceBundle;
 
 import javax.swing.JPopupMenu;
 
 import org.apache.commons.collections.map.LRUMap;
 import org.apache.jmeter.assertions.Assertion;
 import org.apache.jmeter.assertions.gui.AbstractAssertionGui;
 import org.apache.jmeter.config.ConfigElement;
 import org.apache.jmeter.config.gui.AbstractConfigGui;
 import org.apache.jmeter.control.Controller;
 import org.apache.jmeter.control.gui.AbstractControllerGui;
 import org.apache.jmeter.gui.AbstractJMeterGuiComponent;
 import org.apache.jmeter.gui.JMeterGUIComponent;
 import org.apache.jmeter.gui.util.MenuFactory;
 import org.apache.jmeter.processor.PostProcessor;
 import org.apache.jmeter.processor.PreProcessor;
 import org.apache.jmeter.processor.gui.AbstractPostProcessorGui;
 import org.apache.jmeter.processor.gui.AbstractPreProcessorGui;
 import org.apache.jmeter.samplers.Sampler;
 import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
 import org.apache.jmeter.testbeans.TestBean;
 import org.apache.jmeter.testelement.TestElement;
 import org.apache.jmeter.testelement.property.AbstractProperty;
 import org.apache.jmeter.testelement.property.JMeterProperty;
 import org.apache.jmeter.testelement.property.PropertyIterator;
 import org.apache.jmeter.timers.Timer;
 import org.apache.jmeter.timers.gui.AbstractTimerGui;
 import org.apache.jmeter.util.JMeterUtils;
 import org.apache.jmeter.util.LocaleChangeEvent;
 import org.apache.jmeter.util.LocaleChangeListener;
 import org.apache.jmeter.visualizers.Visualizer;
 import org.apache.jmeter.visualizers.gui.AbstractVisualizer;
 import org.apache.jorphan.logging.LoggingManager;
 import org.apache.jorphan.util.JOrphanUtils;
 import org.apache.log.Logger;
 
 /**
  * JMeter GUI element editing for TestBean elements.
  * <p>
  * The actual GUI is always a bean customizer: if the bean descriptor provides
  * one, it will be used; otherwise, a GenericTestBeanCustomizer will be created
  * for this purpose.
  * <p>
  * Those customizers deviate from the standards only in that, instead of a bean,
  * they will receive a Map in the setObject call. This will be a property name
  * to value Map. The customizer is also in charge of initializing empty Maps
  * with sensible initial values.
  * <p>
  * If the provided Customizer class implements the SharedCustomizer interface,
  * the same instance of the customizer will be reused for all beans of the type:
  * setObject(map) can then be called multiple times. Otherwise, one separate
  * instance will be used for each element. For efficiency reasons, most
  * customizers should implement SharedCustomizer.
  *
  */
 public class TestBeanGUI extends AbstractJMeterGuiComponent implements JMeterGUIComponent, LocaleChangeListener{
     private static final long serialVersionUID = 240L;
 
     private static final Logger log = LoggingManager.getLoggerForClass();
 
     private final Class<?> testBeanClass;
 
     private transient BeanInfo beanInfo;
 
     private final Class<?> customizerClass;
 
     /**
      * The single customizer if the customizer class implements
      * SharedCustomizer, null otherwise.
      */
     private Customizer customizer = null;
 
     /**
      * TestElement to Customizer map if customizer is null. This is necessary to
      * avoid the cost of creating a new customizer on each edit. The cache size
      * needs to be limited, though, to avoid memory issues when editing very
      * large test plans.
      */
     @SuppressWarnings("unchecked")
     private final Map<TestElement, Customizer> customizers = new LRUMap(20);
 
     /**
      * Index of the customizer in the JPanel's child component list:
      */
     private int customizerIndexInPanel;
 
     /**
      * The property name to value map that the active customizer edits:
      */
     private final Map<String, Object> propertyMap = new HashMap<String, Object>();
 
     /**
      * Whether the GUI components have been created.
      */
     private boolean initialized = false;
 
     static {
         List<String> paths = new LinkedList<String>();
         paths.add("org.apache.jmeter.testbeans.gui");// $NON-NLS-1$
         paths.addAll(Arrays.asList(PropertyEditorManager.getEditorSearchPath()));
         String s = JMeterUtils.getPropDefault("propertyEditorSearchPath", null);// $NON-NLS-1$
         if (s != null) {
             paths.addAll(Arrays.asList(JOrphanUtils.split(s, ",", "")));// $NON-NLS-1$ // $NON-NLS-2$
         }
         PropertyEditorManager.setEditorSearchPath(paths.toArray(new String[paths.size()]));
     }
 
     /**
      * @deprecated Dummy for JUnit test purposes only
      */
     @Deprecated
     public TestBeanGUI() {
         log.warn("Constructor only for use in testing");// $NON-NLS-1$
         testBeanClass = null;
         customizerClass = null;
         beanInfo = null;
     }
 
     public TestBeanGUI(Class<?> testBeanClass) {
         super();
         log.debug("testing class: " + testBeanClass.getName());
         // A quick verification, just in case:
         if (!TestBean.class.isAssignableFrom(testBeanClass)) {
             Error e = new Error();
             log.error("This should never happen!", e);
             throw e; // Programming error: bail out.
         }
 
         this.testBeanClass = testBeanClass;
 
         // Get the beanInfo:
         try {
             beanInfo = Introspector.getBeanInfo(testBeanClass);
         } catch (IntrospectionException e) {
             log.error("Can't get beanInfo for " + testBeanClass.getName(), e);
             throw new Error(e.toString()); // Programming error. Don't
                                             // continue.
         }
 
         customizerClass = beanInfo.getBeanDescriptor().getCustomizerClass();
 
         // Creation of the customizer and GUI initialization is delayed until
         // the
         // first
         // configure call. We don't need all that just to find out the static
         // label, menu
         // categories, etc!
         initialized = false;
         JMeterUtils.addLocaleChangeListener(this);
     }
 
     private Customizer createCustomizer() {
         try {
             return (Customizer) customizerClass.newInstance();
         } catch (InstantiationException e) {
             log.error("Could not instantiate customizer of class " + customizerClass, e);
             throw new Error(e.toString());
         } catch (IllegalAccessException e) {
             log.error("Could not instantiate customizer of class " + customizerClass, e);
             throw new Error(e.toString());
         }
     }
 
     /**
      * {@inheritDoc}
      */
     @Override
     public String getStaticLabel() {
         if (beanInfo == null){
             return "null";// $NON-NLS-1$
         }
         return beanInfo.getBeanDescriptor().getDisplayName();
     }
 
     /**
      * {@inheritDoc}
      */
    public TestElement createTestElement() {
         try {
             TestElement element = (TestElement) testBeanClass.newInstance();
+            // In other GUI component, clearGUI resets the value to defaults one as there is one GUI per Element
+            // With TestBeanGUI as it's shared, its default values are only known here, we must call setValues with 
+            // element (as it holds default values)
+            // otherwise we will get values as computed by customizer reset and not default ones
+            if(initialized) {
+                setValues(element);
+            }
             // configure(element);
             // super.clear(); // set name, enabled.
             modifyTestElement(element); // put the default values back into the
             // new element
             return element;
         } catch (InstantiationException e) {
             log.error("Can't create test element", e);
             throw new Error(e.toString()); // Programming error. Don't
                                             // continue.
         } catch (IllegalAccessException e) {
             log.error("Can't create test element", e);
             throw new Error(e.toString()); // Programming error. Don't
                                             // continue.
         }
     }
 
    /**
     * {@inheritDoc}
     */
     public void modifyTestElement(TestElement element) {
         // Fetch data from screen fields
         if (customizer instanceof GenericTestBeanCustomizer) {
             GenericTestBeanCustomizer gtbc = (GenericTestBeanCustomizer) customizer;
             gtbc.saveGuiFields();
         }
         configureTestElement(element);
 
         // Copy all property values from the map into the element:
         for (PropertyDescriptor desc : beanInfo.getPropertyDescriptors()) {
             String name = desc.getName();
             Object value = propertyMap.get(name);
             log.debug("Modify " + name + " to " + value);
             if (value == null) {
                 if (GenericTestBeanCustomizer.notNull(desc)) { // cannot be null
                     setPropertyInElement(element, name, desc.getValue(GenericTestBeanCustomizer.DEFAULT));
                 } else {
                     element.removeProperty(name);
                 }
             } else {
                 setPropertyInElement(element, name, value);
             }
         }
     }
 
     /**
      * @param element
      * @param name
      */
     private void setPropertyInElement(TestElement element, String name, Object value) {
         JMeterProperty jprop = AbstractProperty.createProperty(value);
         jprop.setName(name);
         element.setProperty(jprop);
     }
 
     /**
      * {@inheritDoc}
      */
     public JPopupMenu createPopupMenu() {
         if (Timer.class.isAssignableFrom(testBeanClass))
         {
             return MenuFactory.getDefaultTimerMenu();
         }
         else if(Sampler.class.isAssignableFrom(testBeanClass))
         {
             return MenuFactory.getDefaultSamplerMenu();
         }
         else if(ConfigElement.class.isAssignableFrom(testBeanClass))
         {
             return MenuFactory.getDefaultConfigElementMenu();
         }
         else if(Assertion.class.isAssignableFrom(testBeanClass))
         {
             return MenuFactory.getDefaultAssertionMenu();
         }
         else if(PostProcessor.class.isAssignableFrom(testBeanClass) ||
                 PreProcessor.class.isAssignableFrom(testBeanClass))
         {
             return MenuFactory.getDefaultExtractorMenu();
         }
         else if(Visualizer.class.isAssignableFrom(testBeanClass))
         {
             return MenuFactory.getDefaultVisualizerMenu();
         }
         else if(Controller.class.isAssignableFrom(testBeanClass))
         {
             return MenuFactory.getDefaultControllerMenu();
         }
         else {
             log.warn("Cannot determine PopupMenu for "+testBeanClass.getName());
             return MenuFactory.getDefaultMenu();
         }
     }
 
     /**
      * {@inheritDoc}
      */
     @Override
     public void configure(TestElement element) {
         if (!initialized){
             init();
         }
         clearGui();
 
         super.configure(element);
 
+        setValues(element);
+
+        initialized = true;
+    }
+    
+    /**
+     * Get values from element to fill propertyMap and setup customizer 
+     * @param element TestElement
+     */
+    private void setValues(TestElement element) {
         // Copy all property values into the map:
         for (PropertyIterator jprops = element.propertyIterator(); jprops.hasNext();) {
             JMeterProperty jprop = jprops.next();
             propertyMap.put(jprop.getName(), jprop.getObjectValue());
         }
-
+        
         if (customizer != null) {
             customizer.setObject(propertyMap);
         } else {
             if (initialized){
                 remove(customizerIndexInPanel);
             }
             Customizer c = customizers.get(element);
             if (c == null) {
                 c = createCustomizer();
                 c.setObject(propertyMap);
                 customizers.put(element, c);
             }
             add((Component) c, BorderLayout.CENTER);
         }
-
-        initialized = true;
     }
 
     /** {@inheritDoc} */
     public Collection<String> getMenuCategories() {
         List<String> menuCategories = new LinkedList<String>();
         BeanDescriptor bd = beanInfo.getBeanDescriptor();
 
         // We don't want to show expert beans in the menus unless we're
         // in expert mode:
         if (bd.isExpert() && !JMeterUtils.isExpertMode()) {
             return null;
         }
 
         int matches = setupGuiClasses(menuCategories);
         if (matches == 0) {
             log.error("Could not assign GUI class to " + testBeanClass.getName());
         } else if (matches > 1) {// may be impossible, but no harm in
                                     // checking ...
             log.error("More than 1 GUI class found for " + testBeanClass.getName());
         }
         return menuCategories;
     }
 
     /**
      * Setup GUI class
      * @return number of matches
      */
     public int setupGuiClasses() {
     	return setupGuiClasses(new ArrayList<String>());
     }
     
     /**
      * Setup GUI class
      * @param menuCategories List<String> menu categories
      * @return number of matches
      */
     private int setupGuiClasses(List<String> menuCategories ) {
     	int matches = 0;// How many classes can we assign from?
         // TODO: there must be a nicer way...
         BeanDescriptor bd = beanInfo.getBeanDescriptor();
     	if (Assertion.class.isAssignableFrom(testBeanClass)) {
             menuCategories.add(MenuFactory.ASSERTIONS);
             bd.setValue(TestElement.GUI_CLASS, AbstractAssertionGui.class.getName());
             matches++;
         }
         if (ConfigElement.class.isAssignableFrom(testBeanClass)) {
             menuCategories.add(MenuFactory.CONFIG_ELEMENTS);
             bd.setValue(TestElement.GUI_CLASS, AbstractConfigGui.class.getName());
             matches++;
         }
         if (Controller.class.isAssignableFrom(testBeanClass)) {
             menuCategories.add(MenuFactory.CONTROLLERS);
             bd.setValue(TestElement.GUI_CLASS, AbstractControllerGui.class.getName());
             matches++;
         }
         if (Visualizer.class.isAssignableFrom(testBeanClass)) {
             menuCategories.add(MenuFactory.LISTENERS);
             bd.setValue(TestElement.GUI_CLASS, AbstractVisualizer.class.getName());
             matches++;
         }
         if (PostProcessor.class.isAssignableFrom(testBeanClass)) {
             menuCategories.add(MenuFactory.POST_PROCESSORS);
             bd.setValue(TestElement.GUI_CLASS, AbstractPostProcessorGui.class.getName());
             matches++;
         }
         if (PreProcessor.class.isAssignableFrom(testBeanClass)) {
             menuCategories.add(MenuFactory.PRE_PROCESSORS);
             bd.setValue(TestElement.GUI_CLASS, AbstractPreProcessorGui.class.getName());
             matches++;
         }
         if (Sampler.class.isAssignableFrom(testBeanClass)) {
             menuCategories.add(MenuFactory.SAMPLERS);
             bd.setValue(TestElement.GUI_CLASS, AbstractSamplerGui.class.getName());
             matches++;
         }
         if (Timer.class.isAssignableFrom(testBeanClass)) {
             menuCategories.add(MenuFactory.TIMERS);
             bd.setValue(TestElement.GUI_CLASS, AbstractTimerGui.class.getName());
             matches++;
         }
         return matches;
     }
 
     private void init() {
         setLayout(new BorderLayout(0, 5));
 
         setBorder(makeBorder());
         add(makeTitlePanel(), BorderLayout.NORTH);
 
         customizerIndexInPanel = getComponentCount();
 
         if (customizerClass == null) {
             customizer = new GenericTestBeanCustomizer(beanInfo);
         } else if (SharedCustomizer.class.isAssignableFrom(customizerClass)) {
             customizer = createCustomizer();
         }
 
         if (customizer != null){
             add((Component) customizer, BorderLayout.CENTER);
         }
     }
 
     /**
      * {@inheritDoc}
      */
     public String getLabelResource() {
         // @see getStaticLabel
         return null;
     }
 
     /**
      * {@inheritDoc}
      */
     @Override
     public void clearGui() {
         super.clearGui();
         if (customizer instanceof GenericTestBeanCustomizer) {
             GenericTestBeanCustomizer gtbc = (GenericTestBeanCustomizer) customizer;
             gtbc.clearGuiFields();
         }
+        propertyMap.clear();
     }
 
     public boolean isHidden() {
         return beanInfo.getBeanDescriptor().isHidden();
     }
 
     public boolean isExpert() {
         return beanInfo.getBeanDescriptor().isExpert();
     }
 
 	/**
 	 * Handle Locale Change by reloading BeanInfo
 	 * @param event {@link LocaleChangeEvent}
 	 */
 	public void localeChanged(LocaleChangeEvent event) {
 		try {
             beanInfo = Introspector.getBeanInfo(testBeanClass);
             setupGuiClasses();
         } catch (IntrospectionException e) {
             log.error("Can't get beanInfo for " + testBeanClass.getName(), e);
             JMeterUtils.reportErrorToUser("Can't get beanInfo for " + testBeanClass.getName());
         }
 	}
 
     /**
      * {@inheritDoc}}
      * @see org.apache.jmeter.gui.AbstractJMeterGuiComponent#getDocAnchor()
      */
     @Override
     public String getDocAnchor() {
         ResourceBundle resourceBundle = ResourceBundle.getBundle(
                 testBeanClass.getName() + "Resources",  // $NON-NLS-1$
                 new Locale("",""));
 
         String name = resourceBundle.getString("displayName");
         return name.replace(' ', '_');
     }
 }
diff --git a/xdocs/changes.xml b/xdocs/changes.xml
index 60d38f250..948bb1036 100644
--- a/xdocs/changes.xml
+++ b/xdocs/changes.xml
@@ -1,165 +1,166 @@
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
 
 <note>
 <b>This page details the changes made in the current version only.</b>
 <br></br>
 Earlier changes are detailed in the <a href="changes_history.html">History of Previous Changes</a>.
 </note>
 
 
 <!--  =================== 2.7 =================== -->
 
 <h1>Version 2.7</h1>
 
 <h2>New and Noteworthy</h2>
 
 
 <!--  =================== Known bugs =================== -->
 
 <h2>Known bugs</h2>
 
 <p>
 The Include Controller has some problems in non-GUI mode (see Bugs 40671, 41286, 44973, 50898). 
 In particular, it can cause a NullPointerException if there are two include controllers with the same name.
 </p>
 
 <p>The Once Only controller behaves correctly under a Thread Group or Loop Controller,
 but otherwise its behaviour is not consistent (or clearly specified).</p>
 
 <p>Listeners don't show iteration counts when a If Controller has a condition which is always false from the first iteration (see Bug 52496).  
 A workaround is to add a sampler at the same level as (or superior to) the If Controller.
 For example a Test Action sampler with 0 wait time (which doesn't generate a sample),
 or a Debug Sampler with all fields set to False (to reduce the sample size).
 </p>
 
 <!-- =================== Incompatible changes =================== -->
 
 <h2>Incompatible changes</h2>
 
 <p>
 When doing replacement of User Defined Variables, Proxy will not substitute partial values anymore when "Regexp matching" is used. It will use Perl 5 word matching ("\b")
 </p>
 
 
 <!-- =================== Bug fixes =================== -->
 
 <h2>Bug fixes</h2>
 
 <h3>HTTP Samplers and Proxy</h3>
 <ul>
 <li>Bug 52613 - Using Raw Post Body option, text gets encoded</li>
 </ul>
 
 <h3>Other Samplers</h3>
 <ul>
 <li>Bug 51737 - TCPSampler : Packet gets converted/corrupted</li>
 </ul>
 
 <h3>Controllers</h3>
 <ul>
 </ul>
 
 <h3>Listeners</h3>
 <ul>
 </ul>
 
 <h3>Assertions</h3>
 <ul>
 </ul>
 
 <h3>Functions</h3>
 <ul>
 </ul>
 
 <h3>I18N</h3>
 <ul>
 <li>Bug 52551 - Function Helper Dialog does not switch language correctly</li>
 <li>Bug 52552 - Help reference only works in English</li>
 </ul>
 
 <h3>General</h3>
 <ul>
 <li>Bug 52639 - JSplitPane divider for log panel should be hidden if log is not activated</li>
 <li>Bug 52672 - Change Controller action deletes all but one child samplers</li>
 <li>Bug 52694 - Deadlock in GUI related to non AWT Threads updating GUI</li>
 <li>Bug 52678 - Proxy : When doing replacement of UserDefinedVariables, partial values should not be substituted</li>
 <li>Bug 52728 - CSV Data Set Config element cannot coexist with BSF Sampler in same Thread Plan</li>
 <li>Bug 52762 - Problem with multiples certificates: first index not used until indexes are restarted</li>
+<li>Bug 52741 - TestBeanGUI default values do not work at second time or later</li>
 </ul>
 
 <!-- =================== Improvements =================== -->
 
 <h2>Improvements</h2>
 
 <h3>HTTP Samplers</h3>
 <ul>
 </ul>
 
 <h3>Other samplers</h3>
 <ul>
 </ul>
 
 <h3>Controllers</h3>
 <ul>
 </ul>
 
 <h3>Listeners</h3>
 <ul>
 <li>Bug 52603 - MailerVisualizer : Enable SSL , TLS and Authentication</li>
 </ul>
 
 <h3>Timers, Assertions, Config, Pre- &amp; Post-Processors</h3>
 <ul>
 </ul>
 
 <h3>Functions</h3>
 <ul>
 </ul>
 
 <h3>I18N</h3>
 <ul>
 </ul>
 
 <h3>General</h3>
 <ul>
 <li>Bug 45839 - Test Action : Allow premature exit from a loop</li>
 <li>Bug 52614 - MailerModel.sendMail has strange way to calculate debug setting</li>
 </ul>
 
 <h2>Non-functional changes</h2>
 <ul>
 <li>Upgraded to rhino 1.7R3 (was js-1.7R2.jar). 
 Note: the Maven coordinates for the jar were changed from rhino:js to org.mozilla:rhino.
 This does not affect JMeter directly, but might cause problems if using JMeter in a Maven project
 with other code that depends on an earlier version of the Rhino Javascript jar.
 </li>
 <li>Bug 52675 - Refactor Proxy and HttpRequestHdr to allow Sampler Creation by Proxy</li>
 <li>Bug 52680 - Mention version in which function was introduced</li>
 </ul>
 
 </section> 
 </body> 
 </document>
