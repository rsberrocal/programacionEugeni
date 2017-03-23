/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.pilas;

import java.util.Random;

/**
 *
 * @author infot
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int randomNum() {
        int n;
        Random rnd = new Random();
        n = rnd.nextInt(2000);
        return n;
    }

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Pila p = new Pila();
        int num;
        for (int i = 0; i < 2000; i++) {
            num = randomNum();
            p.add(num);
        }
        try {
            while (!p.isEmpty()) {
                System.out.println(p.remove());
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Empty Pila");
        }
    }

}
