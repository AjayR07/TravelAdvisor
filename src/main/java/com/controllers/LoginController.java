package com.controllers;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.models.SmsCode;
import com.repositories.UserRepoImpl;
import com.util.sms.SmsSenderImpl;
@Controller
public class LoginController {
	
	@Autowired
    UserRepoImpl us;
	
	private static Logger logger = Logger.getLogger(LoginController.class.getName());
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		System.out.println("Welcome");
		ModelAndView model = new ModelAndView();

		model.setViewName("welcomePage");
		return model;
	}

	@RequestMapping(value = {"/login","/register"}, method = RequestMethod.GET)
	public ModelAndView loginPage(HttpServletRequest request,ModelAndView model,@RequestParam(value = "error",required = false) String error,
			@RequestParam(value = "logout",	required = false) String logout) {
	
		model.addObject("path",request.getRequestURI());
		if (error != null) {
			System.out.println("......................invalid credentials.........................");
			model.addObject("error", "Invalid Credentials provided.");
		}
		if (logout != null) {
			model.addObject("info", "Logged out from security site successfully.");
		}
		logger.info("User trying to login");
		model.setViewName("login");
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
					logger.info(Mail +" Registered Successfully");
					model.addObject("regStatus", "Registered Successfully");
					model.setViewName("welcomePage");
				}
				else {
					model.addObject("path",request.getRequestURI());
					model.addObject("error", "User Account already exists...");
					model.setViewName("login");
				}
				return model;
	}
	

	@RequestMapping(value = {"/forgotPass"}, method = RequestMethod.GET)
	public void forgotPass(HttpServletRequest request,HttpServletResponse response) {
		String phone=us.findbyuname(request.getParameter("uname")).getPhonenum();
		String code = RandomStringUtils.randomNumeric(6);
	    
	    System.out.println(phone+" "+ code);
		try {
//			new SmsSenderImpl().sendSMS(phone, code);
			response.getWriter().append(code+"-"+phone);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	@RequestMapping(value = {"/resetPass"}, method = RequestMethod.POST)
	public void resetPass(HttpServletRequest request,HttpServletResponse response) {
		
	  us.update(request.getParameter("uname"), request.getParameter("pass"));
		
	}
	
}