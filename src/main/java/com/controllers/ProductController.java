package com.controllers;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.models.ItemDTO;
import com.services.CartServiceImpl;
import com.services.ItemService;
import com.services.MyUserDetailsService;

@Controller
@RequestMapping("products")
public class ProductController {
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CartServiceImpl cartService;

	@Autowired
	private MyUserDetailsService userService;
	
	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@RequestMapping(value = { "/all"}, method = RequestMethod.GET)
	public ModelAndView homePage(ModelAndView model,Principal principal) {
		
		int cnt=cartService.getCartProductsCount(userService.getUser(principal.getName()).getUid());
		
		model.addObject("cart", cnt);
		model.addObject("products", itemService.listItems());
		model.setViewName("homePage");
		
		return model;
	}
	
	@GetMapping(value = { "/{id}"})
	public ModelAndView productPage(@PathVariable("id") String id,ModelAndView model) {
		model.addObject("product", itemService.findItemById(Integer.parseInt(id)));
		model.setViewName("productPage");
		return model;
	}
	
	
	public ModelAndView addProducts(HttpServletRequest request,ModelAndView model) {
		ItemDTO item=ItemDTO.getInstance(request.getParameter("ename"),request.getParameter("edesc"), itemService.imgToBlob("assets/scuba_1.jpg"), 1,"hour", Float.parseFloat(request.getParameter("price")), 30);
		model.addObject("success", "Event Added Successfully");
		model.setViewName("admin");
		return model;
		
	}

	
}
