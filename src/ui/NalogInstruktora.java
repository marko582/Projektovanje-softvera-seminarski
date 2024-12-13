/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;

import broker.DatabaseConnection;
import domen.Instruktor;
import domen.Polaznik;
import domen.Sertifikat;
import domen.StavkaEvidencijeCasa;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import kontroleri.KontrolerInstruktor;
import kontroleri.KontrolerSertifikat;
import kontroleri.KontrolerStavke;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Windows HD
 */
public class NalogInstruktora extends javax.swing.JDialog {

    /**
     * Creates new form NalogInstruktora
     */
    public NalogInstruktora(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    Instruktor ins;
    public NalogInstruktora(java.awt.Frame parent, boolean modal,Instruktor i) throws SQLException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.ins=i;
        txtIme.setText(i.getIme());
        txtPrezime.setText(i.getPrezime());
        txtEmail.setText(i.getEmail());
        txtKorisnickoIme.setText(i.getKorisnickoIme());
        List<Sertifikat> sviSertifikati = KontrolerSertifikat.getList();
        List<Sertifikat> sertifikati = KontrolerSertifikat.getList(i);
        TableModel tm = tblSertifikati.getModel();
        DefaultTableModel dtm = (DefaultTableModel) tm;
        dtm.setRowCount(0);
        for(Sertifikat s: sertifikati){
            Object[] red = new Object[]{s.getNaziv()};
            dtm.addRow(red);
        }
        for (Sertifikat s : new LinkedList<>(sertifikati)) {
            if (sviSertifikati.contains(s)) {
                sviSertifikati.remove(s);
            }
        }

        for(Sertifikat s:sviSertifikati){
            cmbSertifikat.addItem(s);
        }

        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tblSertifikati.setDefaultRenderer(Object.class, centerRenderer);
        
        if(cmbSertifikat.getItemCount()==0){
            cmbSertifikat.setEnabled(false);
            btnDodaj.setEnabled(false);
        }else{
            cmbSertifikat.setEnabled(true);
            btnDodaj.setEnabled(true);
        }
        
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtKorisnickoIme = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbSertifikat = new javax.swing.JComboBox<>();
        btnIzmeni = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSertifikati = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtStaraLozinka = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtNovaLozinka = new javax.swing.JPasswordField();
        btnPromeniLozinku = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 700));
        setPreferredSize(new java.awt.Dimension(900, 700));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setMaximumSize(new java.awt.Dimension(185, 100));
        jPanel1.setMinimumSize(new java.awt.Dimension(185, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 100));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Nalog instruktora");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1);

        jPanel2.setMaximumSize(new java.awt.Dimension(400, 350));
        jPanel2.setMinimumSize(new java.awt.Dimension(400, 350));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 350));
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 10, 0, 10, 0, 10, 0};
        jPanel2Layout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
        jPanel2.setLayout(jPanel2Layout);

        jLabel2.setText("Ime:");
        jLabel2.setMaximumSize(new java.awt.Dimension(150, 25));
        jLabel2.setMinimumSize(new java.awt.Dimension(150, 25));
        jLabel2.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel2.add(jLabel2, gridBagConstraints);

        txtIme.setMaximumSize(new java.awt.Dimension(200, 25));
        txtIme.setMinimumSize(new java.awt.Dimension(200, 25));
        txtIme.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jPanel2.add(txtIme, gridBagConstraints);

        jLabel3.setText("Prezime:");
        jLabel3.setMaximumSize(new java.awt.Dimension(150, 25));
        jLabel3.setMinimumSize(new java.awt.Dimension(150, 25));
        jLabel3.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel2.add(jLabel3, gridBagConstraints);

        txtPrezime.setMaximumSize(new java.awt.Dimension(200, 25));
        txtPrezime.setMinimumSize(new java.awt.Dimension(200, 25));
        txtPrezime.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        jPanel2.add(txtPrezime, gridBagConstraints);

        jLabel4.setText("Email:");
        jLabel4.setMaximumSize(new java.awt.Dimension(150, 25));
        jLabel4.setMinimumSize(new java.awt.Dimension(150, 25));
        jLabel4.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        jPanel2.add(jLabel4, gridBagConstraints);

        txtKorisnickoIme.setMaximumSize(new java.awt.Dimension(200, 25));
        txtKorisnickoIme.setMinimumSize(new java.awt.Dimension(200, 25));
        txtKorisnickoIme.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        jPanel2.add(txtKorisnickoIme, gridBagConstraints);

        jLabel5.setText("Korisnicko ime:");
        jLabel5.setMaximumSize(new java.awt.Dimension(150, 25));
        jLabel5.setMinimumSize(new java.awt.Dimension(150, 25));
        jLabel5.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        jPanel2.add(jLabel5, gridBagConstraints);

        txtEmail.setMaximumSize(new java.awt.Dimension(200, 25));
        txtEmail.setMinimumSize(new java.awt.Dimension(200, 25));
        txtEmail.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        jPanel2.add(txtEmail, gridBagConstraints);

        jLabel8.setText("Sertifikat:");
        jLabel8.setMaximumSize(new java.awt.Dimension(150, 25));
        jLabel8.setMinimumSize(new java.awt.Dimension(150, 25));
        jLabel8.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        jPanel2.add(jLabel8, gridBagConstraints);

        cmbSertifikat.setMaximumSize(new java.awt.Dimension(200, 25));
        cmbSertifikat.setMinimumSize(new java.awt.Dimension(200, 25));
        cmbSertifikat.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 20;
        jPanel2.add(cmbSertifikat, gridBagConstraints);

        btnIzmeni.setText("Izmeni podatke");
        btnIzmeni.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIzmeni.setPreferredSize(new java.awt.Dimension(150, 30));
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 5;
        jPanel2.add(btnIzmeni, gridBagConstraints);

        btnDodaj.setText("Dodaj sertifikat");
        btnDodaj.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDodaj.setMaximumSize(new java.awt.Dimension(150, 30));
        btnDodaj.setMinimumSize(new java.awt.Dimension(150, 30));
        btnDodaj.setPreferredSize(new java.awt.Dimension(150, 30));
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 5;
        jPanel2.add(btnDodaj, gridBagConstraints);

        jPanel4.add(jPanel2);

        jPanel5.setMinimumSize(new java.awt.Dimension(400, 350));
        jPanel5.setPreferredSize(new java.awt.Dimension(400, 350));

        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Obrisi sertifikat");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setMaximumSize(new java.awt.Dimension(150, 30));
        jButton2.setMinimumSize(new java.awt.Dimension(150, 30));
        jButton2.setPreferredSize(new java.awt.Dimension(150, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2);

        tblSertifikati.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Sertifikati"
            }
        ));
        tblSertifikati.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblSertifikati.setMaximumSize(new java.awt.Dimension(400, 300));
        tblSertifikati.setMinimumSize(new java.awt.Dimension(400, 300));
        tblSertifikati.setPreferredSize(new java.awt.Dimension(400, 300));
        jScrollPane1.setViewportView(tblSertifikati);

        jPanel5.add(jScrollPane1);

        jPanel4.add(jPanel5);

        getContentPane().add(jPanel4);

        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 150));
        jPanel3.setMinimumSize(new java.awt.Dimension(100, 150));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 150));
        java.awt.GridBagLayout jPanel3Layout = new java.awt.GridBagLayout();
        jPanel3Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel3Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel3.setLayout(jPanel3Layout);

        jLabel6.setText("Stara lozinka:");
        jLabel6.setMaximumSize(new java.awt.Dimension(150, 25));
        jLabel6.setMinimumSize(new java.awt.Dimension(150, 25));
        jLabel6.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel3.add(jLabel6, gridBagConstraints);

        txtStaraLozinka.setMinimumSize(new java.awt.Dimension(150, 25));
        txtStaraLozinka.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        jPanel3.add(txtStaraLozinka, gridBagConstraints);

        jLabel7.setText("Nova lozinka:");
        jLabel7.setMaximumSize(new java.awt.Dimension(150, 25));
        jLabel7.setMinimumSize(new java.awt.Dimension(150, 25));
        jLabel7.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel3.add(jLabel7, gridBagConstraints);

        txtNovaLozinka.setMinimumSize(new java.awt.Dimension(150, 25));
        txtNovaLozinka.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        jPanel3.add(txtNovaLozinka, gridBagConstraints);

        btnPromeniLozinku.setText("Promeni lozinku");
        btnPromeniLozinku.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPromeniLozinku.setMaximumSize(new java.awt.Dimension(150, 30));
        btnPromeniLozinku.setMinimumSize(new java.awt.Dimension(150, 30));
        btnPromeniLozinku.setPreferredSize(new java.awt.Dimension(150, 30));
        btnPromeniLozinku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromeniLozinkuActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 7;
        jPanel3.add(btnPromeniLozinku, gridBagConstraints);

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        try {
            Connection conn = DatabaseConnection.getInstance();
            String query="UPDATE instruktor SET ime ='"+txtIme.getText()+"',prezime ='"+txtPrezime.getText()+"',"
                    + "email ='"+txtEmail.getText()+"',korisnickoIme ='"+txtKorisnickoIme.getText()+"' WHERE id ="+ins.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            ins.setIme(txtIme.getText());
            ins.setPrezime(txtPrezime.getText());
            ins.setEmail(txtEmail.getText());
            ins.setKorisnickoIme(txtKorisnickoIme.getText());
            JOptionPane.showMessageDialog(this, "Uspesno ste izmenili podatke","Izmena podataka",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(NalogInstruktora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    Object[] opcije = {"Da", "Ne"};
    int izbor = JOptionPane.showOptionDialog(this,"Da li sigurno zelite da obrisete sertifikat?","Brisanje sertifikata",
    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcije,opcije[1]);

    if(izbor == JOptionPane.YES_OPTION){

                
        try {
            List<Sertifikat> sertifikati = KontrolerSertifikat.getList(ins);
            int selektovanRedovi[]={};
            selektovanRedovi=tblSertifikati.getSelectedRows();
            TableModel tm = tblSertifikati.getModel();
            DefaultTableModel dtm = (DefaultTableModel) tm;
            for(int i=0;i<dtm.getRowCount();i++){
                for(int j=0;j<selektovanRedovi.length;j++){
                    if(i==selektovanRedovi[j]){
                       
                            Connection conn = DatabaseConnection.getInstance();
                            Statement st = conn.createStatement();
                            String query = "DELETE FROM insser WHERE idInstruktor="+ins.getId()+ " AND "
                                    + "idSertifikat ="+sertifikati.get(i).getId();
                            st.executeUpdate(query);
                            cmbSertifikat.removeItem(sertifikati.get(i));
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Sertifikat/i " +" uspesno obrisan/i.","Brisanje sertifikata",JOptionPane.INFORMATION_MESSAGE);

            
            dtm.setRowCount(0);
            sertifikati = KontrolerSertifikat.getList(ins);
            for(Sertifikat s: sertifikati){
                Object[] red = new Object[]{s.getNaziv()};
                dtm.addRow(red);
            }
            List<Sertifikat> sviSertifikati = KontrolerSertifikat.getList();
            for (Sertifikat s : new LinkedList<>(sertifikati)) {
                if (sviSertifikati.contains(s)) {
                    sviSertifikati.remove(s);
                }
            }
            cmbSertifikat.removeAllItems();
            for(Sertifikat s:sviSertifikati){
                cmbSertifikat.addItem(s);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Glavna.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cmbSertifikat.getItemCount()==0){
            cmbSertifikat.setEnabled(false);
            btnDodaj.setEnabled(false);
        }else{
            cmbSertifikat.setEnabled(true);
            btnDodaj.setEnabled(true);
        }
      }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        try {
            Sertifikat ser = (Sertifikat) cmbSertifikat.getSelectedItem();
            Connection conn = DatabaseConnection.getInstance();
            String query = "INSERT INTO insser (idInstruktor, idSertifikat, datumIzdavanja) " +
            "VALUES ('"+ins.getId()+"', '"+ser.getId()+"','"+Date.valueOf(LocalDate.now())+"')";
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            
                        TableModel tm = tblSertifikati.getModel();
            DefaultTableModel dtm = (DefaultTableModel) tm;
            dtm.setRowCount(0);
            List<Sertifikat> sertifikati = KontrolerSertifikat.getList(ins);
            for(Sertifikat s: sertifikati){
                Object[] red = new Object[]{s.getNaziv()};
                dtm.addRow(red);
            }
            List<Sertifikat> sviSertifikati = KontrolerSertifikat.getList();
            for (Sertifikat s : new LinkedList<>(sertifikati)) {
                if (sviSertifikati.contains(s)) {
                    sviSertifikati.remove(s);
                }
            }
            cmbSertifikat.removeAllItems();
            for(Sertifikat s:sviSertifikati){
                cmbSertifikat.addItem(s);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(NalogInstruktora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(cmbSertifikat.getItemCount()==0){
            cmbSertifikat.setEnabled(false);
            btnDodaj.setEnabled(false);
        }else{
            cmbSertifikat.setEnabled(true);
            btnDodaj.setEnabled(true);
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromeniLozinkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromeniLozinkuActionPerformed
        String greska="";
        if(!validateLozinka(txtNovaLozinka.getText())){
            greska+="Lozinka nije u odgovarajucem formatu.\n";
            JOptionPane.showMessageDialog(null, greska,"Greska",JOptionPane.ERROR_MESSAGE);
        }
        if(txtStaraLozinka.getText().equals(ins.getLozinka())&&validateLozinka(txtNovaLozinka.getText())){
            try {
                ins.setLozinka(txtNovaLozinka.getText());
                String query="UPDATE instruktor SET lozinka ='"+txtNovaLozinka.getText()+
                "',promenioLozinku=1 WHERE id ="+ins.getId();
                Connection conn = DatabaseConnection.getInstance();
                Statement st = conn.createStatement();
                st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Lozinka uspesno promenjena","Promena lozinke",JOptionPane.INFORMATION_MESSAGE);
                
            } catch (SQLException ex) {
                Logger.getLogger(NalogInstruktora.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btnPromeniLozinkuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnPromeniLozinku;
    private javax.swing.JComboBox<Sertifikat> cmbSertifikat;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSertifikati;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtKorisnickoIme;
    private javax.swing.JPasswordField txtNovaLozinka;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JPasswordField txtStaraLozinka;
    // End of variables declaration//GEN-END:variables

    public boolean validateLozinka(String lozinka){
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(lozinka);
        return matcher.matches();
    }

}