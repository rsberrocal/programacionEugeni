/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenrichard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

//    //Function that returns true if exist one field with the same ID else return false
//    public boolean searchID(String search, String table, int id) throws SQLException {
//        String query = "select " + search + " from " + table + ";";
//        this.makeConnection();
//        try (
//                Statement st = this.getConnection().createStatement();
//                ResultSet rs = st.executeQuery(query);) {
//            while (rs.next()) {
//                if (rs.getInt(1) == id) {
//                    return true;
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("Error " + e.getMessage());
//        }
//        this.closeConnection();
//        return false;
//    }
//
//    //Function only for Llevar table 
//    public boolean searchID(String search, String table, int dorsal, int nstage, String id) throws SQLException {
//        String query = "select " + search + " from " + table + ";";
//        this.makeConnection();
//        try (
//                Statement st = this.getConnection().createStatement();
//                ResultSet rs = st.executeQuery(query);) {
//            while (rs.next()) {
//                if (rs.getInt(1) == dorsal && rs.getInt(2) == nstage && rs.getString(3).equals(id)) {
//                    return true;
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("Error " + e.getMessage());
//        }
//        this.closeConnection();
//        return false;
//    }
//
//    //Same function but with a String variable
//    public boolean searchID(String search, String table, String id) throws SQLException {
//        String query = "select " + search + " from " + table + ";";
//        this.makeConnection();
//        try (
//                Statement st = this.getConnection().createStatement();
//                ResultSet rs = st.executeQuery(query);) {
//            while (rs.next()) {
//                if (rs.getString(1).equals(id)) {
//                    return true;
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("Error " + e.getMessage());
//        }
//        this.closeConnection();
//        return false;
//    }
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
