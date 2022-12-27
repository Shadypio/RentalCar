package com.car.webapp.domain.prenotazione;

import java.util.Date;

public class Prenotazione {

	private Long idPrenotazione;
	private Date dataInizio;
	private Date dataFine;
	private String fk_targaAuto;
	private String fk_idUtente;
	
	private Prenotazione() {}
	
	public Prenotazione(Long idPrenotazione, Date dataInizio, Date dataFine, String fk_targaAuto, String fk_idUtente) {
		this.idPrenotazione = idPrenotazione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.fk_targaAuto = fk_targaAuto;
		this.fk_idUtente = fk_idUtente;
	}


	/**
	 * @return the idPrenotazione
	 */
	public Long getIdPrenotazione() {
		return idPrenotazione;
	}
	/**
	 * @param idPrenotazione the idPrenotazione to set
	 */
	public void setIdPrenotazione(Long idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}
	/**
	 * @return the dataInizio
	 */
	public Date getDataInizio() {
		return dataInizio;
	}
	/**
	 * @param dataInizio the dataInizio to set
	 */
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	/**
	 * @return the dataFine
	 */
	public Date getDataFine() {
		return dataFine;
	}
	/**
	 * @param dataFine the dataFine to set
	 */
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	/**
	 * @return the fk_targaAuto
	 */
	public String getFk_targaAuto() {
		return fk_targaAuto;
	}
	/**
	 * @param fk_targaAuto the fk_targaAuto to set
	 */
	public void setFk_targaAuto(String fk_targaAuto) {
		this.fk_targaAuto = fk_targaAuto;
	}
	/**
	 * @return the fk_idUtente
	 */
	public String getFk_idUtente() {
		return fk_idUtente;
	}
	/**
	 * @param fk_idUtente the fk_idUtente to set
	 */
	public void setFk_idUtente(String fk_idUtente) {
		this.fk_idUtente = fk_idUtente;
	}
	
	
	
	
}
