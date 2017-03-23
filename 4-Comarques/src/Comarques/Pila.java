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
public class Pila {

    private Node top;
    int maxPoblacio;
    Node MaxPob;
    double maxSuperficie;
    Node MaxSuper;
    double maxDensitat;
    Node MaxDen;
    double avg;
    double avgRes;
    double avgTotal;
    double avgCount;
    Node avgDen;

    public Pila() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printData() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty pila");
        }
        System.out.println("Comarca:\t" + this.top.getComarques());
        System.out.println("Poblacio:\t" + this.top.getPoblacio());
        System.out.println("Superficie:\t" + this.top.getSuperficie());
        System.out.println("Densitat:\t" + this.top.getDensitat() + "\n");
        this.top = top.next;
    }

    public void add(String comarques, int poblacio, double superficie, double densitat) {
        Node node;
        node = new Node(comarques, poblacio, superficie, densitat, this.top);
        this.top = node;
        if (node.getPoblacio() > this.maxPoblacio) {
            this.maxPoblacio = node.getPoblacio();
            this.MaxPob = node;
        }
        if (node.getSuperficie() > this.maxSuperficie) {
            this.maxSuperficie = node.getSuperficie();
            this.MaxSuper = node;
        }
        if (node.getDensitat() > this.maxDensitat) {
            this.maxDensitat = node.getSuperficie();
            this.MaxDen = node;
        }
        this.avg = node.getDensitat() + this.avg;
        this.avgCount++;
        this.avgTotal = this.avg / this.avgCount;

        if (this.avgRes < Math.abs(this.avgTotal - node.getDensitat())) {
            this.avgRes = node.getDensitat();
            this.avgDen = node;
        }

    }

    public void printMaxPoblacio() {
        System.out.println("\nComarca con la mayor poblacion");
        System.out.println("------- --- -- ----- ---------\n");
        System.out.println(this.MaxPob.getComarques());
        System.out.println(this.MaxPob.getPoblacio());
        System.out.println(this.MaxPob.getSuperficie());
        System.out.println(this.MaxPob.getDensitat());
    }

    public void printMaxDensitat() {
        System.out.println("\nComarca con la mayor densidat");
        System.out.println("------- --- -- ----- ---------\n");
        System.out.println(this.MaxDen.getComarques());
        System.out.println(this.MaxDen.getPoblacio());
        System.out.println(this.MaxDen.getSuperficie());
        System.out.println(this.MaxDen.getDensitat());
    }

    public void printMaxSuperficie() {
        System.out.println("\nComarca con la mayor superficie");
        System.out.println("------- --- -- ----- ---------\n");
        System.out.println(this.MaxSuper.getComarques());
        System.out.println(this.MaxSuper.getPoblacio());
        System.out.println(this.MaxSuper.getSuperficie());
        System.out.println(this.MaxSuper.getDensitat());
    }

    public void printAvg() {
        System.out.println("\nComarca con la mejor densidad");
        System.out.println("------- --- -- ----- ---------\n");
        System.out.println(this.avgDen.getComarques());
        System.out.println(this.avgDen.getPoblacio());
        System.out.println(this.avgDen.getSuperficie());
        System.out.println(this.avgDen.getDensitat());
    }

}
