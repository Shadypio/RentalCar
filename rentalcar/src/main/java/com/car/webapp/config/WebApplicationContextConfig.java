package com.car.webapp.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
// import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.car.webapp")
public class WebApplicationContextConfig  implements WebMvcConfigurer
{
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry)
	{
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");

		registry.addInterceptor(localeChangeInterceptor);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/img/**").addResourceLocations("/static/images/");
	}
	
	@Override
	public Validator getValidator()
	{
		return validator();
	}
	
	@Bean
	public LocaleResolver localeResolver()
	{
		/*
		 * SessionLocaleResolver resolver = new SessionLocaleResolver();
		 * resolver.setDefaultLocale(new Locale("it")); return resolver;
		 */

		CookieLocaleResolver r = new CookieLocaleResolver();
		r.setCookieName("localeInfo");
		r.setCookieMaxAge(24 * 60 * 60);
		r.setDefaultLocale(new Locale("it"));

		return r;

	}
	
	@Bean(name = "validator")
	public LocalValidatorFactoryBean validator()
	{
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());

		return bean;
	}
	
	/* Alternativa del MessageSource
	@Bean
    public MessageSource messageSource() 
	{
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    */
	
	
	@Bean
	public MessageSource messageSource()
	{
		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
		resource.setBasename("messages");
		
		return resource;
	}


	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);

		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");

		return resolver;
	}
}

