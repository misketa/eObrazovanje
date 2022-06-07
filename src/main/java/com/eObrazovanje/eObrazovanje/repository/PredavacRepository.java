package com.eObrazovanje.eObrazovanje.repository;

import com.eObrazovanje.eObrazovanje.model.entity.Predavac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PredavacRepository extends JpaRepository<Predavac,Long> {
    Predavac save(Predavac predavac);
    void deleteById(Long id);
    Optional<Predavac> findById(Long predavacId);
    Optional<Predavac> findByKorisnickoIme(String korisnickoIme);



}
