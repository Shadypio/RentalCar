package com.car.webapp.service.ruolo;

import java.util.List;

import com.car.webapp.domain.ruolo.Ruolo;

public interface IRuoloService {
	
	List<Ruolo> selTutti();
	
	Ruolo selRuoloById(Long id);

}
