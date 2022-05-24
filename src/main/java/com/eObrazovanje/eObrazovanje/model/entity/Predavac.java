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
public class Predavac extends Korisnik{

    @Column(name = "plata", unique = true, nullable = false)
    private String plata;

    @ManyToMany
    @JoinTable(
            name = "predmet_like",
            joinColumns = @JoinColumn(name = "predavac_id"),
            inverseJoinColumns = @JoinColumn(name = "predmet_id"))
    Set<Predmet> likedPredmet;


}
