/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

/**
 *
 * @author Windows HD
 */
public class ProjektovanjeSoftvera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatMacLightLaf.setup();
        new Login().setVisible(true);
    }
    
}
