/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_di.Entitats;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tito_Berny
 */
public class PersonaTest {
    
    
    private Persona p;
    
    public PersonaTest() {
    }
   
    
    @Before
    public void setUp() {
         p = new Persona(47589675, "Pepe", 1500);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setDni method, of class Persona.
     */
    @Test
    public void testSetDni() {
        System.out.println("setDni");
        int dni = 12345678;
        p.setDni(dni);
        assertEquals(12345678, p.getDni());
    }

    /**
     * Test of setNom method, of class Persona.
     */
    @Test
    public void testSetNom() {
        System.out.println("setNom");
        String nom = "Manolo";
        p.setNom(nom);
        assertEquals("Manolo", p.getNom());

    }

    /**
     * Test of setSou method, of class Persona.
     */
    @Test
    public void testSetSou() {
        System.out.println("setSou");
        int sou =1400;
        p.setSou(sou);
        assertEquals(1400.5, p.getSou(), 0.0);
    }

    /**
     * Test of getDni method, of class Persona.
     */
    @Test
    public void testGetDni() {
        System.out.println("getDni");
        assertEquals(47589675, p.getDni());
        
    }

    /**
     * Test of getNom method, of class Persona.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        assertEquals("Pepe", p.getNom());
        
    }

    /**
     * Test of getSou method, of class Persona.
     */
    @Test
    public void testGetSou() {
        System.out.println("getSou");
        assertEquals(1500, p.getSou(), 0.0);
       
    }

    /**
     * Test of getNif method, of class Persona.
     */
    @Test
    public void testGetNif() {
        System.out.println("getNif");
        int dni = 12345678;
        char expResult = ' ';
        char result = p.getNif(dni);
        assertEquals('Z', result);
    }
    
}
