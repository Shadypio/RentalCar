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
		String CurrentUser = (authentication != null) ?  authentication.getName() : null;
		
		if (CurrentUser != null && CurrentUser.equals("anonymousUser"))
			CurrentUser = null;
				
		return CurrentUser;
	}
}
