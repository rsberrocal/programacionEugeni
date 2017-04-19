/**
 * GNU General Public License <http://www.gnu.org/licenses/>
 *
 * CFGS Desenvolupament d'Aplicacions Multiplataforma Departament d'Informàtica
 * IES Eugeni d'Ors - Vilafranca del Penedès
 *
 * Curs 2016 - 2017
 *
 * Mòdul M7 - Desenvolupament d'Interfícies Pràctica:
 *
 * @author Rubén Nadal <rnadal27@xtec.cat>
 * @version 1.0
 *
 */

package informes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Patró Singleton
 * 
 * @author Rubén Nadal <rnadal27@xtec.cat>
 */

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