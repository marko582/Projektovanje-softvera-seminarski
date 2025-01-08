/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import domen.Instruktor;
import domen.Kategorija;
import domen.Polaznik;
import domen.StavkaEvidencijeCasa;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import kontroleri.KontrolerEvidencija;
import kontroleri.KontrolerInstruktor;
import kontroleri.KontrolerKategorija;
import kontroleri.KontrolerPolaznik;
import kontroleri.KontrolerStavke;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Windows HD
 */
public class GlavnaAdmin extends javax.swing.JFrame {

    /**
     * Creates new form Glavna
     */
    Long rb=0l;
    Instruktor instruktor;
    public GlavnaAdmin() throws SQLException{
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AutoCompleteDecorator.decorate(cmbPolaznik);
        AutoCompleteDecorator.decorate(cmbInstruktor);
//        this.instruktor=i;
        napuniCmbInstruktor();
        instruktor = (Instruktor) cmbInstruktor.getSelectedItem();
        napuniCmbPolaznici(instruktor);
        napuniCmbKategorija();
        
        Polaznik p = (Polaznik) cmbPolaznik.getSelectedItem();
    if(p!=null){
        List<StavkaEvidencijeCasa> stavke = KontrolerStavke.getList(p);
        TableModel tm = tblCasovi.getModel();
        DefaultTableModel dtm = (DefaultTableModel) tm;
        dtm.setRowCount(0);
        for(StavkaEvidencijeCasa s: stavke){
            Object[] red = new Object[]{s.getRb(),s.getDatumCasa(),s.getVremePocetkaCasa()+"h",
                s.getVremeKrajaCasa()+"h",s.getTrajanjeCasa()+"min",s.getPlanObuke().getNaziv()};
            dtm.addRow(red);
        }
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tblCasovi.setDefaultRenderer(Object.class, centerRenderer);
        
        btnDodajCas.setEnabled(true);
        btnIzmeniCas.setEnabled(true);
        btnIzmeniPolaznik.setEnabled(true);
        btnObrisiCas.setEnabled(true);
        btnObrisiPolaznik.setEnabled(true);

    }
    else{
        btnDodajCas.setEnabled(false);
        btnIzmeniCas.setEnabled(false);
        btnIzmeniPolaznik.setEnabled(false);
        btnObrisiCas.setEnabled(false);
        btnObrisiPolaznik.setEnabled(false);
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

        panelGlavniAdmin = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(32767, 0));
        jLabel1 = new javax.swing.JLabel();
        lblInstruktor = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(32767, 0));
        lblIzmenaLozinke = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(70, 0), new java.awt.Dimension(32767, 0));
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCasovi = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cmbInstruktor = new javax.swing.JComboBox<>();
        cmbPolaznik = new javax.swing.JComboBox<>();
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
        txtCenaObuke = new javax.swing.JTextField();
        btnObrisiPolaznik = new javax.swing.JButton();
        btnIzmeniPolaznik = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnDodajCas = new javax.swing.JButton();
        btnObrisiCas = new javax.swing.JButton();
        btnIzmeniCas = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        meniNalog = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        panelGlavniAdmin.setLayout(new javax.swing.BoxLayout(panelGlavniAdmin, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel2.setPreferredSize(new java.awt.Dimension(565, 50));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jPanel7.add(filler1);

        jLabel1.setText("Dobrodosao/la");
        jPanel7.add(jLabel1);

        lblInstruktor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblInstruktor.setText("admin");
        jPanel7.add(lblInstruktor);
        jPanel7.add(filler3);
        jPanel7.add(lblIzmenaLozinke);

        jPanel2.add(jPanel7);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        jPanel8.add(filler2);

        jPanel2.add(jPanel8);

        panelGlavniAdmin.add(jPanel2);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        tblCasovi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Redni broj", "Datum casa", "Vreme pocetka", "Vreme kraja", "Trajanje casa", "Plan rada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCasovi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(tblCasovi);
        if (tblCasovi.getColumnModel().getColumnCount() > 0) {
            tblCasovi.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jPanel4.add(jScrollPane1);

        jPanel5.setMaximumSize(new java.awt.Dimension(325, 32767));
        jPanel5.setPreferredSize(new java.awt.Dimension(325, 423));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setPreferredSize(new java.awt.Dimension(325, 400));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        cmbInstruktor.setMaximumSize(new java.awt.Dimension(300, 32767));
        cmbInstruktor.setMinimumSize(new java.awt.Dimension(300, 22));
        cmbInstruktor.setPreferredSize(new java.awt.Dimension(300, 22));
        cmbInstruktor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbInstruktorItemStateChanged(evt);
            }
        });
        jPanel3.add(cmbInstruktor);

        cmbPolaznik.setMaximumSize(new java.awt.Dimension(300, 32767));
        cmbPolaznik.setMinimumSize(new java.awt.Dimension(300, 22));
        cmbPolaznik.setPreferredSize(new java.awt.Dimension(300, 22));
        cmbPolaznik.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPolaznikItemStateChanged(evt);
            }
        });
        cmbPolaznik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPolaznikActionPerformed(evt);
            }
        });
        jPanel3.add(cmbPolaznik);

        jLabel3.setText("Ime:");
        jLabel3.setPreferredSize(new java.awt.Dimension(90, 20));
        jPanel3.add(jLabel3);

        txtIme.setEditable(false);
        txtIme.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel3.add(txtIme);

        jLabel4.setText("Prezime:");
        jLabel4.setPreferredSize(new java.awt.Dimension(90, 20));
        jPanel3.add(jLabel4);

        txtPrezime.setEditable(false);
        txtPrezime.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel3.add(txtPrezime);

        jLabel5.setText("Email:");
        jLabel5.setPreferredSize(new java.awt.Dimension(90, 20));
        jPanel3.add(jLabel5);

        txtEmail.setEditable(false);
        txtEmail.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel3.add(txtEmail);

        jLabel6.setText("Broj telefona:");
        jLabel6.setPreferredSize(new java.awt.Dimension(90, 20));
        jPanel3.add(jLabel6);

        txtBrTel.setEditable(false);
        txtBrTel.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel3.add(txtBrTel);

        jLabel7.setText("Datum rodjenja:");
        jLabel7.setPreferredSize(new java.awt.Dimension(90, 20));
        jPanel3.add(jLabel7);

        txtDatumRodj.setEnabled(false);
        txtDatumRodj.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel3.add(txtDatumRodj);

        jLabel8.setText("Kategorija:");
        jLabel8.setPreferredSize(new java.awt.Dimension(90, 20));
        jPanel3.add(jLabel8);

        cmbKategorija.setEnabled(false);
        cmbKategorija.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel3.add(cmbKategorija);

        jLabel2.setText("Cena obuke:");
        jLabel2.setPreferredSize(new java.awt.Dimension(90, 20));
        jPanel3.add(jLabel2);

        txtCenaObuke.setEditable(false);
        txtCenaObuke.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel3.add(txtCenaObuke);

        btnObrisiPolaznik.setForeground(new java.awt.Color(255, 51, 51));
        btnObrisiPolaznik.setText("Ispisi polaznika");
        btnObrisiPolaznik.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnObrisiPolaznik.setPreferredSize(new java.awt.Dimension(125, 45));
        btnObrisiPolaznik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiPolaznikActionPerformed(evt);
            }
        });
        jPanel3.add(btnObrisiPolaznik);

        btnIzmeniPolaznik.setForeground(new java.awt.Color(0, 0, 255));
        btnIzmeniPolaznik.setText("Omoguci izmenu");
        btnIzmeniPolaznik.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIzmeniPolaznik.setPreferredSize(new java.awt.Dimension(125, 45));
        btnIzmeniPolaznik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniPolaznikActionPerformed(evt);
            }
        });
        jPanel3.add(btnIzmeniPolaznik);

        jPanel5.add(jPanel3);

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();
        flowLayout1.setAlignOnBaseline(true);
        jPanel6.setLayout(flowLayout1);

        btnDodajCas.setForeground(new java.awt.Color(0, 153, 51));
        btnDodajCas.setText("Dodaj cas");
        btnDodajCas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDodajCas.setPreferredSize(new java.awt.Dimension(250, 45));
        btnDodajCas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajCasActionPerformed(evt);
            }
        });
        jPanel6.add(btnDodajCas);

        btnObrisiCas.setForeground(new java.awt.Color(255, 51, 51));
        btnObrisiCas.setText("Otkazi cas");
        btnObrisiCas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnObrisiCas.setPreferredSize(new java.awt.Dimension(250, 45));
        btnObrisiCas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiCasActionPerformed(evt);
            }
        });
        jPanel6.add(btnObrisiCas);

        btnIzmeniCas.setForeground(new java.awt.Color(0, 0, 255));
        btnIzmeniCas.setText("Izmeni cas");
        btnIzmeniCas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIzmeniCas.setPreferredSize(new java.awt.Dimension(250, 45));
        btnIzmeniCas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniCasActionPerformed(evt);
            }
        });
        jPanel6.add(btnIzmeniCas);

        jPanel5.add(jPanel6);

        jPanel4.add(jPanel5);

        panelGlavniAdmin.add(jPanel4);

        getContentPane().add(panelGlavniAdmin, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Kreiraj");

        jMenuItem1.setText("Polaznik");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Instruktor");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem7.setText("Plan obuke");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Prikazi");

        jMenuItem5.setText("Casove");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem4.setText("Polaznike");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem6.setText("Instruktore");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        meniNalog.setText("Nalog");

        jMenuItem3.setText("Prikazi");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        meniNalog.add(jMenuItem3);

        jMenuItem9.setText("Odjavite se");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        meniNalog.add(jMenuItem9);

        jMenuBar1.add(meniNalog);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            DodavanjePolaznika dpf = new DodavanjePolaznika(this, true);
            dpf.setVisible(true);
            dpf.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    refreshMainCmb();
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void btnObrisiPolaznikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiPolaznikActionPerformed
        try {
            Polaznik p = (Polaznik) cmbPolaznik.getSelectedItem();
            Object[] opcije = {"Da", "Ne"};
            int izbor = JOptionPane.showOptionDialog(this,"Da li sigurno zelite da ispisete polaznika "
                    +p.getIme()+" "+p.getPrezime()+"?","Ispisivanje polaznika",
                    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcije,opcije[1]);

            if(izbor == JOptionPane.YES_OPTION){
                KontrolerPolaznik.ispisi(p);
                cmbPolaznik.removeItem(p);
                JOptionPane.showMessageDialog(null, "Polaznik "+p.getIme()+" "+p.getPrezime() +" uspesno ispisan.","Ispisivanje polaznika",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnObrisiPolaznikActionPerformed

    private void cmbPolaznikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPolaznikActionPerformed
        try {
            Polaznik p = (Polaznik) cmbPolaznik.getSelectedItem();
            if(p!=null){
                
            //sve sto se promeni mora da se promeni i u objektu p
            txtIme.setText(p.getIme());
            txtPrezime.setText(p.getPrezime());
            txtEmail.setText(p.getEmail());
            txtBrTel.setText(p.getBrojTelefona());
            txtDatumRodj.setDate(p.getDatumRodjenja());
            cmbKategorija.setSelectedItem(p.getKategorija());
            btnIzmeniPolaznik.setText("Omoguci izmenu");
            txtIme.setEditable(false);
            txtPrezime.setEditable(false);
            txtBrTel.setEditable(false);
            txtDatumRodj.setEnabled(false);
            txtEmail.setEditable(false);
            cmbKategorija.setEnabled(false);
            
            
            
            TableModel tm = tblCasovi.getModel();
            DefaultTableModel dtm = (DefaultTableModel) tm;
            dtm.setRowCount(0);
            //lista stavki
            List<StavkaEvidencijeCasa> stavke = KontrolerStavke.getList(p);
            
            for(StavkaEvidencijeCasa s: stavke){
                Object[] red = new Object[]{s.getRb(),s.getDatumCasa(),s.getVremePocetkaCasa()+"h",
                    s.getVremeKrajaCasa()+"h",s.getTrajanjeCasa()+"min",s.getPlanObuke().getNaziv()};
                dtm.addRow(red);
            }
            Integer cenaObuke=KontrolerEvidencija.getCenaObuke(p);
            txtCenaObuke.setText(String.valueOf(cenaObuke));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(NullPointerException e){
        }
    }//GEN-LAST:event_cmbPolaznikActionPerformed

    private void btnObrisiCasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiCasActionPerformed
        int selektovanRedovi[]={};
        selektovanRedovi=tblCasovi.getSelectedRows();
    if(selektovanRedovi.length==0){
        JOptionPane.showMessageDialog(this, "Izaberite cas za brisanje","Greska",JOptionPane.ERROR_MESSAGE);
    }else{
        
        
    Object[] opcije = {"Da", "Ne"};
    int izbor = JOptionPane.showOptionDialog(this,"Da li sigurno zelite da otkazete cas/ove?","Otkazivanje casova",
    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcije,opcije[1]);

    if(izbor == JOptionPane.YES_OPTION){
                
        try {
            
            Polaznik p = (Polaznik) cmbPolaznik.getSelectedItem();
            List<StavkaEvidencijeCasa> casovi = KontrolerStavke.getList(p);
            

            TableModel tm = tblCasovi.getModel();
            DefaultTableModel dtm = (DefaultTableModel) tm;
            for(int i=0;i<dtm.getRowCount();i++){
                for(int j=0;j<selektovanRedovi.length;j++){
                    if(i==selektovanRedovi[j]){      
                        KontrolerStavke.otkazi(casovi.get(i));                    
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Cas/ovi " +" uspesno otkazan/i.","Otkazivanje casova",JOptionPane.INFORMATION_MESSAGE);

            
            dtm.setRowCount(0);
            
            List<StavkaEvidencijeCasa> casovi2=KontrolerStavke.getList(p);
            for(StavkaEvidencijeCasa s: casovi2){
                Object[] red = new Object[]{s.getRb(),s.getDatumCasa(),s.getVremePocetkaCasa()+"h",
                  s.getVremeKrajaCasa()+"h",s.getTrajanjeCasa()+"min",s.getPlanObuke().getNaziv()};
                dtm.addRow(red);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    }//GEN-LAST:event_btnObrisiCasActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        try {
            DodavanjePlanaObuke pof=new DodavanjePlanaObuke(this, true);
            pof.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void btnIzmeniPolaznikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniPolaznikActionPerformed
        if(btnIzmeniPolaznik.getText().equals("Omoguci izmenu")){
            txtIme.setEditable(true);
            txtPrezime.setEditable(true);
            txtBrTel.setEditable(true);
            txtDatumRodj.setEnabled(true);
            txtEmail.setEditable(true);
            cmbKategorija.setEnabled(true);

            btnIzmeniPolaznik.setText("Izmeni");
            return;
        }
        if(btnIzmeniPolaznik.getText().equals("Izmeni")){
            Polaznik p = (Polaznik) cmbPolaznik.getSelectedItem();
            Object[] opcije = {"Da", "Ne"};
            int izbor = JOptionPane.showOptionDialog(this,"Da li sigurno zelite da izmenite podatke polaznika ?","Izmena polaznika",
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcije,opcije[1]);

        
        
            if(izbor == JOptionPane.YES_OPTION){
                try {                    
                    Polaznik polaznik = new Polaznik(p.getId(), txtIme.getText(), txtPrezime.getText(), 
                    txtEmail.getText(), txtBrTel.getText(), txtDatumRodj.getDate(), (Kategorija)cmbKategorija.getSelectedItem());
                    KontrolerPolaznik.update(polaznik);
                    JOptionPane.showMessageDialog(null, "Polaznik uspesno izmenjen.","Izmena polaznika",JOptionPane.INFORMATION_MESSAGE);
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
                btnIzmeniPolaznik.setText("Omoguci izmenu");
                txtIme.setEditable(false);
                txtPrezime.setEditable(false);
                txtBrTel.setEditable(false);
                txtDatumRodj.setEnabled(false);
                txtEmail.setEditable(false);
                cmbKategorija.setEnabled(false);
                
                cmbPolaznik.removeAllItems();
                napuniCmbPolaznici(instruktor);
            
       }
    }
        
    }//GEN-LAST:event_btnIzmeniPolaznikActionPerformed

    private void btnDodajCasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajCasActionPerformed
        TableModel tm = tblCasovi.getModel();
        DefaultTableModel dtm =(DefaultTableModel) tm;
        // ne sme ovako rb
//        rb=Long.valueOf(dtm.getRowCount());
        Polaznik p = (Polaznik) cmbPolaznik.getSelectedItem();
        try {
            rb=KontrolerStavke.getRb(KontrolerEvidencija.getId(instruktor, p));
        } catch (SQLException ex) {
            Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DodavanjeCasova dcf = new DodavanjeCasova(this, true, instruktor, p, rb);
            dcf.setVisible(true);
            dcf.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    try {
                        refreshMainTable();
                    } catch (SQLException ex) {
                        Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            });
        } catch (SQLException ex) {
            Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnDodajCasActionPerformed

    private void btnIzmeniCasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniCasActionPerformed
        try {
            StavkaEvidencijeCasa cas=new StavkaEvidencijeCasa();
            Polaznik p = (Polaznik) cmbPolaznik.getSelectedItem();
            List<StavkaEvidencijeCasa> casovi = KontrolerStavke.getList(p);
            Integer selektovanRed;
            selektovanRed=tblCasovi.getSelectedRow();
            TableModel tm = tblCasovi.getModel();
            DefaultTableModel dtm = (DefaultTableModel) tm;
            for(int i=0;i<dtm.getRowCount();i++){
                if(i==selektovanRed){
                    cas = casovi.get(i);
                }
            }
            
            if(selektovanRed!=-1){
                IzmenaCasova icf= new IzmenaCasova(this, rootPaneCheckingEnabled,cas);
                icf.setVisible(true);
                icf.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        try {
                            refreshMainTable();
                        } catch (SQLException ex) {
                            Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
            else{
                JOptionPane.showMessageDialog(this, "Selektujete red za izmenu","Greska",JOptionPane.INFORMATION_MESSAGE);
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIzmeniCasActionPerformed

    private void cmbPolaznikItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPolaznikItemStateChanged
        // TODO add your handling code here:
        if(cmbPolaznik.getSelectedItem()==null){
            btnDodajCas.setEnabled(false);
            btnIzmeniCas.setEnabled(false);
            btnIzmeniPolaznik.setEnabled(false);
            btnObrisiCas.setEnabled(false);
            btnObrisiPolaznik.setEnabled(false);
            txtIme.setText("");
            txtPrezime.setText("");
            txtBrTel.setText("");
            txtCenaObuke.setText("");
            txtDatumRodj.setDate(null);
            txtEmail.setText("");
        }
        else{
            btnDodajCas.setEnabled(true);
            btnIzmeniCas.setEnabled(true);
            btnIzmeniPolaznik.setEnabled(true);
            btnObrisiCas.setEnabled(true);
            btnObrisiPolaznik.setEnabled(true);
        }
    }//GEN-LAST:event_cmbPolaznikItemStateChanged

    private void cmbInstruktorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbInstruktorItemStateChanged
        try {
            
            refreshMainCmb();
            refreshMainTable();
        } catch (SQLException ex) {
            Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbInstruktorItemStateChanged

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            new NalogInstruktora(this, true, (Instruktor) cmbInstruktor.getSelectedItem()).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Glavna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            DodavanjeInstruktora dpf = new DodavanjeInstruktora(this, true);
            dpf.setVisible(true);
            dpf.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    refreshMainCmb();
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        try {
            panelGlavniAdmin.removeAll();
            PanelPolaznici panel = new PanelPolaznici();
            panelGlavniAdmin.add(panel);
            revalidate();  
            repaint();
        } catch (SQLException ex) {
            Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        panelGlavniAdmin.removeAll();
        panelGlavniAdmin.add(this.jPanel2);
        panelGlavniAdmin.add(this.jPanel4);
        revalidate();  
        repaint();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try {
            panelGlavniAdmin.removeAll();
            PanelInstruktori panel = new PanelInstruktori();
            panelGlavniAdmin.add(panel);
            revalidate();  
            repaint();
        } catch (SQLException ex) {
            Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajCas;
    private javax.swing.JButton btnIzmeniCas;
    private javax.swing.JButton btnIzmeniPolaznik;
    private javax.swing.JButton btnObrisiCas;
    private javax.swing.JButton btnObrisiPolaznik;
    private javax.swing.JComboBox<Instruktor> cmbInstruktor;
    private javax.swing.JComboBox<Kategorija> cmbKategorija;
    private javax.swing.JComboBox<Polaznik> cmbPolaznik;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInstruktor;
    private javax.swing.JLabel lblIzmenaLozinke;
    private javax.swing.JMenu meniNalog;
    private javax.swing.JPanel panelGlavniAdmin;
    private javax.swing.JTable tblCasovi;
    private javax.swing.JTextField txtBrTel;
    private javax.swing.JTextField txtCenaObuke;
    private com.toedter.calendar.JDateChooser txtDatumRodj;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    public void refreshMainCmb(){
        instruktor=(Instruktor) cmbInstruktor.getSelectedItem();
        cmbPolaznik.removeAllItems();
        napuniCmbPolaznici(instruktor);
        
    }
    
    public void napuniCmbPolaznici(Instruktor instruktor){
        try {
            List<Polaznik> polaznici = KontrolerPolaznik.getList(instruktor);
            Collections.sort(polaznici, new Comparator<Polaznik>() {
            @Override
            public int compare(Polaznik p1, Polaznik p2) {
                return p1.getIme().compareTo(p2.getIme());
            }
        });
            for(Polaznik p : polaznici){
                cmbPolaznik.addItem(p);
            }
        } catch (SQLException ex) {
            System.out.println("greska sql");
        }
    }
    
    
    protected void setData(String selection) {
        lblIzmenaLozinke.setText(selection);
    }
    
    public void refreshMainTable() throws SQLException{
        TableModel tm = tblCasovi.getModel();
        DefaultTableModel dtm =(DefaultTableModel) tm;
        dtm.setRowCount(0);
        instruktor=(Instruktor) cmbInstruktor.getSelectedItem();
        Polaznik p = (Polaznik) cmbPolaznik.getSelectedItem();
        if(p!=null && instruktor!=null){
                
        List<StavkaEvidencijeCasa> stavke = KontrolerStavke.getList(p);
        for(StavkaEvidencijeCasa s: stavke){
            Object[] red = new Object[]{s.getRb(),s.getDatumCasa(),s.getVremePocetkaCasa()+"h",
                s.getVremeKrajaCasa()+"h",s.getTrajanjeCasa()+"min",s.getPlanObuke().getNaziv()};
            dtm.addRow(red);
        }
        }
    }

    private void napuniCmbKategorija() {
        try {
            List<Kategorija> kategorije = KontrolerKategorija.getList();
            for (Kategorija k : kategorije){
                cmbKategorija.addItem(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void napuniCmbInstruktor() {
        try {
            List<Instruktor> instruktori = KontrolerInstruktor.getList();
            for (Instruktor i : instruktori){
                cmbInstruktor.addItem(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GlavnaAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
