package com.car.webapp.dao;

import java.util.List;

import com.car.webapp.domain.prenotazione.Prenotazione;

public interface IPrenotazioneDao {

	List<Prenotazione> selTutti();
	
	Prenotazione selById(Long id);
	
	void salva(Prenotazione prenotazione);
	
	void aggiorna(Prenotazione prenotazione);
	
	void elimina(Prenotazione prenotazione);
	
	void eliminaById(Long id);
}
