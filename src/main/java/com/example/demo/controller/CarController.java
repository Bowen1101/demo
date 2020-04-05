package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Car;
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
	
	@GetMapping("/addcar")
	public String addCar(Model model) {
		model.addAttribute("car", new Car());
		return "addcar";
	}
	
	@PostMapping("/addcar")
	public String showAddCarResult(Model model,@ModelAttribute("car") Car car) {
		carService.createCar(car);
		return "addcarresult";
	}
	
	@RequestMapping("/deletecar")
	public String deleteCarById(Model model, @RequestParam(value="id", required=true) long id) {
		carService.deleteCarsById(id);
		return "redirect:/cars";
	}
	
	
}
