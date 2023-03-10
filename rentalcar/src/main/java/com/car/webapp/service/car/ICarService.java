package com.car.webapp.service.car;

import java.util.List;

import com.car.webapp.domain.car.Car;

public interface ICarService {

	List<Car> getAllCars();
	
	List<Car> getCarsByFilter(String filter);
	
	Car getCarByLicensePlate(String licensePlate);
	
	void insertCar(Car car);
	
	void updateCar(Car car);
	
	void deleteCar(Car car);

}
