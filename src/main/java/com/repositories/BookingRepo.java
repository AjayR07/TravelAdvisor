package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.models.BookingDTO;



public interface BookingRepo extends JpaRepository<BookingDTO,Integer> {
	
}
