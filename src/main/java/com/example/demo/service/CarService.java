package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CarDao;
import com.example.demo.model.Car;

@Service
public class CarService {
	
	@Autowired
	private CarDao carDao;
	
	public Car getCarById(long id) {
		return carDao.getCarById(id);
	}
	
	public List<Car> getAllCars(){
		return carDao.getAllCars();
	}
	
	public boolean createCar(Car car) {
		return carDao.createCar(car);
	}
	
	public boolean deleteCar(Car car) {
		return carDao.deleteCar(car);
	}

	public boolean updateCar(Car car) {
		return carDao.updateCar(car);
	}
	
	List<Car> getCarsByOwner(long owner){
		return carDao.getCarsByOwner(owner);
	}
	
}
