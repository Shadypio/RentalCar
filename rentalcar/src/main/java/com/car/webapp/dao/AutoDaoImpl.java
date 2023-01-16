package com.car.webapp.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.car.webapp.domain.auto.Auto;

@Repository
public class AutoDaoImpl extends AbstractDao<Auto, String> implements IAutoDao{



	// HQL
	@SuppressWarnings("unchecked")
	@Override
	public List<Auto> selTutti() {
		//HQL example - Get All Auto
		return entityManager.createQuery("from Auto").getResultList();

	}

	// HQL
	@SuppressWarnings("unchecked")
	@Override
	public Auto selByTarga(String targa) {

		//HQL example - Get Employee with id
		Query query = (Query) (entityManager.createQuery("from Auto where targa= :targa"));
		query.setParameter("targa", targa);
		return (Auto) query.uniqueResult();
	}

	/*@Override
	public List<Auto> selTutti() {


		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Auto> queryDefinition = queryBuilder.createQuery(Auto.class);

		Root<Auto> recordset = queryDefinition.from(Auto.class);

		queryDefinition.select(recordset);

		List<Auto> autoTrovate = entityManager.createQuery(queryDefinition).getResultList();

		entityManager.clear();

		return autoTrovate;


		return super.selTutti();


	}

	@Override
	public Auto selByTarga(String targa) {


		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Auto> queryDefinition = queryBuilder.createQuery(Auto.class);

		Root<Auto> recordset = queryDefinition.from(Auto.class);

		queryDefinition.select(recordset)
			.where(queryBuilder.equal(recordset.get("targa"), targa));

		Auto auto = entityManager.createQuery(queryDefinition).getSingleResult();

		entityManager.clear();

		return auto;

		//return super.selById(targa);

	} */

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

	@Override
	public void eliminaById(String targa) {

		// super.eliminaById(targa);

		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Auto> queryDefinition = queryBuilder.createQuery(Auto.class);

		this.entityManager.createQuery(
				queryDefinition.where(
						builder.equal(
								queryDefinition.from(this.entityClass)
								.get("targa"), targa)
						)).executeUpdate();

		entityManager.flush();
		entityManager.clear();

	}
		



}
