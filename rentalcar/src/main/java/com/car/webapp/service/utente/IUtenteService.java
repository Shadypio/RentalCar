package com.car.webapp.service.utente;

import java.util.List;

import com.car.webapp.domain.utente.Utente;

public interface IUtenteService {

	List <Utente> getAllUtenti();
	
	Utente selUtenteById(Long id);

	void insUtente(Utente utente);
	
	void modificaUtente(Utente utente);

	void delUtente(Utente Utente);
	
	void delUtenteById(Long id);
}
