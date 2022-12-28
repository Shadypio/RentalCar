package com.car.webapp.domain.utente;

import java.util.Date;

public class Utente {

	private Long idUtente;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private Date dataDiNascita;
	
	public Utente() {}

	public Utente(String nome, String cognome, String username, String password, Date dataDiNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataDiNascita = dataDiNascita;
	}


	/**
	 * @return the idUtente
	 */
	public Long getIdUtente() {
		return idUtente;
	}
	
	/**
	 * @return the idUtente
	 */
	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the dataDiNascita
	 */
	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	/**
	 * @param dataDiNascita the dataDiNascita to set
	 */
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	
	
}
