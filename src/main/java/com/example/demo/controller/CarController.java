package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.CarService;

@Controller
public class CarController {
	@Autowired
	private CarService carService;
	
	@RequestMapping("/cars")
	public String getAllCars(Model model) {
		model.addAttribute("cars", carService.getAllCars());
		return "cars";
	}
	
//	@RequestMapping("/peopledetail")
//	public String getCarsByOwner(Model model, @RequestParam(value="owner", required=true) Long owner ) {
////		model.addAttribute("owner", owner);
//		model.addAttribute("peopledetail", carService.getCarsByOwner(owner));
//		return "peopledetail";
//	}
}
