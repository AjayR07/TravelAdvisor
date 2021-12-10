package com.services;

import javax.transaction.Transactional;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.models.CartDTO;

@Service
@Transactional
public interface CartService {
	public CartDTO getMyCart(int userId);
	
	public String addToCart(int userId,int productId, int count);

	public int getCartProductsCount(int userId);
	
}
