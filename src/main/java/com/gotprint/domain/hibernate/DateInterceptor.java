package com.gotprint.domain.hibernate;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

/**
 * 
 * @author rakesh
 * 
 */
public class DateInterceptor extends EmptyInterceptor {

	private static final String CREATE_TIME = "createTime";
	private static final String LAST_UPDATE_TIME = "lastUpdateTime";
	/** **/
	private static final long serialVersionUID = -6414179441704055574L;

	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		if (entity instanceof Note) {
			int indexOfLastUpdate=findIndex(propertyNames,LAST_UPDATE_TIME);
			currentState[indexOfLastUpdate] = new Date();
			return true;
		}
		return false;
	}

	private int findIndex(String[] propertyNames, String propertyName) {
		int index = -1;
		for (int i = 0; i < propertyNames.length; i++) {
			if (propertyNames[i].equals(propertyName)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		if (entity instanceof Note) {
			int indexOfLastUpdate=findIndex(propertyNames,LAST_UPDATE_TIME);
			int indexOfCreateTime=findIndex(propertyNames,CREATE_TIME);
			if(indexOfLastUpdate>=0){
				state[indexOfLastUpdate] = new Date();
			}
			if(indexOfCreateTime>=0){
				state[indexOfCreateTime] = new Date();
			}
			return true;
		}
		return false;
	}
}
