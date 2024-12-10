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
                rs.getString("komentar"), rs.getString("status"),new PlanObuke(rs.getLong("idPlanObuke"), rs.getString("naziv"), rs.getString("opis"), rs.getInt("trajanje")));

            lista.add(stavka);
        }
        return lista;
    }
}
