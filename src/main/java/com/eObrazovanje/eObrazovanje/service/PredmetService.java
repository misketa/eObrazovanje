package com.eObrazovanje.eObrazovanje.service;
import com.eObrazovanje.eObrazovanje.model.dto.PredavacDTO;
import com.eObrazovanje.eObrazovanje.model.dto.PredmetDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Predavac;
import com.eObrazovanje.eObrazovanje.model.entity.Predmet;
import com.eObrazovanje.eObrazovanje.payload.requests.PredavacPostRequest;
import com.eObrazovanje.eObrazovanje.payload.requests.PredmetPostRequest;
import java.util.List;
public interface PredmetService {
    Predmet findById(Long predmet_id);
    List<Predmet> findAll();
    Predmet save(PredmetDTO predmetDTO);
    void remove (Long predmet_id);
    Predmet update(Long  predmet_id, PredmetPostRequest predmetPostRequest);

}
