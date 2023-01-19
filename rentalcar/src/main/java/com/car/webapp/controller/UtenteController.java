package com.car.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.car.webapp.domain.ruolo.Ruolo;
import com.car.webapp.domain.utente.Utente;
import com.car.webapp.service.ruolo.IRuoloService;
import com.car.webapp.service.utente.IUtenteService;

@Controller
@RequestMapping("/utente")
public class UtenteController {

	private static final Logger logger = LoggerFactory.getLogger(UtenteController.class);

	@Autowired
	private IUtenteService utenteService;
	
	@Autowired
	private IRuoloService ruoloService;
	
	// Codifica password
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	List<Utente> recordset;

	
	// Equivalente a @GetMapping
	@RequestMapping(method = RequestMethod.GET)
	public String getUtenti(Model model) {

		

		logger.info("Otteniamo tutti gli utenti");
		recordset = utenteService.getAllUtenti();

		model.addAttribute("Titolo", "Ricerca Utenti");
		model.addAttribute("Titolo2", "Ricerca tutti gli utenti");
		model.addAttribute("Utenti", recordset);
		model.addAttribute("numUtenti", recordset.size());
		model.addAttribute("isUtente", true);
		return "utenti";
	}

	
	@GetMapping(value = "/elimina/{idUtente}")
	public String delUtente(@PathVariable("idUtente") Long idUtente, Model model)
	{
		
		try
		{
			if (idUtente != null)
			{
				
				utenteService.delUtente(utenteService.selUtenteById(idUtente));
				//utenteService.delUtenteById(idUtente);
			}
		} 
		catch (Exception ex)
		{
			throw new RuntimeException("Errore eliminazione utente", ex);
		}

		return "redirect:/utente/";
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
		
		//return "redirect:/utente/infoutente/" + nuovoUtente.getIdUtente();
		return "redirect:/utente/";
	}

}
