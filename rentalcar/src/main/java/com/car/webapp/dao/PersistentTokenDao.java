package com.car.webapp.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.car.webapp.domain.customer.Logins;

@Repository("persistentTokenRepository")
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
public class PersistentTokenDao implements PersistentTokenRepository{

	@PersistenceContext
	protected EntityManager entityManager;
	
	private void flushAndClear() 
	{
	    entityManager.flush();
	    entityManager.clear();
	}
	
	@Override
	public void createNewToken(PersistentRememberMeToken token)
	{
		Logins logins = new Logins();
		
		logins.setUsername(token.getUsername());
		logins.setSeries(token.getSeries());
		logins.setToken(token.getTokenValue());
		logins.setUsed(token.getDate());
		
		this.entityManager.persist(logins);
		flushAndClear();
	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) 
	{
		String JPQL = "SELECT a FROM Logins a WHERE a.series = :series ";

		Logins logins = (Logins) entityManager.createQuery(JPQL)
				   .setParameter("series", series)
				   .getSingleResult();
		
		logins.setToken(tokenValue);
		logins.setUsed(lastUsed);
		
		this.entityManager.merge(logins); 
		flushAndClear();
		
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) 
	{
		String JPQL = "SELECT a FROM Logins a WHERE a.series = :series ";
		 
		
		Logins logins = (Logins) entityManager.createQuery(JPQL)
						   .setParameter("series", seriesId)
						   .getSingleResult();
		 
		if (logins != null) 
		{
		      return new PersistentRememberMeToken(
		    		  logins.getUsername(), 
		    		  logins.getSeries(), 
		    		  logins.getToken(),
		    		  logins.getUsed());
		}
		
		return null;
	}

	@Override
	public void removeUserTokens(String username) 
	{
		String JPQL = "delete from Logins where username = :username";
		
		
		entityManager
			.createQuery(JPQL)
			.setParameter("username", username)
			.executeUpdate();
				
		flushAndClear(); 
		
	}
}
