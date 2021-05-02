/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Bean.Room;
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
public class RoomsData {

    public ArrayList<Room> getAllRoomDetails() {

        DBConnect dbConnect = new DBConnect();

        ArrayList<Room> roomList = new ArrayList<>();

        String query = "select * from rooms";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Room room = new Room();

                room.setRoomNo(rs.getInt("room_no"));
                room.setType(rs.getString("type"));
                room.setRoomStatus(rs.getString("status"));
                room.setUnderMaintenance(rs.getBoolean("maintenance"));

                roomList.add(room);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return roomList;

    }

    public int getNewRoomNo() {

        DBConnect dbConnect = new DBConnect();

        int roomNo = 0;
        String query = "select room_no from rooms order by room_no desc limit 1";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                roomNo = rs.getInt("room_no");

            }
            roomNo += 1;

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return roomNo;

    }

    public Room getRoomDetails(int roomNo) {

        Room room = new Room();
        DBConnect dbConnect = new DBConnect();

        String query = "select * from rooms where room_no=" + roomNo;

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                room.setRoomNo(rs.getInt("room_no"));
                room.setType(rs.getString("type"));
                room.setRoomStatus(rs.getString("status"));
                room.setUnderMaintenance(rs.getBoolean("maintenance"));

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return room;

    }

    public boolean addRoom(Room room) {

        DBConnect dbConnect = new DBConnect();

        String query = "INSERT INTO `rooms` (`room_no`, `type`, `status`, `maintenance`) VALUES ('" + room.getRoomNo() + "', '" + room.getType() + "', '" + room.getRoomStatus() + "', " + room.isUnderMaintenance() + ")";

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

    public boolean modifyRoomType(Room room, int roomNo) {

        DBConnect dbConnect = new DBConnect();

        String query = "UPDATE `rooms` SET `type` = '" + room.getType() + "' WHERE `rooms`.`room_no` = " + roomNo;
        //System.out.println(query);

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();

            if (stmt.executeUpdate(query) == 1) {

                return true;

            }

        } catch (IOException | SQLException e) {

            System.out.println(e.getMessage());

        }

        return false;

    }

    public boolean removeRoom(int roomNo) {

        DBConnect dbConnect = new DBConnect();

        String query = "DELETE FROM `rooms` WHERE `rooms`.`room_no` = " + roomNo;

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();

            if (stmt.executeUpdate(query) == 1) {

                return true;

            }

        } catch (IOException | SQLException e) {

            System.out.println(e.getMessage());

        }

        return false;

    }

}
