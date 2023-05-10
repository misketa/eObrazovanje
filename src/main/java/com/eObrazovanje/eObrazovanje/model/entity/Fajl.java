package com.eObrazovanje.eObrazovanje.model.entity;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fajlovi")
public class Fajl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fajl_id", unique = true, nullable = false)
    private Long fajl_id;

    @Column(name = "path", unique = false, nullable = false)
    private String path;

    @OneToMany(cascade= {ALL}, mappedBy= "fajl")
    private List<Dokument> documents = new ArrayList<Dokument>();
}
