/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

/**
 *
 * @author infot
 */
public class Queue {

    NodeQueue Start;
    NodeQueue End;

    public Queue() {
        this.Start = null;
        this.End = null;
    }

    public boolean isEmpty() {
        return this.Start == null;
    }

    public void add(String data, int quantitat, int valor) {
        NodeQueue a;
        a = new NodeQueue(data, quantitat, valor);
        if (isEmpty()) {
            this.Start = a;
        } else {
            this.End.next = a;
        }
        this.End = a;
    }

    public void printData(int n1, int n2) throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty pila");
        }
        if (this.Start.getValor() > n1 && this.Start.getValor() < n2) {
            System.out.println("Data:\t\t" + this.Start.getData());
            System.out.println("Quantitat:\t" + this.Start.getQuantitat());
            System.out.println("Valor:\t\t" + this.Start.getValor() + "\n");
        }
        this.Start = Start.next;
    }

}
