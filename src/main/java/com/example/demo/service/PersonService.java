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
	
//	public boolean deletePersonAndCars(Person person) {
//		return personDao.deletePersonAndCars(person);
//	}
	
	public boolean deletePersonAndCarsById(long id) {
//		when I create a car and set into person.cars, then call person.cars it's still null 
//		Person person = personDao.getPersonById(id);
//		List<Car> cars1 = person.getCars();
		List<Car> cars = carDao.getCarsByOwner(id);
		if(cars != null) {
			carDao.deleteCarByOwner(id);
		}
		return personDao.deletePersonById(id);
	}
	
	public boolean deletePersonById(long id) {
		return personDao.deletePersonById(id);
	}
	
	public boolean updatePerson(Person person) {
		return personDao.updatePerson(person);
	}
	
	public boolean createPerson(Person person) {
		return personDao.createPerson(person);
	}
	
	public boolean createOrUpdatePerson(Person person) {
		boolean isSuccess = false;
		if(person.getId()==0) {
			personDao.createPerson(person);
		}else {
			personDao.updatePerson(person);
		}
		return isSuccess;
	}
	
	public boolean updatePersonById(long id) {
		Person person = personDao.getPersonById(id);
		return personDao.updatePerson(person);
	}
}
