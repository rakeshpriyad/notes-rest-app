package com.gotprint.dao;

import java.util.List;

import org.hibernate.HibernateException;

public class NotesDAOImpl<Note> extends BaseDAOImpl<Note> implements
		NotesDAO<Note> {

	public NotesDAOImpl() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Note> findAllNotes() {
		List<Note> notes = null;
		try {
			startTransation();
			notes = session.createCriteria(com.gotprint.domain.hibernate.Note.class).list();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			endTransation();
		}

		return notes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Note find(Class<Note> clazz, Long id) {
		Note note=null;
		try {
			startTransation();

			note=(Note) getSession().get(clazz, id);
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			endTransation();
		}
		return note;
	}

}
