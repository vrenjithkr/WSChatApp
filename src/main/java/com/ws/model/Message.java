package com.ws.model;

public class Message {
	private int senderMobileNumber;
	private int recipientMobileNumber;
	private String content;

	public int getSenderMobileNumber() {
		return senderMobileNumber;
	}

	public void setSenderMobileNumber(int senderMobileNumber) {
		this.senderMobileNumber = senderMobileNumber;
	}

	public int getRecipientMobileNumber() {
		return recipientMobileNumber;
	}

	public void setRecipientMobileNumber(int recipientMobileNumber) {
		this.recipientMobileNumber = recipientMobileNumber;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	// getters and setters
}
