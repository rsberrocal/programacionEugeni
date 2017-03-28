/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8.listperson;

/**
 *
 * @author infot
 */
public class NodeList {

    String Nom;
    char Sexe;
    double Salari;
    NodeList Next;

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

    public NodeList getNext() {
        return Next;
    }

    public void setNext(NodeList Next) {
        this.Next = Next;
    }

    public NodeList(String nom, char sexe, double salari) {
        this.Nom = nom;
        this.Sexe = sexe;
        this.Salari = salari;
        this.Next = null;
    }

    public NodeList(String nom, char sexe, double salari, NodeList Next) {
        this.Nom = nom;
        this.Sexe = sexe;
        this.Salari = salari;
        this.Next = Next;
    }
}
