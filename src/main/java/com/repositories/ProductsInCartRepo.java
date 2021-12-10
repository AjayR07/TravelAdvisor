package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.models.ProductsInCart;



public interface ProductsInCartRepo extends JpaRepository<ProductsInCart,Integer> {
	
}
