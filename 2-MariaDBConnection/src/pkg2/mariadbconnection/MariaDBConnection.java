/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.mariadbconnection;

/**
 *
 * @author infot
 */
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
public class MariaDBConnection {

    /**
     * @param args the command line arguments
     */
    public static Scanner in = new Scanner(System.in);

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

    public static void createTable(Connection Connect) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS points(");
        sql.append("id integer, ");
        sql.append("nick VARCHAR(256), ");
        sql.append("game VARCHAR(256), ");
        sql.append("points INTEGER "
                + ",primary key(id)) ;");

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
        boolean existPK;
        do {
            System.out.println("ID");
            id = in.nextInt();
            existPK = true;
            if (existID(Connect, "points ", id)) {
                System.out.println("Primary Key already exist");
                existPK = false;
            }
            in.nextLine();
        } while (!existPK);
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
        }
        return false;
    }

    public static boolean existID(Connection Connect, String tableName, int id) {
        String select = "SELECT ID FROM " + tableName + ";";

        try (
                Statement st = Connect.createStatement();
                ResultSet rs = st.executeQuery(select);) {
            while (rs.next()) {
                if (rs.getInt(1) == id) {
                    return true;
                }

            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        String driver = "org.mariadb.jdbc.Driver";
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
