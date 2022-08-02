package com.eObrazovanje.eObrazovanje.controller;


import com.eObrazovanje.eObrazovanje.model.dto.KorisnikDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;
import com.eObrazovanje.eObrazovanje.payload.requests.LoginRequest;
import com.eObrazovanje.eObrazovanje.repository.AdminRepository;
import com.eObrazovanje.eObrazovanje.repository.PredavacRepository;
import com.eObrazovanje.eObrazovanje.repository.RoleRepository;
import com.eObrazovanje.eObrazovanje.repository.StudentRepository;
import com.eObrazovanje.eObrazovanje.security.JwtResponse;
import com.eObrazovanje.eObrazovanje.security.JwtUtil;
import com.eObrazovanje.eObrazovanje.security.UserPrincipal;
import com.eObrazovanje.eObrazovanje.security.UserPrincipalDetailsService;
import com.eObrazovanje.eObrazovanje.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PredavacRepository predavacRepository;


    @Autowired
    private UserPrincipalDetailsService userPrincipalDetailsService;

   // @Autowired
   // PasswordEncoder encoder;


    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){

        Korisnik user = korisnikService.findByKorisnickoIme(loginRequest.getKorisnickoIme());

        if(!user.isBlocked()) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getKorisnickoIme(), loginRequest.getLozinka()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserPrincipal userDetails =  (UserPrincipal) authentication.getPrincipal();
            System.out.println(user);
            String jwt = jwtUtil.generateToken(userDetails);


            List<String> roles = userDetails.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());


            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    roles));
        }else {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }


    }








}
