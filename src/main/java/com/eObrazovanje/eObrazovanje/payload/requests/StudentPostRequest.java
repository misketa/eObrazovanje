package com.eObrazovanje.eObrazovanje.payload.requests;

import com.eObrazovanje.eObrazovanje.model.entity.FinansijskaKartica;
import com.eObrazovanje.eObrazovanje.model.entity.Smer;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
public class StudentPostRequest {

    @NotBlank
    @Size(min = 2, max = 50)
    private String ime;

    @NotBlank
    @Size(min = 2, max = 50)
    private String prezime;

    @NotBlank
    @Size(min = 13, max = 13)
    private String jmbg;

    @NotBlank
    @Size(min = 9)
    private String telefon;

    @NotBlank
    @Size(min = 1, max = 4)
    private String godinaStudija;

    @NotBlank
    @Size(max = 2022)
    private String godinaUpisa;

    @NotBlank
    @Size(min = 2, max = 20)
    private String statusStudenta;


    private Boolean budzet;

    private FinansijskaKartica kartica;

    private Smer smer;


    private List istorijaStudiranja;
}
