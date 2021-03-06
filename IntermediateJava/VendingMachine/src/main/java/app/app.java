/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Controllers.VendingMachineController;
import DAO.VendingMachineAuditDAO;
import DAO.VendingMachineAuditDAOImpl;
import DAO.VendingMachineDAO;
import DAO.VendingMachineDAOException;
import ServiceLayer.InsufficientFundsException;
import ServiceLayer.NoItemInventoryException;
import ServiceLayer.VendingMachineServiceLayer;
import UI.UserIO;
import UI.UserIOImpl;
import UI.VendingMachineView;
import java.io.IOException;

/**
 *
 * @author mdeha
 */
public class app {
    public static void main(String[] args) throws VendingMachineDAOException, InsufficientFundsException, NoItemInventoryException, IOException {
        UserIO io = new UserIOImpl();
        VendingMachineView view = new VendingMachineView(io);
        VendingMachineDAO dao = new VendingMachineDAO();
        VendingMachineAuditDAO audit = new VendingMachineAuditDAOImpl(); 
        VendingMachineServiceLayer serviceLayer = new VendingMachineServiceLayer(dao, audit);
        VendingMachineController controller = new VendingMachineController(view, serviceLayer);
        controller.run();
    }
}
