package com.ws.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ChatMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int senderMobileNumber;
	private int recipientMobileNumber;
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "ChatMessage{" + "senderMobileNumber='" + senderMobileNumber + '\'' + ", recipientMobileNumber='"
				+ recipientMobileNumber + '\'' + ", content='" + content + '\'' + '}';
	}
}
