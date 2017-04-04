/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantillaparaexamen;

/**
 *
 * @author Richard
 */
public class Tree {

    private NodeTree root;

    public Tree() {
        this.root = null;
    }

    public NodeTree getRoot() {
        return root;
    }

    public void setRoot(NodeTree root) {
        this.root = root;
    }

    private void addNodeTree(NodeTree n, NodeTree r) {
        if (r == null) {
            this.root = n;
        } else {
            if (n.getNum() <= r.getNum()) {
                if (r.getLeft() == null) {
                    r.setLeft(n);
                } else {
                    addNodeTree(n, r.getLeft());
                }
            } else {
                if (r.getRight() == null) {
                    r.setRight(n);
                } else {
                    addNodeTree(n, r.getRight());
                }
            }
        }
    }

    public void addNodeTree(NodeTree n) {
        addNodeTree(n, this.root);
    }

    public void preOrder(NodeTree n) {
        if (n == null) {
            return;
        }
        System.out.print(n.getNum() + " ");
        preOrder(n.getLeft());
        preOrder(n.getRight());
    }

    public void inOrder(NodeTree n) {
        if (n == null) {
            return;
        }
        inOrder(n.getLeft());
        System.out.print(n.getNum() + " ");
        inOrder(n.getRight());
    }

    public void postOrder(NodeTree n) {
        if (n == null) {
            return;
        }
        postOrder(n.getLeft());
        postOrder(n.getRight());
        System.out.print(n.getNum() + " ");
    }

}
