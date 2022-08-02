package com.eObrazovanje.eObrazovanje.security;


import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;
import com.eObrazovanje.eObrazovanje.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    @Autowired
    private KorisnikRepository korisnikRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String korisnickoIme) throws UsernameNotFoundException {
        Korisnik user = korisnikRepository.findByKorisnickoIme(korisnickoIme);
        return UserPrincipal.build(user);
    }

}

