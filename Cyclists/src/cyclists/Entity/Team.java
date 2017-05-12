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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author infot
 */
public class Team {

    private String nameEq;
    private String manager;

    public Team() {

    }

    public String getNameEq() {
        return nameEq;
    }

    public void setNameEq(String nameEq) {
        this.nameEq = nameEq;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    //Function to set the width of cells
    private void cellWidth(JTable table) {
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(0).setWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setWidth(40);
    }

    //Function to align cells
    private void alignCells(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    }

    //Functions to fill the list of cyclist
    public List listTeam() throws SQLException {
        List<Team> l = new ArrayList<Team>();
        //Query
        String query = "select nomeq,director from Equips;";
        Database db = new Database();
        //Connect
        db.makeConnection();

        Statement st = db.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {//loop rs
            Team t = new Team();
            t.setNameEq(rs.getString(1));
            t.setManager(rs.getString(2));
            l.add(t);
        }//end loop rs
        //Disconnect
        db.closeConnection();
        return l;
    }

    public void loadTable(JPanel pane) throws SQLException {
        String query = "select * from Equips;";
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
        JTable tbTeam = new JTable(data, column);
        JScrollPane jsp = new JScrollPane(tbTeam);
        tbTeam.getColumnModel().getColumn(0).setHeaderValue("Name");
        tbTeam.getColumnModel().getColumn(1).setHeaderValue("Manager");
        cellWidth(tbTeam);
        alignCells(tbTeam);
        pane.setLayout(new BorderLayout());
        pane.add(jsp, BorderLayout.CENTER);
    }
}
