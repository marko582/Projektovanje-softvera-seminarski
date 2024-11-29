/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.util.List;

/**
 *
 * @author Windows HD
 */
public class EvidencijaCasa {
    private Long id;
    private Integer ukupnaCena;
    private Instruktor instruktor;
    private Polaznik polaznik;

    public EvidencijaCasa(Long id, Integer ukupnaCena, Instruktor instruktor, Polaznik polaznik, List<StavkaEvidencijeCasa> stavke) {
        this.id = id;
        this.ukupnaCena = ukupnaCena;
        this.instruktor = instruktor;
        this.polaznik = polaznik;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(Integer ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Instruktor getInstruktor() {
        return instruktor;
    }

    public void setInstruktor(Instruktor instruktor) {
        this.instruktor = instruktor;
    }

    public Polaznik getPolaznik() {
        return polaznik;
    }

    public void setPolaznik(Polaznik polaznik) {
        this.polaznik = polaznik;
    }

    
    
    
}
