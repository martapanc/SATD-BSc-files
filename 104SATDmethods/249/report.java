File path: src/protocol/http/org/apache/jmeter/protocol/http/config/gui/UrlConfigGui.java
Comment: Does not appear to be used
Initial commit id: e8003f7d
Final commit id: da6679b6
   Bugs between [       0]:

   Bugs after [      17]:
2c182abb1 Bug 60543 - HTTP Request / Http Request Defaults UX: Move to advanced panel Timeouts, Implementation, Proxy Bugzilla Id: 60543
564705a40 Bug 59060 - HTTP Request GUI : Move File Upload to a new Tab to have more space for parameters and prevent incoherent configuration Contributed by Benoit Wiart #resolve #140 https://github.com/apache/jmeter/pull/140 Bugzilla Id: 59060
3282578e5 Bug 59044 - Http Sampler : It should not be possible to select the multipart encoding if the method is not POST #resolve #138 https://github.com/apache/jmeter/pull/138 Patch by Benoit Wiart Bugzilla Id: 59044
5be9daa8a Bug 57193: Add param and return tags to javadoc Bugzilla Id: 57193
ee0c987ff Bug 57193: Add param and return tags to javadoc Bugzilla Id: 57193
0d45f17f0 Bug 57193: Escape entities like &, < and >, as they are not  allowed in javadocs. Place code tag around code-fragments in javadoc. Bugzilla Id: 57193
2ed95f964 Bug 55606 - Use JSyntaxtTextArea for Http Request, JMS Test Elements Reverting crappy code Bugzilla Id: 55606
22bc84d79 Bug 55606 - Use JSyntaxtTextArea for Http Request, JMS Test Elements Fix test case failure in Headless mode Bugzilla Id: 55606
832fa54b7 Bug 55606 - Use JSyntaxtTextArea for Http Request, JMS Test Elements Bugzilla Id: 55606
f459b3345 Reduce the element screen width for HTTP Request Related with Bug 54874
472da1514 Bug 53765 - Switch to commons-lang3-3.1 Bugzilla Id: 53765
ddc3bf4da Bug 52613 - Using Raw Post Body option, text is considered as encoded
dcf739f02 Bug 51861 - Improve HTTP Request GUI to better show parameters without name (GWT RPC requests for example) Fix up code so CRLF is sent after each line.
4b9cb415a Bug 51861 - Improve HTTP Request GUI to better show parameters without name (GWT RPC requests for example)
592bf6b72 Bug 50684 - Optionally disable Content-Type and Transfer-Encoding in Multipart POST
76ac18a73 Bug 27780 - (patch 19936) create multipart/form-data HTTP request without uploading file
90684a56d Bug 41705 - add content-encoding option to HTTP samplers

Start block index: 121
End block index: 136
// Does not appear to be used
//    public void configureSampler(HTTPSampler sampler)
//    {
//        sampler.setArguments((Arguments) argsPanel.createTestElement());
//        sampler.setDomain(domain.getText());
//        sampler.setProtocol(protocol.getText());
//        sampler.setPath(path.getText());
//        sampler.setFollowRedirects(followRedirects.isSelected());
//        sampler.setDelegateRedirects(autoRedirects.isSelected());
//        sampler.setUseKeepAlive(useKeepAlive.isSelected());
//        if (port.getText().length() > 0)
//        {
//            sampler.setPort(Integer.parseInt(port.getText()));
//        }
//        sampler.setMethod((post.isSelected() ? "POST" : "GET"));
//    }
