package com.car.webapp.dao;

import java.util.List;

import com.car.webapp.domain.utente.Customer;

public interface ICustomerDao {
	
	List<Customer> doRetrieveAll();
	
	Customer doRetrieveById(Long id);
	
	Customer doRetrieveByUsername(String username);

	void doSave(Customer customer);
	
	void doSaveAdminUser(String password);

	void doUpdate(Customer customer);
	
	void doDisableCustomer(Customer customer);
	
	void doEnableCustomer(Customer customer);
	
}
