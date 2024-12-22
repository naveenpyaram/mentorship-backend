package com.Mentorship_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Mentorship_app.Entity.Profile;
import com.Mentorship_app.services.ProfileService;

@RestController
@CrossOrigin("http://localhost:5173")
public class ProfileController {
	@Autowired
	ProfileService profileservice;
	@PostMapping("/addProfile")
	public ResponseEntity<Profile>addProfile(@RequestBody Profile profile){
		Profile profile1 = profileservice.addProfile(profile);
		return new
	  ResponseEntity<>(profile1,HttpStatus.CREATED);
	}
	@GetMapping("/getall")
	public ResponseEntity<List<Profile>> allprofiles(){
		List<Profile> profiles = profileservice.allprofiles();
		return ResponseEntity.ok(profiles);
	}
	
	@GetMapping("/get/{email}") 
	public ResponseEntity<Profile>getuserbyemail(@PathVariable String email) { 
		Profile profile = profileservice.getuserbyemail(email);
		return ResponseEntity.ok(profile);
		}
	@DeleteMapping("delete/{email}")
	public ResponseEntity<String> deleteprofilebyemail(@PathVariable String email){
		profileservice.deleteprofilebyemail(email);
		return ResponseEntity.ok("profile deleted succesfully");
		}
	@PutMapping("update/{email}")
	public ResponseEntity<Profile> updateProfile(@PathVariable String email,@RequestBody Profile profile){
		Profile profile1 = profileservice.updateProfile(email,profile);
		return ResponseEntity.ok(profile1);
	}
}
