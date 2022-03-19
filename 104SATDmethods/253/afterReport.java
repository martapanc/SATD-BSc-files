/253/report.java
Satd-method: public JMeterTreeNode(){// Allow serializable test to work
********************************************
********************************************
/253/After/Bug 51876  3dd627dc_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
public 
+public interface Searchable {
+    public static final String SEARCH_TREE      = "search_tree"; // $NON-NLS-1$
+public class SearchTreeCommand extends AbstractAction {
+    public void doAction(ActionEvent e) {
+    public Set<String> getActionNames() {
+    public void setMarkedBySearch(boolean tagged) {
+    public boolean isMarkedBySearch() {
+    public boolean searchContent(String textToSearch) throws Exception {

Lines added containing method: 8. Lines removed containing method: 0. Tot = 8
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
********************************************
********************************************
/253/After/Bug 51876  6572ccd2_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
public 
+    public boolean searchContent(String textToSearch) throws Exception {
-     public boolean searchContent(String textToSearch) throws Exception {
-public class RegexExtractor extends AbstractScopedTestElement implements PostProcessor, Serializable, Searchable {
+public class RegexExtractor extends AbstractScopedTestElement implements PostProcessor, Serializable {
-public class TransactionController extends GenericController implements SampleListener, Controller, Serializable, Searchable {
+public class TransactionController extends GenericController implements SampleListener, Controller, Serializable {
-    public boolean searchContent(String textToSearch) throws Exception {
+    public boolean searchContent(String textToSearch) throws Exception {
-public abstract class AbstractTestElement implements TestElement, Serializable {
+public abstract class AbstractTestElement implements TestElement, Serializable, Searchable {
+    public boolean searchContent(String textToSearch) throws Exception {
+    public boolean searchContent(String textToSearch) throws Exception {

Lines added containing method: 7. Lines removed containing method: 5. Tot = 12
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
********************************************
********************************************
/253/After/Bug 51876  c84b8bca_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
public 
+    public List<JMeterTreeNode> getPathToThreadGroup() {

Lines added containing method: 1. Lines removed containing method: 0. Tot = 1
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
********************************************
********************************************
/253/After/Bug 54648  1372fcf4_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
public 

Lines added containing method: 0. Lines removed containing method: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
********************************************
********************************************
/253/After/Bug 54648  4f697f78_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
public 

Lines added containing method: 0. Lines removed containing method: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
********************************************
********************************************
/253/After/Bug 54648  9d8dc678_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
public 

Lines added containing method: 0. Lines removed containing method: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
********************************************
********************************************
/253/After/Bug 57193: 80e99eb8_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
public 

Lines added containing method: 0. Lines removed containing method: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
********************************************
********************************************
/253/After/Bug 57193: 8cf39ed8_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
public 

Lines added containing method: 0. Lines removed containing method: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
********************************************
********************************************
/253/After/Bug 60564  2ee6bd97_diff.java
————————————————————————————————————————————————
*** Lines Changed in Satd-Method: ***


Lines added: 0. Lines removed: 0. Tot = 0
————————————————————————————————————————————————
*** Changed calls OF Satd-Method in Diff: ***
public 
-    public void setEnabled(boolean e) {
+    public void setEnabled(boolean enabled) {

Lines added containing method: 1. Lines removed containing method: 1. Tot = 2
————————————————————————————————————————————————
*** Changed calls of methods FROM Satd-Method in Diff: ***
Method calls found: 
********************************************
********************************************
