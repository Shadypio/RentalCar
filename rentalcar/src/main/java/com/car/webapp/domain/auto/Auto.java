package com.car.webapp.domain.auto;

import java.time.Year;

public class Auto {

	private String targa;
	private String marca;
	private String modello;
	private Year anno;
	private String categoria;
	private Long fk_idAdmin;
	private Long fk_idPrenotazione;
	
	public Auto() {}
	
	
	public Auto(String targa, String marca, String modello, Year anno, String categoria, Long fk_idAdmin) {
		this.targa = targa;
		this.marca = marca;
		this.modello = modello;
		this.anno = anno;
		this.categoria = categoria;
		this.fk_idAdmin = fk_idAdmin;
		this.fk_idPrenotazione = null;
	}
	
	public Auto(String targa, String marca, String modello, Year anno, String categoria, Long fk_idAdmin,
			Long fk_idPrenotazione) {
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
	public Year getAnno() {
		return anno;
	}
	/**
	 * @param anno the anno to set
	 */
	public void setAnno(Year anno) {
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
	public Long getFk_idAdmin() {
		return fk_idAdmin;
	}
	/**
	 * @param fk_idAdmin the fk_idAdmin to set
	 */
	public void setFk_idAdmin(Long fk_idAdmin) {
		this.fk_idAdmin = fk_idAdmin;
	}
	/**
	 * @return the fk_idPrenotazione
	 */
	public Long getFk_idPrenotazione() {
		return fk_idPrenotazione;
	}
	/**
	 * @param fk_idPrenotazione the fk_idPrenotazione to set
	 */
	public void setFk_idPrenotazione(Long fk_idPrenotazione) {
		this.fk_idPrenotazione = fk_idPrenotazione;
	}
	
	
}
