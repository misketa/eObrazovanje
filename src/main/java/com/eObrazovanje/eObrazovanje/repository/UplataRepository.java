package com.eObrazovanje.eObrazovanje.repository;

import com.eObrazovanje.eObrazovanje.model.entity.Student;
import com.eObrazovanje.eObrazovanje.model.entity.Uplata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UplataRepository extends JpaRepository<Uplata, Long> {
    Uplata save(Uplata uplata);
}
