package com.eObrazovanje.eObrazovanje.model.dto;


import java.io.Serializable;

public class AdminDTO implements Serializable {

    private String ime;
    private String prezime;
    private String jmbg;
    private String telefon;
    private String plata;

    public AdminDTO() {
    }

    public AdminDTO(String ime, String prezime, String jmbg, String telefon, String plata) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.telefon = telefon;
        this.plata = plata;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPlata() {
        return plata;
    }

    public void setPlata(String plata) {
        this.plata = plata;
    }
}
