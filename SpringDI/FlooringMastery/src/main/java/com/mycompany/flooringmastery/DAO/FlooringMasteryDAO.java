/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.DAO;

import com.mycompany.flooringmastery.DTO.Order;
import com.mycompany.flooringmastery.DTO.Product;
import com.mycompany.flooringmastery.DTO.Taxes;
import com.mycompany.flooringmastery.ServiceLayer.OrderNotFoundException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.stereotype.Component;

/**
 *
 * @author mdeha
 */
@Component
public class FlooringMasteryDAO {
    private Map<String, Taxes> states = new HashMap<>();
    private Map<String, Product> prodcuts = new HashMap<>();
    private Map<Integer, Order> orders = new HashMap<>();
    
    private ArrayList<String> dates = new ArrayList<>();
    
    public Order getOrder(int orderNum){
        return orders.get(orderNum);
    }
    
    private String marshallExportOrder(Order myOrder){
        //OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total, OrderDate
        String order = String.valueOf(myOrder.getOrderNum()) + ",";
        order += myOrder.getCustomerName() + ",";
        order += myOrder.getState() + ",";
        order += myOrder.getTaxRate() + ",";
        order += myOrder.getProductType() + ",";
        order += myOrder.getArea() + ",";
        order += myOrder.getCostPerSquareFoot() + ",";
        order += myOrder.getLaborCostperSquareFoot() + ",";
        order += myOrder.getMaterialCost() + ",";
        order += myOrder.getLaborCost() + ",";
        order += myOrder.getTax() + ",";
        order += myOrder.getTotal() + ",";
        order += myOrder.getOrderDate().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        return order;
    }
    
//    public void exportProducts(){
//        PrintWriter out; 
//        try{
//            //out = new PrintWriter(new FileOutputStream(new File("./SampleFileData/Backup/DataExport.txt")));
//            out = new PrintWriter(new FileOutputStream(new File("./SampleFileData/Backup/DataExport.txt"), true));
//            out.print("\n");
//            //out.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total,OrderDate");
//            for(Order i: orders.values()){
//                //System.out.println(i.getCustomerName());
//                out.println(marshallExportOrder(i));
//                out.flush();
//                out.close();
//            }
//            
//        }catch(IOException e){
//            //UNLIKELY
//        }
//    }
//    
    private Product unmarshallProduct(String ItemAsText) {
        String[] ItemTokens = ItemAsText.split(",");
        Product myProduct = new Product();
        myProduct.setProdcutType(ItemTokens[0]);
        myProduct.setCostPerSquareFoot(new BigDecimal(ItemTokens[1]));
        myProduct.setLaborCostPerSquareFoot(new BigDecimal(ItemTokens[2]));
        return myProduct;
    }
    
    public void loadProducts() throws FileNotFoundException{
        Scanner scanner;
        int counter =0;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader("./SampleFileData/Data/Products.txt")));
            
            String currentLine = "";
            while (scanner.hasNextLine()) {
                if(counter ==0){
                    counter++;
                    scanner.nextLine();
                    continue;
                }
                // get the next line in the file
                currentLine = scanner.nextLine();
                Product product = unmarshallProduct(currentLine);
                prodcuts.put(product.getProdcutType(),product);
            }
            // close scanner
            scanner.close();
            //return currentLine;
        } catch (FileNotFoundException e) {
            //Error finding FILE
            throw new FileNotFoundException("PRODCUT FILE NOT FOUND");
        }
    }
    
    private Taxes unmarshallState(String ItemAsText) {
        String[] ItemTokens = ItemAsText.split(",");
        Taxes myState = new Taxes();
        myState.setState(ItemTokens[0]);
        myState.setStateName(ItemTokens[1]);
        myState.setTaxRate(new BigDecimal(ItemTokens[2]));
        
        return myState;
    }
    
    public void loadStates() throws FileNotFoundException{
        Scanner scanner;
        int counter =0;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader("./SampleFileData/Data/Taxes.txt")));
            
            String currentLine = "";
            while (scanner.hasNextLine()) {
                if(counter ==0){
                    counter++;
                    scanner.nextLine();
                    continue;
                }
                // get the next line in the file
                currentLine = scanner.nextLine();
                Taxes state = unmarshallState(currentLine);
                states.put(state.getState(),state);
            }
            // close scanner
            scanner.close();
            //return currentLine;
        } catch (FileNotFoundException e) {
            //Error finding FILE
            throw new FileNotFoundException("STATES FILE NOT FOUND");
        }
    }
    
    private Order unmarshallOrders(String ItemAsText) {
        String[] ItemTokens = ItemAsText.split(",");
        Order myOrder = new Order(Integer.parseInt(ItemTokens[0]));
        //myOrder.setOrderNum();
        myOrder.setCustomerName(ItemTokens[1]);
        myOrder.setState(ItemTokens[2]);
        myOrder.setTaxRate(new BigDecimal(ItemTokens[3]));
        myOrder.setProductType(ItemTokens[4]);
        myOrder.setArea(new BigDecimal(ItemTokens[5]));
        myOrder.setCostPerSquareFoot(new BigDecimal(ItemTokens[6]));
        myOrder.setLaborCostperSquareFoot(new BigDecimal(ItemTokens[7]));
        myOrder.setMaterialCost(new BigDecimal(ItemTokens[8]));
        myOrder.setLaborCost(new BigDecimal(ItemTokens[9]));
        myOrder.setTax(new BigDecimal(ItemTokens[10]));
        myOrder.setTotal(new BigDecimal(ItemTokens[11]));
        
//        String[] date = ItemTokens[12].split("-");
//        String month = date[0];
//        String day = date[1];
//        String year = date[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate tempDate = LocalDate.parse(ItemTokens[12], formatter);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
        dates.add(tempDate.format(formatter2));
        myOrder.setOrderDate(tempDate);
        return myOrder;
    }
    
    public void loadOrders() throws FileNotFoundException{
        Scanner scanner;
        int counter =0;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader("./SampleFileData/Backup/DataExport.txt")));
            
            String currentLine = "";
            while (scanner.hasNextLine()) {
                if(counter ==0){
                    counter++;
                    scanner.nextLine();
                    continue;
                }
                // get the next line in the file
                currentLine = scanner.nextLine();
                //System.out.println(currentLine);
                Order myOrder = unmarshallOrders(currentLine);
                orders.put(myOrder.getOrderNum(),myOrder);
            }
            // close scanner
            scanner.close();
            //return currentLine;
        } catch (FileNotFoundException e) {
            //Error finding FILE
            throw new FileNotFoundException("ORDERS FILE NOT FOUND");
        }
    }
    
    public String readFile(String fileName) throws OrderNotFoundException{
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(fileName)));
            
            String currentLine = "";
            while (scanner.hasNextLine()) {
                // get the next line in the file
                currentLine += scanner.nextLine();
                currentLine += "\n";
            }
            // close scanner
            scanner.close();
            return currentLine;
        } catch (FileNotFoundException e) {
            //Error finding FILE
            throw new OrderNotFoundException("NO orders found", e);
        }
    }
    public ArrayList<String> getStates(){
        return new ArrayList<>(states.keySet());
    }
    
    public ArrayList<String> getProducts(){
        return new ArrayList<>(prodcuts.keySet());
    }
    
    public void calculateNewOrderInfo(Order newOrder){
        newOrder.setTaxRate(states.get(newOrder.getState()).getTaxRate().setScale(2, RoundingMode.HALF_UP));
        newOrder.setCostPerSquareFoot(prodcuts.get(newOrder.getProductType()).getLaborCostPerSquareFoot().setScale(2, RoundingMode.HALF_UP));
        newOrder.setLaborCostperSquareFoot(prodcuts.get(newOrder.getProductType()).getCostPerSquareFoot().setScale(2, RoundingMode.HALF_UP));
        newOrder.setMaterialCost(newOrder.getArea().multiply(newOrder.getCostPerSquareFoot()).setScale(2, RoundingMode.HALF_UP));
        newOrder.setLaborCost(newOrder.getArea().multiply(newOrder.getLaborCostperSquareFoot()).setScale(2, RoundingMode.HALF_UP));
        newOrder.setTax(newOrder.getMaterialCost().add(newOrder.getLaborCost()).multiply(newOrder.getTaxRate().divide(new BigDecimal("100"))).setScale(0, RoundingMode.HALF_UP));
        newOrder.setTotal(newOrder.getMaterialCost().add(newOrder.getLaborCost()).add(newOrder.getTax()));
        
        
        //orders.put(newOrder.getOrderNum(), newOrder);
        
        
        
        /*
        MaterialCost = (Area * CostPerSquareFoot)
        LaborCost = (Area * LaborCostPerSquareFoot)
        Tax = (MaterialCost + LaborCost) * (TaxRate/100)
        Tax rates are stored as whole numbers
        Total = (MaterialCost + LaborCost + Tax)
        */
    }
    
    public void writeOrder(Order newOrder){
        orders.put(newOrder.getOrderNum(), newOrder);
        //exportProducts();
        PrintWriter out;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        String fileName = "./SampleFileData/Orders/Orders_"+newOrder.getOrderDate().format(formatter) + ".txt";
        File f = new File(fileName);
        
        if ( f.exists()) {
            //APPEND
            try{
                out = new PrintWriter(new FileOutputStream(new File(fileName), true));
                out.println(marshallOrder(newOrder.getOrderNum()));
                out.flush();
                out.close();
            }catch(IOException e){
                //UNLIKELY
            }
        }
        else {
            //CREATE NEW FILE AND WRITE
            try{
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
                dates.add(newOrder.getOrderDate().format(formatter2));
                
                out = new PrintWriter(fileName);
                String heading = "OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total";
                out.println(heading);
                out.println(marshallOrder(newOrder.getOrderNum()));
                out.flush();
                out.close();
            }catch(IOException e){
                //UNLIKELY
            }            
        }
    }
    
    private String marshallOrder(int orderNum) {
        //OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total
        Order newOrder = orders.get(orderNum);
        String order = String.valueOf(newOrder.getOrderNum()) + ",";
        order += newOrder.getCustomerName() + ",";
        order += newOrder.getState() + ",";
        order += newOrder.getTaxRate() + ",";
        order += newOrder.getProductType() + ",";
        order += newOrder.getArea() + ",";
        order += newOrder.getCostPerSquareFoot() + ",";
        order += newOrder.getLaborCostperSquareFoot() + ",";
        order += newOrder.getMaterialCost() + ",";
        order += newOrder.getLaborCost() + ",";
        order += newOrder.getTax() + ",";
        order += newOrder.getTotal();
        //System.out.println(newOrder.toString());
        return order;
    }
    
//    private Order unmarshallSingleOrder(String ItemAsText) {
//        String[] ItemTokens = ItemAsText.split(",");
//        Order myOrder = new Order();
//        myOrder.setOrderNum();
//        //myOrder.setOrderNum(Integer.parseInt(ItemTokens[0]));
//        myOrder.setCustomerName(ItemTokens[1]);
//        myOrder.setState(ItemTokens[2]);
//        myOrder.setTaxRate(new BigDecimal(ItemTokens[3]));
//        myOrder.setProductType(ItemTokens[4]);
//        myOrder.setArea(new BigDecimal(ItemTokens[5]));
//        myOrder.setCostPerSquareFoot(new BigDecimal(ItemTokens[6]));
//        myOrder.setLaborCostperSquareFoot(new BigDecimal(ItemTokens[7]));
//        myOrder.setMaterialCost(new BigDecimal(ItemTokens[8]));
//        myOrder.setLaborCost(new BigDecimal(ItemTokens[9]));
//        myOrder.setTax(new BigDecimal(ItemTokens[10]));
//        myOrder.setTotal(new BigDecimal(ItemTokens[11]));
//
//        return myOrder;
//    }
    
    public Order getOrder(String fileName, int orderNum) throws OrderNotFoundException{
        Scanner scanner;
        int counter = 0;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(fileName)));
            
            String currentLine = "";
            while (scanner.hasNextLine()) {
                if(counter ==0){
                    counter++;
                    scanner.nextLine();
                    continue;
                }
                // get the next line in the file
                currentLine = scanner.nextLine();
                
                if(Integer.parseInt(currentLine.split(",")[0]) == orderNum){
                    //FOUND IT
                    //Order myOrder = unmarshallSingleOrder(currentLine);
                    Order myOrder = orders.get(orderNum);
                    scanner.close();
                    return myOrder;
                }
            }
            // close scanner
            scanner.close();
            throw new OrderNotFoundException("NO order 1 found");
        } catch (FileNotFoundException e) {
            //Error finding FILE
            throw new OrderNotFoundException("NO order 2 found", e);
        }
    }
    
//    public void updateOrder(int orderNum){
//        for(Order i: orders.values()){
//           if(i.getOrderNum() != orderNum){
//               
//           } 
//           else {
//               Order tempOrder = orders.get(orderNum);
//               orders.remove(orderNum);
//               orders.put(orderNum, tempOrder);
//           }
//        }
//    }
    public int getLastOrderNum(){
        List<Integer> sortedKeys = new ArrayList<>();
        sortedKeys.addAll(orders.keySet());
        Collections.sort(sortedKeys); //sorts in ascending date order 
        
        return (sortedKeys.get(sortedKeys.size()-1) + 1);
    }
    
    private boolean unmarshallEditOrder(String currentLine, int orderNum){
        String[] ItemTokens = currentLine.split(",");
        if(Integer.parseInt(ItemTokens[0]) == orderNum){
           return true;
        }
        return false;
    }
    
    
    public void writeToFile(String fileName, int orderNum) throws OrderNotFoundException{
        Order myOrder = orders.get(orderNum);
        if(myOrder == null){
            throw new OrderNotFoundException("Order not found");
        }
        Scanner scanner;
        int counter = 0;
        String fileContent = "";
        try{
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(fileName)));
            
            String currentLine = "";
            while (scanner.hasNextLine()) {
                if(counter ==0){
                    fileContent += scanner.nextLine();
                    fileContent += "\n";
                    counter++;
                    continue;
                }
                // get the next line in the file
                currentLine = scanner.nextLine();
                //System.out.println(myOrder.getOrderNum());
                if(!unmarshallEditOrder(currentLine, myOrder.getOrderNum())){
                    fileContent += currentLine;
                    fileContent += "\n";
                }
                else{
                    fileContent += marshallOrder(myOrder.getOrderNum());
                    fileContent += "\n";
                }
            }
            // close scanner
            scanner.close();
            //REWRITE FILE
            PrintWriter out;
            try{
                out = new PrintWriter(fileName);
                out.print(fileContent);
                out.flush();
                out.close();
            }catch(IOException e){
                //UNLIKELY
            }
            
        } catch (FileNotFoundException e) {
            //Error finding FILE
            throw new OrderNotFoundException("ERROR", e);
        }
    }
    
    //Delete
    public Order getOrderToDelete(String date, int orderNum) throws OrderNotFoundException{
//        for(Order i: orders.values()){
//            System.out.println(i.getOrderNum()+ "  " + i.getCustomerName());
//        }

        Order temp = orders.get(orderNum);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
        
        if(temp == null){
            throw new OrderNotFoundException("No such order");
        }
        if(temp.getOrderDate().format(formatter2).equals(date)){
            return temp;
        }
        throw new OrderNotFoundException("No such order");
    }
    
    public void deleteOrder(int orderNum, String date) throws OrderNotFoundException{
        String fileName = "./SampleFileData/Orders/Orders_"+date + ".txt";
        updateDeletedFile(orderNum, fileName);
        orders.remove(orderNum);
    }
    public void updateDeletedFile(int orderNum, String fileName) throws OrderNotFoundException{
        Order myOrder = orders.get(orderNum);
        if(myOrder == null){
            throw new OrderNotFoundException("No order found");
        }
        Scanner scanner;
        int counter = 0;
        String fileContent = "";
        try{
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(fileName)));
            
            String currentLine = "";
            while (scanner.hasNextLine()) {
                if(counter ==0){
                    fileContent += scanner.nextLine();
                    fileContent += "\n";
                    counter++;
                    continue;
                }
                // get the next line in the file
                currentLine = scanner.nextLine();
                if(!unmarshallEditOrder(currentLine, myOrder.getOrderNum())){
                    fileContent += currentLine;
                    fileContent += "\n";
                }
            }
            // close scanner
            scanner.close();
            //REWRITE FILE
            PrintWriter out;
            try{
                out = new PrintWriter(fileName);
                out.print(fileContent);
                out.flush();
                out.close();
            }catch(IOException e){
                //UNLIKELY
            }
            
        } catch (FileNotFoundException e) {
            //Error finding FILE
            throw new OrderNotFoundException("ERROR", e);
        }
    }
    
    //EXPORT
    public void exportData(){
        PrintWriter out;
        try{
            out = new PrintWriter(new FileOutputStream(new File("./SampleFileData/Backup/DataExport.txt")));
            out.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total,OrderDate");
            for(Order i: orders.values()){
                //System.out.println(i.getOrderNum()+"   "+i.getCustomerName());
                String lineToPrint = marshallOrder(i.getOrderNum());
                lineToPrint += ",";
                lineToPrint += i.getOrderDate().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
                out.println(lineToPrint);
                out.flush();
            }
            out.close();
        }catch(IOException e){
            //UNLIKELY
        }
    }
}
