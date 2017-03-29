/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8.listperson;

/**
 *
 * @author infot
 */
public class NodeList {
    Person p;
    NodeList Next;

    public NodeList(Person p) {
        this.p = p;
        this.Next = null;
    }

    public NodeList(Person p, NodeList Next) {
        this.p = p;
        this.Next = Next;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public NodeList getNext() {
        return Next;
    }

    public void setNext(NodeList Next) {
        this.Next = Next;
    }

}
