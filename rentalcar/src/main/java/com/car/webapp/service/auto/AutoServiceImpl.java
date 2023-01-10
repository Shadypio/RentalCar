package com.car.webapp.service.auto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.webapp.domain.auto.Auto;
import com.car.webapp.repository.auto.IAutoRepository;

@Service
public class AutoServiceImpl implements IAutoService {

	@Autowired
	IAutoRepository autoRepository;
	
	@Override
	public List<Auto> getAllAuto() {

		return autoRepository.getAllAuto();
	}

	@Override
	public void insAuto(Auto auto) {
		
		autoRepository.insAuto(auto);
		
	}

	@Override
	public void delAuto(String targa) {
		
		autoRepository.delAuto(targa);
		
	}

	@Override
	public List<Auto> getAutoFromTarga(String targa) {
		
		return autoRepository.getAutoFromTarga(targa);
	}

}
