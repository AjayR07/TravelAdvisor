package com.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repositories.UserRepoImpl;

@Service
@Transactional
public class InitService {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UserRepoImpl userRepo;
	
	
	public void initializeEnv() {
		itemService.addItems();
		userRepo.createAdmin("admin", "admin", "admin", "9940029004");
		
	}
}
