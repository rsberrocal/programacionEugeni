/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5.queue;

/**
 *
 * @author infot
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Queue q = new Queue();
        //q.add(2);
        //q.removeAll();
        for (int i = 0; i < 10; i++) {
            q.add(i);

        }

        try {
            while (!q.isEmpty()) {
                System.out.println(q.remove());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
