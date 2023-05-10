package com.eObrazovanje.eObrazovanje.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "korisnici")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "korisnik_id", unique = true, nullable = false)
    private Long korisnik_id;

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

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();
}
