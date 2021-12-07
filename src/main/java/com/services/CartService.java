package com.services;

import org.springframework.security.core.Authentication;

import com.models.CartDTO;

public interface CartService {
	public CartDTO getMyCart(int userId);
	
	public CartDTO addToCart(int userId,int productId, int count);


	
}
