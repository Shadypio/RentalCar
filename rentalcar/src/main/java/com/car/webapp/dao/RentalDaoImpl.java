package com.car.webapp.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.car.webapp.domain.customer.Customer;
import com.car.webapp.domain.rental.Rental;

@Repository
public class RentalDaoImpl extends AbstractDao<Rental, Long> implements IRentalDao {

	@Override
	public List<Rental> doRetrieveAll() {
		
		return super.doRetrieveAll();
	}

	@Override
	public Rental doRetrieveById(Long id) {
		
		return super.doRetrieveById(id);
	}

	@Override
	public void doSave(Rental rental) {
		
		super.doSave(rental);

	}

	@Override
	public void doUpdate(Rental rental) {
		
		super.doUpdate(rental);

	}

	@Override
	public void doDelete(Rental rental) {
		
		super.doDelete(rental);

	}

	@Override
	public Rental doRetrieveByCustomer(Customer customer) {
		
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Rental> queryDefinition = queryBuilder.createQuery(Rental.class);
		
		Root<Rental> recordset = queryDefinition.from(Rental.class);
		
		queryDefinition.select(recordset)
			.where(queryBuilder.equal(recordset.get("referredCustomer"), customer));
		
		Rental rental = entityManager.createQuery(queryDefinition).getSingleResult();
		
		entityManager.flush();
		entityManager.clear();
		
		return rental;
	}

}
