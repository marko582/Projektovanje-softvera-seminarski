/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import broker.DatabaseConnection;
import domen.EvidencijaCasa;
import domen.Instruktor;
import domen.Polaznik;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Windows HD
 */
public class KontrolerEvidencija {
    public static Long getId(Instruktor i, Polaznik p) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        String query="SELECT id FROM evidencijacasa WHERE idInstruktor="+i.getId()+" AND idPolaznika="+p.getId();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        return rs.getLong(1);
    }
    public static Integer getCenaObuke(Polaznik p) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        String query="SELECT ukupnaCena FROM evidencijacasa WHERE idPolaznika="+p.getId();
        Statement st = conn.createStatement();
        ResultSet rs=st.executeQuery(query);
        Integer cenaObuke = 0;
        if(rs.next()){
            cenaObuke=rs.getInt(1);
        }
        return cenaObuke;
    }
    public static void create(EvidencijaCasa evc) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        String query="INSERT INTO evidencijacasa (idInstruktor,idPolaznika,ukupnaCena) VALUES ("+evc.getInstruktor().getId()+","
        +evc.getPolaznik().getId()+","+ evc.getUkupnaCena() +")";
        st.executeUpdate(query);
        st.close();
    }
}
