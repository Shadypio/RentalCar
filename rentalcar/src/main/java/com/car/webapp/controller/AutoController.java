package com.car.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.car.webapp.service.auto.IAutoService;
import com.car.webapp.service.prenotazione.IPrenotazioneService;

@Controller
@RequestMapping("/auto")
public class AutoController {
	
	@Autowired
	private IAutoService autoService;
	
	@Autowired
	private IPrenotazioneService prenotazioneService;
	
	private List<Auto> recordset;
	
	private static final Logger logger = LoggerFactory.getLogger(AutoController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAuto(Model model) {
		
		recordset = autoService.getAllAuto();
		
		model.addAttribute("Titolo", "Ricerca Auto");
		model.addAttribute("Titolo2", "Ricerca tutte le auto");
		model.addAttribute("Auto", recordset);
		model.addAttribute("isAuto", true);
		if (recordset != null)
			model.addAttribute("numAuto", recordset.size());
		
		return "auto";
	}
	
	@GetMapping(value = "/elimina/{targa}")
	public String delAuto(@PathVariable("targa") String targa, Model model)
	{
		try
		{
			if (targa.length() > 0)
			{
				
				Auto auto = autoService.getAutoFromTarga(targa);
				autoService.delAuto(auto);
			}
		} 
		catch (Exception ex)
		{
			throw new RuntimeException("Errore eliminazione auto", ex);
		}

		return "redirect:/auto/";
	}
	
	
	
	@GetMapping(value = "/infoauto/{targa}")
	public String viewInfoAuto(@PathVariable("targa") String targa, Model model)
	{
		
		Auto auto = autoService.getAutoFromTarga(targa);
		
		model.addAttribute("Titolo", "Dettagli Auto");
		model.addAttribute("Titolo2", "Targa " + targa);
		model.addAttribute("auto", auto);
		model.addAttribute("isAuto", true);
		
		return "infoAuto";
	}
	
	
	@GetMapping(value = "/aggiungi")
	public String insAuto(Model model) {
		
		Auto auto = new Auto();
		
		model.addAttribute("Titolo", "Inserimento Nuova Auto");
		model.addAttribute("auto", auto);
		model.addAttribute("edit", false);
		model.addAttribute("saved", false);
		
		
		return "insAuto";
	}
	
	@PostMapping(value = "/aggiungi")
	public String gestInsAuto(@Valid @ModelAttribute("auto") Auto nuovaAuto, BindingResult result, Model model, 
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "insAuto";
		}
		
		System.out.println(nuovaAuto.toString());
		
		autoService.insAuto(nuovaAuto);
		
		redirectAttributes.addFlashAttribute("saved", true);
		
		return "redirect:/auto/infoauto/" + nuovaAuto.getTarga();
	}
	
	@GetMapping(value = "/prenota/{targa}")
	public String prenotaAuto(@PathVariable("targa") String targa, Model model) {
		
		Auto auto = autoService.getAutoFromTarga(targa);
		Prenotazione prenotazione = new Prenotazione();
		
		model.addAttribute("Titolo", "Prenotazione auto " + targa);
		model.addAttribute("prenotazione", prenotazione);
		model.addAttribute("edit", false);
		model.addAttribute("saved", false);
		
		
		return "insPrenotazione";
	}

}
