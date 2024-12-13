/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import broker.DatabaseConnection;
import domen.PlanObuke;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Windows HD
 */
public class KontrolerPlanObuke {
    public static List<PlanObuke> getList() throws SQLException{
        List<PlanObuke> lista = new LinkedList<>();
        String query = "SELECT id,naziv,opis FROM planobuke";
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            PlanObuke po = new PlanObuke(rs.getLong("id"), rs.getString("naziv"), rs.getString("opis"));
            lista.add(po);
        }
        rs.close();
        st.close();
        conn.close();
        return lista;
    }
    public static void create(PlanObuke plan) throws SQLException{  
        Connection conn = DatabaseConnection.getInstance();
        String query="INSERT INTO planobuke (naziv,opis) VALUES (?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, plan.getNaziv());
        ps.setString(2, plan.getOpis());
        ps.executeUpdate();
        ps.close();
    }
    public static void update(PlanObuke plan) throws SQLException{
        Connection conn = DatabaseConnection.getInstance();
        Statement st = conn.createStatement();
        String query = "UPDATE planobuke SET naziv='"+plan.getNaziv()+"'" +",opis='"+plan.getOpis()
                +"' WHERE id="+plan.getId();
        st.executeUpdate(query);
        st.close();
    }
}
