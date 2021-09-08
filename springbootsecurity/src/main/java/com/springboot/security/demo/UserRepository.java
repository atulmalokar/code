package com.springboot.security.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//creating repository to make database related operations
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	//method to find user by username
	User findByUsername(String username);
}
