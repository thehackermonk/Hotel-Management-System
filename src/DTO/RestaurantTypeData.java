/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Bean.RestaurantType;
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
public class RestaurantTypeData {

    /**
     * To get all types of restaurants
     *
     * @return List of restaurant types
     */
    public ArrayList<RestaurantType> getAllRestauarantTypes() {

        DBConnect dbConnect = new DBConnect();

        ArrayList<RestaurantType> restaurantTypeList = new ArrayList<>();
        String query = "SELECT * FROM `restaurant_type`";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                RestaurantType restaurantType = new RestaurantType();

                restaurantType.setType(rs.getString("type"));
                restaurantType.setDescription(rs.getString("description"));

                restaurantTypeList.add(restaurantType);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return restaurantTypeList;

    }

    /**
     * To get details of a particular restaurant type
     *
     * @param type: type of restaurant
     * @return details of restaurant type
     */
    public RestaurantType getRestaurantTypeDetails(String type) {

        DBConnect dbConnect = new DBConnect();

        RestaurantType restaurantType = new RestaurantType();

        String query = "SELECT * FROM `restaurant_type` WHERE `type`='" + type + "'";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                restaurantType.setType(rs.getString("type"));
                restaurantType.setDescription(rs.getString("description"));

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return restaurantType;

    }

    /**
     * To add a new restaurant type
     *
     * @param restaurantType: details of the new restaurant type
     * @return true if addition was successful and false otherwise
     */
    public boolean addRestaurantType(RestaurantType restaurantType) {

        DBConnect dbConnect = new DBConnect();

        String query = "INSERT INTO `restaurant_type` (`type`, `description`) VALUES ('" + restaurantType.getType() + "', '" + restaurantType.getDescription() + "')";

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
     * To remove a particular restaurant type
     *
     * @param type: type of restaurant
     * @return true if removal was successful and false otherwise
     */
    public boolean removeRestaurantType(String type) {

        DBConnect dbConnect = new DBConnect();

        String query = "DELETE FROM `restaurant_type` WHERE `type`='" + type + "'";

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
