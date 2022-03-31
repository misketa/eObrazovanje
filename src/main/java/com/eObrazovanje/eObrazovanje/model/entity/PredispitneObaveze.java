package com.eObrazovanje.eObrazovanje.model.entity;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "predisipitne")
public class PredispitneObaveze {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "predispitne_id", unique = true, nullable = false)
    private Long predispitne_id;

    @Column(name = "bodovi", unique = false, nullable = false)
    private String bodovi;

    @Column(name = "obavezna", unique = false, nullable = false)
    private Boolean obavezna;

    @Column(name = "vrstaObaveze", unique = false, nullable = false)
    private String vrstaObaveze;

    @ManyToOne
    @JoinColumn(name = "predmet_id")
    @JsonIgnore
    private Predmet predmet;

    public PredispitneObaveze() {
    }

    public PredispitneObaveze(Long predispitne_id, String bodovi, Boolean obavezna, String vrstaObaveze, Predmet predmet) {
        this.predispitne_id = predispitne_id;
        this.bodovi = bodovi;
        this.obavezna = obavezna;
        this.vrstaObaveze = vrstaObaveze;
        this.predmet = predmet;
    }

    public Long getPredispitne_id() {
        return predispitne_id;
    }

    public void setPredispitne_id(Long predispitne_id) {
        this.predispitne_id = predispitne_id;
    }

    public String getBodovi() {
        return bodovi;
    }

    public void setBodovi(String bodovi) {
        this.bodovi = bodovi;
    }

    public Boolean getObavezna() {
        return obavezna;
    }

    public void setObavezna(Boolean obavezna) {
        this.obavezna = obavezna;
    }

    public String getVrstaObaveze() {
        return vrstaObaveze;
    }

    public void setVrstaObaveze(String vrstaObaveze) {
        this.vrstaObaveze = vrstaObaveze;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }
}
