package com.controllers;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.models.CartDTO;
import com.services.CartServiceImpl;
import com.services.MyUserDetailsService;

@Controller
@RequestMapping("cart")
public class CartController {
	@Autowired
	private CartServiceImpl cartService;
	
	@Autowired
	private MyUserDetailsService userService;
	
	@GetMapping("")
	public ModelAndView myCart(ModelAndView model, Principal principal) {
			
			
			CartDTO cart=cartService.getMyCart(userService.getUser(principal.getName()).getUid());
		
			model.addObject("cart", cart);
			model.setViewName("myCart");
			return model;
		}
	
}
