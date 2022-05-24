package com.eObrazovanje.eObrazovanje.security;

import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;
import com.eObrazovanje.eObrazovanje.repository.PredavacRepository;
import com.eObrazovanje.eObrazovanje.repository.StudentRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private final PredavacRepository predavacRepository;
    private final StudentRepository studentRepository;


    public UserPrincipalDetailsService(PredavacRepository predavacRepository, StudentRepository studentRepository) {
        this.predavacRepository = predavacRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String korisnickoIme) {
        Korisnik korisnik;

        try {
            korisnik = predavacRepository.findByUserName(korisnickoIme).get();
        }
        catch (Exception userException) {
            try {
                korisnik = studentRepository.findByUserName(korisnickoIme).get();
            }
            catch (Exception adminException) {
                throw new UsernameNotFoundException("No user present with username : " + korisnickoIme);
            }
        }

        UserPrincipal userPrincipal = new UserPrincipal();
        userPrincipal.setId(korisnik.getKorisnik_id());
        userPrincipal.setIme(korisnik.getIme());
        userPrincipal.setPrezime(korisnik.getPrezime());
        userPrincipal.setUserName(korisnik.getKorisnickoIme());
        userPrincipal.setPassword(korisnik.getLozinka());
        userPrincipal.setAuthorities(getAuthorities(korisnik));

        return userPrincipal;
    }

    private List<GrantedAuthority> getAuthorities(@NotNull Korisnik korisnik) {
        return korisnik.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
    }

}

