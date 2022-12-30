package com.car.webapp.repository.auto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.car.webapp.domain.auto.Auto;

public class AutoMapper implements RowMapper<Auto>{

	@Override
	public Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Auto auto = new Auto();
		
		try
		{ 
			
			auto.setTarga(rs.getString("targa"));
			auto.setMarca(rs.getString("marca"));
			auto.setModello(rs.getString("modello"));
			auto.setAnno(rs.getInt("anno"));
			auto.setCategoria(rs.getString("categoria"));
			auto.setFk_idAdmin(rs.getLong("fk_idAdmin"));
			auto.setFk_idPrenotazione(rs.getLong("idPrenotazione"));
		}
		

		catch (Exception ex)
		{
			System.out.println("Errore in autoMapper.mapRow: " + ex);
		}

		return auto;
	}

	
}
