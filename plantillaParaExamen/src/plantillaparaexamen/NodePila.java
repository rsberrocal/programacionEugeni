/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantillaparaexamen;

/**
 *
 * @author infot
 */
public class NodePila {

    int num;
    NodePila next;

    NodePila(int n) {
        this.num = n;
        this.next = null;
    }

    NodePila(int n, NodePila N) {
        this.num = n;
        this.next = N;
    }

}
