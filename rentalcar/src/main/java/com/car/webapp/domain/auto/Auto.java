package com.car.webapp.domain.auto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.car.webapp.domain.prenotazione.Prenotazione;

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
	
	@OneToMany(mappedBy = "fk_targaAuto")
	private Set<Prenotazione> prenotazioniAuto = new HashSet<Prenotazione>();

	
	public Auto() {}
	
	
	public Auto(String targa, String marca, String modello, int anno, String categoria) {
		this.targa = targa;
		this.marca = marca;
		this.modello = modello;
		this.anno = anno;
		this.categoria = categoria;
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


	public Set<Prenotazione> getPrenotazioniAuto() {
		return prenotazioniAuto;
	}


	public void setPrenotazioniAuto(Set<Prenotazione> prenotazioniAuto) {
		this.prenotazioniAuto = prenotazioniAuto;
	}
	
	
	
	
}
