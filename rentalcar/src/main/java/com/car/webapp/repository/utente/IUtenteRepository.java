package com.car.webapp.repository.utente;

import java.util.List;

import com.car.webapp.domain.utente.Utente;

public interface IUtenteRepository {

	List <Utente> getAllUtenti();
	void insUtente(Utente utente);
	void delUtente(Long idUtente);
}
