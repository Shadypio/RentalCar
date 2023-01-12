package com.car.webapp.domain.prenotazione;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "prenotazione")
public class Prenotazione implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3896030548583216394L;
	
	@Id
	@Column(name = "idPrenotazione")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrenotazione;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataInizio")
	private Date dataInizio;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataFine")
	private Date dataFine;
	
	public Prenotazione() {}
	
	public Prenotazione(Long idPrenotazione, Date dataInizio, Date dataFine) {
		this.idPrenotazione = idPrenotazione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
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

	@Override
	public String toString() {
		return "Prenotazione [idPrenotazione=" + idPrenotazione + ", dataInizio=" + dataInizio + ", dataFine="
				+ dataFine + "]";
	}
	
	
	
}
