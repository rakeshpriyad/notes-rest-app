package com.gotprint.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.gotprint.utils.HibernateSessionManager;

public class BaseDAOImpl<T> implements BaseDAO<T> {
	protected Session session;

	protected Class<T> type;
	
	protected org.hibernate.Transaction tx;

	public BaseDAOImpl() {
	}

	public BaseDAOImpl(Class<T> type) {
		this.type = type;
	}

	public void startTransation(){
		session = HibernateSessionManager.getSessionFactory().openSession();
		session.beginTransaction();
		tx=session.getTransaction();
	}
	
	public void endTransation(){
		try {
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		session.close();
	}
	
	public Session getSession() {
		return this.session;
	}

	public void update(T o) {
		try {
			startTransation();
			getSession().update(o);
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			endTransation();
		}

	}

	@Override
	public Boolean delete(T entity) {
		
		try {
			startTransation();
			getSession().delete(entity);
		} catch (HibernateException e) {
			handleException(e);
			return false;
		} finally {
			endTransation();
		}
		
		return true;
	}

	

	@Override
	public Serializable save(T entity) {
		Serializable s=null;
		try {
			startTransation();
			s= getSession().save(entity);
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			endTransation();
		}
		return s;

	}

	@SuppressWarnings("unchecked")
	public T find(Long id) {
		return (T) getSession().get(type, id);
	}
	
	protected void handleException(HibernateException e) throws HibernateException {
        try {
			tx.rollback();
		} catch (IllegalStateException e1) {
			//ignore
		}
        throw new HibernateException(e);
    }

}
