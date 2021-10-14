/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.UI;


import com.mycompany.vendingmachine.DTO.Change;
import com.mycompany.vendingmachine.DTO.VendingMachineItem;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mdeha
 */
@Component
public class VendingMachineView {
    @Autowired
    UserIO io;
    private int counter = 1;
    
    public VendingMachineView(UserIO io){
        this.io = io;
    }
    
    public void displayItems(List<VendingMachineItem> items){
        io.print("Welcome to my Vending Machine!");
        io.print("Here is a list of items available currently: ");
        
        for(VendingMachineItem i: items){
             String DVDInfo = String.format(counter +". Name: %s -- Price: $%s -- Quantity: %d", 
                    i.getItemName(),
                    i.getItemCost().toString(),
                    i.getNumItems()
                    );
            counter++;
            io.print(DVDInfo);
        }
        counter--;
    }
    
    public BigDecimal getMoney(){
        return io.readBigDecimal("Insert Money").setScale(2, RoundingMode.HALF_UP);
    }
    
    public int getUserSelection(){
        //io.print(""+counter);
        return io.readInt("Enter of the choices from the list", 1, counter);
    }
    public void thankyouMsg(){
        io.print("Thank you for the purchase!");
    }
    public void printChange(String change){
        Change userChange = new Change(new BigDecimal(change));
        Enum coins = userChange.getEnum();
        io.print("Here is your money back: $" + change);
        io.print("Quarters: " + userChange.getQuarters());
        io.print("Dimes: " + userChange.getDimes());
        io.print("Nickels: " + userChange.getNickels());
        io.print("Pennies: " + userChange.getPennies());
    }
    
    public void inSufficientFunds(Exception e){
        io.print(e.getMessage());
    }
    public void inventoryException(Exception e){
        io.print(e.getMessage());
    }
    public void updateCounter(){
        counter = 1;
    }
    
    public boolean userSelectionContinue(){
        if(io.readInt("Would you like to end your session? Y=1//N=2", 1, 2) == 1){
            return false;
        }
        return true;
    }
}
