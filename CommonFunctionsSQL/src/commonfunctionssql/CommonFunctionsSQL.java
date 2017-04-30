/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonfunctionssql;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public static Connection makeConnectMySQL() throws SQLException {
        String connector = "jdbc:mysql";
        String pc = "mysql.hostinger.es";
        String port = "3306";
        String bdName = "u571250913_cicl";
        String user = "u571250913_ciclu";
        String pass = "alumne";
        String connection = connector + "://" + pc + ":" + port + "/" + bdName;
        Connection c = DriverManager.getConnection(connection, user, pass);
        return c;
    }

    public static Connection makeConnectMySQL(String bdName) throws SQLException {
        String connector = "jdbc:mysql";
        String pc = "mysql.hostinger.es";
        String port = "3306";
        String user = "u571250913_ciclu";
        String pass = "alumne";
        String connection = connector + "://" + pc + ":" + port + "/" + bdName;
        Connection c = DriverManager.getConnection(connection, user, pass);
        return c;
    }

    public static Connection makeConnectMySQL(String pc, String bdName, String user, String pass) throws SQLException {
        String connector = "jdbc:mysql";
        String port = "3306";
        String connection = connector + "://" + pc + ":" + port + "/" + bdName;
        Connection c = DriverManager.getConnection(connection, user, pass);
        return c;
    }

    public static Connection makeConnectMariaDB() throws SQLException {
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

    public static Connection makeConnectMariaDB(String pc, String bdName, String user, String pass) throws SQLException {
        String connector = "jdbc:mariadb";
        String port = "3306";
        String connection = connector + "://" + pc + ":" + port + "/" + bdName + "?user=" + user + "&password=" + pass;
        Connection c = DriverManager.getConnection(connection);
        return c;
    }

    public static Connection makeConnectMariaDB(String bdname) throws SQLException {
        String connector = "jdbc:mariadb";
        String pc = "10.0.211.181";
        String port = "3306";
        String user = "root";
        String pass = "alumne";
        String connection = connector + "://" + pc + ":" + port + "/" + bdname + "?user=" + user + "&password=" + pass;
        Connection c = DriverManager.getConnection(connection);
        return c;
    }

    public static boolean comprovaDir(String dir) {
        boolean flag;
        Path path = Paths.get(dir);
        return flag = Files.exists(path);
    }

}
