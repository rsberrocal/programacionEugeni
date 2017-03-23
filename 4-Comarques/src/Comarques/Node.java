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

    String comarques;
    int poblacio;
    double superficie;
    double densitat;
    Node next;

    Node(String comarques, int poblacio, double superficie, double densitat, Node next) {
        this.comarques=comarques;
        this.poblacio=poblacio;
        this.superficie=superficie;
        this.densitat=densitat;
        this.next=next;               
    }

}
