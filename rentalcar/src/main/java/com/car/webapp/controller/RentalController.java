package com.car.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.car.webapp.config.security.SpringSecurityUserContext;
import com.car.webapp.domain.car.Car;
import com.car.webapp.domain.customer.Customer;
import com.car.webapp.domain.rental.Rental;
import com.car.webapp.service.car.ICarService;
import com.car.webapp.service.customer.ICustomerService;
import com.car.webapp.service.rental.IRentalService;


@Controller
@RequestMapping("/rental")
public class RentalController {
	
	@Autowired
	private IRentalService rentalService;
	
	@Autowired
	private ICarService carService;
	
	@Autowired
	private ICustomerService customerService;
	
	private Car rentedCar = new Car();
	private Customer referredCustomer = new Customer();
	
	List<Rental> recordset;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getRentals(Model model) {
		
		recordset = rentalService.getAllRentals();
		
		model.addAttribute("head", "Ricerca Prenotazioni");
		model.addAttribute("subheading", "Ricerca tutte le prenotazioni");
		model.addAttribute("rentals", recordset);
		model.addAttribute("isRental", true);
		if (recordset != null)
			model.addAttribute("rentalsAmount", recordset.size());
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
		
		return "rentals";
	}
	
	@GetMapping(value = "/delete/{idRental}")
	public String deleteRental(@PathVariable("idRental") Long id, Model model)
	{
		try
		{
			if (id != null)
			{
				rentalService.deleteRental(rentalService.getRentalById(id));
			}
		} 
		catch (Exception ex)
		{
			throw new RuntimeException("Errore eliminazione prenotazione", ex);
		}

		return "redirect:/rental/";
	}
	
	@GetMapping(value = "/detailsrental/{idRental}")
	public String viewRentalDetails(@PathVariable("idRental") Long id, Model model)
	{
		
		Rental rental = rentalService.getRentalById(id);
		
		model.addAttribute("head", "Dettagli Prenotazione");
		model.addAttribute("rental", rental);
		model.addAttribute("isRental", true);
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
		
		return "detailsRental";
	}
	
	
	@GetMapping(value = "/add/{licensePlate}")
	public String rentCar(@PathVariable("licensePlate") String licensePlate, Model model,
			HttpSession session) {
		
		Rental rental = new Rental();
		rentedCar = carService.getCarByLicensePlate(licensePlate);
		referredCustomer = customerService.getCustomerByUsername(new SpringSecurityUserContext().getCurrentUser());
		
		model.addAttribute("head", "Inserimento Nuova Prenotazione");
		model.addAttribute("rental", rental);
		model.addAttribute("car", rentedCar);
		model.addAttribute("customer", referredCustomer);
		model.addAttribute("edit", false);
		model.addAttribute("saved", false);
				
		return "insertRental";
	}
	
	@PostMapping(value = "/add/{licensePlate}")
	public String gestInsPrenotazione(@PathVariable("licensePlate") String licensePlate,
			@ModelAttribute("rental") Rental newRental, 
			BindingResult result,
			@ModelAttribute("customer") Customer referredCustomer,
			@ModelAttribute("car") Car rentedCar,
			Model model, 
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "insertRental";
		}
		
		if(newRental.getEndDate().before(newRental.getStartDate())) {	
			redirectAttributes.addFlashAttribute("errorDate", "Non puoi inserire una data di fine "
					+ "antecedente alla data di inizio");
			return "redirect:/rental/add/" + rentedCar.getLicensePlate();
		}
		
		rentedCar = carService.getCarByLicensePlate(licensePlate);
		referredCustomer = customerService.getCustomerByUsername(new SpringSecurityUserContext().getCurrentUser());

		
		if(referredCustomer.getRentalMade() != null) {
			redirectAttributes.addFlashAttribute("alreadyRented", "Hai già prenotato un'altra auto."
					+ " Se vuoi sceglierne un'altra, cancella prima la tua prenotazione attuale");
			return "redirect:/car/";
		}
		
		newRental.setRentedCar(rentedCar);
		newRental.setReferredCustomer(referredCustomer);
		
		
		
		rentalService.insertRental(newRental);
		
		redirectAttributes.addFlashAttribute("saved", true);
		
		return "redirect:/rental/detailsrental/" + newRental.getId();
	}
	
	@GetMapping(value = "/getfromcustomer/{idCustomer}")
	public String getRentalsFromUser(@PathVariable("idCustomer") Long idCustomer, 
			RedirectAttributes redirectAttributes, 
			Model model)
	{
		try
		{
			if (idCustomer != null)
			{
				Rental foundRentals =
						rentalService.getRentalByCustomer(customerService.getCustomerById(idCustomer));
				return "redirect:/rental/detailsrental/" + foundRentals.getId();
			}
		} 
		catch (Exception ex)
		{
			redirectAttributes.addFlashAttribute("noRentals", "Non hai effettuato alcuna prenotazione.");
			return "redirect:/customer/detailscustomer/" + idCustomer;
		}

		return "redirect:/customer/detailscustomer/" + idCustomer;
	}

}
