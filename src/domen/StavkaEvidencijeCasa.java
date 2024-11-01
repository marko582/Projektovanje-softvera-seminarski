/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Windows HD
 */
public class StavkaEvidencijeCasa {
    private Long id;
    private Long rb;
    private Date datumCasa;
    private LocalTime vremePocetkaCasa;
    private LocalTime vremeKrajaCasa;
    private LocalTime trajanjeCasa;
    private Integer cenaCasa;
    private String komentar;
    private PlanObuke planObuke;

    public StavkaEvidencijeCasa(Long id, Long rb, Date datumCasa, LocalTime vremePocetkaCasa, LocalTime vremeKrajaCasa, LocalTime trajanjeCasa, Integer cenaCasa, String komentar, PlanObuke planObuke) {
        this.id = id;
        this.rb = rb;
        this.datumCasa = datumCasa;
        this.vremePocetkaCasa = vremePocetkaCasa;
        this.vremeKrajaCasa = vremeKrajaCasa;
        this.trajanjeCasa = trajanjeCasa;
        this.cenaCasa = cenaCasa;
        this.komentar = komentar;
        this.planObuke = planObuke;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRb() {
        return rb;
    }

    public void setRb(Long rb) {
        this.rb = rb;
    }

    public Date getDatumCasa() {
        return datumCasa;
    }

    public void setDatumCasa(Date datumCasa) {
        this.datumCasa = datumCasa;
    }

    public LocalTime getVremePocetkaCasa() {
        return vremePocetkaCasa;
    }

    public void setVremePocetkaCasa(LocalTime vremePocetkaCasa) {
        this.vremePocetkaCasa = vremePocetkaCasa;
    }

    public LocalTime getVremeKrajaCasa() {
        return vremeKrajaCasa;
    }

    public void setVremeKrajaCasa(LocalTime vremeKrajaCasa) {
        this.vremeKrajaCasa = vremeKrajaCasa;
    }

    public LocalTime getTrajanjeCasa() {
        return trajanjeCasa;
    }

    public void setTrajanjeCasa(LocalTime trajanjeCasa) {
        this.trajanjeCasa = trajanjeCasa;
    }

    public Integer getCenaCasa() {
        return cenaCasa;
    }

    public void setCenaCasa(Integer cenaCasa) {
        this.cenaCasa = cenaCasa;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public PlanObuke getPlanObuke() {
        return planObuke;
    }

    public void setPlanObuke(PlanObuke planObuke) {
        this.planObuke = planObuke;
    }
    
    
}
