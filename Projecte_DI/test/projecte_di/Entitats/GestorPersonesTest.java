/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_di.Entitats;

import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tito_Berny
 */
public class GestorPersonesTest {
    
    private GestorPersones gp;
    private Persona p;
    private List<Persona> lista;
    
    public GestorPersonesTest() {
    }
    
    @Before
    public void setUp() {
        
        Persona per1 = new Persona(12345678, "Manolo",1560);
        lista.add(per1);
        Persona per2 = new Persona(87654321, "Angel",1300);
        lista.add(per2);
        Persona per3 = new Persona(14725836, "Carlos", 2512);
        lista.add(per3);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of emmagatzemar_persones method, of class GestorPersones.
     */
    @Test
    public void testEmmagatzemar_persones() {
        System.out.println("emmagatzemar_persones");
        List<Persona> test = new ArrayList<>();
        
        Persona per1 = new Persona(12345678, "Manolo",1560);
        test = gp.emmagatzemar_persones(test, per1);
        Persona per2 = new Persona(87654321, "Angel", 1300);
        test = gp.emmagatzemar_persones(test, per2);
        Persona per3 = new Persona(14725836, "Carlos", 2512);
        test = gp.emmagatzemar_persones(test, per3);

        assertEquals(test, lista);
        Assert.assertEquals(12345678, 0);
    }

    /**
     * Test of Eliminar_Persones method, of class GestorPersones.
     */
    @Test
    public void testEliminar_Persones() {
        System.out.println("Eliminar_Persones");
        List<Persona> lista = null;
        int dni = 0;
        GestorPersones instance = new GestorPersones();
        instance.Eliminar_Persones(lista, dni);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recomte method, of class GestorPersones.
     */
    @Test
    public void testRecomte() {
        System.out.println("recomte");
        int expResult = 2;
        int result = gp.recomte(lista);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of esborrar_llista method, of class GestorPersones.
     */
    @Test
    public void testEsborrar_llista() {
        System.out.println("esborrar_llista");
        List<Persona> lista = null;
        GestorPersones instance = new GestorPersones();
        List<Persona> expResult = null;
        List<Persona> result = instance.esborrar_llista(lista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcular_sous method, of class GestorPersones.
     */
    @Test
    public void testCalcular_sous() {
        System.out.println("calcular_sous");
        List<Persona> lista = null;
        GestorPersones instance = new GestorPersones();
        float expResult = 0.0F;
        float result = instance.calcular_sous(lista);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
