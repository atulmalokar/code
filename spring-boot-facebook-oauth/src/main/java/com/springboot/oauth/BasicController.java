package com.springboot.oauth;

import java.security.Principal;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

	@GetMapping("/")
	public String home(Principal principal) {
		Map<String, Object> authDetails= (Map<String, Object>) ((OAuth2Authentication) principal)
				.getUserAuthentication()
				.getDetails();
		
		String username= (String) authDetails.get("name");
		return "Hey "+ username + ", Welcome to OAuth2 code!!!";
	}
}
