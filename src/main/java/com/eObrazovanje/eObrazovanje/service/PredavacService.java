package com.eObrazovanje.eObrazovanje.service;

import com.eObrazovanje.eObrazovanje.model.dto.PredavacDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Predavac;
import com.eObrazovanje.eObrazovanje.payload.requests.PredavacPostRequest;
import java.util.List;

public interface PredavacService {
    Predavac findById(Long predavacID);
    List<Predavac> findAll();
    Predavac save(PredavacDTO predavacDTO);
    void remove (Long id);
    Predavac update(Long id, PredavacPostRequest predavacPostRequest);
}
