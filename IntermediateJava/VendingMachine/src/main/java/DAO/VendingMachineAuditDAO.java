/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author mdeha
 */
public interface VendingMachineAuditDAO {
    public void writeAuditEntry(String entry) throws VendingMachineDAOException;
}
