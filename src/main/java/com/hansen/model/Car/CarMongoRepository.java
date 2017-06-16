package com.hansen.model.Car;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface  CarMongoRepository extends MongoRepository<Car, String> {

	List<Car> findByModel(String model);


}
