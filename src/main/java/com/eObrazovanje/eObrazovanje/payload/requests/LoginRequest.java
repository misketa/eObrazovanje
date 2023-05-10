package com.eObrazovanje.eObrazovanje.payload.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@Getter
@Setter
public class LoginRequest {
    @NotBlank
    private String korisnickoIme;

    @NotBlank
    private String lozinka;
}
