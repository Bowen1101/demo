package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CarDao;
import com.example.demo.dao.PersonDao;
import com.example.demo.model.Car;
import com.example.demo.model.Person;

@Service
public class CarService {
	
	@Autowired
	private CarDao carDao;
	@Autowired
	private PersonDao personDao;
	
	public Car getCarById(long id) {
		return carDao.getCarById(id);
	}
	
	public List<Car> getAllCars(){
		return carDao.getAllCars();
	}
	
	public boolean createCar(Car car) {
		boolean isSuccessful = carDao.createCar(car);
		List<Car> cars = carDao.getCarsByOwner(car.getOwner());
		Person person = personDao.getPersonById(car.getOwner());
		person.setCars(cars);
		return isSuccessful;
	}
	
	public boolean deleteCar(Car car) {
		return carDao.deleteCar(car);
	}
	
	public boolean deleteCarsById(long id) {
		return carDao.deleteCarsById(id);
	}
	
	
	public boolean updateCar(Car car) {
		return carDao.updateCar(car);
	}
	
	public List<Car> getCarsByOwner(long owner){
		return carDao.getCarsByOwner(owner);
	}
	
}
