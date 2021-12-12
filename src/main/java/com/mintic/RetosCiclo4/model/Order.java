package com.mintic.RetosCiclo4.model;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class  Model Mongodb Collection "orders"
 * 
 * @author MARIO GOMEZ
 *
 */

@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	public static String PENDING = "Pendiente";
	public static String APROVED = "Aprobada";
	public static String REJECTED = "Rechazada";

	@Id
	private Integer id;
	private Date registerDay;
	private String status;
	private User salesMan;

	private Map<String, Vegetarian> products;
	private Map<String, Integer> quantities;

}
