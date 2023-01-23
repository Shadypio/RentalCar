package com.car.webapp.service.role;

import java.util.List;

import com.car.webapp.domain.role.Role;

public interface IRoleServiec {
	
	List<Role> getAllRoles();
	
	Role getRoleById(Long id);

}
