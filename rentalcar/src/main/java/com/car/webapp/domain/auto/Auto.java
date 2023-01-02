package com.car.webapp.domain.auto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.car.webapp.domain.prenotazione.Prenotazione;
import com.car.webapp.domain.utente.Utente;

@Entity
@Table(name = "auto")
public class Auto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5851587320379712785L;
	
	@Id
	@Column(name = "targa")
	private String targa;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "modello")
	private String modello;
	
	@Column(name = "anno")
	private int anno;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "fk_idAdmin")
	private Utente fk_idAdmin;
	
	@Column(name = "fk_idPrenotazione")
	private Prenotazione fk_idPrenotazione;
	
	public Auto() {}
	
	
	public Auto(String targa, String marca, String modello, int anno, String categoria, Utente fk_idAdmin) {
		this.targa = targa;
		this.marca = marca;
		this.modello = modello;
		this.anno = anno;
		this.categoria = categoria;
		this.fk_idAdmin = fk_idAdmin;
		this.fk_idPrenotazione = null;
	}
	
	public Auto(String targa, String marca, String modello, int anno, String categoria, Utente fk_idAdmin,
			Prenotazione fk_idPrenotazione) {
		this.targa = targa;
		this.marca = marca;
		this.modello = modello;
		this.anno = anno;
		this.categoria = categoria;
		this.fk_idAdmin = fk_idAdmin;
		this.fk_idPrenotazione = fk_idPrenotazione;
	}

	/**
	 * @return the targa
	 */
	public String getTarga() {
		return targa;
	}
	/**
	 * @param targa the targa to set
	 */
	public void setTarga(String targa) {
		this.targa = targa;
	}
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @return the modello
	 */
	public String getModello() {
		return modello;
	}
	/**
	 * @param modello the modello to set
	 */
	public void setModello(String modello) {
		this.modello = modello;
	}
	/**
	 * @return the anno
	 */
	public int getAnno() {
		return anno;
	}
	/**
	 * @param anno the anno to set
	 */
	public void setAnno(int anno) {
		this.anno = anno;
	}
	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	/**
	 * @return the fk_idAdmin
	 */
	public Utente getFk_idAdmin() {
		return fk_idAdmin;
	}
	/**
	 * @param fk_idAdmin the fk_idAdmin to set
	 */
	public void setFk_idAdmin(Utente fk_idAdmin) {
		this.fk_idAdmin = fk_idAdmin;
	}
	/**
	 * @return the fk_idPrenotazione
	 */
	public Prenotazione getFk_idPrenotazione() {
		return fk_idPrenotazione;
	}
	/**
	 * @param fk_idPrenotazione the fk_idPrenotazione to set
	 */
	public void setFk_idPrenotazione(Prenotazione fk_idPrenotazione) {
		this.fk_idPrenotazione = fk_idPrenotazione;
	}
	
	
}
