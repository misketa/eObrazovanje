package com.eObrazovanje.eObrazovanje.model.dto;

import com.eObrazovanje.eObrazovanje.model.entity.Ispit;
import com.eObrazovanje.eObrazovanje.model.entity.Predavac;
import com.eObrazovanje.eObrazovanje.model.entity.Smer;
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
public class PredmetDTO implements Serializable {

    private Long predmet_id;
    private String naziv;
    private String semestar;
    private String espb;
    private String opis;
    private Smer smer;
    Set<Predavac> likes;
    private Ispit ispit;
}
