package com.controllers;

import java.io.IOException;

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

@Controller
@RequestMapping("cart")
public class CartController {
	@Autowired
	private CartServiceImpl cartService;
	

	
	
	@RequestMapping(value={"/addItem"},method = RequestMethod.POST)
	public ModelAndView addItemToCart(HttpServletRequest request, javax.servlet.http.HttpServletResponse response,ModelAndView model) throws ServletException, IOException{
		int uid=1;
		System.out.println("Hello Adding item to your cart");
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int quantity = Integer.parseInt(request.getParameter("qty"));
		cartService.addToCart(uid,itemId, quantity);
		model.setViewName("homePage");
		return model;
		
	}
	@GetMapping("")
	public ModelAndView myCart(ModelAndView model) {

			CartDTO cart=cartService.getMyCart(1);
		
			model.addObject("products", cart);
			model.setViewName("myCart");
			return model;
		}
}
