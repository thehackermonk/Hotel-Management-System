/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.sql.Date;

/**
 *
 * @author thehackermonk
 */
public class FoodProduction {

    int restaurantNo;
    int foodNo;
    Date productionDate;
    int quantity;

    public int getRestaurantNo() {
        return restaurantNo;
    }

    public void setRestaurantNo(int restaurantNo) {
        this.restaurantNo = restaurantNo;
    }

    public int getFoodNo() {
        return foodNo;
    }

    public void setFoodNo(int foodNo) {
        this.foodNo = foodNo;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
