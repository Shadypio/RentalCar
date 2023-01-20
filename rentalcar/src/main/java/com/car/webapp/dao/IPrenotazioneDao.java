package com.car.webapp.dao;

import java.util.List;

import com.car.webapp.domain.prenotazione.Prenotazione;
import com.car.webapp.domain.utente.Utente;

public interface IPrenotazioneDao {

	List<Prenotazione> selTutti();
	
	Prenotazione selById(Long id);
	
	Prenotazione selByUtente(Utente utente);
	
	void salva(Prenotazione prenotazione);
	
	void aggiorna(Prenotazione prenotazione);
	
	void elimina(Prenotazione prenotazione);
}
