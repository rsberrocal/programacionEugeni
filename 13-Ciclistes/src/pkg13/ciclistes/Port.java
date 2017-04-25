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
public class Port {

    private String nomPort;//PK
    private int alcada;
    private String categoria;
    private double pendent;
    private Etapa nEtapa;//FK de Etapa
    private Ciclista dorsal;//FK de Ciclista

    public Port() {
        this.nEtapa=new Etapa();
        this.dorsal=new Ciclista();
    }

    public Port(String nomPort, int alcada, String categoria, double pendent, Etapa nEtapa, Ciclista dorsal) {
        this.nomPort = nomPort;
        this.alcada = alcada;
        this.categoria = categoria;
        this.pendent = pendent;
        this.nEtapa = nEtapa;
        this.dorsal = dorsal;
    }

    private void insertPort() throws SQLException {
        Database db = new Database();
        db.makeConnection();
        String sqlInsert = "INSERT INTO Ports VALUES(?,?,?,?,?,?)";
        try (
                PreparedStatement pst = db.getConnection().prepareStatement(sqlInsert)) {
            pst.setString(1, this.nomPort);
            pst.setInt(2, this.alcada);
            pst.setString(3, this.categoria);
            pst.setDouble(4, this.pendent);
            pst.setInt(5, this.nEtapa.getnEtapa());
            pst.setInt(6, this.dorsal.getDorsal());
            pst.execute();

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        db.getConnection().close();
    }

    public void dadesPort() throws Exception {
        String path = "files/puerto";
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
                    this.nomPort = l[0];
                    this.alcada = Integer.parseInt(l[1]);
                    this.categoria = l[2];
                    this.pendent = Double.parseDouble(l[3]);
                    this.nEtapa.setnEtapa(Integer.parseInt(l[4]));
                    this.dorsal.setDorsal(Integer.parseInt(l[5]));
                    this.insertPort();
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

    public String getNomPort() {
        return nomPort;
    }

    public void setNomPort(String nomPort) {
        this.nomPort = nomPort;
    }

    public int getAlcada() {
        return alcada;
    }

    public void setAlcada(int alcada) {
        this.alcada = alcada;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPendent() {
        return pendent;
    }

    public void setPendent(double pendent) {
        this.pendent = pendent;
    }

    public Etapa getnEtapa() {
        return nEtapa;
    }

    public void setnEtapa(Etapa nEtapa) {
        this.nEtapa = nEtapa;
    }

    public Ciclista getDorsal() {
        return dorsal;
    }

    public void setDorsal(Ciclista dorsal) {
        this.dorsal = dorsal;
    }

}
