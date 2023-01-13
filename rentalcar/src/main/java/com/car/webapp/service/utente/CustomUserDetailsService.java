package com.car.webapp.service.utente;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.car.webapp.domain.utente.Utente;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUtenteService utenteService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		String[] usernameAndId = StringUtils.split(username, "@"); //username@id
		
		if(usernameAndId == null || usernameAndId.length != 2)
			throw new UsernameNotFoundException("Inserisci username e id");
		
		String usernameUtente = usernameAndId[0];
		String idUtenteString = usernameAndId[1];
		Long idUtente = Long.parseLong(idUtenteString);
		
		Utente utente = utenteService.selUtenteByUsernameId(usernameUtente, idUtente);
		
		if(utente == null) {
			throw new UsernameNotFoundException("Utente non trovato");
		}
		
		UserBuilder builder = null;
		
		builder = User.withUsername(utente.getUsername());
		builder.disabled(utente.getRuolo().getIdRuolo() == 1 ? false : true);
		builder.password(utente.getPassword());
		
		
		return builder.build();
	
	
	}

}
