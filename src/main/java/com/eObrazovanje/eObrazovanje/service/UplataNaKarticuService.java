package com.eObrazovanje.eObrazovanje.service;

import com.eObrazovanje.eObrazovanje.model.dto.StudentDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Student;
import com.eObrazovanje.eObrazovanje.model.dto.FinansijskaKarticaDTO;
import com.eObrazovanje.eObrazovanje.model.entity.FinansijskaKartica;
import com.eObrazovanje.eObrazovanje.model.entity.Uplata;

public interface UplataNaKarticuService {

    public Uplata save(Long student_id,int iznos);


}
