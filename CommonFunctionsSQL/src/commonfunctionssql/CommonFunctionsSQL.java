/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonfunctionssql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author infot
 */
public class CommonFunctionsSQL {

    /**
     * @param args the command line arguments
     */
    public static Connection makeConnect() throws SQLException {
        String connector = "jdbc:mariadb";
        String pc = "10.0.211.181";
        String port = "3306";
        String bdName = "java8";
        String user = "root";
        String pass = "alumne";
        String connection = connector + "://" + pc + ":" + port + "/" + bdName + "?user=" + user + "&password=" + pass;
        Connection c = DriverManager.getConnection(connection);
        return c;
    }

    public static Connection makeConnect(String bdname) throws SQLException {
        String connector = "jdbc:mariadb";
        String pc = "10.0.211.181";
        String port = "3306";
        String user = "root";
        String pass = "alumne";
        String connection = connector + "://" + pc + ":" + port + "/" + bdname + "?user=" + user + "&password=" + pass;
        Connection c = DriverManager.getConnection(connection);
        return c;
    }

}
