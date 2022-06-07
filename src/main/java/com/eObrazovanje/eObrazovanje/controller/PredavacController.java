package com.eObrazovanje.eObrazovanje.controller;
import  com.eObrazovanje.eObrazovanje.exeptions.PredavacNotFoundExeption;
import com.eObrazovanje.eObrazovanje.model.dto.KorisnikDTO;
import com.eObrazovanje.eObrazovanje.model.dto.PredavacDTO;
import com.eObrazovanje.eObrazovanje.model.dto.PredmetDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;
import com.eObrazovanje.eObrazovanje.model.entity.Predavac;
import com.eObrazovanje.eObrazovanje.model.entity.Predmet;
import com.eObrazovanje.eObrazovanje.payload.requests.PredavacPostRequest;
import com.eObrazovanje.eObrazovanje.repository.PredavacRepository;
import com.eObrazovanje.eObrazovanje.service.PredavacService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/predavaci")
@CrossOrigin(origins = "http://localhost:4200")
public class PredavacController {

    private final PredavacRepository predavacRepository;
    private final PredavacService predavacService;

    PredavacController(PredavacRepository predavacRepository,PredavacService predavacService){
        this.predavacService=predavacService;
        this.predavacRepository=predavacRepository;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Predavac> findOne(@PathVariable Long id){
        Predavac predavac=(Predavac) predavacRepository.findById(id)
                .orElseThrow(() -> new PredavacNotFoundExeption("Predavac sa datim id ne postoji"));
        return new ResponseEntity<>(predavac, HttpStatus.FOUND);
    }
    @GetMapping("/{id}/predmeti")
    public ResponseEntity<Set<Predmet>> getAllProfesorCourses(@PathVariable Long id){
        Predavac predavac=(Predavac) predavacRepository.findById(id)
                .orElseThrow(() -> new PredavacNotFoundExeption("Predavac sa datim id ne postoji"));
        return new ResponseEntity<>(predavac.getPredmeti(), HttpStatus.FOUND);
    }
    @GetMapping
    public ResponseEntity<List<Predavac>> findAll() {
        List<Predavac> predavaci = predavacService.findAll();
        return new ResponseEntity<>(predavaci, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Predavac> save(@Valid @RequestBody PredavacDTO predavacDTO) {
        Predavac predavac = predavacService.save(predavacDTO);
        return new ResponseEntity<>(predavac, HttpStatus.CREATED);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Predavac> update(@PathVariable("id") Long id,
                                          @Valid @RequestBody PredavacPostRequest predavacPostRequest) {
        Predavac update = predavacService.update(id, predavacPostRequest);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deletePredavac(@PathVariable Long id) {

        predavacRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }







}
