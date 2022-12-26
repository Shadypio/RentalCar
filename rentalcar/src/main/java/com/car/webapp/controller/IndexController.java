package com.car.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController 
{
	@RequestMapping(value="index")
	public String getWelcome(Model model)
	{
		model.addAttribute("intestazione", "Benvenuti nel sito RentalCar");
		model.addAttribute("saluti", "Seleziona le auto da noleggiare");
		
		return "index";
	}
	
	@RequestMapping(value="/")
	public String getWelcome2(Model model)
	{
		model.addAttribute("intestazione", "Benvenuti nel sito RentalCar 2");
		model.addAttribute("saluti", "Seleziona le auto da noleggiare 2");
		
		return "index";
	}

}
