/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Bean.Restaurant;
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
public class RestaurantData {

    /**
     * Get details of all the restaurants
     *
     * @return list of all the restaurants
     */
    public ArrayList<Restaurant> getAllRestaurantDetails() {

        DBConnect dbConnect = new DBConnect();

        ArrayList<Restaurant> restaurantList = new ArrayList<>();

        String query = "SELECT * FROM `restaurant`";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Restaurant restaurant = new Restaurant();

                restaurant.setRestaurantNo(rs.getInt("restaurant_no"));
                restaurant.setName(rs.getString("name"));
                restaurant.setType(rs.getString("type"));

                restaurantList.add(restaurant);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return restaurantList;

    }

    /**
     * Get details of specific restaurant Search using name of the restaurant
     *
     * @param name: name of the restaurant
     * @return Restaurant details
     */
    public Restaurant getRestaurantDetails(String name) {

        DBConnect dbConnect = new DBConnect();
        Restaurant restaurant = new Restaurant();
        String query = "SELECT * FROM `restaurant` WHERE `name`='" + name + "'";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                restaurant.setRestaurantNo(rs.getInt("restaurant_no"));
                restaurant.setName(rs.getString("name"));
                restaurant.setType(rs.getString("type"));

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return restaurant;

    }

    /**
     * Get details of specific restaurant Search using restaurant no
     *
     * @param restaurantNo: unique identification no of the restaurant
     * @return Restaurant details
     */
    public Restaurant getRestaurantDetails(int restaurantNo) {

        DBConnect dbConnect = new DBConnect();
        Restaurant restaurant = new Restaurant();
        String query = "SELECT * FROM `restaurant` WHERE `restaurant_no`='" + restaurantNo + "'";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                restaurant.setRestaurantNo(rs.getInt("restaurant_no"));
                restaurant.setName(rs.getString("name"));
                restaurant.setType(rs.getString("type"));

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return restaurant;

    }

    /**
     * To add new restaurant to the database
     *
     * @param restaurant: details of the restaurant
     * @return true if addition was successful, and false otherwise
     */
    public boolean addNewRestaurant(Restaurant restaurant) {

        DBConnect dbConnect = new DBConnect();

        String query = "INSERT INTO `restaurant` (`name`, `type`) VALUES ('" + restaurant.getName() + "', '" + restaurant.getType() + "')";

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
     * To modify details of an existing restaurant
     *
     * @param restaurant: details of the restaurant
     * @param name: existing name
     * @return true if modification was successful and false otherwise
     */
    public boolean modifyRestaurant(Restaurant restaurant, String name) {

        DBConnect dbConnect = new DBConnect();

        String query = "UPDATE `restaurant` SET `name` = '" + restaurant.getName() + "', `type` = '" + restaurant.getType() + "' WHERE `restaurant`.`name` = '" + name + "'";

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
     * To remove a specific restaurant
     *
     * @param name: name of the restaurant
     * @return true if deletion was successful and false otherwise
     */
    public boolean removeRestaurant(String name) {

        DBConnect dbConnect = new DBConnect();

        String query = "DELETE FROM `restaurant` WHERE `restaurant`.`name` = '" + name + "'";

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
