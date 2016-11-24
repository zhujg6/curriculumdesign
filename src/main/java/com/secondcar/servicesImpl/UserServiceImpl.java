package com.secondcar.servicesImpl;




import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.secondcar.bean.User;
import com.secondcar.comm.BeanFactoryUtil;
import com.secondcar.comm.ResultInfo;
import com.secondcar.dao.UserDao;
import com.secondcar.services.UserService;

public class UserServiceImpl implements UserService {

	
	private static Log logger = LogFactory.getLog(UserServiceImpl.class);
	
	private static UserDao userDao = (UserDao) BeanFactoryUtil.getBean("userDao");
	
	public ResultInfo addUser(User user) {
		return null;
	}

	public ResultInfo login(User user) {
		return null;
	}

	public ResultInfo updateUserInfo(User user) {
		return null;
	}

	public ResultInfo queryUserInfo(String id) {
		return null;
	}

}
