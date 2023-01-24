package com.car.webapp.service.role;

import java.util.List;

import com.car.webapp.domain.role.Role;

public interface IRoleService {

	List<Role> getAllRoles();

	Role getRoleById(Long id);

}
