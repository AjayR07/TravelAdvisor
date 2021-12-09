package com.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.services.CartServiceImpl;
import com.services.MyUserDetailsService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private CartServiceImpl cartService;
	
	@Autowired
	private MyUserDetailsService userService;
	
	 @PostMapping("/cart/addItem")
	public String addToCart(int itemId,int qty, Principal principal) {
		
		 if(principal == null) {		
				return "Session Not Found";
			}
			int uid=userService.getUser(principal.getName()).getUid();
			System.out.println("Hello Adding item to your cart");
			String res=cartService.addToCart(uid,itemId, qty);
			return res;
	}
	

}
