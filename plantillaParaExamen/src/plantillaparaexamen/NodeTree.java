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
public class NodeTree {

    private int num;
    private NodeTree Right;
    private NodeTree Left;

    public NodeTree(int n) {
        this.num = n;
        this.Right = this.Left = null;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public NodeTree getRight() {
        return Right;
    }

    public void setRight(NodeTree Right) {
        this.Right = Right;
    }

    public NodeTree getLeft() {
        return Left;
    }

    public void setLeft(NodeTree Left) {
        this.Left = Left;
    }

}
