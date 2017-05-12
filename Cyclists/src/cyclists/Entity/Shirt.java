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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author infot
 */
public class Shirt {

    private String id;
    private String type;
    private String color;
    private int reward;

    public Shirt() {
    }

    //Function to fill the list of cyclist
    public List listShirt() throws SQLException {
        List<Shirt> l = new ArrayList<Shirt>();
        //Query
        String query = "select * from Maillots;";
        Database db = new Database();
        //Connect
        db.makeConnection();

        Statement st = db.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {//loop rs
            Shirt s = new Shirt();
            s.setId(rs.getString(1));
            s.setType(rs.getString(2));
            s.setColor(rs.getString(3));
            s.setReward(rs.getInt(4));
            l.add(s);
        }//end loop rs
        //Disconnect
        db.closeConnection();
        return l;
    }

    public void loadTable(JPanel pane) throws SQLException {
        String query = "select * from Maillots;";
        String reward = "";
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
                if (i == 4) {
                    reward = rs.getString(i) + "€";
                    row.add(reward);
                } else {
                    row.add(rs.getString(i));
                }
            }
            data.add(row);
        }
        JTable tbShirt = new JTable(data, column);
        JScrollPane jsp = new JScrollPane(tbShirt);
        tbShirt.getColumnModel().getColumn(0).setHeaderValue("ID");
        tbShirt.getColumnModel().getColumn(1).setHeaderValue("Type");
        tbShirt.getColumnModel().getColumn(2).setHeaderValue("Color");
        tbShirt.getColumnModel().getColumn(3).setHeaderValue("Reward");
        pane.setLayout(new BorderLayout());
        pane.add(jsp, BorderLayout.CENTER);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

}
