package com.eObrazovanje.eObrazovanje.model.entity;

import lombok.*;

import javax.persistence.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dokumenti")
public class Dokument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dokumenti_id", unique = true, nullable = false)
    private Long dokumenti_id;

    @Column(name = "naziv", unique = false, nullable = false)
    private String naziv;

    @Column(name = "url")
    private String url;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fajl_id", referencedColumnName = "fajl_id")
    private Fajl fajl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @Column(name = "blocked", unique = false, nullable = false)
    private boolean blocked;


}
