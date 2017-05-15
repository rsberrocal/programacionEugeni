/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author infot
 */
public class Person {

    private String name;
    private double salary;
    private int dniN;

    public Person() {
    }

    public Person(String name, double salary, int dni) {
        this.name = name;
        this.salary = salary;
        this.dniN = dni;
    }

    public String getName() {
        return name;
    }

    public char getLetter() {
        char l[] = new char[23];
        l[0] = 'T';
        l[1] = 'R';
        l[2] = 'W';
        l[3] = 'A';
        l[4] = 'G';
        l[5] = 'M';
        l[6] = 'Y';
        l[7] = 'F';
        l[8] = 'P';
        l[9] = 'D';
        l[10] = 'X';
        l[11] = 'B';
        l[12] = 'N';
        l[13] = 'J';
        l[14] = 'Z';
        l[15] = 'S';
        l[16] = 'Q';
        l[17] = 'V';
        l[18] = 'H';
        l[19] = 'L';
        l[20] = 'C';
        l[21] = 'K';
        l[22] = 'E';
        return l[this.dniN % 23];
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDni() {
        return dniN;
    }

    public void setDni(int dni) {
        this.dniN = dni;
    }

}
