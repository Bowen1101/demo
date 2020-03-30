package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CarMapper implements RowMapper<Car>{
	public Car mapRow(ResultSet resultSet, int i) throws SQLException{
		
		Car car = new Car();
		car.setId(resultSet.getLong("id"));
		car.setVinNumber(resultSet.getString("vin_number"));
		car.setMake(resultSet.getString("make"));
		car.setModel(resultSet.getString("model"));
		car.setColor(resultSet.getString("color"));
		car.setOwner(resultSet.getLong("owner"));
		return car;
	}
	
}
