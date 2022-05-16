package com.eObrazovanje.eObrazovanje.payload.requests;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Getter
public class PredavacPostRequest {
    @NotBlank
    @Size(min=2,max=50)
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
    @Size(min=5)
    private String plata;
}
