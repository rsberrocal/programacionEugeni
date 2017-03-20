/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.listapersona;

import java.io.Serializable;
import static pkg2.listapersona.ListaPersona.in;

/**
 *
 * @author infot
 */
public class Direccion implements Serializable {

    private String calle;
    private String ciudad;
    private String codigoPostal;

    public Direccion() {

    }

    private void nuevaDireccionP(Persona p) {
        System.out.println("Dame la calle de " + p.getNick());
        this.calle = in.nextLine();
        System.out.println("Dame la ciudad de " + p.getNick());
        this.ciudad = in.nextLine();
        System.out.println("Dame el codigo postal de " + p.getNick());
        this.codigoPostal = in.nextLine();

    }

    public Direccion nuevaDireccion(Persona p) {
        this.nuevaDireccionP(p);
        return this;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNuevaCalle(String n) {
        System.out.println("Dame la nueva calle de " + n);
        this.calle = in.nextLine();
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setNuevaCiudad(String n) {
        System.out.println("Dame la nueva ciudad de " + n);
        this.ciudad = in.nextLine();
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setNuevoCodigoPostal(String n) {
        System.out.println("Dame el nuevo codigo postal de " + n);
        this.codigoPostal = in.nextLine();
    }
}
