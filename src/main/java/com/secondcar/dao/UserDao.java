package com.secondcar.dao;

import com.secondcar.bean.User;

public interface UserDao {

	/**
	 * ¼ì²âÓÃ»§µÇÂ¼
	 * @param user
	 * @return
	 */
	public User checkLogin(User user);
	
}
