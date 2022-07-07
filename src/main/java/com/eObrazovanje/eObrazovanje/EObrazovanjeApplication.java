package com.eObrazovanje.eObrazovanje;

import com.eObrazovanje.eObrazovanje.model.entity.Smer;
import com.eObrazovanje.eObrazovanje.model.entity.Student;
import com.eObrazovanje.eObrazovanje.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EObrazovanjeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EObrazovanjeApplication.class, args);
	}
/*
	@Bean
	CommandLineRunner init (StudentRepository sr){
		return args -> {
			Smer smer=new Smer(1,"sit",)
			sr.save(new Student("Treca","2019","redovan",true, ))
		}
	}
*/
}
