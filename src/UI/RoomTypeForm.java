/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Bean.RoomType;
import DTO.RoomTypeData;
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
public class RoomTypeForm extends javax.swing.JFrame {

    /**
     * Creates new form RoomType
     */
    public RoomTypeForm() {
        initComponents();
    }

    /**
     * Set theme of the form
     */
    public void setTheme() {

        this.getContentPane().setBackground(new Color(246, 252, 252));
        roomTypeAddDialog.getContentPane().setBackground(new Color(246, 252, 252));
        roomTypeEditDialog.getContentPane().setBackground(new Color(246, 252, 252));
        roomTypeRemoveDialog.getContentPane().setBackground(new Color(246, 252, 252));

        titleLabel.setForeground(new Color(45, 58, 84));
        addRoomTypeLabel.setForeground(new Color(45, 58, 84));
        addPriceLabel.setForeground(new Color(45, 58, 84));
        addCapacityLabel.setForeground(new Color(45, 58, 84));
        modifyRoomTypeLabel.setForeground(new Color(45, 58, 84));
        modifyPriceLabel.setForeground(new Color(45, 58, 84));
        modifyCapacityLabel.setForeground(new Color(45, 58, 84));
        editCapacityLabel.setForeground(new Color(45, 58, 84));
        removeRoomTypeLabel.setForeground(new Color(45, 58, 84));

        roomTypeTable.getTableHeader().setDefaultRenderer(new DefaultTableCellHeaderRenderer() {

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
     * Clears text fields in add room type dialog box
     */
    public void clearAddRoomType() {

        roomTypeAddTypeTextField.setText("");
        roomTypeAddPriceTextField.setText("");

    }

    /**
     * Clears text fields in edit room type dialog box
     */
    public void clearEditRoomType() {

        roomTypeEditTypeTextField.setText("");
        roomTypeEditPriceTextField.setText("");

    }

    /**
     * Refresh the contents of RoomTypeTable
     */
    public void refreshRoomTypeTable() {

        RoomTypeData roomTypeData = new RoomTypeData();

        DefaultTableModel roomTypeTableModel = (DefaultTableModel) roomTypeTable.getModel();

        while (roomTypeTableModel.getRowCount() > 0) {

            roomTypeTableModel.removeRow(0);

        }

        ArrayList<RoomType> roomTypeList = roomTypeData.getAllRoomTypeDetails();
        Iterator<RoomType> roomTypeListIterator = roomTypeList.iterator();

        while (roomTypeListIterator.hasNext()) {

            RoomType roomType = roomTypeListIterator.next();

            roomTypeTableModel.addRow(new Object[]{roomType.getType(), roomType.getPrice(), roomType.getCapacity()});

        }

    }

    /**
     * Refresh the contents of RoomType combo box
     *
     * @param comboBoxModel any combo box which holds the value room type
     */
    public void refreshRoomTypeComboBox(DefaultComboBoxModel comboBoxModel) {

        RoomTypeData roomTypeData = new RoomTypeData();

        comboBoxModel.removeAllElements();

        ArrayList<RoomType> roomTypeList = roomTypeData.getAllRoomTypeDetails();
        Iterator<RoomType> roomTypeListIterator = roomTypeList.iterator();

        while (roomTypeListIterator.hasNext()) {

            RoomType roomType = roomTypeListIterator.next();
            comboBoxModel.addElement(roomType.getType());

        }

    }

    /**
     * To check if the entered name for room type is valid (must be unique)
     *
     * @param type name for room type entered by the user
     * @return true if it is a valid room type, and false if it is an invalid
     * room type
     */
    public boolean isValidRoomType(String type) {

        RoomTypeData roomTypeData = new RoomTypeData();
        Boolean valid = true;

        ArrayList<RoomType> roomTypeList = roomTypeData.getAllRoomTypeDetails();
        Iterator<RoomType> roomTypeListIterator = roomTypeList.iterator();

        while (roomTypeListIterator.hasNext()) {

            RoomType roomType = roomTypeListIterator.next();

            if (type.equalsIgnoreCase(roomType.getType())) {
                valid = false;
            }

        }

        return valid;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roomTypeAddDialog = new javax.swing.JDialog();
        addRoomTypeLabel = new javax.swing.JLabel();
        addPriceLabel = new javax.swing.JLabel();
        roomTypeAddTypeTextField = new javax.swing.JTextField();
        roomTypeAddPriceTextField = new javax.swing.JTextField();
        addRoomTypeAddButton = new javax.swing.JButton();
        roomTypeAddCapacitySlider = new javax.swing.JSlider();
        addCapacityLabel = new javax.swing.JLabel();
        addRoomTypeCountLabel = new javax.swing.JLabel();
        roomTypeEditDialog = new javax.swing.JDialog();
        roomTypeEditTypeCombo = new javax.swing.JComboBox<>();
        modifyRoomTypeLabel = new javax.swing.JLabel();
        roomTypeEditTypeTextField = new javax.swing.JTextField();
        modifyPriceLabel = new javax.swing.JLabel();
        roomTypeEditPriceTextField = new javax.swing.JTextField();
        editRoomTypeSaveButton = new javax.swing.JButton();
        editCapacitySlider = new javax.swing.JSlider();
        editCapacityLabel = new javax.swing.JLabel();
        modifyCapacityLabel = new javax.swing.JLabel();
        roomTypeRemoveDialog = new javax.swing.JDialog();
        roomTypeRemoveTypeCombo = new javax.swing.JComboBox<>();
        removeRoomTypeRemoveButton = new javax.swing.JButton();
        removeRoomTypeLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomTypeTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        addRoomTypeLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addRoomTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        addRoomTypeLabel.setText("Room Type");

        addPriceLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        addPriceLabel.setText("Price");

        roomTypeAddTypeTextField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        roomTypeAddTypeTextField.setText("jTextField1");
        roomTypeAddTypeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                roomTypeAddTypeTextFieldKeyReleased(evt);
            }
        });

        roomTypeAddPriceTextField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        roomTypeAddPriceTextField.setText("jTextField2");

        addRoomTypeAddButton.setBackground(new java.awt.Color(108, 160, 209));
        addRoomTypeAddButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        addRoomTypeAddButton.setForeground(new java.awt.Color(255, 255, 255));
        addRoomTypeAddButton.setText("ADD");
        addRoomTypeAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomTypeAddButtonActionPerformed(evt);
            }
        });

        roomTypeAddCapacitySlider.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        roomTypeAddCapacitySlider.setMaximum(15);
        roomTypeAddCapacitySlider.setValue(0);
        roomTypeAddCapacitySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                roomTypeAddCapacitySliderStateChanged(evt);
            }
        });

        addCapacityLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addCapacityLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        addCapacityLabel.setText("Capacity");

        addRoomTypeCountLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addRoomTypeCountLabel.setText("0");

        javax.swing.GroupLayout roomTypeAddDialogLayout = new javax.swing.GroupLayout(roomTypeAddDialog.getContentPane());
        roomTypeAddDialog.getContentPane().setLayout(roomTypeAddDialogLayout);
        roomTypeAddDialogLayout.setHorizontalGroup(
            roomTypeAddDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roomTypeAddDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addRoomTypeAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(332, 332, 332))
            .addGroup(roomTypeAddDialogLayout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addGroup(roomTypeAddDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addPriceLabel)
                    .addComponent(addRoomTypeLabel)
                    .addComponent(addCapacityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roomTypeAddDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roomTypeAddTypeTextField)
                    .addComponent(roomTypeAddPriceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addGroup(roomTypeAddDialogLayout.createSequentialGroup()
                        .addComponent(roomTypeAddCapacitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addRoomTypeCountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(283, Short.MAX_VALUE))
        );
        roomTypeAddDialogLayout.setVerticalGroup(
            roomTypeAddDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomTypeAddDialogLayout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addGroup(roomTypeAddDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roomTypeAddDialogLayout.createSequentialGroup()
                        .addGroup(roomTypeAddDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addRoomTypeLabel)
                            .addComponent(roomTypeAddTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(roomTypeAddDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addPriceLabel)
                            .addComponent(roomTypeAddPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(roomTypeAddDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(roomTypeAddCapacitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addRoomTypeCountLabel)))
                    .addComponent(addCapacityLabel))
                .addGap(34, 34, 34)
                .addComponent(addRoomTypeAddButton)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        roomTypeEditTypeCombo.setBackground(new java.awt.Color(246, 252, 252));
        roomTypeEditTypeCombo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        roomTypeEditTypeCombo.setForeground(new java.awt.Color(45, 58, 84));
        roomTypeEditTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roomTypeEditTypeCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                roomTypeEditTypeComboFocusLost(evt);
            }
        });

        modifyRoomTypeLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        modifyRoomTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        modifyRoomTypeLabel.setText("Room Type");

        roomTypeEditTypeTextField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        roomTypeEditTypeTextField.setText("jTextField1");
        roomTypeEditTypeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                roomTypeEditTypeTextFieldKeyReleased(evt);
            }
        });

        modifyPriceLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        modifyPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        modifyPriceLabel.setText("Price");

        roomTypeEditPriceTextField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        roomTypeEditPriceTextField.setText("jTextField2");

        editRoomTypeSaveButton.setBackground(new java.awt.Color(108, 160, 209));
        editRoomTypeSaveButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        editRoomTypeSaveButton.setForeground(new java.awt.Color(255, 255, 255));
        editRoomTypeSaveButton.setText("SAVE");
        editRoomTypeSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRoomTypeSaveButtonActionPerformed(evt);
            }
        });

        editCapacitySlider.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        editCapacitySlider.setMaximum(15);
        editCapacitySlider.setValue(0);
        editCapacitySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                editCapacitySliderStateChanged(evt);
            }
        });

        editCapacityLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        editCapacityLabel.setText("0");

        modifyCapacityLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        modifyCapacityLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        modifyCapacityLabel.setText("Capacity");

        javax.swing.GroupLayout roomTypeEditDialogLayout = new javax.swing.GroupLayout(roomTypeEditDialog.getContentPane());
        roomTypeEditDialog.getContentPane().setLayout(roomTypeEditDialogLayout);
        roomTypeEditDialogLayout.setHorizontalGroup(
            roomTypeEditDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomTypeEditDialogLayout.createSequentialGroup()
                .addGroup(roomTypeEditDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomTypeEditDialogLayout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(roomTypeEditTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roomTypeEditDialogLayout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(editRoomTypeSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roomTypeEditDialogLayout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addGroup(roomTypeEditDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(modifyPriceLabel)
                            .addComponent(modifyRoomTypeLabel)
                            .addComponent(modifyCapacityLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roomTypeEditDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roomTypeEditTypeTextField)
                            .addComponent(roomTypeEditPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roomTypeEditDialogLayout.createSequentialGroup()
                                .addComponent(editCapacitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editCapacityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(288, Short.MAX_VALUE))
        );
        roomTypeEditDialogLayout.setVerticalGroup(
            roomTypeEditDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomTypeEditDialogLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(roomTypeEditTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(roomTypeEditDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifyRoomTypeLabel)
                    .addComponent(roomTypeEditTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roomTypeEditDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifyPriceLabel)
                    .addComponent(roomTypeEditPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roomTypeEditDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editCapacitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyCapacityLabel)
                    .addComponent(editCapacityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(editRoomTypeSaveButton)
                .addGap(92, 92, 92))
        );

        roomTypeRemoveTypeCombo.setBackground(new java.awt.Color(246, 252, 252));
        roomTypeRemoveTypeCombo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        roomTypeRemoveTypeCombo.setForeground(new java.awt.Color(45, 58, 84));
        roomTypeRemoveTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        removeRoomTypeRemoveButton.setBackground(new java.awt.Color(108, 160, 209));
        removeRoomTypeRemoveButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        removeRoomTypeRemoveButton.setForeground(new java.awt.Color(255, 255, 255));
        removeRoomTypeRemoveButton.setText("REMOVE");
        removeRoomTypeRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRoomTypeRemoveButtonActionPerformed(evt);
            }
        });

        removeRoomTypeLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        removeRoomTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        removeRoomTypeLabel.setText("Room Type");

        javax.swing.GroupLayout roomTypeRemoveDialogLayout = new javax.swing.GroupLayout(roomTypeRemoveDialog.getContentPane());
        roomTypeRemoveDialog.getContentPane().setLayout(roomTypeRemoveDialogLayout);
        roomTypeRemoveDialogLayout.setHorizontalGroup(
            roomTypeRemoveDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomTypeRemoveDialogLayout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(removeRoomTypeRemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(347, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roomTypeRemoveDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(removeRoomTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roomTypeRemoveTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(275, 275, 275))
        );
        roomTypeRemoveDialogLayout.setVerticalGroup(
            roomTypeRemoveDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roomTypeRemoveDialogLayout.createSequentialGroup()
                .addContainerGap(218, Short.MAX_VALUE)
                .addGroup(roomTypeRemoveDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomTypeRemoveTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeRoomTypeLabel))
                .addGap(41, 41, 41)
                .addComponent(removeRoomTypeRemoveButton)
                .addGap(182, 182, 182))
        );

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        roomTypeTable.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        roomTypeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Type", "Price", "Capacity"
            }
        ));
        jScrollPane1.setViewportView(roomTypeTable);

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
        titleLabel.setText("Room Type");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(1313, Short.MAX_VALUE)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 345, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(627, 627, 627))
            .addGroup(layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(75, 75, 75)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed

        this.setVisible(false);
        new MaintenanceMenu().show();

    }//GEN-LAST:event_closeButtonActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

        setTheme();

        refreshRoomTypeTable();

    }//GEN-LAST:event_formWindowGainedFocus

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        roomTypeAddDialog.setSize(800, 500);
        clearAddRoomType();
        roomTypeAddDialog.show();

    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed

        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) roomTypeEditTypeCombo.getModel();

        refreshRoomTypeComboBox(comboBoxModel);
        clearEditRoomType();

        roomTypeEditDialog.setSize(800, 500);

        roomTypeEditDialog.show();
        roomTypeEditTypeCombo.requestFocus();

    }//GEN-LAST:event_editButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed

        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) roomTypeRemoveTypeCombo.getModel();

        refreshRoomTypeComboBox(comboBoxModel);

        roomTypeRemoveDialog.setSize(800, 500);
        roomTypeRemoveDialog.show();

    }//GEN-LAST:event_removeButtonActionPerformed

    private void addRoomTypeAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomTypeAddButtonActionPerformed

        RoomType roomType = new RoomType();
        RoomTypeData roomTypeData = new RoomTypeData();

        roomType.setType(roomTypeAddTypeTextField.getText());
        roomType.setPrice(Float.parseFloat(roomTypeAddPriceTextField.getText()));
        roomType.setCapacity(roomTypeAddCapacitySlider.getValue());

        if (roomTypeData.addRoomType(roomType)) {

            JOptionPane.showMessageDialog(null, "Room type added successfully");
            roomTypeAddDialog.setVisible(false);

        }

    }//GEN-LAST:event_addRoomTypeAddButtonActionPerformed

    private void roomTypeEditTypeComboFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roomTypeEditTypeComboFocusLost

        RoomType roomType;
        RoomTypeData roomTypeData = new RoomTypeData();

        String type = roomTypeEditTypeCombo.getSelectedItem().toString();

        roomType = roomTypeData.getRoomTypeDetails(type);

        clearEditRoomType();

        roomTypeEditTypeTextField.setText(roomType.getType());
        roomTypeEditPriceTextField.setText(roomType.getPrice().toString());
        editCapacitySlider.setValue(roomType.getCapacity());

    }//GEN-LAST:event_roomTypeEditTypeComboFocusLost

    private void editRoomTypeSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRoomTypeSaveButtonActionPerformed

        RoomType roomType = new RoomType();
        RoomTypeData roomTypeData = new RoomTypeData();

        String type;

        type = roomTypeEditTypeCombo.getSelectedItem().toString();
        roomType.setType(roomTypeEditTypeTextField.getText());
        roomType.setPrice(Float.parseFloat(roomTypeEditPriceTextField.getText()));
        roomType.setCapacity(editCapacitySlider.getValue());

        if (roomTypeData.updateRoomType(type, roomType)) {

            JOptionPane.showMessageDialog(null, type + " updated successfully!");
            roomTypeEditDialog.setVisible(false);

        }

    }//GEN-LAST:event_editRoomTypeSaveButtonActionPerformed

    private void removeRoomTypeRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRoomTypeRemoveButtonActionPerformed

        RoomTypeData roomTypeData = new RoomTypeData();

        String type;
        int confirm;

        type = roomTypeRemoveTypeCombo.getSelectedItem().toString();
        confirm = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + type);

        if (confirm == 0) {

            if (roomTypeData.removeRoomType(type)) {

                JOptionPane.showMessageDialog(null, type + " removed successfully!");
                roomTypeRemoveDialog.setVisible(false);

            }

        }

    }//GEN-LAST:event_removeRoomTypeRemoveButtonActionPerformed

    private void roomTypeAddTypeTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roomTypeAddTypeTextFieldKeyReleased

        String type = roomTypeAddTypeTextField.getText();

        if (!isValidRoomType(type)) {

            addRoomTypeAddButton.setEnabled(false);
            roomTypeAddTypeTextField.setToolTipText("Room type already exist!");

        } else {

            addRoomTypeAddButton.setEnabled(true);
            roomTypeAddTypeTextField.setToolTipText("");

        }

    }//GEN-LAST:event_roomTypeAddTypeTextFieldKeyReleased

    private void roomTypeEditTypeTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roomTypeEditTypeTextFieldKeyReleased

        String type = roomTypeEditTypeTextField.getText();

        if (!isValidRoomType(type)) {

            editRoomTypeSaveButton.setEnabled(false);
            roomTypeEditTypeTextField.setToolTipText("Room type already exist!");

        } else {

            editRoomTypeSaveButton.setEnabled(true);
            roomTypeEditTypeTextField.setToolTipText("");

        }

    }//GEN-LAST:event_roomTypeEditTypeTextFieldKeyReleased

    private void roomTypeAddCapacitySliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_roomTypeAddCapacitySliderStateChanged

        int capacity = roomTypeAddCapacitySlider.getValue();
        addRoomTypeCountLabel.setText(String.valueOf(capacity));

    }//GEN-LAST:event_roomTypeAddCapacitySliderStateChanged

    private void editCapacitySliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_editCapacitySliderStateChanged

        int capacity = editCapacitySlider.getValue();
        editCapacityLabel.setText(String.valueOf(capacity));

    }//GEN-LAST:event_editCapacitySliderStateChanged

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
            java.util.logging.Logger.getLogger(RoomTypeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomTypeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomTypeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomTypeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomTypeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addCapacityLabel;
    private javax.swing.JLabel addPriceLabel;
    private javax.swing.JButton addRoomTypeAddButton;
    private javax.swing.JLabel addRoomTypeCountLabel;
    private javax.swing.JLabel addRoomTypeLabel;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel editCapacityLabel;
    private javax.swing.JSlider editCapacitySlider;
    private javax.swing.JButton editRoomTypeSaveButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel modifyCapacityLabel;
    private javax.swing.JLabel modifyPriceLabel;
    private javax.swing.JLabel modifyRoomTypeLabel;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel removeRoomTypeLabel;
    private javax.swing.JButton removeRoomTypeRemoveButton;
    private javax.swing.JSlider roomTypeAddCapacitySlider;
    private javax.swing.JDialog roomTypeAddDialog;
    private javax.swing.JTextField roomTypeAddPriceTextField;
    private javax.swing.JTextField roomTypeAddTypeTextField;
    private javax.swing.JDialog roomTypeEditDialog;
    private javax.swing.JTextField roomTypeEditPriceTextField;
    private javax.swing.JComboBox<String> roomTypeEditTypeCombo;
    private javax.swing.JTextField roomTypeEditTypeTextField;
    private javax.swing.JDialog roomTypeRemoveDialog;
    private javax.swing.JComboBox<String> roomTypeRemoveTypeCombo;
    private javax.swing.JTable roomTypeTable;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
