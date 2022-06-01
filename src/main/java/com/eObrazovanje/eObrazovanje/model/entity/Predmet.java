package com.eObrazovanje.eObrazovanje.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

}
