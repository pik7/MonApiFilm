package com.sergealbert.apifilm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sergealbert.apifilm.controller.FilmController;
import com.sergealbert.apifilm.model.Film;
import com.sergealbert.apifilm.service.FilmService;

@SpringBootApplication
public class ApifilmApplication{

	@Autowired
	private FilmController filmcontroller;
	
	public static void main(String[] args) {
		SpringApplication.run(ApifilmApplication.class, args);
	}

}
