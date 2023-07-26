package com.jersey.rest.messanging.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jersey.rest.messanging.model.Message;
import com.jersey.rest.messanging.repository.MessageRepository;

public class MessageService {

	private Map<Integer, Message> message = MessageRepository.getMessage();
	// private Map<Integer, Message> message = new LinkedHashMap<Integer,
	// Message>();
	// CRUD

	public MessageService() {
		message.put(1, new Message(1, "Hello jersey", "Deep"));
		message.put(2, new Message(2, "Hello JAX-RS", "Deep"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(message.values());
	}

	public Message getMessage(int id) {
		return message.get(id);
	}

	public Message setMessages(Message messages) {

		messages.setId(message.size() + 1);
		message.put(messages.getId(), messages);
		return messages;
	}

	public Message deleteMessage(int id) {

		return message.remove(id);
	}

	public Message updateMessage(Message messages) {

		return message.put(messages.getId(), messages);
	}

}
