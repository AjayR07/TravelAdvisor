package com.controllers;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	
	@PostMapping(value={"/add"})
	public String addProducts(HttpServletRequest request,ModelAndView model, @RequestParam("eimage") MultipartFile multipartFile) throws IOException {
		
		System.out.println(multipartFile.getOriginalFilename());

		BufferedImage bimage;
		ByteArrayOutputStream baos =null;
		   try (InputStream inputStream = multipartFile.getInputStream()) {
				bimage = (BufferedImage)ImageIO.read(inputStream);
				baos = new ByteArrayOutputStream();
				ImageIO.write(bimage, "jpg", baos);
	        } catch (IOException ioe) {        
	            throw new IOException("Could not save image file: " , ioe);
	        }      
		   ItemDTO item=ItemDTO.getInstance(request.getParameter("ename"),request.getParameter("edesc"), baos.toByteArray(), 1,"hour", Float.parseFloat(request.getParameter("price")),Integer.parseInt(request.getParameter("eavail")));
		   System.out.println(item);
		   itemService.addItem(item);
		   
		 return "redirect:/admin?added";
	
		
	}

	
}
