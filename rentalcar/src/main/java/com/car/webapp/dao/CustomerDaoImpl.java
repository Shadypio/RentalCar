package com.car.webapp.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.car.webapp.domain.customer.Customer;

@Repository
public class CustomerDaoImpl extends AbstractDao<Customer, Long> implements ICustomerDao {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public List<Customer> doRetrieveAll() {
		
		return super.doRetrieveAll();
	}

	@Override
	public Customer doRetrieveById(Long id) {
		
		return super.doRetrieveById(id);
	}
	
	@Override
	public Customer doRetrieveByUsername(String username) {
		
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> queryDefinition = queryBuilder.createQuery(Customer.class);
		
		Root<Customer> recordset = queryDefinition.from(Customer.class);
		
		queryDefinition.select(recordset)
			.where(queryBuilder.equal(recordset.get("username"), username));
		
		Customer customer = entityManager.createQuery(queryDefinition).getSingleResult();
		
		entityManager.clear();
		
		return customer;
		
	}


	@Override
	public void doSave(Customer customer) {
		
		super.doSave(customer);
		
	}

	@Override
	public void doUpdate(Customer customer) {
		
		super.doUpdate(customer);
		
	}
	
	@Override
	public void doSaveAdminUser(String password) {
		
		String encodedPassword = passwordEncoder.encode(password);
		
		String SQL = "INSERT INTO `cars_db`.`customer` (`first_name`, "
				+ "`last_name`, "
				+ "`username`, "
				+ "`password`, "
				+ "`date_of_birth`, "
				+ "`enabled`, "
				+ "`fk_id_role`) VALUES \r\n"
				+ "('Mario', 'Rossi', 'mariorossi', :password, '2000-06-12', true, 1);";
		
		entityManager.createNativeQuery(SQL).setParameter("password", encodedPassword).executeUpdate();
		
	}

	@Override
	public void doDisableCustomer(Customer customer) {
		
		customer.setEnabled(false);
		super.doUpdate(customer);
		
	}
	
	@Override
	public void doEnableCustomer(Customer customer) {
		
		customer.setEnabled(true);
		super.doUpdate(customer);
		
	}

	

}
