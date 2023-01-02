package com.car.webapp.domain.ruolo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ruolo")
public class Ruolo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5969735811189521060L;
	

	private Long fk_idUtente;
	

	private String nomeRuolo;
	
	public Ruolo() {}
	
	
	public Ruolo(Long fk_idUtente, String ruolo) {
		super();
		this.fk_idUtente = fk_idUtente;
		this.nomeRuolo = ruolo;
	}


	/**
	 * @return the fk_idUtente
	 */
	public Long getFk_idUtente() {
		return fk_idUtente;
	}

	/**
	 * @param fk_idUtente the fk_idUtente to set
	 */
	public void setFk_idUtente(Long fk_idUtente) {
		this.fk_idUtente = fk_idUtente;
	}

	/**
	 * @return the nomeRuolo
	 */
	public String getNomeRuolo() {
		return nomeRuolo;
	}

	/**
	 * @param ruolo the nomeRuolo to set
	 */
	public void setNomeRuolo(String nomeRuolo) {
		this.nomeRuolo = nomeRuolo;
	}
	
	
	
}
