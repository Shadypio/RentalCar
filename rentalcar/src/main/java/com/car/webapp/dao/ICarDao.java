package com.car.webapp.dao;

import java.util.List;

import com.car.webapp.domain.car.Car;

public interface ICarDao {

	List<Car> doRetrieveAll();
	
	List<Car> doRetrieveByFilter(String filter);
	
	Car doRetrieveByLicensePlate(String licensePlate);

	void doSave(Car car);

	void doUpdate(Car car);

	void doDelete(Car car);

	
	
}
