/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.DAO;

import com.mycompany.vendingmachine.DTO.VendingMachineItem;
import java.math.BigDecimal;
import java.util.ArrayList;
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
        //arrange
        System.out.println("getAllItems");
        VendingMachineDAO instance = new VendingMachineDAO();
        
        VendingMachineItem item1 = new VendingMachineItem("New Item1");
        item1.setItemCost(new BigDecimal("12.50"));
        item1.setNumItems(10);
        
        VendingMachineItem item2 = new VendingMachineItem("New Item2");
        item2.setItemCost(new BigDecimal("15.50"));
        item2.setNumItems(1);
        
        //act
        instance.addItem("New Item1", item1);
        instance.addItem("New Item2", item2);
        ArrayList<VendingMachineItem> expResult = new ArrayList<>();
        List<VendingMachineItem> result = instance.getAllItems();
        
        expResult.add(item1);
        expResult.add(item2);
        
        
        //assert
        assertEquals(expResult.get(0), result.get(0));
        assertEquals(expResult.get(1), result.get(1));
        
    }

    /**
     * Test of getItem method, of class VendingMachineDAO.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        VendingMachineDAO instance = new VendingMachineDAO();
                
        VendingMachineItem expResult = new VendingMachineItem("New Item1");
        expResult.setItemCost(new BigDecimal("12.50"));
        expResult.setNumItems(10);
        
        //act
        instance.addItem("New Item1", expResult);
        
        VendingMachineItem result = instance.getItem("New Item1");
        //assert
        assertEquals(expResult, result);
        
    }

    /**
     * Test of removeItem method, of class VendingMachineDAO.
     */
    @Test
    public void testRemoveItem() {
        //Arrange
        System.out.println("removeItem");
        
        VendingMachineItem expResult = new VendingMachineItem("New Item1");
        expResult.setItemCost(new BigDecimal("12.50"));
        expResult.setNumItems(10);
        
        
        VendingMachineDAO instance = new VendingMachineDAO();
        
        //Act
        instance.addItem("New Item1", expResult);
        instance.removeItem("New Item1");
        VendingMachineItem result = instance.getItem("New Item1");
        //Assert
        assertEquals(result.getNumItems(), 9);
        
    }
    
}
