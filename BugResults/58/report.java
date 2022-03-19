File path: src/core/org/apache/jmeter/reporters/ResultSaver.java
Comment: // TODO - perhaps save other items such as headers?
Initial commit id: 59671c56f
Final commit id: da1c07e79
   Bugs between [       3]:
3e16150b7 Bug 52214 - Save Responses to a file - improve naming algorithm - add fixed width numbers - add optional timestamp - fix synchronisation
9cca78bc0 Bug 49365 - Allow result set to be written to file in a path relative to the loaded script
d81ad7e22 Bug 43119 - Save Responses to file: optionally omit the file number
   Bugs after [       2]:
285abc026 Bug 60859 - Save Responses to a file : 2 elements with different configuration will overlap Add JUnits Bugzilla Id: 60859
11d942f4a Bug 60564 - Migrating LogKit to SLF4J - core/engine,plugin,report,reporters packages (2/2) Contributed by Woonsan Ko This closes #270 Bugzilla Id: 60564

End block index: 205
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

import org.apache.jmeter.samplers.Clearable;
import org.apache.jmeter.samplers.SampleEvent;
import org.apache.jmeter.samplers.SampleListener;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.jorphan.util.JOrphanUtils;
import org.apache.log.Logger;

/**
 * Save Result responseData to a set of files 
 * 
 * 
 * This is mainly intended for validation tests
 * 
 */
// TODO - perhaps save other items such as headers?
public class ResultSaver extends AbstractTestElement implements Serializable, SampleListener, Clearable {
	private static final Logger log = LoggingManager.getLoggerForClass();

	// File name sequence number
	private static long sequenceNumber = 0;

	public static final String FILENAME = "FileSaver.filename"; // $NON-NLS-1$

	public static final String ERRORS_ONLY = "FileSaver.errorsonly"; // $NON-NLS-1$

    public static final String SUCCESS_ONLY = "FileSaver.successonly"; // $NON-NLS-1$

    private static synchronized long nextNumber() {
		return ++sequenceNumber;
	}

	/*
	 * Constructor is initially called once for each occurrence in the test plan
	 * For GUI, several more instances are created Then clear is called at start
	 * of test Called several times during test startup The name will not
	 * necessarily have been set at this point.
	 */
	public ResultSaver() {
		super();
		// log.debug(Thread.currentThread().getName());
		// System.out.println(">> "+me+" "+this.getName()+"
		// "+Thread.currentThread().getName());
	}

	/*
	 * Constructor for use during startup (intended for non-GUI use) @param name
	 * of summariser
	 */
	public ResultSaver(String name) {
		this();
		setName(name);
	}

	/*
	 * This is called once for each occurrence in the test plan, before the
	 * start of the test. The super.clear() method clears the name (and all
	 * other properties), so it is called last.
	 */
	// TODO: is this clearData, clearGui or TestElement.clear() ?
	public void clear() {
		// System.out.println("-- "+me+this.getName()+"
		// "+Thread.currentThread().getName());
		super.clear();
		sequenceNumber = 0; // TODO is this the right thing to do?
	}

	// TODO - is this the same as the above?
	public void clearData() {
	}

	/**
	 * Saves the sample result (and any sub results) in files
	 * 
	 * @see org.apache.jmeter.samplers.SampleListener#sampleOccurred(org.apache.jmeter.samplers.SampleEvent)
	 */
	public void sampleOccurred(SampleEvent e) {
      processSample(e.getResult());
   }

   /**
    * Recurse the whole (sub)result hierarchy.
    *
    * @param s Sample result
    */
   private void processSample(SampleResult s) {
		saveSample(s);
		SampleResult[] sr = s.getSubResults();
		for (int i = 0; i < sr.length; i++) {
			processSample(sr[i]);
		}
	}

	/**
	 * @param s
	 *            SampleResult to save
	 */
	private void saveSample(SampleResult s) {
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

		nextNumber();
		String fileName = makeFileName(s.getContentType());
		log.debug("Saving " + s.getSampleLabel() + " in " + fileName);
        s.setResultFileName(fileName);// Associate sample with file name
		File out = new File(fileName);
		FileOutputStream pw = null;
		try {
			pw = new FileOutputStream(out);
			pw.write(s.getResponseData());
		} catch (FileNotFoundException e1) {
			log.error("Error creating sample file for " + s.getSampleLabel(), e1);
		} catch (IOException e1) {
			log.error("Error saving sample " + s.getSampleLabel(), e1);
		} finally {
            JOrphanUtils.closeQuietly(pw);
		}
	}

	/**
	 * @return fileName composed of fixed prefix, a number, and a suffix derived
	 *         from the contentType e.g. Content-Type:
	 *         text/html;charset=ISO-8859-1
	 */
	private String makeFileName(String contentType) {
		String suffix = "unknown";
		if (contentType != null) {
			int i = contentType.indexOf("/");
			if (i != -1) {
				int j = contentType.indexOf(";");
				if (j != -1) {
					suffix = contentType.substring(i + 1, j);
				} else {
					suffix = contentType.substring(i + 1);
				}
			}
		}
		return getFilename() + sequenceNumber + "." + suffix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.jmeter.samplers.SampleListener#sampleStarted(org.apache.jmeter.samplers.SampleEvent)
	 */
	public void sampleStarted(SampleEvent e) {
		// not used
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.jmeter.samplers.SampleListener#sampleStopped(org.apache.jmeter.samplers.SampleEvent)
	 */
	public void sampleStopped(SampleEvent e) {
		// not used
	}

	private String getFilename() {
		return getPropertyAsString(FILENAME);
	}

	private boolean getErrorsOnly() {
		return getPropertyAsBoolean(ERRORS_ONLY);
	}

    private boolean getSuccessOnly() {
        return getPropertyAsBoolean(SUCCESS_ONLY);
    }

}
