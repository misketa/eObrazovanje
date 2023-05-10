package com.eObrazovanje.eObrazovanje.controller;

import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;
import com.eObrazovanje.eObrazovanje.payload.requests.LoginRequest;
import com.eObrazovanje.eObrazovanje.payload.requests.RegisterRequest;

import com.eObrazovanje.eObrazovanje.payload.response.JwtResponse;
import com.eObrazovanje.eObrazovanje.repository.RoleRepository;
import com.eObrazovanje.eObrazovanje.security.UserPrincipal;
import com.eObrazovanje.eObrazovanje.security.jwt.JwtTokenProvider;
import com.eObrazovanje.eObrazovanje.service.KorisnikService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    private final KorisnikService korisnikService;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwtTokenProvider;

    // With not refresh token
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUserWithAccessToken(@Valid @RequestBody LoginRequest loginRequestDTO) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequestDTO.getKorisnickoIme(),
                            loginRequestDTO.getLozinka())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtTokenProvider.generateTokenWithAuthentication(authentication);

            UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
            List<SimpleGrantedAuthority> roles = userDetails.getAuthorities().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                    .collect(Collectors.toList());

            return ResponseEntity.ok(new JwtResponse(jwt, null,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    roles));

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }


    }

    @PostMapping("/register")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use")})
    public String signup(@ApiParam("Signup User") @RequestBody RegisterRequest user) {
        return "register";
    }
}
