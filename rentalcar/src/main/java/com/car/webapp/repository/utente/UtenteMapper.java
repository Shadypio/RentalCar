package com.car.webapp.repository.utente;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.car.webapp.domain.utente.Utente;


public class UtenteMapper implements RowMapper<Utente>{

	@Override
	public Utente mapRow(ResultSet rs, int rowNum) throws SQLException {

		Utente utente = new Utente();

		try
		{ 
			utente.setIdUtente(rs.getLong("idUtente"));
			utente.setNome(rs.getString("nome"));
			utente.setCognome(rs.getString("cognome"));
			utente.setDataDiNascita(rs.getDate("dataDiNascita"));
			utente.setUsername(rs.getString("username"));
			utente.setPassword(rs.getString("password"));
		}
		catch (Exception ex)
		{
			System.out.println("Errore in utenteMapper.mapRow: " + ex);
		}

		return utente;
	}

}
