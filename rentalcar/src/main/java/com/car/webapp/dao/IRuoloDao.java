package com.car.webapp.dao;

import java.util.List;

import com.car.webapp.domain.ruolo.Ruolo;

public interface IRuoloDao {

	List<Ruolo> selTutti();
	Ruolo selById(Long id);
}
