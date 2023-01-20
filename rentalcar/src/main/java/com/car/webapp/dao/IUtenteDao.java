package com.car.webapp.dao;

import java.util.List;

import com.car.webapp.domain.utente.Utente;

public interface IUtenteDao {
	
	List<Utente> selTutti();
	
	Utente selById(Long id);
	
	Utente selByUsername(String username);

	void salva(Utente utente);
	
	void salvaAdminUser(String password);

	void aggiorna(Utente utente);
	
	void disabilitaUtente(Utente utente);
	
	void abilitaUtente(Utente utente);
	
}
