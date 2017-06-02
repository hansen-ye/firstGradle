package com.hansen.model;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hansen.cnst.Sex;

public interface UserRepository extends MongoRepository<User, String> {

	User findByName(String name);
	
	List<User> findByAgeGreaterThan(int age);

	List<User> findBySex(Sex sex);

}
