package com.eObrazovanje.eObrazovanje.model.dto;

import com.eObrazovanje.eObrazovanje.model.entity.Predmet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PredavacDTO implements Serializable {

    private Long predavac_id;
    private String ime;
    private String prezime;
    private String jmbg;
    private String telefon;
    private String plata;
    Set<Predmet> likedPredmet;
}
