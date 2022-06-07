package com.eObrazovanje.eObrazovanje.service.implemantion;

import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;
import com.eObrazovanje.eObrazovanje.repository.KorisnikRepository;
import com.eObrazovanje.eObrazovanje.service.KorisnikService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KorisnikImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;

    public KorisnikImpl (KorisnikRepository korisnikRepository){
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public Korisnik findByUserName(String korisnickoIme) {
        Optional<Korisnik> user = korisnikRepository.findFirstByKorisnickoIme(korisnickoIme);
        if (!user.isEmpty()) {
            return user.get();
        }
        return null;
    }
}
