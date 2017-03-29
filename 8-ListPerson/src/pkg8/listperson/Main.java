/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8.listperson;

/**
 *
 * @author infot
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List l = new List();
        String[] name = new String[10];
        char[] gen = new char[2];
        double[] sal = new double[10];
        name[0] = "Richard";
        name[1] = "Murdoc";
        name[2] = "Russell";
        name[3] = "Luiza";
        name[4] = "Maria";
        name[5] = "Angus";
        name[6] = "Clara";
        name[7] = "David";
        name[8] = "Peter";
        name[9] = "Saul";
        gen[0] = 'H';
        gen[1] = 'M';
        sal[0] = 32321.23;
        sal[1] = 33421.23;
        sal[2] = 5523.32;
        sal[3] = 8785.21;
        sal[4] = 32321.23;
        sal[5] = 32321.23;
        sal[6] = 2154.23;
        sal[7] = 32321.23;
        sal[8] = 3481.23;
        sal[9] = 5484.23;
        Person p1 = new Person();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                p1 = new Person(name[i], gen[0], sal[i]);
            } else {
                p1 = new Person(name[i], gen[1], sal[i]);
            }
            if (i == 0) {
                l.setFirst(p1);
            } else if (i == 10 - 1) {
                l.setLast(p1);
            } else {
                l.addWithPos(i, p1);
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Nom: "+l.mostrarDada(i).getNom());
            System.out.println("Sexe: "+l.mostrarDada(i).getSexe());
            System.out.println("Salari: "+l.mostrarDada(i).getSalari());
            System.out.println("\n");
        }
    }

}

