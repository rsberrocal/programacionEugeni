/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg13.ciclistes;

import static pkg13.ciclistes.Main.in;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTransientConnectionException;
import java.sql.Statement;
import static commonfunctionssql.CommonFunctionsSQL.makeConnectMariaDB;
import static commonfunctionssql.CommonFunctionsSQL.makeConnectMySQL;

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
                    System.out.println("Taula Llevar creada");
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
                    System.out.println("Taula Ciclistes creada");
                } else if (!existTable(c, "Equips")) {
                    createTable(2, c);
                    createTable(3, c);
                }
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
                } else if (!existTable(c, "Ciclistes")) {
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
        Database c = new Database();
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
                    System.out.println("Taula Llevar creada");
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
                break;
            case 2:
                if (!existTable(c.getConnection(), "Equips")) {
                    sql.append("CREATE TABLE IF NOT EXISTS Equips(");
                    sql.append("nomeq VARCHAR(20) PRIMARY KEY, ");
                    sql.append("director VARCHAR(20)); ");
                    executeQuery(c.getConnection(), sql);
                    System.out.println("Taula Equips creada");
                }
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
                    System.out.println("Taula Ciclistes creada");
                } else if (!existTable(c.getConnection(), "Equips")) {
                    createTable(2, c.getConnection());
                    createTable(3, c.getConnection());
                }
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
                } else if (!existTable(c.getConnection(), "Ciclistes")) {
                    createTable(3, c.getConnection());
                    createTable(4, c.getConnection());
                }
                break;
            case 5:
                if (!existTable(c.getConnection(), "Maillots")) {
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
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT count(*) ");
        sql.append("FROM information_schema.TABLES ");
        sql.append("WHERE (TABLE_SCHEMA = 'rsudario_gproductes') AND (TABLE_NAME = '" + tableName + "')");
        int n = 0;
        try (
                Statement st = Connect.createStatement();
                ResultSet rs = st.executeQuery(sql.toString());) {
            while (rs.next()) {
                n = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        if (n > 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void dropTables(int num, Connection c) throws SQLException {
        switch (num) {
            case 1:
                if (existTable(c, "Llevar")) {
                    String llevar = "DROP TABLE Llevar";
                    executeQuery(c, llevar);
                    System.out.println("Taula Llevar eliminada");
                }
                break;
            case 2:
                if (!existTable(c, "Ciclistes") && existTable(c, "Equips")) {
                    String equips = "DROP TABLE Equips";
                    executeQuery(c, equips);
                } else if (existTable(c, "Ciclistes")) {
                    dropTables(3, c);
                    dropTables(2, c);
                }
                break;
            case 3:
                if (existTable(c, "Ciclistes") && !existTable(c, "Etapes") && !existTable(c, "Ports")) {
                    String ciclistes = "DROP TABLE Ciclistes";
                    executeQuery(c, ciclistes);
                    System.out.println("Taula Ciclistes eliminada");
                } else if (existTable(c, "Etapes")) {
                    dropTables(4, c);
                    dropTables(3, c);
                } else if (existTable(c, "Ports")) {
                    dropTables(6, c);
                    dropTables(3, c);
                }
                break;
            case 4:
                if (existTable(c, "Etapes") && !existTable(c, "Llevar") && !existTable(c, "Ports")) {
                    String etapes = "DROP TABLE Etapes";
                    executeQuery(c, etapes);
                    System.out.println("Taula Etapes eliminada");
                } else if (existTable(c, "Llevar")) {
                    dropTables(1, c);
                    dropTables(4, c);
                } else if (existTable(c, "Ports")) {
                    dropTables(6, c);
                    dropTables(4, c);
                }
                break;
            case 5:
                if (existTable(c, "Maillots") && !existTable(c, "Llevar")) {
                    String maillots = "DROP TABLE Maillots";
                    executeQuery(c, maillots);
                    System.out.println("Taula Maillots eliminada");
                } else if (existTable(c, "Llevar")) {
                    dropTables(1, c);
                    dropTables(5, c);
                }
                break;
            case 6:
                if (existTable(c, "Ports")) {
                    String ports = "DROP TABLE Ports";
                    executeQuery(c, ports);
                    System.out.println("Taula Llevar eliminada");
                }
                break;
        }
    }

    public void dropTables(int num) throws SQLException {

        Database c = new Database();
        c.makeConnection();
        switch (num) {
            case 1:
                if (existTable(c.getConnection(), "Llevar")) {
                    String llevar = "DROP TABLE Llevar";
                    executeQuery(c.getConnection(), llevar);
                    System.out.println("Taula Llevar eliminada");
                }
                break;
            case 2:
                if (!existTable(c.getConnection(), "Ciclistes") && existTable(c.getConnection(), "Equips")) {
                    String equips = "DROP TABLE Equips";
                    executeQuery(c.getConnection(), equips);
                } else if (existTable(c.getConnection(), "Ciclistes")) {
                    dropTables(3, c.getConnection());
                    dropTables(2, c.getConnection());
                }
                break;
            case 3:
                if (existTable(c.getConnection(), "Ciclistes") && !existTable(c.getConnection(), "Etapes") && !existTable(c.getConnection(), "Ports")) {
                    String ciclistes = "DROP TABLE Ciclistes";
                    executeQuery(c.getConnection(), ciclistes);
                    System.out.println("Taula Ciclistes eliminada");
                } else if (existTable(c.getConnection(), "Etapes")) {
                    dropTables(4, c.getConnection());
                    dropTables(3, c.getConnection());
                } else if (existTable(c.getConnection(), "Ports")) {
                    dropTables(6, c.getConnection());
                    dropTables(3, c.getConnection());
                }
                break;
            case 4:
                if (existTable(c.getConnection(), "Etapes") && !existTable(c.getConnection(), "Llevar")) {
                    String etapes = "DROP TABLE Etapes";
                    executeQuery(c.getConnection(), etapes);
                    System.out.println("Taula Etapes eliminada");
                } else if (existTable(c.getConnection(), "Llevar")) {
                    dropTables(1, c.getConnection());
                    dropTables(4, c.getConnection());
                }
                break;
            case 5:
                if (existTable(c.getConnection(), "Maillots") && !existTable(c.getConnection(), "Llevar")) {
                    String maillots = "DROP TABLE Maillots";
                    executeQuery(c.getConnection(), maillots);
                    System.out.println("Taula Maillots eliminada");
                } else if (existTable(c.getConnection(), "Llevar")) {
                    dropTables(1, c.getConnection());
                    dropTables(5, c.getConnection());
                }
                break;
            case 6:
                if (existTable(c.getConnection(), "Ports")) {
                    String ports = "DROP TABLE Ports";
                    executeQuery(c.getConnection(), ports);
                    System.out.println("Taula Llevar eliminada");
                }
                break;
            case 7:
                for (int i = 1; i <= 6; i++) {
                    dropTables(i, c.getConnection());
                }
                System.out.println("Totes les taules eliminades");
                break;
        }

        c.getConnection().close();
    }

    private static void executeQuery(Connection Connect, StringBuilder sql) throws SQLException {
        try (
                Statement st = Connect.createStatement()) {
            st.executeQuery(sql.toString());
        } catch (SQLTransientConnectionException e) {
            System.out.println("");
        }
    }

    private static void executeQuery(Connection Connect, String sql) throws SQLException {
        try (
                Statement st = Connect.createStatement()) {
            st.executeQuery(sql);
        } catch (SQLTransientConnectionException e) {
            System.out.println("");
        }
    }

    public void printTables() {

    }

}
