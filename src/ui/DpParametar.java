/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import domen.Polaznik;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

/**
 *
 * @author Windows HD
 */
public class DpParametar extends DodavanjePolaznika{
    Glavna parent;
    
    public DpParametar(Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        addWindowListener(closer);
    }
    
    private WindowListener closer = new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
//            parent.setData("uspeh");
            Polaznik p = vratiPolaznika();
            System.out.println("iz dpp polaznik je:\n"+p);
        }
        
    };
    
}
