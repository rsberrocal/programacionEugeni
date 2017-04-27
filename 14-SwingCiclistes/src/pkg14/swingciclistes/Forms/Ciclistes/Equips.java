/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg14.swingciclistes.Forms.Ciclistes;

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
@Table(name = "Equips", catalog = "ciclistes", schema = "")
@NamedQueries({
    @NamedQuery(name = "Equips.findAll", query = "SELECT e FROM Equips e"),
    @NamedQuery(name = "Equips.findByNomeq", query = "SELECT e FROM Equips e WHERE e.nomeq = :nomeq"),
    @NamedQuery(name = "Equips.findByDirector", query = "SELECT e FROM Equips e WHERE e.director = :director")})
public class Equips implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nomeq")
    private String nomeq;
    @Column(name = "director")
    private String director;

    public Equips() {
    }

    public Equips(String nomeq) {
        this.nomeq = nomeq;
    }

    public String getNomeq() {
        return nomeq;
    }

    public void setNomeq(String nomeq) {
        String oldNomeq = this.nomeq;
        this.nomeq = nomeq;
        changeSupport.firePropertyChange("nomeq", oldNomeq, nomeq);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        String oldDirector = this.director;
        this.director = director;
        changeSupport.firePropertyChange("director", oldDirector, director);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomeq != null ? nomeq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equips)) {
            return false;
        }
        Equips other = (Equips) object;
        if ((this.nomeq == null && other.nomeq != null) || (this.nomeq != null && !this.nomeq.equals(other.nomeq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg14.swingciclistes.Forms.Ciclistes.Equips[ nomeq=" + nomeq + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
