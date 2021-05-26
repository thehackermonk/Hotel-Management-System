/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.OrderedFood;
import Bean.FoodProduction;
import DTO.FoodData;
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
public class OrderFoodLogic {

    public ArrayList<String> getAvailableFoods(int restaurantNo) {

        FoodData foodData = new FoodData();
        FoodProductionData foodProductionData = new FoodProductionData();

        ArrayList<String> foodList = new ArrayList<>();
        ArrayList<FoodProduction> foodProductionList;
        Iterator<FoodProduction> foodProductionListIterator;

        Date date = new Date(Calendar.getInstance().getTime().getTime());

        foodProductionList = foodProductionData.getFoodProducedToday(restaurantNo, date);
        foodProductionListIterator = foodProductionList.iterator();

        while (foodProductionListIterator.hasNext()) {

            FoodProduction foodProduction = foodProductionListIterator.next();

            String food = foodData.getFoodDetails(foodProduction.getFoodNo()).getName();

            foodList.add(food);

        }

        return foodList;

    }

    public int quantityProducedToday(int restaurantNo, int NDBNo) {

        FoodProductionData foodProductionData = new FoodProductionData();

        ArrayList<FoodProduction> foodProductionList;
        Iterator<FoodProduction> foodProductionListIterator;

        int quantity = 0;
        Date date = new Date(Calendar.getInstance().getTime().getTime());

        foodProductionList = foodProductionData.getFoodProducedToday(date);
        foodProductionListIterator = foodProductionList.iterator();

        while (foodProductionListIterator.hasNext()) {

            FoodProduction foodProduction = foodProductionListIterator.next();

            if ((restaurantNo == foodProduction.getRestaurantNo()) && (NDBNo == foodProduction.getFoodNo())) {

                quantity = foodProduction.getQuantity();

            }

        }

        return quantity;

    }

    public int quantityProducedToday(String restaurant, String food) {

        FoodData foodData = new FoodData();
        RestaurantData restaurantData = new RestaurantData();
        FoodProductionData foodProductionData = new FoodProductionData();

        ArrayList<FoodProduction> foodProductionList;
        Iterator<FoodProduction> foodProductionListIterator;

        int quantity = 0;
        Date date = new Date(Calendar.getInstance().getTime().getTime());

        foodProductionList = foodProductionData.getFoodProducedToday(date);
        foodProductionListIterator = foodProductionList.iterator();

        while (foodProductionListIterator.hasNext()) {

            FoodProduction foodProduction = foodProductionListIterator.next();

            if ((restaurantData.getRestaurantDetails(restaurant).getRestaurantNo() == foodProduction.getRestaurantNo()) && (foodData.getFoodDetails(food).getNdbNo() == foodProduction.getFoodNo())) {

                quantity = foodProduction.getQuantity();

            }

        }

        return quantity;

    }

    public boolean orderFood(int roomNo, String restaurant, ArrayList<OrderedFood> foodOrderList) {

        OrderFoodData orderFoodData = new OrderFoodData();
        RestaurantData restaurantData = new RestaurantData();

        String orderStatus;
        int orderNo, restaurantNo;

        Iterator<OrderedFood> foodOrderListIteraror;

        orderStatus = "Initiated";
        orderNo = orderFoodData.getNextOrderNo();
        restaurantNo = restaurantData.getRestaurantDetails(restaurant).getRestaurantNo();
        foodOrderListIteraror = foodOrderList.iterator();

        orderFoodData.orderFood(orderNo, roomNo, restaurantNo, orderStatus);

        while (foodOrderListIteraror.hasNext()) {

            OrderedFood foodOrder = foodOrderListIteraror.next();

            orderFoodData.addOrderedFood(orderNo, foodOrder.getFoodNo(), foodOrder.getQuantity());

        }

        return true;

    }

}
