diff --git a/src/core/org/apache/jmeter/util/JSR223TestElement.java b/src/core/org/apache/jmeter/util/JSR223TestElement.java
index d0a49bf82..9ffc2f998 100644
--- a/src/core/org/apache/jmeter/util/JSR223TestElement.java
+++ b/src/core/org/apache/jmeter/util/JSR223TestElement.java
@@ -1,290 +1,290 @@
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
  *
  */
 
 package org.apache.jmeter.util;
 
 import java.io.BufferedReader;
 import java.io.File;
 import java.io.FileReader;
 import java.io.IOException;
 import java.io.Serializable;
 import java.util.Collections;
 import java.util.Map;
 import java.util.Properties;
 
 import javax.script.Bindings;
 import javax.script.Compilable;
 import javax.script.CompiledScript;
 import javax.script.ScriptEngine;
 import javax.script.ScriptEngineManager;
 import javax.script.ScriptException;
 
 import org.apache.commons.codec.digest.DigestUtils;
 import org.apache.commons.collections.map.LRUMap;
 import org.apache.commons.lang3.StringUtils;
 import org.apache.jmeter.samplers.SampleResult;
 import org.apache.jmeter.samplers.Sampler;
 import org.apache.jmeter.testelement.TestStateListener;
 import org.apache.jmeter.threads.JMeterContext;
 import org.apache.jmeter.threads.JMeterContextService;
 import org.apache.jmeter.threads.JMeterVariables;
-import org.apache.jorphan.logging.LoggingManager;
 import org.apache.jorphan.util.JOrphanUtils;
-import org.apache.log.Logger;
+import org.slf4j.Logger;
+import org.slf4j.LoggerFactory;
 
 public abstract class JSR223TestElement extends ScriptingTestElement
     implements Serializable, TestStateListener
 {
-    private static final long serialVersionUID = 231L;
+    private static final long serialVersionUID = 232L;
         
     /**
      * Cache of compiled scripts
      */
     @SuppressWarnings("unchecked") // LRUMap does not support generics (yet)
     private static final Map<String, CompiledScript> compiledScriptsCache = 
             Collections.synchronizedMap(
                     new LRUMap(JMeterUtils.getPropDefault("jsr223.compiled_scripts_cache_size", 100)));
 
     /** If not empty then script in ScriptText will be compiled and cached */
     private String cacheKey = "";
     
     /** md5 of the script, used as an unique key for the cache */
     private String scriptMd5 = null;
     
     /**
      * Initialization On Demand Holder pattern
      */
     private static class LazyHolder {
         private LazyHolder() {
             super();
         }
         public static final ScriptEngineManager INSTANCE = new ScriptEngineManager();
     }
  
     /**
      * @return ScriptEngineManager singleton
      */
     public static ScriptEngineManager getInstance() {
             return LazyHolder.INSTANCE;
     }
 
     public JSR223TestElement() {
         super();
     }
 
     /**
      * @return {@link ScriptEngine} for language defaulting to groovy if language is not set
      * @throws ScriptException when no {@link ScriptEngine} could be found
      */
     protected ScriptEngine getScriptEngine() throws ScriptException {
         String lang = getScriptLanguageWithDefault();
         ScriptEngine scriptEngine = getInstance().getEngineByName(lang);
         if (scriptEngine == null) {
             throw new ScriptException("Cannot find engine named: '"+lang+"', ensure you set language field in JSR223 Test Element: "+getName());
         }
 
         return scriptEngine;
     }
 
     /**
      * @return script language or DEFAULT_SCRIPT_LANGUAGE if none is set
      */
     private String getScriptLanguageWithDefault() {
         String lang = getScriptLanguage();
         if (StringUtils.isNotEmpty(lang)) {
             return lang;
         }
         return DEFAULT_SCRIPT_LANGUAGE;
     }
 
     /**
      * Populate variables to be passed to scripts
      * @param bindings Bindings
      */
     protected void populateBindings(Bindings bindings) {
         final String label = getName();
         final String fileName = getFilename();
         final String scriptParameters = getParameters();
         // Use actual class name for log
-        final Logger logger = LoggingManager.getLoggerForShortName(getClass().getName());
+        final Logger logger = LoggerFactory.getLogger(getClass());
         bindings.put("log", logger); // $NON-NLS-1$ (this name is fixed)
         bindings.put("Label", label); // $NON-NLS-1$ (this name is fixed)
         bindings.put("FileName", fileName); // $NON-NLS-1$ (this name is fixed)
         bindings.put("Parameters", scriptParameters); // $NON-NLS-1$ (this name is fixed)
         String [] args=JOrphanUtils.split(scriptParameters, " ");//$NON-NLS-1$
         bindings.put("args", args); // $NON-NLS-1$ (this name is fixed)
         // Add variables for access to context and variables
         JMeterContext jmctx = JMeterContextService.getContext();
         bindings.put("ctx", jmctx); // $NON-NLS-1$ (this name is fixed)
         JMeterVariables vars = jmctx.getVariables();
         bindings.put("vars", vars); // $NON-NLS-1$ (this name is fixed)
         Properties props = JMeterUtils.getJMeterProperties();
         bindings.put("props", props); // $NON-NLS-1$ (this name is fixed)
         // For use in debugging:
         bindings.put("OUT", System.out); // NOSONAR $NON-NLS-1$ (this name is fixed)
 
         // Most subclasses will need these:
         Sampler sampler = jmctx.getCurrentSampler();
         bindings.put("sampler", sampler); // $NON-NLS-1$ (this name is fixed)
         SampleResult prev = jmctx.getPreviousResult();
         bindings.put("prev", prev); // $NON-NLS-1$ (this name is fixed)
     }
 
 
     /**
      * This method will run inline script or file script with special behaviour for file script:
      * - If ScriptEngine implements Compilable script will be compiled and cached
      * - If not if will be run
      * @param scriptEngine ScriptEngine
      * @param bindings {@link Bindings} might be null
      * @return Object returned by script
      * @throws IOException when reading the script fails
      * @throws ScriptException when compiling or evaluation of the script fails
      */
     protected Object processFileOrScript(ScriptEngine scriptEngine, Bindings bindings) throws IOException, ScriptException {
         if (bindings == null) {
             bindings = scriptEngine.createBindings();
         }
         populateBindings(bindings);
         File scriptFile = new File(getFilename()); 
         // Hack: bsh-2.0b5.jar BshScriptEngine implements Compilable but throws "java.lang.Error: unimplemented"
         boolean supportsCompilable = scriptEngine instanceof Compilable 
                 && !("bsh.engine.BshScriptEngine".equals(scriptEngine.getClass().getName())); // NOSONAR $NON-NLS-1$
         if (!StringUtils.isEmpty(getFilename())) {
             if (scriptFile.exists() && scriptFile.canRead()) {
                 if (supportsCompilable) {
                     String cacheKey = 
                             getScriptLanguage()+"#"+ // $NON-NLS-1$
                             scriptFile.getAbsolutePath()+"#"+  // $NON-NLS-1$
                                     scriptFile.lastModified();
                     CompiledScript compiledScript = 
                             compiledScriptsCache.get(cacheKey);
                     if (compiledScript==null) {
                         synchronized (compiledScriptsCache) {
                             compiledScript = 
                                     compiledScriptsCache.get(cacheKey);
                             if (compiledScript==null) {
                                 // TODO Charset ?
                                 try ( BufferedReader fileReader = new BufferedReader(new FileReader(scriptFile), 
                                         (int)scriptFile.length())) {
                                     compiledScript = 
                                             ((Compilable) scriptEngine).compile(fileReader);
                                     compiledScriptsCache.put(cacheKey, compiledScript);
                                 }
                             }
                         }
                     }
                     return compiledScript.eval(bindings);
                 } else {
                     // TODO Charset ?
                     try ( BufferedReader fileReader = new BufferedReader(new FileReader(scriptFile), 
                             (int)scriptFile.length())) {
                         return scriptEngine.eval(fileReader, bindings);
                     }
                 }
             }  else {
                 throw new ScriptException("Script file '"+scriptFile.getAbsolutePath()+"' does not exist or is unreadable for element:"+getName());
             }
         } else if (!StringUtils.isEmpty(getScript())) {
             if (supportsCompilable && !StringUtils.isEmpty(cacheKey)) {
                 computeScriptMD5();
                 CompiledScript compiledScript = compiledScriptsCache.get(this.scriptMd5);
                 if (compiledScript == null) {
                     synchronized (compiledScriptsCache) {
                         compiledScript = compiledScriptsCache.get(this.scriptMd5);
                         if (compiledScript == null) {
                             compiledScript = ((Compilable) scriptEngine).compile(getScript());
                             compiledScriptsCache.put(this.scriptMd5, compiledScript);
                         }
                     }
                 }
                 
                 return compiledScript.eval(bindings);
             } else {
                 return scriptEngine.eval(getScript(), bindings);
             }
         } else {
             throw new ScriptException("Both script file and script text are empty for element:"+getName());            
         }
     }
 
     /**
      * compute MD5 if it is null
      */
     private void computeScriptMD5() {
         // compute the md5 of the script if needed
         if(scriptMd5 == null) {
             scriptMd5 = DigestUtils.md5Hex(getScript());
         }
     }
 
     /**
      * @return the cacheKey
      */
     public String getCacheKey() {
         return cacheKey;
     }
 
     /**
      * @param cacheKey the cacheKey to set
      */
     public void setCacheKey(String cacheKey) {
         this.cacheKey = cacheKey;
     }
 
     /**
      * @see org.apache.jmeter.testelement.TestStateListener#testStarted()
      */
     @Override
     public void testStarted() {
         // NOOP
     }
 
     /**
      * @see org.apache.jmeter.testelement.TestStateListener#testStarted(java.lang.String)
      */
     @Override
     public void testStarted(String host) {
         // NOOP   
     }
 
     /**
      * @see org.apache.jmeter.testelement.TestStateListener#testEnded()
      */
     @Override
     public void testEnded() {
         testEnded("");
     }
 
     /**
      * @see org.apache.jmeter.testelement.TestStateListener#testEnded(java.lang.String)
      */
     @Override
     public void testEnded(String host) {
         compiledScriptsCache.clear();
         this.scriptMd5 = null;
     }
     
     public String getScriptLanguage() {
         return scriptLanguage;
     }
 
     public void setScriptLanguage(String s) {
         scriptLanguage = s;
     }
 }
