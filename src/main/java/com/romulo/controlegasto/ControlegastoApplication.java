package com.romulo.controlegasto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ControlegastoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlegastoApplication.class, args);
	}
	@GetMapping("/")
	public String index(){
		return "Olá, mundo!";
	}

}
