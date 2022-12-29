package com.car.webapp.repository.auto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.car.webapp.domain.auto.Auto;

@Repository
public class AutoRepositoryImpl implements IAutoRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Auto> getAllAuto() {
		
		String sql = "SELECT * FROM cars_db.auto;";
		List<Auto> auto = jdbcTemplate.query(sql, new AutoMapper());
		return auto;
	}

	@Override
	public void insAuto(Auto auto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delAuto(String targa) {
		
		String sql = "DELETE FROM cars_db.auto WHERE targa = '" + targa + "'";
		
		jdbcTemplate.update(sql);

	}

}
