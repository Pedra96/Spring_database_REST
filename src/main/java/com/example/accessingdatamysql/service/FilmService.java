package com.example.accessingdatamysql.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessingdatamysql.model.Film;
import com.example.accessingdatamysql.repository.FilmRepository;

@Service
public class FilmService {
	@Autowired
	FilmRepository filmRepository;
	
	public Optional<Film> addFilm(Film film){
		
		Date date = new Date();
		film.setLast_update(new Timestamp(date.getTime()));
		Optional<Film> optFilm= Optional.of(filmRepository.save(film));
		return optFilm;	
	}
	public Iterable<Film> findAll(){
		Iterable<Film> filmList= filmRepository.findAll();
		return filmList;
	}
	public Optional<Film> retrieveFilm(Integer id){
		return filmRepository.findById(id);
	}
	public Optional<Film> updateFilm(Film film) {
		if(film.getId()==null) {
			return Optional.empty();
		}
		return null;
	}
	public Optional<Film> deleteFilm(Integer id) {
		filmRepository.deleteById(id);
		return Optional.empty();
	}
}
