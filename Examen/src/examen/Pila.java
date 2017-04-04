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
public class Pila {

    private NodePila top;

    public Pila() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void add(String data, int quantitat, int valor) {
        NodePila node;
        node = new NodePila(data, quantitat, valor, this.top);
        top = node;
    }

    public void printData() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty pila");
        }
        System.out.println("Data:\t\t" + this.top.getData());
        System.out.println("Quantitat:\t" + this.top.getQuantitat());
        System.out.println("Valor:\t\t" + this.top.getValor() + "\n");
        this.top = top.next;
    }

    public void printData(int n1, int n2) throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty pila");
        }
        if (this.top.getValor() > n1 && this.top.getValor() < n2) {
            System.out.println("Data:\t\t" + this.top.getData());
            System.out.println("Quantitat:\t" + this.top.getQuantitat());
            System.out.println("Valor:\t\t" + this.top.getValor() + "\n");
        }
        this.top = top.next;
    }

}
