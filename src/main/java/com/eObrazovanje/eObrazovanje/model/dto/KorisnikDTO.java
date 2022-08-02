package com.eObrazovanje.eObrazovanje.model.dto;

import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KorisnikDTO implements Serializable {

    private Long id;

    @NotBlank
    private String korisnickoIme;

    @NotBlank
    private String lozinka;


    public KorisnikDTO(Korisnik createdUser) {
        this.korisnickoIme = createdUser.getKorisnickoIme();
        this.lozinka = createdUser.getLozinka();
    }
}
