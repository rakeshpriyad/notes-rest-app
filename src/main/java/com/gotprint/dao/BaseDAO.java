package com.gotprint.dao;

import java.io.Serializable;


public  interface BaseDAO<T> {
	
    public Boolean delete(T entity);
    public void update(T entity);
	public Serializable save(T entity);
	
}
