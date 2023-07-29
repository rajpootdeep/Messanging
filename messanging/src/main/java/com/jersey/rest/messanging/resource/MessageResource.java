package com.jersey.rest.messanging.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.jersey.rest.messanging.model.Message;
import com.jersey.rest.messanging.service.MessageService;

@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService service = new MessageService();

//	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") int id) {
		return service.getMessage(id);
	}

//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Message createMessage(Message message) { // request body....
//		return service.setMessages(message);
//	}

	//

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMessage(Message message, @Context UriInfo info) { // request body....

		Message newMessage = service.setMessages(message);
		Response response = Response.status(Status.CREATED).header("Base URI", info.getBaseUri()).entity(newMessage)
				.build();
		return response;
	}

//	@DELETE
//	@Path("/{messageId}")
//	public Message deleteMessage(@PathParam("messageId") int id) {
//		return service.deleteMessage(id);
//	}

	//
	@DELETE
	@Path("/{messageId}")
	public Response deleteMessage(@PathParam("messageId") int id) {

		Message deletedMessage = service.deleteMessage(id);
		if (deletedMessage == null)

			return Response.status(Status.NOT_FOUND).header("status", "Not Found !!!").build();
		return Response.status(Status.OK).entity(deletedMessage).header("status", "Messages Found and Deleted...")
				.build();
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMsg(@PathParam("messageId") int id, Message message) {

		message.setId(id);
		return service.updateMessage(message);
	}

	@GET
	public List<Message> getAllPMsg(@QueryParam("start") int start, @QueryParam("size") int size) {
		if (start >= 0 && size > 0) {
			return service.getAllMessagePaginated(start, size);
		}
		return service.getAllMessages();
	}
}
