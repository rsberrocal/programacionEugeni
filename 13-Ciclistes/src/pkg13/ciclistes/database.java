/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg13.ciclistes;

import static commonfunctionssql.CommonFunctionsSQL.makeConnect;
import static pkg13.ciclistes.Main.in;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLTransientConnectionException;
import java.sql.Statement;

/**
 *
 * @author infot
 */
public class database {
    private Connection c;
       
    public database(){
        this.c=null;
    }
    
    public void makeConnection() throws SQLException{
        this.c=makeConnect("ciclistes");
    }    
    
    public static void createTable(Connection Connect) throws SQLException {
        StringBuilder sql = new StringBuilder();
        String name_table;
        System.out.println("Dona'm el nom de la nova taula");
        name_table=in.nextLine();
        sql.append("CREATE TABLE IF NOT EXISTS"+name_table+"(");
        System.out.println("Dona'm la clau primaria");
        
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
    
    public void printTables(){
        
    }
    
}
