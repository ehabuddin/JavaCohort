/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DAO.VendingMachineDAO;
import DAO.VendingMachineDAOException;
import DTO.VendingMachineItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdeha
 */
public class VendingMachineServiceLayer {
    VendingMachineDAO dao;
    ArrayList<String> itemNames = new ArrayList<String>();
    
    public VendingMachineServiceLayer(VendingMachineDAO dao){
        this.dao = dao;
    }
    
    public List<VendingMachineItem>  loadVendingMachine() throws VendingMachineDAOException{
        dao.loadVendingItems();
        List<VendingMachineItem> items = dao.getAllItems();
        for(VendingMachineItem i: items){
            itemNames.add(i.getItemName());
        }
        return items;
    }
    
    public void checkSufficientFunds(int selection, BigDecimal money) throws InsufficientFundsException{
        //get the object user wanted
        VendingMachineItem userItem = dao.getItem(itemNames.get(selection-1));
        //System.out.println(userItem.getItemName());
        BigDecimal price = userItem.getItemCost();
        
        /*
            firstBigDecimal.compareTo(secondBigDecimal) < 0 // "<"
            firstBigDecimal.compareTo(secondBigDecimal) > 0 // ">"    
            firstBigDecimal.compareTo(secondBigDecimal) == 0 // "=="  
            firstBigDecimal.compareTo(secondBigDecimal) >= 0 // ">=" 
        */
        
        if(price.compareTo(money) > 0){
            throw new InsufficientFundsException("Insufficient Funds");
        }
    }
    public String dispenseItem(int selection,BigDecimal money) throws NoItemInventoryException{
        //Check inventory
        if(dao.getItem(itemNames.get(selection-1)).getNumItems() > 0){
            //Update DAO
            dao.removeItem(itemNames.get(selection-1));
        }
        else{
            //throw exception
            String name = itemNames.get(selection-1);
            itemNames.remove(selection - 1);
            throw new NoItemInventoryException(name + " is NOT AVAILABLE");
        }
        
        
        
        //Return change
        BigDecimal price = dao.getItem(itemNames.get(selection-1)).getItemCost();
        if(money.compareTo(price) > 0){
            return money.subtract(price).toString();    
        }
        else{
            return "X";
        }
    }
}
