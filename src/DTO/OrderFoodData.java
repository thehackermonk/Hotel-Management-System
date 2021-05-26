/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Bean.FoodOrder;
import Bean.OrderedFood;
import Bean.RestaurantWithFood;
import Logic.DBConnect;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thehackermonk
 */
public class OrderFoodData {

    public ArrayList<FoodOrder> getAllOrders() {

        DBConnect dbConnect = new DBConnect();

        ArrayList<FoodOrder> foodOrderList = new ArrayList<>();

        String query = "SELECT * FROM `food_order`";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                FoodOrder foodOrder = new FoodOrder();

                foodOrder.setOrderNo(rs.getInt("order_no"));
                foodOrder.setRoomNo(rs.getInt("room_no"));
                foodOrder.setRestaurantNo(rs.getInt("restaurant_no"));
                foodOrder.setStatus(rs.getString("status"));

                foodOrderList.add(foodOrder);

            }

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return foodOrderList;

    }

    public int getNextOrderNo() {

        DBConnect dbConnect = new DBConnect();

        String query = "SELECT `order_no` FROM `food_order` ORDER BY `order_no` DESC LIMIT 1";
        int orderNo = 0;

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                orderNo = rs.getInt("order_no");
            }

            if (orderNo <= 0) {
                orderNo = 1;
            } else {
                orderNo += 1;
            }

        } catch (IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return orderNo;

    }

    public ArrayList<RestaurantWithFood> getRestaurantWithFood() {

        DBConnect dbConnect = new DBConnect();

        ArrayList<RestaurantWithFood> restaurantWithFoodList = new ArrayList<>();

        String query = "SELECT * FROM `restaurant_with_food`";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                RestaurantWithFood restaurantWithFood = new RestaurantWithFood();

                restaurantWithFood.setRestaurantNo(rs.getInt("restaurant_no"));
                restaurantWithFood.setRestaurantName(rs.getString("name"));
                restaurantWithFood.setRestaurantType(rs.getString("type"));
                restaurantWithFood.setFood(rs.getInt("food"));
                restaurantWithFood.setDate(rs.getDate("date"));
                restaurantWithFood.setQuantity(rs.getInt("quantity"));

                restaurantWithFoodList.add(restaurantWithFood);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return restaurantWithFoodList;

    }

    public ArrayList<OrderedFood> getOrderDetails(int orderNo) {

        DBConnect dbConnect = new DBConnect();

        ArrayList<OrderedFood> orderedFoodList = new ArrayList<>();

        String query = "SELECT * FROM `ordered_food` WHERE `order_no`=" + orderNo;

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                OrderedFood orderedFood = new OrderedFood();

                orderedFood.setFoodNo(rs.getInt("food"));
                orderedFood.setQuantity(rs.getInt("quantity"));

                orderedFoodList.add(orderedFood);

            }

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return orderedFoodList;

    }

    public boolean orderFood(int orderNo, int roomNo, int restaurantNo, String orderStatus) {

        DBConnect dbConnect = new DBConnect();

        String query = "INSERT INTO `food_order` (`order_no`, `room_no`, `restaurant_no`, `status`) VALUES (" + orderNo + ", " + roomNo + ", " + restaurantNo + ", '" + orderStatus + "')";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();

            if (stmt.executeUpdate(query) == 1) {
                return true;
            }

            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;

    }

    public boolean addOrderedFood(int orderNo, int NDBNo, int quantity) {

        DBConnect dbConnect = new DBConnect();

        String query = "INSERT INTO `ordered_food` (`order_no`, `food`, `quantity`) VALUES (" + orderNo + ", " + NDBNo + ", " + quantity + ")";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();

            if (stmt.executeUpdate(query) == 1) {
                return true;
            }

            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;

    }
    
    public boolean completeOrder(int roomNo,int restaurantNo) {
        
        DBConnect dbConnect=new DBConnect();
        
        String query="UPDATE `food_order` SET `status` = 'Completed' WHERE `room_no`="+roomNo+" AND `restaurant_no`="+restaurantNo;
        
        try{
            
            Connection conn=dbConnect.getConnection();
            Statement stmt=conn.createStatement();
            
            if(stmt.executeUpdate(query)==1)
                return true;
            
        } catch(IOException | SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
        
    }

}
