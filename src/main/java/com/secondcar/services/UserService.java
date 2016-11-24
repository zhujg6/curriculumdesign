package com.secondcar.services;

import com.secondcar.bean.User;
import com.secondcar.comm.ResultInfo;

public interface UserService {

	/**
	 * ע���û�
	 * @param user
	 * @return
	 */
	public ResultInfo addUser(User user);
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
	 * @param id
	 * @return
	 */
	public ResultInfo queryUserInfoById(String id);
	
}
