package com.eObrazovanje.eObrazovanje.security;

import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;
import com.eObrazovanje.eObrazovanje.repository.KorisnikRepository;
import com.eObrazovanje.eObrazovanje.security.jwt.AuthEntryPointJwt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import lombok.SneakyThrows;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserPrincipalDetailsService implements UserDetailsService {

    private final KorisnikRepository korisnikRepository;
    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    @Override
    @SneakyThrows
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String korisnickoIme) {
        Korisnik user = korisnikRepository.findByKorisnickoIme(korisnickoIme);
    logger.info(user.getKorisnickoIme());

        return UserPrincipal.builder()
                .id(user.getKorisnik_id())
                .korisnickoIme(user.getKorisnickoIme())
                .lozinka(user.getLozinka())
                .authorities(getAuthorities(user))
                .build();
    }

    private List<GrantedAuthority> getAuthorities(Korisnik user) {
       return user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}