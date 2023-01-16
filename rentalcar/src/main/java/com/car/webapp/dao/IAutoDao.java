package com.car.webapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.car.webapp.domain.auto.Auto;

public interface IAutoDao {

	List<Auto> selTutti();
	
	Auto selByTarga(String targa);

	void salva(Auto auto);

	void aggiorna(Auto auto);

	void elimina(Auto auto);
	
	void eliminaById(String targa);
	
}
