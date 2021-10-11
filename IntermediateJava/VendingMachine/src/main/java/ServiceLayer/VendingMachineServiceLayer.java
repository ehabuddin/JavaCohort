/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DAO.VendingMachineDAO;

/**
 *
 * @author mdeha
 */
public class VendingMachineServiceLayer {
    VendingMachineDAO dao;
    
    public VendingMachineServiceLayer(VendingMachineDAO dao){
        this.dao = dao;
    }
}
