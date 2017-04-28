/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author infot
 */
@Entity
@Table(name = "Ciclistes", catalog = "ciclistes", schema = "")
@NamedQueries({
    @NamedQuery(name = "Ciclistes.findAll", query = "SELECT c FROM Ciclistes c"),
    @NamedQuery(name = "Ciclistes.findByDorsal", query = "SELECT c FROM Ciclistes c WHERE c.dorsal = :dorsal"),
    @NamedQuery(name = "Ciclistes.findByNom", query = "SELECT c FROM Ciclistes c WHERE c.nom = :nom"),
    @NamedQuery(name = "Ciclistes.findByEdad", query = "SELECT c FROM Ciclistes c WHERE c.edad = :edad"),
    @NamedQuery(name = "Ciclistes.findByNomeq", query = "SELECT c FROM Ciclistes c WHERE c.nomeq = :nomeq")})
public class Ciclistes implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dorsal")
    private Integer dorsal;
    @Column(name = "nom")
    private String nom;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "nomeq")
    private String nomeq;

    public Ciclistes(Integer dorsal, String nom, Integer edad, String nomeq) {
        this.dorsal = dorsal;
        this.nom = nom;
        this.edad = edad;
        this.nomeq = nomeq;
    }
    public Ciclistes() {
    }

    public Ciclistes(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        Integer oldDorsal = this.dorsal;
        this.dorsal = dorsal;
        changeSupport.firePropertyChange("dorsal", oldDorsal, dorsal);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String oldNom = this.nom;
        this.nom = nom;
        changeSupport.firePropertyChange("nom", oldNom, nom);
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        Integer oldEdad = this.edad;
        this.edad = edad;
        changeSupport.firePropertyChange("edad", oldEdad, edad);
    }

    public String getNomeq() {
        return nomeq;
    }

    public void setNomeq(String nomeq) {
        String oldNomeq = this.nomeq;
        this.nomeq = nomeq;
        changeSupport.firePropertyChange("nomeq", oldNomeq, nomeq);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dorsal != null ? dorsal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciclistes)) {
            return false;
        }
        Ciclistes other = (Ciclistes) object;
        if ((this.dorsal == null && other.dorsal != null) || (this.dorsal != null && !this.dorsal.equals(other.dorsal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg14.swingciclistes.Forms.Ciclistes.Ciclistes[ dorsal=" + dorsal + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
