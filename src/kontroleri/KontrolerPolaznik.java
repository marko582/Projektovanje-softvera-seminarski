/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import broker.DatabaseConnection;
import domen.Instruktor;
import domen.Kategorija;
import domen.Polaznik;
import java.util.List;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

/**
 *
 * @author Windows HD
 */
public class KontrolerPolaznik {
    //vraca sve polaznike
    public static List<Polaznik> getList() throws SQLException{
        List<Polaznik> lista = new LinkedList<>();
        String query = "SELECT polaznik.id,polaznik.ime,polaznik.prezime,polaznik.email,"
        + "polaznik.brojTelefona,polaznik.datumRodjenja,polaznik.idKategorija,kategorija.naziv FROM polaznik "
        + "JOIN kategorija ON (polaznik.idKategorija=kategorija.id) AND polaznik.status='upisan'"
        + " ORDER BY polaznik.prezime";
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
    //vraca sve polaznike koji su kod prosledjenog instruktora
    public static List<Polaznik> getList(Instruktor i) throws SQLException{
        List<Polaznik> lista = new LinkedList<>();
        String query = "SELECT polaznik.id,polaznik.ime,polaznik.prezime,polaznik.email,"
        + "polaznik.brojTelefona,polaznik.datumRodjenja,polaznik.idKategorija,kategorija.naziv FROM polaznik "
        + "JOIN kategorija ON (polaznik.idKategorija=kategorija.id) JOIN evidencijacasa ON evidencijacasa.idPolaznika="
        + "polaznik.id JOIN instruktor ON evidencijacasa.idInstruktor=instruktor.id WHERE instruktor.id="+i.getId()
                +" AND polaznik.status='upisan'";
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
    public static Long createGetId(Polaznik p) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        String query="INSERT INTO polaznik (ime,prezime,email,brojTelefona,datumRodjenja,idKategorija) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, p.getIme());
        ps.setString(2, p.getPrezime());
        ps.setString(3, p.getEmail());
        ps.setString(4, p.getBrojTelefona());
        ps.setDate(5, new java.sql.Date(((java.util.Date)p.getDatumRodjenja()).getTime()));
        ps.setLong(6, p.getKategorija().getId());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        rs.next();
        return rs.getLong(1);
    }
    
    public static void update(Polaznik p) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        java.util.Date datum = p.getDatumRodjenja();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formatiranDatum = sdf.format(datum);
        String query = "UPDATE polaznik SET ime='"+p.getIme()+"',prezime='"+p.getPrezime()+
        "',email='"+p.getEmail()+"',brojTelefona='"+p.getBrojTelefona()+
        "',datumRodjenja='"+formatiranDatum+"',idKategorija="
        +p.getKategorija().getId()
        + " WHERE id="+p.getId();
        st.executeUpdate(query);
        st.close();
    }
    
    public static void ispisi(Polaznik p) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        String query = "UPDATE polaznik SET STATUS='ispisan' WHERE id="+p.getId();
        st.executeUpdate(query);
        st.close();
    }
}
