/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg13.ciclistes;

/**
 *
 * @author infot
 */
public class Port {

    private String nomPort;//PK
    private int alcada;
    private String categoria;
    private double pendent;
    private Etapa nEtapa;//FK de Etapa
    private Ciclista dorsal;//FK de Ciclista

    public Port() {
    }

    public Port(String nomPort, int alcada, String categoria, double pendent, Etapa nEtapa, Ciclista dorsal) {
        this.nomPort = nomPort;
        this.alcada = alcada;
        this.categoria = categoria;
        this.pendent = pendent;
        this.nEtapa = nEtapa;
        this.dorsal = dorsal;
    }

    public String getNomPort() {
        return nomPort;
    }

    public void setNomPort(String nomPort) {
        this.nomPort = nomPort;
    }

    public int getAlcada() {
        return alcada;
    }

    public void setAlcada(int alcada) {
        this.alcada = alcada;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPendent() {
        return pendent;
    }

    public void setPendent(double pendent) {
        this.pendent = pendent;
    }

    public Etapa getnEtapa() {
        return nEtapa;
    }

    public void setnEtapa(Etapa nEtapa) {
        this.nEtapa = nEtapa;
    }

    public Ciclista getDorsal() {
        return dorsal;
    }

    public void setDorsal(Ciclista dorsal) {
        this.dorsal = dorsal;
    }

}
