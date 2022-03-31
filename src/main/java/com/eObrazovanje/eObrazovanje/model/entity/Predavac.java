package com.eObrazovanje.eObrazovanje.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "predavaci")
public class Predavac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "predavac_id", unique = true, nullable = false)
    private Long predavac_id;

    @Column(name = "ime", unique = false, nullable = false)
    private String ime;

    @Column(name = "prezime", unique = false , nullable = false)
    private String prezime;

    @Column(name = "jmbg", unique = true, nullable = false)
    private String jmbg;

    @Column(name = "telefon", unique = false, nullable = false)
    private String telefon;

    @Column(name = "plata", unique = true, nullable = false)
    private String plata;

    @ManyToMany
    @JoinTable(
            name = "predmet_like",
            joinColumns = @JoinColumn(name = "predavac_id"),
            inverseJoinColumns = @JoinColumn(name = "predmet_id"))
    Set<Predmet> likedPredmet;

    public Predavac() {
    }

    public Predavac(Long predavac_id, String ime, String prezime, String jmbg, String telefon, String plata, Set<Predmet> likedPredmet) {
        this.predavac_id = predavac_id;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.telefon = telefon;
        this.plata = plata;
        this.likedPredmet = likedPredmet;
    }

    public Long getPredavac_id() {
        return predavac_id;
    }

    public void setPredavac_id(Long predavac_id) {
        this.predavac_id = predavac_id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPlata() {
        return plata;
    }

    public void setPlata(String plata) {
        this.plata = plata;
    }

    public Set<Predmet> getLikedPredmet() {
        return likedPredmet;
    }

    public void setLikedPredmet(Set<Predmet> likedPredmet) {
        this.likedPredmet = likedPredmet;
    }
}
