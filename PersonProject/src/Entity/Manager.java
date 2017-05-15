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

    private List<Person> l;

    public Manager() {
        this.l = new ArrayList<>();
    }
    //Function that returns total salary for all person
    public double getTotalSalary() {
        double total = 0;
        for (int i = 0; i < this.l.size(); i++) {
            total = total + this.l.get(i).getSalary();
        }
        return total;
    }
    //Function to add a Person in to the list
    public void addPerson(Person p) {
        this.l.add(p);
    }

    public void deletePerson(Person p) {
        this.l.remove(p);
    }

    public int manyPerson() {
        return this.l.size();
    }

    public void dropList() {
        for (int i = 0; i < this.l.size(); i++) {
            this.l.remove(i);
        }
    }

    public List<Person> getL() {
        return l;
    }

    public void setL(List<Person> l) {
        this.l = l;
    }

}
