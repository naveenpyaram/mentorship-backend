package com.Mentorship_app.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mentorship_app.Entity.Connection;
import com.Mentorship_app.Entity.ConnectionRequest;
import com.Mentorship_app.Entity.ConnectionRequest.ConnectionRequestStatus;
import com.Mentorship_app.Entity.ConnectionRequestDTO;
import com.Mentorship_app.Entity.User;
import com.Mentorship_app.repository.ConnectionRepository;
import com.Mentorship_app.repository.ConnectionRequestRepository;
import com.Mentorship_app.repository.UserRepository;

@Service
public class ConnectionRequestService {
    @Autowired
    private ConnectionRequestRepository connectionRequestRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ConnectionRepository connectionRepository;

   
    public ConnectionRequest sendConnectionRequest(String senderEmail, String receiverEmail) {
        // Check if request already exists
        Optional<ConnectionRequest> existingRequest = connectionRequestRepository
            .findBySenderEmailAndReceiverEmailAndStatus(senderEmail, receiverEmail, ConnectionRequestStatus.PENDING);
        
        if (existingRequest.isPresent()) {
            throw new RuntimeException("Connection request already sent");
        }

        // Fetch sender details
        User sender = userRepository.findByEmail(senderEmail);

        ConnectionRequest request = new ConnectionRequest();
        request.setSenderEmail(senderEmail);
        request.setSenderName(sender.getUsername());
        request.setReceiverEmail(receiverEmail);
        request.setStatus(ConnectionRequestStatus.PENDING);
        request.setCreatedAt(LocalDateTime.now());

        return connectionRequestRepository.save(request);
    }

   
    public ConnectionRequest handleConnectionRequest(Long requestId, String status) {
        ConnectionRequest request = connectionRequestRepository.findById(requestId).get();
           

        request.setStatus(ConnectionRequestStatus.valueOf(status));

        // If accepted, you might want to add logic to create a connection/relationship
        if ("ACCEPTED".equals(status)) {
            // Create connection in your connections table
            createConnection(request.getSenderEmail(), request.getReceiverEmail());
        }

        return connectionRequestRepository.save(request);
    }

    private void createConnection(String email, String email1) {
        try {
            // Check if connection already exists
            boolean connectionExists = connectionRepository.existsByEmailAndEmail1(email, email1);
            if (connectionExists) {
                System.out.println("Connection already exists between " + email + " and " + email1);
                return;
            }

            // Create a new connection entity
            Connection connection = new Connection();
            connection.setEmail(email);
            connection.setEmail1(email1);
            connection.setCreatedAt(new Date());

            // Save the connection entity
            connectionRepository.save(connection);
            System.out.println("Connection successfully created between " + email + " and " + email1);
        } catch (Exception e) {
            System.err.println("Error creating connection: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public List<ConnectionRequest> getConnectionRequests(String email) {
        return connectionRequestRepository
            .findByReceiverEmailAndStatus(email, ConnectionRequestStatus.PENDING);
    }


	public ConnectionRequest createConnectionRequest(ConnectionRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
