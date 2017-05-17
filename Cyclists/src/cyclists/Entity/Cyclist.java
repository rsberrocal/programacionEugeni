package cyclists.Entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cyclists.Database;
import java.awt.BorderLayout;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Richard
 */
public class Cyclist implements Serializable {

    private Integer dorsal;//PK

    private String nom;

    private Integer edad;

    private String nomeq;//FK

    public Cyclist() {
    }

    public Cyclist(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNomeq() {
        return nomeq;
    }

    public void setNomeq(String nomeq) {
        this.nomeq = nomeq;
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

    //Functions to fill the list of cyclist
    public List cyclistData() throws SQLException {
        List<Cyclist> l = new ArrayList<Cyclist>();
        //Query
        String query = "select dorsal,nom,edad,nomeq from Ciclistes;";
        Database db = new Database();
        //Connect
        db.makeConnection();

        Statement st = db.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {//loop rs
            Cyclist c = new Cyclist();
            c.setDorsal(rs.getInt(1));
            c.setNom(rs.getString(2));
            c.setEdad(rs.getInt(3));
            c.setNomeq(rs.getString(4));
            l.add(c);
        }//end loop rs
        //Disconnect
        db.closeConnection();
        return l;
    }
    //Function that fill the table from Cyclist
    public void loadTable(JPanel pane) throws SQLException {
        //Query
        String query = "select * from Ciclistes;";
        //Array that contains all the data
        Vector data = new Vector();
        //Array for each row
        Vector row = new Vector();
        //Cont
        int i;

        Database db = new Database();
        //Connect
        db.makeConnection();
        //Execute Query
        Statement st = db.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        ResultSetMetaData rsmt = rs.getMetaData();
        //This give you the number of columns from Ciclistes
        int c = rsmt.getColumnCount();
        //New Array for each column
        Vector column = new Vector(c);
        for (i = 1; i <= c; i++) {//Loop to add all columns
            column.add(rsmt.getColumnName(i));
        }//End loop
        //Loop to fill data on row and late add this row in data
        while (rs.next()) {
            row = new Vector(c);
            for (i = 1; i <= c; i++) {
                row.add(rs.getString(i));
            }
            data.add(row);
        }//End loop
        //Create new Table
        JTable tbCiclyst = new JTable(data, column);
        //Create pane that contains our table
        JScrollPane jsp = new JScrollPane(tbCiclyst);
        //Set headers name
        tbCiclyst.getColumnModel().getColumn(0).setHeaderValue("Dorsal");
        tbCiclyst.getColumnModel().getColumn(1).setHeaderValue("Name");
        tbCiclyst.getColumnModel().getColumn(2).setHeaderValue("Age");
        tbCiclyst.getColumnModel().getColumn(3).setHeaderValue("Team");
        //Set widht
        cellWidth(tbCiclyst);
        //Align cells
        alignCells(tbCiclyst);
        pane.setLayout(new BorderLayout());
        //Finally add the pane with table to our pane
        pane.add(jsp, BorderLayout.CENTER);
    }

    @Override
    public String toString() {
        return "cyclists.forms.Ciclyst.Ciclistes[ dorsal=" + dorsal + " ]";
    }

}
