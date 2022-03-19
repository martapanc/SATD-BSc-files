File path: src/functions/org/apache/jmeter/functions/SamplerName.java
Comment: ould this method be synchronized ? all other function execute are
Initial commit id: 1a3195d8d
Final commit id: 63c750cac
   Bugs between [       3]:
63c750cac Bug 57114 - Performance : Functions that only have values as instance variable should not synchronize execute Remove old TODO Bugzilla Id: 57114
f03a8bdbe Bug 57114 - Performance : Functions that only have values as instance variable should not synchronize execute Bugzilla Id: 57114
ea92414e2 Bug 54199 - Move to Java 6 add @Override Bugzilla Id: 54199
   Bugs after [       0]:


Start block index: 45
End block index: 48
    private Object[] values;

    // TODO Should this method be synchronized ? all other function execute are
    /** {@inheritDoc} */
