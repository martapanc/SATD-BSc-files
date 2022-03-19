diff --git a/test/src/org/apache/jmeter/util/TestJMeterUtils.java b/test/src/org/apache/jmeter/util/TestJMeterUtils.java
index 3e0f91000..3b5d9fc42 100644
--- a/test/src/org/apache/jmeter/util/TestJMeterUtils.java
+++ b/test/src/org/apache/jmeter/util/TestJMeterUtils.java
@@ -1,45 +1,41 @@
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
 
 /**
  * Package to test JMeterUtils methods 
  */
      
 package org.apache.jmeter.util;
 
-import junit.framework.TestCase;
+import static org.junit.Assert.assertEquals;
 
-public class TestJMeterUtils extends TestCase {
+import org.junit.Test;
 
-    public TestJMeterUtils() {
-        super();
-    }
-
-    public TestJMeterUtils(String arg0) {
-        super(arg0);
-    }
+public class TestJMeterUtils {
 
+    @Test
     public void testGetResourceFileAsText() throws Exception{
         String sep = System.getProperty("line.separator");
         assertEquals("line one" + sep + "line two" + sep, JMeterUtils.getResourceFileAsText("resourcefile.txt"));
     }
     
+    @Test
     public void testGetResourceFileAsTextWithMisingResource() throws Exception{
         assertEquals("", JMeterUtils.getResourceFileAsText("not_existant_resourcefile.txt"));
     }
 }
