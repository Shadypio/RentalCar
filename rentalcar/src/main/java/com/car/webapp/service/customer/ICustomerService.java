package com.car.webapp.service.customer;

import java.util.List;

import com.car.webapp.domain.customer.Customer;

public interface ICustomerService {

	List <Customer> getAllCustomers();
	
	Customer getCustomerById(Long id);
	
	Customer getCustomerByUsername(String username);

	void insertCustomer(Customer customer);
	
	void insertAdminUser(String password);
	
	void updateCustomer(Customer customer);

	void toggleAbilitation(Customer customer);

}
