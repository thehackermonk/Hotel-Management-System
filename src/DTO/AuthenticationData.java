/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Bean.Credential;
import Logic.DBConnect;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thehackermonk
 */
public class AuthenticationData {

    /**
     * Get password from database
     *
     * @param userID entered by the user
     * @return userID and password fetched from the database
     */
    public Credential getPassword(String userID) {

        DBConnect dbConnect = new DBConnect();
        Credential login = new Credential();

        String query = "SELECT * FROM `auth` WHERE `login`='" + userID + "'";

        try {

            Connection conn = dbConnect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                login.setUserName(rs.getString("login"));
                login.setPassword(rs.getString("password"));

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException | IOException ex) {
            Logger.getLogger(AuthenticationData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return login;

    }

}
