/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenrichard;

import examenrichard.Forms.MainForm;

/**
 *
 * @author infot
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        //MariaDB driver
        Class.forName("org.mariadb.jdbc.Driver");
        MainForm mf = new MainForm();
        //Set the title to the main frame
        mf.setTitle("Caps de departament");
        // Center the Main Frame               
        mf.setLocationRelativeTo(null);
        mf.setVisible(true);
    }

}
