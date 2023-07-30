package com.jersey.rest.messanging.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jersey.rest.messanging.model.Comment;
import com.jersey.rest.messanging.model.Message;
import com.jersey.rest.messanging.repository.MessageRepository;

public class CommentService {

	private Map<Integer, Message> messages = MessageRepository.getMessage();

	public List<Comment> getAllComments(int messageId) {

		Map<Integer, Comment> comments = messages.get(messageId).getComments();

		return new ArrayList<Comment>(comments.values());
	}

	public Comment addComment(int messageId, Comment comment) {

		Map<Integer, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);

		return comment;
	}

	public Comment deleteComment(int messageId, int commentId) {

		Map<Integer, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);

	}
}
