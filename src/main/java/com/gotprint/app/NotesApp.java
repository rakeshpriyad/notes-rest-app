package com.gotprint.app;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

import com.gotprint.app.provider.AuthenticationFilter;
import com.gotprint.app.provider.GsonMessageBodyHandler;

public class NotesApp extends ResourceConfig{
	
	public NotesApp() {
		packages("com.gotprint");
		register(LoggingFilter.class);
		register(GsonMessageBodyHandler.class);
		register(AuthenticationFilter.class);

	}

}
