/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author infot
 */
public class Menu {
    public enum Dia{
        Dilluns,wdqewqe,dwqdwqeqwe,dwqdwqdqw,wqdqdqweq,
    }

    /**
     * @param args the command line arguments
     */
    static Scanner in = new Scanner(System.in);
    
    public static int menu() {
        int opt = 0;
        System.out.println("\n1)Division");
        System.out.println("2)Arrays");
        System.out.println("3)Clases");
        System.out.println("4)Ficheros");
        System.out.println("\n0)Salir");
        try {
            opt = in.nextInt();
        } catch (InputMismatchException e) {

        }
        return opt;
    }

    public static void Array(int n) {
        int max = 10;
        int aInt[] = new int[max];
        try {
            for (int i = 0; i < n; i++) {
                aInt[i] = i;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Un error aqui");
        }

    }

    public static void Array(String n) {
        int max = 10;
        int aInt[] = new int[max];
        int m;
        try {
            m = Integer.parseInt(n);
            for (int i = 0; i < m; i++) {
                aInt[i] = i;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Un error aqui");
        } catch (NumberFormatException a) {
            System.err.println(a.getMessage());
            System.out.println("Un error aqui");
        }

    }

    public static void classes() {
        Usuario u = new Usuario();
//        try {
            System.out.println(u.getNum());
//        } catch () {
            
//        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int menu;
        int div1, div2, divT;

        do {
            menu = menu();
            switch (menu) {
                case 0:
                    break;
                case 1:
                    try {
                        System.out.println("Dame un numero para dividir");
                        div1 = in.nextInt();
                        System.out.println("Dame otro numero para dividir con " + div1);
                        div2 = in.nextInt();
                        divT = div1 / div2;
                        in.nextLine();
                        System.out.println(div1 + "/" + div2 + "=" + divT);
                    } catch (InputMismatchException e) {
                        System.out.println("Numeros incorrectos");
                    } catch (ArithmeticException a) {
                        System.out.println("Esta operacion no se puede hacer");
                    }
                    break;
                case 2:
                    Array(21);
                    Array("w2");
                    Array("20");
                    break;
                case 3:
                    classes();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (menu != 0);
    }

}
