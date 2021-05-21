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
public class Restaurant {

    private int restaurantNo;   // Unique number to identify the restaurant
    private String name;        // Name of the restaurant
    private String type;        // Type of the restaurant

    public int getRestaurantNo() {
        return restaurantNo;
    }

    public void setRestaurantNo(int restaurantNo) {
        this.restaurantNo = restaurantNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
