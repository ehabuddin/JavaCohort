/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DTO.VendingMachineItem;
import java.math.BigDecimal;
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
public class VendingMachineServiceLayerTest {
    
    public VendingMachineServiceLayerTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    /*
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
    */

    /**
     * Test of checkSufficientFunds method, of class VendingMachineServiceLayer.
     */
    @org.junit.jupiter.api.Test
    public void testCheckSufficientFunds() throws Exception {
        System.out.println("checkSufficientFunds");
        int selection = 0;
        BigDecimal money = null;
        VendingMachineServiceLayer instance = null;
        instance.checkSufficientFunds(selection, money);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dispenseItem method, of class VendingMachineServiceLayer.
     */
    @org.junit.jupiter.api.Test
    public void testDispenseItem() throws Exception {
        System.out.println("dispenseItem");
        int selection = 0;
        BigDecimal money = null;
        VendingMachineServiceLayer instance = null;
        String expResult = "";
        String result = instance.dispenseItem(selection, money);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
