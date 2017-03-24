/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6.comarquesambcua;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author infot
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static boolean comprovaDir(String dir) {
        boolean flag;
        Path path = Paths.get(dir);
        return flag = Files.exists(path);
    }

    public static void addWithFile(String path, Queue pil) throws Exception {
        String p;
        String l[];

        int pob;
        double sup, den;
        if (!comprovaDir(path)) {
            throw new Exception(path + " not found");
        } else {
            try (
                    FileReader in = new FileReader(path);
                    Scanner input = new Scanner(in);) {

                while (input.hasNextLine()) {           // Mentre hi hagen línies a l'arxiu ...
                    p = input.nextLine();     // Agafa una línia
                    l = p.split("\t");
                    pob = Integer.parseInt(l[1]);
                    sup = Double.parseDouble(l[2]);
                    den = Double.parseDouble(l[3]);
                    pil.add(l[0], pob, sup, den);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        String path = "files/comarques.txt";
        Queue pil = new Queue();
        try {
            addWithFile(path, pil);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        while (!pil.isEmpty()) {
            try {
                pil.printData();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        pil.printMaxPoblacio();
        pil.printMaxSuperficie();
        pil.printMaxDensitat();
        pil.printAvg();
    }

}
