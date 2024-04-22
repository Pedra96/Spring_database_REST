package com.example.accessingdatamysql.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.accessingdatamysql.model.User;


public interface UserRepository extends CrudRepository<User,Integer>{
	
}
