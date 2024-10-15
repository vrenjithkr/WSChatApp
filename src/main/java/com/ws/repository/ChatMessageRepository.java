package com.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ws.entity.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
