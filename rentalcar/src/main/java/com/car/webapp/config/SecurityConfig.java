package com.car.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter
{
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	};
	
	@Bean
	@Override
	public UserDetailsService userDetailsService()
	{
		UserBuilder users = User.builder();
		
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		
		// Utente 1
		manager.createUser(
				users
				.username("lucaverdi")
				.password(new BCryptPasswordEncoder().encode("PasswordVerdi1."))
				.roles("USER")
				.build());
		
		manager.createUser(
				users
				.username("mariorossi")
				.password(new BCryptPasswordEncoder().encode("PasswordRossi1."))
				.roles("USER", "ADMIN")
				.build());
		
		return manager;

	}
	
	@Bean
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() 
	{
	    StrictHttpFirewall firewall = new StrictHttpFirewall();
	    firewall.setAllowUrlEncodedSlash(true);
	    firewall.setAllowSemicolon(true);
	    
	    return firewall;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception 
	{
	  super.configure(web);
	  
	  web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
	 
	}
	
	@Override
	public void configure(final AuthenticationManagerBuilder auth) throws Exception
	{
		auth
			.userDetailsService(userDetailsService())
			.passwordEncoder(passwordEncoder());
	}
	
	private static final String[] ADMIN_CLIENTI_MATCHER =
	{
			"/utente/aggiungi/**",
			"/utente/modifica/**",
			"/utente/elimina/**",
			
			"/auto/aggiungi/**",
			"/auto/modifica/**",
			"/auto/elimina/**",
			
	};
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception
	{
		http
		.authorizeRequests()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/login/**").permitAll()
		.antMatchers("/").hasAnyRole("ANONYMOUS", "USER")
		.antMatchers(ADMIN_CLIENTI_MATCHER).access("hasRole('ADMIN')")
		.antMatchers("/utente/**").hasRole("USER")
		.antMatchers("/auto/**").hasRole("USER")
		.and()
			.formLogin()
				.loginPage("/login/form")
				.loginProcessingUrl("/login")
				.failureUrl("/login/form?error")
					.usernameParameter("userId")
					.passwordParameter("password")
		.and()
			.exceptionHandling()
			.accessDeniedPage("/login/form?forbidden")
		.and()
			.logout()
			.logoutUrl("/login/form?logout");
		//.and().csrf().disable();
				
	}

}
