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

package org.apache.jmeter.gui.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

import org.apache.jmeter.exceptions.IllegalUserActionException;
import org.apache.jmeter.gui.GuiPackage;
import org.apache.jmeter.gui.tree.JMeterTreeNode;
import org.apache.jmeter.gui.util.FileDialoger;
import org.apache.jmeter.gui.util.FocusRequester;
import org.apache.jmeter.gui.util.MenuFactory;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.services.FileServer;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.testelement.WorkBench;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.jorphan.util.JOrphanUtils;
import org.apache.log.Logger;

import com.thoughtworks.xstream.converters.ConversionException;

/**
 * Handles the Open (load a new file) and Merge commands.
 *
 */
public class Load implements Command {
    private static final Logger log = LoggingManager.getLoggerForClass();

    private static final boolean expandTree = JMeterUtils.getPropDefault("onload.expandtree", false); //$NON-NLS-1$

    private static final Set<String> commands = new HashSet<String>();

    static {
        commands.add(ActionNames.OPEN);
        commands.add(ActionNames.MERGE);
    }

    public Load() {
        super();
    }

    @Override
    public Set<String> getActionNames() {
        return commands;
    }

    @Override
    public void doAction(final ActionEvent e) {
        final JFileChooser chooser = FileDialoger.promptToOpenFile(new String[] { ".jmx" }); //$NON-NLS-1$
        if (chooser == null) {
            return;
        }
        final File selectedFile = chooser.getSelectedFile();
        if(selectedFile != null) {
            final boolean merging = e.getActionCommand().equals(ActionNames.MERGE);
            // We must ask the user if it is ok to close current project
            if(!merging) { // i.e. it is OPEN
                if (!Close.performAction(e)) {
                    return;
                }
            }
            loadProjectFile(e, selectedFile, merging);
        }
    }

    /**
     * Loads or merges a file into the current GUI, reporting any errors to the user.
     * If the file is a complete test plan, sets the GUI test plan file name
     *
     * @param e the event that triggered the action
     * @param f the file to load
     * @param merging if true, then try to merge the file into the current GUI.
     */
    static void loadProjectFile(final ActionEvent e, final File f, final boolean merging) {
        ActionRouter.getInstance().doActionNow(new ActionEvent(e.getSource(), e.getID(), ActionNames.STOP_THREAD));

        final GuiPackage guiPackage = GuiPackage.getInstance();
        if (f != null) {
            InputStream reader = null;
            try {
                    if (merging) {
                        log.info("Merging file: " + f);
                    } else {
                        log.info("Loading file: " + f);
                        // TODO should this be done even if not a full test plan?
                        // and what if load fails?
                        FileServer.getFileServer().setBaseForScript(f);
                    }
                    reader = new FileInputStream(f);
                    final HashTree tree = SaveService.loadTree(reader);
                    final boolean isTestPlan = insertLoadedTree(e.getID(), tree, merging);
    
                    // don't change name if merging
                    if (!merging && isTestPlan) {
                        // TODO should setBaseForScript be called here rather than above?
                        guiPackage.setTestPlanFile(f.getAbsolutePath());
                    }
            } catch (NoClassDefFoundError ex) {// Allow for missing optional jars
                reportError("Missing jar file", ex, true);
            } catch (ConversionException ex) {
                log.warn("Could not convert file "+ex);
                JMeterUtils.reportErrorToUser(SaveService.CEtoString(ex));
            } catch (IOException ex) {
                reportError("Error reading file: ", ex, false);
            } catch (Exception ex) {
                reportError("Unexpected error", ex, true);
            } finally {
                JOrphanUtils.closeQuietly(reader);
            }
            guiPackage.updateCurrentGui();
            guiPackage.getMainFrame().repaint();
        }
    }

    /**
     * Inserts (or merges) the tree into the GUI.
     * Does not check if the previous tree has been saved.
     * Clears the existing GUI test plan if we are inserting a complete plan.
     * @param id the id for the ActionEvent that is created
     * @param tree the tree to load
     * @param merging true if the tree is to be merged; false if it is to replace the existing tree
     * @return true if the loaded tree was a full test plan
     * @throws IllegalUserActionException if the tree cannot be merged at the selected position or the tree is empty
     */
    // Does not appear to be used externally; called by #loadProjectFile()
    public static boolean insertLoadedTree(final int id, final HashTree tree, final boolean merging) throws IllegalUserActionException {
        // convertTree(tree);
        if (tree == null) {
            throw new IllegalUserActionException("Empty TestPlan - see log file");
        }
        final boolean isTestPlan = tree.getArray()[0] instanceof TestPlan;

        // If we are loading a new test plan, initialize the tree with the testplan node we are loading
        final GuiPackage guiInstance = GuiPackage.getInstance();
        if(isTestPlan && !merging) {
            // Why does this not call guiInstance.clearTestPlan() ?
            // Is there a reason for not clearing everything?
            guiInstance.clearTestPlan((TestElement)tree.getArray()[0]);
        }

        if (merging){ // Check if target of merge is reasonable
            final TestElement te = (TestElement)tree.getArray()[0];
            if (!(te instanceof WorkBench || te instanceof TestPlan)){// These are handled specially by addToTree
                final boolean ok = MenuFactory.canAddTo(guiInstance.getCurrentNode(), te);
                if (!ok){
                    String name = te.getName();
                    String className = te.getClass().getName();
                    className = className.substring(className.lastIndexOf('.')+1);
                    throw new IllegalUserActionException("Can't merge "+name+" ("+className+") here");
                }
            }
        }
        final HashTree newTree = guiInstance.addSubTree(tree);
        guiInstance.updateCurrentGui();
        guiInstance.getMainFrame().getTree().setSelectionPath(
                new TreePath(((JMeterTreeNode) newTree.getArray()[0]).getPath()));
        final HashTree subTree = guiInstance.getCurrentSubTree();
        // Send different event wether we are merging a test plan into another test plan,
        // or loading a testplan from scratch
        ActionEvent actionEvent =
            new ActionEvent(subTree.get(subTree.getArray()[subTree.size() - 1]), id, 
                    merging ? ActionNames.SUB_TREE_MERGED : ActionNames.SUB_TREE_LOADED);

        ActionRouter.getInstance().actionPerformed(actionEvent);
        final JTree jTree = guiInstance.getMainFrame().getTree();
        if (expandTree && !merging) { // don't automatically expand when merging
            for(int i = 0; i < jTree.getRowCount(); i++) {
                jTree.expandRow(i);
            }
        } else {
            jTree.expandRow(0);
        }
        jTree.setSelectionPath(jTree.getPathForRow(1));
        FocusRequester.requestFocus(jTree);
        return isTestPlan;
    }

    /**
     * Inserts the tree into the GUI.
     * Does not check if the previous tree has been saved.
     * Clears the existing GUI test plan if we are inserting a complete plan.
     * @param id the id for the ActionEvent that is created
     * @param tree the tree to load
     * @return true if the loaded tree was a full test plan
     * @throws IllegalUserActionException if the tree cannot be merged at the selected position or the tree is empty
     */
    // Called by JMeter#startGui()
    public static boolean insertLoadedTree(final int id, final HashTree tree) throws IllegalUserActionException {
        return insertLoadedTree(id, tree, false);
    }

    // Helper method to simplify code
    private static void reportError(final String reason, final Throwable ex, final boolean stackTrace) {
        if (stackTrace) {
            log.warn(reason, ex);
        } else {
            log.warn(reason + ex);
        }
        String msg = ex.getMessage();
        if (msg == null) {
            msg = "Unexpected error - see log for details";
        }
        JMeterUtils.reportErrorToUser(msg);
    }

}
