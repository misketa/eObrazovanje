package com.eObrazovanje.eObrazovanje;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class EObrazovanjeApplication {

	public static Logger log = Logger.getLogger(EObrazovanjeApplication.class.getName());

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(EObrazovanjeApplication.class, args);
		log.info("Started server");
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
