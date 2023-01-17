package com.car.webapp.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.car.webapp.domain.ruolo.Ruolo;

@Repository
public class RuoloDaoImpl extends AbstractDao<Ruolo, Long> implements IRuoloDao {

	@Override
	public Ruolo selById(Long id) {
		
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Ruolo> queryDefinition = queryBuilder.createQuery(Ruolo.class);
		
		Root<Ruolo> recordset = queryDefinition.from(Ruolo.class);
		
		queryDefinition.select(recordset)
			.where(queryBuilder.equal(recordset.get("idRuolo"), id));
		
		Ruolo ruolo = entityManager.createQuery(queryDefinition).getSingleResult();
		
		entityManager.clear();
		
		return ruolo;
		
	}
	
	@Override
	public List<Ruolo> selTutti() {
		
		return super.selTutti();
	}
}
