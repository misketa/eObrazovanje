package com.eObrazovanje.eObrazovanje.model.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDTO implements Serializable {

    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    private String jmbg;
    private String telefon;
    private String godinaStudija;
    private String godinaUpisa;
    private String statusStudenta;
    private Boolean budzet;
    //private List istorijaStudiranja;


}
