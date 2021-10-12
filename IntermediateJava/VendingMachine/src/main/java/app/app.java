/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Controllers.VendingMachineController;
import DAO.VendingMachineDAO;
import DAO.VendingMachineDAOException;
import ServiceLayer.InsufficientFundsException;
import ServiceLayer.NoItemInventoryException;
import ServiceLayer.VendingMachineServiceLayer;
import UI.UserIO;
import UI.UserIOImpl;
import UI.VendingMachineView;

/**
 *
 * @author mdeha
 */
public class app {
    public static void main(String[] args) throws VendingMachineDAOException, InsufficientFundsException, NoItemInventoryException {
        UserIO io = new UserIOImpl();
        VendingMachineView view = new VendingMachineView(io);
        VendingMachineDAO dao = new VendingMachineDAO();
        VendingMachineServiceLayer serviceLayer = new VendingMachineServiceLayer(dao);
        VendingMachineController controller = new VendingMachineController(view, serviceLayer);
        controller.run();
        
        
        
        
    }
}
