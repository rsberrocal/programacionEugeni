/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9.tree;

/**
 *
 * @author Richard
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Tree t = new Tree();
        Node n1 = new Node(5);
        Node n2 = new Node(2);
        Node n3 = new Node(7);
        Node n4 = new Node(9);
        Node n5 = new Node(4);
        Node n6 = new Node(1);
        t.addNode(n1);
        t.addNode(n2);
        t.addNode(n3);
        t.addNode(n4);
        t.addNode(n5);
        t.addNode(n6);
        t.preOrder(t.getRoot());
        System.out.println("");
        t.inOrder(t.getRoot());
        System.out.println("");
        t.postOrder(t.getRoot());
        System.out.println("");
    }

}
