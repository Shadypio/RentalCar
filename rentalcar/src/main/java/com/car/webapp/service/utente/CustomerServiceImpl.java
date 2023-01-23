package com.car.webapp.service.utente;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.car.webapp.dao.ICustomerDao;
import com.car.webapp.domain.utente.Customer;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		
		return customerRepository.doRetrieveAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		 
		return customerRepository.doRetrieveById(id);
	}

	@Override
	public void insertCustomer(Customer customer) {
		
		customer.setEnabled(true);
		customerRepository.doSave(customer);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		
		customer.setEnabled(true);
		customerRepository.doUpdate(customer);
		
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		
		return customerRepository.doRetrieveByUsername(username);
	}

	@Override
	public void insertAdminUser(String password) {
		
		customerRepository.doSaveAdminUser(password);
		
	}

	@Override
	public void disableCustomer(Customer customer) {
		
		customerRepository.doDisableCustomer(customer);
		
	}
	
	@Override
	public void enableCustomer(Customer customer) {
		
		customerRepository.doEnableCustomer(customer);
		
	}
	
	
	
	

}
