package com.car.webapp.domain.prenotazione;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.car.webapp.domain.auto.Auto;
import com.car.webapp.domain.utente.Utente;

@Entity
@Table(name = "prenotazione")
public class Prenotazione implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3896030548583216394L;
	
	@Id
	@Column(name = "idPrenotazione")
	private Long idPrenotazione;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataInizio")
	private Date dataInizio;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataFine")
	private Date dataFine;
	
	@OneToOne
	//@JoinColumn(name = "fk_idUtente", referencedColumnName = "idUtente")
	private Utente fk_idUtente;
	
	// @OneToOne(optional = false, fetch = FetchType.EAGER)
	@ManyToOne
	//@JoinColumn(name = "fk_targaAuto", referencedColumnName = "targa")
	private Auto fk_targaAuto;

	
	public Prenotazione() {}
	
	public Prenotazione(Long idPrenotazione, Date dataInizio, Date dataFine, Auto fk_targaAuto, Utente fk_idUtente) {
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
	public Auto getFk_targaAuto() {
		return fk_targaAuto;
	}
	/**
	 * @param fk_targaAuto the fk_targaAuto to set
	 */
	public void setFk_targaAuto(Auto fk_targaAuto) {
		this.fk_targaAuto = fk_targaAuto;
	}
	/**
	 * @return the fk_idUtente
	 */
	public Utente getFk_idUtente() {
		return fk_idUtente;
	}
	/**
	 * @param fk_idUtente the fk_idUtente to set
	 */
	public void setFk_idUtente(Utente fk_idUtente) {
		this.fk_idUtente = fk_idUtente;
	}
	
	
	
	
}
