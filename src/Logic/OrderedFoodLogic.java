/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.FoodProduction;
import DTO.FoodProductionData;
import DTO.OrderFoodData;
import DTO.RestaurantData;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

/**
 *
 * @author thehackermonk
 */
public class OrderedFoodLogic {

    public boolean completeOrder(String restaurant, int roomNo, ArrayList<FoodProduction> foodProductionList) {

        OrderFoodData orderFoodData = new OrderFoodData();
        FoodProductionData foodProductionData = new FoodProductionData();
        RestaurantData restaurantData = new RestaurantData();

        int restaurantNo, quantity;

        Iterator<FoodProduction> foodProductionListIterator;

        restaurantNo = restaurantData.getRestaurantDetails(restaurant).getRestaurantNo();

        foodProductionListIterator = foodProductionList.iterator();

        while (foodProductionListIterator.hasNext()) {

            FoodProduction foodProduction = foodProductionListIterator.next();

            foodProduction.setRestaurantNo(restaurantNo);

            quantity = quantityProducedToday(restaurantNo, foodProduction.getFoodNo());
            foodProduction.setQuantity(quantity - foodProduction.getQuantity());

            foodProductionData.buyFood(foodProduction);

        }

        orderFoodData.completeOrder(roomNo, restaurantNo);

        return true;

    }

    public int quantityProducedToday(int restaurantNo, int foodNo) {

        FoodProductionData foodProductionData = new FoodProductionData();

        int quantity = 0;
        Date date = new Date(Calendar.getInstance().getTime().getTime());

        ArrayList<FoodProduction> foodProductionList = foodProductionData.getFoodProducedToday(restaurantNo, date);
        Iterator<FoodProduction> foodProductionListIterator = foodProductionList.iterator();

        while (foodProductionListIterator.hasNext()) {

            FoodProduction foodProduction = foodProductionListIterator.next();

            if (foodProduction.getFoodNo() == foodNo) {
                quantity = foodProduction.getQuantity();
            }

        }

        return quantity;

    }

}
