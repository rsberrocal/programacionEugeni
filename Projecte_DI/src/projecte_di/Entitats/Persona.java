/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_di.Entitats;

/**
 *
 * @author Tito_Berny
 */
public class Persona {
    
    private int dni;
    private String nom;
    private int sou;

    public Persona() {
    }

    public Persona(int dni, String nom, int sou) {
        this.dni = dni;
        this.nom = nom;
        this.sou = sou;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSou(int sou) {
        this.sou = sou;
    }

    public int getDni() {
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public int
         getSou() {
        return sou;
    }

    public char getNif(int dni) {
        char Lletra;
        int calcul;
        char[] v = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E',};

        calcul = dni % 23;
        //lletra = Busca_lletra(calcul);
        Lletra = v[calcul];
        return Lletra;
    }
    
}
