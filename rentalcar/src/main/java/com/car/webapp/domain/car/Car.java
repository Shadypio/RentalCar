package com.car.webapp.domain.car;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.car.webapp.domain.rental.Rental;

@Entity
@Table(name = "car")
public class Car implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5851587320379712785L;
	
	@Id
	@Column(name = "license_plate")
	@NotNull(message = "{NotNull.Auto.targa.validation}")
	@Size(min=7, max=7, message = "{Size.Auto.targa.validation}")
	@Pattern(regexp = "^[ABCDEFGHJKLMNPRSTVWXYZ]{2}[0-9]{3}[ABCDEFGHJKLMNPRSTVWXYZ]{2}$", message = "{Pattern.Auto.targa.validation}")
	private String licensePlate;
	
	@Column(name = "brand")
	@Size(min=1, max=45, message = "{Size.Auto.targa.validation}")
	private String brand;
	
	@Column(name = "model")
	@Size(min=1, max=45, message = "{Size.Auto.modello.validation}")
	private String model;
	
	@Column(name = "year")
	@Digits(integer=4, message="{Digits.Auto.anno.validation}", fraction = 0)
	private int year;
	
	@Column(name = "category")
	@Size(min=1, max=45, message = "{Size.Auto.categoria.validation}")
	private String category;
	
	@OneToOne(mappedBy = "rentedCar", orphanRemoval = true)
	private Rental rental;

	
	public Car() {}


	/**
	 * @return the licensePlate
	 */
	public String getLicensePlate() {
		return licensePlate;
	}


	/**
	 * @param licensePlate the licensePlate to set
	 */
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}


	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}


	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}


	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}


	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}


	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}


	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}


	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}


	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}


	/**
	 * @return the rental
	 */
	public Rental getRental() {
		return rental;
	}


	/**
	 * @param rental the rental to set
	 */
	public void setRental(Rental rental) {
		this.rental = rental;
	}


	@Override
	public String toString() {
		return "Car [licensePlate=" + licensePlate + ", brand=" + brand + ", model=" + model + ", year=" + year
				+ ", category=" + category + ", rental=" + rental + "]";
	}

	
	
	
	
	
	
	
}
