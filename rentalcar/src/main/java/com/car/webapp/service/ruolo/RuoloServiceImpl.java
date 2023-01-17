package com.car.webapp.service.ruolo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.car.webapp.dao.IRuoloDao;
import com.car.webapp.domain.ruolo.Ruolo;

@Service("ruoloService")
@Transactional
public class RuoloServiceImpl implements IRuoloService {

	@Autowired
	private IRuoloDao ruoloRepository;
	
	@Override
	public Ruolo selRuoloById(Long id) {
		
		return ruoloRepository.selById(id);
	}

	@Override
	public List<Ruolo> selTutti() {
		
		return ruoloRepository.selTutti();
	}

}
