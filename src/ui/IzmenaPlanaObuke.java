/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;
import broker.DatabaseConnection;
import domen.Instruktor;
import domen.Kategorija;
import domen.PlanObuke;
import domen.Polaznik;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroleri.KontrolerInstruktor;
import kontroleri.KontrolerKategorija;
import kontroleri.KontrolerPlanObuke;

/**
 *
 * @author Windows HD
 */
public class IzmenaPlanaObuke extends javax.swing.JDialog {

    /**
     * Creates new form Dodavanje
     */
    public IzmenaPlanaObuke(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(this);
        napuniCmbPlanovi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTrajanje = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOpis = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        cmbPlanObuke = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnPromeniPlan = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(234, 500));
        setPreferredSize(new java.awt.Dimension(739, 500));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel2.setPreferredSize(new java.awt.Dimension(573, 50));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 10));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Izmena plana obuke");
        jPanel2.add(jLabel1);

        getContentPane().add(jPanel2);

        jPanel3.setMaximumSize(new java.awt.Dimension(500, 500));
        jPanel3.setMinimumSize(new java.awt.Dimension(136, 100));
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 300));
        java.awt.GridBagLayout jPanel3Layout = new java.awt.GridBagLayout();
        jPanel3Layout.columnWidths = new int[] {0, 5, 0, 5, 0};
        jPanel3Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel3.setLayout(jPanel3Layout);

        jLabel3.setText("Trajanje:");
        jLabel3.setPreferredSize(new java.awt.Dimension(50, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(jLabel3, gridBagConstraints);

        txtTrajanje.setMaximumSize(new java.awt.Dimension(300, 20));
        txtTrajanje.setMinimumSize(new java.awt.Dimension(64, 20));
        txtTrajanje.setPreferredSize(new java.awt.Dimension(350, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        jPanel3.add(txtTrajanje, gridBagConstraints);

        jLabel2.setText("Opis:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(jLabel2, gridBagConstraints);

        txtOpis.setColumns(30);
        txtOpis.setRows(5);
        txtOpis.setMinimumSize(new java.awt.Dimension(13, 150));
        txtOpis.setPreferredSize(new java.awt.Dimension(340, 150));
        jScrollPane1.setViewportView(txtOpis);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridheight = 7;
        jPanel3.add(jScrollPane1, gridBagConstraints);

        jLabel4.setText("Naziv:");
        jLabel4.setPreferredSize(new java.awt.Dimension(50, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(jLabel4, gridBagConstraints);

        txtNaziv.setMaximumSize(new java.awt.Dimension(300, 20));
        txtNaziv.setMinimumSize(new java.awt.Dimension(64, 20));
        txtNaziv.setPreferredSize(new java.awt.Dimension(350, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel3.add(txtNaziv, gridBagConstraints);

        cmbPlanObuke.setPreferredSize(new java.awt.Dimension(350, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel3.add(cmbPlanObuke, gridBagConstraints);

        getContentPane().add(jPanel3);

        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 100));
        jPanel4.setPreferredSize(new java.awt.Dimension(739, 100));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        btnPromeniPlan.setText("Promeni");
        btnPromeniPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniPlanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 103;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 152, 32, 163);
        jPanel4.add(btnPromeniPlan, gridBagConstraints);

        getContentPane().add(jPanel4);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPromeniPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniPlanActionPerformed
        try {
            izmeniPlanObuke();
        } catch (SQLException ex) {
            Logger.getLogger(IzmenaPlanaObuke.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPromeniPlanActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPromeniPlan;
    private javax.swing.JComboBox<PlanObuke> cmbPlanObuke;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextArea txtOpis;
    private javax.swing.JTextField txtTrajanje;
    // End of variables declaration//GEN-END:variables

    private void izmeniPlanObuke() throws SQLException {
        PlanObuke po = (PlanObuke) cmbPlanObuke.getSelectedItem();
        Object[] opcije = {"Da", "Ne"};
        int izbor = JOptionPane.showOptionDialog(this,"Da li sigurno zelite da izmenite plan obuke ?","Plan obuke",
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcije,opcije[1]);
            if(izbor == JOptionPane.YES_OPTION){
                Connection conn = DatabaseConnection.getInstance();
                Statement st = conn.createStatement();
                String query = "UPDATE planobuke SET naziv='"+txtNaziv.getName()+"'" +",opis='"+po.getOpis()
                        +"' WHERE id="+po.getId();
                st.executeUpdate(query);
                st.close();
                JOptionPane.showMessageDialog(null, "Plan obuke uspesno izmenjen.","Izmena plan obuke",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
    }

    private void napuniCmbPlanovi() throws SQLException {
        List<PlanObuke> planovi = KontrolerPlanObuke.getList();
        for (PlanObuke po : planovi){
            cmbPlanObuke.addItem(po);
        }
    }
}
