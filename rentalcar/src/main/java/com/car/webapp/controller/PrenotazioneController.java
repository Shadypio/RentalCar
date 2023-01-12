package com.car.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.car.webapp.domain.prenotazione.Prenotazione;
import com.car.webapp.service.prenotazione.IPrenotazioneService;

@Controller
@RequestMapping("/prenotazione")
public class PrenotazioneController {
	
	@Autowired
	private IPrenotazioneService prenotazioneService;
	
	List<Prenotazione> recordset;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getPrenotazioni(Model model) {
		
		recordset = prenotazioneService.getAllPrenotazioni();
		
		for(Prenotazione p: recordset) {
			System.out.println(p.toString());
		}
		
		model.addAttribute("Titolo", "Ricerca Prenotazioni");
		model.addAttribute("Titolo2", "Ricerca tutte le prenotazioni");
		model.addAttribute("Prenotazioni", recordset);
		model.addAttribute("isPrenotazione", true);
		if (recordset != null)
			model.addAttribute("numPrenotazioni", recordset.size());
		
		return "prenotazioni";
	}
	
	@GetMapping(value = "/elimina/{id}")
	public String delPrenotazione(@PathVariable("id") Long id, Model model)
	{
		try
		{
			if (id != null)
			{
				prenotazioneService.delPrenotazioneById(id);
			}
		} 
		catch (Exception ex)
		{
			throw new RuntimeException("Errore eliminazione prenotazione", ex);
		}

		return "redirect:/prenotazioni/";
	}
	
	@GetMapping(value = "/infoprenotazione/{id}")
	public String viewInfoPrenotazione(@PathVariable("id") Long id, Model model)
	{
		
		Prenotazione prenotazione = prenotazioneService.selPrenotazioneById(id);
		
		model.addAttribute("Titolo", "Dettagli Prenotazione");
		model.addAttribute("prenotazione", prenotazione);
		model.addAttribute("isPrenotazione", true);
		
		return "infoPrenotazione";
	}
	
	
	@GetMapping(value = "/aggiungi")
	public String insAuto(Model model) {
		
		Prenotazione prenotazione = new Prenotazione();
		
		model.addAttribute("Titolo", "Inserimento Nuova Prenotazione");
		model.addAttribute("prenotazione", prenotazione);
		model.addAttribute("edit", false);
		model.addAttribute("saved", false);
		
		
		return "insPrenotazione";
	}

}
