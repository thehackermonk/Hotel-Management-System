/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import DTO.FoodData;
import DTO.RestaurantData;
import DTO.RestaurantFoodData;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author thehackermonk
 */
public class RestaurantFoodLogic {

    /**
     * To assign food to particular restaurant
     *
     * Removes all the instances of restaurant from database and adds the new
     * ones
     *
     * @param restaurantName: name of the restaurant
     * @param foodList: list of food
     * @return true if assigning was successful and false otherwise
     */
    public boolean assignFood(String restaurantName, ArrayList<String> foodList) {

        FoodData foodData = new FoodData();
        RestaurantData restaurantData = new RestaurantData();
        RestaurantFoodData restaurantFoodData = new RestaurantFoodData();

        Iterator<String> foodListIterator = foodList.iterator();

        int restaurantNo, NDBNo;

        String name;

        restaurantNo = restaurantData.getRestaurantDetails(restaurantName).getRestaurantNo();

        restaurantFoodData.removeFood(restaurantNo);

        while (foodListIterator.hasNext()) {

            name = foodListIterator.next();
            NDBNo = foodData.getFoodDetails(name).getNdbNo();

            restaurantFoodData.assignFood(restaurantNo, NDBNo);

        }

        return true;

    }

}
