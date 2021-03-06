package com.hansen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hansen.cnst.Sex;
import com.hansen.model.User;
import com.hansen.model.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public void deleteAllUsers() {
		userRepo.deleteAll();
	}
	
	public User addArrayUser(User user) {
		return userRepo.insert(user);
	}
	
	public User findByName(String name) {
		return userRepo.findByName(name);
	}
	
	public List<User> findByAgeGreaterThan(int age) {
		return userRepo.findByAgeGreaterThan(age);
	}
	
	public List<User> findBySex(Sex sex) {
		return userRepo.findBySex(sex);
	}

	public Page<User> findByAgeGreaterThan(int age,Pageable page){
		return userRepo.findByAgeGreaterThan(age,page);
	}
	
}
