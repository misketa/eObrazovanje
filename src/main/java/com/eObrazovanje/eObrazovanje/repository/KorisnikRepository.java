package com.eObrazovanje.eObrazovanje.repository;

import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Optional<Korisnik> findFirstByKorisnickoIme(String korisnickoIme);

    Korisnik findByKorisnickoIme(String korisnickoIme);


}
