/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author infot
 */
public class Manager {

    private Person p;
    private List<Person> l;

    public Manager() {
        this.p = new Person();
        this.l = new ArrayList<>();
    }

    public double getTotalSalary() {
        double total = 0;
        for (int i = 0; i < this.l.size(); i++) {
            total = total + this.l.get(i).getSalary();
        }
        return total;
    }

    public void addPerson(Person p) {
        this.l.add(p);
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public List<Person> getL() {
        return l;
    }

    public void setL(List<Person> l) {
        this.l = l;
    }

}
