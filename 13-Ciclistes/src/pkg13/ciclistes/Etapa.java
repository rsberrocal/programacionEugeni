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
public class Etapa {

    private int nEtapa;//PK
    private int km;
    private String sortida;
    private String arribada;
    private Ciclista dorsal;//FK de Ciclista

    public Etapa() {
        this.dorsal = new Ciclista();
    }

    public Etapa(int nEtapa, int km, String sortida, String arribada, Ciclista dorsal) {
        this.nEtapa = nEtapa;
        this.km = km;
        this.sortida = sortida;
        this.arribada = arribada;
        this.dorsal = dorsal;
    }

    private void insertEtapa() throws SQLException {
        Database db = new Database();
        db.makeConnection();
        String sqlInsert = "INSERT INTO Etapes VALUES(?,?,?,?,?)";
        try (
                PreparedStatement pst = db.getConnection().prepareStatement(sqlInsert)) {
            pst.setInt(1, this.nEtapa);
            pst.setInt(2, this.km);
            pst.setString(3, this.sortida);
            pst.setString(4, this.arribada);
            pst.setInt(5, this.dorsal.getDorsal());
            pst.execute();

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        db.getConnection().close();
    }

    public void dadesEtapa() throws Exception {
        String path = "files/etapa";
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
                    this.nEtapa = Integer.parseInt(l[0]);
                    this.km = Integer.parseInt(l[1]);
                    this.sortida = l[2];
                    this.arribada = l[3];
                    this.dorsal.setDorsal(Integer.parseInt(l[4]));
                    this.insertEtapa();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                System.out.println("");
            } catch (NumberFormatException nfe) {
                System.out.println("");
            }
            
        }
        System.out.println("Se han introduït totes les etapes");
    }

    public int getnEtapa() {
        return nEtapa;
    }

    public void setnEtapa(int nEtapa) {
        this.nEtapa = nEtapa;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getSortida() {
        return sortida;
    }

    public void setSortida(String sortida) {
        this.sortida = sortida;
    }

    public String getArribada() {
        return arribada;
    }

    public void setArribada(String arribada) {
        this.arribada = arribada;
    }

    public Ciclista getDorsal() {
        return dorsal;
    }

    public void setDorsal(Ciclista dorsal) {
        this.dorsal = dorsal;
    }

}
