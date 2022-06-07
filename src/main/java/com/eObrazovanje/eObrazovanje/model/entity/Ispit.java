package com.eObrazovanje.eObrazovanje.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "ispiti")
public class Ispit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ispit_id", unique = true, nullable = false)
    private Long ispit_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "predmet_id")
    private Predmet predmet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rokovi_id")
    private IspitniRok rokovi;

    public Ispit() {
    }

    public Ispit(Long ispit_id, Predmet predmet, IspitniRok rokovi) {
        this.ispit_id = ispit_id;
        this.predmet = predmet;
        this.rokovi = rokovi;
    }

    public Long getIspit_id() {
        return ispit_id;
    }

    public void setIspit_id(Long ispit_id) {
        this.ispit_id = ispit_id;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public IspitniRok getRokovi() {
        return rokovi;
    }

    public void setRokovi(IspitniRok rokovi) {
        this.rokovi = rokovi;
    }
}
