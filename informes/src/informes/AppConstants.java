/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informes;

/**
 *
 * @author infot
 */
public final class AppConstants {

    private static final String DB_PORT = "3306";
    private static final String DB_DRIVER = "jdbc:mariadb://";
    private static final String DB_HOST = "mestral.ddns.net";
    private static final String DB_NAME = "rsudario_gproductes";
    private static final String DB_USER = "rsudario";
    private static final String DB_PASSWD = "rsudario";

    public static String getConnexio() {
        StringBuilder sb = new StringBuilder();
        sb.append(DB_DRIVER).append(DB_HOST + ":" + DB_PORT);
        sb.append("/").append(DB_NAME);
        sb.append("?user=").append(DB_USER);
        sb.append("&password=").append(DB_PASSWD);

        return sb.toString();
    }

    public static String getDB_PORT() {
        return DB_PORT;
    }

    public static String getDB_HOST() {
        return DB_HOST;
    }

    public static String getDB_NAME() {
        return DB_NAME;
    }

    public static String getDB_USER() {
        return DB_USER;
    }
}
