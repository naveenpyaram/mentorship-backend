package com.Mentorship_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mentorship_app.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
    boolean existsByEmail(String email);
}
