/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg11.sqlbdgames;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTransientConnectionException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author infot
 */
public class SQLBDGames {

    /**
     * @param args the command line arguments
     */
    public static Scanner in = new Scanner(System.in);

    public static Connection makeConnect() throws SQLException {
        String connector = "jdbc:hsqldb:hsql";
        String pc = "localhost";
        String port = "9001";
        String bdName = "java8";
        String user = "sa";
        String pass = "";
        String connection = connector + "://" + pc + ":" + port + "/" + bdName;
        Connection c = DriverManager.getConnection(connection, user, pass);
        return c;
    }

    public static void createTable(Connection Connect) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS points(");
        sql.append("id INTEGER IDENTITY, ");
        sql.append("nick VARCHAR(256), ");
        sql.append("game VARCHAR(256), ");
        sql.append("points INTEGER );");

        try (
                Statement st = Connect.createStatement()) {
            st.executeQuery(sql.toString());
        } catch (SQLTransientConnectionException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public static void addData(Connection Connect) throws SQLException {
        int id;
        String nick, game, sqlInsert;
        int points;
        System.out.println("ID");
        id = in.nextInt();
        in.nextLine();
        System.out.println("Nickname");
        nick = in.nextLine();
        System.out.println("Name of the game");
        game = in.nextLine();
        System.out.println("Points");
        points = in.nextInt();
        in.nextLine();

        sqlInsert = "INSERT INTO points VALUES(?,?,?,?)";
        try (
                PreparedStatement pst = Connect.prepareStatement(sqlInsert)) {
            pst.setInt(1, id);
            pst.setString(2, nick);
            pst.setString(3, game);
            pst.setInt(4, points);

            pst.execute();

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public static void printData(Connection Connect) throws SQLException {
        String select = "SELECT * FROM points;";

        try (
                Statement st = Connect.createStatement();
                ResultSet rs = st.executeQuery(select);) {
            System.out.println("ID \tNickname \tGame \tPoints");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getInt(4));
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public static boolean existTable(Connection Connect, String tableName) {
        String select = "SELECT * FROM " + tableName + ";";

        try (
                Statement st = Connect.createStatement();
                ResultSet rs = st.executeQuery(select);) {
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        String driver = "org.hsqldb.jdbcDriver";
        Class.forName(driver);
        Connection c = makeConnect();
        if (!existTable(c, "points")) {
        createTable(c);
        }
        addData(c);
        printData(c);
        c.close();

    }

}
