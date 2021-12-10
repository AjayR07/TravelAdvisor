package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.models.BookingDTO;
import com.models.CartDTO;



public interface BookingRepo extends JpaRepository<BookingDTO,Integer> {
	public List<BookingDTO> findByUserId(int userId);
	
}
