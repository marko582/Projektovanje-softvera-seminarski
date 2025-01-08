/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import broker.DatabaseConnection;
import domen.Instruktor;
import domen.Polaznik;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Windows HD
 */
public class KontrolerInstruktor {
    public static List<Instruktor> getList() throws SQLException{ 
        List<Instruktor> lista = new LinkedList<>();
        String query = "SELECT * FROM instruktor WHERE status='zaposlen'";
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            Instruktor instruktor = new Instruktor(rs.getLong("id"), 
                    rs.getString("ime"), rs.getString("prezime"), 
                    rs.getString("email"), rs.getString("korisnickoIme"), 
                    rs.getString("lozinka"));
            lista.add(instruktor);
        }
        rs.close();
        st.close();
        conn.close();
        
        return lista;
    }
    public static void create(Instruktor i) throws SQLException{
            Connection conn = DatabaseConnection.getInstance();
            String query="INSERT INTO instruktor (ime,prezime,email,korisnickoIme,lozinka,datumIvremeRegistracije) "
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, i.getIme());
            ps.setString(2, i.getPrezime());
            ps.setString(3, i.getEmail());
            ps.setString(4, i.getKorisnickoIme());
            ps.setString(5, i.getLozinka());
            ps.setTimestamp(6,new java.sql.Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
            ps.close();
    }
    public static void update(Instruktor i) throws SQLException{
            Connection conn = DatabaseConnection.getInstance();
            String query="UPDATE instruktor SET ime ='"+i.getIme()+"',prezime ='"+i.getPrezime()+"',"
            + "email ='"+i.getEmail()+"',korisnickoIme ='"+i.getKorisnickoIme()+"' WHERE id ="+i.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            st.close();
    }
    public static void otkaz(Instruktor i) throws SQLException{
            Connection conn = DatabaseConnection.getInstance();
            String query="UPDATE instruktor SET status ='otkaz' WHERE id ="+i.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            st.close();
    }
    
    public static void updateLozinka(Instruktor i,String novaLozinka) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        String query="UPDATE instruktor SET lozinka ='"+novaLozinka+
        "',promenioLozinku=1 WHERE id ="+i.getId();
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        st.close();
    }
    
    public static Instruktor getInstruktorPolaznika(Polaznik p) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        String query = "SELECT idInstruktor FROM evidencijacasa WHERE idPolaznika="+p.getId();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        Long idInstruktor = 0l;
        if(rs.next())
            idInstruktor = rs.getLong(1);
        else
            return null;
        query = "SELECT * FROM instruktor WHERE id="+idInstruktor;
        st=conn.createStatement();
        rs=st.executeQuery(query);
        if(rs.next()){
            Instruktor instruktor = new Instruktor(rs.getLong("id"), 
                    rs.getString("ime"), rs.getString("prezime"), 
                    rs.getString("email"), rs.getString("korisnickoIme"), 
                    rs.getString("lozinka"));
            return instruktor;
        }
        else{
            return null;
        }
    }
}
