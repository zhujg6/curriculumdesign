package com.secondcar.servicesImpl;




import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.secondcar.bean.User;
import com.secondcar.comm.BeanFactoryUtil;
import com.secondcar.comm.ResultInfo;
import com.secondcar.dao.UserDao;
import com.secondcar.mail.InitMail;
import com.secondcar.mail.Mail;
import com.secondcar.mail.MailUtil;
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
		ResultInfo ret = new ResultInfo();
		if(user != null){
			if(user.getEmail()!=null && user.getEmail()!=""){
				if(user.getPassword()!=null && user.getPassword()!=""){
					User newuser =userDao.checkLogin(user);
					if(newuser!=null){
						ret.setCode(0);
						ret.setObj(newuser);
						Mail mail = InitMail.init(newuser.getEmail());
						MailUtil.send(mail);
					}else{
						ret.setCode(-1);
						ret.setInfo("登录失败！");
					}
				}else{
					ret.setCode(-1);
					ret.setInfo("登录密码不能为空！");
					logger.info("登录密码不能为空！");
				}
			}else{
				ret.setCode(-1);
				ret.setInfo("登录邮箱不能为空！");
			}
		}else{
			ret.setCode(-1);
			ret.setInfo("登录用户不能为空！");
		}
		return ret;
	}

	public ResultInfo updateUserInfo(User user) {
		return null;
	}

	public ResultInfo queryUserInfo(String id) {
		return null;
	}
	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		User user = new User();
		user.setEmail("915018368@qq.com");
		user.setPassword("");
		userService.login(user);
	}
}
