package com.mycompany.vendingmachine.UI;


import java.math.BigDecimal;
import java.math.RoundingMode;
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
}
