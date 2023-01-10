package com.car.webapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.car.webapp.domain.prenotazione.Prenotazione;

@Repository
public class PrenotazioneDaoImpl extends AbstractDao<Prenotazione, Long> implements IPrenotazioneDao {

	@Override
	public List<Prenotazione> selTutti() {
		
		return super.selTutti();
	}

	@Override
	public Prenotazione selById(Long id) {
		
		return super.selById(id);
	}

	@Override
	public void salva(Prenotazione prenotazione) {
		// TODO Auto-generated method stub

	}

	@Override
	public void aggiorna(Prenotazione prenotazione) {
		// TODO Auto-generated method stub

	}

	@Override
	public void alimina(Prenotazione prenotazione) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminaById(Long id) {
		// TODO Auto-generated method stub

	}

}
