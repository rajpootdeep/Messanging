package com.jersey.rest.messanging.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jersey.rest.messanging.model.Comment;
import com.jersey.rest.messanging.service.CommentService;

@Path("comments") // /message/{messageId}/comments
public class CommentResource { // /messages/{meesageId}

//	@GET
//	@Path("comments")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String test(@PathParam("messageId") int messageId) {
//		return "TEst" + messageId;
//	}

	CommentService commentService = new CommentService();

	@GET
	@Path("comments")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getComments(@PathParam("messageId") int messageId) {

		return commentService.getAllComments(messageId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("comments")
	public Comment createComment(@PathParam("messageId") int messageId, Comment comment) {

		return commentService.addComment(messageId, comment);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("comments/{commentId}")
	public Comment deleteComment(@PathParam("messageId") int messageId, @PathParam("commentId") int commentId) {

		return commentService.deleteComment(messageId, commentId);
	}
}
