/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg14.swingciclistes;

import static commonfunctionssql.CommonFunctionsSQL.makeConnect;
import java.sql.Connection;
import java.sql.SQLException;

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
        this.c = makeConnect("ciclistes");
    }
    public void closeConnection() throws SQLException{
        this.c.close();
    }
}
