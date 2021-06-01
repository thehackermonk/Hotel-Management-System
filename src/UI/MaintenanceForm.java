/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Bean.Maintenance;
import Bean.Room;
import DTO.MaintenanceData;
import DTO.RoomsData;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thehackermonk
 */
public class MaintenanceForm extends javax.swing.JFrame {

    /**
     * Creates new form MaintenanceUI
     */
    public MaintenanceForm() {
        initComponents();
    }

    /**
     *
     * Refresh maintenance table
     */
    public void refreshMaintenanceTable() {

        MaintenanceData maintenanceData = new MaintenanceData();

        DefaultTableModel maintenanceTable = (DefaultTableModel) roomMaintenanceTable.getModel();

        ArrayList<Maintenance> maintenanceList = maintenanceData.getAllRoomsUnderMaintenance();
        Iterator<Maintenance> maintenanceListIterator = maintenanceList.iterator();

        while (maintenanceTable.getRowCount() > 0) {

            maintenanceTable.removeRow(0);

        }

        while (maintenanceListIterator.hasNext()) {

            Maintenance maintenance = maintenanceListIterator.next();

            int roomNo = maintenance.getRoomNo();
            String roomType = maintenance.getType();
            String maintenanceType = maintenance.getMaintenanceType();
            Date dateOfMaintenance = maintenance.getMaintenanceDate();

            maintenanceTable.addRow(new Object[]{roomNo, roomType, maintenanceType, dateOfMaintenance});

        }

    }

    /**
     * Get room no which are not under maintenance
     *
     * @param comboBoxModel
     */
    public void refreshRoomNotUnderMaintenanceCombo(DefaultComboBoxModel comboBoxModel) {

        RoomsData roomsData = new RoomsData();

        comboBoxModel.removeAllElements();

        ArrayList<Room> roomList = roomsData.getRoomNotUnderMaintenance();
        Iterator<Room> roomListIterator = roomList.iterator();

        while (roomListIterator.hasNext()) {

            Room room = roomListIterator.next();
            comboBoxModel.addElement(room.getRoomNo());

        }

    }

    /**
     * Get room no which are under maintenance
     *
     * @param comboBoxModel
     */
    public void refreshRoomUnderMaintenanceCombo(DefaultComboBoxModel comboBoxModel) {

        RoomsData roomsData = new RoomsData();

        comboBoxModel.removeAllElements();

        ArrayList<Room> roomList = roomsData.getRoomUnderMaintenance();
        Iterator<Room> roomListIterator = roomList.iterator();

        while (roomListIterator.hasNext()) {

            Room room = roomListIterator.next();
            comboBoxModel.addElement(room.getRoomNo());

        }

    }

    /**
     * Add type of maintenance
     *
     * @param comboBoxModel
     */
    public void refreshTypeOfMaintenanceCombo(DefaultComboBoxModel comboBoxModel) {

        comboBoxModel.removeAllElements();

        comboBoxModel.addElement("Routine Maintenance");
        comboBoxModel.addElement("Electricity Maintenance");
        comboBoxModel.addElement("Plumbing Maintenance");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMaintenanceDialog = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        addRoomNoCombo = new javax.swing.JComboBox<>();
        addRoomTypeTextField = new javax.swing.JTextField();
        addTypeOfMaintenanceCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addRoomForMaintenanceButton = new javax.swing.JButton();
        removeMaintenanceDialog = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        removeRoomNoCombo = new javax.swing.JComboBox<>();
        removeMaintenanceTypeTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        removeCommentTextArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        removeCompleteMaintenance = new javax.swing.JButton();
        removeDateTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomMaintenanceTable = new javax.swing.JTable();
        moveRoomButton = new javax.swing.JButton();
        completeMaintenanceButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Room No");

        addRoomNoCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addRoomNoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addRoomNoCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                addRoomNoComboFocusLost(evt);
            }
        });

        addRoomTypeTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addRoomTypeTextField.setText("jTextField1");

        addTypeOfMaintenanceCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addTypeOfMaintenanceCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Room Type");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Type of Maintenance");

        addRoomForMaintenanceButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addRoomForMaintenanceButton.setText("Add Room for Maintenance");
        addRoomForMaintenanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomForMaintenanceButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addMaintenanceDialogLayout = new javax.swing.GroupLayout(addMaintenanceDialog.getContentPane());
        addMaintenanceDialog.getContentPane().setLayout(addMaintenanceDialogLayout);
        addMaintenanceDialogLayout.setHorizontalGroup(
            addMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addMaintenanceDialogLayout.createSequentialGroup()
                .addGroup(addMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addMaintenanceDialogLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addGroup(addMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addTypeOfMaintenanceCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addRoomTypeTextField)
                            .addComponent(addRoomNoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addMaintenanceDialogLayout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(addRoomForMaintenanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        addMaintenanceDialogLayout.setVerticalGroup(
            addMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addMaintenanceDialogLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addGroup(addMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(addRoomNoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRoomTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(addMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTypeOfMaintenanceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(40, 40, 40)
                .addComponent(addRoomForMaintenanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Room No");

        removeRoomNoCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        removeRoomNoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        removeRoomNoCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                removeRoomNoComboFocusLost(evt);
            }
        });

        removeMaintenanceTypeTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        removeMaintenanceTypeTextField.setText("jTextField1");

        removeCommentTextArea.setColumns(20);
        removeCommentTextArea.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        removeCommentTextArea.setLineWrap(true);
        removeCommentTextArea.setRows(5);
        removeCommentTextArea.setTabSize(6);
        removeCommentTextArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(removeCommentTextArea);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Type of Maintenance");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Comments");

        removeCompleteMaintenance.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        removeCompleteMaintenance.setText("Complete Maintenance");
        removeCompleteMaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCompleteMaintenanceActionPerformed(evt);
            }
        });

        removeDateTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        removeDateTextField.setText("jTextField1");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Date of Maintenance");

        javax.swing.GroupLayout removeMaintenanceDialogLayout = new javax.swing.GroupLayout(removeMaintenanceDialog.getContentPane());
        removeMaintenanceDialog.getContentPane().setLayout(removeMaintenanceDialogLayout);
        removeMaintenanceDialogLayout.setHorizontalGroup(
            removeMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, removeMaintenanceDialogLayout.createSequentialGroup()
                .addContainerGap(318, Short.MAX_VALUE)
                .addComponent(removeCompleteMaintenance)
                .addGap(316, 316, 316))
            .addGroup(removeMaintenanceDialogLayout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addGroup(removeMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(removeMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(removeDateTextField)
                    .addComponent(removeMaintenanceTypeTextField)
                    .addComponent(removeRoomNoCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        removeMaintenanceDialogLayout.setVerticalGroup(
            removeMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeMaintenanceDialogLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(removeMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeRoomNoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(removeMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeMaintenanceTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(removeMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(removeMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(removeCompleteMaintenance)
                .addGap(86, 86, 86))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        roomMaintenanceTable.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        roomMaintenanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Room No", "Room Type", "Maintenance", "Date of Maintenance"
            }
        ));
        jScrollPane1.setViewportView(roomMaintenanceTable);

        moveRoomButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        moveRoomButton.setText("Move Room to Maintenance");
        moveRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveRoomButtonActionPerformed(evt);
            }
        });

        completeMaintenanceButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        completeMaintenanceButton.setText("Complete Maintenance");
        completeMaintenanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeMaintenanceButtonActionPerformed(evt);
            }
        });

        closeButton.setText("X");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(moveRoomButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(completeMaintenanceButton)))
                .addContainerGap(325, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeButton)
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moveRoomButton)
                    .addComponent(completeMaintenanceButton))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

        refreshMaintenanceTable();

    }//GEN-LAST:event_formWindowGainedFocus

    private void moveRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveRoomButtonActionPerformed

        DefaultComboBoxModel roomNoComboBoxModel = (DefaultComboBoxModel) addRoomNoCombo.getModel();
        DefaultComboBoxModel typeOfMaintenanceComboBoxModel = (DefaultComboBoxModel) addTypeOfMaintenanceCombo.getModel();

        refreshRoomNotUnderMaintenanceCombo(roomNoComboBoxModel);
        refreshTypeOfMaintenanceCombo(typeOfMaintenanceComboBoxModel);

        addRoomTypeTextField.setText("");
        addRoomTypeTextField.setEditable(false);

        addMaintenanceDialog.setSize(800, 500);
        addMaintenanceDialog.show();

    }//GEN-LAST:event_moveRoomButtonActionPerformed

    private void addRoomNoComboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addRoomNoComboFocusLost

        RoomsData roomsData = new RoomsData();
        Room room;

        int roomNo = Integer.parseInt(addRoomNoCombo.getSelectedItem().toString());
        room = roomsData.getRoomDetails(roomNo);

        addRoomTypeTextField.setText(room.getType());

    }//GEN-LAST:event_addRoomNoComboFocusLost

    private void addRoomForMaintenanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomForMaintenanceButtonActionPerformed

        Maintenance maintenance = new Maintenance();
        MaintenanceData maintenanceData = new MaintenanceData();

        maintenance.setRoomNo(Integer.parseInt(addRoomNoCombo.getSelectedItem().toString()));
        maintenance.setMaintenanceType(addTypeOfMaintenanceCombo.getSelectedItem().toString());
        maintenance.setMaintenanceDate(java.sql.Date.valueOf(LocalDateTime.now().toLocalDate()));

        if (maintenanceData.addRoomForMaintenance(maintenance)) {

            JOptionPane.showMessageDialog(null, "Room " + maintenance.getRoomNo() + " moved for maintenance!");
            addMaintenanceDialog.setVisible(false);

        }

    }//GEN-LAST:event_addRoomForMaintenanceButtonActionPerformed

    private void completeMaintenanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeMaintenanceButtonActionPerformed

        DefaultComboBoxModel roomNoComboBoxModel = (DefaultComboBoxModel) removeRoomNoCombo.getModel();
        refreshRoomUnderMaintenanceCombo(roomNoComboBoxModel);

        removeMaintenanceTypeTextField.setText("");
        removeMaintenanceTypeTextField.setEditable(false);

        removeDateTextField.setText("");
        removeDateTextField.setEditable(false);

        removeMaintenanceDialog.setSize(800, 500);
        removeMaintenanceDialog.show();

    }//GEN-LAST:event_completeMaintenanceButtonActionPerformed

    private void removeRoomNoComboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_removeRoomNoComboFocusLost

        MaintenanceData maintenanceData = new MaintenanceData();

        int roomNo = Integer.parseInt(removeRoomNoCombo.getSelectedItem().toString());

        Maintenance maintenance = maintenanceData.getRoomDetails(roomNo);

        removeMaintenanceTypeTextField.setText(maintenance.getMaintenanceType());
        removeDateTextField.setText("" + maintenance.getMaintenanceDate());

    }//GEN-LAST:event_removeRoomNoComboFocusLost

    private void removeCompleteMaintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCompleteMaintenanceActionPerformed

        Maintenance maintenance = new Maintenance();
        MaintenanceData maintenanceData = new MaintenanceData();

        maintenance.setRoomNo(Integer.parseInt(removeRoomNoCombo.getSelectedItem().toString()));
        maintenance.setComments(removeCommentTextArea.getText());

        if (maintenanceData.removeRoomFromMaintenance(maintenance)) {

            JOptionPane.showMessageDialog(null, maintenance.getRoomNo() + " maintenance completed!");
            removeMaintenanceDialog.setVisible(false);

        }

    }//GEN-LAST:event_removeCompleteMaintenanceActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        
        this.setVisible(false);
        new MaintenanceMenu().show();
        
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MaintenanceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaintenanceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaintenanceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaintenanceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaintenanceForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog addMaintenanceDialog;
    private javax.swing.JButton addRoomForMaintenanceButton;
    private javax.swing.JComboBox<String> addRoomNoCombo;
    private javax.swing.JTextField addRoomTypeTextField;
    private javax.swing.JComboBox<String> addTypeOfMaintenanceCombo;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton completeMaintenanceButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton moveRoomButton;
    private javax.swing.JTextArea removeCommentTextArea;
    private javax.swing.JButton removeCompleteMaintenance;
    private javax.swing.JTextField removeDateTextField;
    private javax.swing.JDialog removeMaintenanceDialog;
    private javax.swing.JTextField removeMaintenanceTypeTextField;
    private javax.swing.JComboBox<String> removeRoomNoCombo;
    private javax.swing.JTable roomMaintenanceTable;
    // End of variables declaration//GEN-END:variables
}
