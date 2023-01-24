package com.car.webapp.service.rental;

import java.util.List;

import com.car.webapp.domain.customer.Customer;
import com.car.webapp.domain.rental.Rental;

public interface IRentalService {

	List <Rental> getAllRentals();
	
	Rental getRentalById(Long id);
	
	Rental getRentalByCustomer(Customer customer);
	
	void insertRental(Rental rental);
	
	void updateRental(Rental rental);
	
	void deleteRental(Rental rental);
}
