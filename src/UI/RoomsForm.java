/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Bean.Room;
import Bean.RoomType;
import DTO.RoomTypeData;
import DTO.RoomsData;
import java.awt.Color;
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
public class RoomsForm extends javax.swing.JFrame {

    /**
     * Creates new form RoomsUI
     */
    public RoomsForm() {
        initComponents();
    }
    
    /**
     * Set theme of the form
     */
    public void setTheme() {

        this.getContentPane().setBackground(new Color(246, 252, 252));
        addRoomDialog.getContentPane().setBackground(new Color(246, 252, 252));
        editRoomDialog.getContentPane().setBackground(new Color(246, 252, 252));
        removeRoomDialog.getContentPane().setBackground(new Color(246, 252, 252));

        titleLabel.setForeground(new Color(45, 58, 84));
        addRoomNoLabel.setForeground(new Color(45, 58, 84));
        addTypeLabel.setForeground(new Color(45, 58, 84));
        modifyRoomNoLabel.setForeground(new Color(45, 58, 84));
        modifyTypeLabel.setForeground(new Color(45, 58, 84));
        removeRoomNoLabel.setForeground(new Color(45, 58, 84));

        roomTable.getTableHeader().setDefaultRenderer(new DefaultTableCellHeaderRenderer() {

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
     * To display all the rooms details in the table
     *
     */
    public void refreshRoomTable() {

        RoomsData roomsData = new RoomsData();

        DefaultTableModel roomTableModel = (DefaultTableModel) roomTable.getModel();

        while (roomTableModel.getRowCount() > 0) {

            roomTableModel.removeRow(0);

        }

        ArrayList<Room> roomList = roomsData.getAllRoomDetails();
        Iterator<Room> roomListIterator = roomList.iterator();

        while (roomListIterator.hasNext()) {

            Room room = roomListIterator.next();

            int roomNo = room.getRoomNo();
            String type = room.getType();
            String status = room.getRoomStatus();
            String maintenance;

            if (room.isUnderMaintenance()) {
                maintenance = "Yes";
            } else {
                maintenance = "No";
            }

            roomTableModel.addRow(new Object[]{roomNo, type, status, maintenance});

        }

    }

    /**
     * Refresh room no combo box
     *
     * @param comboBoxModel pass combo box
     */
    public void refreshRoomNoComboBox(DefaultComboBoxModel comboBoxModel) {

        RoomsData roomData = new RoomsData();

        ArrayList<Room> roomList = roomData.getAllRoomDetails();
        Iterator<Room> roomListIterator = roomList.iterator();

        comboBoxModel.removeAllElements();

        while (roomListIterator.hasNext()) {

            Room room = roomListIterator.next();
            comboBoxModel.addElement(room.getRoomNo());

        }

    }

    /**
     * Refresh room type combo box
     *
     * @param comboBoxModel pass combo box
     */
    public void refreshRoomTypeComboBox(DefaultComboBoxModel comboBoxModel) {

        RoomTypeData roomTypeData = new RoomTypeData();

        ArrayList<RoomType> roomTypeList = roomTypeData.getAllRoomTypeDetails();
        Iterator<RoomType> roomTypeListIterator = roomTypeList.iterator();

        comboBoxModel.removeAllElements();

        while (roomTypeListIterator.hasNext()) {

            RoomType roomType = roomTypeListIterator.next();

            comboBoxModel.addElement(roomType.getType());

        }

    }

    /**
     * To check if it is a valid room no Room no should not be present already
     *
     * @param roomNo
     * @return true if room no is not present already and false otherwise
     */
    public boolean isValidRoomNo(int roomNo) {

        RoomsData roomsData = new RoomsData();

        Boolean isValid = true;

        ArrayList<Room> roomList = roomsData.getAllRoomDetails();
        Iterator<Room> roomListIterator = roomList.iterator();

        while (roomListIterator.hasNext()) {

            Room room = roomListIterator.next();

            if (room.getRoomNo() == roomNo) {
                isValid = false;
            }

        }

        return isValid;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addRoomDialog = new javax.swing.JDialog();
        addRoomNoLabel = new javax.swing.JLabel();
        addRoomNoTextField = new javax.swing.JTextField();
        addTypeLabel = new javax.swing.JLabel();
        addRoomAddButton = new javax.swing.JButton();
        addRoomTypeCombo = new javax.swing.JComboBox<>();
        editRoomDialog = new javax.swing.JDialog();
        modifyRoomNoLabel = new javax.swing.JLabel();
        editRoomNoCombo = new javax.swing.JComboBox<>();
        modifyTypeLabel = new javax.swing.JLabel();
        editRoomTypeCombo = new javax.swing.JComboBox<>();
        editRoomSaveButton = new javax.swing.JButton();
        removeRoomDialog = new javax.swing.JDialog();
        removeRoomNoCombo = new javax.swing.JComboBox<>();
        removeRoomNoLabel = new javax.swing.JLabel();
        removeRoomNoButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        addRoomNoLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addRoomNoLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        addRoomNoLabel.setText("Room No");

        addRoomNoTextField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addRoomNoTextField.setText("jTextField1");
        addRoomNoTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                addRoomNoTextFieldKeyReleased(evt);
            }
        });

        addTypeLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        addTypeLabel.setText("Type of Room");

        addRoomAddButton.setBackground(new java.awt.Color(108, 160, 209));
        addRoomAddButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        addRoomAddButton.setForeground(new java.awt.Color(255, 255, 255));
        addRoomAddButton.setText("ADD");
        addRoomAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomAddButtonActionPerformed(evt);
            }
        });

        addRoomTypeCombo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addRoomTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout addRoomDialogLayout = new javax.swing.GroupLayout(addRoomDialog.getContentPane());
        addRoomDialog.getContentPane().setLayout(addRoomDialogLayout);
        addRoomDialogLayout.setHorizontalGroup(
            addRoomDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRoomDialogLayout.createSequentialGroup()
                .addGroup(addRoomDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addRoomDialogLayout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(addRoomAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addRoomDialogLayout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addGroup(addRoomDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addRoomNoLabel)
                            .addComponent(addTypeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addRoomDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addRoomNoTextField)
                            .addComponent(addRoomTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        addRoomDialogLayout.setVerticalGroup(
            addRoomDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRoomDialogLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(addRoomDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRoomNoLabel)
                    .addComponent(addRoomNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addRoomDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTypeLabel)
                    .addComponent(addRoomTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addRoomAddButton)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        modifyRoomNoLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        modifyRoomNoLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        modifyRoomNoLabel.setText("Room No");

        editRoomNoCombo.setBackground(new java.awt.Color(246, 252, 252));
        editRoomNoCombo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        editRoomNoCombo.setForeground(new java.awt.Color(45, 58, 84));
        editRoomNoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        editRoomNoCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                editRoomNoComboFocusLost(evt);
            }
        });

        modifyTypeLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        modifyTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        modifyTypeLabel.setText("Room Type");

        editRoomTypeCombo.setBackground(new java.awt.Color(246, 252, 252));
        editRoomTypeCombo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        editRoomTypeCombo.setForeground(new java.awt.Color(45, 58, 84));
        editRoomTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        editRoomSaveButton.setBackground(new java.awt.Color(108, 160, 209));
        editRoomSaveButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        editRoomSaveButton.setForeground(new java.awt.Color(255, 255, 255));
        editRoomSaveButton.setText("SAVE");
        editRoomSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRoomSaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editRoomDialogLayout = new javax.swing.GroupLayout(editRoomDialog.getContentPane());
        editRoomDialog.getContentPane().setLayout(editRoomDialogLayout);
        editRoomDialogLayout.setHorizontalGroup(
            editRoomDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editRoomDialogLayout.createSequentialGroup()
                .addContainerGap(270, Short.MAX_VALUE)
                .addGroup(editRoomDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(modifyRoomNoLabel)
                    .addComponent(modifyTypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editRoomDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editRoomTypeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editRoomNoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(290, 290, 290))
            .addGroup(editRoomDialogLayout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(editRoomSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editRoomDialogLayout.setVerticalGroup(
            editRoomDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editRoomDialogLayout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addGroup(editRoomDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifyRoomNoLabel)
                    .addComponent(editRoomNoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editRoomDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editRoomTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyTypeLabel))
                .addGap(36, 36, 36)
                .addComponent(editRoomSaveButton)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        removeRoomNoCombo.setBackground(new java.awt.Color(246, 252, 252));
        removeRoomNoCombo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        removeRoomNoCombo.setForeground(new java.awt.Color(45, 58, 84));
        removeRoomNoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        removeRoomNoLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        removeRoomNoLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        removeRoomNoLabel.setText("Room No");

        removeRoomNoButton.setBackground(new java.awt.Color(108, 160, 209));
        removeRoomNoButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        removeRoomNoButton.setForeground(new java.awt.Color(255, 255, 255));
        removeRoomNoButton.setText("REMOVE");
        removeRoomNoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRoomNoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout removeRoomDialogLayout = new javax.swing.GroupLayout(removeRoomDialog.getContentPane());
        removeRoomDialog.getContentPane().setLayout(removeRoomDialogLayout);
        removeRoomDialogLayout.setHorizontalGroup(
            removeRoomDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeRoomDialogLayout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(removeRoomNoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeRoomNoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, removeRoomDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(removeRoomNoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(332, 332, 332))
        );
        removeRoomDialogLayout.setVerticalGroup(
            removeRoomDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeRoomDialogLayout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(removeRoomDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeRoomNoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeRoomNoLabel))
                .addGap(50, 50, 50)
                .addComponent(removeRoomNoButton)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        roomTable.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        roomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Room No", "Room Type", "Status", "Under Maintenance"
            }
        ));
        jScrollPane1.setViewportView(roomTable);

        addButton.setBackground(new java.awt.Color(108, 160, 209));
        addButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(108, 160, 209));
        editButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("EDIT");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        removeButton.setBackground(new java.awt.Color(108, 160, 209));
        removeButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        removeButton.setForeground(new java.awt.Color(255, 255, 255));
        removeButton.setText("REMOVE");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        closeButton.setBackground(new java.awt.Color(255, 0, 0));
        closeButton.setForeground(new java.awt.Color(255, 255, 255));
        closeButton.setText("X");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        titleLabel.setText("Room");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(651, 651, 651)
                .addComponent(titleLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(358, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(143, 143, 143)
                                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(358, 358, 358))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

        setTheme();
        
        refreshRoomTable();
        roomTable.requestFocus();

    }//GEN-LAST:event_formWindowGainedFocus

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        RoomsData roomsData = new RoomsData();

        DefaultComboBoxModel roomTypeComboModel = (DefaultComboBoxModel) addRoomTypeCombo.getModel();

        int newRoomNo = roomsData.getNewRoomNo();

        JOptionPane.showMessageDialog(null, newRoomNo + " is the suggested room no.");

        addRoomNoTextField.setText("" + newRoomNo);
        refreshRoomTypeComboBox(roomTypeComboModel);

        addRoomDialog.setSize(800, 500);
        addRoomDialog.show();

    }//GEN-LAST:event_addButtonActionPerformed

    private void addRoomAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomAddButtonActionPerformed

        Room room = new Room();
        RoomsData roomsData = new RoomsData();

        room.setRoomNo(Integer.parseInt(addRoomNoTextField.getText()));
        room.setType(addRoomTypeCombo.getSelectedItem().toString());
        room.setRoomStatus("Vacant");
        room.setUnderMaintenance(false);

        if (roomsData.addRoom(room)) {

            JOptionPane.showMessageDialog(null, "Room " + room.getRoomNo() + " added successfully!");
            addRoomDialog.setVisible(false);

        }

    }//GEN-LAST:event_addRoomAddButtonActionPerformed

    private void addRoomNoTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addRoomNoTextFieldKeyReleased

        int roomNo = Integer.parseInt(addRoomNoTextField.getText());
        if (isValidRoomNo(roomNo)) {

            addRoomNoTextField.setToolTipText("");
            addRoomAddButton.setEnabled(true);

        } else {

            addRoomNoTextField.setToolTipText("Room No " + roomNo + " already exist!");
            addRoomAddButton.setEnabled(false);

        }

    }//GEN-LAST:event_addRoomNoTextFieldKeyReleased

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed

        DefaultComboBoxModel roomNoComboBoxModel = (DefaultComboBoxModel) editRoomNoCombo.getModel();
        DefaultComboBoxModel roomTypeComboBoxModel = (DefaultComboBoxModel) editRoomTypeCombo.getModel();

        refreshRoomNoComboBox(roomNoComboBoxModel);
        refreshRoomTypeComboBox(roomTypeComboBoxModel);

        editRoomDialog.setSize(800, 500);
        editRoomDialog.show();

    }//GEN-LAST:event_editButtonActionPerformed

    private void editRoomNoComboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_editRoomNoComboFocusLost

        Room room;
        RoomsData roomsData = new RoomsData();

        int roomNo = Integer.parseInt(editRoomNoCombo.getSelectedItem().toString());
        room = roomsData.getRoomDetails(roomNo);

        editRoomTypeCombo.setSelectedItem(room.getType());

    }//GEN-LAST:event_editRoomNoComboFocusLost

    private void editRoomSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRoomSaveButtonActionPerformed

        RoomsData roomsData = new RoomsData();
        Room room = new Room();

        int roomNo = Integer.parseInt(editRoomNoCombo.getSelectedItem().toString());
        room.setType(editRoomTypeCombo.getSelectedItem().toString());

        if (roomsData.modifyRoomType(room, roomNo)) {

            JOptionPane.showMessageDialog(null, "Modified room successfully!");
            editRoomDialog.setVisible(false);

        }

    }//GEN-LAST:event_editRoomSaveButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed

        DefaultComboBoxModel roomNoComboBoxModel = (DefaultComboBoxModel) removeRoomNoCombo.getModel();

        refreshRoomNoComboBox(roomNoComboBoxModel);

        removeRoomDialog.setSize(800, 500);
        removeRoomDialog.show();

    }//GEN-LAST:event_removeButtonActionPerformed

    private void removeRoomNoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRoomNoButtonActionPerformed

        RoomsData roomsData = new RoomsData();

        int roomNo, confirm;

        roomNo = Integer.parseInt(removeRoomNoCombo.getSelectedItem().toString());
        confirm = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + roomNo);

        if (confirm == 0) {

            if (roomsData.removeRoom(roomNo)) {

                JOptionPane.showMessageDialog(null, roomNo + " removed successfully!");
                removeRoomDialog.setVisible(false);

            }

        }

    }//GEN-LAST:event_removeRoomNoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RoomsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addRoomAddButton;
    private javax.swing.JDialog addRoomDialog;
    private javax.swing.JLabel addRoomNoLabel;
    private javax.swing.JTextField addRoomNoTextField;
    private javax.swing.JComboBox<String> addRoomTypeCombo;
    private javax.swing.JLabel addTypeLabel;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton editButton;
    private javax.swing.JDialog editRoomDialog;
    private javax.swing.JComboBox<String> editRoomNoCombo;
    private javax.swing.JButton editRoomSaveButton;
    private javax.swing.JComboBox<String> editRoomTypeCombo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel modifyRoomNoLabel;
    private javax.swing.JLabel modifyTypeLabel;
    private javax.swing.JButton removeButton;
    private javax.swing.JDialog removeRoomDialog;
    private javax.swing.JButton removeRoomNoButton;
    private javax.swing.JComboBox<String> removeRoomNoCombo;
    private javax.swing.JLabel removeRoomNoLabel;
    private javax.swing.JTable roomTable;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
