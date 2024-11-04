/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import broker.DatabaseConnection;
import domen.Kategorija;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Windows HD
 */
public class KontrolerKategorija {
    public static List<Kategorija> getList() throws SQLException{
        List<Kategorija> lista = new LinkedList<>();
        String query = "SELECT id,naziv FROM kategorija";
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            Kategorija kategorija = new Kategorija(rs.getLong("id"), rs.getString("naziv"));
            lista.add(kategorija);
        }
        rs.close();
        st.close();
        conn.close();
        return lista;
    }
}
