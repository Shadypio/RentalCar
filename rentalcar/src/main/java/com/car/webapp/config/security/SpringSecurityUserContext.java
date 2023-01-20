package com.car.webapp.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SpringSecurityUserContext 
{
	SecurityContext context = SecurityContextHolder.getContext();
	Authentication authentication = context.getAuthentication();
	
	public String getCurrentUser()
	{
		String usernameCurrentUser = (authentication != null) ?  authentication.getName() : null;
		
		if (usernameCurrentUser != null && usernameCurrentUser.equals("anonymousUser"))
			usernameCurrentUser = null;
				
		return usernameCurrentUser;
	}
}
