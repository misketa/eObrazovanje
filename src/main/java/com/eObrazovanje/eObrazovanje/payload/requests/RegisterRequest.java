package com.eObrazovanje.eObrazovanje.payload.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
@Setter
public class RegisterRequest {
    @NotBlank
    private String ime;

    @NotBlank
    private String prezime;

    @NotBlank
    private String jmbg;

    @NotBlank
    private String telefon;

    @NotBlank
    private String email;

    @NotBlank
    private String korisnickoIme;

    @NotBlank
    private String lozinka;
}
