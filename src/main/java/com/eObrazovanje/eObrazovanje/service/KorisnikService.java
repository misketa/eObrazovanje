package com.eObrazovanje.eObrazovanje.service;


import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;

public interface KorisnikService {

    Korisnik findByUserName(String korisnickoIme);
}
