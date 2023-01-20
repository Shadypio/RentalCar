package com.car.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.car.webapp.config.security.SpringSecurityUserContext;
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
	
	List<Prenotazione> recordset;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getPrenotazioni(Model model) {
		
		recordset = prenotazioneService.getAllPrenotazioni();
		
		model.addAttribute("Titolo", "Ricerca Prenotazioni");
		model.addAttribute("Titolo2", "Ricerca tutte le prenotazioni");
		model.addAttribute("Prenotazioni", recordset);
		model.addAttribute("isPrenotazione", true);
		if (recordset != null)
			model.addAttribute("numPrenotazioni", recordset.size());
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
		
		return "prenotazioni";
	}
	
	@GetMapping(value = "/elimina/{idPrenotazione}")
	public String delPrenotazione(@PathVariable("idPrenotazione") Long id, Model model)
	{
		try
		{
			if (id != null)
			{
				prenotazioneService.delPrenotazione(prenotazioneService.selPrenotazioneById(id));
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
		
		model.addAttribute("Titolo", "Dettagli Prenotazione");
		model.addAttribute("prenotazione", prenotazione);
		model.addAttribute("isPrenotazione", true);
		model.addAttribute("User", new SpringSecurityUserContext().getCurrentUser()); 
		
		return "infoPrenotazione";
	}
	
	
	@GetMapping(value = "/aggiungi/{targa}")
	public String prenotaAuto(@PathVariable("targa") String targa, Model model,
			HttpSession session) {
		
		Prenotazione prenotazione = new Prenotazione();
		autoPrenotata = autoService.getAutoFromTarga(targa);
		utenteRiferito = utenteService.selUtenteByUsername(new SpringSecurityUserContext().getCurrentUser());
		
		model.addAttribute("Titolo", "Inserimento Nuova Prenotazione");
		model.addAttribute("prenotazione", prenotazione);
		model.addAttribute("auto", autoPrenotata);
		model.addAttribute("utente", utenteRiferito);
		model.addAttribute("edit", false);
		model.addAttribute("saved", false);
				
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
		
		if(nuovaPrenotazione.getDataFine().before(nuovaPrenotazione.getDataInizio())) {	
			redirectAttributes.addFlashAttribute("errorDate", "Non puoi inserire una data di fine "
					+ "antecedente alla data di inizio");
			return "redirect:/prenotazione/aggiungi/" + autoPrenotata.getTarga();
		}
		
		autoPrenotata = autoService.getAutoFromTarga(targa);
		utenteRiferito = utenteService.selUtenteByUsername(new SpringSecurityUserContext().getCurrentUser());

		
		if(utenteRiferito.getPrenotazioneEffettuata() != null) {
			redirectAttributes.addFlashAttribute("alreadyRented", "Hai già prenotato un'altra auto."
					+ " Se vuoi sceglierne un'altra, cancella prima la tua prenotazione attuale");
			return "redirect:/auto/";
		}
		
		nuovaPrenotazione.setAutoPrenotata(autoPrenotata);
		nuovaPrenotazione.setUtenteRiferito(utenteRiferito);
		
		
		
		prenotazioneService.insPrenotazione(nuovaPrenotazione);
		
		redirectAttributes.addFlashAttribute("saved", true);
		
		return "redirect:/prenotazione/infoprenotazione/" + nuovaPrenotazione.getIdPrenotazione();
	}
	
	@GetMapping(value = "/getfromutente/{idUtente}")
	public String getPrenotazioniFromUtente(@PathVariable("idUtente") Long idUtente, 
			RedirectAttributes redirectAttributes, 
			Model model)
	{
		try
		{
			if (idUtente != null)
			{
				Prenotazione prenotazioneTrovata =
						prenotazioneService.getPrenotazioneByUtente(utenteService.selUtenteById(idUtente));
				return "redirect:/prenotazione/infoprenotazione/" + prenotazioneTrovata.getIdPrenotazione();
			}
		} 
		catch (Exception ex)
		{
			redirectAttributes.addFlashAttribute("noRentals", "Non hai effettuato alcuna prenotazione.");
			return "redirect:/utente/infoutente/" + idUtente;
		}

		return "redirect:/utente/infoutente/" + idUtente;
	}

}
