package com.eObrazovanje.eObrazovanje.controller;
import com.eObrazovanje.eObrazovanje.model.dto.PredavacDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Predavac;
import com.eObrazovanje.eObrazovanje.model.entity.Predmet;
import com.eObrazovanje.eObrazovanje.payload.requests.PredavacPostRequest;
import com.eObrazovanje.eObrazovanje.service.PredavacService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/predavaci")
@CrossOrigin(origins = "http://localhost:4200")
public class PredavacController {


    private final PredavacService predavacService;

    PredavacController(PredavacService predavacService){
        this.predavacService=predavacService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Predavac> findOne(@PathVariable Long id){
        Predavac predavac= predavacService.findById(id);
        return new ResponseEntity<>(predavac, HttpStatus.FOUND);
    }
    @GetMapping("/{id}/predmeti")
    public ResponseEntity<Set<Predmet>> getAllProfesorCourses(@PathVariable Long id){
        Predavac predavac=(Predavac) predavacService.findById(id);
        return new ResponseEntity<>(predavac.getPredmeti(), HttpStatus.FOUND);
    }
    @GetMapping
    public ResponseEntity<List<Predavac>> findAll() {
        List<Predavac> predavaci = predavacService.findAll();
        return new ResponseEntity<>(predavaci, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Predavac> save( @RequestBody PredavacDTO predavacDTO) {
        Predavac predavac = predavacService.save(predavacDTO);
        return new ResponseEntity<>(predavac, HttpStatus.CREATED);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Predavac> update(@PathVariable("id") Long id,
                                          @RequestBody PredavacPostRequest predavacPostRequest) {
        Predavac update = predavacService.update(id, predavacPostRequest);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deletePredavac(@PathVariable Long id) {

        predavacService.remove(id);

        return ResponseEntity.noContent().build();
    }







}
