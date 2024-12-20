package com.Mentorship_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mentorship_app.Entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>{
	Profile findByEmail(String email);
	
}
