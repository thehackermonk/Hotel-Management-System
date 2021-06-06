/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Color;

/**
 *
 * @author thehackermonk
 */
public class FoodnBeverageMenu extends javax.swing.JFrame {

    /**
     * Creates new form FoodnBeverageMenu
     */
    public FoodnBeverageMenu() {
        initComponents();
    }
    
    /**
     * Set theme of the form
     */
    public void setTheme() {

        this.getContentPane().setBackground(new Color(246, 252, 252));

        titleLabel.setForeground(new Color(45, 58, 84));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        foodOrdersButton = new javax.swing.JButton();
        restaurantButton = new javax.swing.JButton();
        restaurantTypeButton = new javax.swing.JButton();
        foodButton = new javax.swing.JButton();
        assignFoodButton = new javax.swing.JButton();
        foodProductionButton = new javax.swing.JButton();
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

        foodOrdersButton.setBackground(new java.awt.Color(36, 53, 69));
        foodOrdersButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        foodOrdersButton.setForeground(new java.awt.Color(255, 255, 255));
        foodOrdersButton.setText("FOOD ORDERS");
        foodOrdersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodOrdersButtonActionPerformed(evt);
            }
        });

        restaurantButton.setBackground(new java.awt.Color(36, 53, 69));
        restaurantButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        restaurantButton.setForeground(new java.awt.Color(255, 255, 255));
        restaurantButton.setText("RESTARUANT");
        restaurantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurantButtonActionPerformed(evt);
            }
        });

        restaurantTypeButton.setBackground(new java.awt.Color(36, 53, 69));
        restaurantTypeButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        restaurantTypeButton.setForeground(new java.awt.Color(255, 255, 255));
        restaurantTypeButton.setText("RESTAURANT TYPE");
        restaurantTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurantTypeButtonActionPerformed(evt);
            }
        });

        foodButton.setBackground(new java.awt.Color(36, 53, 69));
        foodButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        foodButton.setForeground(new java.awt.Color(255, 255, 255));
        foodButton.setText("FOOD");
        foodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodButtonActionPerformed(evt);
            }
        });

        assignFoodButton.setBackground(new java.awt.Color(36, 53, 69));
        assignFoodButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        assignFoodButton.setForeground(new java.awt.Color(255, 255, 255));
        assignFoodButton.setText("ASSIGN FOOD");
        assignFoodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignFoodButtonActionPerformed(evt);
            }
        });

        foodProductionButton.setBackground(new java.awt.Color(36, 53, 69));
        foodProductionButton.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        foodProductionButton.setForeground(new java.awt.Color(255, 255, 255));
        foodProductionButton.setText("PRODUCE FOOD");
        foodProductionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodProductionButtonActionPerformed(evt);
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

        titleLabel.setFont(new java.awt.Font("Calibri", 0, 28)); // NOI18N
        titleLabel.setText("Food & Beverages");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(foodProductionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(foodOrdersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(restaurantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(restaurantTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(foodButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(assignFoodButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(580, 580, 580)
                .addComponent(titleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(foodOrdersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restaurantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restaurantTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(foodButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assignFoodButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addComponent(foodProductionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void foodOrdersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodOrdersButtonActionPerformed

        this.setVisible(false);
        new OrderedFoodForm().show();

    }//GEN-LAST:event_foodOrdersButtonActionPerformed

    private void restaurantButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurantButtonActionPerformed

        this.setVisible(false);
        new RestaurantForm().show();

    }//GEN-LAST:event_restaurantButtonActionPerformed

    private void restaurantTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurantTypeButtonActionPerformed

        this.setVisible(false);
        new RestaurantTypeForm().show();

    }//GEN-LAST:event_restaurantTypeButtonActionPerformed

    private void foodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodButtonActionPerformed

        this.setVisible(false);
        new FoodForm().show();

    }//GEN-LAST:event_foodButtonActionPerformed

    private void assignFoodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignFoodButtonActionPerformed

        this.setVisible(false);
        new AssignFoodForm().show();

    }//GEN-LAST:event_assignFoodButtonActionPerformed

    private void foodProductionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodProductionButtonActionPerformed
        
        this.setVisible(false);
        new FoodProductionForm().show();
        
    }//GEN-LAST:event_foodProductionButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        
        this.setVisible(false);
        new MainMenu().show();
        
    }//GEN-LAST:event_closeButtonActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        
        setTheme();
        
    }//GEN-LAST:event_formWindowGainedFocus

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
            java.util.logging.Logger.getLogger(FoodnBeverageMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FoodnBeverageMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FoodnBeverageMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FoodnBeverageMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FoodnBeverageMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignFoodButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton foodButton;
    private javax.swing.JButton foodOrdersButton;
    private javax.swing.JButton foodProductionButton;
    private javax.swing.JButton restaurantButton;
    private javax.swing.JButton restaurantTypeButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
