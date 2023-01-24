package com.car.webapp.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.car.webapp.domain.car.Car;

@Repository
public class CarDaoImpl extends AbstractDao<Car, String> implements ICarDao{

	@Override
	public List<Car> doRetrieveAll() {

		return super.doRetrieveAll();

	}

	@Override
	public Car doRetrieveByLicensePlate(String licensePlate) {


		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Car> queryDefinition = queryBuilder.createQuery(Car.class);

		Root<Car> recordset = queryDefinition.from(Car.class);

		queryDefinition.select(recordset)
			.where(queryBuilder.equal(recordset.get("licensePlate"), licensePlate));

		Car car = entityManager.createQuery(queryDefinition).getSingleResult();

		entityManager.clear();

		return car;

	} 

	@Override
	public void doSave(Car car) {

		super.doSave(car);

	}

	@Override
	public void doUpdate(Car car) {

		super.doUpdate(car);

	}

	@Override
	public void doDelete(Car car) {

		super.doDelete(car);
		

	}

		



}
