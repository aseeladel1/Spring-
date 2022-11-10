package com.codingdojo.axsos.spring.logregister.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.axsos.spring.logregister.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	Optional<User>findByEmail(String email);
	Optional<User>findById(Long id);
	

}