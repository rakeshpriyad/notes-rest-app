package com.gotprint.dao;

import java.util.List;

public interface UserDAO<User> extends BaseDAO<User> {

	public List<User> findAllUsers();

	public User find(Class<User> clazz, Long id);

	public User findUserByName(String userName);

}
