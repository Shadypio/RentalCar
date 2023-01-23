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

import com.car.webapp.domain.auto.Car;
import com.car.webapp.domain.utente.Customer;

@Entity
@Table(name = "rental")
public class Rental implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3896030548583216394L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_referred_customer", referencedColumnName = "id")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Customer referredCustomer;
	
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_rented_car", referencedColumnName = "license_plate")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Car rentedCar;
	
	public Rental() {}

	/**
	 * @return the idPrenotazione
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param idPrenotazione the idPrenotazione to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the referredUser
	 */
	public Customer getReferredCustomer() {
		return referredCustomer;
	}

	/**
	 * @param referredUser the referredUser to set
	 */
	public void setReferredCustomer(Customer referredCustomer) {
		this.referredCustomer = referredCustomer;
	}

	/**
	 * @return the rentedCar
	 */
	public Car getRentedCar() {
		return rentedCar;
	}

	/**
	 * @param rentedCar the rentedCar to set
	 */
	public void setRentedCar(Car rentedCar) {
		this.rentedCar = rentedCar;
	}

	@Override
	public String toString() {
		return "Rental [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", referredCustomer="
				+ referredCustomer + ", rentedCar=" + rentedCar + "]";
	}

	


	
	
	
	
}
