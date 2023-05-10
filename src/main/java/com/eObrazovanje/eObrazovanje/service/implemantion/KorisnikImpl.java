package com.eObrazovanje.eObrazovanje.service.implemantion;

import com.eObrazovanje.eObrazovanje.EObrazovanjeApplication;
import com.eObrazovanje.eObrazovanje.model.dto.KorisnikDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;
import com.eObrazovanje.eObrazovanje.payload.requests.LoginRequest;
import com.eObrazovanje.eObrazovanje.payload.requests.RegisterRequest;
import com.eObrazovanje.eObrazovanje.payload.response.JwtResponse;
import com.eObrazovanje.eObrazovanje.repository.KorisnikRepository;
import com.eObrazovanje.eObrazovanje.security.jwt.JwtTokenProvider;
import com.eObrazovanje.eObrazovanje.service.KorisnikService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KorisnikImpl implements KorisnikService {


    private final KorisnikRepository korisnikRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;


//    @Override
//    public JwtResponse signIn(LoginRequest request) {
//        try {
//            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getKorisnickoIme(), request.getLozinka()));
//            Korisnik korisnik = korisnikRepository
//                    .findByKorisnickoIme(request.getKorisnickoIme());
//            SecurityContextHolder.getContext().setAuthentication(auth);
//            String token =  jwtTokenProvider.generateJwtToken(request.getKorisnickoIme(), new ArrayList<>(korisnik.getRoles()));
//
//            return JwtResponse.builder().token(token).username(korisnik.getKorisnickoIme()).roles(korisnik.getRoles()).build();
//
//        } catch (AuthenticationException e) {
//            throw new RuntimeException("Invalid username/password supplied");
//        }
//    }

//    @Override
//    public String signUp(RegisterRequest request) {
//        if (korisnikRepository.findFirstByKorisnickoIme(request.getKorisnickoIme()).isEmpty()) {
//            Korisnik mapiranKorisnik = modelMapper.map(request, Korisnik.class);
//            mapiranKorisnik.setLozinka(passwordEncoder.encode(request.getLozinka()));
//            Korisnik sacuvanKorisnik = korisnikRepository.save(mapiranKorisnik);
//            return jwtTokenProvider.createToken(sacuvanKorisnik.getKorisnickoIme(), new ArrayList<>(sacuvanKorisnik.getRoles()));
//        } else {
//            throw new RuntimeException("Username is already in use");
//        }
//    }

    @Override
    public Korisnik findByKorisnickoIme(String korisnickoIme) {
        return korisnikRepository.findByKorisnickoIme(korisnickoIme);
    }

    @Override
    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }

    @Override
    public void add(Korisnik korisnik) {
        korisnikRepository.save(korisnik);
    }


    @Override
    public Korisnik findOne(Long korisnikId) {
        return korisnikRepository.findById(korisnikId).orElseThrow(() -> new RuntimeException("Nije pronadjen korisnik"));
    }


    @Override
    public void remove(Long id) {
        korisnikRepository.deleteById(id);
    }


    @Override
    public Korisnik save(KorisnikDTO korisnikDTO2) {
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnickoIme(korisnikDTO2.getIme());
        korisnik.setLozinka(korisnikDTO2.getLozinka());
        korisnik.setIme(korisnikDTO2.getIme());
        korisnik.setPrezime(korisnikDTO2.getPrezime());
        korisnik.setJmbg(korisnikDTO2.getJmbg());
        korisnik.setTelefon(korisnikDTO2.getTelefon());


        return korisnikRepository.save(korisnik);
    }

//    @Override
//    public Object update(KorisnikListDTO userDTO) {
//        return null;
//    }

    @Override
    public Korisnik createUser(KorisnikDTO korisnikDTO) {
        Optional<Korisnik> user = korisnikRepository.findFirstByKorisnickoIme(korisnikDTO.getKorisnickoIme());

        if (user.isPresent()) {
            EObrazovanjeApplication.log.info("User that is tried to be added already exists");
            return null;

        }

        Korisnik newUser = new Korisnik();
        newUser.setKorisnickoIme(korisnikDTO.getKorisnickoIme());
        newUser.setLozinka(korisnikDTO.getLozinka());//(passwordEncoder.encode(korisnikDTO.getLozinka()));
        newUser = korisnikRepository.save(newUser);
        EObrazovanjeApplication.log.info("User successfully created");
        return newUser;
    }

    @Override
    public Korisnik findByUserName(String username) {
        return null;
    }
}
