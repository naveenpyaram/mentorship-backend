package com.Mentorship_app.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profiles")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String name;
	private String mobile;
	private String bio;
	private String role;
	private List<String> skills;
	private List<String> interests;
	public Profile() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public List<String> getInterests() {
		return interests;
	}
	public void setInterests(List<String> interests) {
		this.interests = interests;
	}
	public Profile(int id, String email, String name, String mobile, String bio, String role, List<String> skills,
			List<String> interests) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.mobile = mobile;
		this.bio = bio;
		this.role = role;
		this.skills = skills;
		this.interests = interests;
	}
	
	
	
}
