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
public class Llevar {

    private Ciclista dorsal;//PK y FK de Ciclista
    private Etapa nEtapa;//PK y FK de Etapa
    private Maillot codi;//PK y FK de Maillot

    public Llevar() {
        this.dorsal = new Ciclista();
        this.nEtapa = new Etapa();
        this.codi = new Maillot();
    }

    public Llevar(Ciclista dorsal, Etapa nEtapa, Maillot codi) {
        this.dorsal = dorsal;
        this.nEtapa = nEtapa;
        this.codi = codi;
    }

    private void insertLlevar() throws SQLException {
        Database db = new Database();
        db.makeConnection();
        String sqlInsert = "INSERT INTO Llevar VALUES(?,?,?)";
        try (
                PreparedStatement pst = db.getConnection().prepareStatement(sqlInsert)) {
            pst.setInt(1, this.dorsal.getDorsal());
            pst.setInt(2, this.nEtapa.getnEtapa());
            pst.setString(3, this.codi.getCodi());
            pst.execute();

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        db.getConnection().close();
    }

    public void dadesLlevar() throws Exception {
        String path = "files/llevar";
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
                    this.dorsal.setDorsal(Integer.parseInt(l[0]));
                    this.nEtapa.setnEtapa(Integer.parseInt(l[1]));
                    this.codi.setCodi(l[2]);
                    this.insertLlevar();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                System.out.println("");
            } catch (NumberFormatException number) {
                System.out.println("");
            }
        }
        System.out.println("Se han introduït tots els registres");
    }

    public Ciclista getDorsal() {
        return dorsal;
    }

    public void setDorsal(Ciclista dorsal) {
        this.dorsal = dorsal;
    }

    public Etapa getnEtapa() {
        return nEtapa;
    }

    public void setnEtapa(Etapa nEtapa) {
        this.nEtapa = nEtapa;
    }

    public Maillot getCodi() {
        return codi;
    }

    public void setCodi(Maillot codi) {
        this.codi = codi;
    }
}
