package com.controllers;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.models.User;
import com.repositories.UserRepoImpl;
@Controller
public class LoginController {
	
	@Autowired
    UserRepoImpl us;
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		System.out.println("Welcome");
		ModelAndView model = new ModelAndView();
	
		model.setViewName("welcomePage");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPage(
			HttpServletRequest request,@RequestParam(value = "error",required = false) String error,
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
		String Mail = request.getParameter("username");
		User u=us.findbyuname(Mail);
		System.out.println(u);
		System.out.println(u.getUsername());
		System.out.println("valid credentials....................................................");
		return "homePage";
	}
	
	@GetMapping("/register")
	public ModelAndView register()
	{
				ModelAndView model = new ModelAndView();
				model.setViewName("register");
				return model;	
				
	}
	
	@PostMapping(value="/register")
	public ModelAndView SaveRegister(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException
	{
			ModelAndView model = new ModelAndView();
			    System.out.println("tosavehello");
			    String uname = request.getParameter("username");
				String pwd = request.getParameter("password");
				String phno = request.getParameter("Phonenum");
			    String Mail = request.getParameter("Mail");
			    System.out.println(phno.getClass().getName());
			    
				int i=us.save(uname,Mail,pwd,phno);
				if(i == 1) {
					model.addObject("success", "Registered Successfully");
					model.setViewName("welcomePage");
				}
				else {
					model.addObject("error", "UserNameAlready taken.");
					model.setViewName("register");
				}
				return model;
	}

	
}