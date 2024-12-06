/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import broker.DatabaseConnection;
import domen.Instruktor;
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
}
