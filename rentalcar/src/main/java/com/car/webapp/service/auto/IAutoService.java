package com.car.webapp.service.auto;

import java.util.List;

import com.car.webapp.domain.auto.Auto;

public interface IAutoService {

	List<Auto> getAllAuto();
	
	Auto getAutoFromTarga(String targa);
	
	void insAuto(Auto auto);
	
	void modificaAuto(Auto auto);
	
	void delAutoById(String targa);
	
	void delAuto(Auto auto);
}
