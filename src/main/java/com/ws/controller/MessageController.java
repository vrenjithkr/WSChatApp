package com.ws.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws.entity.ChatMessage;
import com.ws.model.Person;
import com.ws.service.ChatMessageService;
import com.ws.service.PersonService;

@RestController
@RequestMapping("/app")
public class MessageController {
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	@Autowired
	private PersonService personService;

	@Autowired
	 private ChatMessageService chatMessageService;

	@PostMapping("/register")
	public ResponseEntity<String> registerPerson(@RequestBody int mobileNumber) {
		Person person = personService.registerPerson(mobileNumber);
		return ResponseEntity.ok("Person registered successfully with ID: " + person.getId());
	}

	@GetMapping("/users")
	public List<Person> getAllUsers() {
		return personService.getAllPersons();
	}

    @PostMapping("/send")
    @MessageMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody ChatMessage chatMessage) {
        System.out.println("Received message: " + chatMessage);
        Optional<Person> recipient = personService.findByMobileNumber(chatMessage.getRecipientMobileNumber());
        if (recipient.isPresent()) {
            int recipientId = recipient.get().getMobileNumber();
            messagingTemplate.convertAndSend("/topic/messages/" + recipientId, chatMessage);
            chatMessageService.saveMessage(chatMessage); // Save the message to the database
            System.out.println("Message sent to: " + recipientId + " | Message: " + chatMessage);
            return ResponseEntity.ok("Message sent and saved successfully");
        } else {
            System.out.println("Recipient not found: " + chatMessage.getRecipientMobileNumber());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recipient not found");
        }
    }
}
