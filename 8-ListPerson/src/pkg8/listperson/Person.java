/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8.listperson;

/**
 *
 * @author Richard
 */
public class Person {

    String Nom;
    char Sexe;
    double Salari;

    public Person() {
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public char getSexe() {
        return Sexe;
    }

    public void setSexe(char Sexe) {
        this.Sexe = Sexe;
    }

    public double getSalari() {
        return Salari;
    }

    public void setSalari(double Salari) {
        this.Salari = Salari;
    }

    public Person(String Nom, char Sexe, double Salari) {
        this.Nom = Nom;
        this.Sexe = Sexe;
        this.Salari = Salari;
    }
}
