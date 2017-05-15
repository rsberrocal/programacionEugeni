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

    private Person p;
    private Manager m;

    public PersonTest() {
    }

    @Before
    public void setUp() {
        p = new Person("Richard", 544.23, 49502368);
        m = new Manager();
    }

    @After
    public void tearDown() {
        p = null;
        m = null;
    }

    /**
     * Test of getName method, of class Person.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Person instance = p;
        String expResult = "Richard";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLetter method, of class Person.
     */
    @Test
    public void testGetLetter() {
        System.out.println("getLetter");
        Person instance = p;
        char expResult = 'C';
        char result = instance.getLetter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Person.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Richard2";
        Person instance = p;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSalary method, of class Person.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        Person instance = p;
        double expResult = 544.23;
        double result = instance.getSalary();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSalary method, of class Person.
     */
    @Test
    public void testSetSalary() {
        System.out.println("setSalary");
        double salary = 554.20;
        Person instance = p;
        instance.setSalary(salary);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDni method, of class Person.
     */
    @Test
    public void testGetDni() {
        System.out.println("getDni");
        Person instance = p;
        int expResult = 49502368;
        int result = instance.getDni();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDni method, of class Person.
     */
    @Test
    public void testSetDni() {
        System.out.println("setDni");
        int dni = 0;
        Person instance = p;
        instance.setDni(dni);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
