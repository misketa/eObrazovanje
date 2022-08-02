package com.eObrazovanje.eObrazovanje.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "studenti")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", unique = true, nullable = false)
    private Long student_id;

    @Column(name = "korisnickoIme", unique = true, nullable = false)
    private String korisnickoIme;

    @Column(name = "lozinka", unique = false, nullable = false)
    private String lozinka;

    @Column(name = "ime", unique = false, nullable = false)
    private String ime;

    @Column(name = "prezime", unique = false, nullable = false)
    private String prezime;

    @Column(name = "jmbg", unique = true, nullable = false)
    private String jmbg;

    @Column(name = "telefon", unique = false, nullable = false)
    private String telefon;

    @Column(name = "blocked", unique = false, nullable = false)
    private boolean blocked;

    @Column(name = "godinaStudija", unique = false, nullable = false)
    private String godinaStudija;

    @Column(name = "godinaUpisa", unique = false, nullable = false)
    private String godinaUpisa;

    @Column(name = "statusStudenta", unique = false, nullable = false)
    private String statusStudenta;

    @Column(name = "budzet", unique = false)
    private Boolean budzet;

    //@Column(name = "istorijaStudiranja", unique = false, nullable = false)
    //private List istorijaStudiranja;

    @ManyToOne
    @JoinColumn(name = "smer_id", nullable = true)
    @JsonIgnore
    private Smer smer;

    //@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Dokument> dokumenti = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kartica_id", nullable = true)
    private FinansijskaKartica kartica;




}
