package com.example.accessingdatamysql.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.accessingdatamysql.model.Film;
import com.example.accessingdatamysql.service.FilmService;

@Controller
@RequestMapping(path="/film")
public class FilmController {
	@Autowired
	private FilmService filmService;
	
	@PostMapping("/add")
	public ResponseEntity<Film> addFilm(@RequestBody Film film){
		Optional<Film> responseFilm = filmService.addFilm(film);
		if(responseFilm.isEmpty()) {
			return new ResponseEntity<Film>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Film>(responseFilm.get(),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Iterable<Film>> getAllFilm(){
		Iterable<Film> listFilm= filmService.findAll();
		if(listFilm== null) {
			return new ResponseEntity<Iterable<Film>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Iterable<Film>>(listFilm,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Film> getFilm(@PathVariable Integer id){
		Optional<Film> responseFilm = filmService.retrieveFilm(id);
		if(responseFilm.isEmpty()) {
			return new ResponseEntity<Film>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Film>(responseFilm.get(),HttpStatus.OK);
	}
	@PutMapping("/update")
	public @ResponseBody ResponseEntity<Film> updateFilm(@RequestBody Film film){
		Optional<Film> responseFilm = filmService.updateFilm(film);
		if(responseFilm.isEmpty()) {
			return new ResponseEntity<Film>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Film>(responseFilm.get(),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseEntity<Film> deleteFilm(@PathVariable Integer id){
		Optional<Film> responseFilm = filmService.deleteFilm(id);
		return new ResponseEntity<Film>(HttpStatus.OK);
	}
}
