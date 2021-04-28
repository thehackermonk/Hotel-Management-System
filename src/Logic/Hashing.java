/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author thehackermonk
 */
public class Hashing {

    /**
     * hash the string using SHA-256 algorithm
     *
     * @param originalString
     * @return hashed string in byte []
     * @throws NoSuchAlgorithmException
     */
    private byte[] hash(String originalString) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));

        return encodedHash;

    }

    /**
     * Convert byte[] to string
     *
     * @param hash
     * @return string value
     */
    private static String bytesToHex(byte[] hash) {

        StringBuilder hexString = new StringBuilder(2 * hash.length);

        for (int i = 0; i < hash.length; i++) {

            String hex = Integer.toHexString(0xff & hash[i]);

            if (hex.length() == 1) {
                hexString.append('0');
            }

            hexString.append(hex);

        }

        return hexString.toString();

    }

    /**
     * Hashing string with salt
     *
     * @param originalString
     * @return hashed value
     * @throws NoSuchAlgorithmException
     */
    public String encode(String originalString) throws NoSuchAlgorithmException {

        String salt = "hotel";

        String saltedString = salt + originalString + salt;

        return (bytesToHex(hash(saltedString)));

    }

}
