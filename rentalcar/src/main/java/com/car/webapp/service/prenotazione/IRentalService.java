package com.car.webapp.service.prenotazione;

import java.util.List;

import com.car.webapp.domain.prenotazione.Rental;
import com.car.webapp.domain.utente.Customer;

public interface IRentalService {

	List <Rental> getAllRentals();
	
	Rental getRentalById(Long id);
	
	Rental getRentalByCustomer(Customer utente);
	
	void insertRental(Rental prenotazione);
	
	void updateRental(Rental prenotazione);
	
	void deleteRental(Rental prenotazione);
}
