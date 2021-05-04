/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Bean.Maintenance;
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
public class MaintenanceData {

    /**
     * Get all rooms which are under maintenance
     *
     * @return List of rooms which are under maintenance
     */
    public ArrayList<Maintenance> getAllRoomsUnderMaintenance() {

        DBConnect dbConnect = new DBConnect();

        ArrayList<Maintenance> maintenanceList = new ArrayList<>();

        String query = "select * from room_under_maintenance";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                Maintenance maintenance = new Maintenance();

                maintenance.setRoomNo(rs.getInt("room_no"));
                maintenance.setType(rs.getString("room_type"));
                maintenance.setMaintenanceType(rs.getString("maintenance_type"));
                maintenance.setMaintenanceDate(rs.getDate("date_of_maintenance"));
                maintenance.setComments(rs.getString("comments"));

                maintenanceList.add(maintenance);

            }

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return maintenanceList;

    }

    /**
     * Get details of particular room which is under maintenance
     *
     * @param roomNo
     * @return details of room which is under maintenance
     */
    public Maintenance getRoomDetails(int roomNo) {

        Maintenance maintenance = new Maintenance();
        DBConnect dbConnect = new DBConnect();

        String query = "select * from maintenance where room_no=" + roomNo + " and status=1;";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                maintenance.setMaintenanceType(rs.getString("type"));
                maintenance.setMaintenanceDate(rs.getDate("date_of_maintenance"));

            }

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return maintenance;

    }

    /**
     * Move room for maintenance
     *
     * @param maintenance
     * @return true if room has been moved to maintenance and false otherwise
     */
    public boolean addRoomForMaintenance(Maintenance maintenance) {

        DBConnect dbConnect = new DBConnect();

        int roomNo = maintenance.getRoomNo();
        String maintenanceType = maintenance.getMaintenanceType();
        Date maintenanceDate = maintenance.getMaintenanceDate();

        String insertQuery = "INSERT INTO `maintenance` (`maintenance_id`, `room_no`, `type`, `status`, `comments`, `date_of_maintenance`) VALUES (NULL, '" + roomNo + "', '" + maintenanceType + "', '1', NULL, '" + maintenanceDate + "')";
        String updateQuery = "UPDATE `rooms` SET `maintenance` = '1' WHERE `rooms`.`room_no` = " + roomNo;

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();

            if (stmt1.executeUpdate(insertQuery) == 1 && stmt2.executeUpdate(updateQuery) == 1) {

                return true;

            }

            stmt1.close();
            stmt2.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;

    }

    /**
     * Complete maintenance
     *
     * @param maintenance
     * @return true if maintenance has been completed and false otherwise
     */
    public boolean removeRoomFromMaintenance(Maintenance maintenance) {

        DBConnect dbConnect = new DBConnect();

        int roomNo = maintenance.getRoomNo();
        String comments = maintenance.getComments();

        String maintenanceQuery = "UPDATE `maintenance` SET `status` = '0', `comments` = '" + comments + "' WHERE `maintenance`.`room_no` = " + roomNo + " and `maintenance`.`status`=1";
        String roomQuery = "UPDATE `rooms` SET `maintenance` = '0' WHERE `rooms`.`room_no` = " + roomNo;

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();

            if (stmt1.executeUpdate(roomQuery) == 1 && stmt2.executeUpdate(maintenanceQuery) == 1) {

                return true;

            }

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;

    }

}
