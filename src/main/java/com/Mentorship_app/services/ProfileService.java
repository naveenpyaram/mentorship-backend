package com.Mentorship_app.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mentorship_app.Entity.Profile;
import com.Mentorship_app.repository.ProfileRepository;

@Service
public class ProfileService {
	@Autowired
	public ProfileRepository profilerepository;

	public List<Profile> allprofiles() {
		List<Profile> profiles = profilerepository.findAll();
		return profiles;
	}

	public Profile getuserbyemail(String email) {
	Profile profile = profilerepository.findByEmail(email);
		return profile;
	}

	public Profile addProfile(Profile profile) {
		Profile profile1 = profilerepository.save(profile);
		return profile1;
	}

	public void deleteprofilebyemail(String email) {
			Profile profile = profilerepository.findByEmail(email);
			profilerepository.delete(profile);
		
	}

	
	public Profile updateProfile(String email, Profile profile) {
	    Profile profile1 = profilerepository.findByEmail(email); 
	    if (profile1 != null) { 
	        profile1.setBio(profile.getBio());
	        profile1.setEmail(profile.getEmail());
	        profile1.setMobile(profile.getMobile());
	        profile1.setName(profile.getName());
	        profile1.setSkills(profile.getSkills());
	        profile1.setInterests(profile.getInterests());
	        // Persist the changes to the database
	        profilerepository.save(profile1); 
	    } 
	    return profile1; 
	}
	
	

}
