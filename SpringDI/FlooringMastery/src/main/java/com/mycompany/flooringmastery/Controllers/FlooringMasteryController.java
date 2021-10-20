/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.Controllers;

import com.mycompany.flooringmastery.DTO.Order;
import com.mycompany.flooringmastery.ServiceLayer.FlooringMasteryServiceLayer;
import com.mycompany.flooringmastery.ServiceLayer.IncorrectOrderDetailsException;
import com.mycompany.flooringmastery.ServiceLayer.OrderNotFoundException;
import com.mycompany.flooringmastery.UI.FlooringMasteryView;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mdeha
 */
@Component
public class FlooringMasteryController {
    @Autowired
    FlooringMasteryView view;
    @Autowired
    FlooringMasteryServiceLayer serviceLayer;
    
    public FlooringMasteryController(FlooringMasteryView view, FlooringMasteryServiceLayer serviceLayer){
        this.view = view;
        this.serviceLayer = serviceLayer;
    }
    
    public void run() throws FileNotFoundException{
        boolean keepGoing = true;
        serviceLayer.loadInfo();
        while(keepGoing){
            boolean dataExported = false;
            view.printOptions();
            int userSelection = view.getUserSelection();
            switch(userSelection){
                case 1:
                    //Display Orders
                    String date = view.getDate();
                    try{
                        String allOrders = serviceLayer.getAllOrders(date);
                        view.printAllOrders(allOrders);
                    }catch(OrderNotFoundException e){
                        view.printException(e);
                    }
                    break;
                case 2:
                    //Add an Order
                    ArrayList<String> states = serviceLayer.getStates();
                    ArrayList<String> products = serviceLayer.getProducts();
                    try{
                        int getLastOrderNum = serviceLayer.getLastOrderNum();
                        Order newOrder = view.addOrder(states, products, getLastOrderNum);
                        serviceLayer.setNewOrderInfo(newOrder);
                        //Print success MSG
                        view.printSuccess("Order ADDED SUCCESSFULLY!");
                        
                    }catch(IncorrectOrderDetailsException e){
                        view.printException(e);
                        continue;
                    }
                    
                    break;
                case 3:
                    //Edit an Order
                    String orderDate = view.getDate();
                    int orderNum = view.getOrderNum();
                    try{
                        //System.out.println(orderDate);
                        Order oldOrder = serviceLayer.edit(orderDate, orderNum);
                        ArrayList<String> state = serviceLayer.getStates();
                        ArrayList<String> product = serviceLayer.getProducts();
                        try{
                            String orderName = oldOrder.getCustomerName();
                            oldOrder = view.getEditInfo(oldOrder, state, product);
                            serviceLayer.editOrderInfo(oldOrder, orderDate);
                            //Show Edit Success MSG
                            view.printSuccess("Order EDITED SUCCESSFULLY!");
                        }catch(IncorrectOrderDetailsException e){
                            view.printException(e);
                        }catch(Exception e){
                            
                        }
                    }catch(OrderNotFoundException e){
                        view.printException(e);
                    }
                    
                    break;
                case 4:
                    //Remove an Order
                    String removeOrderDate = view.getDate();
                    int removeOrderNum = view.getOrderNum();
                    try{
                        Order removeOrder = serviceLayer.removeOrder(removeOrderDate, removeOrderNum);
                        boolean confirmation = view.getRemoveConfirmation(removeOrder);
                        if(confirmation){
                            //Delete
                            serviceLayer.deleteOrder(removeOrder, removeOrderDate);
                            //Show success MSG
                            view.printSuccess("Order DELETED SUCCESSFULLY!");
                        }
                        else{
                            //Show not deleted msg
                            view.printSuccess("Order was NOT deleted!");
                        }
                    }catch(OrderNotFoundException e){
                        view.printException(e);
                    }
                    break;
                case 5:
                    //Export All Data
                    serviceLayer.exportData();
                    view.printSuccess("ALL ORDERS EXPORTED SUCCESSFULLY");
                    dataExported = true;
                    break;
                case 6:
                    //Quit
                    keepGoing = false;
                    if(!dataExported){
                        serviceLayer.exportData();
                    }
                    //Thank you Msg
                    view.printSuccess("THANK YOU! GOODBYE!");
                    break;

            }
            
        }
    }
}
