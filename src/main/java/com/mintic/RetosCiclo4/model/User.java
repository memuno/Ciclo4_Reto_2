package com.mintic.RetosCiclo4.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class  Model Mongodb Collection "Usuarios"
 * 
 * @author G5 Desarrollo WEB
 *
 */
@Document(collection = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	private Integer id;
	private String identification;
	private String name;
	private Date birthtDay;
	private String monthBirthtDay;
	private String address;
	private String cellPhone;
	private String email;
	private String password;
	private String zone;
	private String type;

}
