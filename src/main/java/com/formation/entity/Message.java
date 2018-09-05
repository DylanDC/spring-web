package com.formation.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {
	@Id
	@Column(name = "ID")
	int id;
	@Column(name = "FROMUSER")
	String fromUser;
	@Column(name = "TOUSER")
	String toUser;
	@Column(name = "CONTENT")
	String content;
	@Column(name = "EVENT_TIME")
	LocalDate eventTime;

	@Override
	public String toString() {
		return "Message [  fromUser=" + fromUser + ", toUser=" + toUser + ", message=" + content + ", eventTime="
				+ eventTime + "]";
	}

	public Message() {
		super();
	}

	public Message(String fromUser, String toUser, String content, LocalDate eventTime) {
		super();

		this.fromUser = fromUser;
		this.toUser = toUser;
		this.content = content;
		this.eventTime = eventTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalDate timestamp) {
		this.eventTime = timestamp;
	}

}