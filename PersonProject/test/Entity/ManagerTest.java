/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
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

    private Person p;
    private Manager m;
    private List<Person> l;

    public ManagerTest() {
    }

    @Before
    public void setUp() {
        p = new Person("Richard", 544.23, 49502368);
        m = new Manager();
        m.addPerson(p);
        l = new ArrayList<>();
        l.add(p);
    }

    @After
    public void tearDown() {
        p = null;
        m = null;
    }

    /**
     * Test of getTotalSalary method, of class Manager.
     */
    @Test
    public void testGetTotalSalary() {
        System.out.println("getTotalSalary");
        Manager instance = m;
        double expResult = 544.23;
        double result = instance.getTotalSalary();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addPerson method, of class Manager.
     */
    @Test
    public void testAddPerson() {
        System.out.println("addPerson");
        Person p = new Person("Richard2", 544.23, 49502368);
        Manager instance = m;
        instance.addPerson(p);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deletePerson method, of class Manager.
     */
    @Test
    public void testDeletePerson() {
        System.out.println("deletePerson");
        Manager instance = new Manager();
        instance.deletePerson(p);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of manyPerson method, of class Manager.
     */
    @Test
    public void testManyPerson() {
        System.out.println("manyPerson");
        Manager instance = m;
        int expResult = 1;
        int result = instance.manyPerson();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of dropList method, of class Manager.
     */
    @Test
    public void testDropList() {
        System.out.println("dropList");
        Manager instance = m;
        instance.dropList();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getL method, of class Manager.
     */
    @Test
    public void testGetL() {
        System.out.println("getL");
        Manager instance = m;
        List<Person> expResult = l;
        List<Person> result = instance.getL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setL method, of class Manager.
     */
    @Test
    public void testSetL() {
        System.out.println("setL");
        Manager instance = new Manager();
        instance.setL(l);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
