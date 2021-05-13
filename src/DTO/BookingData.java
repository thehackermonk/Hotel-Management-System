/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Bean.Booking;
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
public class BookingData {

    public ArrayList<Booking> getAllBookingDetails() {

        DBConnect dbConnect = new DBConnect();

        ArrayList<Booking> bookingList = new ArrayList<>();

        String query = "SELECT * FROM booking order by booking_id";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Booking booking = new Booking();

                booking.setBookingID(rs.getInt("booking_id"));
                booking.setName(rs.getString("name"));
                booking.setContact(rs.getString("contact"));
                booking.setRoomNo(rs.getInt("room_no"));
                booking.setFromDate(rs.getDate("from_date").toLocalDate());
                booking.setToDate(rs.getDate("to_date").toLocalDate());
                booking.setPayment(rs.getFloat("payment"));

                bookingList.add(booking);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return bookingList;

    }

    /**
     * Get the last booking ID
     *
     * @return last booking ID
     */
    public int getLastBookingID() {

        DBConnect dbConnect = new DBConnect();
        int bookingID = 0;

        String query = "select booking_id from booking order by booking_id desc limit 1";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                bookingID = rs.getInt("booking_id");

                if (bookingID == 0) {
                    bookingID = 1;
                }

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return bookingID;

    }

    /**
     * To book a room
     *
     * @param booking
     * @return true if booking was successful and false otherwise
     */
    public boolean bookRoom(Booking booking) {

        DBConnect dbConnect = new DBConnect();

        String query = "INSERT INTO `booking` (`name`, `contact`, `room_no`, `from_date`, `to_date`, `payment`) VALUES ('" + booking.getName() + "', '" + booking.getContact() + "', " + booking.getRoomNo() + ", '" + booking.getFromDate() + "', '" + booking.getToDate() + "','" + booking.getPayment() + "')";
        System.out.println(query);

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();

            if (stmt.execute(query)) {

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
     * Get booking details of particular room
     *
     * @param roomNo
     * @return booking details
     */
    public ArrayList<Booking> bookingDetails(int roomNo) {

        DBConnect dbConnect = new DBConnect();

        ArrayList<Booking> bookingList = new ArrayList<>();

        String query = "SELECT * FROM booking WHERE room_no=" + roomNo;

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Booking booking = new Booking();

                booking.setBookingID(rs.getInt("booking_id"));
                booking.setName(rs.getString("name"));
                booking.setContact(rs.getString("contact"));
                booking.setRoomNo(rs.getInt("room_no"));
                booking.setFromDate(rs.getDate("from_date").toLocalDate());
                booking.setToDate(rs.getDate("to_date").toLocalDate());
                booking.setPayment(rs.getFloat("payment"));

                bookingList.add(booking);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return bookingList;

    }

    /**
     * Search bookings by name and contact
     *
     * @param name
     * @param contact
     * @return List of bookings
     */
    public ArrayList<Booking> searchBookings(String name, String contact) {

        DBConnect dbConnect = new DBConnect();

        ArrayList<Booking> bookingList = new ArrayList<>();

        String query = "SELECT * FROM booking WHERE name like '%" + name + "%' and contact like '%" + contact + "%'";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Booking booking = new Booking();

                booking.setBookingID(rs.getInt("booking_id"));
                booking.setName(rs.getString("name"));
                booking.setContact(rs.getString("contact"));
                booking.setRoomNo(rs.getInt("room_no"));
                booking.setFromDate(rs.getDate("from_date").toLocalDate());
                booking.setToDate(rs.getDate("to_date").toLocalDate());
                booking.setPayment(rs.getFloat("payment"));

                bookingList.add(booking);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return bookingList;

    }

    /**
     * To delete a particular booking
     *
     * @param bookingNo
     * @return true if the deletion was successful and false otherwise
     */
    public boolean deleteBooking(int bookingNo) {

        DBConnect dbConnect = new DBConnect();

        String query = "DELETE FROM booking WHERE booking_id=" + bookingNo;

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
