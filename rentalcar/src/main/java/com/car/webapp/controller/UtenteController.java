package com.car.webapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.car.webapp.domain.utente.Utente;
import com.car.webapp.service.utente.IUtenteService;

@Controller
@RequestMapping("/utente")
public class UtenteController {

	private static final Logger logger = LoggerFactory.getLogger(UtenteController.class);

	@Autowired
	private IUtenteService utenteService;

	List<Utente> mainRecordset;

	private String orderType = "DESC";
	private int orderBy = 0;

	//List<PagingData> Pages = new ArrayList<PagingData>();
	private int pageNum = 1;
	private int recForPage = 10;

	private boolean isClienti = true;

	// Equivalente a @GetMapping
	@RequestMapping(method = RequestMethod.GET)
	public String getUtenti(Model model) {

		List<Utente> recordset = null;
		long numRecords = 0;

		logger.info("Otteniamo tutti gli utenti");
		mainRecordset = utenteService.getAllUtenti();

		/*
		 * 
		 
		if(mainRecordset != null) {

			numRecords = mainRecordset.size();
		}

		recordset = mainRecordset
				.stream()
				.skip(0)
				.limit(recForPage)
				.collect(Collectors.toList());
		
		
		
		if (recordset != null)
			model.addAttribute("numUtenti", recordset.size());

		logger.info("Numero di record per pagina: " + recForPage);
		setPages(pageNum);
		*/

		model.addAttribute("Titolo", "Ricerca Utenti");
		model.addAttribute("Titolo2", "Ricerca tutti gli utenti");
		model.addAttribute("Utenti", mainRecordset);
		model.addAttribute("numUtenti", mainRecordset.size());
		model.addAttribute("isUtente", true);
		return "utenti";
	}

	/**
	 * 
	//Metodo di creazione classi Pages
	private void setPages(int Page, long numRecords)
	{
		int Min = 1;
		int ValMin = 1;
		int Max = 5;

		if (Pages != null)
			Pages.clear();

		int Group = (int) Math.ceil((double)Page / 5);

		Max = Group * 5;
		Min = (Max - 5 == 0) ? 1 : Max - 4;

		ValMin = Min;

		int MaxPages = (numRecords > 0) ? (int) Math.ceil((double)numRecords / (double)RecForPage) : 5;

		while (Min <= Max)
		{
			if (Min > MaxPages)
				break;

			Pages.add(new PagingData(Min,false));

			Min++;
		}

		try
		{
			if (Page - ValMin > 0)
				Pages.get(Page - ValMin).setIsSelected(true);
			else
				Pages.get(0).setIsSelected(true);
		}
		catch (Exception ex)
		{
			Pages.get(0).setIsSelected(true);
		}
	}
	*/
	
	@GetMapping(value = "/elimina/{idUtente}")
	public String delUtente(@PathVariable("idUtente") Long idUtente, Model model)
	{
		
		try
		{
			if (idUtente != null)
			{
				
				Utente utenteDaEliminare = utenteService.selUtenteById(idUtente);
				utenteService.delUtente(utenteDaEliminare);
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

}
