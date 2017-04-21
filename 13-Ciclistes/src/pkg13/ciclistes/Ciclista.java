/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg13.ciclistes;

/**
 *
 * @author infot
 */
public class Ciclista {

    private int dorsal;// PK
    private String nom;
    private int edat;
    private Equip nomEquip;//FK de Equip

    public Ciclista() {

    }

    public Ciclista(int dorsal, String nom, int edat, Equip nomEquip) {
        this.dorsal = dorsal;
        this.nom = nom;
        this.edat = edat;
        this.nomEquip = nomEquip;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public Equip getNomEquip() {
        return nomEquip;
    }

    public void setNomEquip(Equip nomEquip) {
        this.nomEquip = nomEquip;
    }

}
