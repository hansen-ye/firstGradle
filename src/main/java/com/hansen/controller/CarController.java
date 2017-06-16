package com.hansen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hansen.model.Car.Car;
import com.hansen.model.Car.CarMongoRepository;

@Controller
public class CarController {

	@Autowired
	CarMongoRepository  carRepository;

	@GetMapping(value = "/car")
	 public String car(Model model){
		 model.addAttribute("carList", carRepository.findAll());
		return "car";
	 }
	 
	@RequestMapping(value = "/addCar" , method = RequestMethod.POST)
	 public String addCar(@ModelAttribute Car car) {
		 carRepository.save(car);
		 return "redirect:car";
	 }
	 
	 
	 @RequestMapping(value = "/search")
		public String search(Model model, @RequestParam String search) {
			model.addAttribute("carList", carRepository.findByModel(search));
			model.addAttribute("search", search);
			return "car";
	 }
}
