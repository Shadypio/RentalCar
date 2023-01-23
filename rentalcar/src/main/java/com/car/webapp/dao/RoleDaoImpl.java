package com.car.webapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.car.webapp.domain.ruolo.Role;

@Repository
public class RoleDaoImpl extends AbstractDao<Role, Long> implements IRoleDao {

	
	@Override
	public List<Role> doRetrieveAll() {
		
		return super.doRetrieveAll();
	}
	
	
	@Override
	public Role doRetrieveById(Long id) {
		
		return super.doRetrieveById(id);
		
	}
	
	
}
