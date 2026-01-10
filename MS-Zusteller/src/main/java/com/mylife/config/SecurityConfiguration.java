package com.mylife.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Profile("production")
public class SecurityConfiguration {

	// Authentication
	// http://docs.spring.io/spring-security/site/docs/current/apidocs/org/springframework/security/config/annotation/web/configuration/WebSecurityConfigurerAdapter.html

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user")
		.password("ecube")
		.roles("USER", "ADMIN");
	}

	// Authorization with challenge box (Basic)
	@Configuration
	@Order(2)
	@Profile("development")
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/**")
			.authorizeRequests()
			.anyRequest()
			.hasRole("ADMIN")
			.and()
			.httpBasic()
			.and()
			.csrf()
			.disable();
		}
	}
 
	@Configuration
	@Order(1)
	@Profile("development")
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/website/**")
			.authorizeRequests()
			.anyRequest()
			.hasRole("USER")
			.and()
			.formLogin()
					.loginPage("/website/login.jsp")
					.failureUrl("/website/login.jsp?error=1")
					.loginProcessingUrl("/website/login")
					.permitAll()
					.and()
					.logout()
					.logoutSuccessUrl("/website/vehicles/list.html");
		}
	}
}
