package com.formation.servlet.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.model.MessageDto;
import com.formation.service.MessageService;

@RestController
@RequestMapping("/admin")
public class AdminRestController {
	@Autowired
	MessageService serv;

	@RequestMapping(value = "/messages", produces = { "application/JSON" }, method = RequestMethod.GET)
	public List<MessageDto> listMessage() {
		return serv.findAllMessages();

	}

}
