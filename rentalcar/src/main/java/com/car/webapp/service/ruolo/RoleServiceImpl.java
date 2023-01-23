package com.car.webapp.service.ruolo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.car.webapp.dao.IRoleDao;
import com.car.webapp.domain.ruolo.Role;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements IRoleServiec {

	@Autowired
	private IRoleDao roleRepository;
	
	@Override
	public List<Role> getAllRoles() {
		
		return roleRepository.doRetrieveAll();
	}
	
	@Override
	public Role getRoleById(Long id) {
		
		return roleRepository.doRetrieveById(id);
	}

	

}
