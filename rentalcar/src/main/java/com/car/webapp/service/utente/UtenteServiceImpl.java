package com.car.webapp.service.utente;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.car.webapp.dao.IUtenteDao;
import com.car.webapp.domain.utente.Utente;

@Service("utenteService")
@Transactional
public class UtenteServiceImpl implements IUtenteService {

	@Autowired
	private IUtenteDao utenteRepository;
	
	@Override
	public List<Utente> getAllUtenti() {
		
		return utenteRepository.selTutti();
	}

	@Override
	public Utente selUtenteById(Long id) {
		 
		return utenteRepository.selById(id);
	}

	@Override
	public void insUtente(Utente utente) {
		
		utenteRepository.salva(utente);
		
	}

	@Override
	public void modificaUtente(Utente utente) {
		
		utenteRepository.aggiorna(utente);
		
	}

	@Override
	public void delUtente(Utente utente) {
		
		utenteRepository.elimina(utente);
		
	}

	@Override
	public void delUtenteById(Long id) {
		
		utenteRepository.eliminaById(id);
		
	}

	@Override
	public Utente selUtenteByUsernameId(String username, Long id) {
		
		return utenteRepository.selByUserId(username, id);
	}

	@Override
	public void salvaAdminUser(String password) {
		
		utenteRepository.salvaAdminUser(password);
		
	}
	
	
	
	

}
