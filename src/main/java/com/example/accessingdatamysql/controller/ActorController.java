package com.example.accessingdatamysql.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.example.accessingdatamysql.model.Actor;
import com.example.accessingdatamysql.service.ActorService;

@Controller
@RequestMapping(path="/actor")
public class ActorController {
	@Autowired
	private ActorService actorService;
	
	@PostMapping("/add")
	public ResponseEntity<Actor> addActor(@RequestBody Actor actor){
		Optional<Actor> responseActor = actorService.addActor(actor);
	if(responseActor.isEmpty()) {
		return new ResponseEntity<Actor>(HttpStatus.BAD_REQUEST);
	}
		return new ResponseEntity<Actor>(responseActor.get(),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public @ResponseBody ResponseEntity<Iterable<Actor>> getAllActors(){
		Iterable<Actor> listActor = actorService.findAll();
		if(listActor == null) {
			return new ResponseEntity<Iterable<Actor>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Iterable<Actor>>(actorService.findAll(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Actor> getActor(@PathVariable Integer id){
		Optional<Actor> responseActor= actorService.retrieveActor(id);
		if(responseActor.isEmpty()) {
			return new ResponseEntity<Actor>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Actor>(responseActor.get(),HttpStatus.OK);
	}
	@PutMapping("/update")
	public @ResponseBody ResponseEntity<Actor> updateActor(@RequestBody Actor actor){
		Optional<Actor> responseActor= actorService.updateActor(actor);
		if(responseActor.isEmpty()) {
			return new ResponseEntity<Actor>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Actor>(responseActor.get(),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseEntity<Actor> deleteActor(@PathVariable Integer id){
		Optional<Actor> responseActor = actorService.deleteActor(id);
			return new ResponseEntity<Actor>(HttpStatus.OK);	
	}
}
