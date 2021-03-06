/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.Credential;
import DTO.AuthenticationData;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author thehackermonk
 */
public class Authentication {

    /**
     * For user authentication
     *
     * @param login - user ID and password entered by user
     * @return true if authentication is successful, false otherwise
     * @throws NoSuchAlgorithmException
     */
    public boolean checkLogin(Credential login) throws NoSuchAlgorithmException {

        AuthenticationData authenticationData = new AuthenticationData();
        Hashing hashing = new Hashing();
        Credential dbLogin = authenticationData.getPassword(login.getUserName());

        return dbLogin.getPassword().equals(hashing.encode(login.getPassword()));

    }

    public String changePassword(Credential login, String newPassword) throws NoSuchAlgorithmException {

        AuthenticationData authenticationData = new AuthenticationData();
        Hashing hashing = new Hashing();

        String errorMessage = null, hashedPassword;

        if (checkLogin(login)) {

            hashedPassword = hashing.encode(newPassword);

            if (authenticationData.changePassword(login.getUserName(), hashedPassword)) {

                errorMessage = null;

            } else {

                errorMessage = "Unable to change password!";

            }

        } else {

            errorMessage = "Incorrect credentials!";

        }

        return errorMessage;

    }

}
