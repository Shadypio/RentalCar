package com.car.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.car.webapp.domain.auto.Auto;
import com.car.webapp.service.auto.IAutoService;

@Controller
@RequestMapping("/auto")
public class AutoController {
	
	@Autowired
	private IAutoService autoService;
	
	private List<Auto> recordset;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getUtenti(Model model) {
		
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
				autoService.delAuto(targa);
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

}
