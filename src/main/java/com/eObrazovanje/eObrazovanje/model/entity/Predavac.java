package com.eObrazovanje.eObrazovanje.model.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import javax.persistence.*;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "predavaci")
public class Predavac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "predavac_id", unique = true, nullable = false)
    private Long predavac_id;

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

    @Column(name = "plata", unique = false, nullable = true)
    private String plata;

    @ManyToMany
    @JoinTable(
            name = "predmet_predavac",
            joinColumns = @JoinColumn(name = "predavac_id"),
            inverseJoinColumns = @JoinColumn(name = "predmet_id"))
    Set<Predmet> predmeti;



}
