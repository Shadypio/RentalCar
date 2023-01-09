package com.car.webapp.dao;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;



/**
 * 
 * @author Si2001
 *
 * @param <I> Entity
 * @param <E> Id
 */
public interface GenericRepository<I extends Serializable, E extends Serializable> {

	@NotNull
	List<I> selTutti();
	
	void inserisci(@NotNull I entity);
	void aggiorna(@NotNull I entity);
	void elimina(@NotNull I entity);
	void eliminaById(@NotNull E id);
	I selById(@NotNull E id);

}
