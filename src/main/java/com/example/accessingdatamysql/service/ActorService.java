package com.example.accessingdatamysql.service;


import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessingdatamysql.model.Actor;
import com.example.accessingdatamysql.repository.ActorRepository;

@Service
public class ActorService {
	@Autowired
	ActorRepository actorRepository;

	public Optional<Actor> addActor(Actor actor) {
		if(actor.getFirstName() == null || actor.getLastName()== null) {
			return Optional.empty() ;
		}
		Date date = new Date();
		actor.setLastUpdate(new Timestamp(date.getTime()));
		Optional<Actor> optActor= Optional.of(actorRepository.save(actor));
		return optActor;
	}
	public Iterable<Actor> findAll() {
		Iterable<Actor> actorList = actorRepository.findAll();
		return actorList;
	}
	public Optional<Actor> retrieveActor(Integer id) {
		return actorRepository.findById(id);
	}
	public Optional<Actor> updateActor(Actor actor) {
		if(actor.getId()==null) {
			return Optional.empty();
		}
		Date date = new Date();
		Optional<Actor> oldActor= actorRepository.findById(actor.getId());
		if(oldActor.isEmpty()) {
			return Optional.empty();
		}
		if(actor.getFirstName() == null ) {
			actor.setFirstName(oldActor.get().getFirstName());
		}
		if(actor.getLastName() == null) {
			actor.setLastName(oldActor.get().getLastName());
		}
		actor.setLastUpdate(new Timestamp(date.getTime()));
		actor= actorRepository.save(actor);
		return Optional.of(actor);
	}
	public Optional<Actor> deleteActor(Integer id) {
			actorRepository.deleteById(id);	
			return Optional.empty();
	}
	
	
	
}
