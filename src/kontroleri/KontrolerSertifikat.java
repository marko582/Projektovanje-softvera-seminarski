/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import broker.DatabaseConnection;
import domen.Instruktor;
import domen.Sertifikat;
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
public class KontrolerSertifikat {
    public static List<Sertifikat> getList() throws SQLException{
        List<Sertifikat> lista = new LinkedList<>();
        String query = "SELECT * FROM sertifikat";
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            Sertifikat s = new Sertifikat(rs.getLong("id"), rs.getString("naziv"));
            lista.add(s);
        }
        rs.close();
        st.close();
        conn.close();
        return lista;
    }
    
    public static List<Sertifikat> getList(Instruktor i) throws SQLException{
        List<Sertifikat> lista = new LinkedList<>();
        String query = "SELECT * FROM sertifikat JOIN insser ON sertifikat.id=insser.idSertifikat WHERE insser.idInstruktor="
                +i.getId();
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            Sertifikat s = new Sertifikat(rs.getLong("id"), rs.getString("naziv"));
            lista.add(s);
        }
        rs.close();
        st.close();
        conn.close();
        return lista;
    }
}
