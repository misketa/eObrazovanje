package com.eObrazovanje.eObrazovanje.model.entity;

import lombok.*;


import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admini")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id", unique = true, nullable = false)
    private Long admin_id;

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

    @Column(name = "plata", unique = false, nullable = false)
    private String plata;

}
