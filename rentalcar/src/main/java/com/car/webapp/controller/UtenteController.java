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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.car.webapp.config.security.SpringSecurityUserContext;
import com.car.webapp.domain.ruolo.Ruolo;
import com.car.webapp.domain.utente.Utente;
import com.car.webapp.service.ruolo.IRuoloService;
import com.car.webapp.service.utente.IUtenteService;

@Controller
@RequestMapping("/utente")
public class UtenteController {

	@Autowired
	private IUtenteService utenteService;

	@Autowired
	private IRuoloService ruoloService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	List<Utente> recordset;


	@RequestMapping(method = RequestMethod.GET)
	public String getUtenti(Model model) {

		recordset = utenteService.getAllUtenti();

		model.addAttribute("Titolo", "Ricerca Utenti");
		model.addAttribute("Titolo2", "Ricerca tutti gli utenti");
		model.addAttribute("Utenti", recordset);
		model.addAttribute("numUtenti", recordset.size());
		model.addAttribute("isUtente", true);
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
		return "utenti";
	}

	@GetMapping(value = "/infoutente/{idUtente}")
	public String viewInfoUtente(@PathVariable("idUtente") Long idUtente, Model model)
	{

		try
		{
			if (idUtente != null)
			{
				Utente utente = utenteService.selUtenteById(idUtente);
				model.addAttribute("Titolo", "Dettagli Utente");
				model.addAttribute("Titolo2", "Utente " + utente.getUsername());
				model.addAttribute("utente", utente);
				model.addAttribute("isUtente", true);
				model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
			}
		} 
		catch (Exception ex)
		{
			throw new RuntimeException("Errore info utente", ex);
		}

		return "infoUtente";
	}

	@GetMapping(value = "/aggiungi")
	public String insUtente(Model model) {

		Utente utente = new Utente();
		List<Ruolo> ruoli = ruoloService.selTutti();

		model.addAttribute("Titolo", "Inserimento Nuovo Utente");
		model.addAttribute("ruoli", ruoli);
		model.addAttribute("utente", utente);
		model.addAttribute("edit", false);
		model.addAttribute("saved", false);
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 


		return "insUtente";
	}

	@PostMapping(value = "/aggiungi")
	public String gestInsUtente(@ModelAttribute("utente") Utente nuovoUtente,
			BindingResult result,
			Model model, 
			RedirectAttributes redirectAttributes, HttpServletRequest request) {

		if(result.hasErrors()) {
			return "insUtente";
		}

		nuovoUtente.setPassword(passwordEncoder.encode(nuovoUtente.getPassword()));
		utenteService.insUtente(nuovoUtente);

		redirectAttributes.addFlashAttribute("saved", true);

		return "redirect:/utente/infoutente/" + nuovoUtente.getIdUtente();
	}
	
	@GetMapping(value = "/disabilita/{idUtente}")
	public String disabilitaUtente(@PathVariable("idUtente") Long idUtente, Model model)
	{

		try
		{
			if (idUtente != null)
			{

				utenteService.disabilitaUtente(utenteService.selUtenteById(idUtente));
			}
		} 
		catch (Exception ex)
		{
			throw new RuntimeException("Errore eliminazione utente", ex);
		}

		return "redirect:/utente/";
	}
	
	@GetMapping(value = "/abilita/{idUtente}")
	public String abilitaUtente(@PathVariable("idUtente") Long idUtente, Model model)
	{

		try
		{
			if (idUtente != null)
			{
				utenteService.abilitaUtente(utenteService.selUtenteById(idUtente));
			}
		} 
		catch (Exception ex)
		{
			throw new RuntimeException("Errore eliminazione utente", ex);
		}

		return "redirect:/utente/";
	}

}
