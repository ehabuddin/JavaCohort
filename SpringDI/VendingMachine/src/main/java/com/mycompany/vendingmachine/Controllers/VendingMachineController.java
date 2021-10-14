/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.Controllers;

import com.mycompany.vendingmachine.DAO.VendingMachineDAOException;
import com.mycompany.vendingmachine.DTO.VendingMachineItem;
import com.mycompany.vendingmachine.ServiceLayer.InsufficientFundsException;
import com.mycompany.vendingmachine.ServiceLayer.NoItemInventoryException;
import com.mycompany.vendingmachine.ServiceLayer.VendingMachineServiceLayer;
import com.mycompany.vendingmachine.UI.VendingMachineView;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




/**
 *
 * @author mdeha
 */
@Component
public class VendingMachineController {
    @Autowired
    VendingMachineView view;
    @Autowired
    VendingMachineServiceLayer serviceLayer;

    public VendingMachineController(VendingMachineView view, VendingMachineServiceLayer serviceLayer) {
        this.view = view;
        this.serviceLayer = serviceLayer;
    }

    public void run() throws VendingMachineDAOException, InsufficientFundsException, NoItemInventoryException, IOException {
        //Load items
        List<VendingMachineItem> myItems = serviceLayer.loadVendingMachine();
        boolean notEnoughFunds;
        while (true) {
            notEnoughFunds = false;
            view.displayItems(myItems);
            //Give user option to add money
            BigDecimal userMoney = view.getMoney();
            //userMoney.setScale(2,RoundingMode.HALF_UP);
            //Get user input (item to purchase)
            int userSelection = view.getUserSelection();
            //Check sufficient funds
            try {
                serviceLayer.checkSufficientFunds(userSelection, userMoney);
            } catch (Exception InsufficientFundsException) {
                view.inSufficientFunds(InsufficientFundsException);
                view.printChange(userMoney.toString());
                notEnoughFunds = true;
            }
            //Enough Funds, process
            if(notEnoughFunds){
            
            }
            else{
                try {
                String change = serviceLayer.dispenseItem(userSelection, userMoney);
                if (change.equals("X")) {
                    //No Change, thank you msg
                    view.thankyouMsg();
                } else {
                    //Print msg with change
                    view.printChange(change);
                }
                } catch (Exception NoItemInventoryException) {                
                    view.inventoryException(NoItemInventoryException);
                    view.printChange(userMoney.toString());

                }
            }
            view.updateCounter();
            //Prompt user to continue
            boolean continueSession = view.userSelectionContinue();
            if(continueSession){
                //Nothing to do
            }
            else{
                //save data
                serviceLayer.saveData();
                break;
            }
        }
    }
}
