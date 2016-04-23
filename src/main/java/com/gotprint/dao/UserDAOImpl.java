package com.gotprint.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class UserDAOImpl<User> extends BaseDAOImpl<User> implements
		UserDAO<User> {

	public UserDAOImpl() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		List<User> Users = null;
		try {
			startTransation();
			Users = session.createCriteria(
					com.gotprint.domain.hibernate.User.class).list();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			endTransation();
		}

		return Users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User find(Class<User> clazz, Long id) {
		return (User) getSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findUserByName(String email) {
		List<User> users = null;
		try {
			startTransation();
			users = session
					.createCriteria(com.gotprint.domain.hibernate.User.class)
					.add(Restrictions.eq("email", email)).list();
			if (users != null && users.size() > 0)
				return users.get(0);
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			endTransation();
		}

		return null;
	}

}
