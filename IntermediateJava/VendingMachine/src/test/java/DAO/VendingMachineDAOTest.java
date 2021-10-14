/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.VendingMachineItem;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mdeha
 */
public class VendingMachineDAOTest {
    
    public VendingMachineDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }


    /**
     * Test of getAllItems method, of class VendingMachineDAO.
     */
    @Test
    public void testGetAllItems() {
        System.out.println("getAllItems");
        VendingMachineDAO instance = new VendingMachineDAO();
        List<VendingMachineItem> expResult = null;
        List<VendingMachineItem> result = instance.getAllItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class VendingMachineDAO.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        String itemName = "";
        VendingMachineDAO instance = new VendingMachineDAO();
        VendingMachineItem expResult = null;
        VendingMachineItem result = instance.getItem(itemName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeItem method, of class VendingMachineDAO.
     */
    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        String itemName = "";
        VendingMachineDAO instance = new VendingMachineDAO();
        instance.removeItem(itemName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
