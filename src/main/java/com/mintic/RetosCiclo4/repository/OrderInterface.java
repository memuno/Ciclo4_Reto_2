package com.mintic.RetosCiclo4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mintic.RetosCiclo4.model.Order;

/**
 * Interface to CRUD repository Collection "orders"
 * 
 * @author MARIO
 *
 */
public interface OrderInterface extends MongoRepository<Order, Integer> {

	// Query to Collection "Orders" by key salesMan.zone
	@Query("{'salesMan.zone': ?0}")
	List<Order> findByZone(final String country);

	// Query to Collection "orders" by key status
	List<Order> findByStatus(final String status);

	// Query to Collection " orders" to get max id
	Optional<Order> findTopByOrderByIdDesc();

}
