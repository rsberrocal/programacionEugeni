/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.pilas;

/**
 *
 * @author infot
 */
public class Node {

    int num;
    Node next;

    Node(int n) {
        this.num = n;
        this.next = null;
    }

    Node(int n, Node N) {
        this.num = n;
        this.next = N;
    }

}
