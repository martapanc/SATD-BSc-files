diff --git a/src/reports/org/apache/jmeter/testelement/Table.java b/src/reports/org/apache/jmeter/testelement/Table.java
index c14196ecb..2312afa9f 100644
--- a/src/reports/org/apache/jmeter/testelement/Table.java
+++ b/src/reports/org/apache/jmeter/testelement/Table.java
@@ -1,36 +1,37 @@
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
 package org.apache.jmeter.testelement;
 
 import java.util.List;
 
 public class Table extends AbstractTable {
 
     public Table() {
         super();
     }
 
     /**
      * for now the method isn't implemented. I still need to decide how
      * it should be implemented.
      */
+    @SuppressWarnings("unchecked") // TODO fix this when there is a real implementation
     @Override
     public String[][] getTableData(List data) {
         return new String[0][0];
     }
 }