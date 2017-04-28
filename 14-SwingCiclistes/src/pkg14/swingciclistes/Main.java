/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg14.swingciclistes;

import java.io.IOException;
import pkg14.swingciclistes.Forms.MainForm;


/**
 *
 * @author infot
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");        
        MainForm mf = new MainForm();
        // Posem el Frame al mig de la pantalla
        mf.setLocationRelativeTo(null);
        mf.setVisible(true);
    }
    
}
