package com.Mentorship_app.Entity;

public class ConnectionRequestDTO {
	private String SenderEmail;
	private String RecieverEmail;
	public String getSenderEmail() {
		return SenderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		SenderEmail = senderEmail;
	}
	public String getRecieverEmail() {
		return RecieverEmail;
	}
	public void setRecieverEmail(String recieverEmail) {
		RecieverEmail = recieverEmail;
	}
	
}
