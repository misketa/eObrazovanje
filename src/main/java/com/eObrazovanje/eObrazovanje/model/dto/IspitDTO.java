package com.eObrazovanje.eObrazovanje.model.dto;

import com.eObrazovanje.eObrazovanje.model.entity.IspitniRok;
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
public class IspitDTO implements Serializable {

    private Long ispit_id;
    private Predmet predmet;
    private IspitniRok rokovi;

}
