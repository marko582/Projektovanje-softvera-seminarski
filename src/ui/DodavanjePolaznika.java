/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;
import broker.DatabaseConnection;
import domen.Instruktor;
import domen.Kategorija;
import domen.Polaznik;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroleri.KontrolerInstruktor;
import kontroleri.KontrolerKategorija;

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
        List<Kategorija> kategorije = KontrolerKategorija.getList();
        for (Kategorija k : kategorije){
            cmbKategorija.addItem(k);
        }
        List<Instruktor> instruktori = KontrolerInstruktor.getList();
        for (Instruktor i : instruktori){
            cmbInstruktori.addItem(i);
        }
        cmbInstruktori.setSelectedItem(null);
        cmbKategorija.setSelectedItem(null);
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
        jButton2 = new javax.swing.JButton();

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

        jButton2.setText("Dodaj");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel4);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            dodajPolaznika();
        } catch (SQLException ex) {
            Logger.getLogger(DodavanjePolaznika.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Instruktor> cmbInstruktori;
    private javax.swing.JComboBox<Kategorija> cmbKategorija;
    private javax.swing.JButton jButton2;
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
        Connection conn = DatabaseConnection.getInstance();
        String query="INSERT INTO polaznik (ime,prezime,email,brojTelefona,datumRodjenja,idKategorija) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
        Long idKategorija=0l;
        String query2="SELECT id FROM kategorija WHERE naziv='"+cmbKategorija.getSelectedItem()+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query2);
        rs.next();
        idKategorija=rs.getLong(1);
        ps.setString(1, txtIme.getText());
        ps.setString(2, txtPrezime.getText());
        ps.setString(3, txtEmail.getText());
        ps.setString(4, txtBrTel.getText());
        ps.setDate(5, new java.sql.Date(((java.util.Date)txtDatumRodj.getDate()).getTime()));
        ps.setLong(6, idKategorija);
        ps.executeUpdate();
        
        rs=ps.getGeneratedKeys();
        rs.next();
        Long idPolaznik=rs.getLong(1);
        this.polaznikId=idPolaznik;
        ps.close();
        Instruktor instruktor = (Instruktor) cmbInstruktori.getSelectedItem();
        String query3="INSERT INTO evidencijacasa (idInstruktor,idPolaznika) VALUES ("+instruktor.getId()+","
                +idPolaznik+")";
        
        st.executeUpdate(query3);
        Object[] opcije = {"Da", "Ne"};
        int izbor = JOptionPane.showOptionDialog(this,"Uspesno dodat polaznik."
                + " Da li zelite da dodate jos jednog polaznika?","Dodavanje polaznika",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcije,opcije[0]);
        
        st.close();
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
    protected Polaznik vratiPolaznika(){
        Polaznik p = new Polaznik(polaznikId, txtIme.getText(), 
                txtPrezime.getText(), txtEmail.getText(), txtBrTel.getText(), 
                txtDatumRodj.getDate(), (Kategorija) cmbKategorija.getSelectedItem());
        
        return p;
    }
}
