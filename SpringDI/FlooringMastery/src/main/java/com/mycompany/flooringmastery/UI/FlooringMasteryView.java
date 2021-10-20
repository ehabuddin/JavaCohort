/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.UI;

import com.mycompany.flooringmastery.DTO.Order;
import com.mycompany.flooringmastery.ServiceLayer.IncorrectOrderDetailsException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mdeha
 */
@Component
public class FlooringMasteryView {
    @Autowired
    UserIOImpl io;
    
    public FlooringMasteryView(UserIOImpl io){
        this.io = io;
    }
    
    public void printOptions(){
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print("* <<Flooring Program>>");
        io.print("* 1. Display Orders");
        io.print("* 2. Add an Order");
        io.print("* 3. Edit an Order");
        io.print("* 4. Remove an Order");
        io.print("* 5. Export All Data");
        io.print("* 6. Quit");
        io.print("*");
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }
    
    public void printSuccess(String toPrint){
        io.print("--------"+toPrint+"--------");
    }
    
    public int getUserSelection(){
        return io.readInt("Selection an option 1-6", 1, 6);
    }
    
    public String getDate(){
        return io.readLocalDateNoSlash();
    }
    public void printException(Exception e){
        io.print(e.getMessage());
    }
    public void printAllOrders(String allOrders){
        io.print(allOrders);
    }
    
    public Order addOrder(ArrayList<String> states, ArrayList<String> products, int counter) throws IncorrectOrderDetailsException{
        LocalDate orderDate = io.readLocalDateAfterToday(LocalDate.now());
        String name = io.readString("Enter customer name[A-Z OR a-z OR , OR .]: ");
//        while(!name.matches("^[\\w.,]$")){
//            name = io.readString("Enter customer name[A-Z OR a-z OR , OR .]: ");
//        }
        String state = io.readString("Enter of these states: "+ states.toString());
        if(!states.contains(state)){
            throw new IncorrectOrderDetailsException("We cannot work with that state");
        }
        
        //GOOD AND CONTINUE
        int count = 1;
        for(String i: products){
            io.print(count+ ". "  + i);
            count++;
        }
        int product = io.readInt("Select one of the prodcuts", 1, count-1);

        BigDecimal area = BigDecimal.ZERO;
        
        while(area.compareTo(new BigDecimal("100")) < 0){
            area = io.readBigDecimal("Enter the area (MUST BE POSITIVE, MIN 100 sq ft.) : ");
            area.setScale(2, RoundingMode.HALF_UP);
        }

        Order newOrder = new Order(counter);
        //newOrder.setOrderNum();
        newOrder.setCustomerName(name);
        newOrder.setOrderDate(orderDate);
        newOrder.setState(state);
        newOrder.setProductType(products.get(product-1));
        newOrder.setArea(area);
        return newOrder;
    }
    
    public int getOrderNum(){
        
        return io.readInt("Enter an order number: ");
    }
    
    public Order getEditInfo(Order oldOrder, ArrayList<String> states, ArrayList<String> products) throws IncorrectOrderDetailsException{
        String oldName = "";
        String newName = io.readString("Enter customer name ("+oldOrder.getCustomerName()+ ") :");
        if(newName.isEmpty()){
            //Dont Edit
        }
        else{
            oldName = oldOrder.getCustomerName();
            oldOrder.setCustomerName(newName);
        }
        
        String state = io.readString("Enter of these states: "+ states.toString());
        if(state.isEmpty()){
            //Dont Edit
        }
        else{
            if(!states.contains(state)){
                throw new IncorrectOrderDetailsException("We cannot work with that state");
            }
            oldOrder.setState(state);
        }
        
        String updateProduct = io.readString("Would you like to update the product? (Enter for NO)");
        if(updateProduct.isEmpty()){
            //Dont Edit
        }
        else{
            int count = 1;
            for(String i: products){
                io.print(count+ ". "  + i);
                count++;
            }
            int product = io.readInt("Select one of the prodcuts", 1, count);
            oldOrder.setProductType(products.get(product-1));
        }
        
        
        String areaEdit = io.readString("Would you like to update the Area? (Enter for NO)");
        if(areaEdit.isEmpty()){
            //Dont Edit
        }
        else{
            BigDecimal area = new BigDecimal(areaEdit);

            while(area.compareTo(new BigDecimal("100")) < 0){
                area = io.readBigDecimal("Enter the area (MUST BE POSITIVE, MIN 100 sq ft.) : ");
                area.setScale(2, RoundingMode.HALF_UP);
            }
            oldOrder.setArea(area);
        }
        return oldOrder;
    }
    public boolean getRemoveConfirmation(Order removeOrder){
        String orderInfo = String.format(removeOrder.getOrderNum()+". Customer Name: %s -- Date: $%s", 
                    removeOrder.getCustomerName(),
                    removeOrder.getOrderDate().toString()
                    );
        io.print(orderInfo);
        int response = io.readInt("Do you want to delete the Order shown above(Y=1//N=2):", 1, 2);
        if(response == 1){
            return true;
        }
        return false;
    }
}
