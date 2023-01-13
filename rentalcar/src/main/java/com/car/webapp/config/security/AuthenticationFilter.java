package com.car.webapp.config.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException
	{
		if (!request.getMethod().equals("POST"))
		{ 
	       throw new AuthenticationServiceException("Metodo di Autenticazione non supportato: " + request.getMethod());
	    } 
		
		UsernamePasswordAuthenticationToken authRequest = getAuthRequest(request);
		setDetails(request, authRequest);
		
		return this.getAuthenticationManager().authenticate(authRequest);
		
	}
	
	private UsernamePasswordAuthenticationToken getAuthRequest(HttpServletRequest request) 
	{
		 String username = request.getParameter("username");
	     String password = obtainPassword(request);
	     String id = request.getParameter("idParam");
	     
	     username = (username == null) ? "" : username;
	     password = (password == null) ? "" : password;
	     id = (id == null) ? "" : id;
	     
	     String UserWithId = username.trim() + "@" + id;
	        
	     return new UsernamePasswordAuthenticationToken(UserWithId, password);  
	         
	}
}
