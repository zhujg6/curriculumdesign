package com.secondcar.dao;

import com.secondcar.bean.User;

public interface UserDao {

	/**
	 * ����û���¼
	 * @param user
	 * @return
	 */
	public User checkLogin(User user);
	
}
