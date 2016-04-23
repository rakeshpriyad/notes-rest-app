package com.gotprint.service;

import java.io.Serializable;
import java.util.List;

import com.gotprint.dao.UserDAO;
import com.gotprint.dao.UserDAOImpl;
import com.gotprint.domain.hibernate.User;

public class UserService {

	private UserDAO<User> usersDao;

	public UserService() {
		usersDao = new UserDAOImpl<User>();
	}

	public List<User> findAllUsers() {
		return usersDao.findAllUsers();
	}

	public void update(User User) {
		usersDao.update(User);
	}

	public Boolean delete(User User) {
		return usersDao.delete(User);
	}

	public Serializable save(User User) {
		return usersDao.save(User);
	}

	public User find(Long id) {
		return usersDao.find(User.class, id);
	}
	
	public User findUserByEmail(String email) {
		return usersDao.findUserByName(email);
	}

}
