//UC - 1 is to As a User need to enter a valid First Name. (First name starts with Cap and has minimum 3 characters)
//UC - 2 is to As a User need to enter a valid Last Name. (Last name starts with Cap and has minimum 3 characters)
//UC - 3 is to As a User need to enter a valid email. (E.g. abc.xyz@bl.co.in - Email has 3 mandatory parts (abc, bl & co)
//            and 2 optional (xyz & in) with precise @ and . positions)

package com.user.registration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the User's First Name");
        String firstName = scan.next();
        System.out.println("Enter the User's Last Name");
        String lastName = scan.next();
        System.out.println("Enter the User's email id");
        String emailID = scan.next();
        System.out.println("Given first name : " + firstName + " is valid : " + validName(firstName));
        System.out.println("Given last name : " + lastName + " is valid : " + validName(lastName));
        System.out.println("Given email id : " + emailID + " is valid : " + validEmail(emailID));
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
    public static boolean validEmail(String name) {
        boolean flag = false;
        String regex = "^[a-z0-9+_.-]+@+[a-z]+.+[a-z]$";
        Pattern pattern = Pattern.compile(regex);
        for(int i = 0; i < name.length(); i++)
        {
            Matcher matcher=pattern.matcher(name);
            flag = matcher.matches();
        }
        return flag;
    }
}