package com.eObrazovanje.eObrazovanje.model.entity;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studenti")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", unique = true, nullable = false)
    private Long student_id;

    @Column(name = "ime", unique = false, nullable = false)
    private String ime;

    @Column(name = "prezime", unique = false , nullable = false)
    private String prezime;

    @Column(name = "jmbg", unique = true, nullable = false)
    private String jmbg;

    @Column(name = "telefon", unique = false, nullable = false)
    private String telefon;

    @Column(name = "godinaStudija", unique = false, nullable = false)
    private String godinaStudija;

    @Column(name = "godinaUpisa", unique = false, nullable = false)
    private String godinaUpisa;

    @Column(name = "statusStudenta", unique = false, nullable = false)
    private String statusStudenta;

    @Column(name = "budzet", unique = false, nullable = false)
    private Boolean budzet;

    @Column(name = "istorijaStudiranja", unique = false, nullable = false)
    private List istorijaStudiranja;

    @ManyToOne
    @JoinColumn(name = "smer_id")
    @JsonIgnore
    private Smer smer;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dokument> dokumenti = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kartica_id", referencedColumnName = "id")
    private FinansijskaKartica kartica;

    public Student() {
    }

    public Student(Long student_id, String ime, String prezime, String jmbg, String telefon, String godinaStudija, String godinaUpisa, String statusStudenta, Boolean budzet, List istorijaStudiranja, Smer smer, List<Dokument> dokumenti, FinansijskaKartica kartica) {
        this.student_id = student_id;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.telefon = telefon;
        this.godinaStudija = godinaStudija;
        this.godinaUpisa = godinaUpisa;
        this.statusStudenta = statusStudenta;
        this.budzet = budzet;
        this.istorijaStudiranja = istorijaStudiranja;
        this.smer = smer;
        this.dokumenti = dokumenti;
        this.kartica = kartica;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
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

    public String getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public String getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(String godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }

    public String getStatusStudenta() {
        return statusStudenta;
    }

    public void setStatusStudenta(String statusStudenta) {
        this.statusStudenta = statusStudenta;
    }

    public Boolean getBudzet() {
        return budzet;
    }

    public void setBudzet(Boolean budzet) {
        this.budzet = budzet;
    }

    public Smer getSmer() {
        return smer;
    }

    public void setSmer(Smer smer) {
        this.smer = smer;
    }

    public List<Dokument> getDokumenti() {
        return dokumenti;
    }

    public void setDokumenti(List<Dokument> dokumenti) {
        this.dokumenti = dokumenti;
    }

    public List getIstorijaStudiranja() {
        return istorijaStudiranja;
    }

    public void setIstorijaStudiranja(List istorijaStudiranja) {
        this.istorijaStudiranja = istorijaStudiranja;
    }

    public FinansijskaKartica getKartica() {
        return kartica;
    }

    public void setKartica(FinansijskaKartica kartica) {
        this.kartica = kartica;
    }
}
