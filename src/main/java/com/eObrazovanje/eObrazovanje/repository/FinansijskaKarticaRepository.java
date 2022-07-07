package com.eObrazovanje.eObrazovanje.repository;

import com.eObrazovanje.eObrazovanje.model.entity.FinansijskaKartica;
import com.eObrazovanje.eObrazovanje.model.entity.Uplata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinansijskaKarticaRepository  extends JpaRepository<FinansijskaKartica, Long> {

    FinansijskaKartica save(FinansijskaKartica kartica);
}
