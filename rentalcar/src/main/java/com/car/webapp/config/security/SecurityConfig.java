package com.car.webapp.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService userDetailsService;
	
	@Autowired
	@Qualifier("persistentTokenRepository")
	private PersistentTokenRepository persistentTokenRepository;
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	};
	
	/*
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
	*/
	
	@Bean
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() 
	{
	    StrictHttpFirewall firewall = new StrictHttpFirewall();
	    firewall.setAllowUrlEncodedSlash(true);
	    // abilita ; nell'url
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
//		auth
//			.userDetailsService(userDetailsService())
//			.passwordEncoder(passwordEncoder());
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return authenticationProvider;
	}
	
	private static final String[] ADMIN_UTENTI_MATCHER =
	{
			"/utente/aggiungi/**",
			"/utente/modifica/**",
			"/utente/elimina/**",
			
	};
	
	private static final String[] ADMIN_AUTO_MATCHER =
		{
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
		.antMatchers("/").hasAnyRole("ANONYMOUS", "USER", "ADMIN")
		.antMatchers(ADMIN_AUTO_MATCHER).hasAuthority("ROLE_ADMIN")
		.antMatchers(ADMIN_UTENTI_MATCHER).hasAuthority("ROLE_ADMIN")
		.antMatchers(ADMIN_AUTO_MATCHER).access("hasRole('ADMIN')")
		.antMatchers(ADMIN_UTENTI_MATCHER).access("hasRole('ADMIN')")
		.antMatchers("/utente/**").hasAnyRole("USER", "ADMIN")
		.antMatchers("/auto/**").hasAnyRole("USER", "ADMIN")
		.antMatchers("/prenotazione/**").hasAnyRole("USER", "ADMIN")
		.and()
		.addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
			.formLogin()
				.loginPage("/login/form")
				.loginProcessingUrl("/login")
				.failureUrl("/login/form?error")
					.usernameParameter("username")
					.passwordParameter("password")
		.and()
			.exceptionHandling()
			.accessDeniedPage("/login/form?forbidden")
		.and()
			.logout()
			.logoutUrl("/login/form?logout");
//		.and().csrf().disable();
				
	}
	
	public AuthenticationFilter authenticationFilter() 
			throws Exception 
	{
		
		 AuthenticationFilter filter = new AuthenticationFilter();
		 
		 filter.setAuthenticationManager(authenticationManagerBean());
		 filter.setAuthenticationFailureHandler(failureHandler());
		 filter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
		 filter.setRememberMeServices(customRememberMeServices());
		 
		 return filter;
		 
	}
	
	public SimpleUrlAuthenticationFailureHandler failureHandler() 
	{ 
        return new SimpleUrlAuthenticationFailureHandler("/login/form?error"); 
    } 
	
	@Bean
	public SavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler() 
	{
        SavedRequestAwareAuthenticationSuccessHandler auth = new SavedRequestAwareAuthenticationSuccessHandler();
		auth.setTargetUrlParameter("targetUrl");
        
		return auth;
	}
	
	@Bean
	public PersistentTokenBasedRememberMeServices customRememberMeServices()
	{
		String Key = "ricordamiKey";
		
		PersistentTokenBasedRememberMeServices rememberMeServices = 
      			new CustomRememberMeServices(Key, userDetailsService, persistentTokenRepository);
		
		rememberMeServices.setCookieName("ricordami");
      	rememberMeServices.setTokenValiditySeconds(60 * 60 * 4);
      	rememberMeServices.setParameter("ricordami");
      	rememberMeServices.setUseSecureCookie(false); //todo Abilitare con l'SSL
      	
      	return rememberMeServices;
		
		
	}
	
	
//	@Bean
//    public PersistentTokenRepository persistentTokenRepository() 
//	{
//        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
//        tokenRepositoryImpl.setDataSource(dataSource);
//        
//        return tokenRepositoryImpl;
//    }


}
