package com.Mentorship_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mentorship_app.Entity.Connection;
import com.Mentorship_app.repository.ConnectionRepository;

import java.util.List;

@Service
public class ConnectionService {
	@Autowired
    private  ConnectionRepository connectionRepository;
	
	public List<Connection> getAcceptedConnections(String email) {
	    return connectionRepository.findByEmailAndStatus(email, "accepted");
	}
}