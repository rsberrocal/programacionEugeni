/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyclists.forms.Stage;

import cyclists.Database;
import cyclists.Entity.Ports;
import cyclists.Entity.Stage;
import cyclists.forms.MainForm;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Richard
 */
public class ModifyStage extends javax.swing.JFrame {

    /**
     * Creates new form AddCiclyst
     */
    public ModifyStage() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../../images/icon.png")));
        //Setting the global index for movement buttons
        index = 0;
        //Setting the Left buttons because we start with index ==0
        btTotalLeft.setEnabled(false);
        btLeft.setEnabled(false);
        cbDorsal.setEnabled(false);
        tfKM.setEnabled(false);
        tfStart.setEnabled(false);
        tfFinish.setEnabled(false);
        //Filling up the list with all the data from cyclist
        try {
            Stage s = new Stage();
            stageData = s.listStage();
            s.addItemsCombo(cbDorsal);
            s.loadTable(pTableStage);
        } catch (SQLException ex) {
            Logger.getLogger(ModifyStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Setting up the width and aligning the cell of the table
//        cellWidth();
//        alignCells();
        //Setting up the width and aligning the cell of the table
//        cellWidth();
//        alignCells();
    }
    //Own variables
    //Index to move the buttons
    public int index;
    //list with all the data from cyclist
    public List<Stage> stageData;
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

        btRight = new javax.swing.JButton();
        btTotalRight = new javax.swing.JButton();
        btLeft = new javax.swing.JButton();
        btTotalLeft = new javax.swing.JButton();
        btModify = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btSearch = new javax.swing.JButton();
        pTableStage = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbDorsal = new javax.swing.JComboBox<>();
        tfFinish = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfKM = new javax.swing.JTextField();
        tfStart = new javax.swing.JTextField();
        tfNum = new javax.swing.JTextField();

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

        btModify.setText("Modify");
        btModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModifyActionPerformed(evt);
            }
        });

        jLabel1.setText("Modify Stage");

        btSearch.setText("Search");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        pTableStage.setMaximumSize(new java.awt.Dimension(32767, 234));

        javax.swing.GroupLayout pTableStageLayout = new javax.swing.GroupLayout(pTableStage);
        pTableStage.setLayout(pTableStageLayout);
        pTableStageLayout.setHorizontalGroup(
            pTableStageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );
        pTableStageLayout.setVerticalGroup(
            pTableStageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel9.setText("Finish");

        jLabel2.setText("Num Stage");

        jLabel10.setText("Cyclist Dorsal");

        cbDorsal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        jLabel11.setText("Km");

        jLabel12.setText("Start");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfFinish, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                    .addComponent(tfStart)))
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfNum, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btSearch))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfKM, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbDorsal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btTotalLeft)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btModify)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btLeft)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btRight)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btTotalRight)))))
                        .addGap(18, 18, 18)
                        .addComponent(pTableStage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(tfKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(tfStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(35, 35, 35))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(cbDorsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tfFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btRight)
                            .addComponent(btLeft)
                            .addComponent(btTotalRight)
                            .addComponent(btTotalLeft)))
                    .addComponent(pTableStage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btModify)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void enableFields() {
        if (!tfKM.isEnabled() && !tfStart.isEnabled() && !tfFinish.isEnabled() && !cbDorsal.isEnabled()) {
            tfKM.setEnabled(true);
            tfStart.setEnabled(true);
            tfFinish.setEnabled(true);
            cbDorsal.setEnabled(true);
        }
    }

    private void consumeEvente(KeyEvent evt, JTextField tf, int max) {
        char c = evt.getKeyChar();
        if (tf.getText().length() > max) {
            evt.consume();
        }
        if (((c < '0') || (c > '9')) && (c != '\b')) {
            evt.consume();
        }
    }

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
        tfNum.setText(String.valueOf(stageData.get(index).getnStage()));
        tfKM.setText(String.valueOf(stageData.get(index).getKm()));
        tfStart.setText(stageData.get(index).getStart());
        tfFinish.setText(stageData.get(index).getStart());
        cbDorsal.setSelectedItem(stageData.get(index).getDorsal());
        //tfTeam.setText(stageData.get(index).getNomeq());
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
        if (index == stageData.size()) {
            btTotalRight.setEnabled(false);
            btRight.setEnabled(false);
        }
        enableFields();
    }//GEN-LAST:event_btRightActionPerformed

    private void btTotalRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTotalRightActionPerformed
        //Set the TextFields with all the data from the last cyclist                
        tfNum.setText(String.valueOf(stageData.get(stageData.size() - 1).getnStage()));
        tfKM.setText(String.valueOf(stageData.get(stageData.size() - 1).getKm()));
        tfStart.setText(stageData.get(stageData.size() - 1).getStart());
        tfFinish.setText(stageData.get(stageData.size() - 1).getStart());
        cbDorsal.setSelectedItem(stageData.get(stageData.size() - 1).getDorsal());

//        tfTeam.setText(stageData.get(stageData.size() - 1).getNomeq());
        //Set index to last position from the list
        index = stageData.size() - 1;
        //Disable right buttons because is the last cyclist
        btTotalRight.setEnabled(false);
        btRight.setEnabled(false);
        //Enable left buttons if they are disable
        if (!btTotalLeft.isEnabled() && !btLeft.isEnabled()) {
            btTotalLeft.setEnabled(true);
            btLeft.setEnabled(true);
        }
        enableFields();
    }//GEN-LAST:event_btTotalRightActionPerformed

    private void btLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLeftActionPerformed
        //If any other button was pressed before set index--
        if ((btRightPressed) && index != 1 && index != stageData.size() - 1) {
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
        tfNum.setText(String.valueOf(stageData.get(index).getnStage()));
        tfKM.setText(String.valueOf(stageData.get(index).getKm()));
        tfStart.setText(stageData.get(index).getStart());
        tfFinish.setText(stageData.get(index).getStart());
        cbDorsal.setSelectedItem(stageData.get(index).getDorsal());
        // tfTeam.setText(stageData.get(index).getNomeq());

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
        enableFields();
    }//GEN-LAST:event_btLeftActionPerformed

    private void btTotalLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTotalLeftActionPerformed
        //Set boolean true if this button wasn't pressed before
        if (!btTotalLeftPressed) {
            btTotalLeftPressed = true;
        }
        //Set the TextFields with all the data from the first cyclist
        tfNum.setText(String.valueOf(stageData.get(0).getnStage()));
        tfKM.setText(String.valueOf(stageData.get(0).getKm()));
        tfStart.setText(stageData.get(0).getStart());
        tfFinish.setText(stageData.get(0).getStart());
        cbDorsal.setSelectedItem(stageData.get(0).getDorsal());
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
        enableFields();
    }//GEN-LAST:event_btTotalLeftActionPerformed

    private void btModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModifyActionPerformed
        int oldNum = stageData.get(index).getnStage();
        // tfAlerts
        if (tfNum.getText().isEmpty() && tfKM.getText().isEmpty() && tfStart.getText().isEmpty() && tfFinish.getText().isEmpty()) {
            MainForm.alertsWarning(this, "All values missing", "Stage number, km, start and finish fields are missing");
            tfNum.requestFocus();
        } else if (tfNum.getText().isEmpty() && tfKM.getText().isEmpty() && tfStart.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Fields missing", "Stage number, km and start fields are missing");
            tfNum.requestFocus();
        } else if (tfNum.getText().isEmpty() && tfKM.getText().isEmpty() && tfFinish.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Fields missing", "Stage number, km and finish fields are missing");
            tfNum.requestFocus();
        } else if (tfNum.getText().isEmpty() && tfStart.getText().isEmpty() && tfFinish.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Fields missing", "Stage number, start and finish fields are missing");
            tfNum.requestFocus();
        } else if (tfKM.getText().isEmpty() && tfStart.getText().isEmpty() && tfFinish.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Fields missing", "Km, start and finish fields are missing");
        } else if (tfNum.getText().isEmpty() && tfStart.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Fields missing", "Stage number and finish fields are missing");
            tfNum.requestFocus();
        } else if (tfNum.getText().isEmpty() && tfKM.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Fields missing", "Stage number and km fields are missing");
            tfNum.requestFocus();
        } else if (tfNum.getText().isEmpty() && tfFinish.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Fields missing", "Stage number and finish fields are missing");
            tfNum.requestFocus();
        } else if (tfStart.getText().isEmpty() && tfNum.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Fields missing", "Start and stage number fields are missing");
            tfNum.requestFocus();
        } else if (tfStart.getText().isEmpty() && tfKM.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Fields missing", "Start and km fields are missing");
            tfKM.requestFocus();
        } else if (tfStart.getText().isEmpty() && tfFinish.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Fields missing", "Start and finish fields are missing");
            tfStart.requestFocus();
        } else if (tfKM.getText().isEmpty() && tfNum.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Fields missing", "Km and stage number fields are missing");
            tfNum.requestFocus();
        } else if (tfKM.getText().isEmpty() && tfStart.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Fields missing", "Km and start fields are missing");
            tfKM.requestFocus();
        } else if (tfKM.getText().isEmpty() && tfFinish.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Fields missing", "Km and finish fields are missing");
            tfKM.requestFocus();
        } else if (tfFinish.getText().isEmpty() && tfNum.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Fields missing", "Finish and stage number fields are missing");
            tfNum.requestFocus();
        } else if (tfFinish.getText().isEmpty() && tfStart.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Fields missing", "Finish and start fields are missing");
            tfStart.requestFocus();
        } else if (tfFinish.getText().isEmpty() && tfKM.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Fields missing", "Finish and km fields are missing");
            tfKM.requestFocus();
        } else if (tfNum.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Field missing", "stage number is missing");
            tfNum.requestFocus();
        } else if (tfKM.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Field missing", "Km is missing");
            tfKM.requestFocus();
        } else if (tfFinish.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Field missing", "Finish is missing");
            tfFinish.requestFocus();
        } else if (tfStart.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Field missing", "Start is missing");
            tfStart.requestFocus();
        } else {
            StringBuilder sqlUpdate = new StringBuilder();;
            sqlUpdate.append("update Etapes set ");
            sqlUpdate.append("netapa = ? ,");
            sqlUpdate.append("km = ? ,");
            sqlUpdate.append("sortida = ? ,");
            sqlUpdate.append("arribada = ? ,");
            sqlUpdate.append("dorsal = ? ");
            sqlUpdate.append("where netapa = ? ;");

            Database db = new Database();
            try {
                //Connect
                db.makeConnection();

                PreparedStatement pst = db.getConnection().prepareStatement(sqlUpdate.toString());
                pst.setInt(1, Integer.parseInt(tfNum.getText()));
                pst.setInt(2, Integer.parseInt(tfKM.getText()));
                pst.setString(3, tfStart.getText());
                pst.setString(4, tfFinish.getText());
                pst.setInt(5, Integer.parseInt(cbDorsal.getSelectedItem().toString()));
                pst.setInt(6, oldNum);
                String n = pst.toString();
                pst.execute();

                //Disconnect
                db.closeConnection();
                MainForm.alertsInformation(this, "Row Modified", "Row Modified");
            } catch (SQLException ex) {
                Logger.getLogger(ModifyStage.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
        }
    }//GEN-LAST:event_btModifyActionPerformed

    private void searchStage(String name) {
        //Adding % to search any cyclist with this text
        name = name + "%";
        //Querys
        //Query to know how many cyclist we got with the same name
        String queryCount = "select count(*) from Etapes where netapa like '" + name + "';";
        //Query to know these names if we got more than 1 cyclist with the same name
        String queryNames = "select netapa from Etapes where netapa like '" + name + "';";

        Database db = new Database();
        //If the TextField name is empty, it opens a dialog that inform the user
        if (tfNum.getText().isEmpty()) {
            MainForm.alertsWarning(this, "Number Missing", "Number Missing");
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
                        String input = (String) JOptionPane.showInputDialog(null, "Choose Stage",
                                "Select a Stage", JOptionPane.INFORMATION_MESSAGE, null,
                                names, // Array with names
                                names[0]); // Default choise
                        ;//End dialog
                        //Query to get the data of cyclist choosed
                        String queryFinal = "select km,sortida,arribada,dorsal from Etapes where netapa like '" + input + "';";
                        //Start the query
                        Statement stFinal = db.getConnection().createStatement();
                        ResultSet rsFinal = stFinal.executeQuery(queryFinal);
                        //Setting up the TextFields with all the data of this cyclist
                        while (rsFinal.next()) {//Loop
                            tfKM.setText(String.valueOf(rsFinal.getInt(1)));
                            tfStart.setText(rsFinal.getString(2));
                            tfFinish.setText(rsFinal.getString(3));
                            cbDorsal.setSelectedItem(String.valueOf(rsFinal.getInt(4)));
                        }//End loop
                        //Finally set the name of this cyclist
                        tfNum.setText(input);
                        //If this cyclist doesn't exists
                    } else if (rsCount.getInt(1) == 0) {
                        //Create a new dialog informing the use that this Cyclist doesnt exist
                        MainForm.alertsInformation(this, "Stage doesn't exists", "Stage doesn't exists");
                        //If there is only 1 cyclist with this name
                    } else {
                        //Query to know all the data about this cyclist
                        String queryFinal = "select netapa,km,sortida,arribada,dorsal from Etapes where netapa like '" + name + "';";
                        //Start the query
                        Statement stFinal = db.getConnection().createStatement();
                        ResultSet rsFinal = stFinal.executeQuery(queryFinal);
                        //Setting up the TextFields with all the data of this cyclist
                        while (rsFinal.next()) {
                            tfNum.setText(rsFinal.getString(1));
                            tfKM.setText(String.valueOf(rsFinal.getInt(2)));
                            tfStart.setText(rsFinal.getString(3));
                            tfFinish.setText(rsFinal.getString(4));
                            cbDorsal.setSelectedItem(String.valueOf(rsFinal.getInt(5)));
                        }
                    }
                }
                //Set the index == 0 to search exactly the index of this cyclist
                index = 0;
                //index = stageData.indexOf(tfDorsal.getText());
                for (int j = 0; j < stageData.size(); j++) {//Loop index
                    //If dorsal of cyclist(j) is equals to the text of dorsal TextField
                    if (stageData.get(j).getnStage() == Integer.parseInt(tfNum.getText())) {
                        //If is the last position, set index to the last position
                        if (j == stageData.size()) {
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
                Logger.getLogger(ModifyStage.class.getName()).log(Level.SEVERE, null, ex);
            }
            //If index == 0 disable the left buttons and enable the right buttons
            if (index == 0) {
                btTotalLeft.setEnabled(false);
                btLeft.setEnabled(false);
                btTotalRight.setEnabled(true);
                btRight.setEnabled(true);
                //If index == 0 disable the right buttons and enable the left buttons
            } else if (index == stageData.size() - 1) {
                btTotalLeft.setEnabled(true);
                btLeft.setEnabled(true);
                btTotalRight.setEnabled(false);
                btRight.setEnabled(false);
                //If index is between 0 and stageData.size enable all the buttons
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
            enableFields();
        }
    }//End function

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        //Calling the function search to search the cyclist that the user put on the TextField name
        searchStage(tfNum.getText());
    }//GEN-LAST:event_btSearchActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(ModifyStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyStage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new ModifyStage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLeft;
    private javax.swing.JButton btModify;
    private javax.swing.JButton btRight;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btTotalLeft;
    private javax.swing.JButton btTotalRight;
    private javax.swing.JComboBox<String> cbDorsal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pTableStage;
    private javax.swing.JTextField tfFinish;
    private javax.swing.JTextField tfKM;
    private javax.swing.JTextField tfNum;
    private javax.swing.JTextField tfStart;
    // End of variables declaration//GEN-END:variables
}
