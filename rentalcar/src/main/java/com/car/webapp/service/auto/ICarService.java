package com.car.webapp.service.auto;

import java.util.List;

import com.car.webapp.domain.auto.Car;

public interface ICarService {

	List<Car> getAllCars();
	
	Car getCarByLicensePlate(String licensePlate);
	
	void insertCar(Car car);
	
	void updateCar(Car car);
	
	void deleteCar(Car car);
}
