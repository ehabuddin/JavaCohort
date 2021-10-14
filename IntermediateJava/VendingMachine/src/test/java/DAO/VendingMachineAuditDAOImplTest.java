/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class VendingMachineAuditDAOImplTest {
    
    public VendingMachineAuditDAOImplTest() {
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
     * Test of writeAuditEntry method, of class VendingMachineAuditDAOImpl.
     */
    @Test
    public void testWriteAuditEntry() throws Exception {
        System.out.println("writeAuditEntry");
        String entry = "";
        VendingMachineAuditDAOImpl instance = new VendingMachineAuditDAOImpl();
        instance.writeAuditEntry(entry);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
