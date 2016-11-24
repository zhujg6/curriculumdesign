package com.secondcar.services;

import com.secondcar.bean.User;
import com.secondcar.comm.ResultInfo;

public interface UserService {

	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public ResultInfo addUser(User user);
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public ResultInfo login(User user);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public ResultInfo updateUserInfo(User user);
	/**
	 * 查询用户信息
	 * @param id
	 * @return
	 */
	public ResultInfo queryUserInfoById(String id);
	
}
