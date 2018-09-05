package com.formation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

	public List<Message> findByfromUser(String toUser);

	public List<Message> findByfromUserAndEventTimeBetween(String fromUser, LocalDate earlyDateTime,
			LocalDate endDateTime);
}
