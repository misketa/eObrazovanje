package com.eObrazovanje.eObrazovanje.model.entity;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "fajlovi")
public class Fajl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fajl_id", unique = true, nullable = false)
    private Long fajl_id;

    @Column(name = "naziv", unique = false, nullable = false)
    private String naziv;

    @ManyToOne
    @JoinColumn(name = "dokument_id")
    @JsonIgnore
    private Dokument dokument;

    public Fajl() {
    }

    public Fajl(Long fajl_id, String naziv, Dokument dokument) {
        this.fajl_id = fajl_id;
        this.naziv = naziv;
        this.dokument = dokument;
    }

    public Long getFajl_id() {
        return fajl_id;
    }

    public void setFajl_id(Long fajl_id) {
        this.fajl_id = fajl_id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Dokument getDokument() {
        return dokument;
    }

    public void setDokument(Dokument dokument) {
        this.dokument = dokument;
    }
}
