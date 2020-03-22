package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}
	



// https://dzone.com/articles/effective-eclipse-shortcut-key

// ctrl+shift+x all uppercase
// ctrl+shift+y all lowercase
// ctrl+shift+r serach for a file
// ctrl+h search in one file
// ctrl+z ctrl+y 
// ctrl+shift+o remove all unused import