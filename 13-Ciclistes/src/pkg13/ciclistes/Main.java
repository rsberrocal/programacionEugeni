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
        System.out.println("\n\tBase de dades de Ciclistes");
        System.out.println("\t---- ---------\n");
        System.out.println("\t1) Esborrar taules");
        System.out.println("\t2) Crear taules");
        System.out.println("\t3) Equips");
        System.out.println("\t4) Ciclistes");
        System.out.println("\t5) Etapes");
        System.out.println("\t6) Maillots");
        System.out.println("\t7) Ports\n");
        System.out.println("\t8) Llevar\n");
        System.out.println("\t0) Sortir");
        opt = in.nextInt();
        return opt;
    }

    public static int ctMenu() {
        int opt;
        System.out.println("\n\tQue vols crear\n");
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

    public static int dtMenu() {
        int opt;
        System.out.println("\n\tQue vols eliminar?\n");
        System.out.println("\t1) Llevar");
        System.out.println("\t2) Equips");
        System.out.println("\t3) Ciclistes");
        System.out.println("\t4) Etapes");
        System.out.println("\t5) Maillots");
        System.out.println("\t6) Ports");
        System.out.println("\t7) Borrar totes les taules\n");
        System.out.println("\t0) Sortir");
        opt = in.nextInt();
        return opt;
    }

    public static int submenuTables(String table) {
        int opt = 0;
        System.out.println("\n\tMenu " + table);
        System.out.println("\t---- ---------\n");
        System.out.println("\t1) Nou " + table);
        System.out.println("\t2) Llistar " + table);
        System.out.println("\n\t0) Sortir");
        opt = in.nextInt();
        return opt;
    }

    public static void equips() throws Exception {
        int opt;
        opt = submenuTables("Equips");
        switch (opt) {
            case 0:
                break;
            case 1:
                Equip e = new Equip();
                e.dadesEquip();
                break;
            default:
                System.out.println("\tOpció incorrecta");
                break;
        }
    }

    public static void ciclista() throws Exception {
        int opt;
        opt = submenuTables("Ciclista");
        switch (opt) {
            case 0:
                break;
            case 1:
                Ciclista e = new Ciclista();
                e.dadesCiclista();
                break;
            default:
                System.out.println("\tOpció incorrecta");
                break;
        }
    }

    public static void etapes() throws Exception {
        int opt;
        opt = submenuTables("Etapa");
        switch (opt) {
            case 0:
                break;
            case 1:
                Etapa e = new Etapa();
                e.dadesEtapa();
                break;
            default:
                System.out.println("\tOpció incorrecta");
                break;
        }
    }

    public static void llevar() throws Exception {
        int opt;
        opt = submenuTables("Llevar");
        switch (opt) {
            case 0:
                break;
            case 1:
                Llevar e = new Llevar();
                e.dadesLlevar();
                break;
            default:
                System.out.println("\tOpció incorrecta");
                break;
        }
    }

    public static void maillot() throws Exception {
        int opt;
        opt = submenuTables("Maillot");
        switch (opt) {
            case 0:
                break;
            case 1:
                Maillot e = new Maillot();
                e.dadesMaillot();
                break;
            default:
                System.out.println("\tOpció incorrecta");
                break;
        }
    }

    public static void port() throws Exception {
        int opt;
        opt = submenuTables("Port");
        switch (opt) {
            case 0:
                break;
            case 1:
                Port e = new Port();
                e.dadesPort();
                break;
            default:
                System.out.println("\tOpció incorrecta");
                break;
        }
    }

    public static void dropTables() throws SQLException {
        int opt;
        Database db = new Database();
        opt = dtMenu();
        switch (opt) {
            case 0:
                break;
            case 1:
                db.dropTables(1);
                break;
            case 2:
                db.dropTables(2);
                break;
            case 3:
                db.dropTables(3);
                break;
            case 4:
                db.dropTables(4);
                break;
            case 5:
                db.dropTables(5);
                break;
            case 6:
                db.dropTables(6);
                break;
            case 7:
                db.dropTables(7);
                break;
            default:
                System.out.println("\tOpció incorrecta");
                break;
        }
    }

    public static void createTables() throws SQLException {
        int opt;
        Database db = new Database();
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
            default:
                System.out.println("\tOpció incorrecta");
                break;
        }

    }

    public static void main(String[] args) throws SQLException, Exception {
        // TODO code application logic here
        int optMain;
        Class.forName("org.mariadb.jdbc.Driver");
        do {
            optMain = mainMenu();
            switch (optMain) {
                case 0:
                    break;
                case 1:
                    dropTables();
                    break;
                case 2:
                    createTables();
                    break;
                case 3:
                    equips();
                    break;
                case 4:
                    ciclista();
                    break;
                case 5:
                    etapes();
                    break;
                case 6:
                    maillot();
                    break;
                case 7:
                    port();
                    break;
                case 8:
                    llevar();
                    break;
                default:
                    System.out.println("\tOpció incorrecta");
                    break;
            }
        } while (optMain != 0);
    }

}
