package com.secondcar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.secondcar.bean.User;

public interface UserDao {

	/**
	 * 检测用户登录
	 * @param user
	 * @return
	 */
	public User checkLogin(User user);
	/**
	 * 用户注册
	 * @param user
	 * @return 
	 */
	public int addUser(User user);
	/**
	 * 根据邮箱查询用户信息
	 * @param email
	 * @return
	 */
	
	public List<User> queryUserByEmail(String email);
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
}
