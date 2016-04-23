package com.gotprint.dao;

import java.util.List;

public interface NotesDAO<Note> extends BaseDAO<Note> {

	public List<Note> findAllNotes();

	public Note find(Class<Note> class1, Long id);

}
