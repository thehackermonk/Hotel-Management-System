/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.Login;
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
    public boolean checkLogin(Login login) throws NoSuchAlgorithmException {

        AuthenticationData authenticationData = new AuthenticationData();
        Hashing hashing = new Hashing();
        Login dbLogin = authenticationData.getPassword(login.getUserName());

        return dbLogin.getPassword().equals(hashing.encode(login.getPassword()));

    }

}
