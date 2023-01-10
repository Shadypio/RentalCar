package com.car.webapp.service.prenotazione;

import java.util.List;

import com.car.webapp.domain.prenotazione.Prenotazione;

public interface IPrenotazioneService {

	List <Prenotazione> getAllPrenotazioni();
	
	Prenotazione selPrenotazioneById(Long id);
	
	void insPrenotazione(Prenotazione prenotazione);
	
	void modificaPrenotazione(Prenotazione prenotazione);
	
	void delPrenotazione(Prenotazione prenotazione);
	
	void delPrenotazioneById(Long id);
}
