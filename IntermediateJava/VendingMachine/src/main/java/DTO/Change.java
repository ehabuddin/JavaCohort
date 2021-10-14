/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author mdeha
 */
public class Change {
    public enum Coins{
        QUARTER, NICKEL, DIME, PENNIES
    }
    
    public Coins coinType;
    
    private int quarters;
    private int nickels;
    private int dimes;
    private int pennies;
    
    public Change(BigDecimal changeToReturn){
        //Quarters
        BigDecimal change = changeToReturn.divide(new BigDecimal("0.25"),0,RoundingMode.FLOOR);
        quarters = Integer.parseInt(change.toString());
        BigDecimal left = changeToReturn.subtract(change.multiply(new BigDecimal("0.25")));
        //Dimes
        change = left.divide(new BigDecimal("0.10"),0,RoundingMode.FLOOR);
        dimes = Integer.parseInt(change.toString());
        left = left.subtract(change.multiply(new BigDecimal("0.10")));
        //Nickels
        change = left.divide(new BigDecimal("0.05"),0,RoundingMode.FLOOR);
        nickels = Integer.parseInt(change.toString());
        left = left.subtract(change.multiply(new BigDecimal("0.05")));
        //Pennies
        change = left.divide(new BigDecimal("0.01"),0,RoundingMode.FLOOR);
        pennies = Integer.parseInt(change.toString());        
    }

    public int getQuarters() {
        return quarters;
    }

    public int getNickels() {
        return nickels;
    }
    
    public int getDimes() {
        return dimes;
    }

    public int getPennies() {
        return pennies;
    }

    public Enum getEnum() {
        return coinType;
    }
    
}
