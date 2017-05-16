/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyclists.Entity;

import cyclists.Database;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author infot
 */
public class Llevar {

    private int dorsal;//PK i FK
    private int nStage;//PK i FK
    private String id;//PK i FK

    public Llevar() {
    }

    //Function for set items on ComboBox
    public void addItemsCombo(JComboBox cb1, JComboBox cb2, JComboBox cb3) throws SQLException {
        //Query
        String queryStage = "select netapa from Etapes order by netapa;";
        String queryDorsal = "select dorsal from Ciclistes order by dorsal;";
        String queryID = "select codi from Maillots order by codi;";
        Database db = new Database();
        //Connect
        db.makeConnection();
        try (
                Statement stStage = db.getConnection().createStatement();
                ResultSet rsStage = stStage.executeQuery(queryStage);) {
            while (rsStage.next()) {
                int n = rsStage.getInt(1);
                cb1.addItem(String.valueOf(rsStage.getInt(1)));
            }

            Statement stDorsal = db.getConnection().createStatement();
            ResultSet rsDorsal = stDorsal.executeQuery(queryDorsal);
            while (rsDorsal.next()) {
                cb2.addItem(String.valueOf(rsDorsal.getInt(1)));
            }
            Statement stID = db.getConnection().createStatement();
            ResultSet rsID = stID.executeQuery(queryID);
            while (rsID.next()) {
                cb3.addItem(String.valueOf(rsID.getString(1)));
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        //Disconnect
        db.closeConnection();
    }

    //Function to fill the list of cyclist
    public List listLlevar() throws SQLException {
        List<Llevar> l = new ArrayList<Llevar>();
        //Query
        String query = "select * from Llevar;";
        Database db = new Database();
        //Connect
        db.makeConnection();

        Statement st = db.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {//loop rs
            Llevar ll = new Llevar();
            ll.setDorsal(rs.getInt(1));
            ll.setnStage(rs.getInt(2));
            ll.setId(rs.getString(3));            
            l.add(ll);
        }//end loop rs
        //Disconnect
        db.closeConnection();
        return l;
    }

    public void loadTable(JPanel pane) throws SQLException {
        String query = "select * from Llevar;";
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
        JTable tbPorts = new JTable(data, column);
        JScrollPane jsp = new JScrollPane(tbPorts);
        tbPorts.getColumnModel().getColumn(0).setHeaderValue("Dorsal Cyclist");
        tbPorts.getColumnModel().getColumn(1).setHeaderValue("Stage Num");
        tbPorts.getColumnModel().getColumn(2).setHeaderValue("Shirt ID");
        pane.setLayout(new BorderLayout());
        pane.add(jsp, BorderLayout.CENTER);
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getnStage() {
        return nStage;
    }

    public void setnStage(int nStage) {
        this.nStage = nStage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
