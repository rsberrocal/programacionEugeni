package cyclists.Entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cyclists.Database;
import java.awt.BorderLayout;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Richard
 */
@Entity
@Table(name = "Ciclistes", catalog = "rsudario_gproductes", schema = "")
@NamedQueries({
    @NamedQuery(name = "Ciclistes.findAll", query = "SELECT c FROM Ciclistes c"),
    @NamedQuery(name = "Ciclistes.findByDorsal", query = "SELECT c FROM Ciclistes c WHERE c.dorsal = :dorsal"),
    @NamedQuery(name = "Ciclistes.findByNom", query = "SELECT c FROM Ciclistes c WHERE c.nom = :nom"),
    @NamedQuery(name = "Ciclistes.findByEdad", query = "SELECT c FROM Ciclistes c WHERE c.edad = :edad"),
    @NamedQuery(name = "Ciclistes.findByNomeq", query = "SELECT c FROM Ciclistes c WHERE c.nomeq = :nomeq")})
public class Cyclist implements Serializable {

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

    public Cyclist() {
    }

    public Cyclist(Integer dorsal) {
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
        if (!(object instanceof Cyclist)) {
            return false;
        }
        Cyclist other = (Cyclist) object;
        if ((this.dorsal == null && other.dorsal != null) || (this.dorsal != null && !this.dorsal.equals(other.dorsal))) {
            return false;
        }
        return true;
    }

    //Function to set the width of cells
    private void cellWidth(JTable table) {
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        table.getColumnModel().getColumn(1).setPreferredWidth(90);
        table.getColumnModel().getColumn(2).setPreferredWidth(15);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
    }

    //Function to align cells
    private void alignCells(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
    }

    public void loadTable(JPanel pane) throws SQLException {
        String query = "select * from Ciclistes;";
        Vector data = new Vector();
        Vector row = new Vector();
        int i;
        Database db = new Database();
        db.makeConnection();
        Statement st = db.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        ResultSetMetaData rsmt = rs.getMetaData();
        int c = rsmt.getColumnCount();
        Vector column = new Vector(c);        
        for (i = 1; i <= c; i++) {
            column.add(rsmt.getColumnName(i));

        }
        while (rs.next()) {
            row = new Vector(c);
            for (i = 1; i <= c; i++) {
                row.add(rs.getString(i));
            }
            data.add(row);
        }
        JTable tbCiclyst = new JTable(data, column);
        JScrollPane jsp = new JScrollPane(tbCiclyst);        
        tbCiclyst.getColumnModel().getColumn(0).setHeaderValue("Dorsal");
        tbCiclyst.getColumnModel().getColumn(1).setHeaderValue("Name");
        tbCiclyst.getColumnModel().getColumn(2).setHeaderValue("Age");
        tbCiclyst.getColumnModel().getColumn(3).setHeaderValue("Team");
        cellWidth(tbCiclyst);
        alignCells(tbCiclyst);
        pane.setLayout(new BorderLayout());
        pane.add(jsp, BorderLayout.CENTER);
    }

    @Override
    public String toString() {
        return "cyclists.forms.Ciclyst.Ciclistes[ dorsal=" + dorsal + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
