package com.test;
import org.junit.Test;

import com.gotprint.domain.hibernate.Note;
import com.gotprint.service.NotesService;

public class HibernateTest {

	@Test
	public void test() {

		NotesService ns = new NotesService();
		Note note = new Note();
		note.setTitle("test");
		System.out.println(ns.findAllNotes());

	}

}