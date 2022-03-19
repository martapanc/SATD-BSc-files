File path: src/core/org/apache/jmeter/gui/action/EditCommand.java
Comment: // TODO: I believe the following code (to the end of the method) is
Initial commit id: faf5bc052
Final commit id: 1139c450e
   Bugs between [       0]:

   Bugs after [       0]:


Start block index: 42
End block index: 57
    public void doAction(ActionEvent e) {
        GuiPackage guiPackage = GuiPackage.getInstance();
        JMeterGUIComponent currentGui = guiPackage.getCurrentGui();
        guiPackage.getMainFrame().setMainPanel((javax.swing.JComponent) currentGui);
        guiPackage.getMainFrame().setEditMenu(guiPackage.getTreeListener().getCurrentNode().createPopupMenu());
        // TODO: I believe the following code (to the end of the method) is
        // obsolete,
        // since NamePanel no longer seems to be the GUI for any component:
        if (!(currentGui instanceof NamePanel)) {
            guiPackage.getMainFrame().setFileLoadEnabled(true);
            guiPackage.getMainFrame().setFileSaveEnabled(true);
        } else {
            guiPackage.getMainFrame().setFileLoadEnabled(false);
            guiPackage.getMainFrame().setFileSaveEnabled(false);
        }
    }
