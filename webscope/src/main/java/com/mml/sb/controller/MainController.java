package com.mml.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mml.sb.service.LoggedUserManagementService;
import com.mml.sb.service.LoginCountService;

@Controller
public class MainController {

	private final LoggedUserManagementService loggedUserManagementService;
	private final LoginCountService loginCountService;
	 
	  public MainController(LoggedUserManagementService loggedUserManagementService,  LoginCountService loginCountService) {
	    this.loggedUserManagementService = loggedUserManagementService;
	    this.loginCountService = loginCountService;
	  }

	  @GetMapping("/main")
	  public String home(
	      @RequestParam(required = false) String logout,
	      Model model
	  ) {
		  
	    if (logout != null) {
	      loggedUserManagementService.setUsername(null);
	    }

		 //If logout parameter not passed and user refresh the same page
	    String username = loggedUserManagementService.getUsername();
	    int count = loginCountService.getCount();
	    
	    
	    if (username == null) {
	      return "redirect:/";
	    }

	    model.addAttribute("username" , username);
	    model.addAttribute("loginCount", count);
	    return "main.html";
	  }
}
