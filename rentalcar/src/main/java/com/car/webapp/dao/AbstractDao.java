package com.car.webapp.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

public abstract class AbstractDao<I extends Serializable, Id extends Serializable> implements GenericRepository<I, Id> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected final Class<I> entityClass;

	CriteriaBuilder builder;

	@SuppressWarnings("unchecked")
	public AbstractDao()
	{
		this.entityClass = (Class<I>) ((ParameterizedType) 
				this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	private CriteriaQuery<I> InitCriteria()
	{
		builder = this.entityManager.getCriteriaBuilder();
		return builder.createQuery(this.entityClass);
	}

	@Override
	public List<I> selTutti() {
		
		
		CriteriaQuery<I> query = this.InitCriteria();

		return this.entityManager.createQuery(
				query.select(query.from(this.entityClass))).getResultList();
	}

	@Override
	public I selById(Id id) {
		CriteriaQuery<I> query = this.InitCriteria();
			return this.entityManager.createQuery(
				query.where(
						builder.equal(
								query.from(this.entityClass).
								get("id"), id))).
				getSingleResult();
	}

	@Override
	@Transactional
	public void inserisci(I entity)
	{
		this.entityManager.persist(entity);
		flushAndClear();
	}

	@Override
	public void aggiorna(I entity)
	{
		this.entityManager.merge(entity); 
		flushAndClear();
	}

	@Override
	public void elimina(I entity)
	{

		this.entityManager.remove(this.entityManager.contains(entity) ? entity : this.entityManager.merge(entity));
		flushAndClear();

	}

	@Override
	public void eliminaById(Id id)
	{
		CriteriaQuery<I> query = this.InitCriteria();

		this.entityManager.createQuery(
				query.where(
						builder.equal(
								query.from(this.entityClass)
								.get("id"), id)
						)).executeUpdate();

		flushAndClear();
	}

	private void flushAndClear() 
	{
		entityManager.flush();
		entityManager.clear();
	}
}
