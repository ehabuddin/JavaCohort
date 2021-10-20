package com.mycompany.flooringmastery.UI;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import org.springframework.stereotype.Component;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mdeha
 */
@Component
public class UserIOImpl implements UserIO {

    Scanner myScanner = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return myScanner.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        while(true){
            try{
                return Integer.parseInt(myScanner.nextLine());
            }catch(NumberFormatException e){
                System.out.println("This is not an INTEGER, try again!");
            }
        }
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        while(true){
            try{
                System.out.println(prompt);
                int temp = Integer.parseInt(myScanner.nextLine());
                if(temp >= min && temp <= max){
                    return temp;
                }
            }catch(NumberFormatException e){
                System.out.println("This is not an INTEGER, try again!");
            }
            
        }
    }

    @Override
    public double readDouble(String prompt) {
        while(true){
            try{
                System.out.println(prompt);
                return Double.parseDouble(myScanner.nextLine());
            }catch(NumberFormatException e){
                System.out.println("This is not a DOUBLE, try again!");
            }
        }
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        while(true){
            try{
                System.out.println(prompt);
                double temp = Double.parseDouble(myScanner.nextLine());
                if(temp >= min && temp <= max){
                    return temp;
                }
            }catch(NumberFormatException e){
                System.out.println("This is not a DOUBLE, try again!");
            }
        }
    }

    @Override
    public float readFloat(String prompt) {
        while(true){
            try{
                System.out.println(prompt);
                return Float.parseFloat(myScanner.nextLine());
            }catch(NumberFormatException e){
                System.out.println("This is not a FLOAT, try again!");
            }
        }
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        while(true){
            try{
                System.out.println(prompt);
                float temp = Float.parseFloat(myScanner.nextLine());
                if(temp >= min && temp <= max){
                    return temp;
                }
            }catch(NumberFormatException e){
                System.out.println("This is not a FLOAT, try again!");
            }
        }
    }

    @Override
    public long readLong(String prompt) {
        while(true){
            try{
                System.out.println(prompt);
                return Long.parseLong(myScanner.nextLine());
            }catch(NumberFormatException e){
                System.out.println("This is not a LONG, try again!");
            }
        }
        
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        while(true){
            try{
                System.out.println(prompt);
                long temp = Long.parseLong(myScanner.nextLine());
                if(temp >= min && temp <= max){
                    return temp;
                }
            }catch(NumberFormatException e){
                System.out.println("This is not a LONG, try again!");
            }
        }
    }
    
    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max){
        /*
            firstBigDecimal.compareTo(secondBigDecimal) < 0 // "<"
            firstBigDecimal.compareTo(secondBigDecimal) > 0 // ">"    
            firstBigDecimal.compareTo(secondBigDecimal) == 0 // "=="  
            firstBigDecimal.compareTo(secondBigDecimal) >= 0 // ">=" 
        */
        while(true){
            try{
                System.out.println(prompt);
                BigDecimal temp = new BigDecimal(myScanner.nextLine());
                temp = temp.setScale(2,RoundingMode.HALF_UP);
                if(temp.compareTo(min) >= 0 && temp.compareTo(min) <= 0){
                    return temp;
                }
            }catch(NumberFormatException e){
                System.out.println("This is not a BIGDECIMAL, try again!");
            }
        }
    }
    
    @Override
    public BigDecimal readBigDecimal(String prompt){
        while(true){
            try{
                System.out.println(prompt);
                return new BigDecimal(myScanner.nextLine());
            }catch(NumberFormatException e){
                System.out.println("This is not a BIGDECIMAL, try again!");
            }
        }
    }
    @Override
    public LocalDate readLocalDateAfterToday(LocalDate min){
        while(true){
            try{
                System.out.println("Enter a order date by entering the following:");
                int month = readInt("Enter a month (1-12)", 1, 12);
                String monthString = String.format("%02d", month);
                int date = readInt("Enter a day (1-31)", 1, 31);
                String dayString = String.format("%02d", date);
                int year =readInt("Enter a year");
                String yearString = String.format("%04d", year);
                //System.out.println(yearString);
                String dateString = monthString + "/"+ dayString+ "/" + yearString;
                //System.out.println(dateString);
                //String dateString = readString("Enter a date: MM/DD/YYYY");
                LocalDate input = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                if(input.isAfter(min)){
                    return input;
                }
                else{
                    System.out.println("Date needs to be in the future");
                }
            }catch(NumberFormatException e){
                System.out.println("This is not a valid input! Try again");
            }
        }
    }
    
    public LocalDate readLocalDateBeforeToday(LocalDate max){
        while(true){
            try{
                int month = readInt("Enter a month (1-12)", 1, 12);
                int date = readInt("Enter a day (1-31)", 1, 31);
                int year =readInt("Enter a year");
                String dateString = month + "/"+ date+ "/" + year;
                LocalDate input = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                if(input.isBefore(max) || input.isEqual(max)){
                    return input;
                }
                else{
                    System.out.println("Date CANN be in the future");
                }
            }catch(NumberFormatException e){
                System.out.println("This is not a valid input! Try again");
            }
        }
    }
    
    public String readLocalDateNoSlash(){
        while(true){
            try{
                System.out.println("Enter a order date by entering the following:");
                int month = readInt("Enter a month (1-12)", 1, 12);
                String monthString = String.format("%02d", month);
                int date = readInt("Enter a day (1-31)", 1, 31);
                String dayString = String.format("%02d", date);
                int year =readInt("Enter a year");
                String yearString = String.format("%04d", year);
                //System.out.println(yearString);
                String dateString = monthString + "/"+ dayString+ "/" + yearString;
                //System.out.println(dateString);
                //String dateString = readString("Enter a date: MM/DD/YYYY");
                LocalDate tempDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                return tempDate.format(DateTimeFormatter.ofPattern("MMddyyyy"));
                
            }catch(NumberFormatException e){
                System.out.println("This is not a valid input! Try again");
            }
            //return readString("Enter a date (MMDDYYYY)");
        }
    }
}
