/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Basket;

/**
 *
 * @author infot
 */
public class Player {

    private String name;
    private String surname;
    private int numPlayer;
    private Teams team;
    private Positions position;

// <editor-fold defaultstate="collapsed" desc="Constructors">
    public Player() {
    }

    public Player(String name, String surname, int numPlayer, Teams team, Positions position) {
        this.name = name;
        this.surname = surname;
        this.numPlayer = numPlayer;
        this.team = team;
        this.position = position;
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNumPlayer() {
        return numPlayer;
    }

    public void setNumPlayer(int numPlayer) {
        this.numPlayer = numPlayer;
    }

    public Teams getTeam() {
        return team;
    }

    public void setTeam(Teams team) {
        this.team = team;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }
// </editor-fold>

}
