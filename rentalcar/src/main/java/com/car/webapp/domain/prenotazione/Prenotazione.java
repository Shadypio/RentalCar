package com.car.webapp.domain.prenotazione;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

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
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrenotazione;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataInizio")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataInizio;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataFine")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataFine;
	
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "utenteRiferito", referencedColumnName = "id")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Utente utenteRiferito;
	
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "targaAuto", referencedColumnName = "targa")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Auto autoPrenotata;
	
	public Prenotazione() {}


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

	public Utente getUtenteRiferito() {
		return this.utenteRiferito;
	}
	
	public Auto getAutoPrenotata() {
		return this.autoPrenotata;
	}


	@Override
	public String toString() {
		return "Prenotazione [idPrenotazione=" + idPrenotazione + ", dataInizio=" + dataInizio + ", dataFine="
				+ dataFine + ", utenteRiferito=" + utenteRiferito.getUsername() + ", autoPrenotata=" + autoPrenotata.getTarga() + "]";
	}

	
	
	
	
}
