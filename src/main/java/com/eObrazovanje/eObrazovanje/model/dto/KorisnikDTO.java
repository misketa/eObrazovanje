package com.eObrazovanje.eObrazovanje.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KorisnikDTO implements Serializable {

    private String ime;
    private String korisnickoIme;
    private String lozinka;
    private String prezime;
    private String jmbg;
    private String telefon;
    private String plata;

}
