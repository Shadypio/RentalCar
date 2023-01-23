package com.car.webapp.service.prenotazione;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.car.webapp.dao.IRentalDao;
import com.car.webapp.domain.prenotazione.Rental;
import com.car.webapp.domain.utente.Customer;

@Service("rentalService")
@Transactional
public class RentalServiceImpl implements IRentalService {
	
	@Autowired
	private IRentalDao rentalRepository;

	@Override
	public List<Rental> getAllRentals() {
		
		return rentalRepository.doRetrieveAll();
	}

	@Override
	public Rental getRentalById(Long id) {
		
		return rentalRepository.doRetrieveById(id);
	}

	@Override
	public void insertRental(Rental rental) {
		
		rentalRepository.doSave(rental);
		
	}

	@Override
	public void updateRental(Rental rental) {
		
		rentalRepository.doUpdate(rental);
		
	}

	@Override
	public void deleteRental(Rental rental) {
		
		rentalRepository.doDelete(rental);
		
	}

	@Override
	public Rental getRentalByCustomer(Customer customer) {
		
		return rentalRepository.doRetrieveByCustomer(customer);
	}


}
