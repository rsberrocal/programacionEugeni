/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.listapersona;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author infot
 */
public class ListaPersona {

    /**
     * @param args the command line arguments
     */
    public static Scanner in = new Scanner(System.in);
    public static String pathPersonas = "../fitxers/personas";
    public static int menu() {
        int opt;
        System.out.println("\tMenu");
        System.out.println("1)Agregar personas");
        System.out.println("2)Modificar personas");
        System.out.println("3)Eliminar personas");
        System.out.println("4)Listar personas");
        System.out.println("\n\n0)Salir");
        opt = in.nextInt();
        in.nextLine();
        return opt;
    }

    public static int menuLog() {
        int opt;
        System.out.println("\tMenu");
        System.out.println("1)Entrar");
        System.out.println("2)Agregar personas");

        System.out.println("\n\n0)Salir");
        opt = in.nextInt();
        in.nextLine();
        return opt;
    }

    public static void Listas(List<Persona> personaLista) {
        int opt, index;
        String nom;
        do {
            opt = menu();
            switch (opt) {
                case 1:
                    Persona p = new Persona();
                    p.nuevaPersona();
                    personaLista.add(p);
                    break;
                case 2:
                    listarPersonas(personaLista);
                    System.out.println("Dame el nombre de la persona a modificar");
                    nom = in.nextLine();
                    if (buscaPersona(personaLista, nom)) {
                        index = returnIndex(personaLista, nom);
                        personaLista.get(index).modificar();
                    } else {
                        System.out.println("La persona no existe");
                    }
                    break;
                case 3:
                    listarPersonas(personaLista);
                    System.out.println("Dame el nombre de la persona a borrar");
                    nom = in.nextLine();
                    if (buscaPersona(personaLista, nom)) {
                        index = returnIndex(personaLista, nom);
                        personaLista.remove(index);
                    } else {
                        System.out.println("La persona no existe");
                    }
                    break;
                case 4:
                    listarPersonas(personaLista);
                    break;
            }
        } while (opt != 0);
    }

    private static void listarPersonas(List<Persona> personaLista) {
        for (int i = 0; i < personaLista.size(); i++) {
            System.out.print(personaLista.get(i).getNombre() + " ");
            System.out.print(personaLista.get(i).getApellido() + " ");
            System.out.print(personaLista.get(i).getDireccion().getCalle() + " ");
            System.out.print(personaLista.get(i).getDireccion().getCiudad() + " ");
            System.out.print(personaLista.get(i).getDireccion().getCodigoPostal() + " ");
            System.out.print(personaLista.get(i).getNacimiento() + " ");
            System.out.print(personaLista.get(i).getNick() + " ");
            System.out.print(personaLista.get(i).getPasswd() + "\n");
        }
    }

    private static void listarUsuarios(List<Persona> personaLista) {
        for (int i = 0; i < personaLista.size(); i++) {
            System.out.print(personaLista.get(i).getNick() + " ");
        }
    }

    private static boolean buscaPersona(List<Persona> personaLista, String n) {
        boolean flag = false;
        for (int i = 0; i < personaLista.size(); i++) {
            if (personaLista.get(i).getNombre().equals(n)) {
                flag = true;
            }
        }
        return flag;
    }

    private static int returnIndex(List<Persona> personaLista, String n) {
        int i;
        for (i = 0; i < personaLista.size(); i++) {
            if (personaLista.get(i).getNombre().equals(n)) {
                return i;
            }
        }
        return i;
    }

    public static boolean auth(List<Persona> pL) {
        boolean enter = false;
        int ind, intentos = 3;
        String nick;
        String pass;
        listarUsuarios(pL);
        System.out.println("Dame el nick para entrar ");
        nick = in.nextLine();
        if (buscaPersona(pL, nick)) {
            ind = returnIndex(pL, nick);
            do {
                System.out.println("Introduce la contraseña de " + pL.get(ind).getNick());
                pass = in.nextLine();
                if (pass.equals(pL.get(ind).getPasswd())) {
                    enter = true;
                } else {
                    intentos--;
                    System.out.println("Contraseña incorrecta tienes " + intentos + " intentos");
                }
            } while (intentos < 0 || !enter);
        } else {
            System.out.println("El nick no existe");
        }
        return enter;
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int opt, index = 0;
        String nom;
        List<Persona> personaLista = new ArrayList<>();
        do {
            opt = menuLog();
            switch (opt) {
                case 1:
                    auth(personaLista);
                    break;
                case 2:
                    Listas(personaLista);
                    Persona p = new Persona();
                    p.nuevaPersona();
                    p.guardarPersona(pathPersonas);
                    personaLista.add(p);
                    break;
            }
        } while (opt != 0);
    }

}
