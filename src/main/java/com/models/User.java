package com.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class User {
	 
@Id
@GenericGenerator(name="kaugen" , strategy="increment")
@GeneratedValue(generator="kaugen")
 private int uid;
private String Phonenum;

 public String getPhonenum() {
	return Phonenum;
}
public void setPhonenum(String phonenum) {
	Phonenum = phonenum;
}
public int getUid() {
	return uid;
}
public User() {
	super();
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getMail() {
	return Mail;
}
public void setMail(String mail) {
	Mail = mail;
}

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
private String username;
private  String Mail;

private String role;
private int flag;

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
private String password;
 
}
