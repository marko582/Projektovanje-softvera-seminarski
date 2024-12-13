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
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

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
    public static void delete(InsSer is) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        String query = "DELETE FROM insser WHERE idInstruktor="+is.getInstruktor().getId()+ " AND "
        + "idSertifikat ="+is.getSertifikat().getId();
        st.executeUpdate(query);
    }
}
