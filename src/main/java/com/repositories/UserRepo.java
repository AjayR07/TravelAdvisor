package com.repositories;

import org.springframework.stereotype.Repository;

import com.models.User;

@Repository
public interface UserRepo {
   User findbyuname(String uname);
   public int save(String uname,String email,String pass,String phno);
   public int createAdmin(String uname,String email,String pass,String phno);
}
