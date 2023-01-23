package com.car.webapp.dao;

import java.util.List;

import com.car.webapp.domain.role.Role;

public interface IRoleDao {

	List<Role> doRetrieveAll();
	
	Role doRetrieveById(Long id);
}
