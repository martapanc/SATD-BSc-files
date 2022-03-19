File path: src/protocol/ldap/org/apache/jmeter/protocol/ldap/sampler/LdapClient.java
Comment: //TODO perhaps return this?
Initial commit id: ff6a94c7e
Final commit id: eb69c5eb8
   Bugs between [       1]:
dd30d6171 Bug 57193: Add param and return tags to javadoc Bugzilla Id: 57193
   Bugs after [       1]:
66cc6bc13 Bug 60564 - Migrating LogKit to SLF4J - Replace logkit loggers with slf4j ones with keeping the current logkit binding solution

Start block index: 132
End block index: 135
	public void createTest(BasicAttributes basicattributes, String string) throws NamingException {
		// DirContext dc = //TODO perhaps return this?
		dirContext.createSubcontext(string, basicattributes);
	}
