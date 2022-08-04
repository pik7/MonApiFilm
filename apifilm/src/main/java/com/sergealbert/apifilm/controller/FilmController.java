package com.sergealbert.apifilm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sergealbert.apifilm.model.Film;
import com.sergealbert.apifilm.service.FilmService;


@RestController
public class FilmController {

	@Autowired
	private FilmService filmService;
	
	/**
	 * Read - Get one film 
	 * @param id The id of the film
	 * @return An Film object full filled
	 */
	@GetMapping("api/film/{id}")
	public Film getFilm(@PathVariable("id") final Long id) {
		Optional<Film> film = filmService.getFilm(id);
		if(film.isPresent()) {
			return film.get();
		} else {
			return null;
		}
	}
	
	/**
	 * Create - Add a new Film
	 * @param film An object film
	 * @return The film object saved
	 */
	@PostMapping("/api/film")
	public Film createFilm(@RequestBody Film film) {
		return filmService.saveFilm(film);
	}
	
	
}
