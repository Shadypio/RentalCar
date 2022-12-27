package com.car.webapp.domain.ruolo;

public class Ruolo {

	private Long fk_idUtente;
	private String nomeRuolo;
	
	private Ruolo() {}
	
	
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
