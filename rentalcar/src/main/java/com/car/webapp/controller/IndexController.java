package com.car.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.car.webapp.config.security.SpringSecurityUserContext;

@Controller
public class IndexController 
{
	
	@RequestMapping(value="/")
	public String getWelcome(Model model)
	{
		model.addAttribute("head", "Benvenuti nel sito RentalCar");
		model.addAttribute("greetings", "Seleziona le auto da noleggiare");
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
		
		return "index";
	}

}
