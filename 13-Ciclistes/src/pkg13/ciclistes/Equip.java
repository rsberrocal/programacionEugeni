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
                    l = p.split("\t");                   
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
