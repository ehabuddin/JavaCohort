/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DTO.VendingMachineItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mdeha
 */
public class VendingMachineView {
    UserIO io;
    private int counter = 1;
    
    public VendingMachineView(UserIO io){
        this.io = io;
    }
    
    public void displayItems(List<VendingMachineItem> items){
        io.print("Welcome to my Vending Machine!");
        io.print("Here is a list of items available today: ");
        
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
        return io.readBigDecimal("Insert Money");
    }
    
    public int getUserSelection(){
        //io.print(""+counter);
        return io.readInt("Enter of the choices from the list", 1, counter);
    }
    public void thankyouMsg(){
        io.print("Thank you for the purchase!");
    }
    public void printChange(String change){
        io.print("Here is your money back: $" + change);
    }
    
    public void inSufficientFunds(Exception e){
        io.print(e.getMessage());
    }
    public void inventoryException(Exception e){
        io.print(e.getMessage());
    }
    public void updateCounter(){
        counter--;
    }
}
