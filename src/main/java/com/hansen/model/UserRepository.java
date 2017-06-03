package com.hansen.model;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.hansen.cnst.Sex;

public interface UserRepository extends MongoRepository<User, String> {

	User findByName(String name);
	
	List<User> findByAgeGreaterThan(int age);

	List<User> findBySex(Sex sex);
	
	//分頁查詢，通過傳進一個Pageable對象，返回Page集合。
	public Page<User> findByAgeGreaterThan(int age,Pageable page) ;

}
