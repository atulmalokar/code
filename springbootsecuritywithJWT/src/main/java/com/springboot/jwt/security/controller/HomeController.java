package com.springboot.jwt.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jwt.security.model.JwtRequest;
import com.springboot.jwt.security.model.JwtResponse;
import com.springboot.jwt.security.service.UserService;
import com.springboot.jwt.security.utiliy.JWTUtility;

//controller class
@RestController
public class HomeController {

	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private UserService userServie;
	
	//default page
	@GetMapping("/")
	public String home() {
		return "Welcome to daily code buffer";
	}
	
	//authenticate methode with username and password
	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
		
		try {
			manager.authenticate(new UsernamePasswordAuthenticationToken
					(jwtRequest.getUsername(), 
					jwtRequest.getPassword())
					);
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid Credentials");
		}
		final UserDetails details= userServie.loadUserByUsername(jwtRequest.getUsername());
		
		final String tokenString=jwtUtility.generateToken(details);
		return new JwtResponse(tokenString);
		
	}
}
