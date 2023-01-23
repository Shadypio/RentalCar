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
	List<I> doRetrieveAll();
	
	void doSave(@NotNull I entity);
	void doUpdate(@NotNull I entity);
	void doDelete(@NotNull I entity);
	void doDeleteById(@NotNull E id);
	I doRetrieveById(@NotNull E id);

}
