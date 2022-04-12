package com.eObrazovanje.eObrazovanje.model.dto;

import com.eObrazovanje.eObrazovanje.model.entity.Predmet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PredispitneObavezeDTO implements Serializable {

    private Long predispitne_id;
    private String bodovi;
    private Boolean obavezna;
    private String vrstaObaveze;
    private Predmet predmet;
}
