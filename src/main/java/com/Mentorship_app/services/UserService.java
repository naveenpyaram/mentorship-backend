package com.Mentorship_app.services;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.Mentorship_app.Entity.LoginRequest;

import com.Mentorship_app.Entity.User;
import com.Mentorship_app.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	public UserRepository userrepository;
	public User adduser(User user) {
		User user1 =  userrepository.save(user);
	        return user1;
	}
	public boolean login(LoginRequest loginrequest) {
		
		  User user = userrepository.findByEmail(loginrequest.getEmail());
		  if (user != null && user.getPassword().equals(loginrequest.getPassword())) {
	            return true;
	        }
	        return false;
	}
	
	public User getuserbyemail(String email) {
	User user = userrepository.findByEmail(email);
		return user;
	}
	public boolean isUserExists(String email) {
		User user = userrepository.findByEmail(email);
		if(user == null) {
			return false;
		}
		return true;
	}

	
	}
