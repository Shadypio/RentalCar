package com.car.webapp.service.rental;

import java.util.List;

import com.car.webapp.domain.customer.Customer;
import com.car.webapp.domain.rental.Rental;

public interface IRentalService {

	List <Rental> getAllRentals();
	
	Rental getRentalById(Long id);
	
	Rental getRentalByCustomer(Customer utente);
	
	void insertRental(Rental prenotazione);
	
	void updateRental(Rental prenotazione);
	
	void deleteRental(Rental prenotazione);
}
