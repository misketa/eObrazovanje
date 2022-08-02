package com.eObrazovanje.eObrazovanje.security;

import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserPrincipal implements UserDetails {
    private Long id;

    private String korisnickoIme;

    @JsonIgnore
    private String lozinka;

    //private Collection<GrantedAuthority> authorities;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String korisnickoIme, String lozinka,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.authorities = authorities;
    }

    public static UserPrincipal build(Korisnik user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new UserPrincipal(
                user.getKorisnik_id(),
                user.getKorisnickoIme(),
                user.getLozinka(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }




    public Long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return lozinka;
    }

    @Override
    public String getUsername() {
        return korisnickoIme;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserPrincipal user = (UserPrincipal) o;
        return Objects.equals(id, user.id);
    }


}