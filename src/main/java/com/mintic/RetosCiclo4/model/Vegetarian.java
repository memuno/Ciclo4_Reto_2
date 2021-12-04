package com.mintic.RetosCiclo4.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Model MongoDB Collection Vegetarians
 * 
 * @author G5 Desarrollo Web
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "vegetarians")
public class Vegetarian {

	@Id
	private String reference;
	private String brand;
	private String category;
	private String description;
	private boolean availability = true;
	private double price;
	private int quantity;
	private String photography;

}
