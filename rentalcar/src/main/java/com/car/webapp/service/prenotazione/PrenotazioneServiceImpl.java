package com.car.webapp.service.prenotazione;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.car.webapp.dao.IPrenotazioneDao;
import com.car.webapp.domain.prenotazione.Prenotazione;

@Service("prenotazioneService")
@Transactional
public class PrenotazioneServiceImpl implements IPrenotazioneService {
	
	@Autowired
	private IPrenotazioneDao prenotazioneRepository;

	@Override
	public List<Prenotazione> getAllPrenotazioni() {
		
		return prenotazioneRepository.selTutti();
	}

	@Override
	public Prenotazione selPrenotazioneById(Long id) {
		
		return prenotazioneRepository.selById(id);
	}

	@Override
	public void insPrenotazione(Prenotazione prenotazione) {
		
		prenotazioneRepository.salva(prenotazione);
		
	}

	@Override
	public void modificaPrenotazione(Prenotazione prenotazione) {
		
		prenotazioneRepository.aggiorna(prenotazione);
		
	}

	@Override
	public void delPrenotazione(Prenotazione prenotazione) {
		
		prenotazioneRepository.elimina(prenotazione);
		
	}

	@Override
	public void delPrenotazioneById(Long id) {
		
		prenotazioneRepository.eliminaById(id);
		
	}
	
	
	

}
