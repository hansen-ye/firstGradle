package com.hansen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hansen.model.User;
import com.hansen.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * <pre>
	 * 使用名字查詢使用者
	 * </pre>
	 * 
	 * @param name 要查詢的名字
	 * @return User 對應的使用者
	 */
	@RequestMapping(value = "name/{name}", method = RequestMethod.GET)
	@ApiOperation(value = "使用名字查詢使用者", response = User.class)
	@ResponseBody
	public User getUserByName(@ApiParam("要查詢的使用者名字") @PathVariable String name) {
		return userService.findByName(name);
	}
	
	/**
	 * <pre>
	 * 使用年齡查詢超過幾歲的使用者
	 * </pre>
	 * 
	 * @param age
	 * @return
	 */
	@RequestMapping(value = "/age/{age}", method = RequestMethod.GET)
	@ApiOperation(value = "使用年齡查詢超過幾歲的使用者", response = User.class)
	@ResponseBody
	public List<User> findByAgeGreaterThan(@PathVariable int age) {
		return userService.findByAgeGreaterThan(age);
	}
	
	//利用分頁
	@RequestMapping(value = "/pageAge/{age}", method = RequestMethod.GET)
	@ResponseBody
	public Page<User> ffindByAgeGreaterThan(@PathVariable int age,Pageable page) {
		return userService.findByAgeGreaterThan(age,page);
	}
	
}
