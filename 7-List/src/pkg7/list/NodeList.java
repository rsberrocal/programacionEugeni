/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg7.list;

/**
 *
 * @author infot
 */
public class NodeList {

    int num;
    NodeList Next;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public NodeList getNext() {
        return Next;
    }

    public void setNext(NodeList Next) {
        this.Next = Next;
    }

    public NodeList(int n) {
        this.num = n;
        this.Next = null;
    }

    public NodeList(int n, NodeList Next) {
        this.num = n;
        this.Next = Next;
    }
}
