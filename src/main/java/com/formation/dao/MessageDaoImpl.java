package com.formation.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.formation.entity.Message;

@Repository
public class MessageDaoImpl implements MessageDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public void save(Message message) {
		em.persist(message);

	}

	// @Override
	// public List<Message> findAllMessages() {
	// TypedQuery<Message> query = em.createQuery("SELECT m FROM Message m ",
	// Message.class);
	// ArrayList<Message> messages = (ArrayList<Message>) query.getResultList();
	// return messages;
	// }
	//
	// @Override
	// public List<Message> findMessages(String user) {
	// TypedQuery<Message> query = em.createQuery("SELECT m FROM Message m WHERE
	// m.fromUser=:user ", Message.class);
	// query.setParameter("user", user);
	// ArrayList<Message> messages = (ArrayList<Message>) query.getResultList();
	// return messages;
	//
	// }
	//
	// @Override
	// public List<Message> findMessagesThisDay(String user, LocalDate day) {
	// TypedQuery<Message> query = em.createQuery(
	// "SELECT m FROM Message m WHERE m.fromUser=:user and
	// m.eventTime=:eventTime ", Message.class);
	// query.setParameter("user", user);
	// query.setParameter("day", day);
	// ArrayList<Message> messages = (ArrayList<Message>) query.getResultList();
	// return messages;
	// }

	@Override
	public void delete(String user, String toUser) {
		Query query = em.createQuery("DELETE FROM Message m WHERE m.fromUser=:user and m.toUser=:toUser");
		query.setParameter("user", user);
		query.setParameter("toUser", toUser);
	}

	@Override
	public void modify(Message oldMessage, String newContent, LocalDate newEventTime) {
		// Select sur message
		TypedQuery<Message> query = em.createQuery(
				"SELECT m FROM Message m WHERE m.fromUser=:fromUser and m.eventTime=:eventTime and m.toUser=:toUser ",
				Message.class);
		query.setParameter("fromUser", oldMessage.getFromUser());
		query.setParameter("eventTime", oldMessage.getEventTime());
		query.setParameter("toUser", oldMessage.getToUser());
		List<Message> messages = (List<Message>) query.getResultList();

		if (messages != null) {
			Message msg = messages.get(0);
			msg.setContent(newContent);
			msg.setEventTime(newEventTime);

			em.merge(msg);
		}

	}

}
