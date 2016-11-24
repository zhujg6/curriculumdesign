package com.secondcar.servicesImpl;




import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.secondcar.bean.User;
import com.secondcar.comm.BeanFactoryUtil;
import com.secondcar.comm.ResultInfo;
import com.secondcar.dao.UserDao;
import com.secondcar.query.QueryUser;
import com.secondcar.services.UserService;

public class UserServiceImpl implements UserService {

	
	private static Log logger = LogFactory.getLog(UserServiceImpl.class);
	
	private static UserDao userDao = (UserDao) BeanFactoryUtil.getBean("userDao");
	
	public ResultInfo addUser(User user) {
		ResultInfo ret = new ResultInfo();
		QueryUser qu = new QueryUser();
		if(null!=user){
			//判断邮箱是否已被使用
			if(	-1 != qu.checkEmail(user.getEmail()).getCode() ){
				ret.setCode(0);
				ret.setInfo("注册成功");
			}
			else{
				ret.setCode(-1);
				ret.setInfo("该邮箱已经被注册");
			}
			//判断用户姓名是否为空
			
		}
		else{
			ret.setCode(-1);
			ret.setInfo("注册失败,缺少对象");
		}
		return ret;
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

	public static void main(String[] args) {
//		UserServiceImpl usi = new UserServiceImpl();
//		User user = new User();
//		user.setEmail("123@qq.com");
//		user.setPassword("12321313");
//		ResultInfo ret =usi.addUser(user);
//		logger.info(ret.getInfo());
	}
}
