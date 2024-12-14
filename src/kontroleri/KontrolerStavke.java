/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import broker.DatabaseConnection;
import domen.Instruktor;
import domen.PlanObuke;
import domen.Polaznik;
import domen.StavkaEvidencijeCasa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Windows HD
 */
public class KontrolerStavke {
    public static List<StavkaEvidencijeCasa> getList(Instruktor i, Polaznik p) throws SQLException{
        List<StavkaEvidencijeCasa> lista = new LinkedList<>();
        Connection conn = DatabaseConnection.getInstance();
        String query="SELECT * FROM stavkaevidencijecasa JOIN planobuke ON planobuke.id=stavkaevidencijecasa.idPlanObuke JOIN evidencijacasa ON evidencijacasa.id=stavkaevidencijecasa.id JOIN instruktor \n" +
                "ON  evidencijacasa.idInstruktor=instruktor.id JOIN polaznik ON polaznik.id=evidencijacasa.idPolaznika \n" +
                "WHERE instruktor.id=? AND polaznik.id=? AND stavkaevidencijecasa.status='zakazan'";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, i.getId());
        ps.setLong(2, p.getId());
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            StavkaEvidencijeCasa stavka = new StavkaEvidencijeCasa
                (rs.getLong("id"), rs.getLong("rb"), rs.getDate("datumCasa"), rs.getTime("vremePocetkaCasa").toLocalTime(),
                rs.getTime("vremeKrajaCasa").toLocalTime(), rs.getInt("trajanjeCasa"),
                rs.getString("komentar"), rs.getString("status"),new PlanObuke(rs.getLong("idPlanObuke"), rs.getString("naziv"), rs.getString("opis")));

            lista.add(stavka);
        }
        return lista;
    }
    public static void create(StavkaEvidencijeCasa cas) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        String query="INSERT INTO stavkaevidencijecasa" +
        "(id, rb, datumCasa, vremePocetkaCasa, vremeKrajaCasa,trajanjeCasa, komentar, idPlanObuke)" +
        "VALUES (?,?,?,?,?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, cas.getId());
        ps.setLong(2, cas.getRb());
        ps.setDate(3, new java.sql.Date(cas.getDatumCasa().getTime()));
        ps.setTime(4, Time.valueOf(cas.getVremePocetkaCasa()));
        ps.setTime(5, Time.valueOf(cas.getVremeKrajaCasa()));
        ps.setInt(6, Integer.valueOf(String.valueOf(Duration.between(cas.getVremePocetkaCasa(),cas.getVremeKrajaCasa() ).toMinutes())));
        ps.setString(7, cas.getKomentar());
        ps.setLong(8, cas.getPlanObuke().getId());
        ps.executeUpdate();
        ps.close();
    }
    public static void update(StavkaEvidencijeCasa cas) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        String query = "UPDATE stavkaevidencijecasa SET datumCasa ='"+cas.getDatumCasa()+"',"+
        "vremePocetkaCasa='"+cas.getVremePocetkaCasa() +"'," +
        "vremeKrajaCasa='"+cas.getVremeKrajaCasa()+"'," +
        "trajanjeCasa='"+Integer.valueOf(String.valueOf(Duration.between(cas.getVremePocetkaCasa(), cas.getVremeKrajaCasa()).toMinutes()))+"', " +
        "komentar='"+cas.getKomentar()+"'," +
        "idPlanObuke='"+cas.getPlanObuke().getId()+"' WHERE id="+
        cas.getId()+" AND rb="+cas.getRb();
        st.executeUpdate(query);
        st.close();
    }
    public static void otkazi(StavkaEvidencijeCasa cas) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        String query = "UPDATE stavkaevidencijecasa SET status = 'otkazan' WHERE id="+
            cas.getId()+" AND rb="+cas.getRb();
        st.executeUpdate(query);     
        st.close();
    }
    public static Long getRb(Long id) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        String query = "SELECT MAX(rb) FROM stavkaevidencijecasa" +
        " WHERE id = "+id+
        " GROUP BY id";
        ResultSet rs = st.executeQuery(query);
        rs.next();
        return rs.getLong(1);
    }
}
