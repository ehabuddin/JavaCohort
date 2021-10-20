/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.ServiceLayer;

import com.mycompany.flooringmastery.DAO.FlooringMasteryDAO;
import com.mycompany.flooringmastery.DTO.Order;
import com.mycompany.flooringmastery.DTO.Taxes;
import java.math.BigDecimal;
import java.util.ArrayList;
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
public class FlooringMasteryServiceLayerTest {
    
    public FlooringMasteryServiceLayerTest() {
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
     * Test of getAllOrders method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testGetAllOrders() throws Exception {
        //Get ALL ORDERS FOR A DATE
        System.out.println("getAllOrders");
        String date = "10202021";
        FlooringMasteryServiceLayer instance = new FlooringMasteryServiceLayer(new FlooringMasteryDAO());
        String expResult = "OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total\n" +
"4,Ehabuddin Mohammed,KY,6.00,Laminate,136,2.10,1.75,285.60,238.00,31,554.60\n" +
"7,Iron Man,CA,25.00,Wood,169.69,4.75,5.15,806.03,873.90,420,2099.93\n";
        String result = instance.getAllOrders(date);
        assertEquals(expResult, result);
    }


    /**
     * Test of edit method, of class FlooringMasteryServiceLayer.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        String date = "10202021";
        int orderNum = 7;
        FlooringMasteryServiceLayer instance = new FlooringMasteryServiceLayer(new FlooringMasteryDAO());
        instance.loadInfo();
        Order expResult = instance.dao.getOrder(orderNum);
        Order result = instance.edit(date, orderNum);
        assertEquals(expResult, result);
        
    }
}
