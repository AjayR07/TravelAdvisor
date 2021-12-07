package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.models.CartDTO;



public interface CartRepo extends JpaRepository<CartDTO,Integer> {
	public CartDTO findByUserId(int userId);
}
