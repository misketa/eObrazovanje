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
@Table(name = "dokumenti")
public class Dokument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dokumenti_id", unique = true, nullable = false)
    private Long dokumenti_id;

    @Column(name = "naziv", unique = false, nullable = false)
    private String naziv;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fajl_id", referencedColumnName = "fajl_id")
    private Fajl fajl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "tip_dokumenta_id", referencedColumnName = "tip_dokumenta_id")
    private TipDokumenta tipDokumenta;

    @Column(name = "blocked", unique = false, nullable = false)
    private boolean blocked;


}
