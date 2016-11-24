package com.secondcar.services;

import com.secondcar.bean.User;
import com.secondcar.comm.ResultInfo;

public interface UserService {

	/**
	 * ע���û�
	 * @param user
	 * @return
	 */
	public ResultInfo insertUser(User user);
	/**
	 * �û���¼
	 * @param user
	 * @return
	 */
	public ResultInfo login(User user);
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return
	 */
	public ResultInfo updateUserInfo(User user);
	/**
	 * ��ѯ�û���Ϣ
	 */
	public ResultInfo queryUserInfo(String id);
	
}