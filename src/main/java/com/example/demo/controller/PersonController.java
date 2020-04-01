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
import com.example.demo.service.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/people")
	public String listAllPeople(Model model) {
		
		model.addAttribute("people", personService.getAllPersons());
		
		return "people";
	}
	
	@GetMapping("/addperson")
	public String addPeople(Model model) {
		model.addAttribute("person", new Person());
		return "addperson";
	}
	
	@PostMapping("/addperson")
	public String showResult(Model model,@ModelAttribute("person") Person person) {
		boolean isSuccess = personService.createPerson(person);
		return "result";
	}
	
	@RequestMapping("/persondetail")
	public String showPersonDetail(Model model, @RequestParam(value="owner", required=true) Long owner ) {
//		List<Car> cars = personService.getPersonById(owner).getCars();
		model.addAttribute("person", personService.getPersonById(owner));
//		model.addAttribute("cars", personService.getPersonById(owner).getCars());
		return "persondetail";
	}
}
