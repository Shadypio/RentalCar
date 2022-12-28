package com.car.webapp.service.utente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.webapp.domain.utente.Utente;
import com.car.webapp.repository.utente.IUtenteRepository;

@Service
public class UtenteServiceImpl implements IUtenteService {
	
	@Autowired 
	IUtenteRepository utenteRepository;

	@Override
	public List<Utente> getAllUtenti() {
		
		return utenteRepository.getAllUtenti();
	}

	@Override
	public void insUtente(Utente utente) {
		
		utenteRepository.insUtente(utente);

	}

	@Override
	public void delUtente(Long idUtente) {
		
		utenteRepository.delUtente(idUtente);

	}

}
