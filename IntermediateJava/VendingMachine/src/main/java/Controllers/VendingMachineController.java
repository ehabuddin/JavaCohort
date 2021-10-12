/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.VendingMachineDAOException;
import DTO.VendingMachineItem;
import ServiceLayer.InsufficientFundsException;
import ServiceLayer.NoItemInventoryException;
import ServiceLayer.VendingMachineServiceLayer;
import UI.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mdeha
 */
public class VendingMachineController {
    VendingMachineView view;
    VendingMachineServiceLayer serviceLayer;
    public VendingMachineController(VendingMachineView view, VendingMachineServiceLayer serviceLayer){
        this.view = view;
        this.serviceLayer = serviceLayer;
    }
    public void run() throws VendingMachineDAOException, InsufficientFundsException, NoItemInventoryException{
        //Load items
        List<VendingMachineItem> myItems = serviceLayer.loadVendingMachine();
        //LOOP
        view.displayItems(myItems);
        //Give user option to add money
        BigDecimal userMoney = view.getMoney();
        //Get user input (item to purchase)
        int userSelection = view.getUserSelection();
        //Check sufficient funds
        try{
            serviceLayer.checkSufficientFunds(userSelection,userMoney);
        }
        catch(Exception InsufficientFundsException){
            view.inSufficientFunds(InsufficientFundsException);
            view.printChange(userMoney.toString());
            return;
        }
        //Enough Funds, process
        try{
            String change = serviceLayer.dispenseItem(userSelection,userMoney);
            if(change.equals("X")){
                //No Change, thank you msg
                view.thankyouMsg();
            }
            else{
                //Print msg with change
                view.printChange(change);
            }            
        }catch(Exception NoItemInventoryException){
            view.updateCounter();
            view.inventoryException(NoItemInventoryException);
            view.printChange(userMoney.toString());
            
        }
    }
}
