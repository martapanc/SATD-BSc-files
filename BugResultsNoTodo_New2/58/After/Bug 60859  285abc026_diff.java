diff --git a/src/core/org/apache/jmeter/reporters/ResultSaver.java b/src/core/org/apache/jmeter/reporters/ResultSaver.java
index a4c17cbff..854d12f8e 100644
--- a/src/core/org/apache/jmeter/reporters/ResultSaver.java
+++ b/src/core/org/apache/jmeter/reporters/ResultSaver.java
@@ -1,289 +1,300 @@
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
 
 package org.apache.jmeter.reporters;
 
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.FileOutputStream;
 import java.io.IOException;
 import java.io.Serializable;
 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 
+import org.apache.jmeter.engine.util.NoThreadClone;
 import org.apache.jmeter.samplers.SampleEvent;
 import org.apache.jmeter.samplers.SampleListener;
 import org.apache.jmeter.samplers.SampleResult;
 import org.apache.jmeter.services.FileServer;
 import org.apache.jmeter.testelement.AbstractTestElement;
+import org.apache.jmeter.testelement.TestStateListener;
 import org.apache.jmeter.threads.JMeterContextService;
 import org.apache.jorphan.util.JOrphanUtils;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 
 /**
  * Save Result responseData to a set of files
  *
  *
  * This is mainly intended for validation tests
  *
  */
-public class ResultSaver extends AbstractTestElement implements Serializable, SampleListener {
+public class ResultSaver extends AbstractTestElement implements NoThreadClone, Serializable, SampleListener, TestStateListener {
     private static final Logger log = LoggerFactory.getLogger(ResultSaver.class);
 
-    private static final long serialVersionUID = 241L;
+    private static final long serialVersionUID = 242L;
 
     private static final Object LOCK = new Object();
 
     private static final String TIMESTAMP_FORMAT = "yyyyMMdd-HHmm_"; // $NON-NLS-1$
 
-    // File name sequence number
-    //@GuardedBy("LOCK")
-    private static long sequenceNumber = 0;
-
-    //@GuardedBy("LOCK")
-    private static String timeStamp;
-
-    //@GuardedBy("LOCK")
-    private static int numberPadLength;
-
     //+ JMX property names; do not change
 
     public static final String FILENAME = "FileSaver.filename"; // $NON-NLS-1$
 
     public static final String VARIABLE_NAME = "FileSaver.variablename"; // $NON-NLS-1$
 
     public static final String ERRORS_ONLY = "FileSaver.errorsonly"; // $NON-NLS-1$
 
     public static final String SUCCESS_ONLY = "FileSaver.successonly"; // $NON-NLS-1$
 
     public static final String SKIP_AUTO_NUMBER = "FileSaver.skipautonumber"; // $NON-NLS-1$
 
     public static final String SKIP_SUFFIX = "FileSaver.skipsuffix"; // $NON-NLS-1$
 
     public static final String ADD_TIMESTAMP = "FileSaver.addTimstamp"; // $NON-NLS-1$
 
     public static final String NUMBER_PAD_LENGTH = "FileSaver.numberPadLen"; // $NON-NLS-1$
 
     //- JMX property names
 
+    // File name sequence number
+    //@GuardedBy("LOCK")
+    private long sequenceNumber = 0;
+
+    //@GuardedBy("LOCK")
+    private String timeStamp;
+
+    //@GuardedBy("LOCK")
+    private int numberPadLength;
+
     /**
      * Constructor is initially called once for each occurrence in the test plan
      * For GUI, several more instances are created Then clear is called at start
      * of test Called several times during test startup The name will not
      * necessarily have been set at this point.
      */
     public ResultSaver() {
         super();
     }
 
     /**
      * Constructor for use during startup (intended for non-GUI use) 
      * @param name of summariser
      */
     public ResultSaver(String name) {
         this();
         setName(name);
     }
 
     /**
      * @return next number accross all instances
      */
-    private static long nextNumber() {
+    private long nextNumber() {
         synchronized(LOCK) {
             return ++sequenceNumber;
         }
+    }    
+
+    @Override
+    public void testStarted() {
+        testStarted(""); //$NON-NLS-1$
     }
-    
-    /**
-     * This is called once for each occurrence in the test plan, before the
-     * start of the test. The super.clear() method clears the name (and all
-     * other properties), so it is called last.
-     */
+
     @Override
-    public void clear() {
+    public void testStarted(String host) {
         synchronized(LOCK){
             sequenceNumber = 0;
             if (getAddTimeStamp()) {
                 DateFormat format = new SimpleDateFormat(TIMESTAMP_FORMAT);
                 timeStamp = format.format(new Date());
             } else {
                 timeStamp = "";
             }
             numberPadLength=getNumberPadLen();
         }
-        super.clear();
+    }
+
+    @Override
+    public void testEnded() {
+        testEnded(""); //$NON-NLS-1$
+    }
+
+    @Override
+    public void testEnded(String host) {
+        
     }
 
     /**
      * Saves the sample result (and any sub results) in files
      *
      * @see org.apache.jmeter.samplers.SampleListener#sampleOccurred(org.apache.jmeter.samplers.SampleEvent)
      */
     @Override
     public void sampleOccurred(SampleEvent e) {
       processSample(e.getResult(), new Counter());
    }
 
    /**
     * Recurse the whole (sub)result hierarchy.
     *
     * @param s Sample result
     * @param c sample counter
     */
    private void processSample(SampleResult s, Counter c) {
        saveSample(s, c.num++);
        SampleResult[] sampleResults = s.getSubResults();
        for (SampleResult sampleResult : sampleResults) {
            processSample(sampleResult, c);
        }
     }
 
     /**
      * @param s SampleResult to save
      * @param num number to append to variable (if >0)
      */
     private void saveSample(SampleResult s, int num) {
         // Should we save the sample?
         if (s.isSuccessful()){
             if (getErrorsOnly()){
                 return;
             }
         } else {
             if (getSuccessOnly()){
                 return;
             }
         }
 
         String fileName = makeFileName(s.getContentType(), getSkipAutoNumber(), getSkipSuffix());
         if (log.isDebugEnabled()) {
             log.debug("Saving {} in {}", s.getSampleLabel(), fileName);
         }
         s.setResultFileName(fileName);// Associate sample with file name
         String variable = getVariableName();
         if (variable.length()>0){
             if (num > 0) {
                 StringBuilder sb = new StringBuilder(variable);
                 sb.append(num);
                 variable=sb.toString();
             }
             JMeterContextService.getContext().getVariables().put(variable, fileName);
         }
         File out = new File(fileName);
         try (FileOutputStream fos = new FileOutputStream(out)){
             JOrphanUtils.write(s.getResponseData(), fos); // chunk the output if necessary
         } catch (FileNotFoundException e) {
             log.error("Error creating sample file for {}", s.getSampleLabel(), e);
         } catch (IOException e) {
             log.error("Error saving sample {}", s.getSampleLabel(), e);
         }
     }
 
     /**
      * @param contentType Content type
      * @param skipAutoNumber Skip auto number
      * @param skipSuffix Skip suffix
      * @return fileName composed of fixed prefix, a number, and a suffix derived
      *         from the contentType e.g. Content-Type:
      *         text/html;charset=ISO-8859-1
      */
-    private String makeFileName(String contentType, boolean skipAutoNumber, boolean skipSuffix) {
+    String makeFileName(String contentType, boolean skipAutoNumber, boolean skipSuffix) {
         StringBuilder sb = new StringBuilder(FileServer.resolveBaseRelativeName(getFilename()));
         sb.append(timeStamp); // may be the empty string
         if (!skipAutoNumber){
             String number = Long.toString(nextNumber());
             for(int i=number.length(); i < numberPadLength; i++) {
                 sb.append('0');
             }
             sb.append(number);
         }
         if (!skipSuffix){
             sb.append('.');
             if (contentType != null) {
                 int i = contentType.indexOf('/'); // $NON-NLS-1$
                 if (i != -1) {
                     int j = contentType.indexOf(';'); // $NON-NLS-1$
                     if (j != -1) {
                         sb.append(contentType.substring(i + 1, j));
                     } else {
                         sb.append(contentType.substring(i + 1));
                     }
                 } else {
                     sb.append("unknown");
                 }
             } else {
                 sb.append("unknown");
             }
         }
         return sb.toString();
     }
 
     /**
      * {@inheritDoc}
      */
     @Override
     public void sampleStarted(SampleEvent e) {
         // not used
     }
 
     /**
      * {@inheritDoc}
      */
     @Override
     public void sampleStopped(SampleEvent e) {
         // not used
     }
 
     private String getFilename() {
         return getPropertyAsString(FILENAME);
     }
 
     private String getVariableName() {
         return getPropertyAsString(VARIABLE_NAME,""); // $NON-NLS-1$
     }
 
     private boolean getErrorsOnly() {
         return getPropertyAsBoolean(ERRORS_ONLY);
     }
 
     private boolean getSkipAutoNumber() {
         return getPropertyAsBoolean(SKIP_AUTO_NUMBER);
     }
 
     private boolean getSkipSuffix() {
         return getPropertyAsBoolean(SKIP_SUFFIX);
     }
 
     private boolean getSuccessOnly() {
         return getPropertyAsBoolean(SUCCESS_ONLY);
     }
 
     private boolean getAddTimeStamp() {
         return getPropertyAsBoolean(ADD_TIMESTAMP);
     }
 
     private int getNumberPadLen() {
         return getPropertyAsInt(NUMBER_PAD_LENGTH, 0);
     }
 
     // Mutable int to keep track of sample count
     private static class Counter{
         int num;
     }
 }
