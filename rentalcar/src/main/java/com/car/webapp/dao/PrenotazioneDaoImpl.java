package com.car.webapp.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.car.webapp.domain.prenotazione.Prenotazione;
import com.car.webapp.domain.utente.Utente;

@Repository
public class PrenotazioneDaoImpl extends AbstractDao<Prenotazione, Long> implements IPrenotazioneDao {

	@Override
	public List<Prenotazione> selTutti() {
		
		return super.selTutti();
	}

	@Override
	public Prenotazione selById(Long id) {
		
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Prenotazione> queryDefinition = queryBuilder.createQuery(Prenotazione.class);
		
		Root<Prenotazione> recordset = queryDefinition.from(Prenotazione.class);
		
		queryDefinition.select(recordset)
			.where(queryBuilder.equal(recordset.get("idPrenotazione"), id));
		
		Prenotazione prenotazione = entityManager.createQuery(queryDefinition).getSingleResult();
		
		entityManager.flush();
		entityManager.clear();
		
		return prenotazione;
	}

	@Override
	public void salva(Prenotazione prenotazione) {
		
		super.inserisci(prenotazione);

	}

	@Override
	public void aggiorna(Prenotazione prenotazione) {
		
		super.aggiorna(prenotazione);

	}

	@Override
	public void elimina(Prenotazione prenotazione) {
		
		super.elimina(prenotazione);

	}

	@Override
	public Prenotazione selByUtente(Utente utente) {
		
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Prenotazione> queryDefinition = queryBuilder.createQuery(Prenotazione.class);
		
		Root<Prenotazione> recordset = queryDefinition.from(Prenotazione.class);
		
		queryDefinition.select(recordset)
			.where(queryBuilder.equal(recordset.get("utenteRiferito"), utente));
		
		Prenotazione prenotazione = entityManager.createQuery(queryDefinition).getSingleResult();
		
		entityManager.flush();
		entityManager.clear();
		
		return prenotazione;
	}

}
