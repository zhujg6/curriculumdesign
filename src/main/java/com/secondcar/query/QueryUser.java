package com.secondcar.query;

import java.util.List;

import com.secondcar.bean.User;
import com.secondcar.comm.BeanFactoryUtil;
import com.secondcar.comm.ResultInfo;
import com.secondcar.dao.UserDao;

public class QueryUser {

	public ResultInfo checkEmail(String email){
		ResultInfo ret = new ResultInfo();
		if(""!= email && null!=email){
			
			UserDao userDao = (UserDao)BeanFactoryUtil.getBean("userDao");
			List<User> userList = null;
			userList=userDao.queryUserByEmail(email);
			if(null==userList && 0==userList.size()){
				ret.setCode(0);
			}else{
				ret.setCode(-1);
			}
		}
			else{
			ret.setCode(-1);
			}
			return ret;
	}
	
}
