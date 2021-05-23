/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Bean.Food;
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
public class FoodData {

    /**
     * Get all foods and its details from the database
     *
     * @return List of all the foods and its details
     */
    public ArrayList<Food> getAllFoodDetails() {

        DBConnect dbConnect = new DBConnect();

        ArrayList<Food> foodList = new ArrayList<>();

        String query = "SELECT * FROM `food` order by `NAME`";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Food food = new Food();

                food.setNdbNo(rs.getInt("ndb_no"));
                food.setName(rs.getString("name"));
                food.setDescription(rs.getString("description"));
                food.setPrice(rs.getDouble("price"));

                foodList.add(food);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return foodList;

    }

    /**
     * Get details of a particular food
     *
     * @param name : Name of the food
     * @return Details of the food
     */
    public Food getFoodDetails(String name) {

        DBConnect dbConnect = new DBConnect();
        Food food = new Food();

        String query = "SELECT * FROM `food` where `name`='" + name + "'";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                food.setNdbNo(rs.getInt("ndb_no"));
                food.setName(rs.getString("name"));
                food.setDescription(rs.getString("description"));
                food.setPrice(rs.getDouble("price"));

            }

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return food;

    }

    /**
     * Get details of a particular food
     *
     * @param NDBNo : Unique identification number of food
     * @return Details of the food
     */
    public Food getFoodDetails(int NDBNo) {

        DBConnect dbConnect = new DBConnect();
        Food food = new Food();

        String query = "SELECT * FROM `food` where `ndb_no`='" + NDBNo + "'";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                food.setNdbNo(rs.getInt("ndb_no"));
                food.setName(rs.getString("name"));
                food.setDescription(rs.getString("description"));
                food.setPrice(rs.getDouble("price"));

            }

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return food;

    }

    /**
     * Get the next NDBNo
     *
     * Gets the last NDBNo from the database and adds 1 to it If there are no
     * food present in the database the new NDB No will be 1001
     *
     * @return next NDB No
     */
    public int getNewNDBNo() {

        DBConnect dbConnect = new DBConnect();

        int newNDBNo = 0, lastNDBNo = 0;
        String query = "SELECT `ndb_no` FROM FOOD ORDER BY `ndb_no` DESC LIMIT 1";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                lastNDBNo = rs.getInt("ndb_no");

            }

            if (lastNDBNo == 0) {
                newNDBNo = 1001;
            } else {
                newNDBNo = lastNDBNo + 1;
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return newNDBNo;

    }

    /**
     * To add a new food to the database
     *
     * @param food: food details
     * @return true if the insertion was successful and false otherwise
     */
    public boolean addNewFood(Food food) {

        DBConnect dbConnect = new DBConnect();

        String query = "INSERT INTO `food` (`ndb_no`, `name`, `description`, `price`) VALUES ('" + food.getNdbNo() + "', '" + food.getName() + "', '" + food.getDescription() + "', '" + food.getPrice() + "')";

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
     * Check if a food already exists in the database
     *
     * @param foodName: name of the food
     * @return true if food already exists and false otherwise
     */
    public boolean checkIfFoodExist(String foodName) {

        DBConnect dbConnect = new DBConnect();

        String query = "SELECT * FROM `food`";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                if (rs.getString("name").equalsIgnoreCase(foodName)) {
                    return true;
                }

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;

    }

    /**
     * Modify details of a food
     *
     * @param food: The updated properties
     * @param foodName: Old name
     * @return true if modification was successful and false otherwise
     */
    public boolean modifyFood(Food food, String foodName) {

        DBConnect dbConnect = new DBConnect();

        String query = "UPDATE `food` SET `name` = '" + food.getName() + "', `description` = '" + food.getDescription() + "', `price` = '" + food.getPrice() + "' WHERE `food`.`name` = '" + foodName + "'";

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
     * To remove a particular food from the database
     *
     * @param foodName: name of the food
     * @return true if removal was successful and false otherwise
     */
    public boolean removeFood(String foodName) {

        DBConnect dbConnect = new DBConnect();

        String query = "DELETE FROM `food` WHERE `food`.`name` = '" + foodName + "'";

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
