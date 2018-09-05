package com.formation.user;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.formation.model.MessageDto;
import com.formation.service.MessageService;

/**
 * Class to make interactions with the user
 */
@Component
public class ChatConsole {

	@Autowired
	private MessageService service;
	private String currentUser;

	public void sendHelloTo(String toUser) {
		// écrit "Hello "+toUser dans le message
		this.currentUser = "toto";
		MessageDto feedback = new MessageDto(currentUser, toUser, "Hello", LocalDate.now());
		service.send(feedback);
	}

	public void sendGoodbyeTo(String toUser) {
		// écrit "Goodbye "+toUser dans le message
		this.currentUser = "toto";
		MessageDto feedback = new MessageDto(currentUser, "Goodbye", toUser, LocalDate.now());
		service.send(feedback);
	}

	public void editMessage(MessageDto content) {
		service.edit(content);

	}

	public void deleteMessageToUser(String toUser) {
		// Supprime tous les messages vers un utilisateur depuis l'utilisateur
		// courant
		currentUser = "toto";
		service.delete(this.currentUser, toUser);
	}

	public List<MessageDto> findMessageToUserToday(String toUser) {

		// Récupère tous les messages envoyés par l'utilisateur courant vers un
		// utilisateur donné, aujourd'hui
		return service.findAllMessageFromUser(toUser);
	}

	public List<MessageDto> findMessageSendToAUserADay(String user, LocalDate day) {
		return service.findMessageSendToAUserADay(user, day);

	}

	public List<MessageDto> findAllMessages() {
		return service.findAllMessages();

	}
}