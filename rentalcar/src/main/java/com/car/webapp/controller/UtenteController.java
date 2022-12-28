package com.car.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.car.webapp.domain.utente.Utente;
import com.car.webapp.service.utente.IUtenteService;

@Controller
@RequestMapping("/utente")
public class UtenteController {
	
	@Autowired
	private IUtenteService utenteService;
	
	private List<Utente> recordset;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getUtenti(Model model) {
		
		recordset = utenteService.getAllUtenti();
		
		model.addAttribute("Titolo", "Ricerca Utenti");
		model.addAttribute("Titolo2", "Ricerca tutti gli utenti");
		model.addAttribute("Utenti", recordset);
		model.addAttribute("isUtente", true);
		if (recordset != null)
			model.addAttribute("numUtenti", recordset.size());
		
		return "utenti";
	}

}
