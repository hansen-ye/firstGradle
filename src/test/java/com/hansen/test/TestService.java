package com.hansen.test;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.hansen.Application;
import com.hansen.cnst.Sex;
import com.hansen.model.User;
import com.hansen.service.UserService;

@RunWith(SpringRunner.class)
	@SpringBootTest(
	classes = Application.class,
	webEnvironment = WebEnvironment.RANDOM_PORT
)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestService {

	@Autowired
	private UserService userService;
	
	@Test
	public void test_01_UserService() {
		userService.deleteAllUsers();
		System.out.println("Delete all users succeed");
		
		userService.addUser("Hansen", Sex.MALE, 38);
		System.out.println("Add Hansen succeed");
		
		userService.addUser("Tommy", Sex.MALE, 18);
		System.out.println("Add Tommy succeed");
		
		userService.addUser("Square", Sex.FEMALE, 18);
		System.out.println("Add Square succeed");
		
		List<User> usersAgeGreaterThan30 = userService.findByAgeGreaterThan(30);
		System.out.println(usersAgeGreaterThan30);
		
		List<User> females = userService.findBySex(Sex.FEMALE);
		System.out.println(females);
	}
}
