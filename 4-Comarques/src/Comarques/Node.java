/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comarques;

/**
 *
 * @author infot
 */
public class Node {

    private String comarques;
    private int poblacio;
    private double superficie;
    private double densitat;
    Node next;

    Node(String comarques, int poblacio, double superficie, double densitat, Node next) {
        this.comarques = comarques;
        this.poblacio = poblacio;
        this.superficie = superficie;
        this.densitat = densitat;
        this.next = next;
    }

    public String getComarques() {
        return comarques;
    }

    public int getPoblacio() {
        return poblacio;
    }

    public double getSuperficie() {
        return superficie;
    }

    public double getDensitat() {
        return densitat;
    }
}
