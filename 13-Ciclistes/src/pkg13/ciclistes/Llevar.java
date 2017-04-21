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
public class Llevar {
    private Ciclista dorsal;//PK y FK de Ciclista
    private Etapa nEtapa;//PK y FK de Etapa
    private Maillot codi;//PK y FK de Maillot

    public Llevar() {
    }

    public Llevar(Ciclista dorsal, Etapa nEtapa, Maillot codi) {
        this.dorsal = dorsal;
        this.nEtapa = nEtapa;
        this.codi = codi;
    }

    public Ciclista getDorsal() {
        return dorsal;
    }

    public void setDorsal(Ciclista dorsal) {
        this.dorsal = dorsal;
    }

    public Etapa getnEtapa() {
        return nEtapa;
    }

    public void setnEtapa(Etapa nEtapa) {
        this.nEtapa = nEtapa;
    }

    public Maillot getCodi() {
        return codi;
    }

    public void setCodi(Maillot codi) {
        this.codi = codi;
    }
}
