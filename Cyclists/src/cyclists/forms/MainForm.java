/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyclists.forms;

import cyclists.forms.Ciclyst.AddCiclyst;
import cyclists.forms.Ciclyst.DeleteCiclyst;
import cyclists.forms.Ciclyst.ModifyCiclyst;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author infot
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icon.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        lBackground = new javax.swing.JLabel();
        mbMain = new javax.swing.JMenuBar();
        mEquips = new javax.swing.JMenu();
        miAddEquips = new javax.swing.JMenuItem();
        miModifyEquips = new javax.swing.JMenuItem();
        miDeleteEquips = new javax.swing.JMenuItem();
        mCiclistes = new javax.swing.JMenu();
        miAddCiclistes = new javax.swing.JMenuItem();
        miModifyCiclistes = new javax.swing.JMenuItem();
        miDeleteCiclistes = new javax.swing.JMenuItem();
        mLlevar = new javax.swing.JMenu();
        miAdd2Lllevar = new javax.swing.JMenuItem();
        miModifyLllevar = new javax.swing.JMenuItem();
        miDeleteLllevar = new javax.swing.JMenuItem();
        mMaillots = new javax.swing.JMenu();
        miAddMaillots = new javax.swing.JMenuItem();
        miModifyMaillots = new javax.swing.JMenuItem();
        miDeleteMaillots = new javax.swing.JMenuItem();
        mPorts = new javax.swing.JMenu();
        miAddPorts = new javax.swing.JMenuItem();
        miModifyPorts = new javax.swing.JMenuItem();
        miDeletePorts = new javax.swing.JMenuItem();
        mEtapes = new javax.swing.JMenu();
        miAddEtapes = new javax.swing.JMenuItem();
        miModifyEtapes = new javax.swing.JMenuItem();
        miDeleteEtapes = new javax.swing.JMenuItem();
        mExit = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconImages(null);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.jpg"))); // NOI18N

        mEquips.setText("Equips");

        miAddEquips.setText("Add");
        mEquips.add(miAddEquips);

        miModifyEquips.setText("Modify");
        mEquips.add(miModifyEquips);

        miDeleteEquips.setText("Delete");
        mEquips.add(miDeleteEquips);

        mbMain.add(mEquips);

        mCiclistes.setText("Ciclistes");

        miAddCiclistes.setText("Add");
        miAddCiclistes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddCiclistesActionPerformed(evt);
            }
        });
        mCiclistes.add(miAddCiclistes);

        miModifyCiclistes.setText("Modify");
        miModifyCiclistes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miModifyCiclistesActionPerformed(evt);
            }
        });
        mCiclistes.add(miModifyCiclistes);

        miDeleteCiclistes.setText("Delete");
        miDeleteCiclistes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDeleteCiclistesActionPerformed(evt);
            }
        });
        mCiclistes.add(miDeleteCiclistes);

        mbMain.add(mCiclistes);

        mLlevar.setText("Llevar");

        miAdd2Lllevar.setText("Add");
        mLlevar.add(miAdd2Lllevar);

        miModifyLllevar.setText("Modify");
        mLlevar.add(miModifyLllevar);

        miDeleteLllevar.setText("Delete");
        mLlevar.add(miDeleteLllevar);

        mbMain.add(mLlevar);

        mMaillots.setText("Maillots");

        miAddMaillots.setText("Add");
        mMaillots.add(miAddMaillots);

        miModifyMaillots.setText("Modify");
        mMaillots.add(miModifyMaillots);

        miDeleteMaillots.setText("Delete");
        mMaillots.add(miDeleteMaillots);

        mbMain.add(mMaillots);

        mPorts.setText("Ports");

        miAddPorts.setText("Add");
        mPorts.add(miAddPorts);

        miModifyPorts.setText("Modify");
        mPorts.add(miModifyPorts);

        miDeletePorts.setText("Delete");
        mPorts.add(miDeletePorts);

        mbMain.add(mPorts);

        mEtapes.setText("Etapes");

        miAddEtapes.setText("Add");
        mEtapes.add(miAddEtapes);

        miModifyEtapes.setText("Modify");
        mEtapes.add(miModifyEtapes);

        miDeleteEtapes.setText("Delete");
        mEtapes.add(miDeleteEtapes);

        mbMain.add(mEtapes);

        mExit.setText("Exit");
        mExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mExitMousePressed(evt);
            }
        });
        mbMain.add(mExit);

        setJMenuBar(mbMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lBackground)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lBackground)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Function for create Alerts with Warning icon
    public static void alertsWarning(JFrame jf, String title, String message) {
        JOptionPane.showMessageDialog(jf, message, title, JOptionPane.WARNING_MESSAGE);
    }

    //Function for create Alerts with Information icon
    public static void alertsInformation(JFrame jf, String title, String message) {
        JOptionPane.showMessageDialog(jf, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private void miAddCiclistesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddCiclistesActionPerformed
        // TODO add your handling code here:
        AddCiclyst ac = new AddCiclyst();
        ac.setTitle("Add Cyclist");
        ac.setLocationRelativeTo(null);
        ac.setVisible(true);

        //this.setEnabled(false);
    }//GEN-LAST:event_miAddCiclistesActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        exitDialog();
    }//GEN-LAST:event_formWindowClosing

    private void miDeleteCiclistesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDeleteCiclistesActionPerformed
        DeleteCiclyst dc = new DeleteCiclyst();
        dc.setTitle("Delete Cyclist");
        dc.setLocationRelativeTo(null);
        dc.setVisible(true);
        //this.setEnabled(false);
    }//GEN-LAST:event_miDeleteCiclistesActionPerformed

    public void exitDialog() {
        if (JOptionPane.showConfirmDialog(this,
                "Are you sure to close this window?", "Really Closing?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void mExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mExitMousePressed
        // TODO add your handling code here:
        exitDialog();
    }//GEN-LAST:event_mExitMousePressed

    private void miModifyCiclistesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miModifyCiclistesActionPerformed
        ModifyCiclyst mc = new ModifyCiclyst();
        mc.setTitle("Modify Cyclist");
        mc.setLocationRelativeTo(null);
        mc.setVisible(true);
    }//GEN-LAST:event_miModifyCiclistesActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel lBackground;
    private javax.swing.JMenu mCiclistes;
    private javax.swing.JMenu mEquips;
    private javax.swing.JMenu mEtapes;
    private javax.swing.JMenu mExit;
    private javax.swing.JMenu mLlevar;
    private javax.swing.JMenu mMaillots;
    private javax.swing.JMenu mPorts;
    private javax.swing.JMenuBar mbMain;
    private javax.swing.JMenuItem miAdd2Lllevar;
    private javax.swing.JMenuItem miAddCiclistes;
    private javax.swing.JMenuItem miAddEquips;
    private javax.swing.JMenuItem miAddEtapes;
    private javax.swing.JMenuItem miAddMaillots;
    private javax.swing.JMenuItem miAddPorts;
    private javax.swing.JMenuItem miDeleteCiclistes;
    private javax.swing.JMenuItem miDeleteEquips;
    private javax.swing.JMenuItem miDeleteEtapes;
    private javax.swing.JMenuItem miDeleteLllevar;
    private javax.swing.JMenuItem miDeleteMaillots;
    private javax.swing.JMenuItem miDeletePorts;
    private javax.swing.JMenuItem miModifyCiclistes;
    private javax.swing.JMenuItem miModifyEquips;
    private javax.swing.JMenuItem miModifyEtapes;
    private javax.swing.JMenuItem miModifyLllevar;
    private javax.swing.JMenuItem miModifyMaillots;
    private javax.swing.JMenuItem miModifyPorts;
    // End of variables declaration//GEN-END:variables

}
