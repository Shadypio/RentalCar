package com.car.webapp.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.car.webapp.domain.auto.Auto;
import com.car.webapp.domain.prenotazione.Prenotazione;
import com.car.webapp.domain.utente.Utente;

@Repository
public class PrenotazioneDaoImpl extends AbstractDao<Prenotazione, Long> implements IPrenotazioneDao {

	@Override
	public List<Prenotazione> selTutti() {
		
//		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Prenotazione> queryDefinition = queryBuilder.createQuery(Prenotazione.class);
//		
//		Root<Prenotazione> recordset = queryDefinition.from(Prenotazione.class);
//		
//		queryDefinition.select(recordset);
//		
//		List<Prenotazione> prenotazioniTrovate = entityManager.createQuery(queryDefinition).getResultList();
//		
//		entityManager.clear();
//		
//		return prenotazioniTrovate;
		
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
		
		// return super.selById(id);
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
	public void eliminaById(Long id) {
		
		// super.eliminaById(id);
		
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Prenotazione> queryDefinition = queryBuilder.createQuery(Prenotazione.class);

		this.entityManager.createQuery(
				queryDefinition.where(
						builder.equal(
								queryDefinition.from(this.entityClass)
								.get("idPrenotazione"), id)
						)).executeUpdate();

		entityManager.flush();
		entityManager.clear();

	}

}
