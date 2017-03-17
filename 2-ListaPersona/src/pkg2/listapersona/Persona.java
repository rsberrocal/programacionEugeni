/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.listapersona;

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
        this.nacimiento = fechaNacimiento();

    }

    private String fechaNacimiento() {
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

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
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
}
