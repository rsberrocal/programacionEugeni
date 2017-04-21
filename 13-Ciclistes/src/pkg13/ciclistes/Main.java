/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg13.ciclistes;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author infot
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static Scanner in = new Scanner(System.in);

    public static int mainMenu() {
        int opt = 0;
        System.out.println("\n\tMenu Ciclistes");
        System.out.println("\t---- ---------\n");
        System.out.println("\t1) Esborrar taules");
        System.out.println("\t2) Crear taules");
        System.out.println("\t3) Equips");
        System.out.println("\t4) Ciclistes");
        System.out.println("\t5) Etapes");
        System.out.println("\t6) Maillots");
        System.out.println("\t7) Ports\n");
        System.out.println("\t0) Sortir");
        opt = in.nextInt();
        return opt;
    }

    public static int ctMenu() {
        int opt;
        System.out.println("\n\tMenu Ciclistes");
        System.out.println("\t---- ---------\n");
        System.out.println("\t1) Llevar");
        System.out.println("\t2) Equips");
        System.out.println("\t3) Ciclistes");
        System.out.println("\t4) Etapes");
        System.out.println("\t5) Maillots");
        System.out.println("\t6) Ports");
        System.out.println("\t7) Crear totes les taules\n");
        System.out.println("\t0) Sortir");
        opt = in.nextInt();
        return opt;
    }

    public static void createTables() throws SQLException {
        int opt;
        database db = new database();
        opt = ctMenu();
        switch (opt) {
            case 0:
                break;
            case 1:
                db.createTable(1);
                break;
            case 2:
                db.createTable(2);
                break;
            case 3:
                db.createTable(3);
                break;
            case 4:
                db.createTable(4);
                break;
            case 5:
                db.createTable(5);
                break;
            case 6:
                db.createTable(6);
                break;
            case 7:
                db.createTable(7);
                break;
        }

    }

    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        int optMain;

        do {
            optMain = mainMenu();
            switch (optMain) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    createTables();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("\tOpció incorrecta");
                    break;
            }
        } while (optMain != 0);
    }

}