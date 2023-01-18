package com.car.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import com.car.webapp.domain.auto.Auto;
import com.car.webapp.domain.prenotazione.Prenotazione;
import com.car.webapp.domain.utente.Utente;
import com.car.webapp.service.auto.IAutoService;
import com.car.webapp.service.prenotazione.IPrenotazioneService;
import com.car.webapp.service.utente.IUtenteService;


@Controller
@RequestMapping("/prenotazione")
public class PrenotazioneController {
	
	@Autowired
	private IPrenotazioneService prenotazioneService;
	
	@Autowired
	private IAutoService autoService;
	
	@Autowired
	private IUtenteService utenteService;
	
	private Auto autoPrenotata = new Auto();
	private Utente utenteRiferito = new Utente();
	// private Utente utenteRiferito = new SpringSecurityUserContext().getCurrentUser()
	
	List<Prenotazione> recordset;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getPrenotazioni(Model model) {
		
		recordset = prenotazioneService.getAllPrenotazioni();
		
//		for(Prenotazione p: recordset) {
//			System.out.println(p.toString());
//		}
		
		model.addAttribute("Titolo", "Ricerca Prenotazioni");
		model.addAttribute("Titolo2", "Ricerca tutte le prenotazioni");
		model.addAttribute("Prenotazioni", recordset);
		model.addAttribute("isPrenotazione", true);
		if (recordset != null)
			model.addAttribute("numPrenotazioni", recordset.size());
		
		return "prenotazioni";
	}
	
	@GetMapping(value = "/elimina/{idPrenotazione}")
	public String delPrenotazione(@PathVariable("idPrenotazione") Long id, Model model)
	{
		try
		{
			if (id != null)
			{
				Prenotazione p = prenotazioneService.selPrenotazioneById(id);
				prenotazioneService.delPrenotazione(p);
			}
		} 
		catch (Exception ex)
		{
			throw new RuntimeException("Errore eliminazione prenotazione", ex);
		}

		return "redirect:/prenotazione/";
	}
	
	@GetMapping(value = "/infoprenotazione/{idPrenotazione}")
	public String viewInfoPrenotazione(@PathVariable("idPrenotazione") Long id, Model model)
	{
		
		Prenotazione prenotazione = prenotazioneService.selPrenotazioneById(id);
		System.out.println("prenotazione to string " + prenotazione.toString());
		
		model.addAttribute("Titolo", "Dettagli Prenotazione");
		model.addAttribute("prenotazione", prenotazione);
		model.addAttribute("isPrenotazione", true);
		
		return "infoPrenotazione";
	}
	
	
	@GetMapping(value = "/aggiungi/{targa}")
	public String prenotaAuto(@PathVariable("targa") String targa, Model model,
			HttpSession session) {
		
		Prenotazione prenotazione = new Prenotazione();
		autoPrenotata = autoService.getAutoFromTarga(targa);
		utenteRiferito = utenteService.getAllUtenti().get(0);
		
		model.addAttribute("Titolo", "Inserimento Nuova Prenotazione");
		model.addAttribute("prenotazione", prenotazione);
		model.addAttribute("auto", autoPrenotata);
		model.addAttribute("utente", utenteRiferito);
		model.addAttribute("edit", false);
		model.addAttribute("saved", false);
		// model.addAttribute("user", new SpringSecurityUserContext().getCurrentUser()); 
				
		return "insPrenotazione";
	}
	
	@PostMapping(value = "/aggiungi/{targa}")
	public String gestInsPrenotazione(@PathVariable("targa") String targa,
			@ModelAttribute("prenotazione") Prenotazione nuovaPrenotazione, 
			BindingResult result,
			@ModelAttribute("utente") Utente utenteRiferito,
			@ModelAttribute("auto") Auto autoPrenotata,
			Model model, 
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "insPrenotazione";
		}
		autoPrenotata = autoService.getAutoFromTarga(targa);
		utenteRiferito = utenteService.getAllUtenti().get(0);
		
		
		
		nuovaPrenotazione.setAutoPrenotata(autoPrenotata);
		nuovaPrenotazione.setUtenteRiferito(utenteRiferito);
		
		prenotazioneService.insPrenotazione(nuovaPrenotazione);
		
		redirectAttributes.addFlashAttribute("saved", true);
		
		return "redirect:/prenotazione/infoprenotazione/" + nuovaPrenotazione.getIdPrenotazione();
	}

}
