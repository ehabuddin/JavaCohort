/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.application;


import com.mycompany.vendingmachine.Controllers.VendingMachineController;
import com.mycompany.vendingmachine.DAO.VendingMachineDAOException;
import com.mycompany.vendingmachine.ServiceLayer.InsufficientFundsException;
import com.mycompany.vendingmachine.ServiceLayer.NoItemInventoryException;
import java.io.IOException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author mdeha
 */
public class app {
    public static void main(String[] args) throws VendingMachineDAOException, InsufficientFundsException, NoItemInventoryException, IOException {
        
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.mycompany.vendingmachine");
        appContext.refresh();
        VendingMachineController controller = appContext.getBean("vendingMachineController", VendingMachineController.class);
        controller.run();
        /*
        UserIO io = new UserIOImpl();
        VendingMachineView view = new VendingMachineView(io);
        VendingMachineDAO dao = new VendingMachineDAO();
        VendingMachineAuditDAO audit = new VendingMachineAuditDAOImpl(); 
        VendingMachineServiceLayer serviceLayer = new VendingMachineServiceLayer(dao, audit);
        VendingMachineController controller = new VendingMachineController(view, serviceLayer);
        controller.run();
        */
    }
}
