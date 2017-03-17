/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.listapersona;

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

    private static boolean buscaPersona(List<Persona> personaLista, String n) {
        boolean flag = false;
        for (int i = 0; i < personaLista.size(); i++) {
            if (personaLista.get(i).getNombre().equals(n)) {
                flag = true;
            }
        }
        return flag;
    }

    public static int menuModificar() {
        int opt;
        System.out.println("1)Nick");
        System.out.println("2)Contraseña");
        System.out.println("3)Nombre");
        System.out.println("4)Apellido");
        System.out.println("5)Calle");
        System.out.println("6)Ciudad");
        System.out.println("7)Codigo postal");
        System.out.println("8)Nacimiento");

        System.out.println("\n\n0)Salir");
        opt = in.nextInt();
        in.nextLine();
        return opt;
    }
    public static void modificar(int o){
        switch(o){
            
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int opt, optModificar;
        String nom;
        List<Persona> personaLista = new ArrayList<>();
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
                        optModificar=menuModificar();
                        modificar(opt);
                    }else{
                        System.out.println("La persona no existe");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    listarPersonas(personaLista);
                    break;
            }
        } while (opt != 0);
    }

}
