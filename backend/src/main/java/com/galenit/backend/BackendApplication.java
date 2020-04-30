package com.galenit.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jdk.nashorn.internal.ir.debug.JSONWriter;

import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@RestController
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@CrossOrigin(origins = "http://localhost:8082")
	@GetMapping("/hello")
		public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s", name);
	}

}
