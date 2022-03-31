package com.eObrazovanje.eObrazovanje.model.entity;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "predmeti")
public class Predmet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "predmet_id", unique = true, nullable = false)
    private Long predmet_id;

    @Column(name = "naziv", unique = false, nullable = false)
    private String naziv;

    @Column(name = "semestar", unique = false , nullable = false)
    private String semestar;

    @Column(name = "espb", unique = true, nullable = false)
    private String espb;

    @Column(name = "opis", unique = true, nullable = false)
    private String opis;

    @ManyToOne
    @JoinColumn(name = "smer_id")
    @JsonIgnore
    private Smer smer;

    @ManyToMany(mappedBy = "likedPredmet")
    Set<Predavac> likes;

    @OneToOne(mappedBy = "predmet")
    private Ispit ispit;

    @OneToMany(mappedBy = "predmet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PredispitneObaveze> predispitne = new ArrayList<>();

    public Predmet() {
    }

    public Predmet(Long predmet_id, String naziv, String semestar, String espb, String opis, Smer smer, Set<Predavac> likes, Ispit ispit, List<PredispitneObaveze> predispitne) {
        this.predmet_id = predmet_id;
        this.naziv = naziv;
        this.semestar = semestar;
        this.espb = espb;
        this.opis = opis;
        this.smer = smer;
        this.likes = likes;
        this.ispit = ispit;
        this.predispitne = predispitne;
    }

    public Long getPredmet_id() {
        return predmet_id;
    }

    public void setPredmet_id(Long predmet_id) {
        this.predmet_id = predmet_id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSemestar() {
        return semestar;
    }

    public void setSemestar(String semestar) {
        this.semestar = semestar;
    }

    public String getEspb() {
        return espb;
    }

    public void setEspb(String espb) {
        this.espb = espb;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Smer getSmer() {
        return smer;
    }

    public void setSmer(Smer smer) {
        this.smer = smer;
    }

    public Set<Predavac> getLikes() {
        return likes;
    }

    public void setLikes(Set<Predavac> likes) {
        this.likes = likes;
    }

    public Ispit getIspit() {
        return ispit;
    }

    public void setIspit(Ispit ispit) {
        this.ispit = ispit;
    }

    public List<PredispitneObaveze> getPredispitne() {
        return predispitne;
    }

    public void setPredispitne(List<PredispitneObaveze> predispitne) {
        this.predispitne = predispitne;
    }
}
