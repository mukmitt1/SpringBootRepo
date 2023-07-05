package com.mml.sb.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.mml.sb.service.LoggedUserManagementService;
import com.mml.sb.service.LoginCountService;

@Component
@RequestScope
public class LoginProcessor {
	private String username;
	private String password;
	
	private final LoggedUserManagementService loggedUserManagementService;
	private final LoginCountService loginCountService;
	
	 public LoginProcessor(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
		    this.loggedUserManagementService = loggedUserManagementService;
		    this.loginCountService = loginCountService;
		    System.out.println("My Request scope login processor rrrrrrrrrrrrrrrrrrrr. call with every request");
	 }
	 

	public boolean login() {
	    loginCountService.increment();

		String username = this.getUsername();
	    String password = this.getPassword();

	    boolean loginResult = false;
	    
	    if ("admin".equals(username) && "password".equals(password)) {
	    	loginResult = true;
	    	loggedUserManagementService.setUsername(username);
	    	System.out.println("login is authenticatedddddddddddd");
	    	
	    } 
	    
	    return loginResult;
	  }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
