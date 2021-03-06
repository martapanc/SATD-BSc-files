File path: src/protocol/mail/org/apache/jmeter/protocol/mail/sampler/MailReaderSampler.java
Comment:  this sensible?
Initial commit id: bdcbd6fcd
Final commit id: 87b67eb18
   Bugs between [       4]:
87b67eb18 Bug 56539 - Mail reader sampler: When Number of messages to retrieve is superior to 1, Number of samples should only show 1 not the number of messages retrieved Bugzilla Id: 56539
d7fdf5ad2 Bug 53042 - Introduce a new Interface to be implemented by AbstractSampler to allow Sampler to decide wether a config element applies to Sampler
3dbd39d86 Bug 51011 - Mail Reader: upon authentication failure, tell what you tried
91e79e3ed Bug 49603 - Allow accepting expired certificates on Mail Reader Sampler
   Bugs after [       2]:
72cb7ea99 Bug 60564 - Migrating LogKit to SLF4J - Replace logkit loggers with slf4j ones with keeping the current logkit binding solution
6c7feaab6 Bug 57193: Add param and return tags to javadoc Bugzilla Id: 57193

Start block index: 87
End block index: 212
    public SampleResult sample(Entry e) {
        SampleResult parent = new SampleResult();
        boolean isOK = false; // Did sample succeed?
        boolean deleteMessages = getDeleteMessages();

        parent.setSampleLabel(getName());
        
        String samplerString = toString();
        parent.setSamplerData(samplerString);

        /*
         * Perform the sampling
         */
        parent.sampleStart(); // Start timing
        try {
            // Create empty properties
            Properties props = new Properties();

            // Get session
            Session session = Session.getDefaultInstance(props, null);

            // Get the store
            Store store = session.getStore(getServerType());
            store.connect(getServer(), getPortAsInt(), getUserName(), getPassword());

            // Get folder
            Folder folder = store.getFolder(getFolder());
            if (deleteMessages) {
                folder.open(Folder.READ_WRITE);
            } else {
                folder.open(Folder.READ_ONLY);
            }

            // Get directory
            Message messages[] = folder.getMessages();
            StringBuilder pdata = new StringBuilder();
            pdata.append(messages.length);
            pdata.append(" messages found\n");
            parent.setResponseData(pdata.toString(),null);
            parent.setDataType(SampleResult.TEXT);
            parent.setContentType("text/plain"); // $NON-NLS-1$

            int n = getNumMessages();
            if (n == ALL_MESSAGES || n > messages.length) {
                n = messages.length;
            }

            parent.setSampleCount(n); // TODO is this sensible?
            
            for (int i = 0; i < n; i++) {
                StringBuilder cdata = new StringBuilder();
                SampleResult child = new SampleResult();
                child.sampleStart();
                Message message = messages[i];
                
                cdata.append("Message "); // $NON-NLS-1$
                cdata.append(message.getMessageNumber());
                child.setSampleLabel(cdata.toString());
                child.setSamplerData(cdata.toString());
                cdata.setLength(0);

                final String contentType = message.getContentType();
                child.setContentType(contentType);// Store the content-type

                if (isStoreMimeMessage()) {
                    // Don't save headers - they are already in the raw message
                    ByteArrayOutputStream bout = new ByteArrayOutputStream();
                    message.writeTo(bout);
                    child.setResponseData(bout.toByteArray()); // Save raw message
                    child.setDataType(SampleResult.TEXT);
                    child.setDataEncoding("iso-8859-1"); // RFC 822 uses ascii
                    child.setEncodingAndType(contentType);// Parse the content-type
                } else {
                    child.setEncodingAndType(contentType);// Parse the content-type
                    @SuppressWarnings("unchecked") // Javadoc for the API says this is OK
                    Enumeration<Header> hdrs = message.getAllHeaders();
                    while(hdrs.hasMoreElements()){
                        Header hdr = hdrs.nextElement();
                        String value = hdr.getValue();
                        try {
                            value = MimeUtility.decodeText(value);
                        } catch (UnsupportedEncodingException uce) {
                            // ignored
                        }
                        cdata.append(hdr.getName()).append(": ").append(value).append("\n");
                    }
                    child.setResponseHeaders(cdata.toString());
                    cdata.setLength(0);
                    appendMessageData(child, message);
                }

                if (deleteMessages) {
                    message.setFlag(Flags.Flag.DELETED, true);
                }
                child.setResponseOK();
                child.sampleEnd();
                parent.addSubResult(child);
            }

            // Close connection
            folder.close(true);
            store.close();

            parent.setResponseCodeOK();
            parent.setResponseMessageOK();
            isOK = true;
        } catch (NoClassDefFoundError ex) {
            log.debug("",ex);// No need to log normally, as we set the status
            parent.setResponseCode("500"); // $NON-NLS-1$
            parent.setResponseMessage(ex.toString());
        } catch (MessagingException ex) {
            log.debug("", ex);// No need to log normally, as we set the status
            parent.setResponseCode("500"); // $NON-NLS-1$
            parent.setResponseMessage(ex.toString());
        } catch (IOException ex) {
            log.debug("", ex);// No need to log normally, as we set the status
            parent.setResponseCode("500"); // $NON-NLS-1$
            parent.setResponseMessage(ex.toString());
        }

        if (parent.getEndTime()==0){// not been set by any child samples
            parent.sampleEnd();
        }
        parent.setSuccessful(isOK);
        return parent;
    }
