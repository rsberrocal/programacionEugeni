/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyclists.forms.Shirt;

import cyclists.forms.Ciclyst.*;
import cyclists.Database;
import cyclists.Entity.Cyclist;
import cyclists.forms.MainForm;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Richard
 */
public final class DeleteShirt extends javax.swing.JFrame {

    /**
     * Creates new form AddCiclyst
     */
    public DeleteShirt() {
        initComponents();
        //Setting the global index for movement buttons
        index = 0;
        //Setting TextField not enable so the user can't edit the cyclist
        tfDorsal.setEnabled(false);
        tfAge.setEnabled(false);
        tfTeam.setEnabled(false);
        //Putting up the icon image
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../../images/icon.png")));
        //Setting the Left buttons because we start with index ==0
        btTotalLeft.setEnabled(false);
        btLeft.setEnabled(false);
        //Filling up the list with all the data from cyclist
        try {
            cyclistData = cyclist();
            Cyclist c = new Cyclist();
            c.loadTable(pTableCyclist);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteShirt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Own variables
    //Index to move the buttons
    public int index;
    //list with all the data from cyclist
    public List<Cyclist> cyclistData;
    //Booleans for movement buttons
    public boolean btRightPressed = false;
    public boolean btLeftPressed = false;
    public boolean btTotalLeftPressed = false;
    public boolean btSearchPressed = false;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfAge = new javax.swing.JTextField();
        tfDorsal = new javax.swing.JTextField();
        btRight = new javax.swing.JButton();
        btTotalRight = new javax.swing.JButton();
        btLeft = new javax.swing.JButton();
        btTotalLeft = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfTeam = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pTableCyclist = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btRight.setText(">");
        btRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRightActionPerformed(evt);
            }
        });

        btTotalRight.setText(">>");
        btTotalRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTotalRightActionPerformed(evt);
            }
        });

        btLeft.setText("<");
        btLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLeftActionPerformed(evt);
            }
        });

        btTotalLeft.setText("<<");
        btTotalLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTotalLeftActionPerformed(evt);
            }
        });

        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Delete Ciclyst");

        jLabel2.setText("Name");

        btSearch.setText("Search");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        jLabel3.setText("Team");

        jLabel4.setText("Dorsal");

        jLabel5.setText("Age");

        pTableCyclist.setMaximumSize(new java.awt.Dimension(32767, 234));

        javax.swing.GroupLayout pTableCyclistLayout = new javax.swing.GroupLayout(pTableCyclist);
        pTableCyclist.setLayout(pTableCyclistLayout);
        pTableCyclistLayout.setHorizontalGroup(
            pTableCyclistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );
        pTableCyclistLayout.setVerticalGroup(
            pTableCyclistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btTotalLeft)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btLeft)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btRight))
                                            .addComponent(btDelete))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btTotalRight)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfDorsal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(13, 154, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfName, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                        .addGap(12, 12, 12)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btSearch)
                                    .addComponent(jLabel5)
                                    .addComponent(tfAge, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(pTableCyclist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pTableCyclist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDorsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btRight)
                            .addComponent(btLeft)
                            .addComponent(btTotalRight)
                            .addComponent(btTotalLeft))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btDelete)
                        .addGap(0, 44, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Functions to fill the list of cyclist
    public List cyclist() throws SQLException {
        List<Cyclist> l = new ArrayList<Cyclist>();
        //Query
        String query = "select dorsal,nom,edad,nomeq from Ciclistes;";
        Database db = new Database();
        //Connect
        db.makeConnection();

        Statement st = db.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {//loop rs
            Cyclist c = new Cyclist();
            c.setDorsal(rs.getInt(1));
            c.setNom(rs.getString(2));
            c.setEdad(rs.getInt(3));
            c.setNomeq(rs.getString(4));
            l.add(c);
        }//end loop rs
        //Disconnect
        db.closeConnection();
        return l;
    }

    //Function to search a cyclist
    private void searchCyclist(String name) {
        //Adding % to search any cyclist with this text
        name = name + "%";
        //Querys
        //Query to know how many cyclist we got with the same name
        String queryCount = "select count(*) from Ciclistes where nom like '" + name + "';";
        //Query to know these names if we got more than 1 cyclist with the same name
        String queryNames = "select nom from Ciclistes where nom like '" + name + "';";

        Database db = new Database();
        //If the TextField name is empty, it opens a dialog that inform the user
        if (tfName.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Name Missing", "Name Missing");
        } else {
            try {
                //Connect
                db.makeConnection();
                //Start the query
                Statement stCount = db.getConnection().createStatement();
                ResultSet rsCount = stCount.executeQuery(queryCount);
                //See if we can put IF and not WHILE
                while (rsCount.next()) {//Loop Count
                    //If we got more than 1 cyclist with the same name
                    if (rsCount.getInt(1) > 1) {
                        //Start the query to get these names
                        Statement stName = db.getConnection().createStatement();
                        ResultSet rsName = stName.executeQuery(queryNames);
                        //Array to save the names
                        String[] names = new String[rsCount.getInt(1)];
                        //index to navigate this array
                        int i = 0;
                        while (rsName.next()) {//Loop names to save the names on the array
                            names[i] = rsName.getString(1);
                            i++;
                        }//End loop names
                        //Create a new dialog to make the user chose one of the names below
                        String input = (String) JOptionPane.showInputDialog(null, "Choose Cyclist Team",
                                "Select a Team", JOptionPane.INFORMATION_MESSAGE, null,
                                names, // Array with names
                                names[0]); // Default choise
                        ;//End dialog
                        //Query to get the data of cyclist choosed
                        String queryFinal = "select dorsal,edad,nomeq from Ciclistes where nom like '" + input + "';";
                        //Start the query
                        Statement stFinal = db.getConnection().createStatement();
                        ResultSet rsFinal = stFinal.executeQuery(queryFinal);
                        //Setting up the TextFields with all the data of this cyclist
                        while (rsFinal.next()) {//Loop
                            tfDorsal.setText(String.valueOf(rsFinal.getInt(1)));
                            tfAge.setText(String.valueOf(rsFinal.getInt(2)));
                            tfTeam.setText(rsFinal.getString(3));
                        }//End loop
                        //Finally set the name of this cyclist
                        tfName.setText(input);
                        //If this cyclist doesn't exists
                    } else if (rsCount.getInt(1) == 0) {
                        //Create a new dialog informing the use that this Cyclist doesnt exist
                        MainForm.alertsInformation(this, "Cyclist doesn't exists", "Cyclist doesn't exists");
                        //If there is only 1 cyclist with this name
                    } else {
                        //Query to know all the data about this cyclist
                        String queryFinal = "select dorsal,edad,nomeq,nom from Ciclistes where nom like '" + name + "';";
                        //Start the query
                        Statement stFinal = db.getConnection().createStatement();
                        ResultSet rsFinal = stFinal.executeQuery(queryFinal);
                        //Setting up the TextFields with all the data of this cyclist
                        while (rsFinal.next()) {
                            tfDorsal.setText(String.valueOf(rsFinal.getInt(1)));
                            tfAge.setText(String.valueOf(rsFinal.getInt(2)));
                            tfTeam.setText(rsFinal.getString(3));
                            tfName.setText(rsFinal.getString(4));
                        }
                    }
                }
                //Set the index == 0 to search exactly the index of this cyclist
                index = 0;
                //index = cyclistData.indexOf(tfDorsal.getText());
                for (int j = 0; j < cyclistData.size(); j++) {//Loop index
                    //If dorsal of cyclist(j) is equals to the text of dorsal TextField
                    if (cyclistData.get(j).getDorsal() == Integer.parseInt(tfDorsal.getText())) {
                        //If is the last position, set index to the last position
                        if (j == cyclistData.size()) {
                            index = j - 1;
                        } else {
                            //else set index to j
                            index = j;
                        }
                    }
                }//End loop
                //Disconnect
                db.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DeleteShirt.class.getName()).log(Level.SEVERE, null, ex);
            }
            //If index == 0 disable the left buttons and enable the right buttons
            if (index == 0) {
                btTotalLeft.setEnabled(false);
                btLeft.setEnabled(false);
                btTotalRight.setEnabled(true);
                btRight.setEnabled(true);
                //If index == 0 disable the right buttons and enable the left buttons
            } else if (index == cyclistData.size() - 1) {
                btTotalLeft.setEnabled(true);
                btLeft.setEnabled(true);
                btTotalRight.setEnabled(false);
                btRight.setEnabled(false);
                //If index is between 0 and cyclistData.size enable all the buttons
            } else {
                btTotalLeft.setEnabled(true);
                btLeft.setEnabled(true);
                btTotalRight.setEnabled(true);
                btRight.setEnabled(true);
            }
            //Finally set true the boolean btSearchPressed to know that this buttons has been pressed
            btSearchPressed = true;
            //And set false the rest of booleans
            btLeftPressed = false;
            btRightPressed = false;
            btTotalLeftPressed = false;
        }
    }//End function

    //Button search action
    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        //Calling the function search to search the cyclist that the user put on the TextField name
        searchCyclist(tfName.getText());
    }//GEN-LAST:event_btSearchActionPerformed

    //Closing window action
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //JFrame topFrame = (JFrame) SwingUtilities.getRoot(this);
        //topFrame.setEnabled(true);
        //Closing the actual frame
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    //Button delete action
    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        //Statement to delete the cyclist
        String sqlDelete = "delete from Ciclistes where nom like '" + tfName.getText() + "';";
        Database db = new Database();
        int i = 0;
        //If TextField name is empty
        if (tfName.getText().isEmpty()) {
            //Create a dialog informing the user that this field is empty
            MainForm.alertsWarning(this, "Name missing", "Name missing");
        } else {
            //If not is empty create a dialog to know if the user really wants to delete this cyclist
            try {
                if (db.searchID("dorsal", "Llevar", Integer.parseInt(tfDorsal.getText())) || db.searchID("dorsal", "Ports", Integer.parseInt(tfDorsal.getText())) || db.searchID("dorsal", "Etapes", Integer.parseInt(tfDorsal.getText()))) {
                    MainForm.alertsWarning(this, "Error", "Error you cant delete this cyclist because depends with other table");
                } else if (JOptionPane.showConfirmDialog(this,
                        "Are you sure to delete " + tfName.getText() + "?", "Delete",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    //If the result is yes delete this cyclist

                    //Connect
                    db.makeConnection();
                    //Start the Statement
                    PreparedStatement pst = db.getConnection().prepareStatement(sqlDelete);
                    pst.execute();
                    //Disconnect
                    db.closeConnection();
                    //Information Message
                    MainForm.alertsInformation(this, "Row deleted", "Row deleted");
                    //The actual frame close
                    this.setVisible(false);

                }
            } catch (SQLException ex) {
                Logger.getLogger(DeleteShirt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btDeleteActionPerformed
    //End action

    //Button right action >
    private void btRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRightActionPerformed
        // TODO add your handling code here:
        //If any other button was pressed before set index++
        if (btLeftPressed || btSearchPressed || btTotalLeftPressed) {
            index++;
            btLeftPressed = false;
            btTotalLeftPressed = false;
            btSearchPressed = false;
        }
        //If index is less than 0 set index == 0
        if (index < 0) {
            index = 0;
        }
        //Set the TextField with the data of cyclist(index)
        tfName.setText(cyclistData.get(index).getNom());
        tfDorsal.setText(String.valueOf(cyclistData.get(index).getDorsal()));
        tfAge.setText(String.valueOf(cyclistData.get(index).getEdad()));
        tfTeam.setText(cyclistData.get(index).getNomeq());
        //Index increase
        index++;
        //If this button boolean wasn't pressed
        if (!btRightPressed) {
            btRightPressed = true;
        }
        //Enable left buttons if they are disabled
        if (!btTotalLeft.isEnabled() && !btLeft.isEnabled()) {
            btTotalLeft.setEnabled(true);
            btLeft.setEnabled(true);
        }
        //Disable right buttons if index is equals to last position from the list
        if (index == cyclistData.size()) {
            btTotalRight.setEnabled(false);
            btRight.setEnabled(false);
        }
    }//GEN-LAST:event_btRightActionPerformed
    //End action

    //Button right action >>
    private void btTotalRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTotalRightActionPerformed
        //Set the TextFields with all the data from the last cyclist
        tfName.setText(cyclistData.get(cyclistData.size() - 1).getNom());
        tfDorsal.setText(String.valueOf(cyclistData.get(cyclistData.size() - 1).getDorsal()));
        tfAge.setText(String.valueOf(cyclistData.get(cyclistData.size() - 1).getEdad()));
        tfTeam.setText(cyclistData.get(cyclistData.size() - 1).getNomeq());
        //Set index to last position from the list
        index = cyclistData.size() - 1;
        //Disable right buttons because is the last cyclist
        btTotalRight.setEnabled(false);
        btRight.setEnabled(false);
        //Enable left buttons if they are disable
        if (!btTotalLeft.isEnabled() && !btLeft.isEnabled()) {
            btTotalLeft.setEnabled(true);
            btLeft.setEnabled(true);
        }
    }//GEN-LAST:event_btTotalRightActionPerformed
    //End action

    //Button left action <
    private void btLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLeftActionPerformed
        //If any other button was pressed before set index--
        if ((btRightPressed) && index != 1 && index != cyclistData.size() - 1) {
            index--;
            btRightPressed = false;
        }
        //Set boolean true if this button wasn't pressed before
        if (!btLeftPressed) {
            btLeftPressed = true;
        }
        //Set index ==0 if this index is less than 0
        if (index < 0) {
            index = 0;
        } else {
            //Else reduce index
            index--;
        }
        //Set the TextField with the data of cyclist(index)
        tfName.setText(cyclistData.get(index).getNom());
        tfDorsal.setText(String.valueOf(cyclistData.get(index).getDorsal()));
        tfAge.setText(String.valueOf(cyclistData.get(index).getEdad()));
        tfTeam.setText(cyclistData.get(index).getNomeq());

        //Enable right buttons if they are disabled
        if (!btTotalRight.isEnabled() && !btRight.isEnabled()) {
            btTotalRight.setEnabled(true);
            btRight.setEnabled(true);
        }
        //Disable left buttons if index is the first cyclist
        if (index == 0) {
            btTotalLeft.setEnabled(false);
            btLeft.setEnabled(false);
        }
    }//GEN-LAST:event_btLeftActionPerformed
    //End action

    //Button left action <<
    private void btTotalLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTotalLeftActionPerformed
        //Set boolean true if this button wasn't pressed before
        if (!btTotalLeftPressed) {
            btTotalLeftPressed = true;
        }
        //Set the TextFields with all the data from the first cyclist
        tfName.setText(cyclistData.get(0).getNom());
        tfDorsal.setText(String.valueOf(cyclistData.get(0).getDorsal()));
        tfAge.setText(String.valueOf(cyclistData.get(0).getEdad()));
        tfTeam.setText(cyclistData.get(0).getNomeq());
        //Set index to 0 because is the first cyclist
        index = 0;
        //Disable left buttons because is the first cyclist
        btTotalLeft.setEnabled(false);
        btLeft.setEnabled(false);
        //Enable left buttons if they are disable
        if (!btTotalRight.isEnabled() && !btRight.isEnabled()) {
            btTotalRight.setEnabled(true);
            btRight.setEnabled(true);
        }
    }//GEN-LAST:event_btTotalLeftActionPerformed
    //End action
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeleteShirt.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteShirt.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteShirt.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteShirt.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteShirt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btLeft;
    private javax.swing.JButton btRight;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btTotalLeft;
    private javax.swing.JButton btTotalRight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel pTableCyclist;
    private javax.swing.JTextField tfAge;
    private javax.swing.JTextField tfDorsal;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfTeam;
    // End of variables declaration//GEN-END:variables
}
