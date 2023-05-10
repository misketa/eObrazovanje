package com.eObrazovanje.eObrazovanje;

import com.eObrazovanje.eObrazovanje.model.entity.Admin;
import com.eObrazovanje.eObrazovanje.model.entity.Dokument;
import com.eObrazovanje.eObrazovanje.model.entity.Korisnik;
import com.eObrazovanje.eObrazovanje.model.entity.Role;
import com.eObrazovanje.eObrazovanje.repository.AdminRepository;
import com.eObrazovanje.eObrazovanje.repository.KorisnikRepository;
import com.eObrazovanje.eObrazovanje.repository.StudentRepository;
import com.eObrazovanje.eObrazovanje.service.DokumentService;
import org.apache.log4j.BasicConfigurator;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.Set;
import java.util.logging.Logger;

@SpringBootApplication
public class EObrazovanjeApplication implements CommandLineRunner {

    public static Logger log = Logger.getLogger(EObrazovanjeApplication.class.getName());

    public static void main(String[] args) {
        BasicConfigurator.configure();
        SpringApplication.run(EObrazovanjeApplication.class, args);
        log.info("Started server");
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Resource
    DokumentService storageService;

    @Override
    public void run(String... arg) throws Exception {
        storageService.deleteAll();
        storageService.init();
    }
    @Bean
    CommandLineRunner init(AdminRepository ar, KorisnikRepository ke, PasswordEncoder pe) {
        return args -> {
//            Admin admin = Admin.builder()
//                    .admin_id(1L).ime("Milos").prezime("Simic").korisnickoIme("msimic").plata("2000").blocked(false)
//                    .telefon("123").lozinka(pe.encode("msimic123")).jmbg("123456")
//                    .build();

            Role role = new Role(1L, "ROLE_ADMIN");
            Korisnik korisnik = Korisnik.builder()
                    .korisnik_id(2L).ime("Petar").prezime("Petrovic").korisnickoIme("msimic").roles(Set.of(role)).blocked(false)
                    .telefon("123").lozinka(pe.encode("msimic123")).jmbg("123456")
                    .build();
//            ar.save(admin);
            ke.save(korisnik);

        };
    }

}
