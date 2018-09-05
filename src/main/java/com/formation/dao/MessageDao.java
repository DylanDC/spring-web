package com.formation.dao;

import java.time.LocalDate;

import com.formation.entity.Message;

public interface MessageDao {
	public void save(Message message);

	public void delete(String user, String toUser);

	public void modify(Message oldMessage, String newContent, LocalDate newEventTime);
}
