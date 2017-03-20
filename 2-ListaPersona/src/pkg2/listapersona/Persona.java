/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.listapersona;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import static pkg2.listapersona.ListaPersona.in;

/**
 *
 * @author infot
 */
public class Persona {

    private String nombre;
    private String apellido;
    private Direccion Direccion;
    private String nick;
    private String passwd;
    private String nacimiento;

    public Persona() {
        this.Direccion = new Direccion();
    }

    public void nuevaPersona() {
        System.out.println("Dame el nick de la nueva persona");
        this.nick = in.nextLine();
        System.out.println("Dame la contraseña de " + this.nick);
        this.passwd = in.nextLine();
        System.out.println("Dame el nombre de " + this.nick);
        this.nombre = in.nextLine();
        System.out.println("Dame el apellido de " + this.nick);
        this.apellido = in.nextLine();
        this.Direccion = this.Direccion.nuevaDireccion(this);
        this.nacimiento = setFechaNacimiento();

    }

    private String setFechaNacimiento() {
        String patternFecha = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
//        Pattern fecha = Pattern.compile(patternFecha);
        do {
            System.out.println("Dame la fecha de nacimiento de " + this.nick + " (Solo se admite el siguiente formato dd/mm/aaaa");
            this.nacimiento = in.nextLine();
            if (!this.nacimiento.matches(patternFecha)) {
                System.out.println("La fecha introducida es incorrecta");
            }
        } while (!this.nacimiento.matches(patternFecha));
        return this.nacimiento;
    }

    private int menuModificar() {
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

    public void modificar() {
        int o;
        do {
            o = menuModificar();
            switch (o) {
                case 1:
                    System.out.println("Dame el nuevo nick de " + this.nombre);
                    this.nick = in.nextLine();
                    break;
                case 2:
                    System.out.println("Dame la nueva contraseña de " + this.nick);
                    this.passwd = in.nextLine();
                    break;
                case 3:
                    System.out.println("Dame el nuevo nombre de " + this.nick);
                    this.nombre = in.nextLine();
                    break;
                case 4:
                    System.out.println("Dame el nuevo apellido de " + this.nick);
                    this.apellido = in.nextLine();
                    break;
                case 5:
                    this.Direccion.setNuevaCalle(this.nick);
                    break;
                case 6:
                    this.Direccion.setNuevaCiudad(this.nick);
                    break;
                case 7:
                    this.Direccion.setNuevoCodigoPostal(this.nick);
                    break;
                case 8:
                    setFechaNacimiento();
                    break;
            }
        } while (o != 0);
    }

    private static boolean ComprovaDirectori(String dir) {

        // Comprova la existència d'un directori
        Path path = Paths.get(dir);

        boolean ok = Files.exists(path);

        return ok;
    }

    public void guardarPersona(String path) throws IOException {
        if (ComprovaDirectori(path) == true) // Escrivim l'objecte l[] dintre del fitxer
        {
            try ( // BLOC DE TRY .. CATCH

                    // Per afegir posem true després el nom del fitxer

                    // PER AFEGIR LA RESTA D'OBJECTES
                    // Per afegir TAMBÉ posem true després el nom del fitxer
                    MeuObjecteOutputStream afegir = new MeuObjecteOutputStream(new FileOutputStream(path, true))) {
                afegir.writeObject(this);    // afegir -> per afegir dades a l'arxiu
            }
        } else // Escrivim l'objecte l[] dintre del fitxer
        {
            try ( // BLOC DE TRY .. CATCH

                    // Per afegir posem true després el nom del fitxer
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path)); // PER AFEGIR LA RESTA D'OBJECTES
                    // Per afegir TAMBÉ posem true després el nom del fitxer
                    ) {
                out.writeObject(this);       // out -> per crear nou arxiu
            }

        }
    }

// <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getNacimiento() {
        return nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Direccion getDireccion() {
        return Direccion;
    }

    public void setDireccion(Direccion Direccion) {
        this.Direccion = Direccion;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    // </editor-fold>
}
