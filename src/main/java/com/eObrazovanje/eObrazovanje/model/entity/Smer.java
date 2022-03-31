package com.eObrazovanje.eObrazovanje.model.entity;

import com.eObrazovanje.eObrazovanje.model.entity.Predmet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "smerovi")
public class Smer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "smer_id", unique = true, nullable = false)
    private Long smer_id;

    @Column(name = "naziv", unique = false, nullable = false)
    private String naziv;

    @OneToMany(mappedBy = "smer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Predmet> predmeti = new ArrayList<>();

    @OneToMany(mappedBy = "smer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> studenti = new ArrayList<>();

    public Smer() {
    }

    public Smer(Long smer_id, String naziv, List<Predmet> predmeti, List<Student> studenti) {
        this.smer_id = smer_id;
        this.naziv = naziv;
        this.predmeti = predmeti;
        this.studenti = studenti;
    }

    public Long getSmer_id() {
        return smer_id;
    }

    public void setSmer_id(Long smer_id) {
        this.smer_id = smer_id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(List<Predmet> predmeti) {
        this.predmeti = predmeti;
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Student> studenti) {
        this.studenti = studenti;
    }
}
