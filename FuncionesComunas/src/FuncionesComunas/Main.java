/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncionesComunas;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author infot
 */
public class Main {

    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

    public static void Escribir(String path, String text) {
        try (BufferedWriter out = new BufferedWriter(
                new FileWriter(path, true))) {
            out.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void imprimirFichero(String path) {
        try (
                FileReader in = new FileReader(path);) {
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) (c));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] creaVector(int v1[], int n) {
        int i;
        for (i = 0; i < n; i++) {
            v1[i] = rnd.nextInt(n);
        }
        return v1;
    }

    public static boolean comprovaDir(String dir) {
        boolean flag;
        Path path = Paths.get(dir);
        return flag = Files.exists(path);
    }

    public static void BorraFitxer(String dir) throws IOException {
        String opt;
        System.out.println("Vas eliminar el següent fitxer " + dir);
        System.out.println("Estas segur? (yes/no)");
        opt = in.nextLine();
        Path path = Paths.get(dir);
        if (opt.contains("yes") || opt.contains("YES")) {
            Files.delete(path);
        }
    }

    public static void copiaFitxer(String ori, String des) throws IOException {
        Path pathOr = Paths.get(ori);
        Path pathDes = Paths.get(des);
        System.out.println("Es copiara el següent fitxer " + ori + "  a " + des);
        Files.copy(pathOr, pathDes);
    }

    public static void moureFitxer(String ori, String des) throws IOException {
        Path pathOr = Paths.get(ori);
        Path pathDes = Paths.get(des);
        System.out.println("Es moura el següent fitxer " + ori + "  a " + des);
        Files.move(pathOr, pathDes);
    }

    public static void moureFitxerSimple(String ori, String des) throws IOException {
        Path pathOr = Paths.get(ori);
        Path pathDes = Paths.get(des);
        Files.move(pathOr, pathDes);
    }

    public static void copiaFitxerSimple(String ori, String des) throws IOException {
        Path pathOr = Paths.get(ori);
        Path pathDes = Paths.get(des);
        Files.copy(pathOr, pathDes);
    }

    public static void BorraFitxerSimple(String dir) throws IOException {

        Path path = Paths.get(dir);

        Files.delete(path);

    }

    public static void EscribirFicherosBinariosInt(String path, int text) {
        try (
                DataOutputStream out = new DataOutputStream(new FileOutputStream(path, true));) {
            out.writeInt(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerFicherosBinariosInt(String path) {
        try (
                DataInputStream in = new DataInputStream(new FileInputStream(path));) {
            int c;
            while ((c = in.readInt()) != -1) {
                System.out.println((int) (c));
            }
        } catch (IOException e) {
            System.out.println("Archivo finalizado");
        }
    }

    public static int sumaFicheros(String path) throws IOException {
        int suma = 0;
        try (
                DataInputStream in = new DataInputStream(new FileInputStream(path));) {
            int c;

            while ((c = in.readInt()) != -1) {
                suma = suma + c;
            }
        } catch (IOException e) {
            return suma;
        }
        return suma;
    }

    public static void EscribirFicherosBinariosDouble(String path, int text) {
        try (
                DataOutputStream out = new DataOutputStream(new FileOutputStream(path, true));) {
            out.writeDouble(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerFicherosBinariosDouble(String path) {
        try (
                DataInputStream in = new DataInputStream(new FileInputStream(path));) {
            double c;
            while ((c = in.readDouble()) != -1) {
                System.out.println((double) (c));
            }
        } catch (IOException e) {
            System.out.println("Archivo finalizado");
        }
    }

    public static int[][] creaMatriu(int[][] m1, int n) {
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                m1[i][j] = rnd.nextInt(n);
            }
        }
        return m1;
    }

    public static boolean CercarCharacterStream(String fitxer, String text) throws FileNotFoundException, IOException {
        // Cerca un String dintre d'un fitxer. Retorna true si trobat o false si no trobat

        boolean trobat = false;     // per dir si la paraula està al fitxer o no
        String p;                   // per recollir la paraula

        // /////////////////////////// //
        // FITXERS CHARACTER STREAMS //
        // ///////////////////////// //
        try ( // BLOC DE TRY .. CATCH

                FileReader in = new FileReader(fitxer);) {
            Scanner input = new Scanner(in);

            while (input.hasNextLine()) {           // Mentre hi hagen línies a l'arxiu ...
                p = input.nextLine();     // Agafa una línia
                if (p.contains(text)) // Cerca una subseqüència dintre la línia
                //if (p.contains(text1) && p.contains(text2)) // Ambdúes seqüències dintre la línia
                {
                    return trobat = true;
                }
            }
            /*        } catch (Exception e) {
         System.err.println(";-(");
             */
        }

        return trobat;
    }

    public static void eliminarYMover(String fitxer, String text) throws FileNotFoundException, IOException {
        // Cerca un String dintre d'un fitxer. Retorna true si trobat o false si no trobat

        String p;                   // per recollir la paraula
        String pathTemp = "../fitxers/fitxerTemp.txt";
        FileWriter out = new FileWriter(pathTemp);
        // /////////////////////////// //
        // FITXERS CHARACTER STREAMS //
        // ///////////////////////// //
        try ( // BLOC DE TRY .. CATCH

                FileReader in = new FileReader(fitxer);) {
            Scanner input = new Scanner(in);

            while (input.hasNextLine()) {           // Mentre hi hagen línies a l'arxiu ...
                p = input.nextLine();     // Agafa una línia
                if (p.contains(text)) // Cerca una subseqüència dintre la línia
                //if (p.contains(text1) && p.contains(text2)) // Ambdúes seqüències dintre la línia
                {

                } else {
                    Escribir(pathTemp, p + "\n");
                }
            }
            BorraFitxerSimple(fitxer);
            moureFitxerSimple(pathTemp, fitxer);
            /*        } catch (Exception e) {
         System.err.println(";-(");
             */
        }

    }

    public static void modificarFichero(String path, String text, String nomModificat, String Tipus) throws IOException {
        String p;                   // per recollir la paraula
        String[] nom;
        String pathTemp = "../fitxers/fitxerTemp.txt";
        FileWriter out = new FileWriter(pathTemp);
        // /////////////////////////// //
        // FITXERS CHARACTER STREAMS //
        // ///////////////////////// //
        try ( // BLOC DE TRY .. CATCH

                FileReader in = new FileReader(path);) {
            Scanner input = new Scanner(in);

            while (input.hasNextLine()) {           // Mentre hi hagen línies a l'arxiu ...
                p = input.nextLine();     // Agafa una línia

                if (p.contains(text)) // Cerca una subseqüència dintre la línia
                //if (p.contains(text1) && p.contains(text2)) // Ambdúes seqüències dintre la línia
                {
                    nom = p.split("\t");

                    switch (Tipus) {
                        case "Nom":
                            Escribir(path, nomModificat + "\t");
                            Escribir(path, nom[1] + "\t");
                            Escribir(path, nom[2] + "\t");
                            Escribir(path, nom[3] + "\n");
                            break;
                        case "Cognom":
                            Escribir(path, nom[0] + "\t");
                            Escribir(path, nomModificat + "\t");
                            Escribir(path, nom[2] + "\t");
                            Escribir(path, nom[3] + "\n");
                            break;
                        case "Edat":
                            Escribir(path, nom[0] + "\t");
                            Escribir(path, nom[1] + "\t");
                            Escribir(path, nomModificat + "\t");
                            Escribir(path, nom[3] + "\n");
                            break;
                        case "Sou":
                            Escribir(path, nom[0] + "\t");
                            Escribir(path, nom[1] + "\t");
                            Escribir(path, nom[2] + "\t");
                            Escribir(path, nomModificat + "\n");
                            break;
                        default:
                            break;
                    }
                } else {
                    Escribir(pathTemp, p + "\n");
                }
            }
            BorraFitxerSimple(path);
            moureFitxerSimple(pathTemp, path);
            /*        } catch (Exception e) {
         System.err.println(";-(");
             */
        }
    }

    public static void searchSou(String fitxer, double souSearch) throws FileNotFoundException, IOException {
        // Cerca un String dintre d'un fitxer. Retorna true si trobat o false si no trobat

        String p;                   // per recollir la paraula
        String[] nom;
        double sou;
        // /////////////////////////// //
        // FITXERS CHARACTER STREAMS //
        // ///////////////////////// //
        try ( // BLOC DE TRY .. CATCH

                FileReader in = new FileReader(fitxer);) {
            Scanner input = new Scanner(in);

            while (input.hasNextLine()) {           // Mentre hi hagen línies a l'arxiu ...
                p = input.nextLine();     // Agafa una línia
                nom = p.split("\t");
                sou = Double.parseDouble(nom[3].replaceAll(",", "."));
                if (sou > souSearch) // Cerca una subseqüència dintre la línia
                //if (p.contains(text1) && p.contains(text2)) // Ambdúes seqüències dintre la línia
                {
                    System.out.println(p);
                }

            }
            /*        } catch (Exception e) {
         System.err.println(";-(");
             */
        }

    }

}
