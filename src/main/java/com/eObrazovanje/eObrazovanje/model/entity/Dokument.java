package com.eObrazovanje.eObrazovanje.model.entity;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dokumenti")
public class Dokument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dokumenti_id", unique = true, nullable = false)
    private Long dokumenti_id;

    @Column(name = "naziv", unique = false, nullable = false)
    private String naziv;

    @OneToMany(mappedBy = "dokument", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fajl> fajlovi = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Student student;

    public Dokument() {
    }

    public Dokument(Long dokumenti_id, String naziv, List<Fajl> fajlovi, Student student) {
        this.dokumenti_id = dokumenti_id;
        this.naziv = naziv;
        this.fajlovi = fajlovi;
        this.student = student;
    }

    public Long getDokumenti_id() {
        return dokumenti_id;
    }

    public void setDokumenti_id(Long dokumenti_id) {
        this.dokumenti_id = dokumenti_id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Fajl> getFajlovi() {
        return fajlovi;
    }

    public void setFajlovi(List<Fajl> fajlovi) {
        this.fajlovi = fajlovi;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
