package com.example.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.model.Car;
import com.example.demo.model.Person;
import com.example.demo.model.PersonMapper;

@Component
public class PersonDaoImpl implements PersonDao {
	
	JdbcTemplate jdbcTemplate;
	
	private final String SQL_FIND_PERSON = "select * from people where id = ?";
	private final String SQL_DELETE_PERSON = "delete from people where id = ?";
	private final String SQL_DELETE_CAR = "delete from cars where owner = ?";
	private final String SQL_UPDATE_PERSON = "update people set full_name = ?, first_name = ?, last_name = ?, age  = ?, email = ?, address = ?, zipcode = ? where id = ?";
	private final String SQL_GET_ALL = "select * from people";
	private final String SQL_INSERT_PERSON = "insert into people(full_name, first_name, last_name, age, email, address, zipcode) values(?,?,?,?,?,?,?)";
	
	@Autowired
	public PersonDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Person getPersonById(long id) {
		return jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[] { id }, new PersonMapper());
	}

	public List<Person> getAllPersons() {
		return jdbcTemplate.query(SQL_GET_ALL, new PersonMapper());
	}

	public boolean deletePerson(Person person) {
		return jdbcTemplate.update(SQL_DELETE_PERSON, person.getId()) > 0;
	}
	
	public boolean deletePersonAndCars(Person person) {
		List<Car> cars = person.getCars();
		boolean isSuccessful = false;
		if(cars==null) {
			jdbcTemplate.update(SQL_DELETE_PERSON, person.getId());
			isSuccessful = true;
		}else {
			jdbcTemplate.update(SQL_DELETE_CAR, person.getId());
			jdbcTemplate.update(SQL_DELETE_PERSON, person.getId());
			isSuccessful = true;
		}
		return isSuccessful;
	}
	
	public boolean deletePersonById(long id) {
		return jdbcTemplate.update(SQL_DELETE_PERSON,id)>0;
	}

	public boolean updatePerson(Person person) {
		return jdbcTemplate.update(SQL_UPDATE_PERSON, person.getFullName(), person.getFirstName(), person.getLastName(), person.getAge(), person.getEmail(), person.getAddress(), person.getZipCode(),
				person.getId()) > 0;
	}

	public boolean createPerson(Person person) {
		return jdbcTemplate.update(SQL_INSERT_PERSON, person.getFullName(), person.getFirstName(), person.getLastName(), 
				person.getAge(), person.getEmail(), person.getAddress(), person.getZipCode()) > 0;
	}
	
}
