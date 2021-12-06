package com.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDTO implements Serializable{
	

	private static final long serialVersionUID = 6027688536869418188L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	
	private String userName;


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
