/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg14.swingciclistes;

import static commonfunctionssql.CommonFunctionsSQL.makeConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author infot
 */
public class Database {

    private Connection c;

    public Database() {
        this.c = null;
    }

    public Connection getConnection() {
        return c;
    }

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
    
    public boolean searchID(String search, String table, String id) throws SQLException {
        String query = "select " + search + " from " + table + ";";
        this.makeConnection();
        try (
                Statement st = this.getConnection().createStatement();
                ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                if (rs.getString(1) == id) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        this.closeConnection();
        return false;
    }

    public void makeConnection() throws SQLException {
        this.c = makeConnect("ciclistes");
    }

    public void closeConnection() throws SQLException {
        this.c.close();
    }
}
