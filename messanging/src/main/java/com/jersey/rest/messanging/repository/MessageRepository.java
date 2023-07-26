package com.jersey.rest.messanging.repository;

import java.util.LinkedHashMap;
import java.util.Map;

import com.jersey.rest.messanging.model.Message;

public class MessageRepository {
	private static Map<Integer, Message> messages = new LinkedHashMap<Integer, Message>();

	public static Map<Integer, Message> getMessage() {
		return messages;

	}

	public static void setMessages(Map<Integer, Message> messages) {
		MessageRepository.messages = messages;
	}
}
