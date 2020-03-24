package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Person;

public interface PersonDao {
	Person getPersonById(long id);
	
	List<Person> getAllPersons();

	boolean createPerson(Person person);
	
	boolean deletePerson(Person person);

	boolean updatePerson(Person person);

}
