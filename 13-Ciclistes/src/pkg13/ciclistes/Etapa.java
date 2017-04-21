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
public class Etapa {
    private int nEtapa;//PK
    private int km;
    private String sortida;
    private String arribada;
    private Ciclista dorsal;//FK de Ciclista

    public Etapa() {
    }

    public Etapa(int nEtapa, int km, String sortida, String arribada, Ciclista dorsal) {
        this.nEtapa = nEtapa;
        this.km = km;
        this.sortida = sortida;
        this.arribada = arribada;
        this.dorsal = dorsal;
    }

    public int getnEtapa() {
        return nEtapa;
    }

    public void setnEtapa(int nEtapa) {
        this.nEtapa = nEtapa;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getSortida() {
        return sortida;
    }

    public void setSortida(String sortida) {
        this.sortida = sortida;
    }

    public String getArribada() {
        return arribada;
    }

    public void setArribada(String arribada) {
        this.arribada = arribada;
    }

    public Ciclista getDorsal() {
        return dorsal;
    }

    public void setDorsal(Ciclista dorsal) {
        this.dorsal = dorsal;
    }
    
}
