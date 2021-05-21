/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Bean.RestaurantFood;
import Logic.DBConnect;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author thehackermonk
 */
public class RestaurantFoodData {

    /**
     * To get food assigned to specific restaurant
     *
     * @param restaurantNo
     * @return
     */
    public ArrayList<RestaurantFood> getAssignedFood(int restaurantNo) {

        DBConnect dbConnect = new DBConnect();

        ArrayList<RestaurantFood> restaurantFoodList = new ArrayList<>();

        String query = "SELECT * FROM `restaurant_food` WHERE `restaurant_no`=" + restaurantNo;

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                RestaurantFood restaurantFood = new RestaurantFood();

                restaurantFood.setNDBNo(rs.getInt("restaurant_no"));
                restaurantFood.setNDBNo(rs.getInt("food"));

                restaurantFoodList.add(restaurantFood);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return restaurantFoodList;

    }

    /**
     * To assign food to restaurant
     *
     * @param restaurantNo: Unique identification number of restaurant
     * @param foodNo: Unique identification number of food
     * @return true if insertion was successful and false otherwise
     */
    public boolean assignFood(int restaurantNo, int foodNo) {

        DBConnect dbConnect = new DBConnect();

        String query = "INSERT INTO `restaurant_food` (`restaurant_no`, `food`) VALUES (" + restaurantNo + ", '" + foodNo + "')";

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

    /**
     * To un-assign food for particular restaurant
     *
     * @param restaurantNo: unique identification number of restaurant
     * @return true if removal was successful and false otherwise
     */
    public boolean removeFood(int restaurantNo) {

        DBConnect dbConnect = new DBConnect();

        String query = "DELETE FROM `restaurant_food` WHERE `restaurant_no`=" + restaurantNo;

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

}
