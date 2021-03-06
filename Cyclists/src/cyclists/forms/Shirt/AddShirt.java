/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyclists.forms.Shirt;

import cyclists.Database;
import cyclists.Entity.Cyclist;
import cyclists.Entity.Shirt;
import cyclists.forms.MainForm;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Richard
 */
public class AddShirt extends javax.swing.JFrame {

    /**
     * Creates new form AddCiclyst
     */
    public AddShirt() {
        initComponents();
        try {
            //Filling the ComboBox			
            Shirt s = new Shirt();
            s.loadTable(pTableCyclist);
        } catch (SQLException ex) {
            Logger.getLogger(AddShirt.class.getName()).log(Level.SEVERE, null, ex);
        }
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../../images/icon.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfReward = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btInsert = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfColor = new javax.swing.JTextField();
        pTableCyclist = new javax.swing.JPanel();
        tfType = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tfReward.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfRewardKeyTyped(evt);
            }
        });

        jLabel1.setText("Id");

        btInsert.setText("Insert");
        btInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsertActionPerformed(evt);
            }
        });

        jLabel2.setText("New Shirt");

        jLabel3.setText("Type");

        jLabel4.setText("Color");

        pTableCyclist.setMaximumSize(new java.awt.Dimension(32767, 234));

        javax.swing.GroupLayout pTableCyclistLayout = new javax.swing.GroupLayout(pTableCyclist);
        pTableCyclist.setLayout(pTableCyclistLayout);
        pTableCyclistLayout.setHorizontalGroup(
            pTableCyclistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );
        pTableCyclistLayout.setVerticalGroup(
            pTableCyclistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel5.setText("Reward");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btInsert)
                        .addGap(101, 101, 101))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfType, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfId, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfColor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(tfReward, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(pTableCyclist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pTableCyclist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tfType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfReward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(11, 11, 11)))
                .addComponent(btInsert)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsertActionPerformed
        // TODO add your handling code here:
        // tfAlerts
        if (tfColor.getText().isEmpty() && tfId.getText().isEmpty() && tfReward.getText().isEmpty()) {
            MainForm.alertsWarning(this, "", "Color, ID and Reward are missing");
            // putting focus on tfName
            tfId.requestFocus();
        } else if (tfColor.getText().isEmpty() && tfId.getText().isEmpty()) {
            MainForm.alertsWarning(this, "", "Color and ID are missing");
            // putting focus on tfName
            tfId.requestFocus();
        } else if (tfReward.getText().isEmpty() && tfColor.getText().isEmpty()) {
            MainForm.alertsWarning(this, "", "Reward and Color are missing");
            // putting focus on tfDorsal
            tfColor.requestFocus();
        } else if (tfReward.getText().isEmpty() && tfId.getText().isEmpty()) {
            MainForm.alertsWarning(this, "", "Reward and ID are missing");
            // putting focus on tfName
            tfId.requestFocus();
        } else if (tfId.getText().isEmpty()) {
            MainForm.alertsWarning(this, "", "ID missing");
            // putting focus on tfName
            tfId.requestFocus();
        } else if (tfColor.getText().isEmpty()) {
            MainForm.alertsWarning(this, "", "Color missing");
            // putting focus on tfDorsal
            tfColor.requestFocus();
        } else if (tfReward.getText().isEmpty()) {
            MainForm.alertsWarning(this, "", "Reward missing");

            // putting focus on tfAge
            tfReward.requestFocus();
            // End of tfAlerts
        } else {
            String color =tfColor.getText();
            String id = tfId.getText();
            int  reward = Integer.parseInt(tfReward.getText());
            String type = tfType.getText();
            
            Database db = new Database();
            try {
                if (db.searchID("codi", "Maillots", id)) {
                    MainForm.alertsWarning(this, "ID Duplicated", "ID Duplicated");
                    // putting focus on tfDorsal
                    tfId.requestFocus();
                } else {
                    // Insert
                    String sqlInsert = "INSERT INTO Maillots VALUES(?,?,?,?)";
                    //Connect
                    db.makeConnection();

                    PreparedStatement pst = db.getConnection().prepareStatement(sqlInsert);
                    pst.setString(1, id);
                    pst.setString(2, type);
                    pst.setString(3, color);
                    pst.setInt(4, reward);

                    pst.execute();
                    //Disconnect
                    db.closeConnection();
                    //End of Insert
                    //Information Message
                    MainForm.alertsInformation(this, "Row inserted", "Row inserted");
                    //The actual frame close
                    this.setVisible(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddShirt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btInsertActionPerformed


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);
//        this.rootPane.setEnabled(true);
//        this.rootPane.requestFocus();
    }//GEN-LAST:event_formWindowClosing

    private void consumeEvente(KeyEvent evt, JTextField tf) {
        char c = evt.getKeyChar();        
        if (((c < '0') || (c > '9')) && (c != '\b')) {
            evt.consume();
        }
    }

    private void tfRewardKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfRewardKeyTyped
        // TODO add your handling code here:
        consumeEvente(evt, tfReward);
    }//GEN-LAST:event_tfRewardKeyTyped

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
            java.util.logging.Logger.getLogger(AddShirt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddShirt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddShirt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddShirt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddShirt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btInsert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel pTableCyclist;
    private javax.swing.JTextField tfColor;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfReward;
    private javax.swing.JTextField tfType;
    // End of variables declaration//GEN-END:variables
}
