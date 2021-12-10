package com.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.models.CartDTO;
import com.models.User;
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
			
			User user=userService.getUser(principal.getName());
			CartDTO cart=cartService.getMyCart(user.getUid());

			model.addObject("cart", cart);
			model.addObject("userName", user.getUsername());
			model.addObject("mail", user.getMail());
			model.addObject("contactNum", user.getPhonenum());
			model.setViewName("myCart");
			return model;
		}
	
}
