package com.car.webapp.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.car.webapp.domain.auto.Auto;

@Repository
public class AutoDaoImpl extends AbstractDao<Auto, String> implements IAutoDao{

	@Override
	public List<Auto> selTutti() {
		
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Auto> queryDefinition = queryBuilder.createQuery(Auto.class);
		
		Root<Auto> recordset = queryDefinition.from(Auto.class);
		
		queryDefinition.select(recordset);
		
		List<Auto> autoTrovate = entityManager.createQuery(queryDefinition).getResultList();
		
		entityManager.clear();
		
		return autoTrovate;
		
		
	}
	
	@Override
	public Auto selById(String targa) {
		
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Auto> queryDefinition = queryBuilder.createQuery(Auto.class);
		
		Root<Auto> recordset = queryDefinition.from(Auto.class);
		
		queryDefinition.select(recordset)
			.where(queryBuilder.equal(recordset.get("targa"), targa));
		
		Auto auto = entityManager.createQuery(queryDefinition).getSingleResult();
		
		entityManager.clear();
		
		return auto;
		
	}

	@Override
	public void salva(Auto auto) {
		
		super.inserisci(auto);
		
	}

	@Override
	public void aggiorna(Auto auto) {
		
		super.aggiorna(auto);
		
	}

	@Override
	public void elimina(Auto auto) {
		
		super.elimina(auto);
		
	}

}
