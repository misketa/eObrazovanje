package com.eObrazovanje.eObrazovanje.service.implemantion;
import com.eObrazovanje.eObrazovanje.model.dto.PredavacDTO;
import com.eObrazovanje.eObrazovanje.model.dto.PredmetDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Predavac;
import com.eObrazovanje.eObrazovanje.model.entity.Predmet;
import com.eObrazovanje.eObrazovanje.payload.requests.PredavacPostRequest;
import com.eObrazovanje.eObrazovanje.repository.PredmetRepository;
import com.eObrazovanje.eObrazovanje.payload.requests.PredmetPostRequest;
import com.eObrazovanje.eObrazovanje.service.PredmetService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PredmetImpl implements PredmetService {

    private  PredmetRepository predmetRepository;
    public PredmetImpl(PredmetRepository predmetRepository){this.predmetRepository=predmetRepository;}

    @Override
    public Predmet findOne(Long predmet_id){return (Predmet)predmetRepository.findById(predmet_id).orElse(null);}
    @Override
    public List<Predmet> findAll() { return predmetRepository.findAll(); }

    @Override
    public Predmet save(PredmetDTO predmetDTO) {
        Predmet predmet = new Predmet();
        predmet.setPredmet_id(predmetDTO.getPredmet_id());
        predmet.setNaziv(predmetDTO.getNaziv());
        predmet.setSemestar(predmetDTO.getSemestar());
        predmet.setEspb(predmetDTO.getEspb());
        predmet.setOpis(predmetDTO.getOpis());
        predmet.setSmer(predmetDTO.getSmer());
        predmet.setIspit(predmetDTO.getIspit());





        return predmetRepository.save(predmet);
    }
    @Override
    public void remove(Long id) { predmetRepository.deleteById(id); }



    @Override
    public Predmet update(Long id, PredmetPostRequest predmetPostRequest) {
        Predmet predmet = (Predmet) predmetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Book with id " + id + " not found"));


        predmet.setPredmet_id(predmetPostRequest.getPredmet_id());
        predmet.setNaziv(predmetPostRequest.getNaziv());
        predmet.setSemestar(predmetPostRequest.getSemestar());
        predmet.setEspb(predmetPostRequest.getEspb());
        predmet.setOpis(predmetPostRequest.getOpis());
        predmet.setSmer(predmetPostRequest.getSmer());
        predmet.setIspit(predmetPostRequest.getIspit());


        return predmetRepository.save(predmet);

    }



}
