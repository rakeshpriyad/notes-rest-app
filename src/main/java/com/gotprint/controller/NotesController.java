package com.gotprint.controller;

import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gotprint.domain.hibernate.Note;
import com.gotprint.domain.hibernate.User;
import com.gotprint.service.NotesService;
import com.gotprint.service.UserService;

@Path("/notes")
public class NotesController {

	private NotesService notesService=new NotesService();
	
	public NotesController(){
		//just to ensure user is entered into DB when this controller is used
		String email="admin@gmail.com";
		String password="password";
		
		UserService userService=new UserService();
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		
		User foundUser=userService.findUserByEmail(email);
		if(foundUser==null){
			userService.save(user);
		}
	}
	
	@RolesAllowed("ADMIN")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Note> getAllNotes() {
		return notesService.findAllNotes();
	}

	@RolesAllowed("ADMIN")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response addNote(Note note) throws URISyntaxException {
		if (note == null) {
			return Response.status(400).entity("Please add Notes details !!")
					.build();
		}

		if (note.getTitle() == null) {
			return Response.status(400)
					.entity("Please provide the Notes title !!").build();
		}
		notesService.save(note);
		GenericEntity<Note> entity = new GenericEntity<Note>(note, Note.class);
		return Response.ok().entity(entity).build();
	}

	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response findNoteById(@PathParam("id") Long id) {
		Note note=notesService.find(id);

		if(note==null){
			Response.status(202).entity("Note not found !!")
			.build();
		}
		return Response.ok().entity(note).build();
	}
	
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateNoteById(@PathParam("id") Long id, Note note) {
		Note updatedNote = notesService.find(id);

		updatedNote.setId(id);
		if (note.getTitle() == null) {
			return Response.status(400)
					.entity("Please provide the Note name !!").build();
		}

		updatedNote.setTitle(note.getTitle());
		updatedNote.setNote(note.getNote());
		notesService.update(updatedNote);

		return Response.ok().entity(updatedNote).build();
	}

	@DELETE
	@Path("/delete/{id}")
	public Response deleteNoteById(@PathParam("id") Long id) {
		Note deleteNote = new Note();
		deleteNote.setId(id);
		Boolean deleted=notesService.delete(deleteNote);
		if(deleted){
			return Response.ok().entity(deleteNote).build();
		}
		return Response.status(202).entity("Note deleted successfully !!")
				.build();
	}
	
	
}
