package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.services.ItemService;

@Controller
public class AdminController 
{
	@Autowired
	private ItemService itemService;
	
	@GetMapping(value="/admin")
	public ModelAndView adminPage(ModelAndView model) {

		model.addObject("products", itemService.listItems());

		model.setViewName("admin");
		return model;
		
	}
}
