/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packImpotSurSociete;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TP3
 */
public class ImpotSurSocieteIT {
    
    public ImpotSurSocieteIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of rechercher method, of class ImpotSurSociete.
     */
    @Test
    public void testRechercher() {
        System.out.println("rechercher");
        ImpotSurSociete instance = new ImpotSurSociete();
        instance.rechercher();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lister method, of class ImpotSurSociete.
     */
    @Test
    public void testLister() {
        System.out.println("lister");
        ImpotSurSociete instance = new ImpotSurSociete();
        instance.lister();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estNumerique method, of class ImpotSurSociete.
     */
    @Test
    public void testEstNumerique() {
        System.out.println("estNumerique");
        String st = "";
        ImpotSurSociete instance = new ImpotSurSociete();
        boolean expResult = false;
        boolean result = instance.estNumerique(st);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class ImpotSurSociete.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ImpotSurSociete.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
