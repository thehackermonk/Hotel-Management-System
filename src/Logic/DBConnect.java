/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author thehackermonk
 */
public class DBConnect {

    /**
     * Create database connection
     *
     * @return database connection
     * @throws SQLException catches any exception by SQL connection creation
     * @throws IOException catches any exception by property read/write
     */
    public Connection getConnection() throws SQLException, IOException {

        GetProperty getProperty = new GetProperty();

        Connection conn = null;

        String connectionString = "jdbc:mysql://localhost:3306/" + getProperty.getDBProperty().getDatabase();
        String userName = getProperty.getDBProperty().getUserName();

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(connectionString, userName, "");

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        return conn;

    }

}
