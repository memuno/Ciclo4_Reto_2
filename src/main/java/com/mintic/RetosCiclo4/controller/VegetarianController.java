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

import com.mintic.RetosCiclo4.model.Vegetarian;
import com.mintic.RetosCiclo4.service.VegetarianService;

/**
 * Class VegetarianController to Acces API REST
 * 
 * @author G5 Desarrollo WEB
 *
 */

@RestController
@RequestMapping("/api/vegetarian")
@CrossOrigin("*")
public class VegetarianController {

	@Autowired
	private VegetarianService ServiceVegetarian;

	/**
	 * Method to Get ALL Products Collections Vegetarian
	 * 
	 * @return List Vegetarian Products
	 */
	@GetMapping("/all")
	public List<Vegetarian> getAllProductsVeg() {
		return ServiceVegetarian.getAllVegProducts();
	}

	/**
	 * Method to Get Product Collections Vegetarian
	 * 
	 * @param reference
	 * @return Vegetarian Product
	 */
	@GetMapping("/{reference}")
	public Optional<Vegetarian> getProductVeg(@PathVariable("reference") String reference) {
		return ServiceVegetarian.getVegProduct(reference);
	}

	/**
	 * Method to Create Product Collections Vegetarian
	 * 
	 * @param product
	 * @return Vegetarian Product
	 */
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public Vegetarian createProductVeg(@RequestBody Vegetarian product) {
		return ServiceVegetarian.createVegProduct(product);
	}

	/**
	 * Method to Update Product Collections Vegetarian
	 * 
	 * @param product
	 * @return Vegetarian Product
	 */
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Vegetarian updateProductVeg(@RequestBody Vegetarian product) {
		return ServiceVegetarian.updateVegProduct(product);
	}

	/**
	 * Method to Delete Product Collections Vegetarian
	 * 
	 * @param reference
	 * @return True or False
	 */
	@DeleteMapping("/{reference}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteProductVeg(@PathVariable("reference") String reference) {
		return ServiceVegetarian.deleteVegProduct(reference);
	}

	/**
	 * Method Endpoint: /api/vegetarian/price/{price} RETO 5
	 * 
	 * @param precio
	 * @return
	 */
	@GetMapping("/price/{price}")
	public List<Vegetarian> productByPrice(@PathVariable("price") double precio) {
		return ServiceVegetarian.productByPrice(precio);
	}

	/**
	 * Method Endpoint: /api/vegetarian/description/{Description} RETO 5
	 * 
	 * @param description
	 * @return
	 */
	@GetMapping("/description/{description}")
	public List<Vegetarian> findByDescriptionLike(@PathVariable("description") String description) {
		return ServiceVegetarian.findByDescriptionLike(description);
	}
}
