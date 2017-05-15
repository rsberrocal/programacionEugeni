/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author infot
 */
public class PersonTest {

    public PersonTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Person.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLetter method, of class Person.
     */
    @Test
    public void testGetLetter() {
        System.out.println("getLetter");
        int dniUser = 0;
        Person instance = new Person();
        char expResult = ' ';
        char result = instance.getLetter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Person.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Person instance = new Person();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalary method, of class Person.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        Person instance = new Person();
        double expResult = 0.0;
        double result = instance.getSalary();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSalary method, of class Person.
     */
    @Test
    public void testSetSalary() {
        System.out.println("setSalary");
        double salary = 0.0;
        Person instance = new Person();
        instance.setSalary(salary);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDni method, of class Person.
     */
    @Test
    public void testGetDni() {
        System.out.println("getDni");
        Person instance = new Person();
        int expResult = 0;
        int result = instance.getDni();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDni method, of class Person.
     */
    @Test
    public void testSetDni() {
        System.out.println("setDni");
        int dni = 0;
        Person instance = new Person();
        instance.setDni(dni);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
