package com.eObrazovanje.eObrazovanje.service;

import com.eObrazovanje.eObrazovanje.model.dto.KorisnikDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;
import com.eObrazovanje.eObrazovanje.payload.requests.LoginRequest;
import com.eObrazovanje.eObrazovanje.payload.requests.RegisterRequest;
import com.eObrazovanje.eObrazovanje.payload.response.JwtResponse;

import java.util.List;

public interface KorisnikService {

//    JwtResponse signIn(LoginRequest request);
//    String signUp(RegisterRequest request);

    Korisnik findByKorisnickoIme(String korisnickoIme);
    List<Korisnik> findAll();
    void add(Korisnik korisnik);

    Korisnik findOne(Long korisnikId);

    void remove(Long id);

    Korisnik save(KorisnikDTO korisnikDTO2);
//    Object update(KorisnikListDTO userDTO);
    Korisnik createUser(KorisnikDTO newUser);
    Korisnik findByUserName(String username);
}
