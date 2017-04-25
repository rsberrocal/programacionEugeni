/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg13.ciclistes;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import static commonfunctionssql.CommonFunctionsSQL.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author infot
 */
public class Equip {

    private String nomEquip;// PK
    private String director;

    public Equip() {
    }

    public Equip(String nomEquip, String director) {
        this.nomEquip = nomEquip;
        this.director = director;
    }

    private void insertEquip() throws SQLException {
        Database db = new Database();
        db.makeConnection();
        String sqlInsert = "INSERT INTO Equips VALUES(?,?)";
        try (
                PreparedStatement pst = db.getConnection().prepareStatement(sqlInsert)) {
            pst.setString(1, this.nomEquip);
            pst.setString(2, this.director);
            pst.execute();

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        db.getConnection().close();
    }

    public void dadesEquip() throws Exception {
        String path = "files/equip";
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
                    l = p.split("&");
                    this.nomEquip = l[0];
                    this.director = l[1];
                    this.insertEquip();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                System.out.println("");
            }
        }
        System.out.println("Se han introduït tots els Equips");
    }

    public String getNomEquip() {
        return nomEquip;
    }

    public void setNomEquip(String nomEquip) {
        this.nomEquip = nomEquip;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
