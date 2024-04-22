package com.example.accessingdatamysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.accessingdatamysql.model.Actor;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {

}
