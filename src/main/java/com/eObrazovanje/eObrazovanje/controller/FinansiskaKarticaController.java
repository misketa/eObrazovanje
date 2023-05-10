package com.eObrazovanje.eObrazovanje.controller;

import com.eObrazovanje.eObrazovanje.model.dto.UplataDTO;
import com.eObrazovanje.eObrazovanje.model.entity.FinansijskaKartica;
import com.eObrazovanje.eObrazovanje.model.entity.Uplata;
import com.eObrazovanje.eObrazovanje.security.UserPrincipal;
import com.eObrazovanje.eObrazovanje.security.UserPrincipalDetailsService;
import com.eObrazovanje.eObrazovanje.service.StudentService;
import com.eObrazovanje.eObrazovanje.service.UplataNaKarticuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/kartice")
@CrossOrigin(origins = "http://localhost:4200")
public class FinansiskaKarticaController {
    @Autowired
    UplataNaKarticuService uplataServis;
    @Autowired
    StudentService studentService;
    @Autowired
    UserPrincipalDetailsService prijavljeni;

    @PostMapping("/uplate")
    public ResponseEntity<Uplata> save( @RequestBody UplataDTO uplataDTO) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal user= (UserPrincipal)prijavljeni.loadUserByUsername(authentication.getName());

        Uplata uplata = uplataServis.save(user.getId(), uplataDTO.getIznos());
        return new ResponseEntity<>(uplata, HttpStatus.CREATED);

    }   
    @GetMapping()
    public ResponseEntity<FinansijskaKartica> get(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal user = (UserPrincipal)prijavljeni.loadUserByUsername(authentication.getName());

        return new ResponseEntity<>(studentService.findById(user.getId()).getKartica(), HttpStatus.OK);
    }
}
