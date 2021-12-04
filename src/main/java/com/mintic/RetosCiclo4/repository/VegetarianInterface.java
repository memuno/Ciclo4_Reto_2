package com.mintic.RetosCiclo4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mintic.RetosCiclo4.model.Vegetarian;

/**
 * Interface to Acces CRUD Repository
 * 
 * @author G5 Desarrollo WEB
 *
 */

public interface VegetarianInterface extends MongoRepository<Vegetarian, String> {

}
