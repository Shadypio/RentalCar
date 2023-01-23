package com.car.webapp.service.utente;

import java.util.List;

import com.car.webapp.domain.utente.Customer;

public interface ICustomerService {

	List <Customer> getAllCustomers();
	
	Customer getCustomerById(Long id);
	
	Customer getCustomerByUsername(String username);

	void insertCustomer(Customer utente);
	
	void insertAdminUser(String password);
	
	void updateCustomer(Customer utente);
	
	void disableCustomer(Customer utente);
	
	void enableCustomer(Customer utente);

}
