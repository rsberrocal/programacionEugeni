/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author infot
 */
public class Examen {

    /**
     * @param args the command line arguments
     */
    public static boolean comprovaDir(String dir) {
        boolean flag;
        Path path = Paths.get(dir);
        return flag = Files.exists(path);
    }

    public static void addWithFile(String path, Pila pil) throws Exception {
        String p;
        String l[];

        String data;
        int quantitat;
        int valor;
        if (!comprovaDir(path)) {
            throw new Exception(path + " not found");
        } else {
            try (
                    FileReader in = new FileReader(path);
                    Scanner input = new Scanner(in);) {

                while (input.hasNextLine()) {           // Mentre hi hagen línies a l'arxiu ...
                    p = input.nextLine();     // Agafa una línia
                    l = p.split("\t");

                    data = l[1];
                    quantitat = Integer.parseInt(l[2]);
                    valor = Integer.parseInt(l[3]);
                    if (quantitat > 2) {
                        pil.add(data, quantitat, valor);
                    }
//                    System.out.println(l[0]+l[1]+l[2]+l[3]);
                    //pil.add(l[0], pob, sup, den);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addWithFile(String path, Queue qu) throws Exception {
        String p;
        String l[];

        String data;
        int quantitat;
        int valor;
        if (!comprovaDir(path)) {
            throw new Exception(path + " not found");
        } else {
            try (
                    FileReader in = new FileReader(path);
                    Scanner input = new Scanner(in);) {

                while (input.hasNextLine()) {           // Mentre hi hagen línies a l'arxiu ...
                    p = input.nextLine();     // Agafa una línia
                    l = p.split("\t");

                    data = l[1];
                    quantitat = Integer.parseInt(l[2]);
                    valor = Integer.parseInt(l[3]);
                    if (quantitat > 2) {
                        qu.add(data, quantitat, valor);
                    }
//                    System.out.println(l[0]+l[1]+l[2]+l[3]);
                    //pil.add(l[0], pob, sup, den);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        String path = "files/arxiu.txt";
        Pila p = new Pila();
        addWithFile(path, p);
        System.out.println("Exercici 1:\n");
        System.out.println("RESULTATS QUANTITAT > 2");
        System.out.println("--------- --------- - -");
        while (!p.isEmpty()) {
            try {
                p.printData();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("\n\nExercici 2:\n");
        Queue qu = new Queue();
        addWithFile(path, qu);
        System.out.println("RESULTATS ENTRE 100 - 120");
        System.out.println("--------- ----- --- - ---");
        while (!qu.isEmpty()) {
            try {
                qu.printData(100, 120);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
