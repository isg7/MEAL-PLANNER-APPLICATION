package com.example.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {

	private String email;
	private String phone;
private String password;










public User(String email, String phone, String password) {
	super();
	this.email = email;
	this.phone = phone;
	this.password = password;
	System.out.println(getClass().getName());
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "User [email=" + email + ", phone=" + phone + ", password=" + password + "]";
}


	
	
}
