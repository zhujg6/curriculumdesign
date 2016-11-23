package com.secondcar.dao;

import java.util.List;

import com.secondcar.bean.User;

public interface UserDao {

	/**
	 * ����û���¼
	 * @param user
	 * @return
	 */
	public User checkLogin(User user);
	/**
	 * �û�ע��
	 * @param user
	 * @return 
	 */
	public int addUser(User user);
	/**
	 * ���������ѯ�û���Ϣ
	 * @param email
	 * @return
	 */
	
	public List<User> queryUserByEmail(String email);
	
}
