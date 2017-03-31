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
public class Node {

    private String comarques;
    private int poblacio;
    private double superficie;
    private double densitat;
    private Node Right;
    private Node Left;

    public Node(String comarques, int poblacio, double superficie, double densitat) {
        this.comarques = comarques;
        this.poblacio = poblacio;
        this.superficie = superficie;
        this.densitat = densitat;
        this.Right = this.Left = null;
    }

    public String getComarques() {
        return comarques;
    }

    public void setComarques(String comarques) {
        this.comarques = comarques;
    }

    public int getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(int poblacio) {
        this.poblacio = poblacio;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double getDensitat() {
        return densitat;
    }

    public void setDensitat(double densitat) {
        this.densitat = densitat;
    }

    public Node getRight() {
        return Right;
    }

    public void setRight(Node Right) {
        this.Right = Right;
    }

    public Node getLeft() {
        return Left;
    }

    public void setLeft(Node Left) {
        this.Left = Left;
    }

}
