package com.eObrazovanje.eObrazovanje.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "predisipitne")
public class PredispitneObaveze {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "predispitne_id", unique = true, nullable = false)
    private Long predispitne_id;

    @Column(name = "bodovi", unique = false, nullable = false)
    private String bodovi;

    @Column(name = "obavezna", unique = false, nullable = false)
    private Boolean obavezna;

    @Column(name = "vrstaObaveze", unique = false, nullable = false)
    private String vrstaObaveze;

    @ManyToOne
    @JoinColumn(name = "predmet_id")
    @JsonIgnore
    private Predmet predmet;
    
}
