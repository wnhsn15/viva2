
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
        if (password.length() < 8){
            return false;
        }
        
        //Check for capital letter
        if (!containsCapital(password)){
            return false;
        }
        
        //Check for small letter
        if (!containsSmall(password)){
            return false;
        }
        
        //Check for 3 digits
        if (!containsDigit(password)){
            return false;
        }
        
        //Check for special character
        if (!containsSpecial(password)){
            return false;
        }
        
        //If all conditions are met
        return true;
    }

    private static boolean containsCapital(String password) {
        for (char c : password.toCharArray()){
            if (Character.isUpperCase(c)){
                return true;
            }
        }
        return false;
    }

    private static boolean containsSmall(String password) {
        for (char c : password.toCharArray()){
            if (Character.isLowerCase(c)){
                return true;
            }
        }
        return false;
    }

    private static boolean containsDigit(String password) {
        int numCount = 0;
        for (int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if (Character.isDigit(c)){
                numCount++;
            }
        }
        return numCount >= 3;
    }

    private static boolean containsSpecial(String password) {
        Pattern specialChar = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = specialChar.matcher(password);
        int specialCharCount = 0;
        while (matcher.find()){
            specialCharCount++;
        }
        return specialCharCount == 1;
    }
}
