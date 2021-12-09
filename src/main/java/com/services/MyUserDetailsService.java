package com.services;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.repositories.UserRepoImpl;
import com.models.User;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepoImpl repo;
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = repo.findbyuname(username);
		if(user == null)
		{
			throw new UsernameNotFoundException("User 404");
		}
		
		 System.out.println("Name is "+user.getUsername());
		 
      return new UserDetailsImpl(user);
	}
	
	public User getUser(String mail) {
		return repo.findbyuname(mail);
	}

}
