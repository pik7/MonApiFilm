package com.sergealbert.apifilm.service;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergealbert.apifilm.model.Film;
import com.sergealbert.apifilm.repository.FilmRepository;


@Service
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;
	
	public Optional<Film> getFilm(Long id) {
		return filmRepository.findById(id);
	}
	
	public Film saveFilm(Film film) {
        Film savedFilm = filmRepository.save(film);
        return savedFilm;
    } 
}
