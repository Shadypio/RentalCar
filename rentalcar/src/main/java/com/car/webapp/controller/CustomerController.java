package com.car.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.car.webapp.config.security.SpringSecurityUserContext;
import com.car.webapp.domain.customer.Customer;
import com.car.webapp.domain.role.Role;
import com.car.webapp.service.customer.ICustomerService;
import com.car.webapp.service.role.IRoleServiec;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private IRoleServiec roleService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	List<Customer> recordset;


	@GetMapping(value = "/")
	public String getCustomers(Model model) {

		recordset = customerService.getAllCustomers();

		model.addAttribute("head", "Ricerca Utenti");
		model.addAttribute("subheading", "Ricerca tutti gli utenti");
		model.addAttribute("customers", recordset);
		model.addAttribute("customersAmount", recordset.size());
		model.addAttribute("isCustomer", true);
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
		return "customers";
	}

	@GetMapping(value = "/detailscustomer/{idCustomer}")
	public String viewCustomerDetails(@PathVariable("idCustomer") Long idCustomer, Model model)
	{

		try
		{
			if (idCustomer != null)
			{
				Customer customer = customerService.getCustomerById(idCustomer);
				model.addAttribute("head", "Dettagli Utente");
				model.addAttribute("subheading", "Utente " + customer.getUsername());
				model.addAttribute("customer", customer);
				model.addAttribute("isCustomer", true);
				model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
			}
		} 
		catch (Exception ex)
		{
			throw new RuntimeException("Errore info utente", ex);
		}

		return "detailsCustomer";
	}
	
	@GetMapping(value = "/detailscustomerusername/{User}")
	public String viewCustomerDetails(@PathVariable("User") String username, Model model)
	{

		try
		{
			if (username != null)
			{
				Customer customer = customerService.getCustomerByUsername(username);
				model.addAttribute("head", "Dettagli Utente");
				model.addAttribute("subheading", "Utente " + customer.getUsername());
				model.addAttribute("customer", customer);
				model.addAttribute("isCustomer", true);
				model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
			}
		} 
		catch (Exception ex)
		{
			throw new RuntimeException("Errore info utente", ex);
		}

		return "detailsCustomer";
	}


	@GetMapping(value = "/add")
	public String insertCustomer(Model model) {

		Customer customer = new Customer();
		List<Role> roles = roleService.getAllRoles();

		model.addAttribute("head", "Inserimento Nuovo Utente");
		model.addAttribute("roles", roles);
		model.addAttribute("customer", customer);
		model.addAttribute("edit", false);
		model.addAttribute("saved", false);
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 


		return "insertCustomer";
	}

	@PostMapping(value = "/add")
	public String manageInsertCustomer(@ModelAttribute("customer") Customer newCustomer,
			BindingResult result,
			Model model, 
			RedirectAttributes redirectAttributes, HttpServletRequest request) {

		if(result.hasErrors()) {
			return "insertCustomer";
		}

		newCustomer.setPassword(passwordEncoder.encode(newCustomer.getPassword()));
		customerService.insertCustomer(newCustomer);

		redirectAttributes.addFlashAttribute("saved", true);

		return "redirect:/customer/detailscustomer/" + newCustomer.getId();
	}
	
	@GetMapping(value = "/edit/{idCustomer}")
	public String updateCustomer(Model model, @PathVariable("idCustomer") Long idCustomer) {

		Customer customer = customerService.getCustomerById(idCustomer);
		customer.setPassword("");

		model.addAttribute("head", "Modifica Utente " + customer.getUsername());
		model.addAttribute("role", customer.getRole());
		model.addAttribute("customer", customer);
		model.addAttribute("edit", true);
		model.addAttribute("saved", false);
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 

		return "insertCustomer";
	}

	@PostMapping(value = "/edit/{idCustomer}")
	public String manageUpdateCustomer(@ModelAttribute("customer") Customer editedUser,
			BindingResult result,
			Model model, 
			RedirectAttributes redirectAttributes, HttpServletRequest request) {

		if(result.hasErrors()) {
			return "insertCustomer";
		}
		
		editedUser.setPassword(passwordEncoder.encode(editedUser.getPassword()));
		customerService.updateCustomer(editedUser);

		redirectAttributes.addFlashAttribute("saved", true);

		return "redirect:/customer/detailscustomer/" + editedUser.getId();
	}
	
	@GetMapping(value = "/disable/{idCustomer}")
	public String disableCustomer(@PathVariable("idCustomer") Long idCustomer, Model model)
	{

		try
		{
			if (idCustomer != null)
			{

				customerService.disableCustomer(customerService.getCustomerById(idCustomer));
			}
		} 
		catch (Exception ex)
		{
			throw new RuntimeException("Errore modifica utente", ex);
		}

		return "redirect:/customer/";
	}
	
	@GetMapping(value = "/enable/{idCustomer}")
	public String enableCustomer(@PathVariable("idCustomer") Long idCustomer, Model model)
	{

		try
		{
			if (idCustomer != null)
			{
				customerService.enableCustomer(customerService.getCustomerById(idCustomer));
			}
		} 
		catch (Exception ex)
		{
			throw new RuntimeException("Errore modifica utente", ex);
		}

		return "redirect:/customer/";
	}

}
