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
public class Stage {

    private int nStage;//PK
    private int km;
    private String start;
    private String finish;
    private int dorsal;//FK

    public Stage() {
    }

    //Function for set items on ComboBox
    public void addItemsCombo(JComboBox cb1) throws SQLException {
        //Query        
        String queryDorsal = "select dorsal from Ciclistes order by dorsal;";
        Database db = new Database();
        //Connect
        db.makeConnection();
        try {
            Statement stDorsal = db.getConnection().createStatement();
            ResultSet rsDorsal = stDorsal.executeQuery(queryDorsal);
            while (rsDorsal.next()) {
                cb1.addItem(String.valueOf(rsDorsal.getInt(1)));
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        //Disconnect
        db.closeConnection();
    }

    //Function to fill the list of cyclist
    public List listStage() throws SQLException {
        List<Stage> l = new ArrayList<Stage>();
        //Query
        String query = "select * from Etapes;";
        Database db = new Database();
        //Connect
        db.makeConnection();

        Statement st = db.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {//loop rs
            Stage s = new Stage();
            s.setnStage(rs.getInt(1));
            s.setKm(rs.getInt(2));
            s.setStart(rs.getString(3));
            s.setFinish(rs.getString(4));
            s.setDorsal(rs.getInt(5));
            l.add(s);
        }//end loop rs
        //Disconnect
        db.closeConnection();
        return l;
    }

    public void loadTable(JPanel pane) throws SQLException {
        String query = "select * from Etapes;";
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
        tbPorts.getColumnModel().getColumn(0).setHeaderValue("Num Stage");
        tbPorts.getColumnModel().getColumn(1).setHeaderValue("Km");
        tbPorts.getColumnModel().getColumn(2).setHeaderValue("Start");
        tbPorts.getColumnModel().getColumn(3).setHeaderValue("Finish");
        tbPorts.getColumnModel().getColumn(4).setHeaderValue("Cyclist dorsal");
        pane.setLayout(new BorderLayout());
        pane.add(jsp, BorderLayout.CENTER);
    }

    public int getnStage() {
        return nStage;
    }

    public void setnStage(int nStage) {
        this.nStage = nStage;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

}
