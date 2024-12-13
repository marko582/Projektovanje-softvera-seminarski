/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;

import broker.DatabaseConnection;
import domen.Instruktor;
import domen.Kategorija;
import domen.Polaznik;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import kontroleri.KontrolerInstruktor;
import kontroleri.KontrolerKategorija;
import kontroleri.KontrolerPolaznik;

/**
 *
 * @author Windows HD
 */
public class IzmenaPolaznika extends javax.swing.JDialog {

    /**
     * Creates new form IzmenaPolaznika
     */
    Instruktor ins;
    public IzmenaPolaznika(java.awt.Frame parent, boolean modal, Instruktor ins) throws SQLException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.ins=ins;
        napuniCmbKategorija();
        napuniCmbPolaznik();
        napuniCmbInstruktor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbPolaznik = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBrTel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDatumRodj = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        cmbKategorija = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbInstruktori = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnIzmeniPolaznika = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 600));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel2.setPreferredSize(new java.awt.Dimension(573, 150));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Izmena podataka polaznika");
        jPanel2.add(jLabel1);

        cmbPolaznik.setPreferredSize(new java.awt.Dimension(500, 30));
        cmbPolaznik.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPolaznikItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbPolaznik);

        getContentPane().add(jPanel2);

        jPanel3.setMaximumSize(new java.awt.Dimension(500, 300));
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 300));
        jPanel3.setLayout(new java.awt.GridLayout(7, 0, 0, 20));

        jLabel3.setText("Ime:");
        jLabel3.setPreferredSize(new java.awt.Dimension(50, 16));
        jPanel3.add(jLabel3);

        txtIme.setMaximumSize(new java.awt.Dimension(300, 20));
        txtIme.setMinimumSize(new java.awt.Dimension(64, 20));
        txtIme.setPreferredSize(new java.awt.Dimension(300, 20));
        jPanel3.add(txtIme);

        jLabel4.setText("Prezime:");
        jPanel3.add(jLabel4);

        txtPrezime.setMaximumSize(new java.awt.Dimension(300, 20));
        txtPrezime.setMinimumSize(new java.awt.Dimension(64, 20));
        txtPrezime.setPreferredSize(new java.awt.Dimension(300, 20));
        jPanel3.add(txtPrezime);

        jLabel5.setText("Email:");
        jPanel3.add(jLabel5);

        txtEmail.setMaximumSize(new java.awt.Dimension(300, 20));
        txtEmail.setMinimumSize(new java.awt.Dimension(64, 20));
        txtEmail.setPreferredSize(new java.awt.Dimension(300, 20));
        jPanel3.add(txtEmail);

        jLabel6.setText("Broj telefona:");
        jPanel3.add(jLabel6);

        txtBrTel.setMaximumSize(new java.awt.Dimension(300, 20));
        txtBrTel.setMinimumSize(new java.awt.Dimension(64, 20));
        txtBrTel.setPreferredSize(new java.awt.Dimension(300, 20));
        jPanel3.add(txtBrTel);

        jLabel7.setText("Datum rodjenja:");
        jPanel3.add(jLabel7);
        jPanel3.add(txtDatumRodj);

        jLabel8.setText("Kategorija:");
        jPanel3.add(jLabel8);

        jPanel3.add(cmbKategorija);

        jLabel2.setText("Instruktor:");
        jPanel3.add(jLabel2);

        jPanel3.add(cmbInstruktori);

        getContentPane().add(jPanel3);

        jPanel1.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(859, 75));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnIzmeniPolaznika.setText("Promeni");
        btnIzmeniPolaznika.setPreferredSize(new java.awt.Dimension(150, 50));
        btnIzmeniPolaznika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniPolaznikaActionPerformed(evt);
            }
        });
        jPanel1.add(btnIzmeniPolaznika, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzmeniPolaznikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniPolaznikaActionPerformed
        try {
            izmeniPolaznik();
        } catch (SQLException ex) {
            Logger.getLogger(IzmenaPolaznika.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIzmeniPolaznikaActionPerformed

    private void cmbPolaznikItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPolaznikItemStateChanged
        Polaznik p = (Polaznik) cmbPolaznik.getSelectedItem();
        txtIme.setText(p.getIme());
        txtPrezime.setText(p.getPrezime());
        txtEmail.setText(p.getEmail());
        txtBrTel.setText(p.getBrojTelefona());
        txtDatumRodj.setDate(p.getDatumRodjenja());
        cmbKategorija.setSelectedItem(p.getKategorija());
    }//GEN-LAST:event_cmbPolaznikItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeniPolaznika;
    private javax.swing.JComboBox<Instruktor> cmbInstruktori;
    private javax.swing.JComboBox<Kategorija> cmbKategorija;
    private javax.swing.JComboBox<Polaznik> cmbPolaznik;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtBrTel;
    private com.toedter.calendar.JDateChooser txtDatumRodj;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    private void izmeniPolaznik() throws SQLException {
        Polaznik p = (Polaznik) cmbPolaznik.getSelectedItem();
        Object[] opcije = {"Da", "Ne"};
        int izbor = JOptionPane.showOptionDialog(this,"Da li sigurno zelite da izmenite podatke polaznika ?","Izmena polaznika",
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcije,opcije[1]);
            if(izbor == JOptionPane.YES_OPTION){
                Connection conn = DatabaseConnection.getInstance();
                Statement st = conn.createStatement();
                Date datum = txtDatumRodj.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String formatiranDatum = sdf.format(datum);
                String query = "UPDATE polaznik SET ime='"+txtIme.getText()+"',prezime='"+txtPrezime.getText()+
                        "',email='"+txtEmail.getText()+"',brojTelefona='"+txtBrTel.getText()+
                        "',datumRodjenja='"+formatiranDatum+"',idKategorija="
                        +((Kategorija)cmbKategorija.getSelectedItem()).getId()
                        + " WHERE id="+p.getId();
                st.executeUpdate(query);
                String query2="UPDATE evidencijacasa SET idInstruktor="+((Instruktor)cmbInstruktori.getSelectedItem()).getId()
                        +" WHERE idPolaznika="+p.getId();
                st.executeUpdate(query2);
                st.close();
                JOptionPane.showMessageDialog(null, "Polaznik uspesno izmenjen.","Izmena polaznika",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
    }

    private void napuniCmbPolaznik() throws SQLException {
        List<Polaznik> polaznici = KontrolerPolaznik.getList();
        for(Polaznik p : polaznici){
            cmbPolaznik.addItem(p);
        }
        cmbKategorija.setSelectedItem(polaznici.get(0).getKategorija());
    }

    private void napuniCmbKategorija() throws SQLException {
        List<Kategorija> kategorije = KontrolerKategorija.getList();
        for (Kategorija k : kategorije){
            cmbKategorija.addItem(k);
        }
    }

    private void napuniCmbInstruktor() throws SQLException {
        List<Instruktor> instruktori = KontrolerInstruktor.getList();
        for (Instruktor i : instruktori){
            cmbInstruktori.addItem(i);
        }
        cmbInstruktori.setSelectedItem(ins);
    }
}
