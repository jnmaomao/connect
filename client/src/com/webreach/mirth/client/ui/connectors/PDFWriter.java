/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is Mirth.
 *
 * The Initial Developer of the Original Code is
 * WebReach, Inc.
 * Portions created by the Initial Developer are Copyright (C) 2006
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *   Gerald Bortis <geraldb@webreachinc.com>
 *
 * ***** END LICENSE BLOCK ***** */


package com.webreach.mirth.client.ui.connectors;

import java.util.Properties;

import com.webreach.mirth.client.ui.Frame;
import com.webreach.mirth.client.ui.PlatformUI;
import com.webreach.mirth.client.ui.UIConstants;

/**
 * A form that extends from ConnectorClass.  All methods implemented
 * are described in ConnectorClass.
 */
public class PDFWriter extends ConnectorClass
{
    Frame parent;

    /** Creates new form PDFWriter */
    public final String DATATYPE = "DataType";
    public final String FILE_DIRECTORY = "host";
    public final String FILE_NAME = "outputPattern";
    public final String PDF_PASSWORD_PROTECTED = "encrypt";
    public final String PDF_PASSWORD = "password";
    public final String FILE_CONTENTS = "template";

    public PDFWriter()
    {
        this.parent = PlatformUI.MIRTH_FRAME;
        name = "PDF Writer";
        initComponents();
    }

    public Properties getProperties()
    {
        Properties properties = new Properties();
        properties.put(DATATYPE, name);
        properties.put(FILE_DIRECTORY, directoryField.getText().replace('\\', '/'));
        properties.put(FILE_NAME, fileNameField.getText());
        
        if (passwordYes.isSelected())
            properties.put(PDF_PASSWORD_PROTECTED, UIConstants.YES_OPTION);
        else
            properties.put(PDF_PASSWORD_PROTECTED, UIConstants.NO_OPTION);
        
        properties.put(PDF_PASSWORD, new String(passwordField.getPassword()));
        properties.put(FILE_CONTENTS, fileContentsTextPane.getText());
        
        return properties;
    }

    public void setProperties(Properties props)
    {
        directoryField.setText((String)props.get(FILE_DIRECTORY));
        fileNameField.setText((String)props.get(FILE_NAME));
        
        if(((String)props.get(PDF_PASSWORD_PROTECTED)).equalsIgnoreCase(UIConstants.YES_OPTION))
        {
            passwordYes.setSelected(true);
            passwordYesActionPerformed(null);
        }
        else
        {
            passwordNo.setSelected(true);
            passwordNoActionPerformed(null);
        }
        
        passwordField.setText((String)props.get(PDF_PASSWORD));

        fileContentsTextPane.setText((String)props.get(FILE_CONTENTS));
    }

    public Properties getDefaults()
    {
        Properties properties = new Properties();
        properties.put(DATATYPE, name);
        properties.put(FILE_DIRECTORY, "");
        properties.put(FILE_NAME, "");
        properties.put(PDF_PASSWORD_PROTECTED, UIConstants.NO_OPTION);
        properties.put(PDF_PASSWORD, "");
        properties.put(FILE_CONTENTS, "");
        return properties;
    }
    
    public boolean checkProperties(Properties props)
    {
        if (((String)props.get(PDF_PASSWORD_PROTECTED)).equals(UIConstants.YES_OPTION))
        {
            if(((String)props.get(FILE_DIRECTORY)).length() > 0 && ((String)props.get(FILE_NAME)).length() > 0
                    && ((String)props.get(PDF_PASSWORD)).length() > 0 && ((String)props.get(FILE_CONTENTS)).length() > 0)
                return true;
        }
        else
        {
            if(((String)props.get(FILE_DIRECTORY)).length() > 0 && ((String)props.get(FILE_NAME)).length() > 0 && ((String)props.get(FILE_CONTENTS)).length() > 0)
                return true;
        }
        return false;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        directoryField = new com.webreach.mirth.client.ui.components.MirthTextField();
        fileNameField = new com.webreach.mirth.client.ui.components.MirthTextField();
        passwordYes = new com.webreach.mirth.client.ui.components.MirthRadioButton();
        passwordNo = new com.webreach.mirth.client.ui.components.MirthRadioButton();
        jLabel4 = new javax.swing.JLabel();
        passwordField = new com.webreach.mirth.client.ui.components.MirthPasswordField();
        passwordLabel = new javax.swing.JLabel();
        fileContentsTextPane = new com.webreach.mirth.client.ui.components.MirthSyntaxTextArea(false,false);

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PDF Writer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        jLabel1.setText("Directory:");

        jLabel2.setText("File Name:");

        jLabel3.setText("Template:");

        passwordYes.setBackground(new java.awt.Color(255, 255, 255));
        passwordYes.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonGroup1.add(passwordYes);
        passwordYes.setText("Yes");
        passwordYes.setMargin(new java.awt.Insets(0, 0, 0, 0));
        passwordYes.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                passwordYesActionPerformed(evt);
            }
        });

        passwordNo.setBackground(new java.awt.Color(255, 255, 255));
        passwordNo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonGroup1.add(passwordNo);
        passwordNo.setText("No");
        passwordNo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        passwordNo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                passwordNoActionPerformed(evt);
            }
        });

        jLabel4.setText("Encrypted:");

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 11));

        passwordLabel.setText("Password:");

        fileContentsTextPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel2)
                    .add(jLabel1)
                    .add(jLabel4)
                    .add(passwordLabel)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(directoryField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(fileNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(passwordYes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(passwordNo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(passwordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(fileContentsTextPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(directoryField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(fileNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(passwordYes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(passwordNo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(passwordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(passwordLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(fileContentsTextPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void passwordNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordNoActionPerformed
        passwordLabel.setEnabled(false);
        passwordField.setEnabled(false);
    }//GEN-LAST:event_passwordNoActionPerformed

    private void passwordYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordYesActionPerformed
        passwordLabel.setEnabled(true);
        passwordField.setEnabled(true);
    }//GEN-LAST:event_passwordYesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private com.webreach.mirth.client.ui.components.MirthTextField directoryField;
    private com.webreach.mirth.client.ui.components.MirthSyntaxTextArea fileContentsTextPane;
    private com.webreach.mirth.client.ui.components.MirthTextField fileNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private com.webreach.mirth.client.ui.components.MirthPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private com.webreach.mirth.client.ui.components.MirthRadioButton passwordNo;
    private com.webreach.mirth.client.ui.components.MirthRadioButton passwordYes;
    // End of variables declaration//GEN-END:variables

}
