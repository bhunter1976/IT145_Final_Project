/*
 * Final Project - Zoo Authentication and Authorization System
 */

package it145authenticationfinalproject;

/**
 *
 * @author brock
 */

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class IT145AuthenticationFinalProject {

    /**
     * @return 
     */
    
    //METHOD getUserInput()
    public static String getUserInput() {
        Scanner scnr = new Scanner(System.in);
        String userInput = "";
        //GET userInput
        userInput = scnr.nextLine();
        //RETURN userInput
        return userInput;
    }
        //METHOD checkCredentials()
    public static String checkCredentials(String userName, String hashedPassword) 
            throws FileNotFoundException, IOException {
        FileInputStream fileStream = null;
        Scanner fileIn = null;
        
        String fileLine = "";
        String userRole = "";
        
            //OPEN credentials file
            fileStream = new FileInputStream("credentials.txt");
            fileIn = new Scanner(fileStream);
            
            //WHILE credentials file has next line
            while (fileIn.hasNextLine()) {
		//READ credentials file line
                fileLine = fileIn.nextLine();
                    //IF userName and hashedPassword are contained in file line
                    if (fileLine.contains(userName) & (fileLine.contains(hashedPassword))) {
			//IF admin contained in file line
                        if (fileLine.contains("admin")) {
                            //SET user role to admin
                            userRole = "admin";
                            //RETURN userRole
                            return userRole;
                        }
			//ELSE IF zookeeper contained in file line
                        else if (fileLine.contains("zookeeper")) {
                            //SET user role to zookeeper
                            userRole = "zookeeper";
                            //RETURN user role
                            return userRole;
                        }
			//ELSE IF veterinarian contained in file line
                        else if (fileLine.contains("veterinarian")) {
                            //SET user role to veterinarian
                            userRole = "veterinarian";
                            //RETURN user role
                            return userRole;
                        }
                    }
                    //ELSE userName and hashedPassword are not contained in 
                    //file line
                    else {
                        //SET userRole to none
                        userRole = "none";
                        //CONTINUE
                        continue;
                    }
            }
            //CLOSE credentials file
            fileStream.close();
            //RETURN userValidCredentials value
            return userRole;
    }
        //METHOD outputUserRole()
    public static void outputUserRole(String userRole) throws FileNotFoundException, IOException {
        Scanner fileIn = null;
        FileInputStream fileStream = null;
        String fileLine = "";
        
        //SWITCH to display correct user role file
        switch (userRole) {
            case "admin":
                //OPEN admin file
                fileStream = new FileInputStream("admin.txt");
                fileIn = new Scanner(fileStream);
                //WHILE file has next line
                while (fileIn.hasNextLine()) {
                    //READ file line
                    fileLine = fileIn.nextLine();
                    //OUTPUT file line to console
                    System.out.println(fileLine);
                }
                //CLOSE admin file
                fileStream.close();
                //RETURN void
                return;
            case "zookeeper":
                //OPEN admin file
                fileStream = new FileInputStream("zookeeper.txt");
                fileIn = new Scanner(fileStream);
                //WHILE file has next line
                while (fileIn.hasNextLine()) {
                    //READ file line
                    fileLine = fileIn.nextLine();
                    //OUTPUT file line to console
                    System.out.println(fileLine);
                }
                //CLOSE admin file
                fileStream.close();
                //RETURN void
                return;
            case "veterinarian":
                //OPEN admin file
                fileStream = new FileInputStream("veterinarian.txt");
                fileIn = new Scanner(fileStream);
                //WHILE file has next line
                while (fileIn.hasNextLine()) {
                    //READ file line
                    fileLine = fileIn.nextLine();
                    //OUTPUT file line to console
                    System.out.println(fileLine);
                }
                //CLOSE admin file
                fileStream.close();
                //RETURN void
                return;
            default:
                break;
        }
    }
    
    public static void main(String[] args) throws NoSuchAlgorithmException, 
            FileNotFoundException, IOException {
        // TODO code application logic here
        //DEFINE variables
        int userAttempts            =   0;
        String userName             =   "userName";
        String userPassword         =   "userPassword";
        String userRole             =   "none";
        String userLogOut           =   "";
        boolean logOut              =   false;
        boolean validCredentials    = false;
        
        //NEW User Object
        User user = new User();
        
            //FOR userAttempts is 1, less than or equal to 3, AND validCredentials is false, +1
            for (userAttempts = 1; (userAttempts <= 3) & (!validCredentials); ++userAttempts) {
                //SET logout to false
                logOut = false;
                //OUTPUT welcome message
                System.out.println("\nWelcome to the city zoo.");
                //OUTPUT prompt for user name
                System.out.print("Please enter your user name or 'x' to quit: ");
                //CALL getUserInput() method and assign the value to User.setUserName()
                userName = getUserInput();
                //IF userInput equals x
                if (userName.equals("x") | (userName.equals("X"))) {
                    break;
                }
                user.setUserName(userName);
                //OUTPUT prompt for user password
                System.out.print("Please enter your password: ");
                //CALL getUserInput() method and assign the value to User.setUserPassword()
                userPassword = getUserInput();
                user.setUserPassword(userPassword);
                //CALL User.setHashedPassword() method
                user.setHashedPassword(userPassword);
                //CALL checkCredentials() method
                userRole = checkCredentials(user.getUserName(), 
                        user.getHashedPassword());
                user.setUserRole(userRole);
                    //IF user role is none
                    if (userRole.equals("none")) {
			//OUTPUT invalid login message
                        System.out.println("Invalid Username or Password");
                        //SET validCredentials to false
                        validCredentials = false;
                    }
                    //ELSE user role is not none;
                    else {
                        validCredentials = true;

			//WHILE logout is false
                        while (!logOut) {
                            //CALL outputUserRole() method
                            outputUserRole(user.getUserRole());
                            //OUTPUT prompt to log out
                            System.out.print("\nEnter x to log out. Any other value to refresh: ");
                            //CALL userInput() method and assign return value to logout
                            userLogOut = getUserInput();
				//IF logout is true
                                if (userLogOut.equals("x") | userLogOut.equals("X")) {
                                    //SET userAttempts to 1, logOut to true, UserValidCredentials to false
                                    logOut = true;
                                    userAttempts = 0;
                                    validCredentials = false;
                                    System.out.println("Logging out...\n");
                                    
                                }
				//ELSE logout is false
                                else {
                                    //CONTINUE
                                    continue;
                                }
                        }
                    }
            }
            //OUTPUT exit message
            System.out.println("Exiting...");
    }
    
}
