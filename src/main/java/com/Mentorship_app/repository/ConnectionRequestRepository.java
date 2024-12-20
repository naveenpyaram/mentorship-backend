package com.Mentorship_app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mentorship_app.Entity.ConnectionRequest;
import com.Mentorship_app.Entity.ConnectionRequest.ConnectionRequestStatus;

@Repository
public interface ConnectionRequestRepository extends JpaRepository<ConnectionRequest, Long> {
    List<ConnectionRequest> findByReceiverEmailAndStatus(String email, ConnectionRequestStatus status);

	Optional<ConnectionRequest> findBySenderEmailAndReceiverEmailAndStatus(String senderEmail, String receiverEmail,
			ConnectionRequestStatus pending);
}

