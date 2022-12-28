package com.car.webapp.service.utente;

import java.util.List;

import com.car.webapp.domain.utente.Utente;

public interface IUtenteService {

	List <Utente> getAllUtenti();

	void insUtente(Utente utente);

	void delUtente(Long idUtente);
}
