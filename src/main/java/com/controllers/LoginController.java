package com.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.models.ItemDTO;
import com.services.ItemService;
@Controller
public class LoginController {
	

	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		System.out.println("Welcome");
		ModelAndView model = new ModelAndView();
	
		model.setViewName("welcomePage");
		return model;
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout) {
		System.out.println(".................................... inside the login page method...........................");
		ModelAndView model = new ModelAndView();
		if (error != null) {
			System.out.println("......................invalid credentials.........................");
			model.addObject("error", "Invalid Credentials provided.");
		}
		if (logout != null) {
			model.addObject("message", "Logged out from security site successfully.");
		}
		System.out.println("valid credentials....................................................");
		model.setViewName("loginPage");
	
		return model;
	}

	
}