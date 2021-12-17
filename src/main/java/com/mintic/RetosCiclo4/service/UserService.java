package com.mintic.RetosCiclo4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.RetosCiclo4.model.User;
import com.mintic.RetosCiclo4.repository.UserRepository;

/**
 * Class to acces Repository User
 * 
 * @author G5 Desarrollo WEB
 *
 */

@Service
public class UserService {

	@Autowired
	private UserRepository repositoryUser;

	/**
	 * Method to get all users
	 * 
	 * @return
	 */
	public List<User> getAllUsers() {
		return repositoryUser.getAllUsers();
	}

	/**
	 * Method to get User by Id
	 * 
	 * @return User
	 */
	public Optional<User> getUsr(int id) {

		return repositoryUser.getUser(id);
	}

	/**
	 * Method to Create User into DB
	 * 
	 * @param user
	 * @return user
	 */
	public User createUsr(User user) {
		if (user.getId() == null) {
			return user;
		} else {
			Optional<User> usrRetrieved = repositoryUser.getUser(user.getId());
			if (usrRetrieved.isEmpty()) {
				if (emailExists(user.getEmail()) == false) {
					return repositoryUser.createUser(user);
				} else {
					return user;
				}
			} else {
				return user;
			}
		}
	}

	/**
	 * Method to Update User DB
	 * 
	 * @param user
	 * @return user
	 */
	public User updateUsr(User user) {

		if (user.getId() != null) {
			Optional<User> usrRecovered = repositoryUser.getUser(user.getId());
			if (!usrRecovered.isEmpty()) {
				if (user.getIdentification() != null) {
					usrRecovered.get().setIdentification(user.getIdentification());
				}
				if (user.getName() != null) {
					usrRecovered.get().setName(user.getName());
				}
				if (user.getAddress() != null) {
					usrRecovered.get().setAddress(user.getAddress());
				}
				if (user.getCellPhone() != null) {
					usrRecovered.get().setCellPhone(user.getCellPhone());
				}
				if (user.getEmail() != null) {
					usrRecovered.get().setEmail(user.getEmail());
				}
				if (user.getPassword() != null) {
					usrRecovered.get().setPassword(user.getPassword());
				}
				if (user.getZone() != null) {
					usrRecovered.get().setZone(user.getZone());
				}

				repositoryUser.updateUser(user);
				return usrRecovered.get();
			} else {
				return user;
			}
		} else {
			return user;
		}
	}

	/**
	 * Method to Delete User of DB
	 * 
	 * @param userId
	 * @return True or False
	 */
	public boolean deleteUsr(int userId) {
		Boolean userBoolean = getUsr(userId).map(user -> {
			repositoryUser.deleteUser(user);
			return true;
		}).orElse(false);
		return userBoolean;
	}

	/**
	 * Method to verify if email Exist
	 * 
	 * @param email
	 * @return Tre if mail exist
	 */

	public boolean emailExists(String email) {
		return repositoryUser.existEmail(email);
	}

	/**
	 * Method to Verify email and password Exist
	 * 
	 * @param email
	 * @param password
	 * @return User type
	 */

	public User authenticateUser(String email, String password) {
		Optional<User> userAthenticated = repositoryUser.authenticateUser(email, password);

		if (userAthenticated.isEmpty()) {
			return new User();
		} else {
			return userAthenticated.get();
		}
	}

	/**
	 * Method to Get Users by monthBrithtDay parameter : RETO 5
	 * 
	 * @param monthBirthtDay
	 * @return
	 */
	public List<User> birthtDayList(String monthBirthtDay) {
		return repositoryUser.birthtDayList(monthBirthtDay);
	}
}