package com.eObrazovanje.eObrazovanje.model.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class KorisnikDTO implements Serializable {
    private Long id;
    @NotBlank
    private String korisnickoIme;
    @NotBlank
    private String lozinka;
    private String jmbg;
    private String telefon;
    private String ime;
    private String prezime;
}
