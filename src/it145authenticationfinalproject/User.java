/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it145authenticationfinalproject;

/**
 *
 * @author brock
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//CLASS User
public class User {
        private String userName             = "userName";
        private String userPassword         = "userPassword";
        private String hashedPassword       = "hashedPassword";
        private String userRole             = "userRole";
        //private boolean validCredentials    = false;
    
    //CONSTRUCTOR
    public User() {
	//SET default object variables (userName, userPassword, hashedPassword,  
        //userRole, validCredentials)
        String userName             = "userName";
        String userPassword         = "userPassword";
        String hashedPassword       = "hashedPassword";
        String userRole             = "userRole";
        //boolean validCredentials    = false;
    }
    //getUserName() method
    public String getUserName() {
        //RETURNS user name
        return this.userName;
    }
    //setUserName() method
    public void setUserName(String userNameInput) {
        //SET user name
        this.userName = userNameInput;
    }
    //getUserPassword() method
    public String getUserPassword() {
        //RETURNS userPassword
        return this.userPassword;
    }
    //setUserPassword() method
    public void setUserPassword(String userPWInput) {
        //SET userPassword
        this.userPassword = userPWInput;
    }
    //getHashedPassword() method
    public String getHashedPassword() {
        //RETURNS hashedPassword
        return this.hashedPassword;
    }
    //setHashedPassword() method
    public void setHashedPassword(String userPWInput) throws NoSuchAlgorithmException {
        //SET hashedPassword [uses MD5 file contents]
        String original = userPWInput;  //Replace "password" with the actual password inputted by the user
	MessageDigest md = MessageDigest.getInstance("MD5");
	md.update(original.getBytes());
	byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
	for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
		}
        this.hashedPassword = sb.toString();
    }
    //getUserRole() method
    public String getUserRole() {
        //RETURNS userRole
        return this.userRole;
    }
    //setUserRole() method
    public void setUserRole(String userRoleInput) {
        //SET userRole
        this.userRole = userRoleInput;
    }
    //getUserValidCredentials() method
/*    public boolean getUserValidCredentials() {
        //RETURNS userValidCredentials value
        return this.validCredentials;
    }
    //setUserValidCredentials() method
    public void setUserValidCredentials(boolean validCredentialsValue) {
        //SET userValidCredentials value
        this.validCredentials = validCredentialsValue;
    }
*/
}
