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
public class Maillot {

    private String codi;//PK
    private String tipus;
    private String color;
    private int premi;

    public Maillot() {
    }

    private void insertMaillot() throws SQLException {
        Database db = new Database();
        db.makeConnection();
        String sqlInsert = "INSERT INTO Maillots VALUES(?,?,?,?)";
        try (
                PreparedStatement pst = db.getConnection().prepareStatement(sqlInsert)) {
            pst.setString(1, this.codi);
            pst.setString(2, this.tipus);
            pst.setString(3, this.color);
            pst.setInt(4, this.premi);
            pst.execute();

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        db.getConnection().close();
    }

    public void dadesMaillot() throws Exception {
        String path = "files/maillot";
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
                    this.codi = l[0];
                    this.tipus = l[1];
                    this.color = l[2];
                    this.premi = Integer.parseInt(l[3]);
                    this.insertMaillot();
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

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPremi() {
        return premi;
    }

    public void setPremi(int premi) {
        this.premi = premi;
    }

}
