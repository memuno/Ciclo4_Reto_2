package com.mintic.RetosCiclo4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.RetosCiclo4.model.Vegetarian;
import com.mintic.RetosCiclo4.repository.VegetarianRepository;

/**
 * Class to Access Repository Vegetarian
 * 
 * @author MARIO GOMEZ
 *
 */

@Service
public class VegetarianService {

	@Autowired
	private VegetarianRepository vegetarianRepository;


	/**
	 * 
	 * @return
	 */

	public List<Vegetarian> getAllVegProducts() {
		return vegetarianRepository.getAllProducts();
	}

	/**
	 * 
	 * @param reference
	 * @return
	 */
	public Optional<Vegetarian> getVegProduct(String reference) {
		return vegetarianRepository.getProduct(reference);
	}

	/**
	 * 
	 * @param product
	 * @return
	 */
	public Vegetarian createVegProduct(Vegetarian product) {
		if (product.getReference() == null) {
			return product;
		} else {
			return vegetarianRepository.createProduct(product);
		}
	}

	/**
	 * 
	 * @param product
	 * @return
	 */

	public Vegetarian updateVegProduct(Vegetarian product) {

		if (product.getReference() != null) {
			Optional<Vegetarian> productDb = vegetarianRepository.getProduct(product.getReference());
			if (!productDb.isEmpty()) {

				if (product.getBrand() != null) {
					productDb.get().setBrand(product.getBrand());
				}

				if (product.getCategory() != null) {
					productDb.get().setCategory(product.getCategory());
				}

				if (product.getDescription() != null) {
					productDb.get().setDescription(product.getDescription());
				}
				if (product.getPrice() != 0.0) {
					productDb.get().setPrice(product.getPrice());
				}
				if (product.getQuantity() != 0) {
					productDb.get().setQuantity(product.getQuantity());
				}
				if (product.getPhotography() != null) {
					productDb.get().setPhotography(product.getPhotography());
				}
				productDb.get().setAvailability(product.isAvailability());
				vegetarianRepository.updateProduct(productDb.get());
				return productDb.get();
			} else {
				return product;
			}
		} else {
			return product;
		}
	}

	/**
	 * 
	 * @param reference
	 * @return
	 */
	public boolean deleteVegProduct(String reference) {
		Boolean vegetBoolean = getVegProduct(reference).map(product -> {
			vegetarianRepository.deleteProduct(product);
			return true;
		}).orElse(false);
		return vegetBoolean;
	}

	/**
	 * Method to get products by price less or equal than price parameter RETO 5
	 * 
	 * @param price
	 * @return List products
	 */
	public List<Vegetarian> productByPrice(double price) {
		return vegetarianRepository.productByPrice(price);
	}

	/**
	 * Method to get products by description parameter RETO 5
	 * 
	 * @param description
	 * @return List products
	 */
	public List<Vegetarian> findByDescriptionLike(String description) {
		return vegetarianRepository.findByDescriptionLike(description);
	}

}
