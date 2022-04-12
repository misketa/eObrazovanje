package com.eObrazovanje.eObrazovanje.model.dto;
import java.io.Serializable;
import java.util.List;

public class StudentDTO implements Serializable {

    private String ime;
    private String prezime;
    private String jmbg;
    private String telefon;
    private String godinaStudija;
    private String godinaUpisa;
    private String statusStudenta;
    private Boolean budzet;
    private List istorijaStudiranja;

    public StudentDTO() {
    }

    public StudentDTO(String ime, String prezime, String jmbg, String telefon, String godinaStudija, String godinaUpisa, String statusStudenta, Boolean budzet, List istorijaStudiranja) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.telefon = telefon;
        this.godinaStudija = godinaStudija;
        this.godinaUpisa = godinaUpisa;
        this.statusStudenta = statusStudenta;
        this.budzet = budzet;
        this.istorijaStudiranja = istorijaStudiranja;
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

    public String getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public String getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(String godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }

    public String getStatusStudenta() {
        return statusStudenta;
    }

    public void setStatusStudenta(String statusStudenta) {
        this.statusStudenta = statusStudenta;
    }

    public Boolean getBudzet() {
        return budzet;
    }

    public void setBudzet(Boolean budzet) {
        this.budzet = budzet;
    }

    public List getIstorijaStudiranja() {
        return istorijaStudiranja;
    }

    public void setIstorijaStudiranja(List istorijaStudiranja) {
        this.istorijaStudiranja = istorijaStudiranja;
    }
}
