/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Bean.Foreigner;
import Bean.FrontOffice;
import Bean.Identity;
import Logic.DBConnect;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author thehackermonk
 */
public class FrontOfficeData {

    /**
     * Get the last entered Guest ID
     *
     * @return Last entered Guest ID
     */
    public int getLastGuestID() {

        DBConnect dbConnect = new DBConnect();

        int lastGuestID = 1;

        String query = "SELECT MAX(`guest_id`) from `guest`";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {

                lastGuestID = rs.getInt("MAX(`guest_id`)");

            }

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return lastGuestID;

    }

    /**
     * Check in for native guests
     *
     * @param identity
     * @param frontOffice
     * @return true if check in was successful and false otherwise
     */
    public boolean nativeCheckIn(Identity identity, FrontOffice frontOffice) {

        DBConnect dbConnect = new DBConnect();

        int lastGuestID = 0;

        String guestQuery, identityQuery, registerQuery;

        guestQuery = "INSERT INTO `guest` (`guest_id`, `name`, `address`, `telephone`, `foreigner`) VALUES (NULL, '" + identity.getName() + "', '" + identity.getAddress() + "', '" + identity.getTelephoneNo() + "', '0')";

        try {

            Connection conn = dbConnect.getConnection();
            Statement guestStmt = conn.createStatement();
            Statement identityStmt = conn.createStatement();
            Statement registerStmt = conn.createStatement();

            guestStmt.executeUpdate(guestQuery);
            lastGuestID = getLastGuestID();

            identityQuery = "INSERT INTO `identity` (`adhaar_no`, `guest_id`, `year_of_birth`) VALUES ('" + identity.getAdhaar_no() + "', '" + lastGuestID + "', '" + identity.getYearOfBirth() + "')";
            registerQuery = "INSERT INTO `guest_register` (`register_no`, `guest_id`, `check_in`, `check_out`, `room_no`, `no_of_persons`, `visiting_purpose`) VALUES (NULL, '" + lastGuestID + "', '" + frontOffice.getCheckIn() + "', NULL, '" + frontOffice.getRoomNo() + "', '" + frontOffice.getNoOfPersons() + "', '" + frontOffice.getVisitingPurpose() + "')";

            identityStmt.executeUpdate(identityQuery);
            registerStmt.executeUpdate(registerQuery);

            return true;

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;

    }

    /**
     * Check in for foreigners
     *
     * @param foreigner
     * @param frontOffice
     * @return true if check in was successful and false otherwise
     */
    public boolean foreignerCheckIn(Foreigner foreigner, FrontOffice frontOffice) {

        DBConnect dbConnect = new DBConnect();

        int lastGuestID = 0;

        String guestQuery, foreignerQuery, registerQuery;

        guestQuery = "INSERT INTO `guest` (`guest_id`, `name`, `address`, `telephone`, `foreigner`) VALUES (NULL, '" + foreigner.getName() + "', '" + foreigner.getAddress() + "', '" + foreigner.getTelephoneNo() + "', '0')";

        try {

            Connection conn = dbConnect.getConnection();
            Statement guestStmt = conn.createStatement();
            Statement foreignerStmt = conn.createStatement();
            Statement registerStmt = conn.createStatement();

            guestStmt.executeUpdate(guestQuery);
            lastGuestID = getLastGuestID();

            foreignerQuery = "INSERT INTO `foreigner` (`passport`, `guest_id`, `nationality`, `issue_date`) VALUES ('" + foreigner.getPassportNo() + "', '" + lastGuestID + "', '" + foreigner.getNationality() + "', '" + foreigner.getIssueDate() + "')";
            registerQuery = "INSERT INTO `guest_register` (`register_no`, `guest_id`, `check_in`, `check_out`, `room_no`, `no_of_persons`, `visiting_purpose`) VALUES (NULL, '" + lastGuestID + "', '" + frontOffice.getCheckIn() + "', NULL, '" + frontOffice.getRoomNo() + "', '" + frontOffice.getNoOfPersons() + "', '" + frontOffice.getVisitingPurpose() + "')";

            foreignerStmt.executeUpdate(foreignerQuery);
            registerStmt.executeUpdate(registerQuery);

            return true;

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;

    }

}
