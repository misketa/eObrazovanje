package com.eObrazovanje.eObrazovanje.model.dto;

import com.eObrazovanje.eObrazovanje.model.entity.Student;
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
public class FinansijskaKarticaDTO implements Serializable {

    private Long kartica_id;
    private int stanje;
    private List listaUplata;
    private Student student;

}
