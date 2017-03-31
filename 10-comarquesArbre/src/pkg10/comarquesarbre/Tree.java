/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10.comarquesarbre;

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
        } else if (n.getPoblacio() <= r.getPoblacio()) {
            if (r.getLeft() == null) {
                r.setLeft(n);
            } else {
                addNode(n, r.getLeft());
            }
        } else if (r.getRight() == null) {
            r.setRight(n);
        } else {
            addNode(n, r.getRight());
        }
    }

    public void addNode(Node n) {
        addNode(n, this.root);
    }

    public void printComarca(Node n) {
        System.out.println("\n"+n.getComarques()+ " ");        
        System.out.println("------- -------");
        System.out.println("Poblacio: "+n.getPoblacio()+ " ");
        System.out.println("Superficie: "+n.getSuperficie()+ " ");
        System.out.println("Densitat: "+n.getDensitat()+ " ");
    }

    public void preOrder(Node n) {
        if (n == null) {
            return;
        }
        printComarca(n);
        preOrder(n.getLeft());
        preOrder(n.getRight());
    }

    public void inOrder(Node n) {
        if (n == null) {
            return;
        }
        inOrder(n.getLeft());
        printComarca(n);
        inOrder(n.getRight());
    }

    public void postOrder(Node n) {
        if (n == null) {
            return;
        }
        postOrder(n.getLeft());
        postOrder(n.getRight());
        printComarca(n);
    }

}

