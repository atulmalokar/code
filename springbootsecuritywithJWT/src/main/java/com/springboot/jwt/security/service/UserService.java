package com.springboot.jwt.security.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//creating user servie layer and implementing userDetailsService Interface
@Service
public class UserService implements UserDetailsService{
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Logic to get the user from the database
		return new User("admin", "password",new ArrayList<>());
	}

	
}
