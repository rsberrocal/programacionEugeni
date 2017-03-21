/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Basket;

import static Main.Basket.Teams.*;
import static Main.Basket.Positions.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author infot
 */
public class Basket {

    /**
     * @param args the command line arguments
     */
    public static List cavaliersPlayers(List<Player> P) {
        Player p1 = new Player("Tristan", "Thompson", 13, CAVALIERS, C);
        P.add(p1);
        p1 = new Player("Richard", "Jefferson", 24, CAVALIERS, PF);
        P.add(p1);
        p1 = new Player("Iman", "Shumpert", 4, CAVALIERS, SG);
        P.add(p1);
        p1 = new Player("Deron", "Williams", 14, CAVALIERS, PG);
        P.add(p1);
        p1 = new Player("LeBron", "James", 23, CAVALIERS, SF);
        P.add(p1);
        return P;
    }

    public static List bullsPlayers(List<Player> P) {
        Player p1 = new Player("Robin", "Lopez", 8, BULLS, C);
        P.add(p1);
        p1 = new Player("Jimmy", "Butler", 21, BULLS, PF);
        P.add(p1);
        p1 = new Player("Rajon", "Rondo", 9, BULLS, SG);
        P.add(p1);
        p1 = new Player("Bobby", "Portis", 5, BULLS, PG);
        P.add(p1);
        p1 = new Player("Nikola", "Mirotic", 44, BULLS, SF);
        P.add(p1);
        return P;
    }

    public static void listTeams(List<Player> P) {
        for (int i = 0; i < P.size(); i++) {
            if (i == 0) {
                System.out.println("\t\t" + CAVALIERS);
                System.out.println("\t\t----------");
                System.out.println("Name  \t Surname Position\t Team \t\tPosition");
            } else if (i == 5) {
                System.out.println("\t\t" + BULLS);
                System.out.println("\t\t----");
                System.out.println("Name  \t Surname Position\t Team \t\tPosition");
            }
            System.out.println(P.get(i).getName() + "\t " + P.get(i).getSurname() + " (" + P.get(i).getNumPlayer() + ")\t\t" + P.get(i).getTeam() + " ---->\t" + P.get(i).getPosition());

        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        List<Player> Players = new ArrayList<>();
        Players = cavaliersPlayers(Players);
        Players = bullsPlayers(Players);
        listTeams(Players);
    }

}
