package com.eObrazovanje.eObrazovanje.service.implemantion;
import com.eObrazovanje.eObrazovanje.model.dto.PredavacDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Predavac;
import com.eObrazovanje.eObrazovanje.repository.PredavacRepository;
import com.eObrazovanje.eObrazovanje.payload.requests.PredavacPostRequest;
import com.eObrazovanje.eObrazovanje.service.PredavacService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PredavacImpl implements PredavacService {

    private final PredavacRepository predavacRepository;

    public PredavacImpl(PredavacRepository predavacRepository){this.predavacRepository=predavacRepository;}

    @Override
    public Predavac findById(Long predavacId){return predavacRepository.findById(predavacId).orElseThrow(() -> new RuntimeException("Nije pronadjen zahtev"));}

    @Override
    public List<Predavac> findAll() { return predavacRepository.findAll(); }

    @Override
    public Predavac save(PredavacDTO predavacDTO) {
        Predavac predavac = new Predavac();
        predavac.setIme(predavacDTO.getIme());
        predavac.setPrezime(predavacDTO.getPrezime());
        predavac.setJmbg(predavacDTO.getJmbg());
        predavac.setTelefon(predavacDTO.getTelefon());
        predavac.setPlata(predavacDTO.getPlata());


        return predavacRepository.save(predavac);
    }
    @Override
    public void remove(Long id) { predavacRepository.deleteById(id); }

    @Override
    public Predavac update(Long id, PredavacPostRequest predavacPostRequest) {
        Predavac predavac = (Predavac) predavacRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Book with id " + id + " not found"));


        predavac.setKorisnickoIme(predavacPostRequest.getKorisnickoIme());
        predavac.setLozinka(predavacPostRequest.getLozinka());
        predavac.setIme(predavacPostRequest.getIme());
        predavac.setPrezime(predavacPostRequest.getPrezime());
        predavac.setJmbg(predavacPostRequest.getJmbg());
        predavac.setTelefon(predavacPostRequest.getTelefon());
        predavac.setPlata(predavacPostRequest.getPlata());


        return predavacRepository.save(predavac);

    }

}
