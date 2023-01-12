package com.car.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController 
{
	
	@RequestMapping(value="/")
	public String getWelcome2(Model model)
	{
		model.addAttribute("intestazione", "Benvenuti nel sito RentalCar");
		model.addAttribute("saluti", "Seleziona le auto da noleggiare");
		
		return "index";
	}

}
