/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg13.ciclistes;

import static commonfunctionssql.CommonFunctionsSQL.makeConnect;
import static pkg13.ciclistes.Main.in;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTransientConnectionException;
import java.sql.Statement;

/**
 *
 * @author infot
 */
public class database {

    private Connection c;

    public database() {
        this.c = null;
    }

    public Connection getConnection() {
        return c;
    }

    public void makeConnection() throws SQLException {
        this.c = makeConnect("ciclistes");
    }

    private static void createTable(int num, Connection c) throws SQLException {
        StringBuilder sql = new StringBuilder();
        switch (num) {
            case 1:
                if (existTable(c, "Ciclistes") && existTable(c, "Etapes") && existTable(c, "Maillots") && !existTable(c, "Llevar")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Llevar(");
                    sql.append("dorsal INTEGER(11), ");
                    sql.append("netapa INTEGER(11) , ");
                    sql.append("codi VARCHAR(6) , ");
                    sql.append("PRIMARY KEY(dorsal,netapa,codi), ");
                    sql.append("FOREIGN KEY (dorsal) REFERENCES Ciclistes (dorsal),");
                    sql.append("FOREIGN KEY (netapa) REFERENCES Etapes (netapa),");
                    sql.append("FOREIGN KEY (codi) REFERENCES Maillots (codi));");
                    executeQuery(c, sql);
                } else if (!existTable(c, "Ciclistes")) {
                    createTable(3, c);
                    createTable(1, c);
                } else if (!existTable(c, "Etapes")) {
                    createTable(4, c);
                    createTable(1, c);
                } else if (!existTable(c, "Maillots")) {
                    createTable(5, c);
                    createTable(1, c);
                }
                System.out.println("Taula Llevar creada");
                break;
            case 2:
                if (!existTable(c, "Equips")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Equips(");
                    sql.append("nomeq VARCHAR(20) PRIMARY KEY, ");
                    sql.append("director VARCHAR(20)); ");
                    executeQuery(c, sql);
                    System.out.println("Taula Equips creada");
                }
                break;
            case 3:
                if (existTable(c, "Equips") && !existTable(c, "Ciclistes")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Ciclistes(");
                    sql.append("dorsal INTEGER(11) PRIMARY KEY, ");
                    sql.append("nom VARCHAR(60), ");
                    sql.append("edad INTEGER(11), ");
                    sql.append("nomeq VARCHAR(50), ");
                    sql.append("FOREIGN KEY (nomeq) REFERENCES Equips (nomeq));");
                    executeQuery(c, sql);
                } else {
                    createTable(2, c);
                    createTable(3, c);
                }
                System.out.println("Taula Ciclistes creada");
                break;
            case 4:
                if (existTable(c, "Ciclistes") && !existTable(c, "Etapes")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Etapes(");
                    sql.append("netapa INTEGER(11) PRIMARY KEY, ");
                    sql.append("km INTEGER(11), ");
                    sql.append("sortida VARCHAR(70), ");
                    sql.append("arribada VARCHAR(70), ");
                    sql.append("dorsal INTEGER(11), ");
                    sql.append("FOREIGN KEY (dorsal) REFERENCES Ciclistes (dorsal));");
                    executeQuery(c, sql);
                    System.out.println("Taula Etapes creada");
                } else {
                    createTable(3, c);
                    createTable(4, c);
                }
                break;
            case 5:
                if (!existTable(c, "Maillots")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Maillots(");
                    sql.append("codi VARCHAR(6) PRIMARY KEY , ");
                    sql.append("tipus VARCHAR(60), ");
                    sql.append("color VARCHAR(40), ");
                    sql.append("premi INTEGER(11));");
                    executeQuery(c, sql);
                    System.out.println("Taula Maillots creada");
                }
                break;
            case 6:
                if (existTable(c, "Etapes") && existTable(c, "Ciclistes") && !existTable(c, "Ports")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Ports(");
                    sql.append("nomport VARCHAR(70) PRIMARY KEY, ");
                    sql.append("alcada INTEGER(11), ");
                    sql.append("categoria VARCHAR(2), ");
                    sql.append("pendent FLOAT, ");
                    sql.append("netapa INTEGER(11), ");
                    sql.append("dorsal INTEGER(11), ");
                    sql.append("FOREIGN KEY (netapa) REFERENCES Etapes (netapa), ");
                    sql.append("FOREIGN KEY (dorsal) REFERENCES Ciclistes (dorsal));");
                    executeQuery(c, sql);
                    System.out.println("Taula Ports creada");
                } else if (!existTable(c, "Etapes")) {
                    createTable(4, c);
                    createTable(6, c);
                } else if (!existTable(c, "Ciclistes")) {
                    createTable(3, c);
                    createTable(6, c);
                }
        }

    }

    public static void createTable(int num) throws SQLException {
        StringBuilder sql = new StringBuilder();
        database c = new database();
        c.makeConnection();
        switch (num) {
            case 1:
                if (existTable(c.getConnection(), "Ciclistes") && existTable(c.getConnection(), "Etapes") && existTable(c.getConnection(), "Maillots") && !existTable(c.getConnection(), "Llevar")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Llevar(");
                    sql.append("dorsal INTEGER(11), ");
                    sql.append("netapa INTEGER(11) , ");
                    sql.append("codi VARCHAR(6) , ");
                    sql.append("PRIMARY KEY(dorsal,netapa,codi), ");
                    sql.append("FOREIGN KEY (dorsal) REFERENCES Ciclistes (dorsal),");
                    sql.append("FOREIGN KEY (netapa) REFERENCES Etapes (netapa),");
                    sql.append("FOREIGN KEY (codi) REFERENCES Maillots (codi));");
                    executeQuery(c.getConnection(), sql);
                } else if (!existTable(c.getConnection(), "Ciclistes")) {
                    createTable(3, c.getConnection());
                    createTable(1, c.getConnection());
                } else if (!existTable(c.getConnection(), "Etapes")) {
                    createTable(4, c.getConnection());
                    createTable(1, c.getConnection());
                } else if (!existTable(c.getConnection(), "Maillots")) {
                    createTable(5, c.getConnection());
                    createTable(1, c.getConnection());
                }
                System.out.println("Taula Llevar creada");
                break;
            case 2:
                if (!existTable(c.getConnection(), "Equips")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Equips(");
                }
                sql.append("nomeq VARCHAR(20) PRIMARY KEY, ");
                sql.append("director VARCHAR(20)); ");
                executeQuery(c.getConnection(), sql);
                System.out.println("Taula Equips creada");
                break;
            case 3:
                if (existTable(c.getConnection(), "Equips")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Ciclistes(");
                    sql.append("dorsal INTEGER(11) PRIMARY KEY, ");
                    sql.append("nom VARCHAR(60), ");
                    sql.append("edad INTEGER(11), ");
                    sql.append("nomeq VARCHAR(50), ");
                    sql.append("FOREIGN KEY (nomeq) REFERENCES Equips (nomeq));");
                    executeQuery(c.getConnection(), sql);
                } else {
                    createTable(2, c.getConnection());
                    createTable(3, c.getConnection());
                }
                System.out.println("Taula Ciclistes creada");
                break;
            case 4:
                if (existTable(c.getConnection(), "Ciclistes") && !existTable(c.getConnection(), "Etapes")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Etapes(");
                    sql.append("netapa INTEGER(11) PRIMARY KEY, ");
                    sql.append("km INTEGER(11), ");
                    sql.append("sortida VARCHAR(70), ");
                    sql.append("arribada VARCHAR(70), ");
                    sql.append("dorsal INTEGER(11), ");
                    sql.append("FOREIGN KEY (dorsal) REFERENCES Ciclistes (dorsal));");
                    executeQuery(c.getConnection(), sql);
                    System.out.println("Taula Etapes creada");
                } else {
                    createTable(3, c.getConnection());
                    createTable(4, c.getConnection());
                }
                break;
            case 5:
                if (!existTable(c.getConnection(), "Equips")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Maillots(");
                    sql.append("codi VARCHAR(6) PRIMARY KEY , ");
                    sql.append("tipus VARCHAR(60), ");
                    sql.append("color VARCHAR(40), ");
                    sql.append("premi INTEGER(11));");
                    executeQuery(c.getConnection(), sql);
                    System.out.println("Taula Maillots creada");
                }
                break;
            case 6:
                if (existTable(c.getConnection(), "Etapes") && existTable(c.getConnection(), "Ciclistes") && !existTable(c.getConnection(), "Ports")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Ports(");
                    sql.append("nomport VARCHAR(70) PRIMARY KEY, ");
                    sql.append("alcada INTEGER(11), ");
                    sql.append("categoria VARCHAR(2), ");
                    sql.append("pendent FLOAT, ");
                    sql.append("netapa INTEGER(11), ");
                    sql.append("dorsal INTEGER(11), ");
                    sql.append("FOREIGN KEY (netapa) REFERENCES Etapes (netapa), ");
                    sql.append("FOREIGN KEY (dorsal) REFERENCES Ciclistes (dorsal));");
                    executeQuery(c.getConnection(), sql);
                    System.out.println("Taula Ports creada");
                } else if (!existTable(c.getConnection(), "Etapes")) {
                    createTable(4, c.getConnection());
                    createTable(6, c.getConnection());
                } else if (!existTable(c.getConnection(), "Ciclistes")) {
                    createTable(3, c.getConnection());
                    createTable(6, c.getConnection());
                }
                break;
            case 7:
                for (int i = 1; i <= 6; i++) {
                    createTable(i, c.getConnection());
                }
                System.out.println("Totes les taules creades");
                break;
        }

        c.getConnection().close();

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

    public void dropTables(int num) throws SQLException {
        StringBuilder sql = new StringBuilder();
        database c = new database();
        c.makeConnection();
        switch (num) {
            case 1:
                if (existTable(c.getConnection(), "Ciclistes") && existTable(c.getConnection(), "Etapes") && existTable(c.getConnection(), "Maillots") && !existTable(c.getConnection(), "Llevar")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Llevar(");
                    sql.append("dorsal INTEGER(11), ");
                    sql.append("netapa INTEGER(11) , ");
                    sql.append("codi VARCHAR(6) , ");
                    sql.append("PRIMARY KEY(dorsal,netapa,codi), ");
                    sql.append("FOREIGN KEY (dorsal) REFERENCES Ciclistes (dorsal),");
                    sql.append("FOREIGN KEY (netapa) REFERENCES Etapes (netapa),");
                    sql.append("FOREIGN KEY (codi) REFERENCES Maillots (codi));");
                    executeQuery(c.getConnection(), sql);
                } else if (!existTable(c.getConnection(), "Ciclistes")) {
                    createTable(3, c.getConnection());
                    createTable(1, c.getConnection());
                } else if (!existTable(c.getConnection(), "Etapes")) {
                    createTable(4, c.getConnection());
                    createTable(1, c.getConnection());
                } else if (!existTable(c.getConnection(), "Maillots")) {
                    createTable(5, c.getConnection());
                    createTable(1, c.getConnection());
                }
                System.out.println("Taula Llevar creada");
                break;
            case 2:
                if (!existTable(c.getConnection(), "Equips")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Equips(");
                }
                sql.append("nomeq VARCHAR(20) PRIMARY KEY, ");
                sql.append("director VARCHAR(20)); ");
                executeQuery(c.getConnection(), sql);
                System.out.println("Taula Equips creada");
                break;
            case 3:
                if (existTable(c.getConnection(), "Equips")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Ciclistes(");
                    sql.append("dorsal INTEGER(11) PRIMARY KEY, ");
                    sql.append("nom VARCHAR(60), ");
                    sql.append("edad INTEGER(11), ");
                    sql.append("nomeq VARCHAR(50), ");
                    sql.append("FOREIGN KEY (nomeq) REFERENCES Equips (nomeq));");
                    executeQuery(c.getConnection(), sql);
                } else {
                    createTable(2, c.getConnection());
                    createTable(3, c.getConnection());
                }
                System.out.println("Taula Ciclistes creada");
                break;
            case 4:
                if (existTable(c.getConnection(), "Ciclistes") && !existTable(c.getConnection(), "Etapes")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Etapes(");
                    sql.append("netapa INTEGER(11) PRIMARY KEY, ");
                    sql.append("km INTEGER(11), ");
                    sql.append("sortida VARCHAR(70), ");
                    sql.append("arribada VARCHAR(70), ");
                    sql.append("dorsal INTEGER(11), ");
                    sql.append("FOREIGN KEY (dorsal) REFERENCES Ciclistes (dorsal));");
                    executeQuery(c.getConnection(), sql);
                    System.out.println("Taula Etapes creada");
                } else {
                    createTable(3, c.getConnection());
                    createTable(4, c.getConnection());
                }
                break;
            case 5:
                if (!existTable(c.getConnection(), "Equips")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Maillots(");
                    sql.append("codi VARCHAR(6) PRIMARY KEY , ");
                    sql.append("tipus VARCHAR(60), ");
                    sql.append("color VARCHAR(40), ");
                    sql.append("premi INTEGER(11));");
                    executeQuery(c.getConnection(), sql);
                    System.out.println("Taula Maillots creada");
                }
                break;
            case 6:
                if (existTable(c.getConnection(), "Etapes") && existTable(c.getConnection(), "Ciclistes") && !existTable(c.getConnection(), "Ports")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Ports(");
                    sql.append("nomport VARCHAR(70) PRIMARY KEY, ");
                    sql.append("alcada INTEGER(11), ");
                    sql.append("categoria VARCHAR(2), ");
                    sql.append("pendent FLOAT, ");
                    sql.append("netapa INTEGER(11), ");
                    sql.append("dorsal INTEGER(11), ");
                    sql.append("FOREIGN KEY (netapa) REFERENCES Etapes (netapa), ");
                    sql.append("FOREIGN KEY (dorsal) REFERENCES Ciclistes (dorsal));");
                    executeQuery(c.getConnection(), sql);
                    System.out.println("Taula Ports creada");
                } else if (!existTable(c.getConnection(), "Etapes")) {
                    createTable(4, c.getConnection());
                    createTable(6, c.getConnection());
                } else if (!existTable(c.getConnection(), "Ciclistes")) {
                    createTable(3, c.getConnection());
                    createTable(6, c.getConnection());
                }
                break;
            case 7:
                for (int i = 1; i <= 6; i++) {
                    createTable(i, c.getConnection());
                }
                System.out.println("Totes les taules creades");
                break;
        }

        c.getConnection().close();
    }

    private static void executeQuery(Connection Connect, StringBuilder sql) throws SQLException {
        try (
                Statement st = Connect.createStatement()) {
            st.executeQuery(sql.toString());
        } catch (SQLTransientConnectionException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void printTables() {

    }

}
