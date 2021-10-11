/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Controllers.VendingMachineController;
import DAO.VendingMachineDAO;
import ServiceLayer.VendingMachineServiceLayer;
import UI.VendingMachineView;

/**
 *
 * @author mdeha
 */
public class app {
    public static void main(String[] args) {
        VendingMachineView view = new VendingMachineView();
        VendingMachineDAO dao = new VendingMachineDAO();
        VendingMachineServiceLayer serviceLayer = new VendingMachineServiceLayer(dao);
        VendingMachineController controller = new VendingMachineController(view, serviceLayer);
        controller.run();
    }
}
