package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	

}
