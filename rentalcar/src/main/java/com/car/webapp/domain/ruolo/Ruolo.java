package com.car.webapp.domain.ruolo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ruolo")
public class Ruolo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5969735811189521060L;
	
	@Id
	@Column(name = "idRuolo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRuolo;
	
	@Column(name = "tipoRuolo")
	private String nomeRuolo;
	
	public Ruolo() {}
	
	
	public Ruolo(Long idRuolo, String nomeRuolo) {
		super();
		this.setIdRuolo(idRuolo);
		this.nomeRuolo = nomeRuolo;
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


	public Long getIdRuolo() {
		return idRuolo;
	}


	public void setIdRuolo(Long idRuolo) {
		this.idRuolo = idRuolo;
	}
	
	
	
}
