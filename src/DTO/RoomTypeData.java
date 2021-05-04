/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Bean.RoomType;
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
public class RoomTypeData {

    /**
     * Get room types and its prices from database
     *
     * @return List of room-types and its prices
     */
    public ArrayList<RoomType> getAllRoomTypeDetails() {

        DBConnect dbConnect = new DBConnect();

        ArrayList<RoomType> roomTypeList = new ArrayList<>();

        String query = "select * from roomtype";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                RoomType roomType = new RoomType();
                roomType.setType(rs.getString("type"));
                roomType.setPrice(rs.getFloat("price"));
                roomType.setCapacity(rs.getInt("capacity"));

                roomTypeList.add(roomType);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return roomTypeList;

    }

    /**
     * Get detail of particular room-type
     *
     * @param type Type of room
     * @return Details of the particular type of room
     */
    public RoomType getRoomTypeDetails(String type) {

        DBConnect dbConnect = new DBConnect();
        RoomType roomType = new RoomType();

        String query = "select * from roomtype where type='" + type + "'";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                roomType.setType(rs.getString("type"));
                roomType.setPrice(rs.getFloat("price"));
                roomType.setCapacity(rs.getInt("capacity"));

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return roomType;

    }

    /**
     * Get no of people who can stay in a particular type of room
     * 
     * @param roomType Type of room
     * @return No of people who can stay
     */
    public int getRoomCapacity(String roomType) {

        DBConnect dbConnect = new DBConnect();
        int capacity = 0;

        String query = "select capacity from roomtype where type='" + roomType+"'";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {

                capacity = rs.getInt("capacity");

            }

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return capacity;

    }

    /**
     * To add new type of room
     *
     * @param roomType new type of room and its price
     * @return true if room-type added successfully and false otherwise
     */
    public boolean addRoomType(RoomType roomType) {

        DBConnect dbConnect = new DBConnect();

        String query = "INSERT INTO `roomtype` (`type`, `price`,`capacity`) VALUES ('" + roomType.getType() + "', '" + roomType.getPrice() + "', '" + roomType.getCapacity() + "')";

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
     * Update details of particular room-type
     *
     * @param type Type of room
     * @param roomType updated values for room-type and price
     * @return true if updation was successful and false otherwise
     */
    public boolean updateRoomType(String type, RoomType roomType) {

        DBConnect dbConnect = new DBConnect();

        String query = "UPDATE `roomtype` SET `type` = '" + roomType.getType() + "', `price` = '" + roomType.getPrice() + "', `capacity` = " + roomType.getCapacity() + " WHERE `roomtype`.`type` = '" + type + "'";

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
     * Remove particular type of room
     *
     * @param type Type of room which needs to be deleted
     * @return true if deletion was successful and false otherwise
     */
    public boolean removeRoomType(String type) {

        DBConnect dbConnect = new DBConnect();

        String query = "DELETE FROM `roomtype` WHERE `roomtype`.`type` = '" + type + "'";

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
