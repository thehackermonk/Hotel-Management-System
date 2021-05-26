/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

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
public class GuestInRoomData {

    public String getGuestInRoom(int roomNo) {

        DBConnect dbConnect = new DBConnect();

        String name = "", query;

        query = "SELECT `name` FROM `guest_in_room` WHERE `room_no`=" + roomNo;

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                name = rs.getString("name");

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return name;

    }

}
