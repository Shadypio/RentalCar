package com.car.webapp.service.customer;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.car.webapp.domain.customer.Customer;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private ICustomerService customerService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Customer customer = customerService.getCustomerByUsername(username);
		
		if(customer == null) {
			throw new UsernameNotFoundException("Utente non trovato");
		}
		
		UserBuilder builder = null;
		
		builder = User.withUsername(customer.getUsername());
		builder.disabled(false);
		builder.password(customer.getPassword());
		builder.disabled((customer.getEnabled() ? false : true ));
		builder.authorities("ROLE_" + customer.getRole().getRoleName());
		
		return builder.build();
	
	
	}

}
