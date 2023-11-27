package com.example.dao;

import com.example.entity.User;

public interface IUserDao {

	public String validateUser(User user);
	public String saveUser(User user);
}
