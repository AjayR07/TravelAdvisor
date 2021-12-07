package com.controllers;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.services.ItemService;

@Controller
@RequestMapping("products")
public class ProductController {
	@Autowired
	private ItemService itemService;
	

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@RequestMapping(value = { "/all"}, method = RequestMethod.GET)
	public ModelAndView homePage(ModelAndView model) {
		
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
	

	
}
