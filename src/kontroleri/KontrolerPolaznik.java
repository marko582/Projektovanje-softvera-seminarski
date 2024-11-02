/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import broker.DatabaseConnection;
import domen.Kategorija;
import domen.Polaznik;
import java.util.List;
import java.sql.*;
import java.util.LinkedList;

/**
 *
 * @author Windows HD
 */
public class KontrolerPolaznik {
    
    public static List<Polaznik> getList() throws SQLException{
        List<Polaznik> lista = new LinkedList<>();
        String query = "SELECT polaznik.id,polaznik.ime,polaznik.prezime,polaznik.email,"
        + "polaznik.brojTelefona,polaznik.datumRodjenja,polaznik.idKategorija,kategorija.naziv FROM polaznik "
        + "JOIN kategorija ON (polaznik.idKategorija=kategorija.id)";
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){

            
            Kategorija kategorija = new Kategorija(rs.getLong("idKategorija"), rs.getString("naziv"));
            Polaznik polaznik = new Polaznik(rs.getLong("id"),
            rs.getString("ime"),rs.getString("prezime"),
            rs.getString("email"),rs.getString("brojTelefona"),
            rs.getDate("datumRodjenja"),kategorija);
            lista.add(polaznik);
        }
        rs.close();
        st.close();
        conn.close();
        return lista;
    }
}
