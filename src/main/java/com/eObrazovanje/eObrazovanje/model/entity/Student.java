package com.eObrazovanje.eObrazovanje.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "studenti")
public class Student extends Korisnik{

    @Column(name = "godinaStudija", unique = false, nullable = false)
    private String godinaStudija;

    @Column(name = "godinaUpisa", unique = false, nullable = false)
    private String godinaUpisa;

    @Column(name = "statusStudenta", unique = false, nullable = false)
    private String statusStudenta;

    @Column(name = "budzet", unique = false, nullable = false)
    private Boolean budzet;

   // @Column(name = "istorijaStudiranja", unique = false, nullable = false)
    //private List istorijaStudiranja;

    @ManyToOne
    @JoinColumn(name = "smer_id")
    @JsonIgnore
    private Smer smer;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dokument> dokumenti = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kartica_id")
    private FinansijskaKartica kartica;


}
