package com.Mentorship_app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Mentorship_app.Entity.LoginRequest;
import com.Mentorship_app.Entity.User;
import com.Mentorship_app.services.ProfileService;
import com.Mentorship_app.services.UserService;

@RestController
@CrossOrigin("http://localhost:5173")
public class UserController {
	@Autowired
	UserService userservice;
	@Autowired
	ProfileService profileservice;
	@PostMapping("/register")
	public ResponseEntity<Object> adduser(@RequestBody User user) {
		 if (userservice.isEmailExists(user.getEmail())) {
		        return new ResponseEntity<>("Email is already registered", HttpStatus.BAD_REQUEST);
		    }
	    User savedUser = userservice.adduser(user);
	    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginuser(@RequestBody LoginRequest loginrequest) {
		boolean isUserExists = userservice.isUserExists(loginrequest.getEmail()); // Check if user exists
	    if (!isUserExists) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	    }

		  boolean isValid = userservice.login(loginrequest);
	        if (isValid) {
	            return ResponseEntity.ok("Login successful");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	        }
        
}	
}
