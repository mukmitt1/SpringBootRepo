package com.mml.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mml.sb.model.LoginProcessor;

@Controller
public class LoginController {
	private final LoginProcessor loginProcessor;

	  public LoginController(LoginProcessor loginProcessor) {
	    this.loginProcessor = loginProcessor;
	    System.out.println("Controller Singletonnnnnnnnnnnnnnnnn");
	  }

	  @GetMapping("/")
	  public String loginGet() {
	    return "login.html";
	  }

	  @PostMapping("/")
	  public String loginPost(
	      @RequestParam String username,
	      @RequestParam String password,
	      Model model
	  ) {
	    loginProcessor.setUsername(username);
	    loginProcessor.setPassword(password);
	    boolean loggedIn = loginProcessor.login();

	    if (loggedIn) {
	    	System.out.println("Loged in and show mainnnnnnnnn page ");
	    	return "redirect:/main";
	    } 
	    
	    
	    model.addAttribute("message", "Login failed!");
	    return "login.html";
	  }
	
	
}
