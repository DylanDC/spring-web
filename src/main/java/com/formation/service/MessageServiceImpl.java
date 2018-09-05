package com.formation.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.MessageRepository;
import com.formation.dao.MessageDao;
import com.formation.entity.Message;
import com.formation.model.MessageDto;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDao dao;

	@Autowired
	MessageRepository repo;

	@Override
	public void send(MessageDto messageDto) {
		Message message = convertMessageDtoToMessage(messageDto);
		dao.save(message);
	}

	@Override
	public void edit(MessageDto editedMsg) {
		Message oldMessage = convertMessageDtoToMessage(editedMsg);
		dao.modify(oldMessage, oldMessage.getContent(), LocalDate.now());
	}

	@Override
	public void delete(String fromUser, String toUser) {
		dao.delete(fromUser, toUser);

	}

	@Override
	public List<MessageDto> findAllMessages() {
		List<Message> messages = repo.findAll();
		// on utilise un stream pour ensuite convertir chaque message en message
		// dto
		return messages.stream().map(e -> {
			return convertMessageToMessageDto(e);
		}).collect(Collectors.toList());
	}

	@Override
	public List<MessageDto> findMessageSendToAUserADay(String user, LocalDate day) {

		List<Message> messages = repo.findByfromUserAndEventTimeBetween(user, day, LocalDate.now());
		// on utilise un stream pour ensuite convertir chaque message en message
		// dto
		return messages.stream().map(e -> {
			return convertMessageToMessageDto(e);
		}).collect(Collectors.toList());
	}

	@Override
	public List<MessageDto> findAllMessageFromUser(String toUser) {
		List<Message> messages = repo.findByfromUser(toUser);
		// on utilise un stream pour ensuite convertir chaque message en message
		// dto
		return messages.stream().map(e -> {
			return convertMessageToMessageDto(e);
		}).collect(Collectors.toList());

		// String sql = "SELECT * FROM message where user = ?";
		//
		// List<Message> findAllFromUser = jdbcTemplate.query(sql, new
		// BeanPropertyRowMapper<Message>(Message.class),
		// user);
		//
		// return findAllFromUser;
	}

	private MessageDto convertMessageToMessageDto(Message message) {
		// Conversion d'un <Type>=>MessageDto en <Type>=>Message
		String convertedToUser = message.getToUser();
		String convertedFromUser = message.getFromUser();
		String convertedContent = message.getContent();
		LocalDate convertedEventTime = message.getEventTime();
		MessageDto convertedMessageDto = new MessageDto(convertedFromUser, convertedToUser, convertedContent,
				convertedEventTime);
		return convertedMessageDto;
	}

	private Message convertMessageDtoToMessage(MessageDto message) {
		// Conversion d'un <Type>=>Message en <Type>=>MessageDto
		String convertedToUser = message.getToUser();
		String convertedFromUser = message.getFromUser();
		String convertedContent = message.getContent();
		LocalDate convertedEventTime = message.getEventTime();
		Message convertedMessage = new Message(convertedFromUser, convertedToUser, convertedContent,
				convertedEventTime);
		return convertedMessage;

	}

}