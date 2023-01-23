package com.car.webapp.service.ruolo;

import java.util.List;

import com.car.webapp.domain.ruolo.Role;

public interface IRoleServiec {
	
	List<Role> getAllRoles();
	
	Role getRoleById(Long id);

}
