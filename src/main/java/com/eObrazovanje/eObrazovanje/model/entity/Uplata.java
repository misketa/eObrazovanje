package com.eObrazovanje.eObrazovanje.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "uplata")
public class Uplata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uplata_id", unique = true, nullable = false)
    private Long uplata_id;

    @Column(name = "iznos",  nullable = false)
    private int iznos;

    @CreationTimestamp
    private Date datum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kartica_id")
    private FinansijskaKartica kartica;

}
