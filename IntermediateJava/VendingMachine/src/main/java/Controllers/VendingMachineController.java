/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ServiceLayer.VendingMachineServiceLayer;
import UI.VendingMachineView;

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
    public void run(){
        //Load items
        //Give user option to add money
        //Get user input (item to purchase)
        //Check sufficient funds
        //update inventory
        //Show success msg.
    }
}
