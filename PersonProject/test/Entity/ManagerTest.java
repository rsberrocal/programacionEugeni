/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author infot
 */
public class ManagerTest {
    
    public ManagerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTotalSalary method, of class Manager.
     */
    @Test
    public void testGetTotalSalary() {
        System.out.println("getTotalSalary");
        Manager instance = new Manager();
        double expResult = 0.0;
        double result = instance.getTotalSalary();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPerson method, of class Manager.
     */
    @Test
    public void testAddPerson() {
        System.out.println("addPerson");
        Person p = null;
        Manager instance = new Manager();
        instance.addPerson(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getP method, of class Manager.
     */
    @Test
    public void testGetP() {
        System.out.println("getP");
        Manager instance = new Manager();
        Person expResult = null;
        Person result = instance.getP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setP method, of class Manager.
     */
    @Test
    public void testSetP() {
        System.out.println("setP");
        Person p = null;
        Manager instance = new Manager();
        instance.setP(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getL method, of class Manager.
     */
    @Test
    public void testGetL() {
        System.out.println("getL");
        Manager instance = new Manager();
        List<Person> expResult = null;
        List<Person> result = instance.getL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setL method, of class Manager.
     */
    @Test
    public void testSetL() {
        System.out.println("setL");
        List<Person> l = null;
        Manager instance = new Manager();
        instance.setL(l);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
