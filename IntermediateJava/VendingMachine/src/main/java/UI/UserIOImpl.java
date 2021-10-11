package UI;


import UI.UserIO;
import java.math.BigDecimal;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mdeha
 */
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
        return Integer.parseInt(myScanner.nextLine());
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        while(true){
            System.out.println(prompt);
            int temp = Integer.parseInt(myScanner.nextLine());
            if(temp >= min && temp <= max){
                return temp;
            }
        }
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        return Double.parseDouble(myScanner.nextLine());
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        while(true){
            System.out.println(prompt);
            double temp = Double.parseDouble(myScanner.nextLine());
            if(temp >= min && temp <= max){
                return temp;
            }
        }
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        return Float.parseFloat(myScanner.nextLine());
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        while(true){
            System.out.println(prompt);
            float temp = Float.parseFloat(myScanner.nextLine());
            if(temp >= min && temp <= max){
                return temp;
            }
        }
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        return Long.parseLong(myScanner.nextLine());
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        while(true){
            System.out.println(prompt);
            long temp = Long.parseLong(myScanner.nextLine());
            if(temp >= min && temp <= max){
                return temp;
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
            System.out.println(prompt);
            BigDecimal temp = new BigDecimal(myScanner.nextLine());
            if(temp.compareTo(min) >= 0 && temp.compareTo(min) <= 0){
                return temp;
            }
        }
    }
    
    @Override
    public BigDecimal readBigDecimal(String prompt){
        System.out.println(prompt);
        return new BigDecimal(myScanner.nextLine());
    }
}
