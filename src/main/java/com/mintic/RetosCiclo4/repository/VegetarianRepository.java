package com.mintic.RetosCiclo4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mintic.RetosCiclo4.model.Vegetarian;

/**
 * Repository to ACCES Model User
 * 
 * @author G5 Desarrollo WEB
 * 
 *
 */
@Repository
public class VegetarianRepository {

	@Autowired
	private VegetarianInterface InterfVegetarianRepo;

	/**
	 * Method to Get All products
	 * 
	 * @return List Type Vegetarian
	 */
	public List<Vegetarian> getAllProducts() {
		return (List<Vegetarian>) InterfVegetarianRepo.findAll();
	}

	/**
	 * Method to Get product by Id
	 * 
	 * @return Unique product
	 */
	public Optional<Vegetarian> getProduct(String reference) {
		return InterfVegetarianRepo.findById(reference);
	}

	/**
	 * Method to Create New product
	 * 
	 * @return Product Saved
	 */
	public Vegetarian createProduct(Vegetarian product) {
		return InterfVegetarianRepo.save(product);
	}

	/**
	 * Method to Update product in DB
	 * 
	 */
	public void updateProduct(Vegetarian product) {
		InterfVegetarianRepo.save(product);
	}

	/**
	 * Method to Delete Unique product in DB
	 * 
	 */
	public void deleteProduct(Vegetarian product) {
		InterfVegetarianRepo.delete(product);
	}

}
