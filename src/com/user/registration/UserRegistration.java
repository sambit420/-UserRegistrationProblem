//UC - 1 is to As a User need to enter a valid First Name. (First name starts with Cap and has minimum 3 characters)
//UC - 2 is to As a User need to enter a valid Last Name. (Last name starts with Cap and has minimum 3 characters)
//UC - 3 is to As a User need to enter a valid email. (E.g. abc.xyz@bl.co.in - Email has 3 mandatory parts (abc, bl & co)
//            and 2 optional (xyz & in) with precise @ and . positions)
//UC - 4 is to As a User need to follow pre-defined Mobile Format. (Mobile Format - E.g. 91 9919819801 -
//            Country code follow by space and 10-digit number)
//UC - 5 is to As a User need to follow pre-defined Password rules.
//      (Rule 1 – minimum 8 Characters)
//      (Rule 2 – Should have at least 1 Upper Case)
//      (Rule 3 - Should have at least 1 numeric number in the password)
//      (Rule 4 - Has exactly 1 Special Character)

package com.user.registration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the User's First Name");
        String firstName = scan.nextLine();
        System.out.println("Enter the User's Last Name");
        String lastName = scan.nextLine();
        System.out.println("Enter the User's email id");
        String emailID = scan.nextLine();
        System.out.println("Enter the User's mobile no");
        String mobileNo = scan.nextLine();
        System.out.println("Enter the User's password");
        String password = scan.nextLine();
        System.out.println("Given first name : " + firstName + " is valid : " + validName(firstName));
        System.out.println("Given last name : " + lastName + " is valid : " + validName(lastName));
        System.out.println("Given email id : " + emailID + " is valid : " + validEmail(emailID));
        System.out.println("Given mobile no : " + mobileNo + " is valid : " + validPhoneNo(mobileNo));
        System.out.println("Given password : " + password + " is valid : " + validPassword(password));
    }

    // Method to check username
    public static boolean validName(String name) {
        boolean flag = false;
        String regex = "^[A-Z][a-z]{3,}$";      // {3,} means above 3 char name
        Pattern pattern = Pattern.compile(regex);
        for(int i = 0; i < name.length(); i++)
        {
            Matcher matcher=pattern.matcher(name);
            flag = matcher.matches();
        }
        return flag;
    }

    // Method to check email id
    public static boolean validEmail(String id) {
        boolean flag = false;
        String regex = "^[a-z0-9+_.-]+@+[a-z]+.+[a-z]+.+[a-z]$";
        Pattern pattern = Pattern.compile(regex);
        for(int i = 0; i < id.length(); i++)
        {
            Matcher matcher=pattern.matcher(id);
            flag = matcher.matches();
        }
        return flag;
    }

    // Method to check mobile
    public static boolean validPhoneNo(String phoneNo) {
        boolean flag = false;
        String regex = "^\\++[91]+\\s+[789]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        for(int i = 0; i < phoneNo.length(); i++)
        {
            Matcher matcher=pattern.matcher(phoneNo);
            flag = matcher.matches();
        }
        return flag;
    }

    // Method to check password
    public static boolean validPassword(String password) {
        boolean flag = false;
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";

//        ^ represents starting character of the string.
//        (?=.*[0-9]) represents a digit must occur at least once.
//        (?=.*[a-z]) represents a lower case alphabet must occur at least once.
//        (?=.*[A-Z]) represents an upper case alphabet that must occur at least once.
//        (?=.*[@#$%^&-+=()]) represents a special character that must occur at least once.
//        (?=\\S+$) white spaces don’t allowed in the entire string.
//        .{8, 20} represents at least 8 characters and at most 20 characters.
//        $ represents the end of the string.

        Pattern pattern = Pattern.compile(regex);
        for(int i = 0; i < password.length(); i++)
        {
            Matcher matcher=pattern.matcher(password);
            flag = matcher.matches();
        }
        return flag;
    }
}