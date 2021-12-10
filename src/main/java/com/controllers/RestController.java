package com.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.razorpay.*;
import com.services.CartServiceImpl;
import com.services.MyUserDetailsService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private CartServiceImpl cartService;
	
	@Autowired
	private MyUserDetailsService userService;
	
	 @PostMapping(value="/cart/addItem",produces = "application/json")
	public Map<String, Object> addToCart(int itemId,int qty, Principal principal) {
		 JSONObject jsonObject = new JSONObject();
		 if(principal == null) {	
			 jsonObject.append("msg","Session Not Found");
			 return jsonObject.toMap();
			}
			int uid=userService.getUser(principal.getName()).getUid();
			System.out.println("Hello Adding item to your cart");
			String res=cartService.addToCart(uid,itemId, qty);
			int cnt=cartService.getCartProductsCount(uid);
			jsonObject.append("msg",res);
			jsonObject.append("cart",cnt);
			return jsonObject.toMap();
	}

	 
}
