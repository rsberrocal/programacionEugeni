/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenrichard.Entity;

import examenrichard.Database;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author infot
 */
public class DeptManager {

    private String dept_name;
    private String name;
    private String surname;

    public DeptManager() {
    }

    //Function that fill the table from DeptManager
    public void loadTable(JPanel pane) throws SQLException {
        //Query
        String query = "select de.dept_name,emp.first_name,emp.last_name "
                + "from departments de,dept_manager dm,employees emp "
                + "where de.dept_no=dm.dept_no "
                + "and emp.emp_no=dm.emp_no;";
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
        JTable tbEmployees = new JTable(data, column);
        //Create pane that contains our table
        JScrollPane jsp = new JScrollPane(tbEmployees);
        //Set headers name
        tbEmployees.getColumnModel().getColumn(0).setHeaderValue("Nom de departament");
        tbEmployees.getColumnModel().getColumn(1).setHeaderValue("Nom");
        tbEmployees.getColumnModel().getColumn(2).setHeaderValue("Cognom");
        pane.setLayout(new BorderLayout());
        //Finally add the pane with table to our pane
        pane.add(jsp, BorderLayout.CENTER);
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
