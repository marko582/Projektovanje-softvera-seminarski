/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import broker.DatabaseConnection;
import domen.InsSer;
import domen.Instruktor;
import domen.Sertifikat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Windows HD
 */
public class KontrolerInsSer {
    public static void create(InsSer is) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        String query = "INSERT INTO insser (idInstruktor, idSertifikat, datumIzdavanja) " +
        "VALUES ('"+is.getInstruktor().getId()+"', '"+is.getSertifikat().getId()+"','"+Date.valueOf(LocalDate.now())+"')";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        st.close();
    }
    public static void create(Instruktor ins, Sertifikat ser) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        String query = "INSERT INTO insser (idInstruktor, idSertifikat, datumIzdavanja) " +
        "VALUES ('"+ins.getId()+"', '"+ser.getId()+"','"+Date.valueOf(LocalDate.now())+"')";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        st.close();
    }
    public static void createAdmin(Instruktor ins, List<Sertifikat> sertifikati) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        String query="INSERT INTO instruktor (ime,prezime,email,korisnickoIme,lozinka,datumIvremeRegistracije,promenioLozinku) "
                + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, ins.getIme());
        ps.setString(2, ins.getPrezime());
        ps.setString(3, ins.getEmail());
        ps.setString(4, ins.getKorisnickoIme());
        ps.setString(5, ins.getLozinka());
        ps.setTimestamp(6,new java.sql.Timestamp(System.currentTimeMillis()));
        ps.setInt(7, 1);
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        rs.next();
        Long id = rs.getLong(1);
        ins.setId(id);
        for(Sertifikat s:sertifikati){
            query = "INSERT INTO insser (idInstruktor, idSertifikat, datumIzdavanja) " +
            "VALUES ('"+ins.getId()+"', '"+s.getId()+"','"+Date.valueOf(LocalDate.now())+"')";
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        }
    }
    public static void delete(InsSer is) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        String query = "DELETE FROM insser WHERE idInstruktor="+is.getInstruktor().getId()+ " AND "
        + "idSertifikat ="+is.getSertifikat().getId();
        st.executeUpdate(query);
    }
}
