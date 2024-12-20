package com.Mentorship_app.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.Mentorship_app.Entity.Connection;


@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {
    boolean existsByEmailAndEmail1(String email, String email1);   
    List<Connection> findByEmailAndStatus(String email, String status);
}


