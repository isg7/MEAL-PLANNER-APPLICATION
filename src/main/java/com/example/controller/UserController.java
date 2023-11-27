package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.IUserDao;
import com.example.dao.IUserDaoImpl;
import com.example.entity.User;
import com.example.repository.userRepo;

@RestController()
@RequestMapping("/user")
public class UserController {
	

	@Autowired
 private	userRepo  userrepo;

	
@Autowired	
private IUserDaoImpl iUserDaoImpl;
	
@PostMapping("/register")
public ResponseEntity<?> addUser(@RequestBody User user) {
    try {
        String result = iUserDaoImpl.saveUser(user);
        return ResponseEntity.ok(result);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
	
	
	@GetMapping("/")
	public ResponseEntity<?> getUser(){
	
		return ResponseEntity.ok(userrepo.findAll());
		
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestBody User user){
    return  iUserDaoImpl.validateUser(user);
	}
	
	
	
	
	
}
