/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.DAO;

import com.mycompany.flooringmastery.DTO.Order;
import com.mycompany.flooringmastery.ServiceLayer.OrderNotFoundException;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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
public class FlooringMasteryDAOTest {
    
    public FlooringMasteryDAOTest() {
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
     * Test of getStates method, of class FlooringMasteryDAO.
     */
    @Test
    public void testGetStates() throws FileNotFoundException {
        System.out.println("getStates");
        FlooringMasteryDAO instance = new FlooringMasteryDAO();
        
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("TX");
        expResult.add("WA");
        expResult.add("KY");
        expResult.add("CA");
        
        
        instance.loadStates();
        ArrayList<String> result = instance.getStates();
        
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getProducts method, of class FlooringMasteryDAO.
     */
    @Test
    public void testGetProducts() throws FileNotFoundException {
        System.out.println("getProducts");
        FlooringMasteryDAO instance = new FlooringMasteryDAO();
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Carpet");
        expResult.add("Laminate");
        expResult.add("Tile");
        expResult.add("Wood");
        
        instance.loadProducts();
        
        ArrayList<String> result = instance.getProducts();
        Collections.sort(result);
        
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getOrderToDelete method, of class FlooringMasteryDAO.
     */
    @Test
    public void testGetOrderToDelete() throws Exception {
        System.out.println("getOrderToDelete");
        String date = "10202021";
        int orderNum = 4;
        FlooringMasteryDAO instance = new FlooringMasteryDAO();
        instance.loadOrders();
        Order expResult = instance.getOrder(orderNum);
        //System.out.println(expResult.getCustomerName());
//        expResult.setCustomerName("Ehabuddin Mohammed");
//        expResult.setState("TX");
//        expResult.setTaxRate(new BigDecimal("4.45"));
//        expResult.setProductType("Tile");
//        expResult.setArea(new BigDecimal("203"));
//        expResult.setCostPerSquareFoot(new BigDecimal("4.15"));
//        expResult.setLaborCostperSquareFoot(new BigDecimal("3.50"));
//        expResult.setMaterialCost(new BigDecimal("842.45"));
//        expResult.setLaborCost(new BigDecimal("710.50"));
//        expResult.setTax(new BigDecimal("69"));
//        expResult.setTotal(new BigDecimal("1621.95"));
        
        Order result = instance.getOrderToDelete(date, orderNum);
        //System.out.println(result.getCustomerName());
        assertTrue(expResult.equals(result));
        
        
        
        date = "10202021";
        orderNum = 1;
        expResult = instance.getOrder(orderNum);
        try{
            result = instance.getOrderToDelete(date, orderNum);
            fail("Exception NOT Reached");
        }catch(OrderNotFoundException e){
            //assertTrue(true);
        }
        
        
        
    }
    
}
