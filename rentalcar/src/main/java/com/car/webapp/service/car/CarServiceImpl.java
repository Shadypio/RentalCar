package com.car.webapp.service.car;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.car.webapp.dao.ICarDao;
import com.car.webapp.domain.car.Car;

@Service("carService")
@Transactional
public class CarServiceImpl implements ICarService {

	@Autowired
	ICarDao carRepository;
	
	@Override
	public List<Car> getAllCars() {

		return carRepository.doRetrieveAll();
	}

	
	@Override
	public Car getCarByLicensePlate(String licensePlate) {
		
		return carRepository.doRetrieveByLicensePlate(licensePlate);
	}
	
	
	@Override
	public void insertCar(Car car) {
		
		carRepository.doSave(car);
		
	}
	

	@Override
	public void updateCar(Car car) {
		
		carRepository.doUpdate(car);
		
	}


	@Override
	public void deleteCar(Car car) {
		
		carRepository.doDelete(car);
		
	}

}
