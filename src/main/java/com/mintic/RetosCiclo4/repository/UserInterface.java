package com.mintic.RetosCiclo4.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mintic.RetosCiclo4.model.User;

/**
 * Interface to Access CRUD Repository
 * 
 * @author G5 Desarrollo WEB
 *
 */

public interface UserInterface extends MongoRepository<User, Integer> {

	Optional<User> findByEmail(String email);
	Optional<User> findByEmailAndPassword(String email, String password);
	
	// To get  max id of User 
	Optional<User> findTopByOrderByIdDesc();

}
