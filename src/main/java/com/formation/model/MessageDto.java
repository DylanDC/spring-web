package com.formation.model;

import java.time.LocalDate;

public class MessageDto {

	String fromUser;

	String toUser;

	String content;

	LocalDate eventTime;

	@Override
	public String toString() {
		return "Message [ fromUser=" + fromUser + ", toUser=" + toUser + ", message=" + content + ", eventTime="
				+ eventTime + "]";
	}

	public MessageDto(String fromUser, String toUser, String content, LocalDate eventTime) {
		super();

		this.fromUser = fromUser;
		this.toUser = toUser;
		this.content = content;
		this.eventTime = eventTime;
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