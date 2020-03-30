package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CarDao;
import com.example.demo.dao.PersonDao;
import com.example.demo.model.Car;
import com.example.demo.model.Person;

@Service
public class PersonService {
	@Autowired
	private PersonDao personDao;
	@Autowired
	private CarDao carDao;
	
	public Person getPersonById(long id) {
		List<Car> cars = carDao.getCarsByOwner(id);
		Person person = personDao.getPersonById(id);
		person.setCars(cars);
		return person;
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
