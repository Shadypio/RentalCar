package com.car.webapp.repository.auto;

import java.util.List;

import com.car.webapp.domain.auto.Auto;

public interface IAutoRepository {

	List<Auto> getAllAuto();
	void insAuto(Auto auto);
	void delAuto(String targa);
}
