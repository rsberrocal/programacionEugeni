package control_examenuf1_rsudario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SQLHelper {

    private static SQLHelper instancia;
    private static Connection connection;
     
    private SQLHelper() {   
    try {
        connection = getConnexio();
        } catch (SQLException ex) {
            Logger.getLogger(SQLHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static SQLHelper getInstancia() {
        if (instancia == null) {
            instancia = new SQLHelper();
        }
        return instancia;
    }

    public void shutdown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
    
    public Connection getConnection() {
        return connection;    
    }
    
    public boolean isConnectionClosed() throws SQLException {
        boolean tancada = false;
        
        if (connection != null) {
            tancada = connection.isClosed();
        }
        
        return tancada;
    }

    public Statement createStatement() throws SQLException {
        if ( connection.isClosed() ) {
            connection = getConnexio();
        }
        return connection.createStatement();
    }
    
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        if ( connection.isClosed() ) {
            connection = getConnexio();
        }
        return connection.prepareStatement(sql);
    }
    
    private Connection getConnexio() throws SQLException {
        if (connection == null)
            connection = DriverManager.getConnection(AppConstants.getConnexio());
        
        return connection;
    }
}