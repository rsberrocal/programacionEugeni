/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg13.ciclistes;

import static commonfunctionssql.CommonFunctionsSQL.comprovaDir;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

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
        this.nomEquip = new Equip();
    }

    public Ciclista(int dorsal, String nom, int edat, Equip nomEquip) {
        this.dorsal = dorsal;
        this.nom = nom;
        this.edat = edat;
        this.nomEquip = nomEquip;
    }

    private void insertCiclista() throws SQLException {
        Database db = new Database();
        db.makeConnection();
        String sqlInsert = "INSERT INTO Ciclistes VALUES(?,?,?,?)";
        try (
                PreparedStatement pst = db.getConnection().prepareStatement(sqlInsert)) {
            pst.setInt(1, this.dorsal);
            pst.setString(2, this.nom);
            pst.setInt(3, this.edat);
            pst.setString(4, this.nomEquip.getNomEquip());
            pst.execute();

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        db.getConnection().close();
    }

    public void dadesCiclista() throws Exception {
        String path = "files/ciclista";
        if (!comprovaDir(path)) {
            throw new Exception(path + " not found");
        } else {
            String p;
            String[] l;

            try (
                    FileReader in = new FileReader(path);
                    Scanner input = new Scanner(in);) {

                while (input.hasNextLine()) {           // Mentre hi hagen línies a l'arxiu ...
                    p = input.nextLine();     // Agafa una línia
                    l = p.split("\t");
                    this.dorsal = Integer.parseInt(l[0]);
                    this.nom = l[1];
                    this.edat = Integer.parseInt(l[2]);
                    this.nomEquip.setNomEquip(l[3]);
                    this.insertCiclista();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                System.out.println("");
            } catch (NumberFormatException number) {
                System.out.println("");
            }
        }
        System.out.println("Se han introduït tots els Equips");
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
