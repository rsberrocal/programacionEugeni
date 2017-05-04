/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyclists.forms.Ciclyst;

import cyclists.Database;
import cyclists.forms.MainForm;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Richard
 */
public class AddCiclyst extends javax.swing.JFrame {

    /**
     * Creates new form AddCiclyst
     */
    public AddCiclyst() {
        initComponents();
        try {
            //Filling the ComboBox
            addItemsCombo();
        } catch (SQLException ex) {
            Logger.getLogger(AddCiclyst.class.getName()).log(Level.SEVERE, null, ex);
        }
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../../images/icon.png")));
        cellWidth();
        alignCells();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("rsudario_gproductes?user=rsudario&password=rsudarioPU").createEntityManager();
        ciclistesQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Ciclistes c");
        ciclistesList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : ciclistesQuery.getResultList();
        ciclistesQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Ciclistes c");
        ciclistesList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : ciclistesQuery1.getResultList();
        ciclistesQuery2 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Ciclistes c");
        ciclistesList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : ciclistesQuery2.getResultList();
        tfAge = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btInsert = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbTeams = new javax.swing.JComboBox<>();
        tfDorsal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCiclyst = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Name");

        btInsert.setText("Insert");
        btInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsertActionPerformed(evt);
            }
        });

        jLabel2.setText("New Ciclyst");

        jLabel3.setText("Teams");

        jLabel4.setText("Dorsal");

        jLabel5.setText("Age");

        cbTeams.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, ciclistesList2, tbCiclyst);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dorsal}"));
        columnBinding.setColumnName("Dorsal");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nom}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${edad}"));
        columnBinding.setColumnName("Age");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomeq}"));
        columnBinding.setColumnName("Team");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tbCiclyst);
        if (tbCiclyst.getColumnModel().getColumnCount() > 0) {
            tbCiclyst.getColumnModel().getColumn(0).setResizable(false);
            tbCiclyst.getColumnModel().getColumn(1).setResizable(false);
            tbCiclyst.getColumnModel().getColumn(2).setResizable(false);
            tbCiclyst.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(tfDorsal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfAge, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btInsert)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbTeams, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cbTeams, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDorsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btInsert)
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void cellWidth() {
        tbCiclyst.getColumnModel().getColumn(0).setPreferredWidth(15);
        tbCiclyst.getColumnModel().getColumn(1).setPreferredWidth(90);
        tbCiclyst.getColumnModel().getColumn(2).setPreferredWidth(10);
        tbCiclyst.getColumnModel().getColumn(3).setPreferredWidth(60);
    }

    public void alignCells() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tbCiclyst.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tbCiclyst.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
    }

    //Function for set items on ComboBox
    public void addItemsCombo() throws SQLException {
        //Query
        String query = "select nomeq from Equips;";
        Database db = new Database();
        //Connect
        db.makeConnection();
        try (
                Statement st = db.getConnection().createStatement();
                ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                cbTeams.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        //Disconnect
        db.closeConnection();
    }

    private void btInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsertActionPerformed
        // TODO add your handling code here:
        // tfAlerts
        if (tfDorsal.getText().isEmpty() && tfName.getText().isEmpty() && tfAge.getText().isEmpty()) {
            MainForm.alertsWarning(this, "", "Name, Dorsal and Age are missing");
            // putting focus on tfName
            tfName.requestFocus();
        } else if (tfDorsal.getText().isEmpty() && tfName.getText().isEmpty()) {
            MainForm.alertsWarning(this, "", "Name and Dorsal are missing");
            // putting focus on tfName
            tfName.requestFocus();
        } else if (tfAge.getText().isEmpty() && tfDorsal.getText().isEmpty()) {
            MainForm.alertsWarning(this, "", "Age and Dorsal are missing");
            // putting focus on tfDorsal
            tfDorsal.requestFocus();
        } else if (tfAge.getText().isEmpty() && tfName.getText().isEmpty()) {
            MainForm.alertsWarning(this, "", "Age and Name are missing");
            // putting focus on tfName
            tfName.requestFocus();
        } else if (tfName.getText().isEmpty()) {
            MainForm.alertsWarning(this, "", "Name missing");
            // putting focus on tfName
            tfName.requestFocus();
        } else if (tfDorsal.getText().isEmpty()) {
            MainForm.alertsWarning(this, "", "Dorsal missing");
            // putting focus on tfDorsal
            tfDorsal.requestFocus();
        } else if (tfAge.getText().isEmpty()) {
            MainForm.alertsWarning(this, "", "Age missing");

            // putting focus on tfAge
            tfAge.requestFocus();
            // End of tfAlerts
        } else {
            int dorsal = Integer.parseInt(tfDorsal.getText());
            String name = tfName.getText();
            int age = Integer.parseInt(tfAge.getText());
            String nTeam = cbTeams.getSelectedItem().toString();
            Database db = new Database();
            try {
                if (db.searchID("dorsal", "Ciclistes", dorsal)) {
                    MainForm.alertsWarning(this, "ID Duplicated", "ID Duplicated");
                    // putting focus on tfDorsal
                    tfDorsal.requestFocus();
                } else {
                    // Insert
                    String sqlInsert = "INSERT INTO Ciclistes VALUES(?,?,?,?)";
                    //Connect
                    db.makeConnection();

                    PreparedStatement pst = db.getConnection().prepareStatement(sqlInsert);
                    pst.setInt(1, dorsal);
                    pst.setString(2, name);
                    pst.setInt(3, age);
                    pst.setString(4, nTeam);

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
                Logger.getLogger(AddCiclyst.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btInsertActionPerformed


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);       
//        this.rootPane.setEnabled(true);
//        this.rootPane.requestFocus();
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
            java.util.logging.Logger.getLogger(AddCiclyst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCiclyst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCiclyst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCiclyst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCiclyst().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btInsert;
    private javax.swing.JComboBox<String> cbTeams;
    private java.util.List<cyclists.Entity.Ciclistes> ciclistesList;
    private java.util.List<cyclists.Entity.Ciclistes> ciclistesList1;
    private java.util.List<cyclists.Entity.Ciclistes> ciclistesList2;
    private javax.persistence.Query ciclistesQuery;
    private javax.persistence.Query ciclistesQuery1;
    private javax.persistence.Query ciclistesQuery2;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCiclyst;
    private javax.swing.JTextField tfAge;
    private javax.swing.JTextField tfDorsal;
    private javax.swing.JTextField tfName;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}