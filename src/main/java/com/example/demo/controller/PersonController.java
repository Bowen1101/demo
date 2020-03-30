package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Person;
import com.example.demo.service.CarService;
import com.example.demo.service.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;
	@Autowired
	private CarService carService;
	
	@RequestMapping("/people")
	public String listAllPeople(Model model) {
		
		model.addAttribute("people", personService.getAllPersons());
		
		return "people";
	}
	
	@GetMapping("/addpeople")
	public String addPeople(Model model) {
		model.addAttribute("person", new Person());
		return "addpeople";
	}
	
	@PostMapping("/addpeople")
	public String showResult(Model model,@ModelAttribute("person") Person person) {
		return "result";
	}
	
	@RequestMapping("/peopledetail")
	public String getCarsByOwner(Model model, @RequestParam(value="owner", required=true) Long owner ) {
//		model.addAttribute("owner", owner);
		model.addAttribute("peopledetail", carService.getCarsByOwner(owner));
		return "peopledetail";
	}
}
