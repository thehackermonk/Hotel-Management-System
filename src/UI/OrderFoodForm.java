/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Bean.OrderedFood;
import Bean.RestaurantWithFood;
import Bean.Room;
import DTO.FoodData;
import DTO.GuestInRoomData;
import DTO.OrderFoodData;
import DTO.RestaurantData;
import DTO.RoomsData;
import Logic.OrderFoodLogic;
import Logic.Validation;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author thehackermonk
 */
public class OrderFoodForm extends javax.swing.JFrame {

    /**
     * Creates new form OrderFoodForm
     */
    public OrderFoodForm() {
        initComponents();
    }

    /**
     * Set theme of the form
     */
    public void setTheme() {

        this.getContentPane().setBackground(new Color(246, 252, 252));

        titleLabel.setForeground(new Color(45, 58, 84));
        roomNoLabel.setForeground(new Color(45, 58, 84));
        nameLabel.setForeground(new Color(45, 58, 84));
        restaurantLabel.setForeground(new Color(45, 58, 84));
        foodLabel.setForeground(new Color(45, 58, 84));
        quantityLabel.setForeground(new Color(45, 58, 84));
        totalPriceLabel.setForeground(new Color(45, 58, 84));
        
        foodTable.getTableHeader().setDefaultRenderer(new DefaultTableCellHeaderRenderer() {

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
     * To clear the fields
     */
    public void clear() {

        DefaultComboBoxModel foodComboBoxModel = (DefaultComboBoxModel) foodComboBox.getModel();

        nameTextField.setText("");
        quantityTextField.setText("");
        totalPriceTextField.setText("");

        foodComboBoxModel.removeAllElements();

        clearTable();

    }

    /**
     * To clear the table
     */
    public void clearTable() {

        DefaultTableModel foodTableModel = (DefaultTableModel) foodTable.getModel();

        while (foodTableModel.getRowCount() > 0) {
            foodTableModel.removeRow(0);
        }

    }

    /**
     * To add room nos to the combo box Only rooms where guest are staying will
     * be shown
     *
     * @param comboBox
     */
    public void refreshRoomNoComboBox(DefaultComboBoxModel comboBox) {

        RoomsData roomsData = new RoomsData();

        ArrayList<Room> roomList;
        Iterator<Room> roomListIterator;

        comboBox.removeAllElements();

        roomList = roomsData.getOccupiedRooms();
        roomListIterator = roomList.iterator();

        while (roomListIterator.hasNext()) {

            Room room = roomListIterator.next();

            comboBox.addElement(room.getRoomNo());

        }

    }

    /**
     * To add available restaurants in the combo box
     *
     * @param comboBox
     */
    public void refreshRestaurantComboBox(DefaultComboBoxModel comboBox) {

        OrderFoodData orderFoodData = new OrderFoodData();

        ArrayList<RestaurantWithFood> restaurantWithFoodList;
        Iterator<RestaurantWithFood> restaurantWithFoodListIterator;
        HashSet<String> restaurantNameList = new HashSet<>();

        comboBox.removeAllElements();

        restaurantWithFoodList = orderFoodData.getRestaurantWithFood();
        restaurantWithFoodListIterator = restaurantWithFoodList.iterator();

        while (restaurantWithFoodListIterator.hasNext()) {

            RestaurantWithFood restaurantWithFood = restaurantWithFoodListIterator.next();

            restaurantNameList.add(restaurantWithFood.getRestaurantName());

        }

        restaurantNameList.forEach(restaurantName -> {
            comboBox.addElement(restaurantName);
        });

    }

    /**
     * To calculate the total payable amount
     *
     * @param tableModel: ordered food table
     * @return : total payable amount
     */
    public double calculateTotalPrice(DefaultTableModel tableModel) {

        double totalPrice = 0;

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            totalPrice += Double.parseDouble(tableModel.getValueAt(i, 3).toString());
        }

        return totalPrice;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        roomNoLabel = new javax.swing.JLabel();
        roomNoComboBox = new javax.swing.JComboBox<>();
        nameTextField = new javax.swing.JTextField();
        restaurantComboBox = new javax.swing.JComboBox<>();
        selectRestaurantButton = new javax.swing.JButton();
        foodComboBox = new javax.swing.JComboBox<>();
        quantitySlider = new javax.swing.JSlider();
        nameLabel = new javax.swing.JLabel();
        restaurantLabel = new javax.swing.JLabel();
        foodLabel = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        addFoodButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        foodTable = new javax.swing.JTable();
        orderFoodButton = new javax.swing.JButton();
        totalPriceLabel = new javax.swing.JLabel();
        totalPriceTextField = new javax.swing.JTextField();
        quantityTextField = new javax.swing.JTextField();
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

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        roomNoLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        roomNoLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        roomNoLabel.setText("Room No");

        roomNoComboBox.setBackground(new java.awt.Color(246, 252, 252));
        roomNoComboBox.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        roomNoComboBox.setForeground(new java.awt.Color(45, 58, 84));
        roomNoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roomNoComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                roomNoComboBoxFocusLost(evt);
            }
        });

        nameTextField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        nameTextField.setText("jTextField1");

        restaurantComboBox.setBackground(new java.awt.Color(246, 252, 252));
        restaurantComboBox.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        restaurantComboBox.setForeground(new java.awt.Color(45, 58, 84));
        restaurantComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        restaurantComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                restaurantComboBoxFocusGained(evt);
            }
        });

        selectRestaurantButton.setBackground(new java.awt.Color(108, 160, 209));
        selectRestaurantButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        selectRestaurantButton.setForeground(new java.awt.Color(255, 255, 255));
        selectRestaurantButton.setText("SELECT RESTAURANT");
        selectRestaurantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectRestaurantButtonActionPerformed(evt);
            }
        });

        foodComboBox.setBackground(new java.awt.Color(246, 252, 252));
        foodComboBox.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        foodComboBox.setForeground(new java.awt.Color(45, 58, 84));
        foodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        foodComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                foodComboBoxFocusLost(evt);
            }
        });

        quantitySlider.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        quantitySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                quantitySliderStateChanged(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nameLabel.setText("Name");

        restaurantLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        restaurantLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        restaurantLabel.setText("Restaurant");

        foodLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        foodLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        foodLabel.setText("Food");

        quantityLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        quantityLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        quantityLabel.setText("Quantity");

        addFoodButton.setBackground(new java.awt.Color(108, 160, 209));
        addFoodButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        addFoodButton.setForeground(new java.awt.Color(255, 255, 255));
        addFoodButton.setText("ADD FOOD");
        addFoodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFoodButtonActionPerformed(evt);
            }
        });

        foodTable.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        foodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Food", "Price", "Quantity", "Net Price"
            }
        ));
        jScrollPane1.setViewportView(foodTable);

        orderFoodButton.setBackground(new java.awt.Color(108, 160, 209));
        orderFoodButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        orderFoodButton.setForeground(new java.awt.Color(255, 255, 255));
        orderFoodButton.setText("ORDER FOOD");
        orderFoodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderFoodButtonActionPerformed(evt);
            }
        });

        totalPriceLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        totalPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalPriceLabel.setText("Total Price");

        totalPriceTextField.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        totalPriceTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalPriceTextField.setText("jTextField1");

        quantityTextField.setText("0");
        quantityTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantityTextFieldFocusLost(evt);
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
        titleLabel.setText("Order Food");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(647, 647, 647)
                .addComponent(titleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nameLabel)
                                    .addComponent(roomNoLabel)
                                    .addComponent(restaurantLabel)
                                    .addComponent(foodLabel)
                                    .addComponent(quantityLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(quantitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(restaurantComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nameTextField)
                                    .addComponent(roomNoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(foodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addFoodButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(212, 212, 212))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectRestaurantButton)
                                .addGap(207, 207, 207)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(totalPriceLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(totalPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(297, 297, 297))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(100, 100, 100))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderFoodButton)
                                .addGap(315, 315, 315))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(totalPriceLabel)
                                    .addComponent(totalPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(orderFoodButton))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roomNoLabel)
                            .addComponent(roomNoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(restaurantComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(restaurantLabel))
                        .addGap(49, 49, 49)
                        .addComponent(selectRestaurantButton)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(foodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(foodLabel))
                                .addGap(18, 18, 18)
                                .addComponent(quantitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(quantityLabel)
                            .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(addFoodButton)
                        .addGap(163, 163, 163))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

        setTheme();
        
        DefaultComboBoxModel roomNoComboBoxModel = (DefaultComboBoxModel) roomNoComboBox.getModel();
        DefaultComboBoxModel restaurantComboBoxModel = (DefaultComboBoxModel) restaurantComboBox.getModel();

        clear();
        refreshRoomNoComboBox(roomNoComboBoxModel);
        refreshRestaurantComboBox(restaurantComboBoxModel);

        nameTextField.setEditable(false);
        totalPriceTextField.setEditable(false);
        addFoodButton.setEnabled(false);

        roomNoComboBox.requestFocus();

    }//GEN-LAST:event_formWindowGainedFocus

    private void roomNoComboBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roomNoComboBoxFocusLost

        GuestInRoomData guestInRoomData = new GuestInRoomData();

        int roomNo;

        roomNo = Integer.parseInt(roomNoComboBox.getSelectedItem().toString());

        nameTextField.setText(guestInRoomData.getGuestInRoom(roomNo));

    }//GEN-LAST:event_roomNoComboBoxFocusLost

    private void restaurantComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_restaurantComboBoxFocusGained

        addFoodButton.setEnabled(false);

        clearTable();

    }//GEN-LAST:event_restaurantComboBoxFocusGained

    private void selectRestaurantButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectRestaurantButtonActionPerformed

        OrderFoodLogic orderFoodLogic = new OrderFoodLogic();
        RestaurantData restaurantData = new RestaurantData();

        DefaultComboBoxModel foodComboBoxModel = (DefaultComboBoxModel) foodComboBox.getModel();

        String restaurantName;
        int restaurantNo;

        ArrayList<String> foodList;
        Iterator<String> foodListIterator;

        foodComboBoxModel.removeAllElements();

        restaurantName = restaurantComboBox.getSelectedItem().toString();
        restaurantNo = restaurantData.getRestaurantDetails(restaurantName).getRestaurantNo();

        foodList = orderFoodLogic.getAvailableFoods(restaurantNo);
        foodListIterator = foodList.iterator();

        while (foodListIterator.hasNext()) {

            String food = foodListIterator.next();
            foodComboBoxModel.addElement(food);

        }

        addFoodButton.setEnabled(true);
        foodComboBox.requestFocus();

    }//GEN-LAST:event_selectRestaurantButtonActionPerformed

    private void foodComboBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_foodComboBoxFocusLost

        OrderFoodLogic orderFoodLogic = new OrderFoodLogic();

        String restaurant, food;

        restaurant = restaurantComboBox.getSelectedItem().toString();
        food = foodComboBox.getSelectedItem().toString();

        quantitySlider.setMaximum(orderFoodLogic.quantityProducedToday(restaurant, food));
        quantitySlider.setValue(0);

    }//GEN-LAST:event_foodComboBoxFocusLost

    private void quantitySliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_quantitySliderStateChanged

        quantityTextField.setText(quantitySlider.getValue() + "");

    }//GEN-LAST:event_quantitySliderStateChanged

    private void addFoodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFoodButtonActionPerformed

        FoodData foodData = new FoodData();
        Validation validation = new Validation();

        DefaultTableModel foodTableModel = (DefaultTableModel) foodTable.getModel();

        String foodName;
        int quantity;
        double price, netPrice;

        if (validation.isNumeric(quantityTextField.getText())) {

            foodName = foodComboBox.getSelectedItem().toString();
            quantity = Integer.parseInt(quantityTextField.getText());

            price = foodData.getFoodDetails(foodName).getPrice();

            netPrice = quantity * price;

            if (quantity <= quantitySlider.getMaximum()) {
                foodTableModel.addRow(new Object[]{foodName, price, quantity, netPrice});
            }

        }

        if (foodTableModel.getRowCount() > 0) {
            totalPriceTextField.setText(calculateTotalPrice(foodTableModel) + "");
        }

    }//GEN-LAST:event_addFoodButtonActionPerformed

    private void orderFoodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderFoodButtonActionPerformed

        FoodData foodData = new FoodData();
        OrderFoodLogic orderFoodLogic = new OrderFoodLogic();

        DefaultTableModel foodTableModel = (DefaultTableModel) foodTable.getModel();

        String restaurant;
        int roomNo;

        ArrayList<OrderedFood> foodOrderList = new ArrayList<>();

        roomNo = Integer.parseInt(roomNoComboBox.getSelectedItem().toString());
        restaurant = restaurantComboBox.getSelectedItem().toString();

        for (int i = 0; i < foodTableModel.getRowCount(); i++) {

            OrderedFood foodOrder = new OrderedFood();

            foodOrder.setFoodNo(foodData.getFoodDetails(foodTable.getValueAt(i, 0).toString()).getNdbNo());
            foodOrder.setQuantity(Integer.parseInt(foodTable.getValueAt(i, 2).toString()));

            foodOrderList.add(foodOrder);

        }

        if (orderFoodLogic.orderFood(roomNo, restaurant, foodOrderList)) {

            JOptionPane.showMessageDialog(null, "Food ordered successfully");

        }

    }//GEN-LAST:event_orderFoodButtonActionPerformed

    private void quantityTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityTextFieldFocusLost

        Validation validation = new Validation();

        int quantity, maxQuantity;

        if (validation.isNumeric(quantityTextField.getText())) {
            quantity = Integer.parseInt(quantityTextField.getText());
            maxQuantity = quantitySlider.getMaximum();

            if (quantity > maxQuantity) {

                JOptionPane.showMessageDialog(null, quantity + " food is not available.\n Maximum is " + maxQuantity);
                quantityTextField.requestFocus();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a valid quantity");
        }

    }//GEN-LAST:event_quantityTextFieldFocusLost

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed

        this.setVisible(false);
        new FrontOfficeMenu().show();

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
            java.util.logging.Logger.getLogger(OrderFoodForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderFoodForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderFoodForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderFoodForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderFoodForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFoodButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JComboBox<String> foodComboBox;
    private javax.swing.JLabel foodLabel;
    private javax.swing.JTable foodTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton orderFoodButton;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JSlider quantitySlider;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JComboBox<String> restaurantComboBox;
    private javax.swing.JLabel restaurantLabel;
    private javax.swing.JComboBox<String> roomNoComboBox;
    private javax.swing.JLabel roomNoLabel;
    private javax.swing.JButton selectRestaurantButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel totalPriceLabel;
    private javax.swing.JTextField totalPriceTextField;
    // End of variables declaration//GEN-END:variables
};
