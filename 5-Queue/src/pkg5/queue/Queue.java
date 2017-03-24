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
public class Queue {

    Node Start;
    Node End;

    public Queue() {
        this.Start = null;
        this.End = null;
    }

    public boolean isEmpty() {
        return this.Start == null;
    }

    public void add(int n) {
        Node a;
        a = new Node(n);
        if (isEmpty()) {
            this.Start = a;
        } else {
            this.End.next = a;
        }
        this.End = a;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty queue");
        }
        int n = this.Start.num;
        this.Start = this.Start.next;
        return n;
    }

    public void removeAll() {

        while (!isEmpty()) {
            this.Start = null;
        }
    }

}
