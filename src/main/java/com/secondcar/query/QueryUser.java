package com.secondcar.query;

import java.util.List;

import com.secondcar.bean.User;
import com.secondcar.comm.BeanFactoryUtil;
import com.secondcar.comm.ResultInfo;
import com.secondcar.dao.UserDao;

public class QueryUser {

	public ResultInfo checkEmail(String email){
		ResultInfo ret= new ResultInfo();
		UserDao userDao = (UserDao)BeanFactoryUtil.getBean("userDao");
		List<User> userList = null;
		userList=userDao.queryUserByEmail(email);
		if(null!=userList && userList.size()>0){
			ret.setCode(-1);
		}else{
			ret.setCode(0);
		}
		return ret;
	}
	
}
