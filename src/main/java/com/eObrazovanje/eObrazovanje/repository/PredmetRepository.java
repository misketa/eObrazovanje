package com.eObrazovanje.eObrazovanje.repository;

import com.eObrazovanje.eObrazovanje.model.entity.Predmet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PredmetRepository extends JpaRepository<Predmet,Long> {
    Predmet save(Predmet predmet);
    void  deleteById(Long predmet_id);

    @Override
    Optional<Predmet> findById(Long predmet_id);

    Optional<Predmet> findByNaziv(String naziv);

}
