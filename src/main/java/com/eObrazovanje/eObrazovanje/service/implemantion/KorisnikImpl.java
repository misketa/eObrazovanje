package com.eObrazovanje.eObrazovanje.service.implemantion;

import com.eObrazovanje.eObrazovanje.EObrazovanjeApplication;
import com.eObrazovanje.eObrazovanje.model.dto.KorisnikDTO;
import com.eObrazovanje.eObrazovanje.model.dto.KorisnikDTO2;
import com.eObrazovanje.eObrazovanje.model.dto.KorisnikListDTO;
import com.eObrazovanje.eObrazovanje.model.dto.StudentDTO;
import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;
import com.eObrazovanje.eObrazovanje.model.entity.Student;
import com.eObrazovanje.eObrazovanje.repository.KorisnikRepository;
import com.eObrazovanje.eObrazovanje.service.KorisnikService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KorisnikImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;
    //private final PasswordEncoder passwordEncoder;

    public KorisnikImpl(KorisnikRepository korisnikRepository /*PasswordEncoder passwordEncoder*/){
        this.korisnikRepository = korisnikRepository;
        //this.passwordEncoder = passwordEncoder;
    }



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
    public Korisnik save(KorisnikDTO2 korisnikDTO2) {
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnickoIme(korisnikDTO2.getIme());
        korisnik.setLozinka(korisnikDTO2.getIme());
        korisnik.setIme(korisnikDTO2.getIme());
        korisnik.setPrezime(korisnikDTO2.getPrezime());
        korisnik.setJmbg(korisnikDTO2.getJmbg());
        korisnik.setTelefon(korisnikDTO2.getTelefon());


        return korisnikRepository.save(korisnik);
    }



    @Override
    public Object update(KorisnikListDTO userDTO) {
        return null;
    }

    @Override
    public Korisnik createUser(KorisnikDTO korisnikDTO) {
        Optional<Korisnik> user = korisnikRepository.findFirstByKorisnickoIme(korisnikDTO.getKorisnickoIme());

        if(user.isPresent()){
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
