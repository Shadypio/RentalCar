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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	    // enable ; in url
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
	
	private static final String[] ADMIN_CUSTOMER_MATCHER =
	{
			"/customer/**",
			"/customer/add/**",
			"/customer/edit/**",
			"/customer/disable/**",
			"/customer/enable/**",
	};
	
	private static final String[] ADMIN_CAR_MATCHER =
		{
			"/car/add/**",
			"/car/edit/**",
			"/car/delete/**",
		};
	
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception
	{
		http
		.authorizeRequests()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/login/**").permitAll()
		.antMatchers("/").hasAnyRole("ANONYMOUS", "USER", "ADMIN")
		.antMatchers(ADMIN_CAR_MATCHER).access("hasRole('ADMIN')")
		.antMatchers(ADMIN_CUSTOMER_MATCHER).access("hasRole('ADMIN')")
		.antMatchers("/customer/detailscustomer/**").hasAnyRole("USER", "ADMIN")
		.antMatchers("/customer/detailscustomerusername/**").hasAnyRole("USER", "ADMIN")
		.antMatchers("/car/**").hasAnyRole("USER", "ADMIN")
		.antMatchers("/rental/**").hasAnyRole("USER", "ADMIN")
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
		auth.setTargetUrlParameter("/");
        
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
      	rememberMeServices.setUseSecureCookie(false); 
      	
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
