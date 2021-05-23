/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Bean.FoodProduction;
import Logic.DBConnect;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author thehackermonk
 */
public class FoodProductionData {

    public ArrayList<FoodProduction> getFoodProducedToday(Date date) {

        DBConnect dbConnect = new DBConnect();

        String query = "SELECT * FROM `todays_food` WHERE `date`='" + date + "'";

        ArrayList<FoodProduction> foodProductionList = new ArrayList<>();

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                FoodProduction foodProduction = new FoodProduction();

                foodProduction.setRestaurantNo(rs.getInt("restaurant_no"));
                foodProduction.setFoodNo(rs.getInt("food"));
                foodProduction.setProductionDate(rs.getDate("date"));
                foodProduction.setCount(rs.getInt("quantity"));

                foodProductionList.add(foodProduction);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return foodProductionList;

    }

    public boolean clearTodaysFood(FoodProduction foodProduction) {

        DBConnect dbConnect = new DBConnect();

        String query = "DELETE FROM `todays_food` WHERE `restaurant_no`=" + foodProduction.getRestaurantNo() + " and `food`=" + foodProduction.getFoodNo();

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

    public boolean addTodaysFood(FoodProduction foodProduction) {

        DBConnect dbConnect = new DBConnect();

        String query = "INSERT INTO `todays_food` (`restaurant_no`, `food`, `date`, `quantity`) VALUES ('" + foodProduction.getRestaurantNo() + "', '" + foodProduction.getFoodNo() + "', '" + foodProduction.getProductionDate() + "', '" + foodProduction.getCount() + "')";

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
