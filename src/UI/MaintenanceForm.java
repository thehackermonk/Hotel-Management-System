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
import java.awt.Color;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.swing.table.DefaultTableCellHeaderRenderer;

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
     * Set theme of the form
     */
    public void setTheme() {

        this.getContentPane().setBackground(new Color(246, 252, 252));
        addMaintenanceDialog.getContentPane().setBackground(new Color(246,252,252));
        removeMaintenanceDialog.getContentPane().setBackground(new Color(246,252,252));

        titleLabel.setForeground(new Color(45, 58, 84));
        addRoomLabel.setForeground(new Color(45, 58, 84));
        addRoomTypeLabel.setForeground(new Color(45, 58, 84));
        addTypeOfMaintenanceLabel.setForeground(new Color(45, 58, 84));
        removeRoomLabel.setForeground(new Color(45, 58, 84));
        removeTypeLabel.setForeground(new Color(45, 58, 84));
        removeDateLabel.setForeground(new Color(45, 58, 84));
        removeCommentsLabel.setForeground(new Color(45, 58, 84));
        
        roomMaintenanceTable.getTableHeader().setDefaultRenderer(new DefaultTableCellHeaderRenderer() {

            @Override
            public void setOpaque(boolean isOpaque) {
                super.setOpaque(true); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setBackground(Color c) {
                super.setBackground(new Color(45, 58, 84)); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setForeground(Color c) {
                super.setForeground(new Color(255, 255, 255)); //To change body of generated methods, choose Tools | Templates.
            }

        });
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
        addRoomLabel = new javax.swing.JLabel();
        addRoomNoCombo = new javax.swing.JComboBox<>();
        addRoomTypeTextField = new javax.swing.JTextField();
        addTypeOfMaintenanceCombo = new javax.swing.JComboBox<>();
        addRoomTypeLabel = new javax.swing.JLabel();
        addTypeOfMaintenanceLabel = new javax.swing.JLabel();
        addRoomForMaintenanceButton = new javax.swing.JButton();
        removeMaintenanceDialog = new javax.swing.JDialog();
        removeRoomLabel = new javax.swing.JLabel();
        removeRoomNoCombo = new javax.swing.JComboBox<>();
        removeMaintenanceTypeTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        removeCommentTextArea = new javax.swing.JTextArea();
        removeTypeLabel = new javax.swing.JLabel();
        removeCommentsLabel = new javax.swing.JLabel();
        removeCompleteMaintenance = new javax.swing.JButton();
        removeDateTextField = new javax.swing.JTextField();
        removeDateLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomMaintenanceTable = new javax.swing.JTable();
        moveRoomButton = new javax.swing.JButton();
        completeMaintenanceButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        addRoomLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addRoomLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        addRoomLabel.setText("Room No");

        addRoomNoCombo.setBackground(new java.awt.Color(246, 252, 252));
        addRoomNoCombo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addRoomNoCombo.setForeground(new java.awt.Color(45, 58, 84));
        addRoomNoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addRoomNoCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                addRoomNoComboFocusLost(evt);
            }
        });

        addRoomTypeTextField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addRoomTypeTextField.setText("jTextField1");
        addRoomTypeTextField.setDisabledTextColor(new java.awt.Color(108, 160, 209));

        addTypeOfMaintenanceCombo.setBackground(new java.awt.Color(246, 252, 252));
        addTypeOfMaintenanceCombo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addTypeOfMaintenanceCombo.setForeground(new java.awt.Color(45, 58, 84));
        addTypeOfMaintenanceCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addRoomTypeLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addRoomTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        addRoomTypeLabel.setText("Room Type");

        addTypeOfMaintenanceLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addTypeOfMaintenanceLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        addTypeOfMaintenanceLabel.setText("Type of Maintenance");

        addRoomForMaintenanceButton.setBackground(new java.awt.Color(108, 160, 209));
        addRoomForMaintenanceButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        addRoomForMaintenanceButton.setForeground(new java.awt.Color(255, 255, 255));
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
                .addGap(321, 321, 321)
                .addComponent(addRoomForMaintenanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(244, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addMaintenanceDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addRoomLabel)
                    .addComponent(addRoomTypeLabel)
                    .addComponent(addTypeOfMaintenanceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addTypeOfMaintenanceCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addRoomNoCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addRoomTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(221, 221, 221))
        );
        addMaintenanceDialogLayout.setVerticalGroup(
            addMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addMaintenanceDialogLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addGroup(addMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRoomLabel)
                    .addComponent(addRoomNoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRoomTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addRoomTypeLabel))
                .addGap(18, 18, 18)
                .addGroup(addMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTypeOfMaintenanceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTypeOfMaintenanceLabel))
                .addGap(40, 40, 40)
                .addComponent(addRoomForMaintenanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        removeRoomLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        removeRoomLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        removeRoomLabel.setText("Room No");

        removeRoomNoCombo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        removeRoomNoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        removeRoomNoCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                removeRoomNoComboFocusLost(evt);
            }
        });

        removeMaintenanceTypeTextField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        removeMaintenanceTypeTextField.setText("jTextField1");

        removeCommentTextArea.setColumns(20);
        removeCommentTextArea.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        removeCommentTextArea.setLineWrap(true);
        removeCommentTextArea.setRows(5);
        removeCommentTextArea.setTabSize(6);
        removeCommentTextArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(removeCommentTextArea);

        removeTypeLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        removeTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        removeTypeLabel.setText("Type of Maintenance");

        removeCommentsLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        removeCommentsLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        removeCommentsLabel.setText("Comments");

        removeCompleteMaintenance.setBackground(new java.awt.Color(108, 160, 209));
        removeCompleteMaintenance.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        removeCompleteMaintenance.setForeground(new java.awt.Color(255, 255, 255));
        removeCompleteMaintenance.setText("Complete Maintenance");
        removeCompleteMaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCompleteMaintenanceActionPerformed(evt);
            }
        });

        removeDateTextField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        removeDateTextField.setText("jTextField1");

        removeDateLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        removeDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        removeDateLabel.setText("Date of Maintenance");

        javax.swing.GroupLayout removeMaintenanceDialogLayout = new javax.swing.GroupLayout(removeMaintenanceDialog.getContentPane());
        removeMaintenanceDialog.getContentPane().setLayout(removeMaintenanceDialogLayout);
        removeMaintenanceDialogLayout.setHorizontalGroup(
            removeMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, removeMaintenanceDialogLayout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addComponent(removeCompleteMaintenance)
                .addGap(303, 303, 303))
            .addGroup(removeMaintenanceDialogLayout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addGroup(removeMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(removeRoomLabel)
                    .addComponent(removeTypeLabel)
                    .addComponent(removeCommentsLabel)
                    .addComponent(removeDateLabel))
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
                    .addComponent(removeRoomLabel))
                .addGap(18, 18, 18)
                .addGroup(removeMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeMaintenanceTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeTypeLabel))
                .addGap(18, 18, 18)
                .addGroup(removeMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeDateLabel))
                .addGap(18, 18, 18)
                .addGroup(removeMaintenanceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeCommentsLabel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(removeCompleteMaintenance)
                .addGap(80, 80, 80))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        roomMaintenanceTable.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
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

        moveRoomButton.setBackground(new java.awt.Color(108, 160, 209));
        moveRoomButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        moveRoomButton.setForeground(new java.awt.Color(255, 255, 255));
        moveRoomButton.setText("MOVE ROOM TO MAINTENANCE");
        moveRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveRoomButtonActionPerformed(evt);
            }
        });

        completeMaintenanceButton.setBackground(new java.awt.Color(108, 160, 209));
        completeMaintenanceButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        completeMaintenanceButton.setForeground(new java.awt.Color(255, 255, 255));
        completeMaintenanceButton.setText("COMPLETE MAINTENANCE");
        completeMaintenanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeMaintenanceButtonActionPerformed(evt);
            }
        });

        closeButton.setBackground(new java.awt.Color(255, 0, 0));
        closeButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        closeButton.setForeground(new java.awt.Color(255, 255, 255));
        closeButton.setText("X");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        titleLabel.setText("Maintenance");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(moveRoomButton)
                        .addGap(200, 200, 200)
                        .addComponent(completeMaintenanceButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(617, 617, 617)
                .addComponent(titleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1066, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(titleLabel)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moveRoomButton)
                    .addComponent(completeMaintenanceButton))
                .addGap(75, 75, 75))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

        setTheme();
        
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
        /*try {
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
        }*/
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
    private javax.swing.JLabel addRoomLabel;
    private javax.swing.JComboBox<String> addRoomNoCombo;
    private javax.swing.JLabel addRoomTypeLabel;
    private javax.swing.JTextField addRoomTypeTextField;
    private javax.swing.JComboBox<String> addTypeOfMaintenanceCombo;
    private javax.swing.JLabel addTypeOfMaintenanceLabel;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton completeMaintenanceButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton moveRoomButton;
    private javax.swing.JTextArea removeCommentTextArea;
    private javax.swing.JLabel removeCommentsLabel;
    private javax.swing.JButton removeCompleteMaintenance;
    private javax.swing.JLabel removeDateLabel;
    private javax.swing.JTextField removeDateTextField;
    private javax.swing.JDialog removeMaintenanceDialog;
    private javax.swing.JTextField removeMaintenanceTypeTextField;
    private javax.swing.JLabel removeRoomLabel;
    private javax.swing.JComboBox<String> removeRoomNoCombo;
    private javax.swing.JLabel removeTypeLabel;
    private javax.swing.JTable roomMaintenanceTable;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
