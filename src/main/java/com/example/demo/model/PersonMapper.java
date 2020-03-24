package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonMapper implements RowMapper<Person> {
	public Person mapRow(ResultSet resultSet, int i) throws SQLException{
		
		Person person = new Person();
		person.setId(resultSet.getLong("id"));
		person.setFullName(resultSet.getString("full_name"));
		person.setFirstName(resultSet.getString("first_name"));
		person.setLastName(resultSet.getString("last_name"));
		person.setAge(resultSet.getInt("age"));
		person.setEmail(resultSet.getString("email"));
		person.setAddress(resultSet.getString("address"));
		person.setZipCode(resultSet.getInt("zipcode"));
		return person;
	}
}
