/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Bean.Credential;
import Logic.Authentication;
import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author thehackermonk
 */
public class PasswordChangeForm extends javax.swing.JFrame {

    /**
     * Creates new form PasswordChangeForm
     */
    public PasswordChangeForm() {
        initComponents();
    }
    
    /**
     * Set theme of the form
     */
    public void setTheme() {

        this.getContentPane().setBackground(new Color(246, 252, 252));

        titleLabel.setForeground(new Color(45, 58, 84));
        userIDLabel.setForeground(new Color(45, 58, 84));
        oldPasswordLabel.setForeground(new Color(45, 58, 84));
        newPasswordLabel.setForeground(new Color(45, 58, 84));

    }

    /**
     * To clear the fields
     */
    public void clear() {

        userIDTextField.setText("");
        oldPasswordField.setText("");
        newPasswordField.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userIDLabel = new javax.swing.JLabel();
        userIDTextField = new javax.swing.JTextField();
        oldPasswordLabel = new javax.swing.JLabel();
        newPasswordLabel = new javax.swing.JLabel();
        changePasswordField = new javax.swing.JButton();
        oldPasswordField = new javax.swing.JPasswordField();
        newPasswordField = new javax.swing.JPasswordField();
        closeButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        userIDLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        userIDLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        userIDLabel.setText("User ID");

        userIDTextField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        userIDTextField.setText("jTextField1");

        oldPasswordLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        oldPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        oldPasswordLabel.setText("Old Password");

        newPasswordLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        newPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        newPasswordLabel.setText("New Password");

        changePasswordField.setBackground(new java.awt.Color(108, 160, 209));
        changePasswordField.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        changePasswordField.setForeground(new java.awt.Color(255, 255, 255));
        changePasswordField.setText("CHANGE PASSWORD");
        changePasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordFieldActionPerformed(evt);
            }
        });

        oldPasswordField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        oldPasswordField.setText("jPasswordField1");

        newPasswordField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        newPasswordField.setText("jPasswordField2");

        closeButton.setBackground(new java.awt.Color(255, 0, 0));
        closeButton.setForeground(new java.awt.Color(255, 255, 255));
        closeButton.setText("X");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        titleLabel.setText("Change Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(597, 597, 597)
                .addComponent(titleLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(564, 564, 564)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userIDLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(oldPasswordLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(newPasswordLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(userIDTextField)
                                    .addComponent(oldPasswordField)
                                    .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(changePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)))
                        .addContainerGap(564, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userIDLabel)
                    .addComponent(userIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldPasswordLabel)
                    .addComponent(oldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPasswordLabel)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(changePasswordField)
                .addGap(248, 248, 248))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

        clear();
        userIDTextField.requestFocus();

    }//GEN-LAST:event_formWindowGainedFocus

    private void changePasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordFieldActionPerformed

        Authentication authentication = new Authentication();
        Credential credential = new Credential();

        String newPassword, error = null;

        credential.setUserName(userIDTextField.getText());
        credential.setPassword(Arrays.toString(oldPasswordField.getPassword()));
        newPassword = Arrays.toString(newPasswordField.getPassword());

        try {
            error = authentication.changePassword(credential, newPassword);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordChangeForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (error == null) {
            JOptionPane.showMessageDialog(null, "Password changed successfully!");
        } else {
            
            JOptionPane.showMessageDialog(null, error);
            clear();
            userIDTextField.requestFocus();
            
        }

    }//GEN-LAST:event_changePasswordFieldActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        
        this.setVisible(false);
        new MainMenu().show();
        
    }//GEN-LAST:event_closeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PasswordChangeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordChangeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordChangeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordChangeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasswordChangeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changePasswordField;
    private javax.swing.JButton closeButton;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JLabel newPasswordLabel;
    private javax.swing.JPasswordField oldPasswordField;
    private javax.swing.JLabel oldPasswordLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel userIDLabel;
    private javax.swing.JTextField userIDTextField;
    // End of variables declaration//GEN-END:variables
}
