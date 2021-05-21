/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author thehackermonk
 */
public class RestaurantFood {

    private int restaurantNo;   // Unique identification number of restaurant
    private int NDBNo;          // Unique identification number of food

    public int getRestaurantNo() {
        return restaurantNo;
    }

    public void setRestaurantNo(int restaurantNo) {
        this.restaurantNo = restaurantNo;
    }

    public int getNDBNo() {
        return NDBNo;
    }

    public void setNDBNo(int NDBNo) {
        this.NDBNo = NDBNo;
    }

}
