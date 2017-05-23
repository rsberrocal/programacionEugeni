/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_di.Entitats;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tito_Berny
 */
public class GestorPersones {

    public GestorPersones() {
    }
    
    public List<Persona> emmagatzemar_persones (List<Persona> lista, Persona p){
        
        lista.add(p);                                    //afegim objecte a la llista
        
        return lista;
    }
    
    public void Eliminar_Persones (List<Persona> lista, int dni) {
        
        for (int i = 1; i < lista.size(); i++) {
            if (dni == lista.get(i).getDni()){
                lista.remove(i);                         //eliminem tots els registres
            }
        }
    }
    
    public int recomte (List<Persona> lista) {
        
        int c = lista.size();
     
        return c;
    }
    
    public List<Persona> esborrar_llista (List<Persona> lista) {
    
        for (int i = 1; i < lista.size(); i++) {
                lista.remove(i);                     //esborrem tots els regitres
        }

        return lista;
    }
    
    public int calcular_sous (List<Persona> lista) {
    
        int sous = 0;
        
        for (int i = 1; i < lista.size(); i++) {
            sous = sous + lista.get(i).getSou();     // fem la suma de tots els sous de la llista
        }
        
        return sous;
    }  
    
} 
