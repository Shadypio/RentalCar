package com.car.webapp.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.car.webapp.domain.utente.Utente;

@Repository
public class UtenteDaoImpl extends AbstractDao<Utente, Long> implements IUtenteDao {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	// Criteria API
	@Override
	public List<Utente> selTutti() {
		
		
		/*CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Utente> queryDefinition = queryBuilder.createQuery(Utente.class);
		
		Root<Utente> recordset = queryDefinition.from(Utente.class);
		
		queryDefinition.select(recordset);
		
		List<Utente> utentiTrovati = entityManager.createQuery(queryDefinition).getResultList();
		
		entityManager.clear();
		
		return utentiTrovati;*/
		
		return super.selTutti();
	}

	@Override
	public Utente selById(Long id) {
		
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Utente> queryDefinition = queryBuilder.createQuery(Utente.class);
		
		Root<Utente> recordset = queryDefinition.from(Utente.class);
		
		queryDefinition.select(recordset)
			.where(queryBuilder.equal(recordset.get("idUtente"), id));
		
		Utente utente = entityManager.createQuery(queryDefinition).getSingleResult();
		
		entityManager.clear();
		
		return utente;
		// return super.selById(id);
	}
	
	/**
	 * Metodo con JPQL - La sintassi si riferisce alla classe Java
	 * @param 
	 * @return
	 
	@Override
	@SuppressWarnings("unchecked")
	public Utente selbyId(Long id)
	{
		String JPQL = "SELECT a FROM Utente a WHERE a.idUtente = :idUtente";
		
		
		Utente utente =  entityManager.createQuery(JPQL)
								 .setParameter("idUtente", id)
								 .getSingleResult();
		
		return utente;
	}
	*/
	
	@Override
	public Utente selByUserId(String username, Long id) {
		
		return this.selById(id);
		
	}


	@Override
	public void salva(Utente utente) {
		
		super.inserisci(utente);
		
//		String SQL = "INSERT INTO `cars_db`.`utente` (`nome`, "
//				+ "`cognome`, "
//				+ "`username`, "
//				+ "`password`, "
//				+ "`dataDiNascita`, "
//				+ "`fk_idRuolo`) VALUES \r\n"
//				+ "(:nome, :cognome, :username, :password, :dataDiNascita, :fk_idRuolo);";
//		
//		entityManager.createNativeQuery(SQL)
//			.setParameter("nome", utente.getNome())
//			.setParameter("cognome", utente.getCognome())
//			.setParameter("username", utente.getUsername())
//			.setParameter("password", utente.getPassword())
//			.setParameter("dataDiNascita", utente.getDataDiNascita())
//			//.setParameter("fk_idRuolo", 2)
//			.setParameter("fk_idRuolo", utente.getRuolo().getIdRuolo())
//			.executeUpdate();
		
	}

	@Override
	public void aggiorna(Utente utente) {
		
		super.aggiorna(utente);
		
	}

	@Override
	public void elimina(Utente utente) {
		
		super.elimina(utente);
		
	}
	
	@Override
	public void eliminaById(Long id) {
		
		super.eliminaById(id);
		
	}

	/*
	INSERT INTO `cars_db`.`utente` (`nome`, `cognome`, `username`, `password`, `dataDiNascita`, `fk_idRuolo`) VALUES 
	('Mario', 'Rossi', 'mariorossi', 'PasswordRossi1.', '2000-06-12', 1);
	*/

	@Override
	public void salvaAdminUser(String password) {
		
		String encodedPassword = passwordEncoder.encode(password);
		
		String SQL = "INSERT INTO `cars_db`.`utente` (`nome`, "
				+ "`cognome`, "
				+ "`username`, "
				+ "`password`, "
				+ "`dataDiNascita`, "
				+ "`fk_idRuolo`) VALUES \r\n"
				+ "('Mario', 'Rossi', 'mariorossi', :password, '2000-06-12', 1);";
		
		entityManager.createNativeQuery(SQL).setParameter("password", encodedPassword).executeUpdate();
		
	}

	

}
