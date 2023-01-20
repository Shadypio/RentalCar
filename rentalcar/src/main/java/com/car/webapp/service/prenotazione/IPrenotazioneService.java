package com.car.webapp.service.prenotazione;

import java.util.List;

import com.car.webapp.domain.prenotazione.Prenotazione;
import com.car.webapp.domain.utente.Utente;

public interface IPrenotazioneService {

	List <Prenotazione> getAllPrenotazioni();
	
	Prenotazione selPrenotazioneById(Long id);
	
	Prenotazione getPrenotazioneByUtente(Utente utente);
	
	void insPrenotazione(Prenotazione prenotazione);
	
	void modificaPrenotazione(Prenotazione prenotazione);
	
	void delPrenotazione(Prenotazione prenotazione);
}
