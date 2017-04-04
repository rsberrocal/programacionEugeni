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
public class Pila {

    private NodePila top;

    public Pila() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty pila");
        }
        int num = top.num;
        this.top = top.next;
        return num;
    }

    public void add(int n) {
        NodePila node;
        node = new NodePila(n, this.top);        
        top = node;
    }

    public int num() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty pila");
        }
        return this.top.num;
    }
    
    public void removeAll(){
        NodePila n;
        while(!isEmpty()){
            n=this.top;
            this.top=top.next;
            n.next=null;
        }
    }

}
