package com.eObrazovanje.eObrazovanje.model.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "finansijskaKartica")
public class FinansijskaKartica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kartica_id", unique = true, nullable = false)
    private Long kartica_id;

    @Column(name = "stanje", unique = false, nullable = false)
    private int stanje;


    @OneToMany(mappedBy = "kartica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Uplata> uplate = new ArrayList<>();



    @OneToOne(mappedBy = "kartica")
    private Student student;

    public FinansijskaKartica() {
        stanje=0;
    }

    public FinansijskaKartica(Long kartica_id, int stanje, Student student) {
        this.kartica_id = kartica_id;
        this.stanje = stanje;
        this.student = student;
    }

    public Long getKartica_id() {
        return kartica_id;
    }

    public void setKartica_id(Long kartica_id) {
        this.kartica_id = kartica_id;
    }

    public int getStanje() {
        return stanje;
    }

    public void setStanje(int stanje) {
        this.stanje = stanje;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public List<Uplata> getUplate() {
        return uplate;
    }

    public void setUplate(List<Uplata> uplate) {
        this.uplate = uplate;
    }
}
