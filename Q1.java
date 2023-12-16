
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wanab
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Variable
        String password;
        
        //User prompt
        System.out.println("Please enter your password");
        password = input.nextLine();
        
        //Output
        if (passwordValidation(password)){
            System.out.println("Valid password");
        }
        else {
            System.out.println("Invalid password");
        }
    }
    
    public static boolean passwordValidation(String password) {
        //Check length
        if (password.length() >= 8){
        } else {
            return false;
        }
        
        //Check for capital letter
        for (char c : password.toCharArray()){
            if (Character.isUpperCase(c)){
            } else {
                return false;
            }
        }
        
        //Check for small letter
        for (char c : password.toCharArray()){
            if (Character.isLowerCase(c)){
            } else {
                return false;
            }
        }
                
        //Check for 3 digits
       int numCount = 0;
        for (int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if (Character.isDigit(c)){
                numCount++;
            }
        }
        if (numCount >= 3){
        } else {
            return false;
        }
        
        //Check for special character
        Pattern specialChar = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = specialChar.matcher(password);
        int specialCharCount = 0;
        while (matcher.find()){
            specialCharCount++;
        }
        if (specialCharCount == 1){
        } else {
            return false;
        }
        
        //If all conditions are met
        return true;
    }
}
