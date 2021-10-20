/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.ServiceLayer;

import com.mycompany.flooringmastery.DAO.FlooringMasteryDAO;
import com.mycompany.flooringmastery.DTO.Order;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mdeha
 */
@Component
public class FlooringMasteryServiceLayer {
    @Autowired
    FlooringMasteryDAO dao = new FlooringMasteryDAO();
    public FlooringMasteryServiceLayer(FlooringMasteryDAO dao){
        this.dao = dao;
        
    }
    
    public void loadInfo(){
        try{
            dao.loadOrders();
            dao.loadProducts();
            dao.loadStates();
        }catch(FileNotFoundException e){
            //Unlikely
        }
        
    }
            
    
    public String getAllOrders(String date) throws OrderNotFoundException{
        String fileName = "./SampleFileData/Orders/Orders_"+date+".txt";
        try{
            String toPrint = dao.readFile(fileName);
            return toPrint;
            
        }catch(OrderNotFoundException e){
            throw new OrderNotFoundException("NO orders Found", e);
        }
    }
    
    public ArrayList<String> getStates() throws FileNotFoundException{
        return dao.getStates();
    }
    
    public ArrayList<String> getProducts() throws FileNotFoundException{
        return dao.getProducts();
    }
    
    public int getLastOrderNum(){
        return dao.getLastOrderNum();
    }
    
    public void setNewOrderInfo(Order newOrder){
        dao.calculateNewOrderInfo(newOrder);
        //ADD ORDER IN FILE
        dao.writeOrder(newOrder);
    }
    
    public Order edit(String date, int orderNum) throws OrderNotFoundException{
        String fileName = "./SampleFileData/Orders/Orders_"+date+".txt";
        try{
            Order order = dao.getOrder(fileName,orderNum);
            if(order == null){
                throw new OrderNotFoundException("No order file Found");
            }
            return order;
        }catch(OrderNotFoundException e){
            throw new OrderNotFoundException("NO order file found");
        }
    }
    
    public void editOrderInfo(Order editOrder, String date) throws OrderNotFoundException{
        String fileName = "./SampleFileData/Orders/Orders_"+date+".txt";
        dao.calculateNewOrderInfo(editOrder);
        dao.writeToFile(fileName, editOrder.getOrderNum());
        //dao.updateOrder(editOrder.getOrderNum(),orderName);
    }
    
    //Remove Order
    public Order removeOrder(String removeOrderDate,int removeOrderNum) throws OrderNotFoundException{
        try{
            Order temp = dao.getOrderToDelete(removeOrderDate, removeOrderNum);
            if(temp == null){
                throw new OrderNotFoundException("NO such order");
            }
            return temp;
        }catch(OrderNotFoundException e){
            throw new OrderNotFoundException("NO such order");
        }
    }
    
    public void deleteOrder(Order deleteOrder, String date) throws OrderNotFoundException{
        try{
            dao.deleteOrder(deleteOrder.getOrderNum(), date);
        }catch(OrderNotFoundException e){
            
        }
    }
    
    //EXPORT DATA
    public void exportData(){
        dao.exportData();
    }
}
