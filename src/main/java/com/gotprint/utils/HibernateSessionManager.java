package com.gotprint.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.gotprint.domain.hibernate.DateInterceptor;

public class HibernateSessionManager {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			//return .configure().buildSessionFactory();
			Configuration configuration = new Configuration().setInterceptor(new DateInterceptor());
	        configuration.configure();

	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	        return configuration.buildSessionFactory(serviceRegistry);

		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}