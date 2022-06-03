package com.eObrazovanje.eObrazovanje.model.entity;


import javax.persistence.*;
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

   // @Column(name = "listaUplata", unique = false , nullable = false)
   // private List<String> listaUplata;

    @OneToOne(mappedBy = "kartica")
    private Student student;

    public FinansijskaKartica() {
    }

    public FinansijskaKartica(Long kartica_id, int stanje, List<String> listaUplata, Student student) {
        this.kartica_id = kartica_id;
        this.stanje = stanje;
       // this.listaUplata = listaUplata;
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
/*
    public List<String> getListaUplata() {
        return listaUplata;
    }

    public void setListaUplata(List<String> listaUplata) {
        this.listaUplata = listaUplata;
    }
*/
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
