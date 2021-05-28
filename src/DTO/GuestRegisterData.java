/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Bean.GuestRegister;
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
public class GuestRegisterData {

    /**
     * Get list of all the rooms which are currently occupied
     * 
     * @return List of rooms
     */
    public ArrayList<GuestRegister> getOccupiedRooms() {

        DBConnect dbConnect = new DBConnect();

        ArrayList<GuestRegister> guestRegisterList = new ArrayList<>();

        String query = "SELECT * FROM `guest_register` WHERE `check_out` IS NULL";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                GuestRegister guestRegister = new GuestRegister();

                guestRegister.setGuestID(rs.getInt("guest_id"));
                guestRegister.setCheckInDate(rs.getDate("check_in"));
                guestRegister.setRoomNo(rs.getInt("room_no"));
                guestRegister.setNoOfPersons(rs.getInt("no_of_persons"));

                guestRegisterList.add(guestRegister);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return guestRegisterList;

    }

    /**
     * Get details of guest who is staying in a particular room
     * 
     * @param roomNo
     * @return Details of guest
     */
    public GuestRegister getGuestDetails(int roomNo) {

        DBConnect dbConnect = new DBConnect();

        GuestRegister guestRegister = new GuestRegister();

        String query = "SELECT r.register_no,g.name,g.address,g.telephone,r.check_in,r.check_out,r.room_no FROM guest g, guest_register r WHERE r.room_no=" + roomNo + " AND g.guest_id=r.guest_id";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                guestRegister.setRegisterNo(rs.getInt("register_no"));
                guestRegister.setName(rs.getString("name"));
                guestRegister.setAddress(rs.getString("address"));
                guestRegister.setTelephoneNo(rs.getString("telephone"));
                guestRegister.setCheckInDate(rs.getDate("check_in"));
                guestRegister.setCheckOutDate(rs.getDate("check_out"));
                guestRegister.setRoomNo(rs.getInt("room_no"));

            }

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return guestRegister;

    }

    /**
     * To check out of the hotel
     * Function adds a check out date to the guest register
     * 
     * @param roomNo
     * @param checkInDate
     * @param checkOutDate
     * @return true if check out was successful and false otherwise
     */
    public boolean checkOut(int roomNo, Date checkInDate, Date checkOutDate) {

        DBConnect dbConnect = new DBConnect();

        String query = "UPDATE `guest_register` SET `check_out`='" + checkOutDate + "' WHERE `check_in`='" + checkInDate + "' AND `room_no`=" + roomNo;

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
