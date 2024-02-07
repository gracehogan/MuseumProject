package com.barclays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:3000")
public class MuseumApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuseumApiApplication.class, args);
	}

}
