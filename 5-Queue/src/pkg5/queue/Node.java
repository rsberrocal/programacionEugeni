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
public class Node {

    int num;
    Node next;

    Node(int num) {
        this.num = num;
        this.next = null;
    }

    Node(int num, Node N) {
        this.num = num;
        this.next = N;
    }
}
