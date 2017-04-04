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
public class NodePila {

    private String data;
    private int quantitat;
    private int valor;
    NodePila next;

    NodePila(String data, int quantitat, int valor) {

        this.data = data;
        this.quantitat = quantitat;
        this.valor = valor;
        this.next = null;
    }

    NodePila(String data, int quantitat, int valor, NodePila N) {
        this.data = data;
        this.quantitat = quantitat;
        this.valor = valor;
        this.next = N;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public NodePila getNext() {
        return next;
    }

    public void setNext(NodePila next) {
        this.next = next;
    }

}
