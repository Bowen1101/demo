package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

@Service
public class PersonService {
	@Autowired
	private PersonDao personDao;
	
	public Person getPersonById(long id) {
		return personDao.getPersonById(id);
	}
	
	public List<Person> getAllPersons(){
		return personDao.getAllPersons();
	}
	
	public boolean deletePerson(Person person) {
		return personDao.deletePerson(person);
	}
	
	public boolean updatePerson(Person person) {
		return personDao.updatePerson(person);
	}
	
	public boolean createPerson(Person person) {
		return personDao.createPerson(person);
	}
}
