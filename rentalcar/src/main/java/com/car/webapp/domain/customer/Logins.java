package com.car.webapp.domain.customer;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "logins")
public class Logins implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6164833248073268799L;

	@Id
	@Basic(optional = false)
	private String series;
	
	@Basic(optional = false)
	private String username;
	
	@Basic(optional = false)
	private String token;
	
	@Temporal(TemporalType.TIME)
	@Basic(optional = false)
	private Date used;
	
	public Logins()
	{}

	/**
	 * @return the series
	 */
	public String getSeries() {
		return series;
	}

	/**
	 * @param series the series to set
	 */
	public void setSeries(String series) {
		this.series = series;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the used
	 */
	public Date getUsed() {
		return used;
	}

	/**
	 * @param used the used to set
	 */
	public void setUsed(Date used) {
		this.used = used;
	}

	
	
	
}
