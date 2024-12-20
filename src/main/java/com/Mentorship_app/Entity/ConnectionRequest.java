package com.Mentorship_app.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ConnectionRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String senderEmail;
    private String receiverEmail;
    private String senderName;
    private ConnectionRequestStatus status;
    private LocalDateTime createdAt;
    
    // Enum for request status
    public enum ConnectionRequestStatus {
        PENDING,
        ACCEPTED,
        DECLINED
    }
    public ConnectionRequest() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getReceiverEmail() {
		return receiverEmail;
	}

	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public ConnectionRequestStatus getStatus() {
		return status;
	}

	public void setStatus(ConnectionRequestStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public ConnectionRequest(Long id, String senderEmail, String receiverEmail, String senderName,
			ConnectionRequestStatus status, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.senderEmail = senderEmail;
		this.receiverEmail = receiverEmail;
		this.senderName = senderName;
		this.status = status;
		this.createdAt = createdAt;
	}
    
}