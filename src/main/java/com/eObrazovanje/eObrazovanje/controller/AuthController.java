package com.eObrazovanje.eObrazovanje.controller;

import com.eObrazovanje.eObrazovanje.model.dto.KorisnikDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;
import com.eObrazovanje.eObrazovanje.service.KorisnikService;
import com.eObrazovanje.eObrazovanje.service.PredavacService;
import com.eObrazovanje.eObrazovanje.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final StudentService studentService;
    private final PredavacService predavacService;
    private final KorisnikService korisnikService;


    public AuthController(StudentService studentService, PredavacService predavacService, KorisnikService korisnikService){
        this.studentService = studentService;
        this.predavacService = predavacService;
        this.korisnikService = korisnikService;
    }

    @PostMapping("/prijava")
    public ResponseEntity<String> prijava(@RequestBody KorisnikDTO userDto) {
        Korisnik k = korisnikService.findByUserName(userDto.getKorisnickoIme());
        if (k == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();

    }


}
