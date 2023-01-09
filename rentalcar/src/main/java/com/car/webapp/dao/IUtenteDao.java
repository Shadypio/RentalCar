package com.car.webapp.dao;

import java.util.List;

import com.car.webapp.domain.utente.Utente;

public interface IUtenteDao {
	
	List<Utente> selTutti();
	
	Utente selById(Long id);

	void salva(Utente cliente);

	void aggiorna(Utente cliente);

	void elimina(Utente cliente);
}
