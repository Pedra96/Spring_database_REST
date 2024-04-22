package com.example.accessingdatamysql.model;

import java.sql.Timestamp;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Film {
	@Column(name = "film_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private Integer language_id;
	private Integer rental_duration;
	private float rental_rate;
	private float replacement_cost;
	private Timestamp last_update;
	@OneToMany(mappedBy="id")
	private Set<Actor> actors;
	
	public Film() {
		
	}

	public Film(String title, Integer language_id, Integer rental_duration, float rental_rate, float replacement_cost,
			Timestamp last_update, Set<Actor> actors) {
		this.title = title;
		this.language_id = language_id;
		this.rental_duration = rental_duration;
		this.rental_rate = rental_rate;
		this.replacement_cost = replacement_cost;
		this.last_update = last_update;
		this.actors = actors;
	}

	public Integer getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(Integer language_id) {
		this.language_id = language_id;
	}
	public Integer getRental_duration() {
		return rental_duration;
	}
	public void setRental_duration(Integer rental_duration) {
		this.rental_duration = rental_duration;
	}
	public float getRental_rate() {
		return rental_rate;
	}
	public void setRental_rate(float rental_rate) {
		this.rental_rate = rental_rate;
	}
	public float getReplacement_cost() {
		return replacement_cost;
	}
	public void setReplacement_cost(float replacement_cost) {
		this.replacement_cost = replacement_cost;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	public Set<Actor> getActors() {
		return actors;
	}
	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}
	
}
