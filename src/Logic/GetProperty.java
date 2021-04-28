/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.DBCredential;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author thehackermonk
 */

public class GetProperty {

    /**
     * Get database properties from the properties file
     * 
     * @return database name and user name
     * @throws IOException 
     */
    public DBCredential getDBProperty() throws IOException {

        DBCredential credential = new DBCredential();

        try {

            Properties property = new Properties();
            String propertyFileName = "hms/dbConfig.properties";

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);

            if (inputStream != null) {
                property.load(inputStream);
            } else {
                throw new FileNotFoundException("property file missing!");
            }

            credential.setUserName(property.getProperty("userName"));
            credential.setDatabase(property.getProperty("database"));

        } catch (IOException e) {

            System.out.println(e.getMessage());

        }

        return credential;

    }

}
