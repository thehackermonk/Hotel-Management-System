/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Bean.Food;
import Bean.Restaurant;
import Bean.RestaurantFood;
import DTO.FoodData;
import DTO.RestaurantData;
import DTO.RestaurantFoodData;
import Logic.RestaurantFoodLogic;
import Logic.Sort;
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
public class AssignFoodForm extends javax.swing.JFrame {

    /**
     * Creates new form AssignFoodForm
     */
    public AssignFoodForm() {
        initComponents();
    }

    /**
     * Set theme of the form
     */
    public void setTheme() {

        this.getContentPane().setBackground(new Color(246, 252, 252));
        
        titleLabel.setForeground(new Color(45, 58, 84));
        restaurantLabel.setForeground(new Color(45, 58, 84));
        
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

        selectedFoodTable.getTableHeader().setDefaultRenderer(new DefaultTableCellHeaderRenderer() {

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
     * Clear contents of both the tables
     */
    public void clearTables() {

        DefaultTableModel foodTableModel = (DefaultTableModel) foodTable.getModel();
        DefaultTableModel selectedFoodTableModel = (DefaultTableModel) selectedFoodTable.getModel();

        while (foodTableModel.getRowCount() > 0) {
            foodTableModel.removeRow(0);
        }

        while (selectedFoodTableModel.getRowCount() > 0) {
            selectedFoodTableModel.removeRow(0);
        }

    }

    /**
     * Refresh contents of the restaurant name combo box
     *
     * @param comboBox
     */
    public void refreshRestaurantComboBox(DefaultComboBoxModel comboBox) {

        RestaurantData restaurantData = new RestaurantData();

        ArrayList<Restaurant> restaurantList = restaurantData.getAllRestaurantDetails();
        Iterator<Restaurant> restaurantListIterator = restaurantList.iterator();

        comboBox.removeAllElements();

        while (restaurantListIterator.hasNext()) {

            Restaurant restaurant = restaurantListIterator.next();
            comboBox.addElement(restaurant.getName());

        }

    }

    /**
     * Refresh contents of food table
     *
     * Food table contains name of all the foods that are not selected
     *
     * This function is triggered when there are values in the selected food
     * table
     *
     * @param tableModel
     * @param selectedTableModel
     */
    public void refreshFoodTable(DefaultTableModel tableModel, DefaultTableModel selectedTableModel) {

        FoodData foodData = new FoodData();

        ArrayList<Food> foodList;
        ArrayList<String> selectedList = new ArrayList<>();
        Iterator<Food> foodListIterator;

        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
        }

        foodList = foodData.getAllFoodDetails();
        foodListIterator = foodList.iterator();

        for (int i = 0; i < selectedTableModel.getRowCount(); i++) {

            selectedList.add(selectedTableModel.getValueAt(i, 0).toString());

        }

        while (foodListIterator.hasNext()) {

            Food food = foodListIterator.next();
            String foodName = food.getName();

            if (!(selectedList.contains(foodName))) {

                tableModel.addRow(new Object[]{foodName});

            }

        }

    }

    /**
     * Refresh contents of food table
     *
     * Food table contains name of all the foods that are not selected
     *
     * This function is triggered when there are no values in the selected food
     * table
     *
     * @param tableModel
     */
    public void refreshFoodTable(DefaultTableModel tableModel) {

        FoodData foodData = new FoodData();

        ArrayList<Food> foodList;
        Iterator<Food> foodListIterator;

        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
        }

        foodList = foodData.getAllFoodDetails();
        foodListIterator = foodList.iterator();

        while (foodListIterator.hasNext()) {

            Food food = foodListIterator.next();
            tableModel.addRow(new Object[]{food.getName()});

        }

    }

    /**
     * Refresh contents of selected food table
     *
     * @param tableModel
     * @param restaurantNo : Unique identification number of restaurant
     */
    public void refreshSelectedFoodTable(DefaultTableModel tableModel, int restaurantNo) {

        FoodData foodData = new FoodData();
        RestaurantFoodData restaurantFoodData = new RestaurantFoodData();

        ArrayList<RestaurantFood> restaurantFoodList;
        Iterator<RestaurantFood> restaurantFoodListIterator;

        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
        }

        restaurantFoodList = restaurantFoodData.getAssignedFood(restaurantNo);
        restaurantFoodListIterator = restaurantFoodList.iterator();

        while (restaurantFoodListIterator.hasNext()) {

            Food food;
            RestaurantFood restaurantFood;

            restaurantFood = restaurantFoodListIterator.next();
            food = foodData.getFoodDetails(restaurantFood.getNDBNo());

            tableModel.addRow(new Object[]{food.getName()});

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        selectedFoodTable = new javax.swing.JTable();
        assignFoodButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        foodTable = new javax.swing.JTable();
        removeAllButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        addAllButton = new javax.swing.JButton();
        restaurantLabel = new javax.swing.JLabel();
        restaurantComboBox = new javax.swing.JComboBox<>();
        chooseButton = new javax.swing.JButton();
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

        selectedFoodTable.setBackground(new java.awt.Color(237, 247, 250));
        selectedFoodTable.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        selectedFoodTable.setForeground(new java.awt.Color(45, 58, 84));
        selectedFoodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "SELECTED FOOD"
            }
        ));
        jScrollPane1.setViewportView(selectedFoodTable);

        assignFoodButton.setBackground(new java.awt.Color(108, 160, 209));
        assignFoodButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        assignFoodButton.setForeground(new java.awt.Color(255, 255, 255));
        assignFoodButton.setText("ASSIGN FOOD");
        assignFoodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignFoodButtonActionPerformed(evt);
            }
        });

        resetButton.setBackground(new java.awt.Color(108, 160, 209));
        resetButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        resetButton.setForeground(new java.awt.Color(255, 255, 255));
        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        foodTable.setBackground(new java.awt.Color(237, 247, 250));
        foodTable.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        foodTable.setForeground(new java.awt.Color(45, 58, 84));
        foodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "FOOD"
            }
        ));
        jScrollPane2.setViewportView(foodTable);

        removeAllButton.setBackground(new java.awt.Color(108, 160, 209));
        removeAllButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        removeAllButton.setForeground(new java.awt.Color(255, 255, 255));
        removeAllButton.setText("<<");
        removeAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllButtonActionPerformed(evt);
            }
        });

        removeButton.setBackground(new java.awt.Color(108, 160, 209));
        removeButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        removeButton.setForeground(new java.awt.Color(255, 255, 255));
        removeButton.setText("<");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(108, 160, 209));
        addButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText(">");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        addAllButton.setBackground(new java.awt.Color(108, 160, 209));
        addAllButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        addAllButton.setForeground(new java.awt.Color(255, 255, 255));
        addAllButton.setText(">>");
        addAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAllButtonActionPerformed(evt);
            }
        });

        restaurantLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        restaurantLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        restaurantLabel.setText("Restaurant");

        restaurantComboBox.setBackground(new java.awt.Color(246, 252, 252));
        restaurantComboBox.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        restaurantComboBox.setForeground(new java.awt.Color(45, 58, 84));
        restaurantComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        chooseButton.setBackground(new java.awt.Color(108, 160, 209));
        chooseButton.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        chooseButton.setForeground(new java.awt.Color(255, 255, 255));
        chooseButton.setText("CHOOSE");
        chooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseButtonActionPerformed(evt);
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
        titleLabel.setText("Assign Food");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(562, 562, 562)
                        .addComponent(restaurantLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(restaurantComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(removeAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(536, Short.MAX_VALUE)
                        .addComponent(assignFoodButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(536, 536, 536))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(chooseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(620, 620, 620))
            .addGroup(layout.createSequentialGroup()
                .addGap(624, 624, 624)
                .addComponent(titleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restaurantComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restaurantLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(chooseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                        .addComponent(removeAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignFoodButton)
                    .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

        setTheme();

        Sort sort = new Sort();

        DefaultComboBoxModel restaurantComboBoxModel = (DefaultComboBoxModel) restaurantComboBox.getModel();

        refreshRestaurantComboBox(restaurantComboBoxModel); // refresh contents of the restaurant name combo box
        sort.sortComboBox(restaurantComboBoxModel);         // sort the contents of the restaurant name combo box alphabetically

        clearTables();      // clear contents of both the tables

    }//GEN-LAST:event_formWindowGainedFocus

    private void assignFoodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignFoodButtonActionPerformed

        RestaurantFoodLogic restaurantFoodLogic = new RestaurantFoodLogic();

        String restaurantName;

        DefaultTableModel selectedTableModel = (DefaultTableModel) selectedFoodTable.getModel();

        ArrayList<String> foodList = new ArrayList<>();

        restaurantName = restaurantComboBox.getSelectedItem().toString();

        for (int i = 0; i < selectedTableModel.getRowCount(); i++) {

            foodList.add(selectedTableModel.getValueAt(i, 0).toString());   // To get all the selected foods

        }

        if (restaurantFoodLogic.assignFood(restaurantName, foodList)) {

            JOptionPane.showMessageDialog(null, "Food assigned successfully!");

        }

    }//GEN-LAST:event_assignFoodButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed

        // Resets both the tables to the initial state
        Restaurant restaurant;
        RestaurantData restaurantData = new RestaurantData();

        DefaultTableModel foodTableModel = (DefaultTableModel) foodTable.getModel();
        DefaultTableModel selectedFoodTableModel = (DefaultTableModel) selectedFoodTable.getModel();

        String restaurantName;

        restaurantName = restaurantComboBox.getSelectedItem().toString();
        restaurant = restaurantData.getRestaurantDetails(restaurantName);

        refreshSelectedFoodTable(selectedFoodTableModel, restaurant.getRestaurantNo());

        if (selectedFoodTable.getRowCount() > 0) {

            refreshFoodTable(foodTableModel, selectedFoodTableModel);

        } else {

            refreshFoodTable(foodTableModel);

        }

    }//GEN-LAST:event_resetButtonActionPerformed

    private void chooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseButtonActionPerformed

        // Gets the restaurant name from the combo box and fills the tables accordingly
        Restaurant restaurant;
        RestaurantData restaurantData = new RestaurantData();

        DefaultTableModel foodTableModel = (DefaultTableModel) foodTable.getModel();
        DefaultTableModel selectedFoodTableModel = (DefaultTableModel) selectedFoodTable.getModel();

        String restaurantName;

        restaurantName = restaurantComboBox.getSelectedItem().toString();
        restaurant = restaurantData.getRestaurantDetails(restaurantName);

        refreshSelectedFoodTable(selectedFoodTableModel, restaurant.getRestaurantNo());

        if (selectedFoodTable.getRowCount() > 0) {

            refreshFoodTable(foodTableModel, selectedFoodTableModel);

        } else {

            refreshFoodTable(foodTableModel);

        }

    }//GEN-LAST:event_chooseButtonActionPerformed

    private void removeAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllButtonActionPerformed

        // Remove all the foods
        DefaultTableModel foodTableModel = (DefaultTableModel) foodTable.getModel();
        DefaultTableModel selectedFoodTableModel = (DefaultTableModel) selectedFoodTable.getModel();

        for (int i = 0; i < selectedFoodTableModel.getRowCount(); i++) {
            foodTableModel.addRow(new Object[]{selectedFoodTableModel.getValueAt(i, 0)});
        }

        while (selectedFoodTableModel.getRowCount() > 0) {
            selectedFoodTableModel.removeRow(0);
        }

    }//GEN-LAST:event_removeAllButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed

        // Remove the selected food
        DefaultTableModel foodTableModel = (DefaultTableModel) foodTable.getModel();
        DefaultTableModel selectedFoodTableModel = (DefaultTableModel) selectedFoodTable.getModel();

        String selectedFood;
        int selectedRow;

        selectedRow = selectedFoodTable.getSelectedRow();
        selectedFood = selectedFoodTable.getValueAt(selectedRow, 0).toString();

        foodTableModel.addRow(new Object[]{selectedFood});
        selectedFoodTableModel.removeRow(selectedRow);

    }//GEN-LAST:event_removeButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        // Add the selected food
        DefaultTableModel foodTableModel = (DefaultTableModel) foodTable.getModel();
        DefaultTableModel selectedFoodTableModel = (DefaultTableModel) selectedFoodTable.getModel();

        String selectedFood;
        int selectedRow;

        selectedRow = foodTable.getSelectedRow();
        selectedFood = foodTable.getValueAt(selectedRow, 0).toString();

        selectedFoodTableModel.addRow(new Object[]{selectedFood});
        foodTableModel.removeRow(selectedRow);

    }//GEN-LAST:event_addButtonActionPerformed

    private void addAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAllButtonActionPerformed

        // Add all the foods
        DefaultTableModel foodTableModel = (DefaultTableModel) foodTable.getModel();
        DefaultTableModel selectedFoodTableModel = (DefaultTableModel) selectedFoodTable.getModel();

        for (int i = 0; i < foodTableModel.getRowCount(); i++) {
            selectedFoodTableModel.addRow(new Object[]{foodTableModel.getValueAt(i, 0)});
        }

        while (foodTableModel.getRowCount() > 0) {
            foodTableModel.removeRow(0);
        }

    }//GEN-LAST:event_addAllButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed

        this.setVisible(false);
        new FoodnBeverageMenu().show();

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
            java.util.logging.Logger.getLogger(AssignFoodForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssignFoodForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssignFoodForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssignFoodForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssignFoodForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAllButton;
    private javax.swing.JButton addButton;
    private javax.swing.JButton assignFoodButton;
    private javax.swing.JButton chooseButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JTable foodTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeAllButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JComboBox<String> restaurantComboBox;
    private javax.swing.JLabel restaurantLabel;
    private javax.swing.JTable selectedFoodTable;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
