/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg7.list;

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
        l.inserirPrimer(1);
        l.introduirDada(1, 2);
        l.introduirDada(2, 3);
        l.inserirUltim(4);
        System.out.println(l.mostrarPrimer());
        System.out.println(l.mostrarDada(1));
        System.out.println(l.mostrarDada(2));
        System.out.println(l.mostrarUltim());
       
    }
    
}

