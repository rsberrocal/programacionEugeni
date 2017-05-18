/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenrichard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author infot
 */
public class Database {

    //Connection variable to connect to the server
    private Connection c;

    //Constructor
    public Database() {
        this.c = null;
    }

    public Connection getConnection() {
        return c;
    }
   
    //Function to make a connectio to the server
    public void makeConnection() throws SQLException {
        //MariaDB
        String connector = "jdbc:mariadb";
        String port = "3306";
        //Host
        String pc = "10.0.211.200";
        //Bd name
        String bd = "employees";
        //Login
        String user = "alumne";
        String pass = "pasAlumne";

        String connection = connector + "://" + pc + ":" + port + "/" + bd + "?user=" + user + "&password=" + pass;
        this.c = DriverManager.getConnection(connection);
    }

    public void closeConnection() throws SQLException {
        this.c.close();
    }
}
