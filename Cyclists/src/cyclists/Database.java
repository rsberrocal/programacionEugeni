/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyclists;

import static commonfunctionssql.CommonFunctionsSQL.makeConnectMariaDB;
import java.sql.Connection;
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
    //Function that returns true if exist one field with the same ID else return false
    public boolean searchID(String search, String table, int id) throws SQLException {
        String query = "select " + search + " from " + table + ";";
        this.makeConnection();
        try (
                Statement st = this.getConnection().createStatement();
                ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                if (rs.getInt(1) == id) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        this.closeConnection();
        return false;
    }
    //Same function but with a String variable
    public boolean searchID(String search, String table, String id) throws SQLException {
        String query = "select " + search + " from " + table + ";";
        this.makeConnection();
        try (
                Statement st = this.getConnection().createStatement();
                ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {                
                if (rs.getString(1).equals(id)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        this.closeConnection();
        return false;
    }
    //Function to make a connectio to the server
    public void makeConnection() throws SQLException {
        //MySQL
        //this.c = makeConnectMySQL();        
        //MariaDB
        String pc = "mestral.ddns.net";
        String bd = "rsudario_gproductes";
        String user = "rsudario";
        String pass = "rsudario";
        this.c = makeConnectMariaDB(pc, bd, user, pass);
    }

    public void closeConnection() throws SQLException {
        this.c.close();
    }
}
