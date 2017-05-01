/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyclists;

import cyclists.forms.MainForm;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
        //mf.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        mf.setTitle("Ciclysts");
        // Center the Main Frame               
        mf.setLocationRelativeTo(null);
        mf.setVisible(true);
    }

}
