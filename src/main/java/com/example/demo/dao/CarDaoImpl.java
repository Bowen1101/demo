package com.example.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.model.Car;
import com.example.demo.model.CarMapper;

@Component
public class CarDaoImpl implements CarDao {
	JdbcTemplate jdbcTemplate;
	
	
	private final String SQL_FIND_CAR = "select * from cars where id = ?";
	private final String SQL_DELETE_CAR = "delete from cars where id = ?";
	private final String SQL_UPDATE_CAR = "update cars set vin_number = ?, make = ?, model = ?, color  = ?, owner = ? where id = ?";
	private final String SQL_GET_ALL = "select * from cars";
	private final String SQL_INSERT_CAR = "insert into cars(vin_number, make, model, color, owner) values(?,?,?,?,?)";
	private final String SQL_FIND_CARS_BY_OWNER = "select * from cars where owner = ?";

	@Autowired
	public CarDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Car getCarById(long id) {
		return jdbcTemplate.queryForObject(SQL_FIND_CAR, new Object[] { id }, new CarMapper());
	}
	
	public List<Car> getAllCars(){
		return jdbcTemplate.query(SQL_GET_ALL, new CarMapper());
	}
	
	public boolean createCar(Car car) {
		return jdbcTemplate.update(SQL_INSERT_CAR, car.getVinNumber(), car.getMake(), car.getModel(), car.getColor(), car.getOwner()) > 0;
	}
	
	public boolean deleteCar(Car car) {
		return jdbcTemplate.update(SQL_DELETE_CAR, car.getId()) > 0;
	}
	
	public boolean updateCar(Car car) {
		return jdbcTemplate.update(SQL_UPDATE_CAR, car.getVinNumber(), car.getMake(), car.getModel(), car.getColor(), car.getOwner(), car.getId()) > 0;
	}
	
	public List<Car> getCarsByOwner(long owner){
		return jdbcTemplate.query(SQL_FIND_CARS_BY_OWNER, new Object[] {owner},new CarMapper());
	}
	
}
