package com.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.ItemDTO;

@Repository
public interface ItemDAO extends JpaRepository<ItemDTO,Integer>{

}
	
