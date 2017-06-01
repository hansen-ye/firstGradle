package com.hansen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hansen.service.GetFirstService;

@Controller
@RequestMapping(value = "/test")
public class HelloController {

	@Autowired
	private GetFirstService getFirstService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String home() {
		return getFirstService.getHello();
	}

}