package com.gotprint.service;

import java.io.Serializable;
import java.util.List;

import com.gotprint.dao.NotesDAO;
import com.gotprint.dao.NotesDAOImpl;
import com.gotprint.domain.hibernate.Note;

public class NotesService {

	private NotesDAO<Note> notesDao;

	public NotesService() {
		notesDao = new NotesDAOImpl<Note>();
	}

	public List<Note> findAllNotes() {
		return notesDao.findAllNotes();
	}

	public void update(Note note) {
		notesDao.update(note);
	}

	public Boolean delete(Note note) {
		return notesDao.delete(note);
	}

	public Serializable save(Note note) {
		return notesDao.save(note);
	}

	public Note find(Long id) {
		return notesDao.find(Note.class, id);
	}

}
