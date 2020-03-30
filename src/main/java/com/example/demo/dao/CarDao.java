package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Car;

public interface CarDao {
	Car getCarById(long id);
	
	List<Car> getAllCars();
	
	boolean createCar(Car car);
	
	boolean deleteCar(Car car);

	boolean updateCar(Car car);
	
	List<Car> getCarsByOwner(long owner);
	
}
