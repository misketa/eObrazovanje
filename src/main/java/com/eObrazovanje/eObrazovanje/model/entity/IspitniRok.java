package com.eObrazovanje.eObrazovanje.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rokovi")
public class IspitniRok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rokovi_id", unique = true, nullable = false)
    private Long rokovi_id;

    @Column(name = "naziv", unique = false, nullable = false)
    private String naziv;

    @Column(name = "listIspita", unique = false, nullable = false)
    private List listaIspita;

    @OneToOne(mappedBy = "rokovi")
    private Ispit ispit;

    public IspitniRok() {
    }

    public IspitniRok(Long rokovi_id, String naziv, List listaIspita, Ispit ispit) {
        this.rokovi_id = rokovi_id;
        this.naziv = naziv;
        this.listaIspita = listaIspita;
        this.ispit = ispit;
    }

    public Long getRokovi_id() {
        return rokovi_id;
    }

    public void setRokovi_id(Long rokovi_id) {
        this.rokovi_id = rokovi_id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List getListaIspita() {
        return listaIspita;
    }

    public void setListaIspita(List listaIspita) {
        this.listaIspita = listaIspita;
    }

    public Ispit getIspit() {
        return ispit;
    }

    public void setIspit(Ispit ispit) {
        this.ispit = ispit;
    }
}
