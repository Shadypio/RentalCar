package com.car.webapp.repository.utente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.car.webapp.domain.utente.Utente;

@Repository
public class UtenteRepositoryImpl implements IUtenteRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Utente> getAllUtenti() {
		
		String sql = "SELECT * FROM cars_db.utente;";
		List<Utente> utenti = jdbcTemplate.query(sql, new UtenteMapper());
		return utenti;
	}

	@Override
	public void insUtente(Utente utente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delUtente(Long idUtente) {
		
		String sql = "DELETE FROM cars_db.utente WHERE idUtente = '" + idUtente + "'";
		
		jdbcTemplate.update(sql);
		
	}

}
