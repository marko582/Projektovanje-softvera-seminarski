/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;
import domen.EvidencijaCasa;
import domen.Instruktor;
import domen.Kategorija;
import domen.Polaznik;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import kontroleri.KontrolerEvidencija;
import kontroleri.KontrolerInstruktor;
import kontroleri.KontrolerKategorija;
import kontroleri.KontrolerPolaznik;

/**
 *
 * @author Windows HD
 */
public class DodavanjePolaznika extends javax.swing.JDialog {

    /**
     * Creates new form Dodavanje
     */
    Long polaznikId;
    public DodavanjePolaznika(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(this);
        napuniCmbKategorija();
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
        jPanel4 = new javax.swing.JPanel();
        btnDodajPolaznika = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(2147483647, 500));
        setPreferredSize(new java.awt.Dimension(800, 450));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel2.setPreferredSize(new java.awt.Dimension(573, 50));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 10));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Dodavanje polaznika");
        jPanel2.add(jLabel1);

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

        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 100));
        jPanel4.setPreferredSize(new java.awt.Dimension(739, 100));

        btnDodajPolaznika.setText("Dodaj");
        btnDodajPolaznika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajPolaznikaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(btnDodajPolaznika, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(btnDodajPolaznika, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel4);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajPolaznikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajPolaznikaActionPerformed
        try {
            dodajPolaznika();
        } catch (SQLException ex) {
            Logger.getLogger(DodavanjePolaznika.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDodajPolaznikaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajPolaznika;
    private javax.swing.JComboBox<Instruktor> cmbInstruktori;
    private javax.swing.JComboBox<Kategorija> cmbKategorija;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtBrTel;
    private com.toedter.calendar.JDateChooser txtDatumRodj;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    private void dodajPolaznika() throws SQLException {
        if(!validacijaDodajPolaznik()){
            JOptionPane.showMessageDialog(this, "Svi podaci moraju biti uneti u ispravnom formatu","",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
        Long idKategorija=KontrolerKategorija.getId((Kategorija) cmbKategorija.getSelectedItem());
        Polaznik polaznik = new Polaznik(0l, txtIme.getText(), txtPrezime.getText(), 
        txtEmail.getText(), txtBrTel.getText(), txtDatumRodj.getDate(), (Kategorija)cmbKategorija.getSelectedItem());
        
        this.polaznikId=KontrolerPolaznik.createGetId(polaznik);
        polaznik.setId(polaznikId);
        Integer cenaObuke=getCenaObuke(idKategorija);
        
        Instruktor instruktor = (Instruktor) cmbInstruktori.getSelectedItem();
        EvidencijaCasa evc = new EvidencijaCasa(0l, cenaObuke, instruktor, polaznik);
        KontrolerEvidencija.create(evc);

        
        
        Object[] opcije = {"Da", "Ne"};
        int izbor = JOptionPane.showOptionDialog(this,"Uspesno dodat polaznik."
                + " Da li zelite da dodate jos jednog polaznika?","Dodavanje polaznika",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcije,opcije[0]);
        
        if(izbor == JOptionPane.NO_OPTION){
            this.dispose();
        }
        else{
            txtIme.setText("");
            txtPrezime.setText("");
            txtBrTel.setText("");
            txtEmail.setText("");
            txtDatumRodj.setCalendar(null);
            cmbInstruktori.setSelectedItem(null);
            cmbKategorija.setSelectedItem(null);
        }
        }
        
        
    }

    private void napuniCmbKategorija() throws SQLException {
        List<Kategorija> kategorije = KontrolerKategorija.getList();
        for (Kategorija k : kategorije){
            cmbKategorija.addItem(k);
        }
        cmbKategorija.setSelectedItem(null);
    }

    private void napuniCmbInstruktor() throws SQLException {
        List<Instruktor> instruktori = KontrolerInstruktor.getList();
        for (Instruktor i : instruktori){
            cmbInstruktori.addItem(i);
        }
        cmbInstruktori.setSelectedItem(null);
    }

    private boolean validacijaDodajPolaznik() {
        if(!txtIme.getText().equals("") && !txtPrezime.getText().equals("") && !txtBrTel.getText().equals("")
                && txtDatumRodj.getDate()!=null && validateEmail(txtEmail.getText())
                && cmbKategorija.getSelectedItem()!=null && cmbInstruktori.getSelectedItem()!=null){
            return true;
        }
        return false;
    }
    public boolean validateEmail(String email){
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public Integer getCenaObuke(Long idKategorija){
        Integer cenaObuke=0;
        switch (Long.valueOf(idKategorija).intValue()) {
            case 1:
                cenaObuke=67500;
                break;
            case 2:
                cenaObuke=70000;
                break;
            case 3:
                cenaObuke=72500;
                break;
            case 4:
                cenaObuke=75000;
                break;
            case 5:
                cenaObuke=80000;
                break;
            case 6:
                cenaObuke=82500;
                break;
            case 7:
                cenaObuke=85000;
                break;
            case 8:
                cenaObuke=87500;
                break;
            case 9:
                cenaObuke=90000;
                break;
            default:
                throw new AssertionError();
        }
        return cenaObuke;
    }
}
