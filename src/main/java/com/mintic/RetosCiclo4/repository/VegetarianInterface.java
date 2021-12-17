package com.mintic.RetosCiclo4.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mintic.RetosCiclo4.model.Vegetarian;

/**
 * Interface to Acces CRUD Repository
 * 
 * @author G5 Desarrollo WEB
 *
 */

public interface VegetarianInterface extends MongoRepository<Vegetarian, String> {

	// Reto 5 - EP: /api/vegetarian/price/{precio}
	public List<Vegetarian> findByPriceLessThanEqual(double precio);

	// Reto 5 - EP:/api/vegetarian/description/{calidad}
	@Query("{'description':{'$regex':'?0','$options':'i'}}")
	public List<Vegetarian> findByDescriptionLike(String description);

}
