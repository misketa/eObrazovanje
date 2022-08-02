package com.eObrazovanje.eObrazovanje.service;


import com.eObrazovanje.eObrazovanje.model.dto.KorisnikDTO;
import com.eObrazovanje.eObrazovanje.model.dto.KorisnikDTO2;
import com.eObrazovanje.eObrazovanje.model.dto.KorisnikListDTO;
import com.eObrazovanje.eObrazovanje.model.dto.StudentDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;
import com.eObrazovanje.eObrazovanje.model.entity.Student;

import java.util.List;

public interface KorisnikService {

    Korisnik findByKorisnickoIme(String korisnickoIme);

    List<Korisnik> findAll();

    void add(Korisnik korisnik);

    Korisnik findOne(Long korisnikId);

    void remove(Long id);

    Korisnik save(KorisnikDTO2 korisnikDTO2);

    Object update(KorisnikListDTO userDTO);

    Korisnik createUser(KorisnikDTO newUser);

    Korisnik findByUserName(String username);
}
