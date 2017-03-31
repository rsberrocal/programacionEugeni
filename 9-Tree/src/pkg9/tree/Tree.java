/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9.tree;

/**
 *
 * @author Richard
 */
public class Tree {

    private Node root;

    public Tree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private void addNode(Node n, Node r) {
        if (r == null) {
            this.root = n;
        } else {
            if (n.getNum() <= r.getNum()) {
                if (r.getLeft() == null) {
                    r.setLeft(n);
                } else {
                    addNode(n, r.getLeft());
                }
            } else {
                if (r.getRight() == null) {
                    r.setRight(n);
                } else {
                    addNode(n, r.getRight());
                }
            }
        }
    }

    public void addNode(Node n) {
        addNode(n, this.root);
    }

    public void preOrder(Node n) {
        if (n == null) {
            return;
        }
        System.out.print(n.getNum()+" ");
        preOrder(n.getLeft());
        preOrder(n.getRight());   
    }

    public void inOrder(Node n) {
        if (n == null) {
            return;
        }
        inOrder(n.getLeft());
        System.out.print(n.getNum()+" ");
        inOrder(n.getRight());
    }

    public void postOrder(Node n) {
        if (n == null) {
            return;
        }
        postOrder(n.getLeft());
        postOrder(n.getRight());
        System.out.print(n.getNum()+" ");
    }

}
