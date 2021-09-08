package com.springboot.security.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


//main class which implements spring security
@Configuration
//annotation to enable web security to class
@EnableWebSecurity
//extending webSecurityConfigurerAdapter to provide Authentication (username/password)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	//adding user details service dependency from web security configurer adapter
	@Autowired
	UserDetailsService userDetailsService;
	
	//overriding authentication provider to set username and encrypted password
	//to save bcrypt password website refered bcrypt-generator
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		return daoAuthenticationProvider;
	}

	//overriding configure method to add roles to different users like for user will redirect to homepage
	//and admin will redirect to the admin page 
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//creating http authorize request and matching each url
		http.authorizeRequests()
		//default url permiting all the users
		.antMatchers("/")
		.permitAll()
		.antMatchers("/home")
		//for home page adding authority to user only
		.hasAuthority("USER")
		.antMatchers("/admin")
		//for admin page adding authority to admin page only
		.hasAuthority("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	
	
}
