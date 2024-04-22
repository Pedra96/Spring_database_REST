package com.example.accessingdatamysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.accessingdatamysql.model.Film;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {

}
