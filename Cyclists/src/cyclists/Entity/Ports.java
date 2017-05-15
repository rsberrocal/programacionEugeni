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
public class Ports {

	private String portName;
	private int height;
	private String category;
	private double slope;
	private int netapa;
	private int dorsal;

	public Ports() {
	}

	//Function to fill the list of cyclist
	public List listShirt() throws SQLException {
		List<Ports> l = new ArrayList<Ports>();
		//Query
		String query = "select * from Ports;";
		Database db = new Database();
		//Connect
		db.makeConnection();

		Statement st = db.getConnection().createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {//loop rs
			Ports p = new Ports();
			p.setPortName(rs.getString(1));
			p.setHeight(rs.getInt(2));
			p.setCategory(rs.getString(3));
			p.setSlope(rs.getDouble(4));
			p.setNetapa(rs.getInt(5));
			p.setDorsal(rs.getInt(6));
			l.add(p);
		}//end loop rs
		//Disconnect
		db.closeConnection();
		return l;
	}

	public void loadTable(JPanel pane) throws SQLException {
		String query = "select * from Ports;";		
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
		tbPorts.getColumnModel().getColumn(0).setHeaderValue("Name");
		tbPorts.getColumnModel().getColumn(1).setHeaderValue("Height");
		tbPorts.getColumnModel().getColumn(2).setHeaderValue("Category");
		tbPorts.getColumnModel().getColumn(3).setHeaderValue("Slope");
		tbPorts.getColumnModel().getColumn(4).setHeaderValue("Stage num");
		tbPorts.getColumnModel().getColumn(5).setHeaderValue("Cyclist dorsal");
		pane.setLayout(new BorderLayout());
		pane.add(jsp, BorderLayout.CENTER);
	}

	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getSlope() {
		return slope;
	}

	public void setSlope(double slope) {
		this.slope = slope;
	}

	public int getNetapa() {
		return netapa;
	}

	public void setNetapa(int netapa) {
		this.netapa = netapa;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
}
