package com.mintic.RetosCiclo4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.RetosCiclo4.model.User;
import com.mintic.RetosCiclo4.service.UserService;

/**
 * Class to Access Endpoints
 * 
 * @author MARIO
 *
 */

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService serviceUser;

	/**
	 * Method EP to Get Users
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return serviceUser.getAllUsers();
	}

	/**
	 * Method Endpoint to get unique user
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Optional<User> getUser(@PathVariable("id") int id) {
		return serviceUser.getUsr(id);
	}

	/**
	 * Method EP to Create User
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user) {
		return serviceUser.createUsr(user);
	}

	/**
	 * Method EP to Update User
	 * 
	 * @param user
	 * @return
	 */
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public User update(@RequestBody User user) {
		return serviceUser.updateUsr(user);
	}

	/**
	 * Method EP to Delete User by Id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteUsr(@PathVariable("id") int id) {
		return serviceUser.deleteUsr(id);
	}

	/**
	 * Method EP to Validate User´s Email and Password
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	@GetMapping("/{email}/{password}")
	public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
		return serviceUser.authenticateUser(email, password);
	}

	/**
	 * Method EP to Verify if User´s Email Exist
	 * 
	 * @param email
	 * @return
	 */
	@GetMapping("/emailexist/{email}")
	public boolean emailExists(@PathVariable("email") String email) {
		return serviceUser.emailExists(email);
	}
}
