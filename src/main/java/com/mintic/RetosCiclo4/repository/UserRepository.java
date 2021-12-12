package com.mintic.RetosCiclo4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mintic.RetosCiclo4.model.User;

/**
 * Repository to ACCES Model User
 * 
 * @author G5 Desarrollo WEB
 *
 */
@Repository
public class UserRepository {
	@Autowired
	private UserInterface interfUserRepo;

	/**
	 * Method to Get All products
	 * 
	 * @return List Type User
	 */
	public List<User> getAllUsers() {
		return (List<User>) interfUserRepo.findAll();
	}

	/**
	 * Method to Get User by Id
	 * 
	 * @return Unique User
	 */
	public Optional<User> getUser(int id) {
		return interfUserRepo.findById(id);
	}

	/**
	 * Method to Create New User
	 * 
	 * @return Product Saved
	 */
	public User createUser(User user) {
		return interfUserRepo.save(user);
	}

	/**
	 * Method to Update User in DB
	 */
	public void updateUser(User user) {
		interfUserRepo.save(user);
	}

	/**
	 * Method to Delete Unique User in DB
	 */
	public void deleteUser(User user) {
		interfUserRepo.delete(user);
	}

	/**
	 * Method to verify if email Exist
	 * 
	 * @param email
	 * @return True if email exist
	 */
	public boolean existEmail(String email) {
		Optional<User> usrItem = interfUserRepo.findByEmail(email);
		return !usrItem.isEmpty();
	}

	/**
	 * Method to verify if email and password exists
	 * 
	 * @param email
	 * @param password
	 * @return User
	 */
	public Optional<User> authenticateUser(String email, String password) {
		return interfUserRepo.findByEmailAndPassword(email, password);
	}

	/**
	 * get last user Id from collection "usuarios" @ return User id
	 */
	public Optional<User> lastUserId() {
		return interfUserRepo.findTopByOrderByIdDesc();

	}

}
