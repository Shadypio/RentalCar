package com.car.webapp.dao;

import java.util.List;

import com.car.webapp.domain.auto.Car;

public interface ICarDao {

	List<Car> doRetrieveAll();
	
	Car doRetrieveByLicensePlate(String targa);

	void doSave(Car auto);

	void doUpdate(Car auto);

	void doDelete(Car auto);
	
}
